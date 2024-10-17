package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import applicationlayer.Loginpage;
import applicationlayer.LogoutPage;

public class AppUtil1 
{
	public static WebDriver driver;
	public static Properties pro;
	
@BeforeTest
public static void setup() throws FileNotFoundException, IOException
{
	pro = new Properties();
	pro.load(new FileInputStream("./PropertyFiles/Environment.properties"));
	if(pro.getProperty("Browser").equalsIgnoreCase("chrome"))
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(pro.getProperty("Url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Loginpage login = PageFactory.initElements(driver, Loginpage.class);
		
	//call login method
		login.adminlogin("admin", "master");
	}else if(pro.getProperty("Browser").equalsIgnoreCase("firefox"))
{
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(pro.getProperty("Url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Loginpage login = PageFactory.initElements(driver, Loginpage.class);	
		login.adminlogin("admin", "master");

		
}	
	
}
@AfterTest
public static void tearDown()
{
	LogoutPage logout = PageFactory.initElements(driver, LogoutPage.class);
	logout.adminlogout();
	driver.quit();
	
	
}	

}
