package com.mylogoecom.testclasses;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mylogoecom.POM.HomePage;
import com.mylogoecom.POM.ProductPage;
import com.mylogoecom.POM.SearchPage;
import com.mylogoecom.POM.SignInPage;
import com.mylogoecom.base.Base;

public class OrderProductTest extends Base {
	
	@BeforeMethod
	public void lanuchBrowser() {
		fireBrowser();
	}
	
	@Test
	public void productOrder() {
		HomePage _homePage = new HomePage();
		SignInPage _signInPage =_homePage.goToSignInPage();
		_signInPage.signinUser();
		SearchPage _searchPage = _homePage.queryToSearchProduct();
		ProductPage _productPage= _searchPage.searchProduct();
		_productPage.addToCart();
		
		
	}

}
