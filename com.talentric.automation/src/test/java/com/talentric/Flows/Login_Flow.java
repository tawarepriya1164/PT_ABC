package com.talentric.Flows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.talentric.Locators.TalentricHomePage_Locators;
import com.talentric.Locators.TalentricLoginPage_Locators;
import com.talentric.Reporting.Extent_Reporting;
import com.talentric.Utilities.Excel_Handling;
import com.talentric.Utilities.WrapperMethods;

public class Login_Flow {


	WebDriver driver;
	WrapperMethods method = new WrapperMethods();

	public void TalentricLoginWithValidData(WebDriver driver, String TC_ID) throws Throwable {
		try {
			Thread.sleep(8000);
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.titleContains("Talentric"));
			System.out.println("Logging in to the application...");
			
			
			// Enter Username
			System.out.println("Entering Username:- " + Excel_Handling.Get_Data(TC_ID, "userName"));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(TalentricLoginPage_Locators.username));
			method.waitForElementClickable(driver, TalentricLoginPage_Locators.username_TextField, "User Name");
			method.enterText(driver, TalentricLoginPage_Locators.username_TextField,
					Excel_Handling.Get_Data(TC_ID, "userName"), "User Name");
			Extent_Reporting.Log_with_Screenshot("Username entered successfully.",driver);

			// Enter Password
			System.out.println("Entering Password:- " + Excel_Handling.Get_Data(TC_ID, "password"));
			method.waitForElementVisible(driver, TalentricLoginPage_Locators.password_TextField, "Password");
			method.enterText(driver, TalentricLoginPage_Locators.password_TextField,
					Excel_Handling.Get_Data(TC_ID, "password"), "Password");
			Extent_Reporting.Log_with_Screenshot( "Password entered successfully.",driver);
			
			//Click on Login button
			method.Clickbtn(driver, TalentricLoginPage_Locators.login_Button, "Login");
			Extent_Reporting.Log_with_Screenshot("Clicked on Login button successfully.",driver);
			
			
			if(method.checkElementDisplayedBy(driver, TalentricHomePage_Locators.homePage_WelcomeUsername)) {
				System.out.println("Login successfull..");
				Extent_Reporting.Log_with_Screenshot("Login successfull..",driver);
			}
			else {
				System.out.println("Login unsuccessfull...Please check UserName and Password");
				Extent_Reporting.Log_with_Screenshot("Login successfull..", driver);
			}

		} catch (Exception e) {
			e.printStackTrace();
			Extent_Reporting.Log_Fail("Login Error", "Failed", driver);
			System.out.println("Login Failed");
		}

	}
	
	
	public void TalentricLoginWithInvalidData(WebDriver driver, String TC_ID) throws Throwable {
		try {
			Thread.sleep(8000);
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.titleContains("Talentric"));
			System.out.println("Logging in to the application...");
			
			
			// Enter Username
			System.out.println("Entering Username:- " + Excel_Handling.Get_Data(TC_ID, "userName"));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(TalentricLoginPage_Locators.username));
			method.waitForElementClickable(driver, TalentricLoginPage_Locators.username_TextField, "User Name");
			method.enterText(driver, TalentricLoginPage_Locators.username_TextField,
					Excel_Handling.Get_Data(TC_ID, "userName"), "User Name");
			Extent_Reporting.Log_with_Screenshot("Username entered successfully.",driver);

			// Enter Password
			System.out.println("Entering Password:- " + Excel_Handling.Get_Data(TC_ID, "password"));
			method.waitForElementVisible(driver, TalentricLoginPage_Locators.password_TextField, "Password");
			method.enterText(driver, TalentricLoginPage_Locators.password_TextField,
					Excel_Handling.Get_Data(TC_ID, "password"), "Password");
			Extent_Reporting.Log_with_Screenshot( "Password entered successfully.",driver);
			
			//Click on Login button
			method.Clickbtn(driver, TalentricLoginPage_Locators.login_Button, "Login");
			Extent_Reporting.Log_with_Screenshot("Clicked on Login button successfully.",driver);
			
			
			if(method.checkElementDisplayedBy(driver, TalentricHomePage_Locators.authentication_Error)) {
				System.out.println("Login unsuccessfull..Please check UserName and Password");
				Extent_Reporting.Log_with_Screenshot("Login unsuccessfull..",driver);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			Extent_Reporting.Log_Fail("Login Error", "Failed", driver);
			System.out.println("Login Failed");
		}

	}
}
