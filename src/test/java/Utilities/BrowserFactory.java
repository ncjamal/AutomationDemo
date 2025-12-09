package Utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	public static WebDriver getBrowser(String browser) throws IOException
	{
		 configReader.loadConfig();
		 browser = System.getProperty("browser", configReader.get("browser")); //default is chrome
		 boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false")); //dafault is non-headless
		 
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions option = new ChromeOptions();
			
			if(headless)
			{
				option.addArguments("--headless");
			}
			
			option.addArguments("--incognito");
			option.addArguments("--no-sandbox");
			option.addArguments("--disable-dev-shm-usage");
			
			return new ChromeDriver(option);
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions option = new FirefoxOptions();
			
			if(headless)
			{
				option.addArguments("--headless");
			}
			
			//option.addArguments("--private");
			return new FirefoxDriver(option);
		}
		else if (browser.equalsIgnoreCase("ie"))
		{
			WebDriverManager.iedriver().setup();
			//System.setProperty("webdriver.edge.driver", "Drivers/msedgedriver.exe");
			//IeOptions option = new EdgeOptions();
			//option.addArguments("--inprivate");
			return new InternetExplorerDriver();
		}
		else
		{
		throw new RuntimeException("Unsupported browser: " + browser);
		}
	}

}
