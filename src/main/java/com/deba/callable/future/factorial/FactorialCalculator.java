package com.deba.callable.future.factorial;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FactorialCalculator implements Callable<Integer> {
    private Integer num;

    public FactorialCalculator(Integer num) {
        this.num = num;
    }

    @Override
    public Integer call() throws Exception {
        if (num == 0 || num == 1) {
            return 1;
        }

        int total = 1;
        for(int i = 2; i <= num; i++) {
            total *= i;
            TimeUnit.MILLISECONDS.sleep(20);
        }
        System.out.printf("%s: %d\n",Thread.currentThread().getName(),total);
        return total;
    }
}
