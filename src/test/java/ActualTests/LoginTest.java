package ActualTests;
import Base.BaseTest;
import Pages.LoginPage;
import Pages.ProductPage;
import Utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends BaseTest
{
	@Test(priority=1)
	public void ValidLogin() //Valid Login Test case
	{
		String UserId = ExcelUtil.GetData(DataPath, "Credentials", 1, 0); //call method to read username
		String Password = ExcelUtil.GetData(DataPath, "Credentials", 1, 1); //call method to read password
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.LoginInput(UserId,Password);
		loginPage.ClickLogin();
		
		ProductPage PP = new ProductPage(driver);
		Assert.assertTrue(PP.isProductPageDisplayed(), "Valid login test case failed");
	}
	@Test (priority=2)
	public void InvalidLogin()  //This test case is to check for incorrect credential supplied
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.LoginInput("Wrong", "wrong");
		loginPage.ClickLogin();
		Assert.assertTrue(loginPage.isInvalidLogin(), "The Invalid login test case failed");
	}
	@Test(priority=3)
	public void EmptyLogin()
	{
		LoginPage loginPage=new LoginPage(driver);
		loginPage.LoginInput("", "");
		loginPage.ClickLogin();
		Assert.assertTrue(loginPage.isEmptyLogin(), "The Empty Login test case failed");
	}
}
