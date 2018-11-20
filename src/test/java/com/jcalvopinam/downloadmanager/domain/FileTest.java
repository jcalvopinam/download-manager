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
import org.junit.Test;

import static com.jcalvopinam.downloadmanager.DownloadManagerApplicationTest.*;

/**
 * @author Juan Calvopina
 */
public class FileTest {

    @Test
    public void testPriorityWhenIsNotNull() {
        final String expectedFile = "File{priority=1, fileUrl='https://www.github.com/juanca87', fileName='github'}";

        final File fileNotNull = new File(PRIORITY, FILE_URL, FILE_NAME);
        final File fileNull = new File(null, null, null);

        Assert.assertNotNull(fileNotNull.getPriority());
        Assert.assertNotNull(fileNotNull.getFileUrl());
        Assert.assertNotNull(fileNotNull.getFileName());


        Assert.assertNull(fileNull.getPriority());
        Assert.assertNull(fileNull.getFileUrl());
        Assert.assertNull(fileNull.getFileName());

        Assert.assertEquals(FILE_NAME, fileNotNull.getFileName());
        Assert.assertEquals(expectedFile, fileNotNull.toString());
        Assert.assertEquals(fileNotNull, fileNotNull);

        Assert.assertNotEquals(null, fileNotNull);
    }

    @Test
    public void testSymmetrical() {
        File x = new File(PRIORITY, FILE_URL, FILE_NAME);
        File y = new File(PRIORITY, FILE_URL, FILE_NAME);

        Assert.assertEquals(x, y);
        Assert.assertEquals(y, x);
    }

    @Test
    public void testEqualsIsNull() {
        File x = new File(null, null, null);
        Assert.assertNotEquals(x, null);
    }

    @Test
    public void testTransitive() {
        File x = new File(PRIORITY, FILE_URL, FILE_NAME);
        File y = new File(PRIORITY, FILE_URL, FILE_NAME);
        File z = new File(PRIORITY, FILE_URL, FILE_NAME);

        Assert.assertEquals(x, y);
        Assert.assertEquals(y, z);
        Assert.assertEquals(x, z);
    }

    @Test
    public void testsConsistency() {
        File x = new File(PRIORITY, FILE_URL, FILE_NAME);
        File y = new File(PRIORITY, FILE_URL, FILE_NAME);

        Assert.assertEquals(x, y);
        Assert.assertEquals(x, y);
        Assert.assertEquals(x, y);
        Assert.assertEquals(x, y);
    }

    @Test
    public void testHashcode() {
        File x = new File(PRIORITY, FILE_URL, FILE_NAME);
        File y = new File(PRIORITY, FILE_URL, FILE_NAME);

        Assert.assertTrue(x.equals(y) && y.equals(x));
        Assert.assertEquals(x.hashCode(), y.hashCode());
    }

}