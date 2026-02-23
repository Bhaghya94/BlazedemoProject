package com.Blazedemo.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReservePage {
	
	// Choose a flight.
	
	WebDriver driver;
	public String actUrl;
	
	// Locator
	By chooseFlight = By.xpath("//table//tbody//tr[2]//td//input[@value=\"Choose This Flight\"]");
	
	public ReservePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean reserveUrlCheck() {
		
		new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.urlContains("reserve.php"));
		
		actUrl = driver.getCurrentUrl();
		return actUrl.contentEquals("https://blazedemo.com/reserve.php");
	}
	
	public void chooseFlight() {
			
		driver.findElement(chooseFlight).click();
	}

}
