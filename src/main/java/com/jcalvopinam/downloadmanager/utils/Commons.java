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

import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        return String.format("%03d", value);
    }

    public static String drawLine(int number) {
        return IntStream.range(0, number).mapToObj(i -> "-").collect(Collectors.joining());
    }

    public static String drawBox(String... message) {

        StringBuilder joinMessages = new StringBuilder();

        int maxLength = 0;
        for (String aMessage : message) {
            if (aMessage.length() > maxLength) {
                maxLength = aMessage.length() + Constants.MIN_INDEX;
            }
        }

        for (int i = 0; i < message.length; i++) {
            if (i == message.length - 1) {
                joinMessages.append(formatMessage(message[i], maxLength));
            } else {
                joinMessages.append(formatMessage(message[i], maxLength))
                            .append(Constants.LINE_FEED);
            }
        }

        String drawLine = drawLine(maxLength * 2);

        return Constants.LINE_FEED + drawLine +
                Constants.LINE_FEED + joinMessages.toString() +
                Constants.LINE_FEED + drawLine +
                Constants.LINE_FEED;
    }

    private static String formatMessage(String message, int maxLength) {
        String result = Constants.PIPE + message.replace("\n", " |\n|");
        String format = "%1$-" + maxLength + "s%2$" + maxLength + "s";
        return String.format(format, result, Constants.PIPE);
    }

}
