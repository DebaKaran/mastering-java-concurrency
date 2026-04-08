package com.deba.invokeany;

import java.util.concurrent.TimeUnit;

public class MySqlDB implements DB {

    @Override
    public String fetchData() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        return "MySQL";
    }
}
