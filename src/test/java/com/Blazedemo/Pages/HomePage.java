package com.Blazedemo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	
	// Select cities, click “Find Flights”. 
	
    WebDriver driver;
    String actHeader, actTitle, actUrl;
    
    public HomePage(WebDriver driver) {
    	this.driver = driver;
    }
    
    // Locators for departure city, destination city, Find Flights button
    //By homeHeader = By.xpath("\"//h1[contains(text(),'Welcome to the Simple Travel Agency!')]\"");
    By homeHeader = By.tagName("h1");
    
    By departureCity = By.name("fromPort");
    By destinationCity = By.name("toPort");
    By findFlightBtn = By.xpath("//input[@value='Find Flights']");
    
    public boolean homeHeaderCheck() {
    	
    	actHeader = driver.findElement(homeHeader).getText();
    	return actHeader.contentEquals("Welcome to the Simple Travel Agency!");
    	
    }
    
    public boolean homeTitleCheck() {
    	
    	actTitle = driver.getTitle();
    	return actTitle.trim().contentEquals("BlazeDemo");  	
    }
    
    public boolean homeUrlCheck() {
    	
    	actUrl = driver.getCurrentUrl();
    	return actUrl.contentEquals("https://blazedemo.com/");
    }
    
    public boolean departureCitydropdown() {
    	
    	return driver.findElement(departureCity).isDisplayed();
    }
    
    public boolean destionationCitydropdown() {
    	
    	return driver.findElement(destinationCity).isDisplayed();
    }
     
    public void selectCities(String from, String to) {
    	
    	// click on departure city
    	Select dptCity = new Select(driver.findElement(departureCity));
    	dptCity.selectByValue(from);
 	  
    	// click on destination city & select New York
    	Select dstCity = new Select(driver.findElement(destinationCity));
    	dstCity.selectByVisibleText(to);
    	
    }
 	
    public void clickFindFlights() {
    	
    	// click on Find Flights button
    	driver.findElement(findFlightBtn).click();;
    	
    }
}
