package com.talentric.Flows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.talentric.Locators.TalentricHomePage_Locators;
import com.talentric.Locators.TalentricNewRequisitionPage_Locators;
import com.talentric.Reporting.Extent_Reporting;
import com.talentric.Utilities.Excel_Handling;
import com.talentric.Utilities.WrapperMethods;

public class RequisitionFlowWithBond {

	WebDriver driver;
	WrapperMethods method = new WrapperMethods();
	
	public void TalentricNewRequisition(WebDriver driver, String TC_ID) throws Throwable {
		try {
			Thread.sleep(4000);
			WebDriverWait wait = new WebDriverWait(driver,30);
			
			System.out.println("Click on new requisition button");
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(TalentricHomePage_Locators.NewRequisition_ButtonIcon));
			method.Clickbtn(driver, TalentricHomePage_Locators.NewRequisition_Button, "New requisitin button");
			if(method.checkElementDisplayedBy(driver, TalentricNewRequisitionPage_Locators.header_NewRequisition)) {
				System.out.println("New Requisition Page opened successfully..");
			}
			Thread.sleep(2000);
			method.Clickbtn(driver, TalentricNewRequisitionPage_Locators.client_drp, "Client dropdown");
			System.out.println("Selecting Client:- " + Excel_Handling.Get_Data(TC_ID, "Client"));
			method.inputText_Enter(driver, TalentricNewRequisitionPage_Locators.client_SearchField, Excel_Handling.Get_Data(TC_ID, "Client"), "Client");
			
			method.Clickbtn(driver, TalentricNewRequisitionPage_Locators.project_drp, "Project dropdown");
			System.out.println("Selecting Project:- " + Excel_Handling.Get_Data(TC_ID, "Project"));
			method.inputText_Enter(driver, TalentricNewRequisitionPage_Locators.project_SearchField, Excel_Handling.Get_Data(TC_ID, "Project"), "Project");
			
			method.Clickbtn(driver, TalentricNewRequisitionPage_Locators.requestedBy_drp, "RequestedBy dropdown");
			System.out.println("Selecting RequestedBy:- " + Excel_Handling.Get_Data(TC_ID, "RequestedBy"));
			method.inputText_Enter(driver, TalentricNewRequisitionPage_Locators.requestedBy_SearchField, Excel_Handling.Get_Data(TC_ID, "RequestedBy"), "RequestedBy");
			
			method.Clickbtn(driver, TalentricNewRequisitionPage_Locators.profile_drp, "Profile dropdown");
			System.out.println("Selecting Profile:- " + Excel_Handling.Get_Data(TC_ID, "Profile"));
			method.inputText_Enter(driver, TalentricNewRequisitionPage_Locators.profile_SearchField, Excel_Handling.Get_Data(TC_ID, "Profile"), "Profile");
			
			method.Clickbtn(driver, TalentricNewRequisitionPage_Locators.requisitionType_drp, "RequisitionType dropdown");
			System.out.println("Selecting RequisitionType:- " + Excel_Handling.Get_Data(TC_ID, "RequisitionType"));
			method.inputText_Enter(driver, TalentricNewRequisitionPage_Locators.requisitionType_SearchField, Excel_Handling.Get_Data(TC_ID, "RequisitionType"), "RequisitionType");
			
			Thread.sleep(2000);
			method.Clickbtn(driver, TalentricNewRequisitionPage_Locators.resourceType_drp, "ResourceType dropdown");
			System.out.println("Selecting ResourceType:- " + Excel_Handling.Get_Data(TC_ID, "ResourceType"));
			method.inputText_Enter(driver, TalentricNewRequisitionPage_Locators.resourceType_SearchField, Excel_Handling.Get_Data(TC_ID, "ResourceType"), "ResourceType");
			
			System.out.println("Entering NoOfPosition:- " + Excel_Handling.Get_Data(TC_ID, "NoOfPosition"));
			method.enterText(driver, TalentricNewRequisitionPage_Locators.noOfPosition_Field,
					Excel_Handling.Get_Data(TC_ID, "NoOfPosition"), "NoOfPosition");
			
			method.Clickbtn(driver, TalentricNewRequisitionPage_Locators.approvedBudgetLac_drp, "ApprovedBudgetLac dropdown");
			System.out.println("Selecting ApprovedBudgetLac:- " + Excel_Handling.Get_Data(TC_ID, "ApprovedBudgetLac"));
			method.inputText_Enter(driver, TalentricNewRequisitionPage_Locators.approvedBudgetLac_SearchField, Excel_Handling.Get_Data(TC_ID, "ApprovedBudgetLac"), "ApprovedBudgetLac");
			
			method.Clickbtn(driver, TalentricNewRequisitionPage_Locators.approvedBudgetThou_drp, "ApprovedBudgetThou dropdown");
			System.out.println("Selecting ApprovedBudgetThou:- " + Excel_Handling.Get_Data(TC_ID, "ApprovedBudgetThou"));
			method.inputText_Enter(driver, TalentricNewRequisitionPage_Locators.approvedBudgetThou_SearchField, Excel_Handling.Get_Data(TC_ID, "ApprovedBudgetThou"), "ApprovedBudgetThou");
			
			method.Clickbtn(driver, TalentricNewRequisitionPage_Locators.requiredExpFrom_drp, "RequiredExpFrom dropdown");
			System.out.println("Selecting RequiredExpFrom:- " + Excel_Handling.Get_Data(TC_ID, "RequiredExpFrom"));
			method.inputText_Enter(driver, TalentricNewRequisitionPage_Locators.requiredExpFrom_SearchField, Excel_Handling.Get_Data(TC_ID, "RequiredExpFrom"), "RequiredExpFrom");
			
			method.Clickbtn(driver, TalentricNewRequisitionPage_Locators.requiredExpTo_drp, "RequiredExpTo dropdown");
			System.out.println("Selecting RequiredExpTo:- " + Excel_Handling.Get_Data(TC_ID, "RequiredExpTo"));
			method.inputText_Enter(driver, TalentricNewRequisitionPage_Locators.requiredExpTo_SearchField, Excel_Handling.Get_Data(TC_ID, "RequiredExpTo"), "RequiredExpTo");
			
			method.Clickbtn(driver, TalentricNewRequisitionPage_Locators.shift_drp, "Shift dropdown");
			System.out.println("Selecting Shift:- " + Excel_Handling.Get_Data(TC_ID, "Shift"));
			method.inputText_Enter(driver, TalentricNewRequisitionPage_Locators.shift_SearchField, Excel_Handling.Get_Data(TC_ID, "Shift"), "Shift");
			
			method.Clickbtn(driver, TalentricNewRequisitionPage_Locators.jobLocation_drp, "JobLocation dropdown");
			System.out.println("Selecting JobLocation:- " + Excel_Handling.Get_Data(TC_ID, "JobLocation"));
			method.inputText_Enter(driver, TalentricNewRequisitionPage_Locators.jobLocation_SearchField, Excel_Handling.Get_Data(TC_ID, "JobLocation"), "JobLocation");
			
			method.Clickbtn(driver, TalentricNewRequisitionPage_Locators.interviewLocation_drp, "InterviewLocation dropdown");
			System.out.println("Selecting InterviewLocation:- " + Excel_Handling.Get_Data(TC_ID, "InterviewLocation"));
			method.inputText_Enter(driver, TalentricNewRequisitionPage_Locators.interviewLocation_SearchField, Excel_Handling.Get_Data(TC_ID, "InterviewLocation"), "InterviewLocation");
			
			
			System.out.println("Selecting ModeOfInterview:- " + Excel_Handling.Get_Data(TC_ID, "ModeOfInterview"));
			method.inputText_Enter(driver, TalentricNewRequisitionPage_Locators.modeOfInterview_SearchField, Excel_Handling.Get_Data(TC_ID, "ModeOfInterview"), "ModeOfInterview");
			
			method.Clickbtn(driver, TalentricNewRequisitionPage_Locators.rold_drp, "Role dropdown");
			System.out.println("Selecting Role:- " + Excel_Handling.Get_Data(TC_ID, "Role"));
			method.inputText_Enter(driver, TalentricNewRequisitionPage_Locators.rold_SearchField, Excel_Handling.Get_Data(TC_ID, "Role"), "Role");
			
			method.Clickbtn(driver, TalentricNewRequisitionPage_Locators.designation_drp, "Designation dropdown");
			System.out.println("Selecting Designation:- " + Excel_Handling.Get_Data(TC_ID, "Designation"));
			method.inputText_Enter(driver, TalentricNewRequisitionPage_Locators.designation_SearchField, Excel_Handling.Get_Data(TC_ID, "Designation"), "Designation");
			
			method.Clickbtn(driver, TalentricNewRequisitionPage_Locators.designationLevel_drp, "DesignationLevel dropdown");
			System.out.println("Selecting Designation:- " + Excel_Handling.Get_Data(TC_ID, "DesignationLevel"));
			method.inputText_Enter(driver, TalentricNewRequisitionPage_Locators.designationLevel_SearchField, Excel_Handling.Get_Data(TC_ID, "DesignationLevel"), "DesignationLevel");
			
			//date
			method.setDate(driver, TalentricNewRequisitionPage_Locators.calender_icon, Excel_Handling.Get_Data(TC_ID, "HireByDate"));
			
			System.out.println("Selecting Skills:- " + Excel_Handling.Get_Data(TC_ID, "Skills"));
			method.Clickbtn(driver, TalentricNewRequisitionPage_Locators.skills_drp, "Skills dropdown");
			method.inputText_Enter(driver, TalentricNewRequisitionPage_Locators.skills_SearchField, Excel_Handling.Get_Data(TC_ID, "Skills"), "Skills");
			
			System.out.println("Selecting SubSkills:- " + Excel_Handling.Get_Data(TC_ID, "SubSkills"));
			method.Clickbtn(driver, TalentricNewRequisitionPage_Locators.subSkills_drp, "SubSkills");
			method.inputText_Enter(driver, TalentricNewRequisitionPage_Locators.subSkills_drp, Excel_Handling.Get_Data(TC_ID, "SubSkills"), "SubSkills");
			
			System.out.println("Entering MustToHaveSkill:- " + Excel_Handling.Get_Data(TC_ID, "MustToHaveSkill"));
			method.enterText(driver, TalentricNewRequisitionPage_Locators.mustToHaveSkills_Field,
					Excel_Handling.Get_Data(TC_ID, "MustToHaveSkill"), "MustToHaveSkill");
			
			System.out.println("Selecting HighestEdu:- " + Excel_Handling.Get_Data(TC_ID, "HighestEdu"));
			method.Clickbtn(driver, TalentricNewRequisitionPage_Locators.highestEducation_drp, "HighestEdu dropdown");
			method.inputText_Enter(driver, TalentricNewRequisitionPage_Locators.highestEducation_SearchField, Excel_Handling.Get_Data(TC_ID, "HighestEdu"), "HighestEdu");
           
			String bond =Excel_Handling.Get_Data(TC_ID, "Bond");
			System.out.println("Bond present" + bond);
			if(bond.equalsIgnoreCase("Yes")) {
			method.Clickbtn(driver, TalentricNewRequisitionPage_Locators.bond_btn, "Bond");
			
			System.out.println("Selecting bond duration in months:- " + Excel_Handling.Get_Data(TC_ID, "BondDurationInMonth"));
			method.Clickbtn(driver, TalentricNewRequisitionPage_Locators.bondDuration_drp, "BondDurationInMonth dropdown");
			method.inputText_Enter(driver, TalentricNewRequisitionPage_Locators.bondDuration_SearchField, Excel_Handling.Get_Data(TC_ID, "BondDurationInMonth"), "BondDurationInMonth");

			System.out.println("Selecting bond amount in lacs:- " + Excel_Handling.Get_Data(TC_ID, "BondAmountInLacs"));
			method.Clickbtn(driver, TalentricNewRequisitionPage_Locators.bondAmountLac_drp, "BondAmountInLacs dropdown");
			method.inputText_Enter(driver, TalentricNewRequisitionPage_Locators.bondAmountLac_SearchField, Excel_Handling.Get_Data(TC_ID, "BondAmountInLacs"), "BondAmountInLacs");

			System.out.println("Selecting bond amount in thousands:- " + Excel_Handling.Get_Data(TC_ID, "BondAmountInThou"));
			method.Clickbtn(driver, TalentricNewRequisitionPage_Locators.bondAmountThou_drp, "BondAmountInThou dropdown");
			method.inputText_Enter(driver, TalentricNewRequisitionPage_Locators.bondAmountThou_SearchField, Excel_Handling.Get_Data(TC_ID, "BondAmountInThou"), "BondAmountInThou");
			}
			
			

			String cabFacility =Excel_Handling.Get_Data(TC_ID, "cabFacility");
			if(cabFacility.equalsIgnoreCase("Yes")) {
			method.Clickbtn(driver, TalentricNewRequisitionPage_Locators.cabFacility_btn, "cabFacility");
			}
			
			System.out.println("Entering cab comment:- " + Excel_Handling.Get_Data(TC_ID, "cabComment"));
			method.enterText(driver, TalentricNewRequisitionPage_Locators.cabComment_Field,
					Excel_Handling.Get_Data(TC_ID, "cabComment"), "cabComment");
			
			System.out.println("Entering cab special conditions:- " + Excel_Handling.Get_Data(TC_ID, "cabSpecialCond"));
			method.enterText(driver, TalentricNewRequisitionPage_Locators.cabspecialCond_Field,
					Excel_Handling.Get_Data(TC_ID, "cabSpecialCond"), "cab Special Conditions");
			
			
			System.out.println("Entering JobResponsibilities:- " + Excel_Handling.Get_Data(TC_ID, "JobResponsibilities"));
			method.enterText(driver, TalentricNewRequisitionPage_Locators.jobResponsibilities_Field,
					Excel_Handling.Get_Data(TC_ID, "JobResponsibilities"), "JobResponsibilities");
			System.out.println("Entering DesiredSkills:- " + Excel_Handling.Get_Data(TC_ID, "DesiredSkills"));
			method.enterText(driver, TalentricNewRequisitionPage_Locators.desiredSkills_Field,
					Excel_Handling.Get_Data(TC_ID, "DesiredSkills"), "DesiredSkills");
			System.out.println("Entering RelaventExp:- " + Excel_Handling.Get_Data(TC_ID, "RelaventExp"));
			method.enterText(driver, TalentricNewRequisitionPage_Locators.relaventExperience_Field,
					Excel_Handling.Get_Data(TC_ID, "RelaventExp"), "RelaventExp");
		
			System.out.println("Click on submit button");
			method.Clickbtn(driver, TalentricNewRequisitionPage_Locators.submit_Btn, "submit button");
			
			if(method.checkElementDisplayedBy(driver, TalentricHomePage_Locators.NewRequisition_Button)) {
				System.out.println("New Requisition created successfully with bond..");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			Extent_Reporting.Log_Fail("Requisition Error", "Failed", driver);
			System.out.println("Failed to create new requisition");
			}
		}
}
