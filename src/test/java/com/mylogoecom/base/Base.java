package com.mylogoecom.base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	protected static WebDriver driver;
	
	public Properties properties = new Properties();
	
@BeforeSuite
public void beforeSuite() {
	try {
		properties.load(getClass().getResourceAsStream("/config.properties"));
		System.out.println("GetProperties Password"+" "+properties.getProperty("PASSWORD"));
	} catch (Exception e) {
		System.out.println("error from beforesuitmethod"+" "+e.getMessage());
	}
}

public void fireBrowser() {
	
	try {
		switch (properties.getProperty("BROWSER")) {
		case "chrome":
			//set browser driver location
		//	WebDriverManager.chromedriver().setup();
			
			//initiate browser
			driver= new ChromeDriver();
			break;
			
		case "firefox":
			//set browser driver location
			WebDriverManager.firefoxdriver().setup();
			
			//initiate browser
			driver= new FirefoxDriver();
	
			break;

		default:
			//set browser driver location
			WebDriverManager.chromedriver().setup();
			
			//initiate browser
			driver= new ChromeDriver();
			break;
		}
		//navigate the browse to site
		driver.get(properties.getProperty("BASE_URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

	} catch (Exception e) {
		System.out.println("error from fireBrowser"+" "+e.getMessage());
	}
	
}
	
}
