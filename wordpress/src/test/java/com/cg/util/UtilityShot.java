package com.cg.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import com.cg.base.TestBase;
public class UtilityShot  extends TestBase{
	
	
	public static String takescreenshot(String screenshotname)   
	{
		

		// Take a PAGE ScreenShot and set the output as FILE type
					File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					// store the screenshot to your local machine
					String path= System.getProperty("user.dir")+"/ScreenShots/"+ (screenshotname)+".png";
					File destination=new File(path);
					try {
						FileUtils.copyFile (scrFile, destination);
					} catch (IOException e) {
					System.out.println("capture failed"+e.getMessage());
						e.printStackTrace();
					}
					return path;
			}
	
}
