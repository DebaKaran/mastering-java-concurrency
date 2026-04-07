package com.deba.executor.service.chapter4;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable{
    private String name;
    private Date initDate;

    public Task(String name) {
        this.name = name;
        this.initDate = new Date();
    }

    @Override
    public void run() {
        //Print when it starts
        
        System.out.printf("%s: Task %s: Created on: %s\n",Thread.
                currentThread().getName(),name,initDate);
        System.out.printf("%s: Task %s: Started on: %s\n",Thread.
                currentThread().getName(),name,new Date());

        // Simulate doing some work (random duration)

        try {
            Long duration=(long)(Math.random()*10);
            System.out.printf("%s: Task %s: Doing a task during %d seconds\n",
                    Thread.currentThread().getName(),name,duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s: Task %s: Finished on: %s\n",Thread.
                currentThread().getName(),name,new Date());
    }
}
