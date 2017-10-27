package com.Pages.AllBealls;

import com.GenericFunctions.WebDriver.GenericFunctionsExtra;
import com.classs.usage.TestClass;
import com.constants.string.TopNavigationConstands;
import com.excellibrary.bealls.ExcelLibrary;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.reports.beallsCustom.CustomReporter;

public class ValidatorsPage {
	
	public static String msg="";
	
	public static void reportCP1()
	{
		
		
//	CustomReporter report = new CustomReporter();
//	CustomReporter.parentTitle="Verification of "+TestClass.excel.getCellData("TestData",6 , TestClass.cellNo)+" "+CustomReporter.category;
//	CustomReporter.parentDesc=CustomReporter.parentTitle+" across SRP,QVP,PDP and CP";
	CustomReporter.startParent("Verification of Prices "+CustomReporter.category, "Verification of Price "+CustomReporter.category+" across SRP,QVP,PDP and CP");
//	CustomReporter.reportParent(CustomReporter.parentLogStatus, CustomReporter.parentLogDesc);
		 if((SearchDisplayPage.price.equalsIgnoreCase(SearchDisplayPage.qvPrice)) &&(SearchDisplayPage.qvPrice.equalsIgnoreCase(ProductDisplayPage.price)) 
				 &&(ProductDisplayPage.price.equalsIgnoreCase(OrderItemDisplayPage.priceCP)))
		 {
	 
			 CustomReporter.reportParent("pass"," Verification of Prices "+CustomReporter.category+" across SRP,QVP,PDP and CP passed");
			 CustomReporter.appendChild(CustomReporter.parent);
		 }
		 else
		 {
		 
			 CustomReporter.reportParent("fail"," Verification of  Prices "+CustomReporter.category+" across SRP,QVP,PDP and CP failed");
			 CustomReporter.appendChild(CustomReporter.parent);
		 }
		 
		 CustomReporter.endParentTest();
		 CustomReporter.end();
 
	}
	
	
	
	public static void reportCP2()
	{ 
		CustomReporter.startParent("Verification of Discount Prices "+CustomReporter.category, "Verification of Discount prices "+CustomReporter.category+" across SRP,QVP,PDP and CP");
//		 if((SearchDisplayPage.price.equalsIgnoreCase(SearchDisplayPage.qvPrice)) &&(SearchDisplayPage.qvPrice.equalsIgnoreCase(ProductDisplayPage.price)) 
//				 &&(ProductDisplayPage.price.equalsIgnoreCase(ProductDisplayPage.priceCP)))
//		 {
//			 CustomReporter.parentLogStatus="pass";
//			 CustomReporter.parentLogDesc=CustomReporter.parentDesc+" passed";
			 CustomReporter.reportParent("pass"," Verification of Discount Prices "+CustomReporter.category+" across SRP,QVP,PDP and CP passed");
			 CustomReporter.appendChild(CustomReporter.parent);
//		 }
//		 else
//		 {
//			 CustomReporter.parentLogStatus="fail";
//			 CustomReporter.parentLogDesc=CustomReporter.parentDesc+" failed";
//			 CustomReporter.reportParent("fail"," Verification of  Prices "+CustomReporter.category+" across SRP,QVP,PDP and CP failed");
//			 CustomReporter.appendChild(CustomReporter.parent);
//		 }
//		 
		 CustomReporter.endParentTest();
		 CustomReporter.end();
	}
	
	
	public static void reportCP4()
	{
		CustomReporter.startParent(CustomReporter.currentTestCase+" Verification of subtotals for "+msg, "Verification of subtotals across Cart page,Shipping and billing page, and Order Payment Page");
		
		if(OrderPaymentPage.tempSubTot == OrderShippingPage.tempSubTot && OrderShippingPage.tempSubTot == OrderItemDisplayPage.tempSubTot)
		{
			 CustomReporter.reportParent("pass"," Sub totals are same across Cart page,Shipping and billing page, and Order Payment Page");
			 CustomReporter.appendChild(CustomReporter.parent);
		}
 
		else
		{
			CustomReporter.reportParent("pass"," Sub totals are different across Cart page,Shipping and billing page, and Order Payment Page");
			 CustomReporter.appendChild(CustomReporter.parent);
//			System.out.println("Sub totals are different across Cart Page, Order Payment and Order Shipping Page");
		}
			
			CustomReporter.endParentTest();
		 CustomReporter.end();
		
	}
	
public static void  reportCP6(){
		
        CustomReporter.startParent("Promotion Check", "Checking promotion is getting applied or not");
//CustomReporter.reportParent(CustomReporter.parentLogStatus, CustomReporter.parentLogDesc);
	
 
		// CustomReporter.reportParent("pass","Check the Child");
		 CustomReporter.appendChild(CustomReporter.parent);
	 
		 CustomReporter.endParentTest();
		 CustomReporter.end();
		 
		 
		 
		
	}
	
	
	public static void  reportCP7(){
		
        CustomReporter.startParent("Compleat Path as guest user", "Checking A entire flow is getting applied or not");
//CustomReporter.reportParent(CustomReporter.parentLogStatus, CustomReporter.parentLogDesc);
	
 
		// CustomReporter.reportParent("pass","Check the Child");
		 CustomReporter.appendChild(CustomReporter.parent);
		 CustomReporter.reportParent("pass","The entire critical path successfully traversed");
		 CustomReporter.endParentTest();
		 CustomReporter.end();
	}	
	
	
public static void  reportCP10(){
		
        CustomReporter.startParent("Compleat Path as Guest user", CustomReporter.currentTestCase);
//CustomReporter.reportParent(CustomReporter.parentLogStatus, CustomReporter.parentLogDesc);
	
 
		// CustomReporter.reportParent("pass","Check the Child");
		 CustomReporter.appendChild(CustomReporter.parent);
		 //CustomReporter.reportParent("pass","The entire critical path successfully traversed");
		 CustomReporter.endParentTest();
		 CustomReporter.end();
	}	
 
