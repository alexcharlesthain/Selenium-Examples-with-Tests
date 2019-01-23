package com.qa.alex.selenium;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SalahWikiTestwithReport {
	
	public ExtentReports report;
	public ExtentTest test;
	
	public WebDriver driver;
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyWikiTitle() {
		
		report = new ExtentReports("C:\\Users\\Admin\\Documents\\BasicReport.html", true);
		
		test = report.startTest("Verify Page Title");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		test.log(LogStatus.INFO, "Browser Started");
		
		driver.get("https://en.wikipedia.org/wiki/Mohamed_Salah");
		String title = driver.getTitle();
		
		if (title.equals("Mohamed Salah - Wikipedia")) {
			test.log(LogStatus.PASS, "verify title of page");
		} else {
			test.log(LogStatus.FAIL, "verify title of page");
		}
		
		report.endTest(test);
		report.flush();
	
		assertEquals("Mohamed Salah - Wikipedia", title);
	}
	
}
