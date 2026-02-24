package com.Blazedemo.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Blazedemo.Pages.ConfirmationPage;
import com.Blazedemo.Pages.HomePage;
import com.Blazedemo.Pages.PurchasePage;
import com.Blazedemo.Pages.ReservePage;

public class FlightBookingNegativeTest extends BaseClass {
	
  // Blank Credit Card	
  @Test(groups = "Negative")
  public void testBlankcreditcard() {
	  
	  HomePage home = new HomePage(driver);
      ReservePage reserve = new ReservePage(driver);
      PurchasePage purchase = new PurchasePage(driver);
      ConfirmationPage confirm = new ConfirmationPage(driver);

      home.selectCities("Boston", "New York");
      home.clickFindFlights();

      reserve.chooseFlight();
      purchase.passengerInfo("Test", "Street", "Delhi", "", "Test");
      purchase.clickPurchase();

      // Check confirmation page Url
      Assert.assertFalse(driver.getPageSource().contains("Thank you"), "Test Fail");
      
  }
  
  // Non-numeric Credit Card Number
  @Test(groups = "Negative")
  public void testinvalidcardno() {
	  
	  HomePage home = new HomePage(driver);
      ReservePage reserve = new ReservePage(driver);
      PurchasePage purchase = new PurchasePage(driver);
      ConfirmationPage confirm = new ConfirmationPage(driver);

      home.selectCities("Boston", "New York");
      home.clickFindFlights();

      reserve.chooseFlight();
      purchase.passengerInfo("Test", "Street", "Delhi", "@@@###", "Test");
      purchase.clickPurchase();
      
      // Check confirmation page Url
      Assert.assertFalse(driver.getPageSource().contains("Thank you"), "Test Fail");

  }
  
  // Leave required fields blank
  @Test(groups = "Negative")
  public void testEmptyField() {
	  
	  HomePage home = new HomePage(driver);
      ReservePage reserve = new ReservePage(driver);
      PurchasePage purchase = new PurchasePage(driver);
      ConfirmationPage confirm = new ConfirmationPage(driver);

      home.selectCities("Boston", "New York");
      home.clickFindFlights();

      reserve.chooseFlight();
      purchase.passengerInfo("", "Street", "Delhi", "", "Test");
      purchase.clickPurchase();
      
      // Check confirmation page Url
      Assert.assertFalse(driver.getPageSource().contains("Thank you"), "Test Fail");
      
  }
  
  // Same Departure & Destination City
  @Test(groups = "Negative")
  public void testSameCities() {
	  
	  HomePage home = new HomePage(driver);

      home.selectCities("Boston", "Boston");
      home.clickFindFlights();

      // Check ReservePage Url
      Assert.assertFalse(driver.getCurrentUrl().contains("reserve"), "Test Fail");

  }

	    
}
