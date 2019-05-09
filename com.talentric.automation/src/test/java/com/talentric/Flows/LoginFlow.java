package com.talentric.Flows;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


import com.talentric.Locators.LoginPage_Locators;
import com.talentric.Reporting.Extent_Reporting;
import com.talentric.Utilities.Driver_Setup;
import com.talentric.Utilities.Excel_Handling;
import com.talentric.Utilities.WrapperMethods;

public class LoginFlow extends Driver_Setup
{
	WebDriver driver;
	WrapperMethods method = new WrapperMethods();
	LoginPage_Locators login_locators = new LoginPage_Locators();
	
	public void Login(WebDriver driver, String TC_ID) throws Throwable 
	{
		try {
			Thread.sleep(2000);
			System.out.println("Logging in to the application...");
			// Username
			System.out.println("Entering Username:- " + Excel_Handling.Get_Data(TC_ID, "username"));
			method.waitForElementClickable(driver, LoginPage_Locators.username_TextField, "User Name");
			method.enterText(driver, LoginPage_Locators.username_TextField, Excel_Handling.Get_Data(TC_ID, "username"), "User Name");
			
			// Password
						System.out.println("Entering Password:- " + Excel_Handling.Get_Data(TC_ID, "password"));
						method.waitForElementVisible(driver, LoginPage_Locators.password_TextField, "Password");
						method.enterText(driver, LoginPage_Locators.password_TextField, Excel_Handling.Get_Data(TC_ID, "password"),
								"Password");
						// Login
						Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
								 
								.withTimeout(30000, TimeUnit.SECONDS).pollingEvery(5000, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
						
						method.waitForElementClickable(driver, LoginPage_Locators.login_Button, "Login");
						method.Clickbtn(driver, LoginPage_Locators.login_Button, "Login");
						Thread.sleep(500);
						//WebDriverWait wait2 = new WebDriverWait(driver, 3);
		}
		catch (Exception e) {
			Extent_Reporting.Log_Fail("Login Error", "Failed", driver);
			System.out.println("Login Failed");
		}
	
	}
}