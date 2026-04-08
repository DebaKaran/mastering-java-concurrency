package com.deba.invokeany;

import java.util.concurrent.TimeUnit;

public class MySqlDB implements DB {

    @Override
    public String fetchData() throws Exception {
        // CHECK HERE (before or inside long work)
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedException("Task interrupted before start");
        }
        TimeUnit.SECONDS.sleep(1);
        return "MySQL";
    }
}
