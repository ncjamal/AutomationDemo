package Base;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import Utilities.BrowserFactory;
import Utilities.configReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
	protected WebDriver driver;
	protected String Path;
	protected String DataPath;
	//protected String Browser;
	protected String URL;
	
	@Parameters("browser")
	@BeforeMethod
	public void Setup(String browser) throws IOException
	{
		configReader.loadConfig();
		//Browser = configReader.get("browser");
		 URL = configReader.get("URL");
		 Path = configReader.get("ExcelPath");
		 DataPath =System.getProperty("user.dir") + Path;
		
		 driver = BrowserFactory.getDriver(browser);
//		ChromeOptions option=new ChromeOptions();
//		option.addArguments("--incognito");
//		driver = new ChromeDriver(option);
	
		driver.get(URL);
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void TearDown()
	{
//if(driver!=null)
//{
//		driver.close();
//}
	}
	
}
