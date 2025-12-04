package ActualTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.CartPage;
import Pages.CheckoutComplete;
import Pages.CheckoutOverviewPage;
import Pages.CheckoutPage;
import Pages.LoginPage;
import Pages.ProductPage;
import Utilities.ExcelUtil;

public class CheckoutOverviewTests extends BaseTest{
	@Test(priority=1)
	public void FinishCheckout()
	{
		String uname = ExcelUtil.GetData(DataPath, "Credentials", 1, 0);
		String Pass = ExcelUtil.GetData(DataPath, "Credentials", 1, 1);
		
		LoginPage LP = new LoginPage(driver);
		LP.LoginInput(uname, Pass);
		LP.ClickLogin();
		
		ProductPage PP = new ProductPage(driver);
		Assert.assertTrue(PP.isProductPageDisplayed(), "Finish checkout: Step 1 failed: Product page is not displayed");
		PP.AddBackPackToCart();
		PP.AddBikeLightToCart();
		Assert.assertTrue(PP.CheckCartCount(2), "Finish checkout: Step 2 failed: Product page cart icon mismatch");
		PP.ClickOnCart();
		
		CartPage CP = new CartPage(driver);
		Assert.assertTrue(CP.isCartPageDisplayed(), "Finish checkout: Step 3 failed: cart page is not displayed");
		//Assert.assertEquals(PP.CheckCartCount(), 2, "Cart icon mismatch on cart page - Finish checkout test case");
		CP.ClickOnCheckout();
		
		CheckoutPage Checkout = new CheckoutPage(driver);
		Assert.assertTrue(Checkout.isCheckoutPageDisplayed(), "Finish checkout: Step 4 failed: Checkout page is not displayed");	
		Checkout.SubmitCheckoutDetails("Sana", "Fatma", "274502");
		
		CheckoutOverviewPage OP=new CheckoutOverviewPage(driver);
		Assert.assertTrue(OP.isCheckoutOverviewPage(), "Finish checkout: Step 5 failed: Checkout overview page is not displayed");
		OP.ClickFinishBtn();
		
		CheckoutComplete CC= new CheckoutComplete(driver);
		Assert.assertTrue(CC.isCheckoutCompletePage(), "Finish checkout: Step 6 failed: Checkout complete page is not displayed");
		System.out.println(CC.ThankYouOrder());
	}
	@Test(priority=2)
	public void CancelTheOrder()
	{
		String uname = ExcelUtil.GetData(DataPath, "Credentials", 1, 0);
		String Pass = ExcelUtil.GetData(DataPath, "Credentials", 1, 1);
		
		LoginPage LP = new LoginPage(driver);
		LP.LoginInput(uname, Pass);
		LP.ClickLogin();
		
		ProductPage PP = new ProductPage(driver);
		Assert.assertTrue(PP.isProductPageDisplayed(), "Cancel Order: Step 1 failed: Product page is not displayed");
		PP.AddBackPackToCart();
		PP.AddBikeLightToCart();
		Assert.assertTrue(PP.CheckCartCount(2), "Cancel Order: Step 2 failed: Product page cart icon mismatch");
		PP.ClickOnCart();
		
		CartPage CP = new CartPage(driver);
		Assert.assertTrue(CP.isCartPageDisplayed(), "Cancel Order: Step 3 failed: Cart page is not displayed");
		Assert.assertTrue(PP.CheckCartCount(2), "Cancel Order: Step 4 failed: Cart page icon mismatch");
		CP.ClickOnCheckout();
		
		CheckoutPage Checkout = new CheckoutPage(driver);
		Assert.assertTrue(Checkout.isCheckoutPageDisplayed(), "Cancel Order: Step 5 failed: Checkout page is not displayed");	
		Checkout.SubmitCheckoutDetails("Sana", "Fatma", "274502");
		
		CheckoutOverviewPage OP=new CheckoutOverviewPage(driver);
		Assert.assertTrue(OP.isCheckoutOverviewPage(), "Cancel Order: Step 6 failed: Checkout overview page is not displayed");
		OP.ClickCancelBtn();
		Assert.assertTrue(PP.isProductPageDisplayed(), "Cancel Order: Step 7 failed: Product page is not displayed");
	}
}
