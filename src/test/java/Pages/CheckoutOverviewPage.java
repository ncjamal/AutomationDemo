package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ExplicitWait;

public class CheckoutOverviewPage {
	WebDriver driver;
	ExplicitWait wait;
	
	public CheckoutOverviewPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new ExplicitWait(driver);
	}
	@FindBy(xpath="//span[text()='Checkout: Overview']")
	WebElement ChkoutOverviewTitle;
	
	@FindBy(xpath="//button[text()='Finish']")
	WebElement FinishBtn;
	
	@FindBy(xpath="//button[@id='cancel']")
	WebElement CancelBtn;
	
	public boolean isCheckoutOverviewPage()
	{
		return ChkoutOverviewTitle.getText().equals("Checkout: Overview");
	}
	public void ClickFinishBtn()
	{
		FinishBtn.click();
	}
	public void ClickCancelBtn()
	{
		CancelBtn.click();
	}

}
