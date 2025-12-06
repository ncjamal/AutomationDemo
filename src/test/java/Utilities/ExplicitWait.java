package Utilities;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait 
{
	WebDriver driver;
	WebDriverWait wait;
	
	public ExplicitWait(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	public WebElement WaitForVisibility(WebElement element)
	{
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	public WebElement WaitForClickable(WebElement element)
	{
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

}
