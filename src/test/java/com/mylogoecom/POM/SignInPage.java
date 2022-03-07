package com.mylogoecom.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mylogoecom.base.Base;

public class SignInPage extends Base {
	
	public SignInPage() {
		PageFactory.initElements(driver, SignInPage.class);
	}

	@FindBy(id ="email")
	public WebElement userNamElement;
	
	@FindBy(id="passwd")
	public WebElement passwordElement;
	
	@FindBy(id="SubmitLogin")
	public WebElement submitBtnElement;
	
	public void isInstanceCreated() {
		System.out.println("Instance created");
	}
	
	public void signinUser() {
//		userNamElement.sendKeys(properties.getProperty("USER_NAME"));
//		passwordElement.sendKeys(properties.getProperty("PASSWORD"));
//		submitBtnElement.click();
		userNamElement.sendKeys("surren");
	}
	
	
	
}
