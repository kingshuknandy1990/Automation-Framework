package com.Pages.AllBealls;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.GenericFunctions.WebDriver.GenericFunctionsExtra;
import com.GenericFunctions.WebDriver.GenericWebDriverFunctions;
import com.constants.string.PromotionConstants;
import com.constants.string.StringConstants;
import com.excellibrary.bealls.ExcelLibrary;
import com.reports.beallsCustom.CustomReporter;

public class CheckOutPage {
	
	/**
	 * Edit address flag 
	 */
	public static int EditAddressFlag=0;

	@FindBy(xpath =PromotionConstants.ContinueAsGuestinCheckOutPage)
	public static WebElement continueAsGuest;
	
	@FindBy(xpath =PromotionConstants.First_Name)
	public static WebElement fname;
	
	@FindBy(xpath =PromotionConstants.First_Name)
	public static List <WebElement> fnamelist;
	
	@FindBy(xpath =PromotionConstants.Last_Name)
	public static WebElement lname;
	
	@FindBy(xpath =PromotionConstants.Street_Address)
	public static WebElement addr;
	
	@FindBy(xpath =PromotionConstants.City)
	public static WebElement city;
	
	
	
	
	
	@FindBy(xpath =PromotionConstants.StateOption)
	public static WebElement stateOption;
	
	@FindBy(xpath =PromotionConstants.Zip_Code)
	public static WebElement zippp;
	
	@FindBy(xpath =PromotionConstants.Phone_Number)
	public static WebElement phone;
	
	@FindBy(xpath =PromotionConstants.Email_Address)
	public static WebElement email;
	
	
	@FindBy(xpath =PromotionConstants.ContinueChekOut)
	public static WebElement checkOut;
	
	@FindBy(xpath =PromotionConstants.Use_Entry)
	public static WebElement useEntry;
	
	@FindBy(xpath =PromotionConstants.Use_Entry)
	public static List <WebElement> useEntrylist;
	
	@FindBy(xpath=PromotionConstants.Edit_Addresss)
	public static List <WebElement> EditAddress;

	
	@FindBy(xpath=PromotionConstants.CardOption)
	public static WebElement CardOption;

	
	@FindBy(xpath=PromotionConstants.CardNo)
	public static WebElement CardNoele; 
	
	@FindBy(xpath= PromotionConstants.Security)
	public static WebElement Securityfeild;
	
	
	@FindBy(xpath=PromotionConstants.ExpiresOn)
	public static WebElement expiresOn;
	
	@FindBy(xpath=PromotionConstants.CompleteYourOrder)
	public static WebElement completeOrder;
	
	@FindBy(xpath=PromotionConstants.Year)
	public static WebElement Yearlapse;
	
	
	
	
	
	public CheckOutPage(){
		PageFactory.initElements(GenericWebDriverFunctions.driver,this);
	}
	
