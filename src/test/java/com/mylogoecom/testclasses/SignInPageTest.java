package com.mylogoecom.testclasses;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.mylogoecom.POM.HomePage;
import com.mylogoecom.base.Base;


public class SignInPageTest extends Base {

	HomePage homePageInstance;
	
	ExtentTest signInTestCaseExtentReport;
	
	 
	
	@BeforeMethod
	public void launchBrowser() {
		fireBrowser();
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
	
	
	
	@AfterTest
	private void writeToExtentReport() {
		// TODO Auto-generated method stub
		extentReports.flush();
	} 
	
	@Test
	public void goToSignInPage() {
		signInTestCaseExtentReport=	extentReports.createTest("Go to SignIn Page Test Case");

		homePageInstance=new HomePage();
		try {
		homePageInstance.goToSignInPage();
		signInTestCaseExtentReport.log(Status.PASS,"Go to SignIn Page Successfull");
		
		} catch (Exception e) {
			signInTestCaseExtentReport.log(Status.FAIL, "Go to SignIn Page Fail");
			System.out.println("error from goToSignInPage"+" "+e.getMessage());
		}
		
	}
	
}
