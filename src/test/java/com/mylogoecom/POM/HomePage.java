package com.mylogoecom.POM;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mylogoecom.base.Base;



public class HomePage extends Base {
	
	SignInPage insInPage;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "search_query_top")
	public WebElement searchBoxWebElement;
	
	@FindBy(xpath = "//img[contains(@class,'logo')]")
	public WebElement logoElement;
	
	@FindBy(linkText = "Sign in")
	public WebElement signInLinkElement;
	

	public SignInPage goToSignInPage() {
		try {
			signInLinkElement.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new SignInPage();
		
		
}

public SignUpEmailPage goToSignUpEmailPage() {
	
	try {
		signInLinkElement.click();
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	
	return new SignUpEmailPage();
	
}

public SearchPage queryToSearchProduct() {
	try {
		searchBoxWebElement.sendKeys(properties.getProperty("SEARCH_KEY"));
	} catch (Exception e) {
		System.out.println("error in query to search product");
	}
	return new SearchPage();
}
	
}
