package com.reports.beallsCustom;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
public class Executor {
	
	CustomReporter reporter = null;
	@BeforeTest
	public void init()
	{
	reporter = new CustomReporter();

	}
	
	
	@Test
	public void testOne()
	{
		reporter.startParent("Scenario One", "Checks scenario one ");
		reporter.reportParent("Pass", "All cases passed");
		
		reporter.startChild("Test case one", "High to Low");
		reporter.reportChild("Pass", "High to low passed");
		
		reporter.startChild("Test Case 2", "Low To High");
		reporter.reportChild("Pass", "Low to high passed");
		
		reporter.startChild("Test Case 3", "Highest Rarings");
		reporter.reportChild("Pass", "Highest ratings passed");
		
		reporter.endChildTest();
		reporter.endParentTest();
		
		reporter.end();
	}
	
	@Test
	public void testTwo()
	{
		reporter.startParent("Scenario Two", "Checks scenario two ");
		reporter.reportParent("Fail", "All cases passed");
		
		reporter.startChild("Test case one", "Items/ page 30");
		reporter.reportChild("Fail", "Items/ page 30");
		
		reporter.startChild("Test Case 2", "Items/ Page 60");
		reporter.reportChild("Pass", "Items/ Page 60");
		
		reporter.startChild("Test Case 3", "Items / Page 90");
		reporter.reportChild("Pass", "Items / Page 90");
		
		reporter.endChildTest();
		reporter.endParentTest();
		
		reporter.end();
	}
	
	
	 

}
