package com.mylogoecom.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mylogoecom.base.Base;

public class SignUpEmailPage extends Base {

	//id="customer_firstname"
	//id="SubmitCreate"
	
	public SignUpEmailPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email_create")
	WebElement creatAccountElement;
	
	@FindBy(id="SubmitCreate")
	WebElement creatAccountSubmitBtnElement;
	
	public CreateAccountForm sendEmailForCreateAccount() {
		creatAccountElement.sendKeys("heyjusttest@gmail.com");
		creatAccountSubmitBtnElement.click();
		return new CreateAccountForm();
	}
	
	
}
