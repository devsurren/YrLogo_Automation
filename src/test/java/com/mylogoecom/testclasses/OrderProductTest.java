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
	
	
	private ShoppingCartPage _shoppingCartPage;
	private AddressPageInShoppingCart _AddressPageInShoppingCart;
	private ShippingPageInShoppingCart _ShippingPageInShoppingCart;
	private PaymentPageInShoppingCart _PaymentPageInShoppingCart;
	private OrderConfirmationPage _OrderConfirmationPage;
	private OrderSuccessFullyPlacedPage _OrderSuccessFullyPlacedPage;
	private Boolean isOrderPlacedBoolean;

	private	ExtentTest extent;
	private ExtentTest extentTestCaseOfAddressPage;
	private ExtentTest extentTestCaseOfShipppingPage;
	private ExtentTest extentTestCaseOfPaymentPage;
	private ExtentTest extentTestCaseOfOrderConfirmationPage;
	private ExtentTest extentTestCaseOfOrderSuccessfullPage;

	
	
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
	
	@Test(dependsOnMethods = "addProductTpShoppingCart")
	public void addressPageOfShoppingCartTest() {
		extentTestCaseOfAddressPage = extentReports.createTest("AddressPageTest");
		try {
			_AddressPageInShoppingCart=_shoppingCartPage.placeOrder();
			extentTestCaseOfAddressPage.log(Status.PASS,"AddressPageTest Completed");

		} catch (Exception e) {
			extentTestCaseOfAddressPage.log(Status.FAIL,"AddressPageTest Failed");
			System.out.println("error from OrderProductTest in addressPageOfShoppingCart"+e.getMessage());
		}
	}
	
	@Test(dependsOnMethods = "addressPageOfShoppingCartTest")
	public void shippingPageOfShoppingCartTest() {
		extentTestCaseOfShipppingPage = extentReports.createTest("ShippingPageTest");
		try {
			_ShippingPageInShoppingCart = _AddressPageInShoppingCart.clickProceedToCheckOutInAddressPage();
			extentTestCaseOfShipppingPage.log(Status.PASS,"ShippingPageTest Completed" );
		} catch (Exception e) {
			extentTestCaseOfShipppingPage.log(Status.FAIL, "ShippingPageTest Failed");
			System.out.println("error from OrderProductTest in shippingPageOfShoppingCart"+e.getMessage());
		}
	}
	
	@Test(dependsOnMethods ="shippingPageOfShoppingCartTest") 
	public void paymentPageofShoppingCartPage() {
		extentTestCaseOfPaymentPage = extentReports.createTest("PaymentPage Test");
		try {
			_PaymentPageInShoppingCart = _ShippingPageInShoppingCart.proceedToCheckOutInShippingPage();
			extentTestCaseOfPaymentPage.log(Status.PASS, "PaymentPage Test Completed");
		} catch (Exception e) {
			extentTestCaseOfPaymentPage.log(Status.PASS, "PaymentPage Test Fail");
			System.out.println("error from paymentPageofShoppingCartPage in shippingPageOfShoppingCart"+e.getMessage());
		}
	}
	
	@Test(dependsOnMethods = "paymentPageofShoppingCartPage")
	public void orderConfirmationPageTest() {
		extentTestCaseOfOrderConfirmationPage = extentReports.createTest("OrderConfirmation Page Test");
		try {
			_OrderConfirmationPage = _PaymentPageInShoppingCart.clickPayByBankWire();
			extentTestCaseOfOrderConfirmationPage.log(Status.PASS,"OrderConfirmation Page Test Completed");
		} catch (Exception e) {
			extentTestCaseOfOrderConfirmationPage.log(Status.FAIL,"OrderConfirmation Page Test Fail");
			System.out.println("error from paymentPageofShoppingCartPage in shippingPageOfShoppingCart"+e.getMessage());
		}
	}
	
	@Test(dependsOnMethods = "orderConfirmationPageTest")
	public void orderSuccessFullPageTest() {
		extentTestCaseOfOrderSuccessfullPage = extentReports.createTest("OrderSuccessFull Page Test");
		try {
			_OrderSuccessFullyPlacedPage=_OrderConfirmationPage.clickConfirmMyOrderButton();
			isOrderPlacedBoolean=_OrderSuccessFullyPlacedPage.checkingOrderIsPlaced();
			if(isOrderPlacedBoolean) {
				System.out.println("OrderPlacedSuccessFully");
				extentTestCaseOfOrderSuccessfullPage.log(Status.PASS, "Order Placed Page Test Successfully Completed");
			}
		} catch (Exception e) {
			System.out.println("error from paymentPageofShoppingCartPage in shippingPageOfShoppingCart"+e.getMessage());
			extentTestCaseOfOrderSuccessfullPage.log(Status.FAIL, "Order Placed successfully placed page Test Failed");
		}
	}
	
	
	

}
