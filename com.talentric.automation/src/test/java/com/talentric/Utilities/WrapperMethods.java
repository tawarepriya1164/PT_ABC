package com.talentric.Utilities;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.google.common.base.Function;
import com.talentric.Reporting.Extent_Reporting;

public class WrapperMethods {


	
	public boolean isElementPresentByXpath(String xpath,WebDriver driver,String Element_Name) throws InterruptedException
	{
		try
		{
			driver.findElement(By.xpath(xpath));
			Extent_Reporting.Log_Pass(Element_Name+" Exist",Element_Name+" Exist");
		}
		catch(Throwable t)
		{
			//Log.error("Element not Found -->"+t.getMessage());
			Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", driver);
			t.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	public boolean isElementDisplayedandGetText(WebDriver driver,String xpath,String Element_Name,int t)
	{
		boolean flag=false;
		try
		{
			driver.manage().timeouts().implicitlyWait(t, TimeUnit.SECONDS);
			if(
					driver.findElement(By.xpath(xpath)).isDisplayed())
				driver.findElement(By.xpath(xpath)).getText();
			{	Extent_Reporting.Log_Pass(Element_Name +" is displayed ", Element_Name +" is displayed ");
				flag = true;
				
				
			}
		}
		catch(Throwable e)
		{
			Extent_Reporting.Log_Pass(Element_Name +" is not displayed ", Element_Name +" is not displayed ");
			flag = false;
		}
		return flag;

	}
	
	public boolean isElementPresentByXpathAndClick(String xpath,WebDriver driver,String Value,String Element_Name) throws InterruptedException
	{
		try
		{
			
			
			WebElement selectDropBox = driver.findElement(By.xpath(xpath));
			Select select = new Select(selectDropBox);
			select.selectByVisibleText(Value);
			
			
			Extent_Reporting.Log_Pass(Element_Name+" Exist",Element_Name+" Exist");
		}
		catch(Throwable t)
		{
			//Log.error("Element not Found -->"+t.getMessage());
			Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", driver);
			t.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean isElementPresentByLinkText(String linkText,WebDriver driver) throws InterruptedException
	{
		try
		{
			driver.findElement(By.linkText(linkText));
			Extent_Reporting.Log_Pass(linkText+" Exist",linkText+" Exist");
		}
		catch(Throwable t)
		{
			
			Extent_Reporting.Log_Fail(linkText+" does not Exist",linkText+" does not Exist", driver);
			t.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean isElementPresentByID(String ID,WebDriver driver,String Element_Name) throws InterruptedException
	{
		try
		{
			driver.findElement(By.id(ID));
			
			Extent_Reporting.Log_Pass(Element_Name+" Exist",Element_Name+" Exist");
		}
		catch(Throwable t)
		{
			
			Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", driver);
			t.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean isElementPresentByName(String Name,WebDriver driver,String Element_Name) throws InterruptedException
	{
		try
		{
			driver.findElement(By.name(Name));
			Extent_Reporting.Log_Pass(Element_Name+" Exist",Element_Name+" Exist");
		}
		catch(Throwable t)
		{
			
			Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", driver);
			t.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean isElementPresentByClassName(String className,WebDriver driver,String Element_Name) throws InterruptedException
	{
		try
		{
			driver.findElement(By.className(className));
			Extent_Reporting.Log_Pass(Element_Name+" Exist",Element_Name+" Exist");
		}
		catch(Throwable t)
		{
			
			Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", driver);
			t.printStackTrace();
			return false;
		}
		return true;
	}


	public void clickButtonID(WebDriver screenName,String ID,String Element_Name) throws Exception
	{
		try
		{
		
			WebElement webButton = screenName.findElement(By.id(ID));
			webButton.click();
			Extent_Reporting.Log_Pass(Element_Name+" Clicked",Element_Name+" Clicked");
		}
		catch(Throwable t)
		{
			Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", screenName);
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}
	public void clickButton(WebDriver screenName,String ObjectxPath,String Element_Name) throws Exception
	{
		try
		{
			WebElement webButton = screenName.findElement(By.xpath(ObjectxPath));
			webButton.click();
			Extent_Reporting.Log_Pass(Element_Name+" Clicked",Element_Name+" Clicked");
		}
		catch(Throwable t)
		{ 
			Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", screenName);
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}
	
	public void isnullandEnter(WebDriver screenName,String ObjectxPath,String sValue,String Element_Name) throws Exception
	{
		try
		{
			String webButton = screenName.findElement(By.xpath(ObjectxPath)).getAttribute("value");
			
			WebElement inputBox = screenName.findElement(By.xpath(ObjectxPath));
			String textInsideInputBox = inputBox.getAttribute("value");

			// Check whether input field is blank
			if(textInsideInputBox.isEmpty())
			{	inputBox.sendKeys(sValue);
			   System.out.println("Input field is empty");
			}
		
			
			else
			{
				Extent_Reporting.Log_Pass(Element_Name+" Already Exist",Element_Name+" Entered");
			}
			Extent_Reporting.Log_Pass(Element_Name+" Value Entered",Element_Name+" Entered");
		}
		catch(Throwable t)
		{ 
			Extent_Reporting.Log_Fail(Element_Name+" is Not Null",Element_Name+" not Null", screenName);
			t.printStackTrace();
			throw new Exception("Element Not Null");
		}
	}

	public void isnullandclick(WebDriver screenName,String ObjectxPath,String xpathExpression,String Element_Name) throws Exception
	{
		try
		{
			String webButton = screenName.findElement(By.xpath(ObjectxPath)).getAttribute("value");
			
			WebElement inputBox = screenName.findElement(By.xpath(ObjectxPath));
			String textInsideInputBox = inputBox.getAttribute("value");

			// Check whether input field is blank
			if(textInsideInputBox.isEmpty())
			{	
				
			 WebElement webButton2 = screenName.findElement(By.xpath(xpathExpression));
				webButton2.click();
			   
			}
		
			
			else
			{
				Extent_Reporting.Log_Pass(Element_Name+" Already Exist",Element_Name+" Entered");
			}
			Extent_Reporting.Log_Pass(Element_Name+" Value Entered",Element_Name+" Entered");
		}
		catch(Throwable t)
		{ 
			Extent_Reporting.Log_Fail(Element_Name+" is Not Null",Element_Name+" not Null", screenName);
			t.printStackTrace();
			throw new Exception("Element Not Null");
		}
	}
	
	
	
	public void clickLink(WebDriver screenName,String ObjectxPath,String Element_Name) throws Exception
	{
		try
		{
			WebElement webButton = screenName.findElement(By.xpath(ObjectxPath));
			webButton.click();
			Extent_Reporting.Log_Pass(Element_Name+" Clicked",Element_Name+" Clicked");
		}
		catch(Throwable t)
		{ 
			Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", screenName);
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}
	
	public void clickLinkByLinkText(WebDriver screenName,String linkText,String Element_Name) throws Exception
	{
	    try
		{
			WebElement webButton = screenName.findElement(By.linkText(linkText));
			webButton.click();
			Extent_Reporting.Log_Pass(Element_Name+" Clicked",Element_Name+" Clicked");
		}
	    catch(Throwable t)
		{ 
			Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", screenName);
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	public boolean clickFirst(WebDriver screenName,String ObjectxPath,String Element_Name) throws Exception
	{
		boolean flag=true;
		try
		{
			WebElement webButton = screenName.findElement(By.xpath(ObjectxPath));
			webButton.click();
			Extent_Reporting.Log_Pass(Element_Name+" Clicked",Element_Name+" Clicked");
		}
		 catch(Throwable t)
			{ 
				Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", screenName);
				t.printStackTrace();
				throw new Exception("Element Not Present");
			}
		return flag;
	}
	public void inputText(WebDriver screenName,String ObjectxPath,String sValue,String Element_Name) throws Exception
	{
		try
		{
			WebElement inputText = screenName.findElement(By.xpath(ObjectxPath));
			inputText.clear();
			inputText.sendKeys(sValue);
			Extent_Reporting.Log_Pass(Element_Name+" Entered",sValue + " entered in "+ Element_Name);
		}
		 catch(Throwable t)
		{ 
			Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", screenName);
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
		
	}
	
	public void removeAttribute(WebDriver driver) {
		List<WebElement> inputs = driver.findElements(By.tagName("input"));
		for (WebElement input : inputs) {
			((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", input);
		}
	}

	public void typeNonEditable(WebDriver driver,String ObjectxPath,String sValue,String Element_Name) throws Exception {
		removeAttribute(driver);
		inputText(driver,ObjectxPath,sValue,Element_Name);
	}
	
	public void enterText(WebDriver screenName, String ObjectxPath, String sValue,String Element_Name) throws Exception {
		try
		{
			WebElement inputText = screenName.findElement(By.xpath(ObjectxPath));
			inputText.sendKeys(sValue);
			Extent_Reporting.Log_Pass(Element_Name+" Entered",sValue + " entered in "+ Element_Name);
		}  catch(Throwable t)
		{ 
			Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", screenName);
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
		
	}
	
	
	public void inputText_Enter(WebDriver screenName, String ObjectxPath, String sValue,String Element_Name) throws Exception {
		try
		{
			WebElement inputText = screenName.findElement(By.xpath(ObjectxPath));
			inputText.sendKeys(sValue,Keys.ENTER);
			Extent_Reporting.Log_Pass(Element_Name+" Entered",sValue + " entered in "+ Element_Name);
		}  catch(Throwable t)
		{ 
			Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", screenName);
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
		
	}
	
	
	public void inputTextByID(WebDriver screenName,String ID,String sValue,String Element_Name) throws Exception
	{
		try
		{	WebElement inputText = screenName.findElement(By.id(ID));
			inputText.sendKeys(sValue);
			Extent_Reporting.Log_Pass(Element_Name+" Entered",sValue + " entered in "+ Element_Name);
		}  catch(Throwable t)
		{ 
			Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", screenName);
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
		
	}

	public void selectCheckBox(WebDriver screenName,String ObjectxPath,String Element_Name) throws Exception
	{
		try
		{	WebElement checkBox = screenName.findElement(By.xpath(ObjectxPath));
			checkBox.click();
			Extent_Reporting.Log_Pass(Element_Name+" checkbox clicked",Element_Name+" checkbox clicked");
		}  catch(Throwable t)
		{ 
			Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", screenName);
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}
	public void selectRadio(WebDriver screenName,String ObjectxPath,String Element_Name) throws Exception
	{
		try
		{
			WebElement radioButton = screenName.findElement(By.xpath(ObjectxPath));
			radioButton.click();
			Extent_Reporting.Log_Pass(Element_Name+" radiobutton clicked",Element_Name+" radiobutton clicked");
		}  catch(Throwable t)
		{ 
			Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", screenName);
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	public String getInputTextValue(WebDriver screenName,String ObjectxPath,String Element_Name) throws Exception
	{
		try
		{
			WebElement inputText = screenName.findElement(By.xpath(ObjectxPath));
			Extent_Reporting.Log_Pass(Element_Name+" exist",Element_Name+" has "+ inputText.getText());
			return inputText.getText();
		}
		 catch(Throwable t)
			{ 
				Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", screenName);
				t.printStackTrace();
				throw new Exception("Element Not Present");
			}
	}
	
	public String getInputValue(WebDriver screenName,String ObjectxPath,String Element_Name) throws Exception
	{
		try
		{
			WebElement inputText = screenName.findElement(By.xpath(ObjectxPath));
			Extent_Reporting.Log_Pass(Element_Name+" exist",Element_Name+" has "+ inputText.getText());
			return inputText.getAttribute("value");
		}
		catch(Throwable t)
		{ 
			Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", screenName);
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}
	
	public String getAttributeValue(WebDriver screenName,String ObjectxPath,String attributeName,String Element_Name) throws Exception
	{
		try
		{
			WebElement inputText = screenName.findElement(By.xpath(ObjectxPath));
			Extent_Reporting.Log_Pass(Element_Name+" exist",Element_Name+" has "+ inputText.getText());
			return inputText.getAttribute("attributeName");
		}
		catch(Throwable t)
		{ 
			Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", screenName);
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	public void clearInputTextValue(WebDriver screenName,String ObjectxPath,String Element_Name) throws Exception
	{
		try
		{
			WebElement inputText = screenName.findElement(By.xpath(ObjectxPath));
			inputText.clear();
		}
		catch(Throwable t)
		{ 
			Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", screenName);
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}
	public void clearInputTextValueByName(WebDriver screenName,String name,String Element_Name) throws Exception
	{
		try
		{
			WebElement inputText = screenName.findElement(By.name(name));
			inputText.clear();
		}
		catch(Throwable t)
		{ 
			Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", screenName);
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}
	public void clearAndInputTextValue(WebDriver screenName,String ObjectxPath,String value,String Element_Name) throws Exception
	{
		
		try
		{
			WebElement inputText = screenName.findElement(By.xpath(ObjectxPath));
			Thread.sleep(1000);
			inputText.clear();
			Thread.sleep(1000);
			inputText.sendKeys(value);
			Extent_Reporting.Log_Pass(Element_Name+" cleared & Entered with "+value,Element_Name+" cleared & Entered with "+value);
		}
		catch(Throwable t)
		{ 
			Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", screenName);
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}
	public void selectDropBoxValue(WebDriver screenName,String ObjectxPath,String value,String Element_Name) throws Exception
	{
		try
		{
			WebElement selectDropBox = screenName.findElement(By.xpath(ObjectxPath));
			Select select = new Select(selectDropBox);
			select.selectByValue(value);
			Extent_Reporting.Log_Pass(Element_Name+" selected with "+value,Element_Name+" selected with "+value);
		}
		catch(Throwable t)
		{ 
			Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", screenName);
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}

	}
	
	
	public void isnullandselectDropBoxValue(WebDriver screenName,String ObjectxPath,String Value,String Element_Name) throws Exception
	{
		try
		{
			
	
			String webButton = screenName.findElement(By.xpath(ObjectxPath)).getAttribute("value");
			WebElement inputBox = screenName.findElement(By.xpath(ObjectxPath));
			String textInsideInputBox = inputBox.getAttribute("value");
			
			if(textInsideInputBox.isEmpty())
			{
				
				WebElement selectDropBox = screenName.findElement(By.xpath(ObjectxPath));
				Select select = new Select(selectDropBox);
				select.selectByVisibleText(Value);
			  
			}
			else
			{
				Extent_Reporting.Log_Pass(Element_Name+" Already Exist",Element_Name+" Entered");
			}
			Extent_Reporting.Log_Pass(Element_Name+" Value Entered",Element_Name+" Entered");
		}
		catch(Throwable t)
		{ 
			Extent_Reporting.Log_Fail(Element_Name+" is Not Null",Element_Name+" not Null", screenName);
			t.printStackTrace();
			throw new Exception("Element Not Null");
		}
	}
	
	public void selectDropBoxByVisibleText(WebDriver screenName,String ObjectxPath,String value,String Element_Name) throws Exception
	{
		try
		{
			WebElement selectDropBox = screenName.findElement(By.xpath(ObjectxPath));
			Select select = new Select(selectDropBox);
			select.selectByVisibleText(value);
			Extent_Reporting.Log_Pass(Element_Name+" selected with "+value,Element_Name+" selected with "+value);
		}
		catch(Throwable t)
		{ 
			Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", screenName);
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}
	
	public void selectDropBoxValueByID(WebDriver screenName,String ID,String value,String Element_Name) throws Exception
	{
		try
		{
			WebElement selectDropBox = screenName.findElement(By.id(ID));
			Select select = new Select(selectDropBox);
			select.selectByValue(value);
			Extent_Reporting.Log_Pass(Element_Name+" selected with "+value,Element_Name+" selected with "+value);
		}
		catch(Throwable t)
		{ 
			Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", screenName);
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}

	}
	public void selectDropBoxValueByName(WebDriver screenName,String Name,String value,String Element_Name) throws Exception
	{
		try
		{
			WebElement selectDropBox = screenName.findElement(By.name(Name));
			Select select = new Select(selectDropBox);
			select.selectByValue(value);
			Extent_Reporting.Log_Pass(Element_Name+" selected with "+value,Element_Name+" selected with "+value);
		}
		catch(Throwable t)
		{ 
			Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", screenName);
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}

	}
	public void selectDropBoxValue(WebDriver screenName,String ObjectxPath,int index,String Element_Name) throws Exception
	{
		try
		{
			WebElement selectDropBox = screenName.findElement(By.xpath(ObjectxPath));
			Select select = new Select(selectDropBox);
			select.selectByIndex(index);
			Extent_Reporting.Log_Pass(Element_Name+" selected with "+index,Element_Name+" selected with "+index);
		}
		catch(Throwable t)
		{ 
			Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", screenName);
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}

	}
	public void selectDropBoxDefaultValue(WebDriver screenName,String ObjectxPath,String Element_Name) throws Exception
	{
		try
		{
			WebElement selectDropBox = screenName.findElement(By.xpath(ObjectxPath));
			Select select = new Select(selectDropBox);
			select.selectByIndex(0);
			Extent_Reporting.Log_Pass(Element_Name+" selected with default value ",Element_Name+" selected with default value ");
		}
		catch(Throwable t)
		{ 
			Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", screenName);
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}

	}
	public String getDropBoxDefaultValue(WebDriver screenName,String ObjectxPath,String Element_Name) throws Exception
	{
		try
		{
			WebElement selectDropBox = screenName.findElement(By.xpath(ObjectxPath));
			Select select = new Select(selectDropBox);
			Extent_Reporting.Log_Pass(Element_Name+" selected value is "+select.getFirstSelectedOption().getText(),Element_Name+" selected value is "+select.getFirstSelectedOption().getText());
			return select.getFirstSelectedOption().getText();
			
		}
		catch(Throwable t)
		{ 
			Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", screenName);
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}
	public String getDropBoxSelectedValue(WebDriver screenName,String ObjectxPath,int index,String Element_Name) throws Exception
	{
		try
		{
			WebElement selectDropBox = screenName.findElement(By.xpath(ObjectxPath));
			Select select = new Select(selectDropBox);
			Extent_Reporting.Log_Pass(Element_Name+" selected value is "+select.getFirstSelectedOption().getText(),Element_Name+" selected value is "+select.getFirstSelectedOption().getText());
			return select.getOptions().get(index).getText();
		}
	
		catch(Throwable t)
		{ 
			Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", screenName);
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	public int getDropBoxSize(WebDriver screenName,String ObjectxPath,String Element_Name) throws Exception
	{
		try
		{
			WebElement selectDropBox = screenName.findElement(By.xpath(ObjectxPath));
			Select select = new Select(selectDropBox);
			Extent_Reporting.Log_Pass(Element_Name+" dropbox size is "+select.getOptions().size(),Element_Name+" dropbox size is "+select.getOptions().size());
			return select.getOptions().size();
		}
		catch(Throwable t)
		{ 
			Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", screenName);
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}



	public String[] getDropBoxValue(WebDriver screenName,String ObjectxPath,String Element_Name) throws Exception
	{
		try
		{
			WebElement selectDropBox = screenName.findElement(By.xpath(ObjectxPath));
			Select select =new Select(selectDropBox);
			List<WebElement> optionValue = select.getOptions();
			String[] value = new String[optionValue.size()];
			for(int i =0;i<optionValue.size();i++)
				value[i] = optionValue.get(i).getText();
			return value;
		}
		catch(Throwable t)
		{ 
			Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", screenName);
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}

	}

	public int getTotalTableCell(WebDriver driver,String ObjectxPath,String Element_Name) throws Exception
	{
		try
		{
			Extent_Reporting.Log_Pass(Element_Name+" table size is "+driver.findElements(By.xpath(ObjectxPath)).size(),Element_Name+" table size is "+driver.findElements(By.xpath(ObjectxPath)).size());
			return driver.findElements(By.xpath(ObjectxPath)).size();
		}
		catch(Throwable t)
		{ 
			Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", driver);
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}

	public int getElementsSize(WebDriver driver,String ObjectxPath,String Element_Name) throws Exception
	{
		try
		{
			Extent_Reporting.Log_Pass(Element_Name+" element size is "+driver.findElements(By.xpath(ObjectxPath)).size(),Element_Name+" element size is "+driver.findElements(By.xpath(ObjectxPath)).size());
			return driver.findElements(By.xpath(ObjectxPath)).size();
		}
		catch(Throwable t)
		{ 
			Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", driver);
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}


	public int getElementCount(WebDriver driver,String className,String Element_Name) throws Exception
	{
		int count=0;

		try
		{
			count = driver.findElements(By.className(className)).size();
			Extent_Reporting.Log_Pass(Element_Name+" element count "+count,Element_Name+" element size is "+count);
		}
		catch(Throwable t)
		{ 
			Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", driver);
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
		return count;
	}

	public boolean isElementDisplayed(WebDriver driver,String xpath,String Element_Name,int t)
	{
		boolean flag=false;
		try
		{
			driver.manage().timeouts().implicitlyWait(t, TimeUnit.SECONDS);
			if(driver.findElement(By.xpath(xpath)).isDisplayed())
			{	Extent_Reporting.Log_Pass(Element_Name +" is displayed ", Element_Name +" is displayed ");
				flag = true;
			}
		}
		catch(Throwable e)
		{
			Extent_Reporting.Log_Pass(Element_Name +" is not displayed ", Element_Name +" is not displayed ");
			flag = false;
		}
		return flag;

	}
	public boolean isElementDisplayed(WebDriver driver,String xpath,String Element_Name)
	{
		boolean flag=false;
		try
		{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			if(driver.findElement(By.xpath(xpath)).isDisplayed())
			{	Extent_Reporting.Log_Pass(Element_Name +" is displayed ", Element_Name +" is displayed ");
				flag = true;
			}
		}
		catch(Throwable e)
		{
			Extent_Reporting.Log_Pass(Element_Name +" is not displayed ", Element_Name +" is not displayed ");
			flag = false;
		}
		return flag;

	}

	
	public boolean isElementDisplayedandclick(WebDriver driver,String xpath,String Element_Name)
	{
		boolean flag=false;
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			if(driver.findElement(By.xpath(xpath)).isDisplayed())
			{	Extent_Reporting.Log_Pass(Element_Name +" is displayed ", Element_Name +" is displayed ");
				flag = true;
				WebElement webButton = driver.findElement(By.xpath(xpath));
				webButton.click();
			}
		}
		catch(Throwable e)
		{
			Extent_Reporting.Log_Pass(Element_Name +" is not displayed ", Element_Name +" is not displayed ");
			flag = false;
		}
		return flag;

	}
	
	public boolean isElementDisplay(WebDriver driver,String xpath)
	{
		boolean flag=false;
		try
		{
			if(driver.findElement(By.xpath(xpath)).isDisplayed())
			{	
				flag = true;
			}
		}
		catch(Throwable e)
		{
			e.printStackTrace();
			flag = false;
		}
		return flag;

	}
	
	//  Rohit - ETS -- 11 June 2015
	public void mouseHoverAction_3(WebDriver driver,String mainElementXP, String subElementXP,String subSubElementXP,String Element_Name) throws Exception{
        try
        {
			Actions action = new Actions(driver);
			WebElement mainElement = driver.findElement(By.xpath(mainElementXP));
			action.moveToElement(mainElement).perform();
			WebElement subElement = driver.findElement(By.xpath(subElementXP));
			action.moveToElement(subElement).perform();
			WebElement subSubElement = driver.findElement(By.xpath(subSubElementXP));
			action.moveToElement(subSubElement);
			action.click();
			action.perform();
			
			Extent_Reporting.Log_Pass("Click action is performed on the selected Product Type"+Element_Name,"Click action is performed on the selected Product Type"+Element_Name);
	     }
        catch(Throwable t)
		{ 
			Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", driver);
			t.printStackTrace();
			throw new Exception("Element Not Present");
		}
	}
	public void mouseHoverAction_2(WebDriver driver,String mainElementXP, String subElementXP,String Element_Name) throws Exception{
      try
      {
		Actions action = new Actions(driver);
		WebElement mainElement = driver.findElement(By.xpath(mainElementXP));
		action.moveToElement(mainElement).perform();
		WebElement subElement = driver.findElement(By.xpath(subElementXP));
		action.moveToElement(subElement);
		action.click();
		action.perform();
		
		Extent_Reporting.Log_Pass("Click action is performed on the selected Product Type"+Element_Name,"Click action is performed on the selected Product Type"+Element_Name);
    }
   catch(Throwable t)
	{ 
		Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", driver);
		t.printStackTrace();
		throw new Exception("Element Not Present");
	}
	}
	public void mouseHoverAction(WebDriver driver,String mainElementXP,String Element_Name) throws Exception{
      try
      {
		Actions action = new Actions(driver);
		WebElement mainElement = driver.findElement(By.xpath(mainElementXP));
		action.moveToElement(mainElement).clickAndHold().build().perform();
		action.release().perform();
	//action.perform();
		
		Extent_Reporting.Log_Pass("Click action is performed on the selected Product Type"+Element_Name,"Click action is performed on the selected Product Type"+Element_Name);
    }
   catch(Throwable t)
	{ 
		Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", driver);
		t.printStackTrace();
		throw new Exception("Element Not Present");
	}
	}
	
	public void mouseHoverAction(WebDriver driver,String mainElementXP, String subElementXP,String subSubElementXP, String subBesideElementXP,String Element_Name) throws Exception{
    try
    {
		Actions action = new Actions(driver);
		WebElement mainElement = driver.findElement(By.xpath(mainElementXP));
		action.moveToElement(mainElement).perform();
		WebElement subElement = driver.findElement(By.xpath(subElementXP));
		action.moveToElement(subElement).perform();
		WebElement subSubElement = driver.findElement(By.xpath(subSubElementXP));
		action.moveToElement(subSubElement).perform();
		WebElement subBesideElement = driver.findElement(By.xpath(subBesideElementXP));
		action.moveToElement(subBesideElement).perform();
		action.click();
		action.perform();
		
		Extent_Reporting.Log_Pass("Click action is performed on the selected Product Type"+Element_Name,"Click action is performed on the selected Product Type"+Element_Name);
    }
   catch(Throwable t)
	{ 
		Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", driver);
		t.printStackTrace();
		throw new Exception("Element Not Present");
	}
	}
	
	public void selectclass(WebDriver driver,WebElement parent,String elementToSelect,String Element_Name) throws Exception{
        try
        {
		Select dropdown = new Select(parent);
		dropdown.selectByVisibleText(elementToSelect);
		Extent_Reporting.Log_Pass("selected "+elementToSelect,"selected "+elementToSelect+"in "+parent);
        }
       catch(Throwable t)
    	{ 
    		Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", driver);
    		t.printStackTrace();
    		throw new Exception("Element Not Present");
    	}
    	

	}
	
	
	public void getWindowHandle(WebDriver driver , String title) {
		Set<String> handles = driver.getWindowHandles();

		String[] browser =	handles.toArray(new String[0]);
		System.out.println("Number of browsers opened are"
				+ browser.length);
		for (int i=0; i<handles.size();i++) {

			driver.switchTo().window(browser[i]);
			if(driver.getTitle().equals(title)){
				driver.getWindowHandle();

			}

		}

	} 
	
	public void selectWindowIfElementPresent(WebDriver driver, String element) throws InterruptedException {
		Thread.sleep(2000);
		Set<String> windows = driver.getWindowHandles();
		Object[] win = windows.toArray(); System.out.println(win.length);
		driver.switchTo().window(win[0].toString());
		if (isElementDisplay(driver, element)) {
			Extent_Reporting.Log_Pass("Selected Pop Up : " + driver.switchTo().window(win[0].toString()).getTitle(),"Selected Pop Up : " + driver.switchTo().window(win[0].toString()).getTitle());
		} else {
			driver.switchTo().window(win[1].toString());
			System.out.println("Selected Pop Up : " + driver.switchTo().window(win[1].toString()).getTitle());
		}
	}
	
	public void waitForElementNotPresent(WebDriver driver, String element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(element)));
		} catch (TimeoutException te) {
		}
	}
	
	public void waitForElementByPolling(WebDriver driver,final String xpath) {
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					 
				       .withTimeout(60, TimeUnit.SECONDS)
				 
				       .pollingEvery(500, TimeUnit.MILLISECONDS)
				 
				       .ignoring(NoSuchElementException.class);
				 
				 
				 
				   WebElement element = wait.until(new Function<WebDriver, WebElement>() {
				 
				     public WebElement apply(WebDriver driver) {
				 
				       return driver.findElement(By.xpath(xpath));
				 
				     }
				 
				   });
				   
				   System.out.println("Element display ="+ element.isDisplayed());
				   
				   
		} catch (TimeoutException te) {
		}
	}
	
	public void waitForElementVisible(WebDriver driver, String element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
		} catch (NoSuchWindowException e) {
		} catch (InvalidElementStateException e) {
		} catch (TimeoutException te) {
		} catch (NoSuchElementException e) {
		} catch (WebDriverException we) {
		}
	}
	
	public void waitForElementClickable(WebDriver driver, String element,String text) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
		} catch (NoSuchWindowException e) {
		} catch (InvalidElementStateException e) {
		} catch (TimeoutException te) {
		} catch (NoSuchElementException e) {
		} catch (WebDriverException we) {
		}
	}
	
	public void waitForTextPresent(WebDriver driver, String text) throws InterruptedException {
		try {
			Thread.sleep(2000);
			long timer = 0;
			while (isTextPresent(driver, text) == false && timer < Long.valueOf("30000")) {
				Thread.sleep(500);
				timer += 5000;
			}
		} catch (NoSuchWindowException e) {
		}
	}
	
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(new Common_Functions().GetXMLTagValue(Constants.configPath+"Config.xml", "timeout")), TimeUnit.SECONDS);
	}

	
	public boolean isTextPresent(WebDriver driver, String text) {
		boolean flag = false;
		try {
			flag = driver.findElement(By.xpath("//*[contains(.,'" + text + "')]")).isDisplayed();
		} catch (NoSuchElementException e) {
			return flag;
		} catch (NoSuchWindowException e) {
			return flag;
		}
		return flag;
	}
	
	public void getTableData(WebDriver driver , String xpath)
	{
		// Grab the table 
		WebElement table = driver.findElement(By.xpath(xpath)); 

		// Now get all the TR elements from the table 
		List<WebElement> allRows = table.findElements(By.tagName("tr")); 

		// And iterate over them, getting the cells 
		for (WebElement row : allRows) { 
		    List<WebElement> cells = row.findElements(By.tagName("td")); 

		    // Print the contents of each cell
		    for (WebElement cell : cells) { 
		        System.out.println(cell.getText());
		    }
		}
	}
	
	
	//Function for fetching the value from the object when value attribute is not present.
	public String getObjectValue(WebDriver driver,WebElement webElement) {
        JavascriptExecutor e = (JavascriptExecutor) driver;
        return (String) e.executeScript(String.format("return $('#%s').val();", webElement.getAttribute("id")));
	}
	
	public String getObjectValueClass(WebDriver driver,WebElement webElement) {
        JavascriptExecutor e = (JavascriptExecutor) driver;
        return (String) e.executeScript(String.format("return $('#%s').val();", webElement.getAttribute("class")));
	}
	
	/*public void doubleClick(WebDriver driver,WebElement myElemment) throws InterruptedException
	{
		if(isElementPresentByXpath(driver, myElemment))
		{
		Actions action = new Actions(driver);
		action.moveToElement(myElemment);
		Thread.sleep(2000);
		action.doubleClick();
		//action.doubleClick(myElemment);
		action.build().perform();
		}
		else
		{
			throw new Exception("selectDropBoxValue() --- >Element Not Present");
		}
	}
	 */
	public int getElementCountXPath(WebDriver driver, String ObjectPath,String Element_Name) throws InterruptedException {
		int count = 0;
		if (isElementPresentByXpath(ObjectPath, driver,Element_Name)) {
			count = driver.findElements(By.xpath(ObjectPath)).size();
		}
		return count;
	}
	
	public void acceptAlert(WebDriver driver) throws InterruptedException {
		try {
			Alert alert = waitforAlertPresent(driver);
			if (!alert.equals(null))
				alert.accept();
		} catch (NoAlertPresentException ex) {
		}
	}
	
	public Alert waitforAlertPresent(WebDriver driver) throws InterruptedException {
		int i = 0;
		Alert alert = null;
		while (i++ < 30) {
			try {
				alert = driver.switchTo().alert();
				return alert;
			} catch (NoAlertPresentException e) {
				Thread.sleep(1000);
				continue;
			}
		}
		return alert;
	}
	public void waitForPopUp(WebDriver driver, String b) throws InterruptedException {
		Thread.sleep(3000);
		try {
			selectPopUp(driver, b);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (NoSuchWindowException e1) {
		} catch (Exception e) {
		}
	}
	
	public void selectPopUp(WebDriver driver, String arg) {
		boolean flag = false;
		try {
			for (int i = 0; i < 2 && flag == false; i++) {
				Set<String> pops = driver.getWindowHandles();
					Iterator<String> it = pops.iterator();
					if (pops.size() > 1) {
						System.out.println("No of Windows " + pops.size());
						for (int j = 0; j < pops.size() && flag == false; j++) {
							String popupHandle = it.next().toString();
							if (driver.switchTo().window(popupHandle).getTitle().contains(arg)) {
								driver.switchTo().window(popupHandle);
								flag = true;
							}
						}flag = true;
						pops.clear();
					}
			}
		} catch (NoSuchWindowException e) {
			System.out.println("Not able to Navigate to Window " + arg);
		} catch (Exception e) {
		}
	}
	
	public void checkUsingJavaScript(WebDriver driver, String obj,String ObjectName ) throws InterruptedException {
		try
		{
		WebElement element = null;
		if(obj.startsWith("id")){
			element = driver.findElement(By.id(obj.split("id:")[1]));	
		}else if(obj.startsWith("name")){
			element = driver.findElement(By.name(obj.split("name:")[1]));
		}else{
			element = driver.findElement(By.xpath(obj));
		}
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Extent_Reporting.Log_Pass(ObjectName+" clicked", ObjectName+" Ciicked");
		}
		catch(Throwable t)
		{
		
			Extent_Reporting.Log_Fail(ObjectName+" Not Present", ObjectName+" Not Present", driver);
			t.printStackTrace();
			new Exception(ObjectName+" not present");
		}
	}


	public void waitForFrameAndSwitch(WebDriver driver , String frameName) {
		WebDriverWait wait = new WebDriverWait(driver,60);
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
		
	}
	
	public void waitForFrameAndSwitch(String frameXpath,WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,60);
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath(frameXpath)));
		
	}
	
	
	public void waitForElementVisible(WebDriver driver, String element,String Element_Name) throws Throwable {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 300);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
			
			
		} 
		 catch (Throwable we) {
			 we.printStackTrace();
			 Extent_Reporting.Log_Fail(Element_Name+"Not visible", Element_Name+"Not visible", driver);
		}
	}
	
	
	public void waitForElementVisibleandenter(WebDriver driver,String xpath, String element,String Element_Name) throws Throwable {
		try {
			
			
			
			WebDriverWait wait = new WebDriverWait(driver, 300);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			WebElement inputText = driver.findElement(By.xpath(xpath));
			inputText.sendKeys(element);
		} 
		 catch (Throwable we) {
			 we.printStackTrace();
			 Extent_Reporting.Log_Fail(Element_Name+"Not visible", Element_Name+"Not visible", driver);
		}
	}
	

public void Javascriptexecutor_forClick(WebDriver driver , String frameName,String XpathObject,String ObjectName) throws Throwable {
	waitForPageToLoad(driver);
	waitForFrameAndSwitch(driver, frameName);
	waitForPageToLoad(driver);
	waitForElementVisible(driver, XpathObject,ObjectName);
	try
	{
			WebElement e=driver.findElement(By.xpath(XpathObject));
	
			JavascriptExecutor js = (JavascriptExecutor)driver;
			
			
			js.executeScript("arguments[0].click();", e);
			Extent_Reporting.Log_Pass(ObjectName+" clicked", ObjectName+" Ciicked");
			js=null;
			e=null;
	}
	catch(Throwable t)
	{
	
		Extent_Reporting.Log_Fail(ObjectName+" Not Present", ObjectName+" Not Present", driver);
		t.printStackTrace();
		new Exception(ObjectName+" not present");
	}

	
}

public String[] findElementsInArray(WebDriver driver, String ObjectxPath,String ObjectName) throws InterruptedException, Exception {
	String[] array = null;
	int i = 0;
	if (isElementPresentByXpath(ObjectxPath, driver, ObjectName)) {
		List<WebElement> list = driver.findElements(By.xpath(ObjectxPath));
		array = new String[list.size()];
		Iterator<WebElement> it = list.iterator();
		while (it.hasNext()) {
			array[i++] = it.next().getText();
		}
	} else {
		Extent_Reporting.Log_Fail("findElementsInArray", ObjectxPath + " is not present", driver);
		throw new Exception("findElementsInArray() --- >Element Not Present");
	}
	return array;
}

public void removeAttribute(WebDriver driver,String ObjectXpath) {
	WebElement input = driver.findElement(By.xpath(ObjectXpath));
	
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('disabled','disabled')", input);
	
}

public void clickUsingActions(WebDriver screenName,String ObjXpath,String Element_Name) throws Exception
{
	try
	{
		Actions actions = new Actions(screenName);
		WebElement webButton = screenName.findElement(By.xpath(ObjXpath));
		actions.click(webButton);
		Extent_Reporting.Log_Pass(Element_Name+" Clicked",Element_Name+" Clicked");
	}
	catch(Throwable t)
	{
		Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", screenName);
		t.printStackTrace();
		throw new Exception("Element Not Present");
	}
}

public List<WebElement> findElementsInList(WebDriver driver, String ObjectxPath,String ObjectName) throws InterruptedException, Exception {
	
	List<WebElement> list=null;
	
	
	if (isElementPresentByXpath(ObjectxPath, driver, ObjectName)){ 
		list = driver.findElements(By.xpath(ObjectxPath));	
		
	} else {
		Extent_Reporting.Log_Fail("findElementsInArray", ObjectxPath + " is not present", driver);
		throw new Exception("findElementsInArray() --- >Element Not Present");
	 }
	return list;
}

public boolean selectWindow(String windowname,WebDriver driver) {

    try {

            Thread.sleep(1000);

    } catch (InterruptedException e1) {

            e1.printStackTrace();

    }

    boolean selWindow = false;

    try {

            if (windowname != null) {

                    if (windowname.contains("null")) {

                            switchToWindow(1,driver);

                            selWindow = true;

                    } else {

                            selectPopUp(windowname,driver);

                            selWindow = true;

                    }

            } else {

                    switchToWindow(1,driver);

                    selWindow = true;

            }

    } catch (Exception e) {

            {

                    e.getMessage();

                    e.printStackTrace();

                    switchToWindow(1,driver);

                    selWindow = false;

            }

    }

    return selWindow;

}

public void switchToWindow(int WindowNumber,WebDriver driver) {

    WindowNumber = WindowNumber - 1;

    Set<String> windows = driver.getWindowHandles();

    Object[] win = windows.toArray();

    driver.switchTo().window(win[WindowNumber].toString());

}

public void selectPopUp(String arg,WebDriver driver) {

    boolean flag = false;

    try {

            for (int i = 0; i < 2 && flag == false; i++) {

                    Set<String> pops = driver.getWindowHandles();

                    {

                            Iterator<String> it = pops.iterator();

                            if (pops.size() > 1) {

                                    System.out.println("No of Windows " + pops.size());

                                    for (int j = 0; j < pops.size() && flag == false; j++) {

String popupHandle = it.next().toString();

                                            if (driver.switchTo().window(popupHandle).getTitle().contains(arg)) {

                                                    driver.switchTo().window(popupHandle);

                                                    flag = true;

                                            }

                                    }

                                    pops.clear();

                            }

                    }

            }

    } catch (NoSuchWindowException e) {

            System.out.println("Not able to Navigate to Window " + arg);

    } catch (Exception e) {

    }

}



public void waitUntilExist(WebDriver driver,String ObjectxPath) throws Exception
{
	driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	int i=1;
	do{
		
		i=i+1;
		Thread.sleep(1000);
	
	try
	{
		WebElement webButton = driver.findElement(By.xpath(ObjectxPath));
		System.out.println("X"+i);
		webButton.getText();
	}
	catch(Throwable t)
	{ 
		break;
		
	}
	}while(i<100);
	waitForPageToLoad(driver);
	
}
public boolean  CheckifExist(WebDriver driver, String element,int number) {
try {
	driver.manage().timeouts().implicitlyWait(number, TimeUnit.MILLISECONDS);
	WebDriverWait wait = new WebDriverWait(driver, number);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
	//driver.findElement(By.xpath(element));
	waitForPageToLoad(driver);
	return true;
	
} catch (Exception e) {
	System.out.println("not exist");
	waitForPageToLoad(driver);
	return false;


}
}

public void Clickbtn(WebDriver screenName,String ObjectxPath,String Element_Name) throws Exception
{
	Thread.sleep(500);
	try
	{
		WebElement webButton = screenName.findElement(By.xpath(ObjectxPath));
		
		webButton.click();
		Extent_Reporting.Log_Pass(Element_Name+" Clicked",Element_Name+" Clicked");
	}
	catch(Throwable t)
	{ 
		Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", screenName);
		t.printStackTrace();
		throw new Exception("Element Not Present");
	}
}

public void Clickbtn3(WebDriver screenName,String ObjectCSS,String Element_Name) throws Exception
{
	Thread.sleep(500);
	try
	{
		WebElement webButton = screenName.findElement(By.cssSelector(ObjectCSS));
		webButton.click();
		Extent_Reporting.Log_Pass(Element_Name+" Clicked",Element_Name+" Clicked");
	}
	catch(Throwable t)
	{ 
		Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", screenName);
		t.printStackTrace();
		throw new Exception("Element Not Present");
	}
}
public void Clickbtn2(WebDriver screenName,String ObjectxPath,String Element_Name) throws Exception
{
	Thread.sleep(500);
	try
	{
		WebElement webButton = screenName.findElement(By.xpath(ObjectxPath));
		webButton.click();
		Extent_Reporting.Log_Pass(Element_Name+" Clicked",Element_Name+" Clicked");
	}
	catch(Throwable t)
	{ 
		//Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", screenName);
		//t.printStackTrace();
		throw new Exception("Element Not Present");
	}
}

public void WaitFunction(WebDriver driver,String Message) throws Exception   
{
	waitUntilExist(driver, "//*[contains(text(),'Loading...')]");
	waitUntilExist(driver, "//*[contains(text(),'Loading...')]");
	if(CheckifExist(driver, "//*[contains(text(),'Attention')]", 3)) 
	{
		Extent_Reporting.Log_Fail("Attention Error Occured", "Attention Error Occured"+Message, driver);
		new Exception("Attention Error Occured");
	}
	
}

public void waituntilDisplayed(WebDriver driver,String xpath) throws InterruptedException

{
	int i=1;
	
	boolean x=false;
	do
	{
		i=i+1;
		Thread.sleep(2000);
		try
		{
			x=driver.findElement(By.xpath(xpath)).isDisplayed();
			
		}
		catch(Throwable t)
		{
			
		}
		if(i==60)
		{
			break;
		}
		
	}while(x==false);
	
}
public boolean  CheckifTextExistAndReport(WebDriver driver, String element,String Element_Name) throws InterruptedException {
	try {
		//driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
		String Strelement="//*[contains(text(),'"+element+"')]";
		driver.findElement(By.xpath(Strelement));
		Extent_Reporting.Log_Pass(Element_Name + " Exist", Element_Name + " is Exist");
		System.out.println("Element Exist");
	//	return true;
		//driver.switchTo().defaultContent();
		//System.out.println(""+driver.getPageSource().toString());
		//System.out.println("");
	//	if (driver.getPageSource().contains(element))
	//	{
		waitForPageToLoad(driver);
			return true;
	//	}
	//	else
	//	{
		//	return false;
	//	}
		
		
	} catch (Throwable t) {
		waitForPageToLoad(driver);
		System.out.println("not exist");
		t.printStackTrace();
		Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + "does not Exist",driver);
		
		return false;
	}
		
	
	
	
}
public boolean  CheckifExistwithWait (WebDriver driver, String element) {
	try {
		//driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
	//	WebDriverWait wait = new WebDriverWait(driver, 1);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
		driver.findElement(By.xpath(element));
		// waitForPageToLoad(driver);
		return true;
		
	} catch (Throwable e) {
		//e.printStackTrace();
		
		return false;
	}
}





public void MouseClick(WebDriver driver,String Xpath) throws AWTException
{
	  Robot bot = new Robot();
	   WebElement e= driver.findElement(By.xpath(Xpath));
	   int x=e.getLocation().getX();
	   int y=e.getLocation().getY();
	   System.out.println(x+" "+y);
	    bot.mouseMove(x, y);    
	    bot.mousePress(InputEvent.BUTTON1_MASK);
	    bot.mouseRelease(InputEvent.BUTTON1_MASK);
}

public int getTableRowCount(WebDriver driver,String xapth)
{
	try
	{
	WebElement htmltable=driver.findElement(By.xpath(xapth));
	
	List<WebElement> rows=htmltable.findElements(By.tagName("tr"));
	//List<WebElement> columns=rows.get(1).findElements(By.tagName("td"));

	//System.out.println("Number of columns:"+rows.size());
	System.out.println(rows.size());
	 return rows.size();
	}
	catch(Throwable t)
	{
		t.printStackTrace();
		return 0;
	}
	
}




public boolean  CheckifTextExistwithoutReport(WebDriver driver, String element,String Element_Name) throws InterruptedException {
	try {
		//driver.manage().timeouts().implicitlyWait(0, TimeUnit.MILLISECONDS);
		String Strelement="//*[contains(text(),'"+element+"')]";
		driver.findElement(By.xpath(Strelement));
	//	Extent_Reporting.Log_Pass(Element_Name + " Exist", Element_Name + " is Exist");
		System.out.println("Element Exist");
	//	return true;
		//driver.switchTo().defaultContent();
		//System.out.println(""+driver.getPageSource().toString());
		//System.out.println("");
	//	if (driver.getPageSource().contains(element))
	//	{
		waitForPageToLoad(driver);
			return true;
	//	}
	//	else
	//	{
		//	return false;	//	}
		
		
	} catch (Throwable t) {
		waitForPageToLoad(driver);
		System.out.println("not exist");
		//t.printStackTrace();
		//Extent_Reporting.Log_Fail(Element_Name + " does not Exist", Element_Name + "does not Exist",driver);
		
		return false;
	}
		
	
	
	
}
public void Javascriptexecutor_forClick(WebDriver driver ,String XpathObject,String ObjectName) throws Throwable {
	waitForPageToLoad(driver);
	//waitForFrameAndSwitch(driver, frameName);
	waitForPageToLoad(driver);
	//waitForElementVisible(driver, XpathObject,ObjectName);
	try
	{
			WebElement e=driver.findElement(By.xpath(XpathObject));
	
			JavascriptExecutor js = (JavascriptExecutor)driver;
			
			
			js.executeScript("arguments[0].click();", e);
			Extent_Reporting.Log_Pass(ObjectName+" clicked", ObjectName+" Ciicked");
			js=null;
			e=null;
	}
	catch(Throwable t)
	{
	
		Extent_Reporting.Log_Fail(ObjectName+" Not Present", ObjectName+" Not Present", driver);
		t.printStackTrace();
		new Exception(ObjectName+" not present");
	}

	
}

public void javascriptExecutor_Setvalue(WebDriver driver,String Xpath,String data,String ElementName)
{
       WebElement VVIN = driver.findElement(By.xpath(Xpath));
       JavascriptExecutor myExecutor = ((JavascriptExecutor) driver);

       myExecutor.executeScript("arguments[0].value='"+data+"';",VVIN);
       Extent_Reporting.Log_Pass(ElementName+" is set with "+data, ElementName+" is set with "+data);
       
}

public void inputTextwithClick(WebDriver screenName,String ObjectxPath,String sValue,String Element_Name) throws Exception
{
       try
       {
              WebElement inputText = screenName.findElement(By.xpath(ObjectxPath));
              //elementHighlight(screenName,inputText);
              inputText.click();
              inputText.clear();
              System.out.println(sValue);
              inputText.sendKeys(sValue);
              inputText.sendKeys(Keys.ENTER);
              Extent_Reporting.Log_Pass(Element_Name+" Entered",sValue + " entered in "+ Element_Name);
       }
       catch(Throwable t)
       { 
              Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", screenName);
              t.printStackTrace();
              throw new Exception("Element Not Present");
       }
       
}

public void HandleAuthentication(WebDriver driver){
	WebDriverWait wait = new WebDriverWait(driver, 10);  
	Alert alert = wait.until(ExpectedConditions.alertIsPresent());     
	alert.authenticateUsing(new UserAndPassword("INOS006576", "Feb@4114"));
}



public void DragandDrop(WebDriver driver,String from,String to,String Element_Name) throws Exception
{
	try {
	WebElement drag = driver.findElement(By.id(from));
	WebElement drop = driver.findElement(By.id(to));
	
	Actions builder = new Actions(driver);
	 
	Action dragAndDrop = builder.clickAndHold(drag).moveToElement(drop).release(drop).build();
	dragAndDrop.perform();
			 
	Extent_Reporting.Log_Pass(Element_Name+" Clicked",Element_Name+" Clicked");
}
catch(Throwable t)
{
	Extent_Reporting.Log_Fail(Element_Name+" does not Exist",Element_Name+" does not Exist", driver);
	t.printStackTrace();
	throw new Exception("Element Not Present");
	
	

}
	
	
}

public boolean checkElementDisplayedBy(WebDriver driver,String locator) {
	try {
	WebDriverWait wait = new WebDriverWait(driver,30);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
   boolean check =driver.findElement(By.xpath(locator)).isDisplayed();
   return check;
	}
	catch(NoSuchElementException exception) {
		System.out.println("I got No Such Element Excxeption.."+exception.getMessage());
		exception.printStackTrace();
		return false;
	}
	catch(Exception exception) {
		exception.printStackTrace();
		return false;
	}
}

//date formate should be -28-Mar-2019 ,dd-mm-yyyy
public void setDate(WebDriver driver,String locator,String date) throws InterruptedException {
	//Click on calender icon
	driver.findElement(By.xpath(locator)).click();
	
	WebElement middleLink = driver.findElement(By.xpath("//button[@ng-click=\"toggleMode()\"]"));
	WebElement forwardArrow = driver.findElement(By.xpath("//button[contains(@class,'btn btn-default btn-sm pull-right')]"));
	WebElement backwardArrow = driver.findElement(By.xpath("//button[contains(@class,'btn btn-default btn-sm pull-left')]"));
	
	System.out.println("Date is"+ date);
	String [] dateArray = date.split("/");
    int yearDiff = Integer.parseInt(dateArray[2])- Calendar.getInstance().get(Calendar.YEAR);

    middleLink.click();
    if(yearDiff!=0){
        //if you have to move next year
        if(yearDiff>0){
            for(int i=0;i< yearDiff;i++){
                System.out.println("Year Diff->"+i);
                forwardArrow.click();
            }
        }
        //if you have to move previous year
        else if(yearDiff<0){
            for(int i=0;i< (yearDiff*(-1));i++){
                System.out.println("Year Diff->"+i);
                backwardArrow.click();
            }
        }
    }
    
    List<WebElement> list_AllMonthToBook = driver.findElements(By.xpath("//div[@ng-switch=\"datepickerMode\"]//table//tbody//td[not(contains(@class,'k-other-month'))]"));
    list_AllMonthToBook.get(Integer.parseInt(dateArray[1])-1).click();
    Thread.sleep(1000);
    
    //get all dates from calendar to select correct one
    List<WebElement> list_AllDateToBook = driver.findElements(By.xpath("//div[@ng-switch='datepickerMode']//table//tbody//td//button/span[@class='ng-binding']"));
    list_AllDateToBook.get(Integer.parseInt(dateArray[0])-1).click();
}


}