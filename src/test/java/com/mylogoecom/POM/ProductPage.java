package com.mylogoecom.POM;



//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mylogoecom.base.Base;

public class ProductPage extends Base {
	
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}

	//Quantity web element
	@FindBy(id="quantity_wanted")
	public WebElement quntityWebElement;
	
	//Size web element
	@FindBy(id = "group_1")
	public WebElement selectSizeWebElement;
	
	//Add to cart button
	@FindBy(xpath = "//p[@id='add_to_cart']/button")
	public WebElement addToCartButtonWebElement;
	
	//price element
	@FindBy(id="our_price_display")
	public WebElement priceWebElement;
	
/**
 * proceed to check_out_button 
 * it will return shopping cart summary page
 */
	@FindBy(xpath = "//a[@title='Proceed to checkout']")
	public WebElement processedCheckOutButtonWebElement;
	
	
	public ShoppingCartPage addToCart()  {
		try {
			Select select = new Select(selectSizeWebElement);
			select.selectByVisibleText("M");
			addToCartButtonWebElement.click();
			Thread.sleep(3);
			processedCheckOutButtonWebElement.click();
		} catch (Exception e) {
			System.out.println("error from productpage in add to cart page"+e.getMessage());
		}
//		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//		jsExecutor.executeScript("arguments[0].click", processedCheckOutButtonWebElement);
		return new ShoppingCartPage();
	}
	
	
	
	
	
	
}
