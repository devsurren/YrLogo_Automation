package com.mylogoecom.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mylogoecom.base.Base;

public class CreateAccountForm extends Base{

	public CreateAccountForm() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="customer_firstname")
	WebElement firstNameElement;
	
	public void fillCreateAccountForm() {
		firstNameElement.sendKeys("Surren");
	}
	
}
