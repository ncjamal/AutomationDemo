package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(xpath = "//h3[text()='Epic sadface: Username and password do not match any user in this service']")
	WebElement InvalidLoginText;
	
	@FindBy(xpath="//h3[text()='Epic sadface: Username is required']")
	WebElement EmptyLoginText;
	
	@FindBy(xpath="//input[@id='user-name']")
	WebElement UserName;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@id='login-button']")
	WebElement Login;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public boolean isInvalidLogin()
	{
		return InvalidLoginText.getText().equals("Epic sadface: Username and password do not match any user in this service");
	}
	public boolean isEmptyLogin()
	{
		return EmptyLoginText.getText().equals("Epic sadface: Username is required");
	}
	public void LoginInput(String uname, String pass)
	{
		UserName.sendKeys(uname);
		Password.sendKeys(pass);
		
	}
	public void ClickLogin()
	{
		Login.click();
	}
}
