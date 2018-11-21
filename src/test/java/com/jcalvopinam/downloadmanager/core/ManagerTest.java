/*
 * MIT License
 *
 * Copyright (c) 2018. JUAN CALVOPINA M
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.jcalvopinam.downloadmanager.core;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import com.jcalvopinam.downloadmanager.domain.File;
import org.junit.Test;

import static com.jcalvopinam.downloadmanager.DownloadManagerApplicationTest.*;
import static com.jcalvopinam.downloadmanager.utils.Commons.getFileName;

/**
 * @author Juan Calvopina
 */
public class ManagerTest {

    private static final String ROBOTS_URL = "https://www.google.com/robots.txt";
    private static final String RESEARCH_URL = "http://research.google.com/publications_list.txt";
    private static final String WRONG_URL = "https://localhost.io";

    /**
     * This test only checks the invocation to the download method.
     */
    @Test
    public void testDownloadMethod() {
        List<File> files = createFileList();
        Manager.INSTANCE.download(files, OUTPUT_FILE);
    }

    @Test
    public void testDownloadMethodWhenPoolIsShutdown() {
        List<File> files = createFileList();
        Manager.INSTANCE.download(files, OUTPUT_FILE);
        Manager.INSTANCE.download(files, OUTPUT_FILE);
        Manager.INSTANCE.download(files, OUTPUT_FILE);
        Manager.INSTANCE.download(files, OUTPUT_FILE);
        Manager.INSTANCE.download(files, OUTPUT_FILE);
        Manager.INSTANCE.shutdown();
        Manager.INSTANCE.download(files, OUTPUT_FILE);
        Manager.INSTANCE.download(files, OUTPUT_FILE);
    }

    private List<File> createFileList() {
        List<File> fileList = new ArrayList<>();
        IntStream.range(0, 20)
                 .mapToObj(i -> new File(1, ROBOTS_URL, getFileName(ROBOTS_URL) + i))
                 .forEach(fileList::add);
        IntStream.range(21, 40)
                 .mapToObj(i -> new File(2, RESEARCH_URL, getFileName(FILE_NAME + i)))
                 .forEach(fileList::add);
        IntStream.range(41, 60)
                 .mapToObj(i -> new File(3, WRONG_URL, FILE_NAME + i))
                 .forEach(fileList::add);
        fileList.sort(Comparator.comparing(File::getPriority));
        return fileList;
    }

}