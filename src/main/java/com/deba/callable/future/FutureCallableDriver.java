package com.deba.callable.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class FutureCallableDriver {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ReportServer server = new ReportServer();

        // Submit tasks
        List<ReportTask> tasks = List.of(
                new ReportTask("Sales Report"),
                new ReportTask("Inventory Report"),
                new ReportTask("User Report")
        );

        List<Future<String>> futures = new ArrayList<>();

        // Submit all tasks
        for (ReportTask task : tasks) {
            futures.add(server.submitTask(task));
        }

        System.out.println("All reports submitted... doing other work");

        // Collect results
        for (Future<String> future : futures) {
            System.out.println(future.get());
        }

        server.shutdown();
    }
}
