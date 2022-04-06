package com.mylogoecom.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mylogoecom.base.Base;

public class PaymentPageInShoppingCart extends Base {

	public PaymentPageInShoppingCart() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//p[@class='payment_module']/a")
	public WebElement payByBankWireWebElement;
	
	public OrderConfirmationPage clickPayByBankWire() {
		
		try {
			payByBankWireWebElement.click();
		} catch (Exception e) {
			System.out.println("error from paymentpage in clickPayByBankWire Method"+e.getMessage());
		}
		
		return new OrderConfirmationPage();
	}
	
	
}
