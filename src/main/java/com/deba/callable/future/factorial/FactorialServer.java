package com.deba.callable.future.factorial;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class FactorialServer {
    private ThreadPoolExecutor executor;

    public FactorialServer() {
        this.executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
    }

    public long getCompletedTaskCount() {
        return executor.getCompletedTaskCount();
    }
    public List<Future<Integer>> submitAllTasks(List<FactorialCalculator> tasks) {
        List<Future<Integer>> result = new ArrayList<>();
        for(FactorialCalculator task : tasks) {
            Future<Integer> future = executor.submit(task);
            result.add(future);
        }

        return result;
    }

    public void shutdown() {
        executor.shutdown();
    }
}
