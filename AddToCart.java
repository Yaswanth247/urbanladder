package com.urbanladder.pages;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.urbanladder.config.Variable;
import com.urbanladder.utils.Screenshot;

public class AddToCart extends Variable {

	 WebDriver driver;
	 public static WebElement  scroll, item;
	 public AddToCart(WebDriver driver)
	{
		this.driver= driver;
	}
	//View the product information
	public void clickOnProduct() throws Exception
	{
		driver.get(productUrl);
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		driver.findElement(clickOnProduct_xpath).click();
    	// Java Script is used to bring the add to cart button into view.
    	 scroll= driver.findElement(scroll_xpath);
		//Scroll contains the locator of the element till where we need to scroll in order to view the add to cart button
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)",scroll);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	// Add the product into the cart.
		driver.findElement(clickAddToCart_xpath).click();
	    Screenshot.takeScreenshot(driver);
		// Verifying if the product is successfully added into the cart or not.
		List<WebElement> cartEmpty= driver.findElements(emptyCart_xpath);
		if(cartEmpty.isEmpty())
		{
			System.out.println("Item is added in the cart Successfully");
		}else 
		{
			System.out.println("Shopping cart is empty");
		}
	}
}
