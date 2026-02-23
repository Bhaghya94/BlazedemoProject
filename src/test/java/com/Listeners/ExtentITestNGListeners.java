package com.Listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Blazedemo.Tests.BaseClass;
import com.Blazedemo.Utils.ExtentManager;
import com.Blazedemo.Utils.Screenshots;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentITestNGListeners implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        test.fail(result.getThrowable());

        WebDriver driver =
                ((BaseClass) result.getInstance()).driver;

        String path = Screenshots.getScreenshots(driver);

        test.addScreenCaptureFromPath(path);
        
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}