package com.qa.alex.selenium;
	
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DriverReportTestDemoSite {
	
		public ExtentReports report;
		public ExtentTest test;
	
		private WebDriver driver;
		  private String baseUrl;
		  private boolean acceptNextAlert = true;
		  private StringBuffer verificationErrors = new StringBuffer();

		  @Before
		  public void setUp() throws Exception  {
			  System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Documents\\chromedriver_win32\\chromedriver.exe");
		    driver = new ChromeDriver();
		    baseUrl = "https://www.katalon.com/";
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  }
		  
		  @Test
		  public void testTheDemoSiteTestCase() throws Exception {
		    
			report = new ExtentReports("C:\\Users\\Admin\\Documents\\DemoSiteReport.html", true);
			test = report.startTest("Verify Site Title");
			driver.manage().window().maximize();
			
			test.log(LogStatus.INFO, "Browser Started");
			
			driver.get("http://www.thedemosite.co.uk/");
			String title = driver.getTitle();
			
			if (title.equals("FREE example PHP code and online MySQL database - example username password protected site")) {
				test.log(LogStatus.PASS, "verify title of page");
			} else {
				test.log(LogStatus.FAIL, "verify title of page");
			}
		    
			assertEquals("FREE example PHP code and online MySQL database - example username password protected site", title);
			
		    driver.findElement(By.linkText("3. Add a User")).click();
		    driver.findElement(By.name("username")).click();
		    driver.findElement(By.name("username")).clear();
		    driver.findElement(By.name("username")).sendKeys("UrDaSellsAvon");
		    driver.findElement(By.name("password")).click();
		    driver.findElement(By.name("password")).clear();
		    driver.findElement(By.name("password")).sendKeys("alex");
		    driver.findElement(By.name("FormsButton2")).click();
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='PHP'])[1]/following::b[1]")).click();
		    driver.findElement(By.linkText("4. Login")).click();
		    driver.findElement(By.name("username")).click();
		    driver.findElement(By.name("username")).clear();
		    driver.findElement(By.name("username")).sendKeys("UrDaSellsAvon");
		    driver.findElement(By.name("password")).click();
		    driver.findElement(By.name("password")).clear();
		    driver.findElement(By.name("password")).sendKeys("alex");
		    driver.findElement(By.name("FormsButton2")).click();
		    Thread.sleep(6000);
		    
		    report.endTest(test);
			report.flush();
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