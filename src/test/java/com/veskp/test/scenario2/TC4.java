package com.veskp.test.scenario2;

import org.testng.annotations.Test;

import com.veskp.framework.core.*;
import com.veskp.framework.library.*;
import com.veskp.framework.selenium.*;
import com.veskp.test.library.*;



/**
 * Test for book flight tickets and verify booking
 * @author BNPP-TCoE
 */
public class TC4 extends TestCase
{
	private FunctionalLibrary functionalLibrary;
	
	@Test
	public void runTC4()
	{
		testParameters.setBrowser(Browser.Mobile);
		//testParameters.setBrowserVersion("7.0");		
		testParameters.setCurrentTestDescription("Test for Expenses Tracker applicaton");
		testParameters.setIterationMode(IterationOptions.RunOneIterationOnly);		
		
		driverScript = new DriverScript(testParameters);
		driverScript.driveTestExecution();
	}
	
	@Override
	public void setUp()
	{			
		report.addTestLogSection("Setup");		
		report.updateTestLog("Invoke Application", "Invoke the Mobile application under test", Status.DONE);	
    }
	
	@Override
	public void executeTest()
	{
		functionalLibrary = new FunctionalLibrary(scriptHelper);
		functionalLibrary.login();
	}	
	
	@Override
	public void tearDown()
	{
		report.addTestLogSection("Teardown");		
		functionalLibrary.logout();
	}
}