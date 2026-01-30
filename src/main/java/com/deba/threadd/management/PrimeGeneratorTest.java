package com.deba.threadd.management;

public class PrimeGeneratorTest {
    public static void main(String[] args) {
        PrimeGenerator task = new PrimeGenerator();
        task.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        task.interrupt();
    }
}
