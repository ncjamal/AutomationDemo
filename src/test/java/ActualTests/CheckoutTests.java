package ActualTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.CartPage;
import Pages.CheckoutOverviewPage;
import Pages.CheckoutPage;
import Pages.LoginPage;
import Pages.ProductPage;
import Utilities.ExcelUtil;

public class CheckoutTests extends BaseTest {
	@Test(priority=1)
	public void SubmitDetails()
	{
		String uname = ExcelUtil.GetData(DataPath, "Credentials", 1, 0);
		String Pass = ExcelUtil.GetData(DataPath, "Credentials", 1, 1);
		
		LoginPage LP = new LoginPage(driver);
		LP.LoginInput(uname, Pass);
		LP.ClickLogin();
		
		ProductPage PP = new ProductPage(driver);
		Assert.assertTrue(PP.isProductPageDisplayed(), "Submit checkout page: Step-1: Product page is not desplayed");
		PP.AddBackPackToCart();
		PP.AddBikeLightToCart();
		Assert.assertTrue(PP.CheckCartCount(2), "Submit checkout page: Step-2:Cart icon mismatch on Product page");
		PP.ClickOnCart();
		
		CartPage CP = new CartPage(driver);
		Assert.assertTrue(CP.isCartPageDisplayed(), "Submit checkout page: Step-3: Cart page is not displayed");
		Assert.assertTrue(PP.CheckCartCount(2), "Submit checkout page: Step-4: Cart page cart icon mismatch");
		CP.ClickOnCheckout();
		
		CheckoutPage Checkout = new CheckoutPage(driver);
		Assert.assertTrue(Checkout.isCheckoutPageDisplayed(), "Submit checkout page: Step-5: Checkout page is not displayed");	
		Checkout.SubmitCheckoutDetails("Sana", "Fatma", "274502");
		
		CheckoutOverviewPage OP=new CheckoutOverviewPage(driver);
		Assert.assertTrue(OP.isCheckoutOverviewPage(), "Submit checkout page: Step-6: Checkout overview page is not displayed");
	}
	
	@Test(priority=2)
	public void CancelCheckOut() throws IOException
	{
		String uname = ExcelUtil.GetData(DataPath, "Credentials", 1, 0);
		String Pass = ExcelUtil.GetData(DataPath, "Credentials", 1, 1);
		
		LoginPage LP = new LoginPage(driver);
		LP.LoginInput(uname, Pass);
		LP.ClickLogin();
		
		ProductPage PP = new ProductPage(driver);
		Assert.assertTrue(PP.isProductPageDisplayed(), "Cancel checkout- step-1: Product page is not displayed");
		PP.AddBackPackToCart();
		PP.AddBikeLightToCart();
		Assert.assertTrue(PP.CheckCartCount(2), "Cancel checkout- step-2: Product page cart icon mismatch");
		PP.ClickOnCart();
		
		CartPage CP = new CartPage(driver);
		Assert.assertTrue(CP.isCartPageDisplayed(), "Cancel checkout- step-3: cart page is not displayed");
		Assert.assertTrue(PP.CheckCartCount(2), "Cancel checkout- step-4: cart page icon mismatch");
		CP.ClickOnCheckout();
		
		CheckoutPage Checkout=new CheckoutPage(driver);
		Assert.assertTrue(Checkout.isCheckoutPageDisplayed(), "Cancel checkout- step-4: Checkout page is not displayed");
		Checkout.CancelCheckout();
		Assert.assertTrue(CP.isCartPageDisplayed(), "Cancel checkout- step-4: Cart page is not displayed");
	}
}
