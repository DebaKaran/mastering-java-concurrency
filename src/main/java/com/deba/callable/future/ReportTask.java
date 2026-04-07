package com.deba.callable.future;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ReportTask implements Callable<String> {
    private String reportName;

    public ReportTask(String reportName) {
        this.reportName = reportName;
    }

    @Override
    public String call() throws Exception {
        System.out.println("Generating report: " + reportName);

        TimeUnit.SECONDS.sleep(2);

        return reportName + " generated successfully";
    }
}
