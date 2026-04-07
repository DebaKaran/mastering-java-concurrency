package com.deba.callable.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ReportServer {
    private ExecutorService service;

    public ReportServer() {
        this.service = Executors.newFixedThreadPool(4);

    }

    public Future<String> submitTask(ReportTask task) {
        return service.submit(task);
    }

    public void shutdown() {
        service.shutdown();
    }
}
