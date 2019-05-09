package com.talentric.Locators;

import org.openqa.selenium.By;

public class TalentricHomePage_Locators {

	public static String homePage_Username ="//div[@class='col-md-12 col-sm-12 col-xs-12 text-center padding-none']//span[@ng-bind='currentUser']";
	public static String homePage_WelcomeUsername = "//div[@class='col-md-12 col-sm-12 col-xs-12 text-center padding-none']//span[@ng-bind='currentUser']";
	public static String NewRequisition_Button = "//div[@class='textCenter']//span[@ng-click='pageLoading()']";
	public static By NewRequisition_ButtonIcon = By.xpath("//div[@class='textCenter']//span[@ng-click='pageLoading()']");
	public static String authentication_Error = "//span[contains(text(),'Authentication Failed')]";
}
