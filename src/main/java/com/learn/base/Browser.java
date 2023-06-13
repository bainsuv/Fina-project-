package com.osa.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.osa.utility.Utility;

public class Browser {

private static Logger log = Utility.getLog(Browser.class);
	
public static WebDriver openBrowsers(String browser) {

	WebDriver dr=null;
	String osName=System.getProperty("os.name");
	log.info("****************************RUNNING THE TEST ON "+osName+" OS*********************************");
		if(browser.equalsIgnoreCase("chrome")) {
			System.out.println("The test in running on " + browser);
			dr=getChrome();
		}else if(browser.equalsIgnoreCase("firefox")) {
			System.out.println("The test in running on " + browser);
			dr=getFirefox();
		}else {
			log.info("*****************************************************************************");
			log.info("You have entered "+browser+" which is not a suppored browser in this framework!!");
			log.info("You can enter \n1. chrome ---> Chrome Browser\n2. firefox ---> Firefox Browser");
			log.info("*****************************************************************************");
		}
		dr.manage().window().maximize();
		dr.get("https://www.osaconsultingtech.com");

	return dr;
}

public static ChromeDriver getChrome() {
	System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
	ChromeDriver dr=new ChromeDriver();
	return dr;
}

public static FirefoxDriver getFirefox() {
	System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\drivers\\geckodriver.exe");
	FirefoxDriver dr=new FirefoxDriver();
	return dr;
}
}