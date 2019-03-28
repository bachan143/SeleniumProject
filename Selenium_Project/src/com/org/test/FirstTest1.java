package com.org.test;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.org.repository.GoogleHomePage;
import com.org.repository.GoogleSearchResultPage;

public class FirstTest1
{
	static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException 
	{
		
		new FirstTest1();
	}
	@Before
	public void intilise()
	{
		String[]  broswer= {"chrome","firefox","internetexplore"};
		
		setUp(broswer[0]);
	}
	public static  void setUp(String broswer)
	{
		switch(broswer)
		{
		case "chrome":
		         System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Desktop\\chromedriver_win32\\"
		 		+ "chromedriver.exe");
		         driver=new ChromeDriver();
		         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		         break;
		case "firefox":
		      System.setProperty("webdriver.firefox.marionette","C:\\Users\\hp\\Desktop\\geckodriver-v0.24.0-win64\\"
				+"geckodriver.exe");
		      driver=new FirefoxDriver();
		      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		      break;
		case   "internetexplore":
		System.setProperty("webdriver.ie.driver","C:\\Users\\hp\\Desktop\\IEDriverServer_x64_3.14.0\\"
				+ "IEDriverServer.exe");
		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		caps.setCapability("ignoreZoomSetting", true);
		
		 driver=new InternetExplorerDriver(caps); 
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 break;
		 default :
			 System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Desktop\\chromedriver_win32\\"
				 		+ "chromedriver.exe");
				         driver=new ChromeDriver();
				         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				        
			 
		 
		  
		}
	}
	@Test
	public void searchTestCase() throws InterruptedException
	{
		 GoogleHomePage googlehomepage=new GoogleHomePage(driver);
		 GoogleSearchResultPage googlesearchresultpage=new GoogleSearchResultPage(driver);
		 driver.get("https://thenalanda.com");
		 driver.manage().window().maximize();
		 googlehomepage.enterText("home");
		 //Thread.sleep(3000);
		 googlehomepage.clickOnGoogleSearch();
		 assertTrue(googlesearchresultpage.isPresent());
	}
	@Test
	public void searchTestCase2() throws InterruptedException
	{
		 GoogleHomePage googlehomepage=new GoogleHomePage(driver);
		 GoogleSearchResultPage googlesearchresultpage=new GoogleSearchResultPage(driver);
		 driver.get("https://google.com");
		 driver.manage().window().maximize();
		 googlehomepage.enterText("my name is cricket");
		// Thread.sleep(3000);
		 googlehomepage.clickOnGoogleSearch();
		assertTrue(googlesearchresultpage.isPresent());
	}
	@After
	public void close()
	{
		 driver.close();
	}
 
}
