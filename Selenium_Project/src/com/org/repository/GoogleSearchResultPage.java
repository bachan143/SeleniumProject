package com.org.repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchResultPage extends Page
{
	WebDriver driver;
	By ResultStrat=By.id("resultStats");
	public GoogleSearchResultPage(WebDriver driver)
	{
		this.driver=driver;
	}
	public boolean isPresent()
	{
		if(driver.findElement(ResultStrat).isDisplayed())
			return true;
		else 
			return false;
		
	}

}
