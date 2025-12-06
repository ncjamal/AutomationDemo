package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ExplicitWait;

public class CartPage {
	WebDriver driver;
	ExplicitWait wait;
	
	@FindBy(xpath="//span[text()='Your Cart']")
	WebElement CartPageTitle;
	
	@FindBy(xpath="//button[@id='checkout']")
	WebElement CheckOutBtn;
	
	@FindBy(xpath="//button[@id='continue-shopping']")
	WebElement ContinueShopBtn;
	
	public CartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new ExplicitWait(driver);
	}
	public void ClickOnCheckout()
	{
		CheckOutBtn.click();
	}
	public void ContinueShopClick()
	{
		ContinueShopBtn.click();
	}
	public boolean isCartPageDisplayed()
	{
		return CartPageTitle.getText().equals("Your Cart");
	}
}
