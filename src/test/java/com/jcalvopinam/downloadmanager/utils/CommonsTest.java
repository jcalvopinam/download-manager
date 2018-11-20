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

import org.junit.Assert;
import org.junit.Test;

import static com.jcalvopinam.downloadmanager.DownloadManagerApplicationTest.FILE_URL;

/**
 * @author Juan Calvopina
 */
public class CommonsTest {

    private int lengthExpected = 3;

    @Test
    public void testIsURLValid() {
        Assert.assertTrue(Commons.isURLValid("https://www.github.com/juanca87"));
    }

    @Test
    public void testIsURLInvalid() {
        Assert.assertFalse(Commons.isURLValid("http://"));
    }

    @Test
    public void testGetFileNameWhenIsEquals() {
        String fileName = Commons.getFileName(FILE_URL);
        String expected = "juanca87";
        Assert.assertEquals(expected, fileName);
    }

    @Test
    public void testGetFileNameWhenIsNotEquals() {
        String fileName = Commons.getFileName(FILE_URL);
        String expected = "";
        Assert.assertNotEquals(expected, fileName);
    }

    @Test
    public void testLeftPadLessThanNine() {
        int value = 7;
        int leftPad = Commons.leftPad(value).length();
        Assert.assertEquals(lengthExpected, leftPad);
    }

    @Test
    public void testLeftPadUpperThanNine() {
        int value = 19;
        int leftPad = Commons.leftPad(value).length();
        Assert.assertEquals(lengthExpected, leftPad);
    }

    @Test
    public void testDrawLine() {
        String drawLine = Commons.drawLine(5);
        String expected = "-----";
        Assert.assertEquals(expected, drawLine);
    }

    @Test
    public void testDrawBox() {
        String drawBox = Commons.drawBox(FILE_URL);
        String expected = "\n" +
                "----------------------------------------------------------------\n" +
                "|https://www.github.com/juanca87                               |\n" +
                "----------------------------------------------------------------\n";
        Assert.assertEquals(expected, drawBox);
    }

    @Test
    public void testDrawBoxSomeParameters() {
        String drawBox = Commons.drawBox("https://www.github.com/", "juanca87");
        String expected = "\n" +
                "------------------------------------------------\n" +
                "|https://www.github.com/                       |\n" +
                "|juanca87                                      |\n" +
                "------------------------------------------------\n";
        Assert.assertEquals(expected, drawBox);
    }

}