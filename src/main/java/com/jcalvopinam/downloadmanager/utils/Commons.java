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

import java.net.URL;

/**
 * @author Juan Calvopina
 */
public class Commons {

    private static final String HTTPS = "https://";

    public static URL verifyURL(String fileURL) {
        if (!fileURL.toLowerCase().startsWith(HTTPS)) {
            System.out.println(" [x] The source (" + fileURL + ") is not a valid URL," +
                                       " this must start with HTTP or HTTPS protocol.");
            return null;
        } else {
            System.out.println(" [✓] Source found: " + fileURL);
        }

        URL verifiedUrl = null;
        try {
            verifiedUrl = new URL(fileURL);
        } catch (Exception e) {
            System.err.println("An error occurred with the URL.");
            return null;
        }

        if (verifiedUrl.getFile().length() < 2) {
            System.err.println("The URL doesn't have a specific file to download.");
            return null;
        }

        return verifiedUrl;
    }

}
