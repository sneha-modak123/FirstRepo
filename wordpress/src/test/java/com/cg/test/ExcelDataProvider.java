package com.cg.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cg.base.TestBase;
import com.cg.util.ExcelUtil;
import com.cg.util.ExtentReport;
import com.cg.util.ExtentReportDemo2;
import com.cg.util.UtilityShot;

public class ExcelDataProvider extends TestBase{
	
	TestBase Base;
	public ExcelDataProvider() {
		init();

		
	 
	}
	@Test(dataProvider= "test1data")
	public void test1(String username, String password) throws InterruptedException, IOException
	{
		
		System.out.println(username+" | " +password);
		
		driver.findElement(By.id("user_login")).sendKeys(username);
		driver.findElement(By.id("user_pass")).sendKeys(password);
		driver.findElement(By.id("wp-submit")).submit();
		Thread.sleep(5000);
		WebElement error=driver.findElement(By.id("login_error"));
		Assert.assertTrue(error.getText().contains("Invalid username"));
		/*UtilityShot shot = new UtilityShot();
		shot.takescreenshot("before12 submit");
		driver.findElement(By.id("wp-submit")).submit();
		Thread.sleep(2000);
		shot.takescreenshot("after12 submit");
		ExtentReport obj= new ExtentReport();
		obj.report();*/
		
	}
	
	@DataProvider(name= "test1data")
	public Object[][] getData() throws IOException {
		
		String excelPath= "C:\\Users\\snehajos\\eclipse-workspace\\wordpress\\Excel\\data.xlsx";
		
				Object data[][]= testData(excelPath, "Sheet1");
		return data;
		
	}
	
	
	public static Object[][] testData(String excelPath,String sheetName) throws IOException {
		
		
	ExcelUtil excel= new ExcelUtil(excelPath,sheetName);
	
	int rowCount = excel.getRowCount();
	int colCount= excel.getcolCount();
	Object data[][]=new Object[rowCount-1] [colCount];
	
	for(int i=1;  i<rowCount; i++)
	{
	    for(int j=0; j<colCount; j++) {
	
	    String cellData= excel.getCellDataString(i, j);
	   // System.out.println(cellData+" ");
	    data[i-1][j] = cellData;
	    
	    
	    }
	    System.out.println();
	    
}return data;
	
}
	
}