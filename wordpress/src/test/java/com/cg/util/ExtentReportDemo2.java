package com.cg.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cg.base.TestBase;
import com.cg.test.ExcelDataProvider;

public class ExtentReportDemo2 extends TestBase{
	ExtentReports extent;
	ExtentTest logger;
	
	@BeforeMethod
	public void setup() {
		
		ExtentHtmlReporter htmlreporter= new ExtentHtmlReporter("./Reportsnew/wordpress.html") ;
		extent= new ExtentReports();
		extent.attachReporter(htmlreporter);
		logger=extent.createTest("Wordpress Login");

	}
	
	@AfterMethod()
	public void tearDown(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			UtilityShot shot = new UtilityShot();
			String temp=shot.takescreenshot("before1 submit");
			logger.fail(result.getThrowable().getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			
		}
		extent.flush();
	
	}
		
	
@Test
public void Login() throws InterruptedException
{   	
	init();
	String projectPath = System.getProperty("user.dir");
   ExcelUtil excel = new ExcelUtil(projectPath+ "/Excel/data.xlsx" ,"Sheet1");

	driver.findElement(By.id("user_login")).sendKeys(excel.getCellDataString(1, 0));
	driver.findElement(By.id("user_pass")).sendKeys(excel.getCellDataString(1, 1));
	driver.findElement(By.id("wp-submit")).submit();
	String title= driver.getTitle();
	System.out.println(title);
	Assert.assertEquals(title, "Log In");
	
	
	
}
	}
	

