package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileUtil 
{
XSSFWorkbook wb;


//creating constructor for reading excel path
public ExcelFileUtil(String excelpath) throws Throwable
{
	FileInputStream fi = new FileInputStream(excelpath);
	wb = new XSSFWorkbook(fi);	
}
//count no of rows in a sheet
public int rowcount(String sheetname)
{
	return wb.getSheet(sheetname).getLastRowNum();
}
//method for reading cell data
public String getCellData(String sheetname,int row,int column)
{
	String data="";
	if(wb.getSheet(sheetname).getRow(row).getCell(column).getCellType()==CellType.NUMERIC)
	{
		int celldata=(int)wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
		data = String.valueOf(celldata);	
	}
	else
	{
		data = wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
	}
	return data;	
}
//method for writing status into new wb
public void setCellData(String sheetname,int row,int column,String status,String writeExcel) throws Throwable
{
	//get sheet from wb
	XSSFSheet ws = wb.getSheet(sheetname);
	//get row from sheet
	XSSFRow rowNum = ws.getRow(row);
	//create cell
	XSSFCell cell = rowNum.createCell(column);
	cell.setCellValue(status);
	if(status.equalsIgnoreCase("pass"))
	{
		XSSFCellStyle style = wb.createCellStyle();
		XSSFFont font = wb.createFont();
		font.setColor(IndexedColors.GREEN.getIndex());
		font.setBold(true);
		style.setFont(font);
		rowNum.getCell(column).setCellStyle(style);
		
	}else if(status.equalsIgnoreCase("Fail"))
	{
		XSSFCellStyle style = wb.createCellStyle();
		XSSFFont font = wb.createFont();
		font.setColor(IndexedColors.RED.getIndex());
		font.setBold(true);
		style.setFont(font);
		rowNum.getCell(column).setCellStyle(style);
		
	}else if (status.equalsIgnoreCase("Blocked"))
	{
		XSSFCellStyle style = wb.createCellStyle();
		XSSFFont font = wb.createFont();
		font.setColor(IndexedColors.BLUE.getIndex());
		font.setBold(true);
		style.setFont(font);
		rowNum.getCell(column).setCellStyle(style);
		
	}
	
	FileOutputStream fo = new FileOutputStream(writeExcel);
	wb.write(fo);
		
}

public static void main(String[] args) throws Throwable 
{
	
	
	ExcelFileUtil xl = new ExcelFileUtil("D:/Sample.xlsx");
	int rc = xl.rowcount("Emp");
	System.out.println(rc);
	
	for(int i=1;i<=rc;i++)
	{
		String fname = xl.getCellData("Emp", i, 0);
		String mname = xl.getCellData("Emp", i, 1);
		String lname = xl.getCellData("Emp", i, 2);
		String Empid = xl.getCellData("Emp", i, 3);

		System.out.println(fname+" "+mname+" "+lname+" "+Empid);
		
//	    xl.setCellData("emp", i, 4, "pass", "D:/Results.xlsx");
	    xl.setCellData("Emp", i, 4, "Fail", "D:/Results.xlsx");

		
	}
	
	
	
}






}
