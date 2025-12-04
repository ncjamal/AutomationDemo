package Pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.ExplicitWait;

public class ProductPage {
	
	WebDriver driver;
	ExplicitWait waitUtil;
	
	public ProductPage(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
		waitUtil = new ExplicitWait(driver);
	}
	
	@FindBy(xpath = "//span[text()='Products']")
	WebElement ProductPageTitle;
	
	@FindBy(xpath="//button[contains(@data-test,'sauce-labs-backpack')]")
	WebElement Backpack;
	
	@FindBy(xpath="//button[contains(@data-test,'sauce-labs-bike-light')]")
	WebElement BikeLight;
	
	@FindBy(xpath="//select[contains(@data-test,'-sort-container')]")
	WebElement SortIcon;
	
	@FindBy(xpath="//a[@data-test='shopping-cart-link']")
	WebElement CartIcon;
	
	public void AddBackPackToCart()
	{
		if(Backpack.getText().equals("Add to cart"))
		{
			Backpack.click();
		}	
	}
	public void AddBikeLightToCart()
	{
		if(BikeLight.getText().equals("Add to cart"))
		{
			BikeLight.click();
		}
	}
	public void RemoveFromCart(String ProductName)
	{
		switch(ProductName)
		{
		case "Sauce Labs Backpack":
			Backpack.click();
		case "Sauce Labs Bike Light":
			BikeLight.click();
		}	
	}
	public boolean CheckCartCount(int ExpectedCount)
	{
		List<WebElement> CartCount = driver.findElements(By.cssSelector(".shopping_cart_badge"));
		if(CartCount.isEmpty())
		{
			return ExpectedCount == 0;
		}
		else
			 return Integer.parseInt(CartCount.get(0).getText()) == ExpectedCount;		
	}

	public boolean isProductPageDisplayed()
	{
		return ProductPageTitle.getText().equals("Products");
	}
	public void SortProduct(String SortWay)
	{
		Select SortDP = new Select(SortIcon);
		SortDP.selectByVisibleText(SortWay);
	}
	public void ClickOnCart()
	{
		CartIcon.click();
	}
}