package com.mylogoecom.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mylogoecom.base.Base;

public class ShoppingCartPage extends Base {
	
	public ShoppingCartPage() {
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//p[@class='cart_navigation clearfix']/a")
	public WebElement summaryProceedToCheckOutWebElement;
	
//	@FindBy(name = "processAddress")
//	public WebElement addressProceedToCheckOutWebElement;
//	
//	@FindBy(id = "cgv")
//	public WebElement agreeTermsAndConditionWebElement;
//	
//	@FindBy(name = "processCarrier")
//	public WebElement shippingProceedToCheckOutWebElement;
//	
//	@FindBy(xpath = "//p[@class='payment_module']/a")
//	public WebElement payByBankWireWebElement;
//	
//	@FindBy(xpath = "//span[text()='I confirm my order']/ancestor::button")
//	public WebElement confirmMyOrderWebElement;
	
	//Order complete alert popup
	////p[text()='Your order on My Store is complete.']
	
	public AddressPageInShoppingCart placeOrder() {
		try {
			summaryProceedToCheckOutWebElement.click();
		} catch (Exception e) {
			System.out.println("error from shoppingCartPlaceOrderMethod"+e.getMessage());
		}
		return new AddressPageInShoppingCart();
	}
	
}
