package com.deba.callable.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class FutureCallableDriver {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ReportServer server = new ReportServer();

        // Submit tasks
        Future<String> f1 = server.submitTask(new ReportTask("Sales Report"));
        Future<String> f2 = server.submitTask(new ReportTask("Inventory Report"));
        Future<String> f3 = server.submitTask(new ReportTask("User Report"));

        System.out.println("All reports submitted... doing other work");

        // Get results later
        System.out.println(f1.get());
        System.out.println(f2.get());
        System.out.println(f3.get());

        server.shutdown();
    }
}
