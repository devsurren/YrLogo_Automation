package com.mylogoecom.testclasses;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.mylogoecom.POM.HomePage;
import com.mylogoecom.POM.SignInPage;
import com.mylogoecom.base.Base;

public class SignInPageTest extends Base {

	HomePage homePageInstance;
	SignInPage signInPageInstance;
	
	ExtentTest signInTestCaseExtentReport;
	
	 
//	@BeforeClass
//	public void launchBrowser() {
//		fireBrowser();
//	}
	
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
		signInPageInstance=homePageInstance.goToSignInPage();
		signInTestCaseExtentReport.log(Status.PASS,"Go to SignIn Page Successfull");
		
		} catch (Exception e) {
			signInTestCaseExtentReport.log(Status.FAIL, "Go to SignIn Page Fail");
			System.out.println("error from goToSignInPage"+" "+e.getMessage());
		}
		
	}
	
	@Test
	public void loginUser() {
		ExtentTest loginUserTestCase = extentReports.createTest("Login The User");
		try {
			signInPageInstance.signinUser();
			loginUserTestCase.log(Status.PASS, "User was logged in Successfully");
		} catch (Exception e) {
			loginUserTestCase.log(Status.FAIL, "Login user failed");
			System.out.println("error from SignInPageTest in loginUser"+e.getMessage());
		}
		
	}	
	
}
