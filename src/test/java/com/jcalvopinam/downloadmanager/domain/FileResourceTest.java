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

import com.jcalvopinam.downloadmanager.DownloadManagerApplicationTest;
import com.jcalvopinam.downloadmanager.exception.ManagerException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Juan Calvopina
 */
public class FileResourceTest {

    private FileResource fileResource;

    @Before
    public void setUp() {
        String inputFile = DownloadManagerApplicationTest.class.getClassLoader().getResource("items.txt").getPath();
        String outputFile = System.getProperty("java.io.tmpdir");
        String[] argss = {inputFile, outputFile};
        fileResource = FileResource.of(argss);
    }

    @Test
    public void testOfNotNull() {
        Assert.assertNotNull(fileResource);
    }

    @Test
    public void testCheckAndGetInputNotNull() {
        String input = fileResource.checkAndGetInput();
        Assert.assertNotNull(input);
    }

    @Test
    public void testCheckAndGetOutputNotNull() {
        String output = fileResource.checkAndGetOutput();
        String expected = "/tmp";
        Assert.assertNotNull(output);
        Assert.assertEquals(expected, output);
    }

    @Test
    public void testCheckAndGetOutputNull() {
        String inputFile = DownloadManagerApplicationTest.class.getClassLoader().getResource("items.txt").getPath();
        String[] args = {inputFile};
        fileResource = FileResource.of(args);
        String output = fileResource.checkAndGetOutput();
        String expected = "";
        Assert.assertNotNull(output);
        Assert.assertEquals(expected, output);
    }

    @Test(expected = ManagerException.class)
    public void testInputIsNull() {
        String[] args = {};
        fileResource = FileResource.of(args);
    }

    @Test(expected = ManagerException.class)
    public void testInputNotExist() {
        String[] args = {"/any/place"};
        fileResource = FileResource.of(args);
    }

}