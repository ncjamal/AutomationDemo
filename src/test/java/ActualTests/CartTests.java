package ActualTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Base.BaseTest;
import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.LoginPage;
import Pages.ProductPage;
import Utilities.ExcelUtil;

public class CartTests extends BaseTest
{
	@Test(priority=1)
	public void NavigateToCart()
	{
		String uname=ExcelUtil.GetData(DataPath, "Credentials", 1, 0);
		String Pass = ExcelUtil.GetData(DataPath, "Credentials", 1, 1);
		
		LoginPage LP=new LoginPage(driver);
		LP.LoginInput(uname, Pass);
		LP.ClickLogin();
		
		ProductPage PP = new ProductPage(driver);
		Assert.assertTrue(PP.isProductPageDisplayed(), "Navigate to cart: Step 1 failed: Product page is not displayed");
		PP.AddBackPackToCart();
		PP.AddBikeLightToCart();
		Assert.assertTrue(PP.CheckCartCount(2), "Navigate to cart: Step 2 failed: Cart count mismatch on product page");
		PP.ClickOnCart();
				
		CartPage CP = new CartPage(driver);
		Assert.assertTrue(CP.isCartPageDisplayed(), "Navigate to Cart: Step 3 failed: Cart page is not displayed");
	}
	@Test(priority=2)
	public void VerifyProductInCart()
	{
		String uname=ExcelUtil.GetData(DataPath, "Credentials", 1, 0);
		String Pass = ExcelUtil.GetData(DataPath, "Credentials", 1, 1);
		
		LoginPage LP=new LoginPage(driver);
		LP.LoginInput(uname, Pass);
		LP.ClickLogin();
		
		ProductPage PP = new ProductPage(driver);
		Assert.assertTrue(PP.isProductPageDisplayed(), "Verify product in cart: Step 1 failed: Product page is not displayed");
		PP.AddBackPackToCart();
		PP.AddBikeLightToCart();
		Assert.assertTrue(PP.CheckCartCount(2), "Verify product in cart: Step 2 failed: Cart count mismatch on product page");
		PP.ClickOnCart();
				
		CartPage CP = new CartPage(driver);
		Assert.assertTrue(CP.isCartPageDisplayed(), "Verify product in cart: Step 3 failed: Cart page is not displayed");
		Assert.assertTrue(PP.CheckCartCount(2), "Verify product in cart: Step 4 failed: cart count mismatch on cart page");
	}
	@Test(priority=3)
	public void RemoveProductFromCart()
	{
		String uname=ExcelUtil.GetData(DataPath, "Credentials", 1, 0);
		String Pass = ExcelUtil.GetData(DataPath, "Credentials", 1, 1);
		
		LoginPage LP=new LoginPage(driver);
		LP.LoginInput(uname, Pass);
		LP.ClickLogin();
		
		ProductPage PP = new ProductPage(driver);
		Assert.assertTrue(PP.isProductPageDisplayed(), "Remove product from cart: Step 1 failed: Product page is not displayed");
		PP.AddBackPackToCart();
		PP.AddBikeLightToCart();
		Assert.assertTrue(PP.CheckCartCount(2), "Remove product from cart: Step 2 failed: Cart count mismatch on product page");
		PP.ClickOnCart();
				
		CartPage CP = new CartPage(driver);
		Assert.assertTrue(CP.isCartPageDisplayed(), "Remove product from cart: Step 3 failed: Cart page is not displayed");
		PP.RemoveFromCart("Sauce Labs Bike Light");
		Assert.assertTrue(PP.CheckCartCount(1), "Remove product from cart: Step 4 failed: cart count mismatch on cart page");
	}
	@Test(priority=4)
	public void ClickCheckout()
	{
		String uname=ExcelUtil.GetData(DataPath, "Credentials", 1, 0);
		String Pass = ExcelUtil.GetData(DataPath, "Credentials", 1, 1);
		
		LoginPage LP=new LoginPage(driver);
		LP.LoginInput(uname, Pass);
		LP.ClickLogin();
		
		ProductPage PP = new ProductPage(driver);
		Assert.assertTrue(PP.isProductPageDisplayed(), "Click checkout: Step 1 failed: Product page is not displayed");
		PP.AddBackPackToCart();
		PP.AddBikeLightToCart();
		Assert.assertTrue(PP.CheckCartCount(2), "Click checkout: Step 2 failed: Cart count mismatch on product page");
		PP.ClickOnCart();
				
		CartPage CP = new CartPage(driver);
		Assert.assertTrue(CP.isCartPageDisplayed(), "Click checkout: Step 3 failed: Cart page is not displayed");
		CP.ClickOnCheckout();
		
		CheckoutPage ChkP = new CheckoutPage(driver);
		Assert.assertTrue(ChkP.isCheckoutPageDisplayed(), "Click checkout: Step 4 failed: Checkout page is not displayed");
	}
	@Test(priority=5)
	public void ClickContinueShopping()
	{
		String uname=ExcelUtil.GetData(DataPath, "Credentials", 1, 0);
		String Pass = ExcelUtil.GetData(DataPath, "Credentials", 1, 1);
		
		LoginPage LP=new LoginPage(driver);
		LP.LoginInput(uname, Pass);
		LP.ClickLogin();
		
		ProductPage PP = new ProductPage(driver);
		Assert.assertTrue(PP.isProductPageDisplayed(), "Click continue shopping: Step 1 failed: Product page is not displayed");
		PP.AddBackPackToCart();
		PP.AddBikeLightToCart();
		PP.ClickOnCart();
				
		CartPage CP = new CartPage(driver);
		Assert.assertTrue(CP.isCartPageDisplayed(), "Clcik continue shopping: Step 2 failed: Cart page is not displayed");
		CP.ContinueShopClick();
		Assert.assertTrue(PP.isProductPageDisplayed(), "Click continue shopping: Step 3 failed: is not navigated back to product page");
	}
}
