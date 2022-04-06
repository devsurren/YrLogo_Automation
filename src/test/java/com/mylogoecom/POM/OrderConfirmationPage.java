package com.mylogoecom.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mylogoecom.base.Base;

public class OrderConfirmationPage extends Base {

	public OrderConfirmationPage () {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//span[text()='I confirm my order']/ancestor::button")
	public WebElement confirmMyOrderWebElement;
	
	public OrderSuccessFullyPlacedPage clickConfirmMyOrderButton() {
		try {
			confirmMyOrderWebElement.click();
		} catch (Exception e) {
			System.out.println("error from OrderSuccessFullyPlacedPage in clickConfirmMyOrderButton"+e.getMessage());
		}
		return new OrderSuccessFullyPlacedPage();
	}
	
}
