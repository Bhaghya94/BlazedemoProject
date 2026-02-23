package com.Blazedemo.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Blazedemo.Utils.WaitUtil;

public class PurchasePage {
	
	// Enter passenger and payment info.
	
	WebDriver driver;
	public String actUrl;
	
	public PurchasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean purchaseUrlCheck() {
		
		  actUrl = driver.getCurrentUrl();
		  return actUrl.contentEquals("https://blazedemo.com/purchase.php");
	}
	
	// Locators
	By name = By.id("inputName");
	By address = By.id("address");
	By city = By.id("city");
	By state = By.id("state");
	By zipcode = By.id("zipCode");
	By cardtype = By.xpath("//select[@id=\"cardType\"]");
	By cardno = By.id("creditCardNumber");
	By nameoncard = By.id("nameOnCard");
	
	public void passengerInfo(String pname, String paddress, String pcity, String pcardno, String pnameoncard) {
		
//		  driver.findElement(name).sendKeys(pname);
//		  driver.findElement(address).sendKeys(paddress);
//		  driver.findElement(city).sendKeys(pcity);
//		  
//		  driver.findElement(cardno).sendKeys(pcardno);
//		  
//		  driver.findElement(nameoncard).sendKeys(pnameoncard);
		
		WaitUtil.waitForVisibility(By.id("inputName"))
        .sendKeys(pname);

		WaitUtil.waitForVisibility(By.id("address"))
        .sendKeys(paddress);

		WaitUtil.waitForVisibility(By.id("city"))
        .sendKeys(pcity);

		WaitUtil.waitForVisibility(By.id("creditCardNumber"))
        .sendKeys(pcardno);

		WaitUtil.waitForVisibility(By.id("nameOnCard"))
        .sendKeys(pnameoncard);
	}
	
	public void clickPurchase() {
		
		  WebElement purchaseFlightBtn = driver.findElement(By.xpath("//input[@value=\"Purchase Flight\"]"));
		  purchaseFlightBtn.click();
	}
}
