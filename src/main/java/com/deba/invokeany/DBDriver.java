package com.deba.invokeany;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class DBDriver {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<DB> tasks = List.of(
                new MySqlDB(),
                new MongoDB(),
                new SqlServer()
        );
        
        DBServer server = new DBServer();
        final String result = server.submitAllTasks(tasks);
        System.out.println(result);

        server.shutdown();
    }
}
