package com.Blazedemo.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.Blazedemo.Utils.DriverSession;

@Listeners(com.Listeners.ExtentITestNGListeners.class)

public class BaseClass {
	
	public WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setup() {

        driver = DriverSession.getDriver();
        driver.manage().window().maximize();
        driver.get("https://blazedemo.com/");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        DriverSession.quitDriver();
    }
}