    public static void ContinueAsGuest(){
	GenericWebDriverFunctions.performAction(StringConstants.CLICK, continueAsGuest, "");

}

public static void AddBillingAddress() throws InterruptedException{

	Thread.sleep(3000);
	if(GenericFunctionsExtra.ElementVisibility(EditAddress)){
		EditAddressFlag=1;
	}else{
		EditAddressFlag=2;
		 CustomReporter.startChild("Adding Billing Address", "");

	    
		try {
			ExcelLibrary exe=new ExcelLibrary(PromotionConstants.filepath);
			String FirstName=(String) exe.getCellData(PromotionConstants.TestData, PromotionConstants.FirstNameRow, PromotionConstants.cellno);
		    String LastName=(String) exe.getCellData(PromotionConstants.TestData, PromotionConstants.LastNameRow, PromotionConstants.cellno);
		    String StreetAddress=(String) exe.getCellData(PromotionConstants.TestData, PromotionConstants.StreetAddressRow, PromotionConstants.cellno);
		    String City=(String) exe.getCellData(PromotionConstants.TestData, PromotionConstants.CityRow, PromotionConstants.cellno);
		    String State=(String) exe.getCellData(PromotionConstants.TestData, PromotionConstants.StateRow, PromotionConstants.cellno);
		   
		    Double Zip=(Double) exe.getCellData(PromotionConstants.TestData,PromotionConstants.ZipRow , PromotionConstants.cellno);
			String v = Zip.toString().trim();
			String ZipCode=v.substring(0, v.indexOf("."));
		    
			Long Phone=Double.valueOf( exe.getCellData(PromotionConstants.TestData, PromotionConstants.PhoneRow, 1).toString()).longValue();
			String PhoneNo=Phone.toString();
			
			String Email=(String) exe.getCellData(PromotionConstants.TestData, PromotionConstants.EmailRow, PromotionConstants.cellno);
			
			String str= "<br>"+"Name:     "+FirstName+"\t"+LastName+
					    "<br>"+"Address:  "+StreetAddress+"\t"+","+"\t"+State+","+City+"-"+Zip+
					    "<br>"+"Phone No: "+PhoneNo+
					    "<br>"+"Email   : "+Email
					;
			GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, fname, FirstName);
			GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, lname, LastName);
			GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, addr, StreetAddress);


			
			GenericWebDriverFunctions.scrollToElement(city);
			GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, city, City);
			
			
			GenericWebDriverFunctions.performAction(StringConstants.SELECTVALUE, stateOption, State);
			GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, zippp, ZipCode);
			
			GenericWebDriverFunctions.scrollToElement(phone);
			GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, phone, PhoneNo);
			GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, email, Email);
			CustomReporter.reportChild("pass", "Billing Address Added successfully");
			//String description="<br>"+this.getCouterNo()+"  :  "+"<a href="+this.getLink()+">"+this.getCatagoryName()+"</a>"
			CustomReporter.addChildInfo(str);
		} catch (Exception e) {
			CustomReporter.reportChild("fail", "Unable to add Billing Address");
		}
		CustomReporter.endChildTest();
	}
	


}


 public static void ContinueCheckout(){
		GenericWebDriverFunctions.scrollToElement(checkOut);
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, checkOut, "");
 }
 
 public static void useEntryClick(){
	 
	 if(EditAddressFlag==2){
	 GenericWebDriverFunctions.performAction(StringConstants.CLICK, useEntry, "");
	 }
 }
 
 
 public static void CardDetailsPut() throws InterruptedException{
	 
	    System.out.println("----------------------////////////////***************");
	    //Thread.sleep(3000);
		     CustomReporter.startChild("Adding Card Details", "");
		     WebDriverWait   wait = new WebDriverWait(GenericWebDriverFunctions.driver, 9);	
	    	
		     
	    	
		try {
			ExcelLibrary exe=new ExcelLibrary(PromotionConstants.filepath);
		    String CardType=(String) exe.getCellData(PromotionConstants.TestData, PromotionConstants.CardTypeRow, PromotionConstants.cellno);
		    Long CardNumber=Double.valueOf( exe.getCellData(PromotionConstants.TestData, PromotionConstants.CardNumberRow, PromotionConstants.cellno).toString()).longValue();
			String CardNo=CardNumber.toString();
		    
		    
			Double Security11=(Double) exe.getCellData(PromotionConstants.TestData, PromotionConstants.Security11Row, PromotionConstants.cellno);
			String sec = Security11.toString().trim();
		
			String Security=sec.substring(0, sec.indexOf("."));
			
		    String ExpiresOn=(String) exe.getCellData(PromotionConstants.TestData, PromotionConstants.ExpiresOnRow, PromotionConstants.cellno);
		  
		    
		    Double Year11=(Double) exe.getCellData(PromotionConstants.TestData, PromotionConstants.Year11Row, PromotionConstants.cellno);
		    String ye = Year11.toString().trim();
			
		    String Year=ye.substring(0, ye.indexOf("."));
			
			//System.out.println("*************:::"+CardOption);
			Thread.sleep(2500);
			//GenericWebDriverFunctions.scrollToElement(CardOption);
			//GenericWebDriverFunctions.performAction(StringConstants.SELECTVALUE, CardOption, CardType);
/*			WebElement element=wait.until(ExpectedConditions.visibilityOf(CardOption));
			 Select option= new Select(element);
			 option.selectByIndex(2);*/
			GenericWebDriverFunctions.performAction(StringConstants.SELECTBYVT, CardOption, CardType.trim());
			
			
			GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, CardNoele, CardNo);
			GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, Securityfeild, Security);
			Thread.sleep(1000);
			GenericWebDriverFunctions.performAction(StringConstants.SELECTVALUE, expiresOn, ExpiresOn);
			Thread.sleep(1000);
			GenericWebDriverFunctions.performAction(StringConstants.SELECTVALUE, Yearlapse, Year);
			
			CustomReporter.reportChild("pass", "Card details Added Successfully");
			String str11= "<br>"+"Type of Card: "+CardType+"\t"+
					    "<br>"+"Card No     : "+CardNo+"\t"+
					    "<br>"+"Security    : "+Security11+
					    "<br>"+"Expires On  : "+ExpiresOn+
					    "<br>"+"Year  		: "+Year11
				;
			CustomReporter.addChildInfo(str11);
		} catch (Exception e) {
			CustomReporter.reportChild("fail", "Unable to add Card Details");
			CustomReporter.addChildInfo("Error::"+e);
		}
		
		CustomReporter.endChildTest();
 }
 
 public static void OrderComplete(){
	 CustomReporter.startChild("Completing Order", "");
	 try {
		 GenericWebDriverFunctions.performAction(StringConstants.CLICK, completeOrder, "");
		 CustomReporter.reportChild("pass", "Order Was successfully placed");
	} catch (Exception e) {
		// TODO: handle exception
		 CustomReporter.reportChild("fail", "Unable to place order");
	}
	 CustomReporter.endChildTest();
 }

}
