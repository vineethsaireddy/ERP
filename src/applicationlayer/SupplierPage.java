package applicationlayer;

import java.awt.Desktop.Action;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.slf4j.helpers.Reporter;

public class SupplierPage 
{
WebDriver driver;
public SupplierPage(WebDriver driver)
{
	this.driver=driver;
		
}

@FindBy(xpath = "//div/ul[1]/li[3]/a")
WebElement ClickSupplier;
@FindBy(xpath = "(//span[@data-caption = 'Add'])[1]")
WebElement ClickAddIcon;
@FindBy(xpath = "//input[@id = 'x_Supplier_Number']")
WebElement SupplierNumber;
@FindBy(xpath = "//input[@id = 'x_Supplier_Name']")
WebElement SupplierName;
@FindBy(xpath = "//textarea[@name = 'x_Address']")
WebElement Address;
@FindBy(xpath = "//input[@id = 'x_City']")
WebElement City;
@FindBy(xpath = "//input[@id = 'x_Country']")
WebElement Country;
@FindBy(xpath = "//input[@id = 'x_Contact_Person']")
WebElement Contactperson;
@FindBy(xpath = "//input[@id = 'x_Phone_Number']")
WebElement Phonenumber;
@FindBy(xpath = "//input[@id = 'x__Email']")
WebElement Email;
@FindBy(xpath = "//input[@name = 'x_Mobile_Number']")
WebElement Mobilenumber;
@FindBy(xpath = "//input[@id = 'x_Notes']")
WebElement Notes;
@FindBy(id = "btnAction")
WebElement ClickAddButton;

@FindBy(xpath = "//span[@data-caption = 'Search']")
WebElement SearchPanel;
@FindBy(xpath = "//input[@name = 'psearch']")
WebElement SearchTextbox;
@FindBy(xpath = "//button[@id = 'btnsubmit']")
WebElement SearchButton;
@FindBy(xpath = "//table[@class = 'table ewTable']/tbody/tr[1]/td[6]/div/span")
WebElement webtable;


//method for supplier creation
public boolean addSupplier(String Suppliername,String Address,String City,String Country,
String ContactPerson,String Phonenumber,String Email,String MobileNumber,String Notes) throws Throwable
{
	
	Actions act = new Actions(driver);
	act.moveToElement(this.ClickSupplier).click().perform();
	Thread.sleep(2000);
	act.moveToElement(ClickAddIcon).click().perform();
	Thread.sleep(2000);
	
	String Expdata = this.SupplierNumber.getAttribute("value");
	this.SupplierName.sendKeys(Suppliername);
	this.Address.sendKeys(Address);
	this.City.sendKeys(City);
	this.Country.sendKeys(Country);
	this.Contactperson.sendKeys(ContactPerson);
	this.Phonenumber.sendKeys(Phonenumber);
	this.Email.sendKeys(Email);
	this.Mobilenumber.sendKeys(MobileNumber);
	this.Notes.sendKeys(Notes);
	this.ClickAddButton.sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	
	
	
	if(!this.SearchTextbox.isDisplayed())
	    this.SearchPanel.click();
	this.SearchTextbox.clear();
	this.SearchTextbox.sendKeys(Expdata);	
	this.SearchButton.click();
    Thread.sleep(3000);
	
	String Actdata = webtable.getText();
			if(Actdata.equals(Expdata))
			{
				org.testng.Reporter.log("Add supplier is success");
				return true;	
			}else
				org.testng.Reporter.log("Add supplier is fail");
	            return false;
	
}










}