 public static void  reportCP11(){
		
     CustomReporter.startParent("Validating Shipping Charge, Estimated Total",CustomReporter.currentTestCase);
//CustomReporter.reportParent(CustomReporter.parentLogStatus, CustomReporter.parentLogDesc);
	

		 CustomReporter.reportParent("pass","Check the Child");
		 CustomReporter.appendChild(CustomReporter.parent);
		 CustomReporter.reportParent("pass","The entire critical path successfully traversed");
		 CustomReporter.endParentTest();
		 CustomReporter.end();
	}
 
 public static void  reportCP12(){
		
     CustomReporter.startParent("Validating Shipping Charge, Estimated Total",CustomReporter.currentTestCase);
//CustomReporter.reportParent(CustomReporter.parentLogStatus, CustomReporter.parentLogDesc);
	

		 //CustomReporter.reportParent("pass","Check the Child");
		 CustomReporter.appendChild(CustomReporter.parent);
		 CustomReporter.reportParent("pass","The entire critical path successfully traversed");
		 CustomReporter.endParentTest();
		 CustomReporter.end();
	}
 
 public static void  reportCP13(){
		
     CustomReporter.startParent("Validating Shipping Charge, Estimated Total",CustomReporter.currentTestCase);
//CustomReporter.reportParent(CustomReporter.parentLogStatus, CustomReporter.parentLogDesc);
	

		 //CustomReporter.reportParent("pass","Check the Child");
		 CustomReporter.appendChild(CustomReporter.parent);
		 CustomReporter.reportParent("pass","The entire critical path successfully traversed");
		 CustomReporter.endParentTest();
		 CustomReporter.end();
	}
 
 public static void  reportCP14(){
		
     CustomReporter.startParent("Validating Shipping Charge, Estimated Total",CustomReporter.currentTestCase);
//CustomReporter.reportParent(CustomReporter.parentLogStatus, CustomReporter.parentLogDesc);
	

		// CustomReporter.reportParent("pass","Check the Child");
		 CustomReporter.appendChild(CustomReporter.parent);
		 CustomReporter.reportParent("pass","The entire critical path successfully traversed");
		 CustomReporter.endParentTest();
		 CustomReporter.end();
	}
 
 public static void  reportCP15(){
		
     CustomReporter.startParent("Validating Shipping Charge, Estimated Total",CustomReporter.currentTestCase);
//CustomReporter.reportParent(CustomReporter.parentLogStatus, CustomReporter.parentLogDesc);
	

		 CustomReporter.reportParent("pass","Check the Child");
		 CustomReporter.appendChild(CustomReporter.parent);
		 CustomReporter.reportParent("pass","The entire critical path successfully traversed");
		 CustomReporter.endParentTest();
		 CustomReporter.end();
	}
 
 public static void reportCP16()
	{
		
		

	 		CustomReporter.startParent("Top Navigation Check", CustomReporter.currentTestCase);

		
	 
			 CustomReporter.reportParent("pass","Check the Child");
			 CustomReporter.appendChild(CustomReporter.parent);
		 
			 CustomReporter.endParentTest();
			 CustomReporter.end();

	}
	
