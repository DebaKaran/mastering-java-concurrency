package com.deba.invokeany;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DBServer {
    private  ExecutorService service;

    public DBServer() {
        this.service = Executors.newFixedThreadPool(2);
    }

    public String submitAllTasks(List<DB> tasks) throws ExecutionException, InterruptedException {
        List<Callable<String>> callables = new ArrayList<>();

        for(DB db : tasks) {
            /**
            callables.add( new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return db.fetchData();
                }
            }); */

            callables.add(() -> db.fetchData());

        }

        return service.invokeAny(callables);
    }

    public void shutdown() {
        service.shutdown();
    }

}
