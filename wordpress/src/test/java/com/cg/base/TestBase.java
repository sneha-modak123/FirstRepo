package com.cg.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.cg.exception.InvallidBrowserException;



public class TestBase {
	public static WebDriver driver;
	 public static Properties properties;
	


	public TestBase()
	{
		properties=new Properties();
		try {
			properties.load(new FileInputStream("com.cg.config\\config.properties"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void init()
	{
		String browser=properties.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else if(browser.equalsIgnoreCase("ff"))
		{
			System.setProperty("webdriver.gecko.driver", "driver//firefoxdriver.exe");
			driver=new FirefoxDriver();
			
		}
		else
		{
			try {
				throw new InvallidBrowserException("Browser is not matching");
			} catch (InvallidBrowserException e) {
				e.printStackTrace();
			}
		}
		
		driver.manage().window().maximize();
		driver.get(properties.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
	}
	
	 

}


