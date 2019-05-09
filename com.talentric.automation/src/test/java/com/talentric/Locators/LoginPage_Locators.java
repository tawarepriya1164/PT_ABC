package com.talentric.Locators;

public class LoginPage_Locators 
{
	//Login Page Locators 
	public static String username_TextField="//input[@placeholder='Username']";
	public static String password_TextField="//input[@id='password']";
	public static String login_Button=" //button[@class='btn btn-login w3-btn w3-blue ng-binding']";
	public static String errorMessage= "//span[contains(text(),'Authentication Failed')]";
}
