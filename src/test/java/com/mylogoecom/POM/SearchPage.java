package com.mylogoecom.POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mylogoecom.base.Base;


public class SearchPage extends Base {
	
	public SearchPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * SearchBox Web element
	 * */
	
//	@FindBy(id = "search_query_top")
//	public WebElement searchBoxWebElement;
	
	//Product web element
	
	@FindBy(xpath = "//a[@class='product_img_link']")
	public WebElement productWebElement;
	
	public ProductPage searchProduct() {
		try {
			productWebElement.click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ProductPage();
	}
	
}
