package com.mylogoecom.testclasses;

import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.mylogoecom.POM.AddressPageInShoppingCart;
import com.mylogoecom.POM.HomePage;
import com.mylogoecom.POM.OrderConfirmationPage;
import com.mylogoecom.POM.OrderSuccessFullyPlacedPage;
import com.mylogoecom.POM.PaymentPageInShoppingCart;
import com.mylogoecom.POM.ProductPage;
import com.mylogoecom.POM.SearchPage;
import com.mylogoecom.POM.ShippingPageInShoppingCart;
import com.mylogoecom.POM.ShoppingCartPage;
import com.mylogoecom.POM.SignInPage;
import com.mylogoecom.base.Base;

public class OrderProductTest extends Base {
	
	ExtentTest extent;
	private ShoppingCartPage _shoppingCartPage;
	private AddressPageInShoppingCart _AddressPageInShoppingCart;
	private ShippingPageInShoppingCart _ShippingPageInShoppingCart;
	private PaymentPageInShoppingCart _PaymentPageInShoppingCart;
	private OrderConfirmationPage _OrderConfirmationPage;
	private OrderSuccessFullyPlacedPage _OrderSuccessFullyPlacedPage;
	private Boolean isOrderPlacedBoolean;
	
	
	@AfterTest
	private void writeResultToExtentReport() {
		extentReports.flush();
	}
	
	@Test
	public void addProductTpShoppingCart() {
		extent=extentReports.createTest("Add the product to the shopping cart");
	try {
		HomePage _homePage = new HomePage();
		SignInPage _signInPage =_homePage.goToSignInPage();
		_signInPage.signinUser();
		SearchPage _searchPage = _homePage.queryToSearchProduct();
		ProductPage _productPage= _searchPage.searchProduct();
		_shoppingCartPage=_productPage.addToCart();
		extent.log(Status.PASS, "Add the product to the shopping");
	} catch (Exception e) {
		extent.log(Status.FAIL, "Add the product to the shopping");
		System.out.println("error from OrderProcutTest in placeorderMethod"+e.getMessage());
	}
	}
	
	@Test
	public void addressPageOfShoppingCartTest() {
		try {
			_AddressPageInShoppingCart=_shoppingCartPage.placeOrder();

		} catch (Exception e) {
			System.out.println("error from OrderProductTest in addressPageOfShoppingCart"+e.getMessage());
		}
	}
	
	@Test
	public void shippingPageOfShoppingCartTest() {
		try {
			_ShippingPageInShoppingCart = _AddressPageInShoppingCart.clickProceedToCheckOutInAddressPage();
		} catch (Exception e) {
			System.out.println("error from OrderProductTest in shippingPageOfShoppingCart"+e.getMessage());
		}
	}
	
	@Test
	public void paymentPageofShoppingCartPage() {
		try {
			_PaymentPageInShoppingCart = _ShippingPageInShoppingCart.proceedToCheckOutInShippingPage();
		} catch (Exception e) {
			System.out.println("error from paymentPageofShoppingCartPage in shippingPageOfShoppingCart"+e.getMessage());
		}
	}
	
	@Test
	public void orderConfirmationPageTest() {
		try {
			_OrderConfirmationPage = _PaymentPageInShoppingCart.clickPayByBankWire();
		} catch (Exception e) {
			System.out.println("error from paymentPageofShoppingCartPage in shippingPageOfShoppingCart"+e.getMessage());
		}
	}
	
	@Test
	public void orderSuccessFullPageTest() {
		try {
			_OrderSuccessFullyPlacedPage=_OrderConfirmationPage.clickConfirmMyOrderButton();
			isOrderPlacedBoolean=_OrderSuccessFullyPlacedPage.checkingOrderIsPlaced();
			if(isOrderPlacedBoolean) {
				System.out.println("OrderPlacedSuccessFully");
			}
		} catch (Exception e) {
			System.out.println("error from paymentPageofShoppingCartPage in shippingPageOfShoppingCart"+e.getMessage());
		}
	}
	
	
	

}
