package com.deba.threadd.management;

public class DataAndNetworkSourcesLoaderTest {

    public static void main(String[] args) {
        DataSourcesLoader dataSourcesLoader = new DataSourcesLoader();
        Thread task1 = new Thread(dataSourcesLoader);

        NetworkConnectionsLoader networkConnectionsLoader = new NetworkConnectionsLoader();
        Thread task2 = new Thread(networkConnectionsLoader);

        task1.start();
        task2.start();

        try {
            task1.join();
            task2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
