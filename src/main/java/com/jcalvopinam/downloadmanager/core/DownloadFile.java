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

package com.jcalvopinam.downloadmanager.core;

import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Optional;

import com.jcalvopinam.downloadmanager.domain.File;
import com.jcalvopinam.downloadmanager.utils.Commons;
import com.jcalvopinam.downloadmanager.utils.Constants;

/**
 * @author Juan Calvopina
 */
public class DownloadFile implements Runnable {

    private final String saveAs;
    private File file;

    public DownloadFile(File file, String saveAs) {
        this.file = file;
        this.saveAs = Optional.of(saveAs).orElse(Constants.OUTPUT_FOLDER);
    }

    @Override
    public void run() {
        long threadId = Thread.currentThread().getId();
        downloadFile(file, saveAs, threadId);
    }

    private void downloadFile(File file, String saveAs, long threadId) {
        try {
            URL url = new URL(file.getFileUrl());
            ReadableByteChannel rbc = Channels.newChannel(url.openStream());

            long currentTime = System.currentTimeMillis();

            FileOutputStream fos = new FileOutputStream(saveAs + currentTime + "_" + file.getFileName());
            fos.getChannel().transferFrom(rbc, Constants.MIN_INDEX, Long.MAX_VALUE);

            System.out.println(" [" + threadId + "]" +
                                       "\t[" + Commons.leftPad(file.getPriority()) + "]" +
                                       "\t[✓] Downloaded! " + file.getFileUrl());

        } catch (Exception e) {
            System.err.println(" [" + threadId + "]" +
                                       "\t[" + Commons.leftPad(file.getPriority()) + "]" +
                                       "\t[x] Error! " + e.getMessage());
        }
    }

}