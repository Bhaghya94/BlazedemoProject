package com.Blazedemo.Utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshots {
	
	public static String getScreenshots(WebDriver driver) {
		
		if (driver == null) {
	        throw new RuntimeException("Driver is null - Cannot capture screenshot");
	    }
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"//Screenshots//BlazedemoTest"+System.currentTimeMillis()+".png";
		File dest = new File(path);
		try {
			FileHandler.copy(source, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return path;
	}

}
