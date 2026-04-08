package com.deba.invokeany;

import java.util.concurrent.TimeUnit;

public class SqlServer implements DB {

    @Override
    public String fetchData() throws Exception {
        TimeUnit.SECONDS.sleep(2);
        return "SqlServer";
    }
}
