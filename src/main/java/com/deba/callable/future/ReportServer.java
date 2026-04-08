package com.deba.callable.future;

import java.util.List;
import java.util.concurrent.*;

public class ReportServer {
    private ExecutorService service;
    private CompletionService<String> completionService;

    public ReportServer() {
        this.service = Executors.newFixedThreadPool(4);
        this.completionService = new ExecutorCompletionService<>(service);

    }

    /**public Future<String> submitTask(ReportTask task) {
        return service.submit(task);
    } */

    public void submitAllTasks(List<ReportTask> tasks) {
        for (ReportTask task : tasks) {
            completionService.submit(task);
        }
    }

    public Future<String> takeResult() throws InterruptedException {
        return completionService.take(); // waits for NEXT completed task
    }

    public void shutdown() {
        service.shutdown();
    }
}
