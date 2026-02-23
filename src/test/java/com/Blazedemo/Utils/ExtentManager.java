package com.Blazedemo.Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	public static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            ExtentSparkReporter reporter =
                    new ExtentSparkReporter("Reports/ExtentReport_" + timestamp + ".html");

            extent = new ExtentReports();
            extent.attachReporter(reporter);

            extent.setSystemInfo("Project", "BlazeDemo Automation");
            extent.setSystemInfo("Tester", "Bhaghya");
        }

        return extent;
    }

}
