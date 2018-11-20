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

import java.util.Objects;

/**
 * @author Juan Calvopina
 */
public class Constants {

    public static final int PRIORITY = 0;
    public static final int FILE = 1;
    public static final int MIN_INDEX = 1;
    public static final int MAX_INDEX = 2;
    public static final int FIRST_ELEMENT = 0;
    public static final int SECOND_ELEMENT = 1;

    public static final String APPLICATION_PROPERTIES = "application";
    public static final String PATH_SEPARATOR = Objects.requireNonNull(Property.getString("path.separator"));
    public static final String LINE_SEPARATOR = Objects.requireNonNull(Property.getString("line.separator"));
    public static final String OUTPUT_FOLDER = Property.getString("output.folder");
    public static final String LINE_FEED = "\n";
    public static final String PIPE = "|";

    public static final Integer POOL_SIZE = Property.getInt("pool.size");

    private Constants() {
    }

}
