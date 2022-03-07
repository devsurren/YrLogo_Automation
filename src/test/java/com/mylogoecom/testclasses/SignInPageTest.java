package com.mylogoecom.testclasses;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mylogoecom.POM.HomePage;
import com.mylogoecom.POM.SignInPage;
import com.mylogoecom.base.Base;


public class SignInPageTest extends Base {

	HomePage homePageInstance;
	
	@BeforeMethod
	public void launchBrowser() {
		fireBrowser();
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
	
	@Test
	public void goToSignInPage() {
		homePageInstance=new HomePage();
		try {
			System.out.println("goToSignInPage fired");
		SignInPage singInPageInstance=homePageInstance.goToSignInPage();
		singInPageInstance.isInstanceCreated();
			//singInPageInstance.userNamElement.sendKeys("surren");
			//_homePage.goToSignInPage();
		} catch (Exception e) {
			System.out.println("error from goToSignInPage"+" "+e.getMessage());
		}
		
	}
	
}
