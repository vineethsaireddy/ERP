package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.helpers.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AppUtil 
{
	public static WebDriver driver;
	public static Properties pro;
	
@BeforeTest
public static void setUp() throws Throwable, Throwable
{	
	pro = new Properties();
	//load property file
	pro.load(new FileInputStream("./PropertyFiles/Environment.properties"));
	if(pro.getProperty("Browser").equalsIgnoreCase("chrome"))
			{
		       driver = new ChromeDriver();
		       driver.manage().window().maximize();		
			}
	else if(pro.getProperty("Browser").equalsIgnoreCase("firefox")) 
	{
		driver = new FirefoxDriver();
	}
//	else
//	{
//	    Reporter.	
//	}	
}
	
@AfterTest
public static void teardown()
{
	driver.quit();
}
	
	
	
	
	
	

}
