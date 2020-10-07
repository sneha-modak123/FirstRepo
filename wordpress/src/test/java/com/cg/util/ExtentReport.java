package com.cg.util;


import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cg.base.TestBase;


public class ExtentReport{

	

	public void report()
	{
	//ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reportsnew/wordpress.html");
		System.out.println("Login to Wordpress");
	ExtentHtmlReporter htmlreporter= new ExtentHtmlReporter("./Reportsnew/wordpress.html") ;
	ExtentReports extent= new ExtentReports();
	extent.attachReporter(htmlreporter);
	ExtentTest logger=extent.createTest("Wordpress Login");
	logger.log(Status.INFO, "Login to Wordpress");
	logger.log(Status.PASS,"Verified" );
	
	extent.flush();
	
	
}

}