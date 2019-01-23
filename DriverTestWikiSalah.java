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

public class DriverTestWikiSalah {

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
	  public void testGoogleSalahTestCase() throws Exception {
	    driver.get("https://www.google.com/");
	    driver.findElement(By.name("q")).sendKeys(Keys.DOWN);
	    driver.findElement(By.name("q")).clear();
	    driver.findElement(By.name("q")).sendKeys("mohamed salah");
	    driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Web results'])[1]/following::h3[1]")).click();
	    driver.findElement(By.id("firstHeading")).click();
	    assertEquals("Mohamed Salah", driver.findElement(By.id("firstHeading")).getText());
	    assertEquals("Mohamed Salah - Wikipedia", driver.getTitle());
	    driver.findElement(By.id("content")).click();
	    Thread.sleep(7000);
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
