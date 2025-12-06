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

public class CheckoutCompleteTests extends BaseTest {
	@Test
	public void ClickBackHome()
	{
		String uname = ExcelUtil.GetData(DataPath, "Credentials", 1, 0);
		String Pass = ExcelUtil.GetData(DataPath, "Credentials", 1, 1);
		
		LoginPage LP = new LoginPage(driver);
		LP.LoginInput(uname, Pass);
		LP.ClickLogin();
		
		ProductPage PP = new ProductPage(driver);
		Assert.assertTrue(PP.isProductPageDisplayed(), "Click back home: Step-1: Product page is not displayed");
		PP.AddBackPackToCart();
		PP.AddBikeLightToCart();
		Assert.assertTrue(PP.CheckCartCount(2), "Click back home: Step-2: Cart icon mismatch on Product page");
		PP.ClickOnCart();
		
		CartPage CP = new CartPage(driver);
		Assert.assertTrue(CP.isCartPageDisplayed(), "Click back home: Step-3: Cart page is not displayed");
		//Assert.assertEquals(PP.CheckCartCount(2), 2, "Cart icon mismatch on cart page - Checkout complete test case");
		CP.ClickOnCheckout();
		
		CheckoutPage Checkout = new CheckoutPage(driver);
		Assert.assertTrue(Checkout.isCheckoutPageDisplayed(), "Click back home: Step-4: Checkout page is not displayed");	
		Checkout.SubmitCheckoutDetails("Sana", "Fatma", "274502");
		
		CheckoutOverviewPage OP=new CheckoutOverviewPage(driver);
		Assert.assertTrue(OP.isCheckoutOverviewPage(), "Click back home: Step-5: Checkout overview page is not displayed");
		OP.ClickFinishBtn();
		
		CheckoutComplete CC= new CheckoutComplete(driver);
		Assert.assertTrue(CC.isCheckoutCompletePage(), "Click back home: Step-6: Checkout Complete page is not displayed");
		System.out.println(CC.ThankYouOrder());
		CC.ClickBackHomeBtn();
		Assert.assertTrue(PP.isProductPageDisplayed(), "Product page is not displayed");
	}
}
