package com.mylogoecom.POM;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mylogoecom.base.Base;

public class ShippingPageInShoppingCart extends Base {

	public ShippingPageInShoppingCart() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//input[@id='cgv']")
	public WebElement agreeTermsAndConditionWebElement;
	
	@FindBy(name = "processCarrier")
	public WebElement shippingProceedToCheckOutWebElement;
	
	public PaymentPageInShoppingCart proceedToCheckOutInShippingPage() {
		try {
			//agreeTermsAndConditionWebElement.click();
//			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//			jsExecutor.executeScript("document.getElementById('cgv').click();");
			
			//using Actions Class
			
			Actions _Actions = new Actions(driver);
			_Actions.moveToElement(agreeTermsAndConditionWebElement).click().build().perform();
			
			shippingProceedToCheckOutWebElement.click();
		} catch (Exception e) {
			System.out.println("error in ShippingPageInShoppingCart from proceedToCheckOut"+e.getMessage());
		}
		return new PaymentPageInShoppingCart();
	}
	
	
}
