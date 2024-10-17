package applicationlayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage 
{
@FindBy(xpath = "//a[@id = 'logout']")
WebElement logoutClick;
public void adminlogout()
{
	logoutClick.click();
	
}
	
	
	
	
	

}
