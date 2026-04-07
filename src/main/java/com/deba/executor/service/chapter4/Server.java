package com.deba.executor.service.chapter4;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Server {

    private ThreadPoolExecutor executor;

    public Server() {
        this.executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
    }

    public void executeTask(Task task) {
        //Log that a task has arrived
        System.out.printf("Server: A new task has arrived\n");

        //Submit it for execution
        executor.execute(task);

        /**
         * C: Print current system stats:
         * -> Total threads in pool
         * -> Threads currently working
         * -> Tasks already completed
         */
        System.out.printf("Server: Pool Size: %d\n",executor.
                getPoolSize());
        System.out.printf("Server: Active Count: %d\n",executor.
                getActiveCount());
        System.out.printf("Server: Completed Tasks: %d\n",executor.
                getCompletedTaskCount());
    }

    public void endServer() {
        executor.shutdown();
    }

}
