package com.deba.threadd.management.dameon;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class DameonTest {
    public static void main(String[] args) {
        Deque<Event> deque = new LinkedBlockingDeque<>();

        WriterTask writerTask = new WriterTask(deque);
        for(int i = 0; i <= 2; i++) {
            Thread thread = new Thread(writerTask);
            thread.start();
        }
        CleanerTask cleanerTask = new CleanerTask(deque);
        cleanerTask.start();

        try {
            TimeUnit.SECONDS.sleep(40);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("End of mai thread: "+Thread.currentThread().getName());
    }
}
