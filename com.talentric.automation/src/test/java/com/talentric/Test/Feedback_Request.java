package com.talentric.Test;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talentric.Flows.LoginFlow;
import com.talentric.Reporting.Report_Setup;
import com.talentric.Utilities.Driver_Setup;
import com.talentric.Utilities.WrapperMethods;

public class Feedback_Request extends Driver_Setup 
{
	public WebDriver driver;
	WrapperMethods method = new WrapperMethods();

	@Parameters({ "browserType", "appURL", "tcID" })
	@Test
	public void TC_002(String browserType, String appURL, String TestCase_ID) throws Throwable {
		System.out.println("============="+browserType);
		try {
			LoginFlow page_Login = new LoginFlow();

			/*//Dashboard_Reliance reliance_dashboard = new Dashboard_Reliance();
			Policy_Type_BusinessFlows policy_type_businessflows = new Policy_Type_BusinessFlows();
			Common_Functions commonFunctions = new Common_Functions();
			Select_Type_BusinessFlows selecttype = new Select_Type_BusinessFlows();
			Create_BusinessFlows create = new Create_BusinessFlows();
			SellingPage_BusinessFlows sellingpage = new SellingPage_BusinessFlows();
			Package_Type_BusinessFlows package_type = new Package_Type_BusinessFlows();
			Policy_Category_BusinessFlows policy_category=new Policy_Category_BusinessFlows();
			Vehicle_Details_BusinessFlows vehicle_details=new Vehicle_Details_BusinessFlows();
			*/
			Driver_Setup n = new Driver_Setup();
			Report_Setup.InitializeReport(TestCase_ID);
			driver = n.initializeTestBaseSetup(browserType, appURL, TestCase_ID);
			//commonFunctions.startRecording();
			page_Login.Login(driver, TestCase_ID);
			
		} catch (Exception e) {
			
			driver.close();
			System.out.println("TC_ 02_Login Error");
		}
	}

/*	@AfterTest
	void teatDown() {

		driver.close();

	}
*/
}
