package com.veskp.test.scenario1;

import org.testng.annotations.Test;

import com.veskp.framework.core.*;
import com.veskp.framework.library.*;
import com.veskp.framework.selenium.*;



/**
 * Template test
 * @author BNPP-TCoE
 */
public class Template extends TestCase
{
	@Test(enabled = false)
	public void runTemplate()
	{
		// Modify the test parameters as required
		testParameters.setCurrentTestDescription("Template test");
		testParameters.setIterationMode(IterationOptions.RunOneIterationOnly);
		testParameters.setBrowser(Browser.InternetExplorer);
		
		driverScript = new DriverScript(testParameters);
		driverScript.driveTestExecution();
	}
	
	@Override
	public void setUp()
	{
		// report.addTestLogSection("Setup");	// Uncomment this line if you implement the setUp() function
	}
	
	@Override
	public void executeTest()
	{
		// Specify the main test logic here
	}
	
	@Override
	public void tearDown()
	{
		// report.addTestLogSection("Teardown");	// Uncomment this line if you implement the tearDown() function
	}
}