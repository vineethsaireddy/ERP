package applicationlayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage 
{
  //Define repository for login
	@FindBy(xpath = "//button[@name = 'btnreset']")
	WebElement ObjReset;
	@FindBy(id = "username")
	WebElement Objuser;
	@FindBy(name = "password")
	WebElement Objpass;
	@FindBy(xpath = "//button[@name = 'btnsubmit']")
	WebElement ObjLogin;
	
   //write method to perform action
	public void adminlogin(String user,String pass)
	{
		ObjReset.click();
        Objuser.sendKeys(user);
		Objpass.sendKeys(pass);
		ObjLogin.click();
		
		
		
	}
	
	
	
	
	}
