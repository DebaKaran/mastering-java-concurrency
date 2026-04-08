package com.deba.callable.future.factorial;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class FactorialDriver {
    public static void main(String[] args) {

        FactorialServer server = new FactorialServer();

        List<FactorialCalculator> factorialCalculatorList = new ArrayList<>();

        Random random = new Random();

        for(int i = 0; i < 5; i++) {
            Integer num = random.nextInt(10);
            FactorialCalculator factorialCalculator = new FactorialCalculator(num);
            factorialCalculatorList.add(factorialCalculator);
        }

        List<Future<Integer>> futures = server.submitAllTasks(factorialCalculatorList);


        do {
            System.out.printf("Main: Number of Completed Tasks: %d\n",server.getCompletedTaskCount());

            for(int i = 0; i < futures.size(); i++) {
                Future<Integer> future = futures.get(i);
                System.out.printf("Main: Task %d: %s\n",i,future.isDone());
            }

            // Put the thread to sleep for 50 milliseconds.- put outside for loop
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (server.getCompletedTaskCount() < futures.size());

        server.shutdown();

        System.out.println("Main: Results");

        for (int i = 0; i < futures.size(); i++) {
            try {
                Integer value = futures.get(i).get();
                System.out.printf("Main: Task %d: %d\n", i, value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
