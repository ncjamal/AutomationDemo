package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ExplicitWait;

public class CheckoutComplete {
	WebDriver driver;
	ExplicitWait wait;
	public CheckoutComplete(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new ExplicitWait(driver);
	}
	@FindBy(xpath="//span[text()='Checkout: Complete!']")
	WebElement ChkCompletePgTitle;
	
	@FindBy(xpath="//h2[text()='Thank you for your order!']")
	WebElement ThankYouText;
	
	@FindBy(xpath="//button[text()='Back Home']")
	WebElement BackHomeBtn;
	
	public boolean isCheckoutCompletePage()
	{
		return ChkCompletePgTitle.getText().equals("Checkout: Complete!");
	}
	public String ThankYouOrder()
	{
		return ThankYouText.getText();
	}
	public void ClickBackHomeBtn()
	{
		BackHomeBtn.click();
	}
	

}
