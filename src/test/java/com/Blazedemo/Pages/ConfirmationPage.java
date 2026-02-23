package com.Blazedemo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {
	
	// Validate success message.
	
	WebDriver driver;
	public String actUrl;
	
	// Locators
	By ConfirmationMsg = By.tagName("h1");
	
	public ConfirmationPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public boolean confirmationUrlCheck() {
		
		actUrl = driver.getCurrentUrl();
		return actUrl.contentEquals("https://blazedemo.com/confirmation.php");
	}
	
	public String getConfirmationMsg() {
		
		String actConfirmationMsg = driver.findElement(ConfirmationMsg).getText();
		return actConfirmationMsg;
	}

}
