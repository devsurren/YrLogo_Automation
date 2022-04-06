package com.mylogoecom.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mylogoecom.base.Base;

public class CreateAccountForm extends Base{

	public CreateAccountForm() {
		PageFactory.initElements(driver,this);
	}
	
	//Mr || Mrs Title
	@FindBy(id = "id_gender1")
	public WebElement genderTitleWebElement;
	
	@FindBy(id="customer_firstname")
	public WebElement firstNameWebElement;
	
	@FindBy(name="customer_lastname")
	public WebElement lastnameWebElement;
	
	@FindBy(id = "passwd")
	public WebElement passwordWebElement;
	
	//days drop down webElement
	@FindBy(id = "days")
	public WebElement daysWebElement;
	
	@FindBy(id = "months")
	public WebElement monthWebElement;
	
	@FindBy(id = "years")
	public WebElement yearWebElement;
	

	//Address Section
	@FindBy(id = "firstname")
	public WebElement addressFirstNameWebElement;
		
	@FindBy(id = "lastname")
	public WebElement addressLastNameWebElement;
	
	@FindBy(id = "company")
	public WebElement companyWebElement;
	
	@FindBy(id = "address1")
	public WebElement address1WebElement;
	
	@FindBy(id="address2")
	public WebElement address2WebElement;
	
	@FindBy(id="city")
	public WebElement cityWebElement;
	
	//State drop down
	@FindBy(id="id_state")
	public WebElement stateWebElement;
	
	@FindBy(id = "postcode")
	public WebElement postCodeWebElement;
	
	//Country drop down
	@FindBy(id = "id_country")
	public WebElement countryWebElement;
	
	//TextArea
	@FindBy(id="other")
	public WebElement additionalInformationWebElement;
	
	@FindBy(id = "phone")
	public WebElement phoneWebElement;
	@FindBy(id = "phone_mobile")
	public WebElement mobileWebElement;
	@FindBy(id = "alias")
	public WebElement aliasWebElement;
	
	@FindBy(id = "submitAccount")
	public WebElement submitButtonWebElement;
	
	public void fillCreateAccountForm() {
		genderTitleWebElement.click();
		firstNameWebElement.sendKeys("peaky");
		lastnameWebElement.sendKeys("Blinders");
		passwordWebElement.sendKeys("peakyblinders123");
		
		//selecting date
		Select dateSelect = new Select(daysWebElement);
		dateSelect.selectByValue("5");
		
		//selecting month
		Select monthSelect = new Select(monthWebElement);
		monthSelect.selectByIndex(3);
		
		//selecting Year
		Select yearSelect = new Select(yearWebElement);
		yearSelect.selectByValue("1995");
		
		//Your Address Section
		
		addressFirstNameWebElement.sendKeys("firtanme");
		addressLastNameWebElement.sendKeys("lastname");
		
		companyWebElement.sendKeys("PeakyBlinder");
		address1WebElement.sendKeys(
				"state of alabama 2 cross road"
				);
		address2WebElement.sendKeys(
				"state of alabama 2 cross road"
				);
		
		
		cityWebElement.sendKeys("something");
		
		//Selecting value state value Select drop down
		Select countrySelect = new Select(countryWebElement);
		countrySelect.selectByIndex(1);
		
		//Selecting value state value Select drop down
		Select stateSelect = new Select(stateWebElement);
		stateSelect.selectByIndex(1);
		
		postCodeWebElement.sendKeys("36117");
		
		mobileWebElement.sendKeys("1234567890");
		
		aliasWebElement.sendKeys("samurai");
		
		submitButtonWebElement.click();
		
		
		
		
		
	}
	
}
