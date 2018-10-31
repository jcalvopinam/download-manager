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

package com.jcalvopinam.downloadmanager.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.jcalvopinam.downloadmanager.DownloadManagerApplicationTest.*;

/**
 * @author Juan Calvopina
 */
public class FileTest {

    private File fileNotNull;
    private File fileNull;

    @Before
    public void setUp() throws Exception {
        fileNotNull = new File(PRIORITY, FILE_URL, FILE_NAME);
        fileNull = new File(null, null, null);
    }

    @Test
    public void testPriorityWhenIsNotNull() {
        Assert.assertNotNull(fileNotNull.getPriority());
    }

    @Test
    public void testFileUrlWhenIsNotNull() {
        Assert.assertNotNull(fileNotNull.getFileUrl());
    }

    @Test
    public void testFileNameWhenIsNotNull() {
        Assert.assertNotNull(fileNotNull.getFileName());
    }

    @Test
    public void equalsWhenAreEquals() {
        String expected = FILE_NAME;
        Assert.assertEquals(expected, fileNotNull.getFileName());
    }

    @Test
    public void testPriorityWhenIsNull() {
        Assert.assertNull(fileNull.getPriority());
    }

    @Test
    public void testFileUrlWhenIsNull() {
        Assert.assertNull(fileNull.getFileUrl());
    }

    @Test
    public void testFileNameWhenIsNull() {
        Assert.assertNull(fileNull.getFileName());
    }

    @Test
    public void testToString() {
        String expected = "File{priority=1, fileUrl='https://www.github.com/juanca87', fileName='github'}";
        Assert.assertEquals(expected, fileNotNull.toString());
    }

    @Test
    public void testReflexive() {
        Assert.assertTrue(fileNotNull.equals(fileNotNull));
    }

    @Test
    public void testReflexiveIsNull() {
        Assert.assertFalse(fileNotNull.equals(null));
    }

    @Test
    public void testSymmetrical() {
        File x = new File(PRIORITY, FILE_URL, FILE_NAME);
        File y = new File(PRIORITY, FILE_URL, FILE_NAME);

        Assert.assertTrue(x.equals(y));
        Assert.assertTrue(y.equals(x));
    }

    @Test
    public void testTransitive() {
        File x = new File(PRIORITY, FILE_URL, FILE_NAME);
        File y = new File(PRIORITY, FILE_URL, FILE_NAME);
        File z = new File(PRIORITY, FILE_URL, FILE_NAME);

        Assert.assertTrue(x.equals(y));
        Assert.assertTrue(y.equals(z));
        Assert.assertTrue(x.equals(z));
    }

    @Test
    public void testsConsistency() {
        File x = new File(PRIORITY, FILE_URL, FILE_NAME);
        File y = new File(PRIORITY, FILE_URL, FILE_NAME);

        Assert.assertTrue(x.equals(y));
        Assert.assertTrue(x.equals(y));
        Assert.assertTrue(x.equals(y));
        Assert.assertTrue(x.equals(y));
    }

    @Test
    public void testHashcode() {
        File x = new File(PRIORITY, FILE_URL, FILE_NAME);
        File y = new File(PRIORITY, FILE_URL, FILE_NAME);

        Assert.assertTrue(x.equals(y) && y.equals(x));
        Assert.assertTrue(x.hashCode() == y.hashCode());
    }

}