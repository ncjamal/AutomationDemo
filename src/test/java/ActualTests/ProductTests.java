package ActualTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Base.BaseTest;
import Pages.LoginPage;
import Pages.ProductPage;
import Utilities.ExcelUtil;

public class ProductTests extends BaseTest
{
	@Test(priority=1)
	public void AddOneProductCart()
	{
		String uname = ExcelUtil.GetData(DataPath, "Credentials", 1, 0);
		String Pass = ExcelUtil.GetData(DataPath, "Credentials", 1, 1);
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.LoginInput(uname, Pass);
		loginPage.ClickLogin();
		
		ProductPage PP = new ProductPage(driver);
		Assert.assertTrue(PP.isProductPageDisplayed(), "Add one product: Step 1 failed: Product page is not displayed");
		PP.AddBackPackToCart();
		
		Assert.assertTrue(PP.CheckCartCount(1), "Add one product: Step 2 failed: Cart icon count mismatch on product page");		
	}
	@Test(priority=2)
	public void AddMultProductToCart()
	{
		String uname = ExcelUtil.GetData(DataPath, "Credentials", 1, 0);
		String Pass = ExcelUtil.GetData(DataPath, "Credentials", 1, 1);
		
		LoginPage LP = new LoginPage(driver);
		LP.LoginInput(uname, Pass);
		LP.ClickLogin();
		
		ProductPage PP = new ProductPage(driver);
		Assert.assertTrue(PP.isProductPageDisplayed(), "Add mul product: Step 1 failed: Product page is not displayed");
		PP.AddBackPackToCart();
		PP.AddBikeLightToCart();
		
		Assert.assertTrue(PP.CheckCartCount(2), "Add mul product: step 2 failed: Cart icon count mismatch on product page");
	}
	@Test(priority=3)
	public void RemoveProductFromCart()
	{
		String uname = ExcelUtil.GetData(DataPath, "Credentials", 1, 0);
		String Pass = ExcelUtil.GetData(DataPath, "Credentials", 1, 1);
		
		LoginPage LP = new LoginPage(driver);
		LP.LoginInput(uname, Pass);
		LP.ClickLogin();
		
		ProductPage PP = new ProductPage(driver);
		Assert.assertTrue(PP.isProductPageDisplayed(), "Remove product: step 1 failed: Product page is not displayed");
		PP.AddBackPackToCart();
		PP.RemoveFromCart("Sauce Labs Backpack");
		PP.RemoveFromCart("Sauce Labs Bike Light");
		Assert.assertTrue(PP.CheckCartCount(0), "Remove Product: step 2 failed: The cart is not empty");		
	}
	@Test(priority=4)
	public void SortProductBy()
	{
		String uname = ExcelUtil.GetData(DataPath, "Credentials", 1, 0);
		String Pass = ExcelUtil.GetData(DataPath, "Credentials", 1, 1);
		
		LoginPage LP = new LoginPage(driver);
		LP.LoginInput(uname, Pass);
		LP.ClickLogin();
		
		ProductPage PP = new ProductPage(driver);
		Assert.assertTrue(PP.isProductPageDisplayed(), "Sort product: step 1 failed: Product page is not displayed");
		PP.SortProduct("Price (high to low)");	//Name (A to Z); Name (Z to A); Price (low to high); Price (high to low)
	}
}
