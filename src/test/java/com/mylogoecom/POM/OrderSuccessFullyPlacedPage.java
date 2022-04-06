package com.mylogoecom.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mylogoecom.base.Base;

public class OrderSuccessFullyPlacedPage extends Base {

	public OrderSuccessFullyPlacedPage() {
		PageFactory.initElements(driver,this);
	}
	
	//Your order on My Store is complete.
	@FindBy(xpath = "p[text()='Your order on My Store is complete.']")
	public WebElement orderCompleteWebElement;
	
	public Boolean checkingOrderIsPlaced() {
		if(orderCompleteWebElement.getText().equals("Your order on My Store is complete")) {
			return true;
		}else {
			return false;
		}
	}
	
}