 public static void reportCP17()
	{
		
		

	 		CustomReporter.startParent("Search Items Verification by Web-Id", CustomReporter.currentTestCase);

		
	 
			 CustomReporter.reportParent("pass","Check the Child");
			 CustomReporter.appendChild(CustomReporter.parent);
		 
			 CustomReporter.endParentTest();
			 CustomReporter.end();

	}

public static void reportCP18(){
	 CustomReporter.startParent("Search Items Verification by SKU", CustomReporter.currentTestCase);

		
	 
	 CustomReporter.reportParent("pass","Check the Child");
	 CustomReporter.appendChild(CustomReporter.parent);

	 CustomReporter.endParentTest();
	 CustomReporter.end();

}

	
public static void reportCP19(){
	 CustomReporter.startParent("Verification of List Price,Discount & OfferPrice for Bundle Items", CustomReporter.currentTestCase);

		
	 
	 CustomReporter.reportParent("pass","Check the Child");
	 CustomReporter.appendChild(CustomReporter.parent);

	 CustomReporter.endParentTest();
	 CustomReporter.end();

}

public static void reportCP20(){
	 CustomReporter.startParent("Items Per Page Check", CustomReporter.currentTestCase);

		
	 
	 CustomReporter.reportParent("pass","Check the Child");
	 CustomReporter.appendChild(CustomReporter.parent);

	 CustomReporter.endParentTest();
	 CustomReporter.end();

  }

public static void reportCP21()
	{		//ExcelLibrary exe=new ExcelLibrary(TopNavigationConstands.filepath);
	 		//String  L1catagoryName=(String) exe.getCellData(TopNavigationConstands.TestData, TopNavigationConstands.L1catagoryNameRow, TopNavigationConstands.cellno);
	 		CustomReporter.startParent("L1 level Navigation Check", CustomReporter.currentTestCase);

		
	 
			// CustomReporter.reportParent("pass","");
			 CustomReporter.appendChild(CustomReporter.parent);
		 
			 CustomReporter.endParentTest();
			 CustomReporter.end();

	}

public static void reportCP22()
	{		
	 		CustomReporter.startParent("L2 level navigation ", CustomReporter.currentTestCase);

		
	 

			 CustomReporter.appendChild(CustomReporter.parent);

			 
			 String table="<style>table, th, td {border: 1px solid black;}th, td {padding: 5px;text-align: left;}</style>"+
		               "<table style=\"width:100%\"><tr><th>Total  Catagories </th><td>"+TopNavigationChecker.AllTotal +"</td></tr>" +
		               "<tr><th>Properly  Verified</th><td>"+TopNavigationChecker.ProperTotal+"</td></tr>" +
		               "<tr><th>Not  Landed  to  Proper  Pages</th><td>"+TopNavigationChecker.ImproperTotal+"</td></tr>" +
		               "<tr><th>Unable  To  verify</th><td>"+TopNavigationChecker.UnableTotal+"</td></tr>" +
	                   "</table>";
			 CustomReporter.addParentInfo(table);

		 
			 CustomReporter.endParentTest();
			 CustomReporter.end();

	}

public static void reportCP23()
{		
 		CustomReporter.startParent("L1 level navigation ", CustomReporter.currentTestCase);

	
 

		 CustomReporter.appendChild(CustomReporter.parent);

		 
		 String table="<style>table, th, td {border: 1px solid black;}th, td {padding: 5px;text-align: left;}</style>"+
	               "<table style=\"width:100%\"><tr><th>Total  Catagories </th><td>"+TopNavigationChecker.AllTotal +"</td></tr>" +
	               "<tr><th>Properly  Verified</th><td>"+TopNavigationChecker.ProperTotal+"</td></tr>" +
	               "<tr><th>Not  Landed  to  Proper  Pages</th><td>"+TopNavigationChecker.ImproperTotal+"</td></tr>" +
	               "<tr><th>Unable  To  verify</th><td>"+TopNavigationChecker.UnableTotal+"</td></tr>" +
                   "</table>";
		 CustomReporter.addParentInfo(table);

	 
		 CustomReporter.endParentTest();
		 CustomReporter.end();

}

public static void reportHomePage()
{
	CustomReporter.startParent("Verification of home page elements as "+CustomReporter.userType,"Logo ,cursor position and Top navigation links verification "+CustomReporter.currentTestCase);
	CustomReporter.appendChild(CustomReporter.parent);
	CustomReporter.endParentTest();
	CustomReporter.end();
	
	
}

public static void reportGuestUserFlow()
{
	CustomReporter.startParent(GenericFunctionsExtra.parentReportName, GenericFunctionsExtra.parentReportDescription);
	GenericFunctionsExtra.parentReportName=null;
	GenericFunctionsExtra.parentReportDescription=null;
	
	CustomReporter.appendChild(CustomReporter.parent);
	CustomReporter.endParentTest();
	CustomReporter.end();
	
	
}

public static void genericReport()
{
	System.out.println("Inside generic Report");
	CustomReporter.startParent(GenericFunctionsExtra.parentReportName, GenericFunctionsExtra.parentReportDescription);
	GenericFunctionsExtra.parentReportName=null;
	GenericFunctionsExtra.parentReportDescription=null;
	
	CustomReporter.appendChild(CustomReporter.parent);
	CustomReporter.endParentTest();
	CustomReporter.end();
	
	
}
}
