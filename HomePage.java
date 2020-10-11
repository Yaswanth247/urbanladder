package com.urbanladder.pages;

import org.openqa.selenium.WebDriver;
import com.urbanladder.utils.Screenshot;

public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	public String  homePage() throws Exception
	{
		
		driver.getCurrentUrl();
		Screenshot.takeScreenshot(driver);
		return driver.getTitle();
	}
}
