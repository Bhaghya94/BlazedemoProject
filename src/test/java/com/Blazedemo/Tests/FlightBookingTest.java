package com.Blazedemo.Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Blazedemo.Pages.ConfirmationPage;
import com.Blazedemo.Pages.HomePage;
import com.Blazedemo.Pages.PurchasePage;
import com.Blazedemo.Pages.ReservePage;
import com.Blazedemo.Utils.DriverSession;
import com.Blazedemo.Utils.WaitUtil;

public class FlightBookingTest extends BaseClass {
	
  @Test(groups = "Smoke")
  public void flightbooking() {
	  
	  HomePage home = new HomePage(driver);
      ReservePage reserve = new ReservePage(driver);
      PurchasePage purchase = new PurchasePage(driver);
      ConfirmationPage confirm = new ConfirmationPage(driver);
	  
	  // Homepage Validation
	  Assert.assertTrue(home.homeHeaderCheck());
	  Assert.assertTrue(home.homeTitleCheck());
	  Assert.assertTrue(home.homeUrlCheck());
	  
	  // Select Depature & Destination Cities as "Boston" & "New York"
	  home.selectCities("Boston", "New York");
	   
	  // click on Find Flights button
	  home.clickFindFlights();
	  
	  
	  // ReservePage Validation
	  //Assert.assertTrue(reserve.reserveUrlCheck());
	  WaitUtil.waitForUrlContains("reserve.php");

      Assert.assertTrue(
              DriverSession.getDriver()
              .getCurrentUrl()
              .contains("reserve.php"),
              "Navigation to Reserve page failed");
	  
	  
	  // chooseFilght
	  reserve.chooseFlight();
	  
	  // PurchasePage Validation
	  //Assert.assertTrue(purchase.purchaseUrlCheck());
	  WaitUtil.waitForUrlContains("purchase.php");

      Assert.assertTrue(
              DriverSession.getDriver()
              .getCurrentUrl()
              .contains("purchase.php"),
              "Navigation to Purchase page failed");
	  
	  // passenger info & purchase flight
	  purchase.passengerInfo("Bhaghya", "RoseVille", "Pune", "123456", "Bhaghya");
	  purchase.clickPurchase();
	  
	  // ConfirmationPage Validation
	  //Assert.assertTrue(confirm.confirmationUrlCheck());
	  WaitUtil.waitForUrlContains("confirmation.php");

      Assert.assertTrue(
              confirm.confirmationUrlCheck(),
              "Confirmation page URL mismatch");
	  
	  // validate that Confirmation message is displayed
	  String msgText = confirm.getConfirmationMsg();
	  Assert.assertEquals(msgText, "Thank you for your purchase today!");
  }
  
  // DataProvider
  @Test(dataProvider = "bookingData", groups = "Functional")
  public void verifyMultipleBookings(String fromCity,
                                     String toCity,
                                     String name,
                                     String address,
                                     String city,
                                     String cardNo,
                                     String cardName) {

      HomePage home = new HomePage(driver);
      ReservePage reserve = new ReservePage(driver);
      PurchasePage purchase = new PurchasePage(driver);
      ConfirmationPage confirm = new ConfirmationPage(driver);

      home.selectCities(fromCity, toCity);
      home.clickFindFlights();

      reserve.chooseFlight();
      purchase.passengerInfo(name, address, city, cardNo, cardName);
      purchase.clickPurchase();

      Assert.assertTrue(confirm.confirmationUrlCheck());
      Assert.assertEquals(confirm.getConfirmationMsg(),
              "Thank you for your purchase today!");
  }


  @DataProvider(name = "bookingData")
  public Object[][] getBookingData() {

      return new Object[][]{
              {"Boston", "New York", "Siya", "Street 1", "Delhi", "1234", "Siya"},
              {"Paris", "London", "Arun", "Lake View", "Mumbai", "4567", "Arun"},
              {"Boston", "London", "Sneha", "Hill Road", "Pune", "7890", "Sneha"}
      };
  }
  
  
}
