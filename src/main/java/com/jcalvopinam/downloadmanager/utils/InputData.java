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

package com.jcalvopinam.downloadmanager.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import com.jcalvopinam.downloadmanager.domain.File;
import com.jcalvopinam.downloadmanager.exception.ManagerException;

/**
 * @author Juan Calvopina
 */
public class InputData {

    public static List<File> readFile(String url) {
        List<File> list = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(url))) {

            stream.forEach(x -> {
                String[] item = x.split(Constants.LINE_SEPARATOR);
                if (item.length != Constants.MAX_INDEX) {
                    throw new ManagerException("The input file isn't valid!");
                }
                String fileURL = item[Constants.FILE];
                if (Commons.isURLValid(fileURL)) {
                    list.add(
                            new File(Integer.valueOf(item[Constants.PRIORITY]), fileURL, Commons.getFileName(fileURL)));
                }
            });

            list.sort(Comparator.comparing(File::getPriority));
        } catch (IOException e) {
            throw new ManagerException("An error occurred while reading the file: " + e.getMessage());
        }

        return list;
    }

}
