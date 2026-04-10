package com.deba.forkjoin.recurstivetask;

import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class RecursiveTaskTest {
    public static void main(String[] args) {
        TransactionGenerator generator = new TransactionGenerator();
        List<Transaction> transactionList = generator.generate(1000);

        Task task = new Task(transactionList, 0, transactionList.size());

        ForkJoinPool pool = new ForkJoinPool();

        double result = pool.invoke(task);

        pool.shutdown();

        System.out.println(result);
    }
}
