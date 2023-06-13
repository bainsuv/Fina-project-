package com.osa.base;



import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.osa.utility.Utility;

public class Base {
	public static HashMap<String,WebDriver> hp=new HashMap<String,WebDriver>();
	private static Logger log = Utility.getLog(Base.class);
	public WebDriver dr;
	@BeforeMethod
	@Parameters("browser")
	public void openBrowser(String browser) {
		dr=Browser.openBrowsers(browser);
		hp.put("driver", dr);
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void closeBrowser() {
		dr.quit();
	}
	@BeforeSuite
	public void beforeSuite() {
		log.info("********Running Before Suite**************");
	}
	@AfterSuite
	public void afterSuite() {
		log.info("********Running After Suite**************");
	}
	@BeforeTest
	public void beforeTest() {
		log.info("********Running Before Test**************");
	}
	@AfterTest
	public void afterTest() {
		log.info("********Running After Test**************");
	}
	
}