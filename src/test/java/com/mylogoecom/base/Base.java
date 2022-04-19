package com.mylogoecom.base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	protected static WebDriver driver;
	
	//Extent Reports Properties
	ExtentSparkReporter htmlTemplatExtentSparkReporter;
	protected static ExtentReports extentReports;
	
	protected Properties properties = new Properties();
	
@BeforeSuite
public void beforeSuite() {
	try {
		//loading properties files
		properties.load(getClass().getResourceAsStream("/config.properties"));
		
		//extent reports configuration
		htmlTemplatExtentSparkReporter = new ExtentSparkReporter("ExtentReport.html");
		extentReports =  new ExtentReports();
		extentReports.attachReporter(htmlTemplatExtentSparkReporter);
		fireBrowser();		
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
