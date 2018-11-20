/*
 * MIT License
 *
 * Copyright (c) 2018. JUAN CALVOPINA M
 *
 * Permission is hereby granted, free of chargse, to any person obtaining a copy
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

package com.jcalvopinam.downloadmanager.domain;

import java.util.Objects;

import com.jcalvopinam.downloadmanager.DownloadManagerApplicationTest;
import com.jcalvopinam.downloadmanager.exception.ManagerException;
import org.junit.Assert;
import org.junit.Test;

import static com.jcalvopinam.downloadmanager.DownloadManagerApplicationTest.OUTPUT_FILE;

/**
 * @author Juan Calvopina
 */
public class FileResourceTest {

    @Test
    public void testOfNotNull() {
        Assert.assertNotNull(getFileResource());
    }

    @Test
    public void testCheckAndGetInputNotNull() {
        String input = getFileResource().checkAndGetInput();
        Assert.assertNotNull(input);
    }

    @Test
    public void testCheckAndGetOutputNotNull() {
        String output = getFileResource().checkAndGetOutput();
        Assert.assertNotNull(output);
        Assert.assertEquals(OUTPUT_FILE, output);
    }

    @Test
    public void testCheckAndGetOutputNull() {
        String inputFile = Objects.requireNonNull(
                DownloadManagerApplicationTest.class.getClassLoader().getResource("items.txt")).getPath();
        String[] args = {inputFile};
        FileResource fileResource = FileResource.of(args);
        String output = fileResource.checkAndGetOutput();
        String expected = "";
        Assert.assertNotNull(output);
        Assert.assertEquals(expected, output);
    }

    @Test(expected = ManagerException.class)
    public void testInputIsNull() {
        String[] args = {};
        FileResource.of(args);
    }

    @Test(expected = ManagerException.class)
    public void testInputNotExist() {
        String[] args = {"/any/place"};
        FileResource.of(args);
    }

    private FileResource getFileResource() {
        String inputFile = Objects.requireNonNull(
                DownloadManagerApplicationTest.class.getClassLoader().getResource("items.txt")).getPath();
        String[] args = {inputFile, OUTPUT_FILE};
        return FileResource.of(args);
    }

}