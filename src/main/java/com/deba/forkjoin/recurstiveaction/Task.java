package com.deba.forkjoin.recurstiveaction;

import java.util.List;
import java.util.concurrent.RecursiveAction;

public class Task extends RecursiveAction {

    private List<Product> products;
    private int first;
    private int last;
    private double increment;

    public Task(List<Product> products, int first, int last, double increment) {
        this.products = products;
        this.first = first;
        this.last = last;
        this.increment = increment;
    }

    @Override
    protected void compute() {
        if(last - first < 10) {
            updatePrices();
        } else {
            int middle = first + (last - first) / 2;

            Task task1 = new Task(products, first, middle, increment);
            Task task2 = new Task(products, middle, last, increment);
            invokeAll(task1, task2);
        }
    }

    private void updatePrices() {

        for(int i = first; i < last; i++) {
            Product product = products.get(i);
            product.setPrice(product.getPrice() + increment);
        }
    }
}
