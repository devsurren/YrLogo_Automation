package com.mylogoecom.testclasses;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mylogoecom.POM.CreateAccountForm;
import com.mylogoecom.POM.HomePage;
import com.mylogoecom.POM.SignUpEmailPage;
import com.mylogoecom.base.Base;

public class SignUpEmailPageTest  extends Base{
	SignUpEmailPage _SignUpEmailPage;
	HomePage _homePage;
	
	@BeforeMethod
	public void launchBrowser() {
		fireBrowser();
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
	
	@Test
	public void createAccount() {
		try {
			 _homePage=new HomePage();
			_SignUpEmailPage=_homePage.goToSignUpEmailPage();
			
		//	_SignUpEmailPage =new SignUpEmailPage();
			CreateAccountForm _createAccountForm=_SignUpEmailPage.sendEmailForCreateAccount();	
			_createAccountForm.fillCreateAccountForm();
		} catch (Exception e) {
		 System.out.println("error message from createAccount"+" "+e.getMessage());
		}
	}
	
}
