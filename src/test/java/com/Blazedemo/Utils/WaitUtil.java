package com.Blazedemo.Utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {

    private static final int TIMEOUT = 10;

    // Wait for visibility
    public static WebElement waitForVisibility(By locator) {

        WebDriverWait wait = new WebDriverWait(
                DriverSession.getDriver(),
                Duration.ofSeconds(TIMEOUT));

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait for element clickable
    public static WebElement waitForClickable(By locator) {

        WebDriverWait wait = new WebDriverWait(
                DriverSession.getDriver(),
                Duration.ofSeconds(TIMEOUT));

        return wait.until(
                ExpectedConditions.elementToBeClickable(locator));
    }

    // Wait for URL to contain text
    public static void waitForUrlContains(String partialUrl) {

        WebDriverWait wait = new WebDriverWait(
                DriverSession.getDriver(),
                Duration.ofSeconds(TIMEOUT));

        wait.until(ExpectedConditions.urlContains(partialUrl));
    }

    // Wait for exact URL
    public static void waitForUrlToBe(String fullUrl) {

        WebDriverWait wait = new WebDriverWait(
                DriverSession.getDriver(),
                Duration.ofSeconds(TIMEOUT));

        wait.until(ExpectedConditions.urlToBe(fullUrl));
    }
}
