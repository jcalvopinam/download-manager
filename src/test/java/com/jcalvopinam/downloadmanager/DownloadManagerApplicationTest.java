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

package com.jcalvopinam.downloadmanager;

import java.util.Arrays;
import java.util.List;

import com.jcalvopinam.downloadmanager.core.Manager;
import com.jcalvopinam.downloadmanager.domain.File;
import com.jcalvopinam.downloadmanager.utils.InputData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import static org.powermock.api.mockito.PowerMockito.*;

/**
 * @author Juan Calvopina
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({InputData.class, Manager.class})
public class DownloadManagerApplicationTest {

    public static final String OUTPUT_FILE = System.getProperty("java.io.tmpdir") + java.io.File.separator;
    public static final String FILE_URL = "https://www.github.com/juanca87";
    public static final String FILE_NAME = "github";
    public static final int PRIORITY = 1;

    @Test
    public void testMainMethod() {
        String inputFile = DownloadManagerApplicationTest.class.getClassLoader().getResource("items.txt").getPath();
        String[] args = {inputFile, OUTPUT_FILE};

        PowerMockito.mockStatic(InputData.class);

        when(InputData.readFile(args[0])).thenReturn(createFileList());
        List<File> files = InputData.readFile(args[0]);

        Manager mockInstance = mock(Manager.class);
        Whitebox.setInternalState(Manager.class, "INSTANCE", mockInstance);

        PowerMockito.doNothing().when(mockInstance).download(files, "");

        DownloadManagerApplication.main(args);
    }

    private List<File> createFileList() {
        File file = new File(PRIORITY, FILE_URL, FILE_NAME);
        return Arrays.asList(file);
    }

}
