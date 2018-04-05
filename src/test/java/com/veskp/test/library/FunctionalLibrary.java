package com.veskp.test.library;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.veskp.framework.core.*;
import com.veskp.framework.library.*;
import com.veskp.framework.selenium.*;

/**
 * Functional Library class
 * @author BNPP-TCoE
 */
public class FunctionalLibrary extends ReusableLibrary
{
	/**
	 * Constructor to initialize the functional library
	 * @param scriptHelper The {@link ScriptHelper} object passed from the {@link DriverScript}
	 */
		
	public FunctionalLibrary(ScriptHelper scriptHelper)
	{
		super(scriptHelper);
	}
	
	public void login()
	{
		String userName = dataTable.getData("General_Data","Username");
		String password = dataTable.getData("General_Data","Password");
		/*
		driver.findElement(By.id("com.vinsol.expensetracker:id/home_text")).click();		
		driver.findElement(By.id("com.vinsol.expensetracker:id/edit_amount")).sendKeys("123456789");
		driver.findElement(By.id("com.vinsol.expensetracker:id/edit_tag")).sendKeys(userName);
		driver.findElement(By.id("com.vinsol.expensetracker:id/edit_tag")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("com.vinsol.expensetracker:id/edit_tag")).sendKeys(password);		
		*/
		driver.findElement(By.id("home_text")).click();		
		driver.findElement(By.id("edit_amount")).sendKeys("123456789");
		driver.findElement(By.id("edit_tag")).sendKeys(userName);
		driver.findElement(By.id("edit_tag")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("edit_tag")).sendKeys(password);	
		
		report.updateTestLog("Login", "Enter login credentials: " +
										"Username = " + userName + ", " +
										"Password = " + password, Status.DONE);
	}
	
	public void verifyLoginValidUser()
	{
		WebDriverUtil driverUtil = new WebDriverUtil(driver);
		if(driverUtil.objectExists(By.linkText("SIGN-OFF"))) {
			report.updateTestLog("Verify Login", "Login succeeded for valid user", Status.PASS);
		} else {
			frameworkParameters.setStopExecution(true);
			throw new FrameworkException("Verify Login", "Login failed for valid user");
		}
	}
	
	public void logout()
	{
		driver.findElement(By.id("com.vinsol.expensetracker:id/edit_save_entry")).click();
		report.updateTestLog("Logout", "Click the sign-off link", Status.DONE);
	}
}