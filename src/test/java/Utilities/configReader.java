package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configReader {
	private static Properties prop;
	
	public static void loadConfig() throws IOException
	{
		FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
		prop = new Properties();
		prop.load(fis);
	}
	
	public static String get(String key)
	{
		return prop.getProperty(key);
	}

}
