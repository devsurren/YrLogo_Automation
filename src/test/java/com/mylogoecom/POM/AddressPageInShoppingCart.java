package com.mylogoecom.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mylogoecom.base.Base;

public class AddressPageInShoppingCart extends Base {
	
	public AddressPageInShoppingCart() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "processAddress")
	public WebElement addressProceedToCheckOutWebElement;
	
	public ShippingPageInShoppingCart clickProceedToCheckOutInAddressPage() {
		try {
			addressProceedToCheckOutWebElement.click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ShippingPageInShoppingCart();
	}

}
