package com.deba.forkjoin.recurstivetask;

import java.util.List;
import java.util.concurrent.RecursiveTask;

public class Task extends RecursiveTask<Double> {

    private List<Transaction> transactionList;
    private int first;
    private int last; //excluding
    //private double total; // not required as RecursiveTask is about returning values, not sharing state
    // and Each task should be stateless

    public Task(List<Transaction> transactionList, int first, int last) {
        this.transactionList = transactionList;
        this.first = first;
        this.last = last;

    }

    @Override
    protected Double compute() {
        if(last - first < 50) {
            return computeTotal();
        }

        int middle = first + (last - first) / 2;
        Task leftTask = new Task(transactionList, first, middle);
        Task rightTask = new Task(transactionList, middle, last);
        //invokeAll(leftTask, rightTask);

        // double result = 0;
        //result = leftTask.get() + rightTask.get();
        //get is blocking + checked exceptions and Designed for Future, not ForkJoin
        // double result = leftTask.join() + rightTask.join();

        leftTask.fork();
        double rightResult = rightTask.compute();
        double leftResult = leftTask.join();

        double result = leftResult + rightResult;

        return result;
    }

    private Double computeTotal() {
        double total = 0;
        for(int i = first; i < last; i++) {
            final Transaction transaction = transactionList.get(i);
            if(transaction.getAmount() > 500) {
                total += transaction.getAmount();
            }
        }

        return total;
    }
}
