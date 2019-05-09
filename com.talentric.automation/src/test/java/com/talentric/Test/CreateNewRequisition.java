package com.talentric.Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.talentric.Flows.Login_Flow;
import com.talentric.Flows.RequisitionFlowWithCab;
import com.talentric.Reporting.Report_Setup;
import com.talentric.Utilities.Common_Functions;
import com.talentric.Utilities.Driver_Setup;
import com.talentric.Utilities.WrapperMethods;

public class CreateNewRequisition {

	public class CreateRequisition extends Driver_Setup {
		public WebDriver driver;
		WrapperMethods method = new WrapperMethods();
		Common_Functions commonFunction = new Common_Functions();

		@Parameters({ "browserType", "appURL", "tcID" })
		@Test(enabled = true , priority=1)
		public void TC_004(String browserType, String appURL, String TestCase_ID) throws Throwable {
			System.out.println("=============" + browserType);
			try {
				commonFunction.startRecording();
				Login_Flow page_Login = new Login_Flow();
				RequisitionFlowWithCab page_requisition = new RequisitionFlowWithCab();
				
				
				Driver_Setup n = new Driver_Setup();
				Report_Setup.InitializeReport(TestCase_ID);
				driver = n.initializeTestBaseSetup(browserType, appURL, TestCase_ID);
				page_Login.TalentricLoginWithValidData(driver, TestCase_ID);
				page_requisition.TalentricNewRequisition(driver, TestCase_ID);
				Report_Setup.extent.endTest(Report_Setup.test);
				Report_Setup.extent.flush();
				commonFunction.stopRecording();

			} catch (Exception e) {
				driver.close();
				System.out.println("TC_04_Fialed to create requisition");
				commonFunction.stopRecording();
			}
		}

		@Parameters({ "browserType", "appURL", "tcID" }) 	
		@Test(enabled = true,priority=2)
		public void TC_008(String browserType, String appURL, String TestCase_ID) throws Throwable {
			System.out.println("=============" + browserType);
			try {
				commonFunction.startRecording();
				Login_Flow page_Login = new Login_Flow();
				RequisitionFlowWithCab page_requisition = new RequisitionFlowWithCab();
				
				Driver_Setup n = new Driver_Setup();
				Report_Setup.InitializeReport(TestCase_ID);
				driver = n.initializeTestBaseSetup(browserType, appURL, TestCase_ID);
				page_Login.TalentricLoginWithValidData(driver, TestCase_ID);
				page_requisition.TalentricNewRequisitionWithCabFacility(driver, TestCase_ID);
				Report_Setup.extent.endTest(Report_Setup.test);
				Report_Setup.extent.flush();
				commonFunction.stopRecording();

			} catch (Exception e) {
				driver.close();
				System.out.println("TC_04_Fialed to create requisition");
				commonFunction.stopRecording();
			}
		}
		
		@Parameters({ "browserType", "appURL", "tcID" }) 	
		@Test(enabled = true,priority=3)
		public void TC_009(String browserType, String appURL, String TestCase_ID) throws Throwable {
			System.out.println("=============" + browserType);
			try {
				commonFunction.startRecording();
				Login_Flow page_Login = new Login_Flow();
				RequisitionFlowWithCab page_requisition = new RequisitionFlowWithCab();
				
				Driver_Setup n = new Driver_Setup();
				Report_Setup.InitializeReport(TestCase_ID);
				driver = n.initializeTestBaseSetup(browserType, appURL, TestCase_ID);
				page_Login.TalentricLoginWithValidData(driver, TestCase_ID);
				page_requisition.TalentricNewRequisitionWithoutJobLocation(driver, TestCase_ID);
				Report_Setup.extent.endTest(Report_Setup.test);
				Report_Setup.extent.flush();
				commonFunction.stopRecording();

			} catch (Exception e) {
				driver.close();
				System.out.println("TC_04_Fialed to create requisition");
				commonFunction.stopRecording();
			}
		}
		
		@Parameters({ "browserType", "appURL", "tcID" }) 	
		@Test(enabled = true,priority=4)
		public void TC_010(String browserType, String appURL, String TestCase_ID) throws Throwable {
			System.out.println("=============" + browserType);
			try {
				commonFunction.startRecording();
				Login_Flow page_Login = new Login_Flow();
				RequisitionFlowWithCab page_requisition = new RequisitionFlowWithCab();
				
				Driver_Setup n = new Driver_Setup();
				Report_Setup.InitializeReport(TestCase_ID);
				driver = n.initializeTestBaseSetup(browserType, appURL, TestCase_ID);
				page_Login.TalentricLoginWithValidData(driver, TestCase_ID);
				page_requisition.TalentricNewRequisitionWithoutNoOPositions(driver, TestCase_ID);
				Report_Setup.extent.endTest(Report_Setup.test);
				Report_Setup.extent.flush();
				commonFunction.stopRecording();

			} catch (Exception e) {
				driver.close();
				System.out.println("TC_04_Fialed to create requisition");
				commonFunction.stopRecording();
			}
		}


		@Parameters({ "browserType", "appURL", "tcID" }) 	
		@Test(enabled = true,priority=5)
		public void TC_011(String browserType, String appURL, String TestCase_ID) throws Throwable {
			System.out.println("=============" + browserType);
			try {
				commonFunction.startRecording();
				Login_Flow page_Login = new Login_Flow();
				RequisitionFlowWithCab page_requisition = new RequisitionFlowWithCab();
				
				Driver_Setup n = new Driver_Setup();
				Report_Setup.InitializeReport(TestCase_ID);
				driver = n.initializeTestBaseSetup(browserType, appURL, TestCase_ID);
				page_Login.TalentricLoginWithValidData(driver, TestCase_ID);
				page_requisition.TalentricNewRequisitionWithJobResponsibilitiesLessThan200Char(driver, TestCase_ID);
				Report_Setup.extent.endTest(Report_Setup.test);
				Report_Setup.extent.flush();
				commonFunction.stopRecording();

			} catch (Exception e) {
				driver.close();
				System.out.println("TC_04_Fialed to create requisition");
				commonFunction.stopRecording();
			}
		}

		
		
		@AfterTest
		void teardownEnvironment() {
			//driver.close();
			
		}
	}
}
