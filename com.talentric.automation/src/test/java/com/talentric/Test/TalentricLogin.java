package com.talentric.Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talentric.Flows.Login_Flow;
import com.talentric.Reporting.Report_Setup;
import com.talentric.Utilities.Driver_Setup;
import com.talentric.Utilities.WrapperMethods;

public class TalentricLogin {

	public class Login_Request extends Driver_Setup {
		public WebDriver driver;
		WrapperMethods method = new WrapperMethods();

		@Parameters({ "browserType", "appURL", "tcID" })
		@Test(priority =1,enabled = false)
		public void TC_001(String browserType, String appURL, String TestCase_ID) throws Throwable {
			System.out.println("=============" + browserType);
			try {
				Login_Flow page_Login = new Login_Flow();

				Driver_Setup n = new Driver_Setup();
				Report_Setup.InitializeReport(TestCase_ID);
				driver = n.initializeTestBaseSetup(browserType, appURL, TestCase_ID);
				page_Login.TalentricLoginWithValidData(driver, TestCase_ID);
				Report_Setup.extent.endTest(Report_Setup.test);
				Report_Setup.extent.flush();

			} catch (Exception e) {
				driver.close();
				System.out.println("TC_01_Login Error");
			}
		}
		
		@Parameters({ "browserType", "appURL", "tcID" })
		@Test(priority =2,enabled = true)
		public void TC_002(String browserType, String appURL, String TestCase_ID) throws Throwable {
			System.out.println("=============" + browserType);
			try {
				Login_Flow page_Login = new Login_Flow();

				Driver_Setup n = new Driver_Setup();
				Report_Setup.InitializeReport(TestCase_ID);
				driver = n.initializeTestBaseSetup(browserType, appURL, TestCase_ID);
				page_Login.TalentricLoginWithInvalidData(driver, TestCase_ID);
				Report_Setup.extent.endTest(Report_Setup.test);
				Report_Setup.extent.flush();

			} catch (Exception e) {
				driver.close();
				System.out.println("TC_01_Login Error");
			}
		}

		@AfterTest
		void teardownEnvironment() {
			driver.close();
		}
	}
}
