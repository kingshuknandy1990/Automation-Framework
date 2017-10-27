package com.Pages.AllBealls;

import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericFunctions.WebDriver.GenericFunctionsExtra;
import com.GenericFunctions.WebDriver.GenericWebDriverFunctions;


import com.constants.string.PDPpageExtConstants;
import com.constants.string.StringConstants;
import com.reports.beallsCustom.CustomReporter;




public class PDPpageExtended {

	
	@FindBy(xpath=PDPpageExtConstants.OfferPrice)
	public static WebElement OfferPrice;
	
	@FindBy(xpath=PDPpageExtConstants.OfferPrice)
	public static List <WebElement> OfferPricelist;
	
	
	@FindBy(xpath=PDPpageExtConstants.ListPrice)
	public static WebElement  ListPrice;
	
	@FindBy(xpath=PDPpageExtConstants.ListPrice)
	public static List <WebElement>  ListPricelist;
	
	@FindBy(xpath=PDPpageExtConstants.Save)
	public static WebElement  Save;
	
	@FindBy(xpath=PDPpageExtConstants.Save)
	public static List <WebElement>  Savelist;
	
	@FindAll(@FindBy(xpath=PDPpageExtConstants.sizes))
	public static List <WebElement> sizes;
	
	public PDPpageExtended(){
		PageFactory.initElements(GenericWebDriverFunctions.driver,this);
	}
	
	public static void VerifyProdPriceHavingPriceRange() {
		
		/*for (int i = 0; i < sizes.size(); i++) {
    	   WebElement size=sizes.get(i);
    	   GenericWebDriverFunctions.performAction(StringConstants.CLICK, size, "");
    	   Thread.sleep(5000);
	   }*/
		CustomReporter.startChild("Verification of List Price,Discount & OfferPrice for Bundle Items", "");
		try {
			if(GenericFunctionsExtra.ElementVisibility(OfferPricelist) &&
					GenericFunctionsExtra.ElementVisibility(ListPricelist) &&
					GenericFunctionsExtra.ElementVisibility(Savelist)){
				
				GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, OfferPrice, "");
				List<Double> offerPricerange=GenericFunctionsExtra.PriceRangeStringTodouble(GenericWebDriverFunctions.getText);
				
				GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, ListPrice, "");
				List<Double> listPricerange=GenericFunctionsExtra.PriceRangeStringTodouble(GenericWebDriverFunctions.getText);
				
				GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, Save, "");
				String savee=GenericWebDriverFunctions.getText;
				
				String strr[]=savee.split(" ");
				Double savepercent=Double.valueOf(strr[2].replace("%", ""));
				
				if(offerPricerange.size()>1 && listPricerange.size()>1 ){
					System.out.println("Range is avaliable");
					CustomReporter.addChildInfo("Range is avaliable");
					
					if (PDPpageExtended.verifyOfferprice(offerPricerange.get(0), listPricerange.get(0), savepercent) 
							&& PDPpageExtended.verifyOfferprice(offerPricerange.get(1), listPricerange.get(1), savepercent)) {
						System.out.println("Proper Offer Price is displayed");
						CustomReporter.reportChild("pass", "Proper Offer Price is displayed");
					}else{
						System.out.println("Proper Offer Price is not displayed");
						CustomReporter.reportChild("fail", "Proper Offer Price is not displayed");
					}
					
				}else{
					System.out.println("Range is not avaliable");
					CustomReporter.reportChild("fail", "Range is not avaliable");
				}
				
			}else{
				CustomReporter.reportChild("fail", "List Price,Discount & OfferPrice for Bundle Items field are not properly displayed ");
			}
		} catch (Exception e) {
			CustomReporter.reportChild("fail", "Unable to verify List Price,Discount & OfferPrice for Bundle Items "
					+"  Error:"+e);
			System.out.println("Error:"+e);
		}
		
		CustomReporter.endChildTest();
	}
	
	public static boolean verifyOfferprice(Double offerprice,Double listprice,Double savePercent){
		boolean status=false;
		Double offerpricecalculated=(1-(savePercent/100))*listprice;
		System.out.println("offerpricecalculated:"+offerpricecalculated+"   "+"offerprice:"+offerprice);
		if(GenericFunctionsExtra.NumberComparer(offerpricecalculated, offerprice)){
			status=true;
		}else{
			status=false;
		}
		return status;	
	}
}
