package com.deba.callable.future;

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

        // Submit all tasks
        //List<Future<String>> futures = server.submitAllTasks(tasks);
        server.submitAllTasks(tasks);

        System.out.println("All reports submitted... doing other work");

        // Collect results
        // Process results as they COMPLETE (not order)
        for (int i = 0; i < tasks.size(); i++) {
            Future<String> future = server.takeResult();
            System.out.println(future.get());
        }

        server.shutdown();
    }
}
