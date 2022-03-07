package com.mylogoecom.POM;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.mylogoecom.base.Base;



public class HomePage extends Base {
	
	SignInPage insInPage;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[contains(@class,'logo')]")
	public WebElement logoElement;
	
	@FindBy(linkText = "Sign in")
	public WebElement signInLinkElement;
	
//	Wait<WebDriver> driverWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(4))
//			.ignoring(InvocationTargetException.class);
//	
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
	
}
