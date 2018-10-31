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

import org.apache.commons.validator.routines.UrlValidator;

/**
 * @author Juan Calvopina
 */
public class Commons {

    private Commons() {
    }

    public static boolean isURLValid(String fileUrl) {
        UrlValidator urlValidator = new UrlValidator();
        return urlValidator.isValid(fileUrl);
    }

    public static String getFileName(String fileUrl) {
        return fileUrl.substring(fileUrl.lastIndexOf(Constants.PATH_SEPARATOR) + Constants.MIN_INDEX);
    }

    public static String leftPad(Integer value) {
        return value <= 9 ? "0" + value : String.valueOf(value);
    }

    public static String drawLine(int number) {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < number; i++) {
            line.append("-");
        }
        return line.toString();
    }

    public static String drawBox(String... message) {

        StringBuilder joinMessages = new StringBuilder();

        int maxLength = 0;
        for (int i = 0; i < message.length; i++) {
            if (message[i].length() > maxLength) {
                maxLength = message[i].length() + Constants.MIN_INDEX;
            }
        }

        for (int i = 0; i < message.length; i++) {
            if (i == message.length - 1) {
                joinMessages.append(formatMessage(message[i], maxLength));
            } else {
                joinMessages.append(formatMessage(message[i], maxLength) + Constants.LINE_FEED);
            }
        }

        String drawLine = drawLine(maxLength * 2);

        StringBuilder output = new StringBuilder();
        output.append(Constants.LINE_FEED)
              .append(drawLine)
              .append(Constants.LINE_FEED)
              .append(joinMessages.toString())
              .append(Constants.LINE_FEED)
              .append(drawLine)
              .append(Constants.LINE_FEED);
        return output.toString();
    }

    private static String formatMessage(String message, int maxLength) {
        StringBuilder messageOutput = new StringBuilder();
        messageOutput.append(Constants.PIPE)
                     .append(message.replace("\n", " |\n|"));
        String result = messageOutput.toString();
        return String.format("%1$-" + maxLength + "s%2$" + maxLength + "s", result, Constants.PIPE);
    }

}
