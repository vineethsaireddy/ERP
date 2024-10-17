package driverFactory;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import applicationlayer.SupplierPage;
import config.AppUtil;
import config.AppUtil1;
import utilities.ExcelFileUtil;

public class TestScript extends AppUtil1{
String inputpath = "./FileInput/SupplierData.xlsx";
String outputpath = "./FileOutput/SupplierResult.xlsx";
ExtentReports reports;
ExtentTest logger;
String TCsheet = "Supplier";	
@Test
public void startTest() throws Throwable
{
	ExcelFileUtil xl = new ExcelFileUtil(inputpath);
	int rc = xl.rowcount(TCsheet);
	Reporter.log("No of rows are::"+rc,true);
	for(int i=1;i<=rc;i++)
	{
		String sname = xl.getCellData(TCsheet, i, 0);
		String Address = xl.getCellData(TCsheet, i, 1);
		String city = xl.getCellData(TCsheet, i, 2);
		String country = xl.getCellData(TCsheet, i, 3);
		String cperson = xl.getCellData(TCsheet, i, 4);
		String pnumber = xl.getCellData(TCsheet, i, 5);
		String email = xl.getCellData(TCsheet, i, 6);
		String mnumber = xl.getCellData(TCsheet, i, 7);
		String notes = xl.getCellData(TCsheet, i, 8);

		SupplierPage sup = PageFactory.initElements(driver, SupplierPage.class);
        boolean res = sup.addSupplier(sname, Address, city, country, cperson, pnumber, email, mnumber, notes);
		if(res)
		{
			xl.setCellData(TCsheet, i, 9,"pass",outputpath);	
		}else
		{
			xl.setCellData(TCsheet, i, 9, "Fail", outputpath);
		}	
	}}
	
public static void add()
{
	int a = 100,b=200,c;
	c=a+b;
	System.out.println(c);
	
	
}
	
	
	
	
}
	
	
	
	


