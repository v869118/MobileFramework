package com.veskp.test.scenario1;

import org.testng.annotations.Test;

import com.veskp.framework.core.*;
import com.veskp.framework.library.*;
import com.veskp.test.library.*;


/**
 * Test for login with valid user credentials
 * @author BNPP-TCoE
 */
public class TC1 extends TestCase
{
	private FunctionalLibrary functionalLibrary;
	
	@Test()
	public void runTC1()
	{
		testParameters.setCurrentTestDescription("Test for login with valid user credentials");
		testParameters.setIterationMode(IterationOptions.RunOneIterationOnly);
		//testParameters.setBrowser(Browser.HtmlUnit);
		
		driverScript = new DriverScript(testParameters);
		driverScript.driveTestExecution();
	}
	
	@Override
	public void setUp()
	{
		functionalLibrary = new FunctionalLibrary(scriptHelper);
		report.addTestLogSection("Setup");
		
		driver.get(properties.getProperty("ApplicationUrl"));
		report.updateTestLog("Invoke Application", "Invoke the application under test @ " +
								properties.getProperty("ApplicationUrl"), Status.DONE);
	}
	
	@Override
	public void executeTest()
	{
		functionalLibrary.login();
		functionalLibrary.verifyLoginValidUser();
		functionalLibrary.logout();
	}
	
	@Override
	public void tearDown()
	{
		// Nothing to do
	}
}