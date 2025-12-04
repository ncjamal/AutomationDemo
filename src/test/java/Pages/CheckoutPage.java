package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ExplicitWait;

public class CheckoutPage {
	WebDriver driver;
	ExplicitWait wait;
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new ExplicitWait(driver);
	}
	
	@FindBy(xpath="//span[text()='Checkout: Your Information']")
	WebElement CheckoutPageTitle;
	
	@FindBy(xpath="//input[@id ='first-name']")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@id='last-name']")
	WebElement LastName;
	
	@FindBy(xpath="//input[@id ='postal-code']")
	WebElement PinCode;

	@FindBy(xpath="//input[@id = 'continue']")
	WebElement SubmittBtn;
	
	@FindBy(xpath="//button[@id='cancel']")
	WebElement CheckoutCancel;
	
	public boolean isCheckoutPageDisplayed()
	{
		return CheckoutPageTitle.getText().equals("Checkout: Your Information");
	}
	public void SubmitCheckoutDetails(String fname, String lname, String pincode)
	{
		FirstName.sendKeys("fname");
		LastName.sendKeys("lname");
		PinCode.sendKeys("pincode");
		SubmittBtn.click();	
	}
	public void CancelCheckout()
	{
		CheckoutCancel.click();
	}
	
	
	
	
	

}
