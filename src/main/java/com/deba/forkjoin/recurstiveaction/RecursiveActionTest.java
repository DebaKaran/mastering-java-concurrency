package com.deba.forkjoin.recurstiveaction;

import java.util.List;
import java.util.concurrent.*;

public class RecursiveActionTest {
    public static void main(String[] args) {
        ProductListGenerator generator = new ProductListGenerator();
        final List<Product> products = generator.generateProductList(10000000);

        Task task = new Task(products, 0, products.size(), 0.20);

        ForkJoinPool pool = new ForkJoinPool();

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        ScheduledFuture<?> monitor = scheduler.scheduleAtFixedRate(() -> {
            System.out.printf("Main: Thread Count: %d\n", pool.getActiveThreadCount());
            System.out.printf("Main: Thread Steal: %d\n", pool.getStealCount());
            System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
        }, 0, 500, TimeUnit.MILLISECONDS);

        pool.invoke(task);   // main thread blocks efficiently

        monitor.cancel(true);      // stop repeating task
        scheduler.shutdown();      // shutdown scheduler
        pool.shutdown();

        if (task.isCompletedNormally()){
            System.out.printf("Main: The process has completed normally.\n");
        }

        for (int i=0; i<products.size(); i++){
            Product product=products.get(i);
            if (product.getPrice()- 12 > 0.001) {
                System.out.printf("Product %s: %f\n",product.
                        getName(),product.getPrice());
            }
        }

        System.out.println("Main: End of the program.\n");
    }
}
