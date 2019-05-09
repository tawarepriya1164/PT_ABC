package com.talentric.Reporting;

import org.openqa.selenium.WebDriver;



import com.relevantcodes.extentreports.LogStatus;
import com.talentric.Utilities.Common_Functions;


public class Extent_Reporting {		
	public static void Log_Pass(String stepName, String passMessage){
		Report_Setup.test.log(LogStatus.PASS, stepName, passMessage);
	}
	
	public static void Log_Fail(String stepName, String failMessage, WebDriver driver) throws InterruptedException{
		Report_Setup.test.log(LogStatus.FAIL, stepName, failMessage);
		//Thread.sleep(1000);
		String img = Report_Setup.test.addScreenCapture(Common_Functions.captureScreenshot(driver));
		Report_Setup.test.log(LogStatus.INFO, stepName, "Error Snap: " + img);
	}
	
	public static void Log_Pass_with_Screenshot(String stepName, String passMessage, WebDriver driver) throws InterruptedException{
		Report_Setup.test.log(LogStatus.PASS, stepName, passMessage);
		//Thread.sleep(1000);
		String img = Report_Setup.test.addScreenCapture(Common_Functions.captureScreenshot(driver));
		Report_Setup.test.log(LogStatus.INFO, stepName, "Pass Snapshot: " + img);
	}
	
	public static void Log_with_Screenshot(String stepName, WebDriver driver) throws InterruptedException{
		//Report_Setup.test.log(LogStatus.PASS, stepName, passMessage);
		//Thread.sleep(1000);
		String img = Report_Setup.test.addScreenCapture(Common_Functions.captureScreenshot(driver));
		Report_Setup.test.log(LogStatus.INFO, stepName, "Snapshot: " + img);
	}
	
}