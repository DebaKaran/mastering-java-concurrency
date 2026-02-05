package com.deba.threadd.management.uncheckedexception;

public class ExceptionHandlerTaskTest {
    public static void main(String[] args) {
        Task task = new Task();
        Thread thread = new Thread(task);
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();

        System.out.println("End of main thread...");

    }
}
