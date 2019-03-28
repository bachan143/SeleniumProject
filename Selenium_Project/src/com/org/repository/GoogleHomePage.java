package com.org.repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage extends Page
{
	WebDriver driver;
	private By searchBox=By.className("gLFyf");
	private By searchButton=By.name("btnK");
	public GoogleHomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void enterText(String text)
	{
		driver.findElement(searchBox).sendKeys(text);
	}
	
	public void clickOnGoogleSearch()
	{
		driver.findElement(searchButton).click();
	}
	

}
