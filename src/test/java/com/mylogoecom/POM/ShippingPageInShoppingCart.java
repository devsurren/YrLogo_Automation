package com.mylogoecom.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mylogoecom.base.Base;

public class ShippingPageInShoppingCart extends Base {

	public ShippingPageInShoppingCart() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id = "cgv")
	public WebElement agreeTermsAndConditionWebElement;
	
	@FindBy(name = "processCarrier")
	public WebElement shippingProceedToCheckOutWebElement;
	
	public PaymentPageInShoppingCart proceedToCheckOutInShippingPage() {
		try {
			agreeTermsAndConditionWebElement.click();
			shippingProceedToCheckOutWebElement.click();
		} catch (Exception e) {
			
		}
		return new PaymentPageInShoppingCart();
	}
	
	
}
