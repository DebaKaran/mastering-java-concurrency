package com.deba.threadd.management;

public class Calculator implements Runnable {

    final int n;

    public Calculator(final int n) {
        this.n = n;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 10; i++) {
            System.out.printf("%s: %d * %d = %d\n",Thread.
                    currentThread().getName(),n,i,i*n);
        }
    }
}
