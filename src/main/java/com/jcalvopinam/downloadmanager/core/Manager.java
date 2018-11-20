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

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import com.jcalvopinam.downloadmanager.domain.File;
import com.jcalvopinam.downloadmanager.utils.Commons;
import com.jcalvopinam.downloadmanager.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Juan Calvopina
 */
public enum Manager {

    INSTANCE;

    private static final Logger LOGGER = LoggerFactory.getLogger(Manager.class);
    private final ExecutorService pool = Executors.newFixedThreadPool(Constants.POOL_SIZE);

    public void download(List<File> files, String saveAs) {

        LOGGER.info(":: Start downloading... ::");
        final String legend = Commons.drawBox("Total files to be downloaded: " + files.size(),
                                              "TID: Thread ID", "PID: Priority ID");
        LOGGER.info("{}", legend);
        LOGGER.info("\tTID_\tPID_\tStatus_");

        CompletableFuture<?>[] futures = files.stream()
                                              .map(file -> new DownloadFile(file, saveAs))
                                              .collect(Collectors.toList())
                                              .stream()
                                              .map(task -> CompletableFuture.runAsync(task, pool))
                                              .toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(futures).join();
        pool.shutdown();

        LOGGER.info(":: The downloads are complete! ::");

    }

}
