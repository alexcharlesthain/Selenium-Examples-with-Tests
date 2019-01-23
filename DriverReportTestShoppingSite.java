package com.qa.alex.selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverReportTestShoppingSite {
	
	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception  {
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Documents\\AUTOMATED_TESTING_WEEK_10\\chromedriver_win32\\chromedriver.exe");
	    driver = new ChromeDriver();
	    baseUrl = "https://www.katalon.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	  
	  @Test
	  public void testShoppingSiteTestCase() throws Exception {
		driver.get("http://automationpractice.com/index.php");
			
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Summer Dresses'])[1]/following::a[1]")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Reduced price!'])[1]/following::a[1]")).click();
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='$30.51'])[2]/following::span[2]")).click();
		Thread.sleep(9000);		
	  }
	  
	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }
}
