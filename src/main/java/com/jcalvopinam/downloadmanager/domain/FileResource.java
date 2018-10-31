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

import java.io.File;

import com.jcalvopinam.downloadmanager.exception.ManagerException;
import com.jcalvopinam.downloadmanager.utils.Constants;

/**
 * @author Juan Calvopina
 */
public class FileResource {

    private String input;
    private String output;

    private FileResource(String input, String output) {
        this.input = input;
        this.output = output;
    }

    public static FileResource of(String[] args) {
        return new FileResource(checkAndGetInput(args), checkAndGetOutput(args));
    }

    private static String checkAndGetInput(String[] args) {
        if (args.length < Constants.MIN_INDEX) {
            throw new ManagerException("Please enter the file path with the items to download!");
        }
        File file = new File(args[Constants.FIRST_ELEMENT]);
        if (!file.exists()) {
            throw new ManagerException("The file doesn't exist, please try again...");
        }
        return args[Constants.FIRST_ELEMENT];
    }

    private static String checkAndGetOutput(String[] arg) {
        if (arg.length < Constants.MAX_INDEX) {
            System.err.println("The output path is empty. The files will be downloaded in this directory!");
            return "";
        }
        return arg[Constants.SECOND_ELEMENT];
    }

    public String checkAndGetInput() {
        return input;
    }

    public String checkAndGetOutput() {
        return output;
    }

}
