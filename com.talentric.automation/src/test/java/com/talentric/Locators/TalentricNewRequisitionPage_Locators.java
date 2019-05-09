package com.talentric.Locators;

import org.openqa.selenium.By;

public class TalentricNewRequisitionPage_Locators {

	//Header
	public static String header_NewRequisition = "//span[contains(text(),'New Requisition')]";
	
	
	//Dropdowns
	
	public static String client_drp = "//span[contains(text(),'--Select Client--')]";
	public static String profile_drp = "//span[contains(text(),'--Select Profile--')]";
	public static String project_drp = "//span[contains(text(),'--Select Project--')]";
	public static String requestedBy_drp = "//span[contains(text(),'--Select Requested By--')]";
	
	public static String requisitionType_drp = "//span[contains(text(),'--Select Requisition Type--')]";
	public static String resourceType_drp = "//span[contains(text(),'--Select Resource Type--')]";
	public static String approvedBudgetLac_drp = "//a[contains(@class,'chosen-single')]//span[contains(text(),'1')]";
	public static String approvedBudgetThou_drp ="//div[@id='approvedBudgetThousand_chosen']//span[contains(text(),'0')]";
	
	public static String requiredExpFrom_drp = "//div[@id='requiredExperienceFrom_chosen']//span[contains(text(),'0')]";
	public static String requiredExpTo_drp = "//div[@id='requiredExperienceTo_chosen']//span[contains(text(),'2')]";
	public static String shift_drp = "//span[contains(text(),'--Select Shift--')]";
	public static String jobLocation_drp = "//span[contains(text(),'--Select Job Location--')]";
	public static String interviewLocation_drp = "//span[contains(text(),'--Select Interview Location--')]";
	
	public static String modeOfInterview_drp = "//div[@id='madeOfInterview_chosen']//input[contains(@value,'Select Some Options')]";
	public static String rold_drp = "//span[contains(text(),'--Select Role--')]";
	public static String designation_drp = "//span[contains(text(),'--Select Designation--')]";
	public static String designationLevel_drp = "//span[contains(text(),'--Select Designation Level--')]";
	public static String skills_drp = "//span[contains(text(),'--Select Skills--')]";
	public static String subSkills_drp = "//div[@id='subSkills_chosen']//input[@value='Select Some Options']";
	
	public static String highestEducation_drp= "//div[@id='highestEducation_chosen']//input[@value='Select Some Options']";
	public static String certification_drp = "//div[@id='certification_chosen']//input[@value='Select Some Options']";
	
	public static String bondDuration_drp = "//span[contains(text(),'--Select Bond Duration--')]";
	public static String bondAmountLac_drp = "//div[@id='bondAmmountLac_chosen']//span[contains(text(),'0')]";
	public static String bondAmountThou_drp = "//span[contains(text(),'50')]";
	

	
	//Dropdowns Search Fields
	public static String client_SearchField = "//div[@id='client_chosen']//input[@type='text']";
	public static String profile_SearchField = "//div[@id='profile_chosen']//input[@type='text']";
	public static String project_SearchField = "//div[@id='project_chosen']//input[@type='text']";
	public static String requestedBy_SearchField = "//div[@id='requestedByCode_chosen']//input[@type='text']";
	
	public static String requisitionType_SearchField = "//div[@id='requisitionType_chosen']//input[@type='text']";
	public static String resourceType_SearchField = "//div[@id='resourceType_chosen']//input[@type='text']";
	public static String approvedBudgetLac_SearchField = "//div[@id='approvedBudgetLac_chosen']//input[@type='text']";
	public static String approvedBudgetThou_SearchField ="//div[@id='approvedBudgetThousand_chosen']//input[@type='text']";
	
	public static String requiredExpFrom_SearchField = "//div[@id='requiredExperienceFrom_chosen']//input[@type='text']";
	public static String requiredExpTo_SearchField = "//div[@id='requiredExperienceTo_chosen']//input[@type='text']";
	public static String shift_SearchField = "//div[@id='shift_chosen']//input[@type='text']";
	public static String jobLocation_SearchField = "//div[@id='jobLocation_chosen']//input[@type='text']";
	public static String interviewLocation_SearchField = "//div[@id='interviewLocation_chosen']//input[@type='text']";
	
	public static String modeOfInterview_SearchField = "//div[@id='madeOfInterview_chosen']//input[@value='Select Some Options']";
	public static String rold_SearchField = "//div[@id='role_chosen']//input[@type='text']";
	public static String designation_SearchField = "//div[@id='designation_chosen']//input[@type='text']";
	public static String designationLevel_SearchField = "//div[@id='designationLevel_chosen']//input[@type='text']";
	public static String skills_SearchField = "//div[@id='skills_chosen']//input[@type='text']";
	public static String subSkills_SearchField = "//div[@id='subSkills_chosen']//input[@value='Select Some Options']";
	
	public static String highestEducation_SearchField = "//div[@id='highestEducation_chosen']//input[@value='Select Some Options']";
	public static String certification_SearchField = "//div[@id='certification_chosen']//input[@value='Select Some Options']";
	
	public static String bondDuration_SearchField = "//div[@id='bondDuration_chosen']//input[contains(@type,'text')]";
	public static String bondAmountLac_SearchField = "//div[@id='bondAmmountLac_chosen']//input[contains(@type,'text')]";
	public static String bondAmountThou_SearchField = "//div[@id='bondAmmountThousand_chosen']//input[contains(@type,'text')]";
	public static String specialCondition_Field ="//textarea[@id='specialCondition']";
	
	
	//Input Fileld
	public static String noOfPosition_Field = "//input[@id='numberOfPositions']";
	public static String mustToHaveSkills_Field ="//input[@id='mustToHaveSkill']";
	public static String certificationDetails_Field ="//input[@id='certificationDetails']";
	public static String jobResponsibilities_Field ="//textarea[@placeholder='Job Responsibilities']";
	public static String desiredSkills_Field ="//textarea[@placeholder='Desired Skill']";
	public static String relaventExperience_Field ="//textarea[@placeholder='Relevant Experience']";
	public static String cabComment_Field ="//textarea[@id='cabComment']";
	public static String cabspecialCond_Field ="//textarea[@id='specialCondition']";
	
	//Buttons
	public static String submit_Btn= "//button[contains(text(),'Submit')]";
	public static String clear_Btn= "//button[contains(text(),'Clear')]";
	public static String calender_icon = "//span[contains(@class,'input-group-btn')]//button[contains(@type,'button')]";
	public static String bond_btn = "//span[contains(@ng-click,'changeBondStatus')]//span[@class='green switch green ng-valid']";
	public static String cabFacility_btn = "//span[contains(@ng-click,\"addOpeningDto.cabComment='';\")]//span[contains(@class,'green switch green ng-valid')]";
	
	public static String date ="//span[contains(text(),'21')]";
	public static String cabCommentError = "//div[text()='Required Cab Comment.']";
	public static String jobLocationError = "//div[text()='Required Job Location.']";
	public static String noOfPositionsError = "//div[text()='Required No. Of Position.']";
	public static String jobResponsibilitiesError = "//span[text()='Job Responsibilities:']//parent::label//parent::div//div[contains(text(),' Required Minimum Length 200.')]";
	
}
