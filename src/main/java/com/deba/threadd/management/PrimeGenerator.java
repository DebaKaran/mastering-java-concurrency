package com.deba.threadd.management;

public class PrimeGenerator extends Thread{

    @Override
    public void run() {
        long num = 1L;
        while (true) {
            if(isPrimeNumber(num)) {
                System.out.printf("Number %d is Prime",num);
            }

            if(isInterrupted()) {
                System.out.printf("The Prime Generator has been Interrupted");
                return;
            }
            num++;
        }
    }

    private boolean isPrimeNumber(long num) {
        if (num <= 1) return false;
        if (num <= 3) return true;

        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
