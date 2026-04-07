package com.deba.executor.service.chapter4;

public class TasksTest {
    public static void main(String[] args) {
        Server server = new Server();
        for(int i = 0; i < 5; i++) {
            server.executeTask(new Task("Task: "+i));
        }
        server.endServer();
    }
}
