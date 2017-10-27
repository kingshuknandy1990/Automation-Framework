package com.Pages.AllBealls;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.GenericFunctions.WebDriver.GenericFunctionsExtra;
import com.GenericFunctions.WebDriver.GenericWebDriverFunctions;
import com.GenericFunctions.WebDriver.PromotionClass;
import com.bealls.pojo.PromotionPojo;
import com.constants.string.PromotionConstants;

import com.constants.string.StringConstants;
import com.excellibrary.bealls.ExcelLibrary;
import com.reports.beallsCustom.CustomReporter;


public class PromotionSpecificClass {
	
	/**
	 * PromoStatusFlag describes the status of Promotion
	 * PromoStatusFlag=0  //Initialization 
	 * PromoStatusFlag=1  //Promotion applied by clicking on Apply button
	 * PromoStatusFlag=2  //Unable to apply Promotion: Due to some error in excel TestData or Ajax timeout.
	 * PromoStatusFlag=3  //Invalid promotion code
	 * PromoStatusFlag=4  //Promo is applied as it qualify for minimum qualifying criterion
	 * PromoStatusFlag=5  //Promo is not applied as it does not qualify for minimum qualifying criterion
	 */
	public static int PromoStatusFlag=0;
	public static String PromotionName=null;
	
	
	@FindBy(xpath=PromotionConstants.PromoErrorFeild)
	public static List <WebElement> PromotionErrorFeild;
	
	@FindBy(xpath=PromotionConstants.PromoCodeFeild)
	public static WebElement PromoCodeFeild;
	
	@FindBy(xpath=PromotionConstants.PromoApplyButton)
	public static WebElement PromoApplyButton;
	
	@FindBy(xpath=PromotionConstants.AppliedPromotionName)
	public static List <WebElement>  AppliedPromotionName;
	
	@FindBy(xpath=PromotionConstants.PromoRemoveFeild)
	public static WebElement PromoRemoveFeild;
	
	@FindBy(xpath=PromotionConstants.PromoRemoveFeild)
	public static List <WebElement> PromoRemoveFeildVisibility;
	
	@FindBy(xpath=PromotionConstants.AppliedPromoDiscountValue)
	public static WebElement AppliedPromoDiscountValue;

	@FindBy(xpath=PromotionConstants.PromoAppliedFeild)
	public static WebElement PromoAppliedFeild;
	
	@FindBy(xpath=PromotionConstants.DeductedPriceFeild)
	public static WebElement DeductedPriceFeild;
	
	@FindBy(xpath=PromotionConstants.ProductSubtotal)
	public static WebElement ProductSubtotal;
	
	@FindBy(xpath=PromotionConstants.ShippingChargefeild)
	public static WebElement ShippingChargefeild;
	
	@FindBy(xpath=PromotionConstants.EstimatedTotal)
	public static WebElement EstimatedTotal;
	
	@FindBy(xpath=PromotionConstants.EstimatedTax)
	public static List <WebElement>  EstimatedTaxlist;
	
	@FindBy(xpath=PromotionConstants.EstimatedTax)
	public static WebElement  EstimatedTax;
	
	public PromotionSpecificClass(){
		PageFactory.initElements(GenericWebDriverFunctions.driver, this);
	}


	
	/**
	 * Applying promotion in the cart page
	 * @throws InterruptedException
	 */
	public static void ApplyPromotionInCartPage() throws InterruptedException{
		     CustomReporter.startChild("Apply Promotion In Cart Page", "");

	    	
		
	    	ExcelLibrary exe=new ExcelLibrary(PromotionConstants.filepath);
		System.out.println("----------ApplyPromotionInCartPage----------------------------------------------------------------");    
		try {
			PromotionName= exe.getCellData(PromotionConstants.TestData, PromotionConstants.PromotionNameRowCart, PromotionConstants.cellno).toString();
			String PromotionCode= exe.getCellData(PromotionConstants.TestData, PromotionConstants.PromoCodeRowCart, PromotionConstants.cellno).toString();
			PromotionPojo po=new PromotionPojo();
			po.setPromotionName(PromotionName);
			po.setPromoCode(PromotionCode);
			CustomReporter.addChildInfo(po.toStringPromo());
			GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, PromoCodeFeild, PromotionCode);
			GenericWebDriverFunctions.performAction(StringConstants.CLICK, PromoApplyButton, "");
			
			Thread.sleep(9000);
			PromoStatusFlag=1;
			CustomReporter.reportChild("pass", "Applying Promo-Code in Cart Page");
		} catch (Exception e) {
			PromotionName=null;
			PromoStatusFlag=2;
			CustomReporter.reportChild("fail","Error in TestData of ApplyPromotion Function:");
			CustomReporter.addChildInfo("Please Check The PromotionName & PromotionCode field in TestData."+e);
			
			System.out.println("Error in TestData of ApplyPromotion Function:"+e);
			System.out.println("Please Check The PromotionName & PromotionCode field in TestData.");
		}
		
		CustomReporter.endChildTest();

	}
	
	/**
	 * applying promotion in Shipping And Billing Page
	 * @throws InterruptedException
	 */
	public static void ApplyPromotionInShippingAndBillingPage() throws InterruptedException{
		CustomReporter.startChild("Apply Promotion In Shipping & Billing Page", "");
		ExcelLibrary exe=new ExcelLibrary(PromotionConstants.filepath);
		System.out.println("----------ApplyPromotionInShippingAndBillingPage----------------------------------------------------------------");    
		try {
			PromotionName= exe.getCellData(PromotionConstants.TestData, PromotionConstants.PromotionNameRowShipBill, PromotionConstants.cellno).toString();
			String PromotionCode= exe.getCellData(PromotionConstants.TestData, PromotionConstants.PromoCodeRowShipBill, PromotionConstants.cellno).toString();
			GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, PromoCodeFeild, PromotionCode);
			GenericWebDriverFunctions.performAction(StringConstants.CLICK, PromoApplyButton, "");
			Thread.sleep(9000);
			PromoStatusFlag=1;
			CustomReporter.reportChild("pass", "Promotion Has Been Applied");
		} catch (Exception e) {
			PromotionName=null;
			PromoStatusFlag=2;
			System.out.println("Error in TestData of ApplyPromotion Function:"+e);
			System.out.println("Please Check The PromotionName & PromotionCode field in TestData.");
			
			CustomReporter.reportChild("fail","Error in TestData of ApplyPromotion Function:");
			CustomReporter.addChildInfo("Please Check The PromotionName & PromotionCode field in TestData."+e);
		}

		   CustomReporter.endChildTest();
	}
	
	public static void ApplyPromotionInPaymentAndOrderPage() throws InterruptedException{
		
		CustomReporter.startChild("Apply Promotion In Payment & Order Page", "");
		
		ExcelLibrary exe=new ExcelLibrary(PromotionConstants.filepath);
		System.out.println("----------ApplyPromotionInPaymentAndOrderPage----------------------------------------------------------------");        
		try {
			PromotionName= exe.getCellData(PromotionConstants.TestData, PromotionConstants.PromotionNameRowPay, PromotionConstants.cellno).toString();
			String PromotionCode= exe.getCellData(PromotionConstants.TestData, PromotionConstants.PromoCodeRowPay, PromotionConstants.cellno).toString();
			GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, PromoCodeFeild, PromotionCode);
			GenericWebDriverFunctions.performAction(StringConstants.CLICK, PromoApplyButton, "");
			Thread.sleep(9000);
			PromoStatusFlag=1;
			CustomReporter.reportChild("pass", "Promotion Has Been Applied");
		} catch (Exception e) {
			PromotionName=null;
			PromoStatusFlag=2;
			System.out.println("Error in TestData of ApplyPromotion Function:"+e);
			System.out.println("Please Check The PromotionName & PromotionCode field in TestData.");
			
			CustomReporter.reportChild("fail","Error in TestData of ApplyPromotion Function:");
			CustomReporter.addChildInfo("Please Check The PromotionName & PromotionCode field in TestData."+e);
		}
		CustomReporter.endChildTest();
	}
	
	
	
	
	
	public static void RemoveExistingPromotion() throws InterruptedException{
		if(GenericFunctionsExtra.ElementVisibility(PromoRemoveFeildVisibility)){
			CustomReporter.startChild("Removing Existing Promotion", "");
			try {
				GenericWebDriverFunctions.performAction(StringConstants.CLICK, PromoRemoveFeild, "");
				Thread.sleep(7000);
				CustomReporter.addChildInfo("Existing Promotion was Removed");
			} catch (Exception e) {
				// TODO: handle exception
			}

			CustomReporter.endChildTest();
		}
	}
	
	public static void CheckPromoAppliedOrNot(){
		
		//Checking PromoCode applicable or not
		if(PromoStatusFlag==1){
			   CustomReporter.startChild("Check Promo Applied Or Not", "");
				try {
					if(GenericFunctionsExtra.ElementVisibility(PromotionErrorFeild)){
						PromoStatusFlag=3;
						CustomReporter.reportChild("Pass","System Generated Error Message:"+PromotionErrorFeild.get(0).getText());
						System.out.println("Error occured::"+PromotionErrorFeild.get(0).getText());
					}else if(GenericFunctionsExtra.ElementVisibility(AppliedPromotionName)){
						
						System.out.println("Promotion Name::"+AppliedPromotionName.get(0).getText());
						CustomReporter.addChildInfo("Promotion Name::"+AppliedPromotionName.get(0).getText());
						
						GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, AppliedPromoDiscountValue, "");
						Double AppliedDiscountValue=GenericFunctionsExtra.StringToDoubleConvertor(GenericWebDriverFunctions.getText);
						if(AppliedDiscountValue==0.00){
							PromoStatusFlag=5;
							System.out.println("Your shopping bag does not qualify for all applied promotions at this time.");
							CustomReporter.reportChild("Pass","Your shopping bag does not qualify for all applied promotions at this time.");
						}else{
							PromoStatusFlag=4;
							CustomReporter.reportChild("Pass","Promo has Been Applied and Amout Has been deducted");
						}
						
					}
				} catch (Exception e) {
					CustomReporter.reportChild("fail","Error:"+e);
				}
				CustomReporter.endChildTest();  
		}
	}
	

	
	
	public static void ValidatingProductsubtotal(){
            
			if(PromoStatusFlag==4){
				GenericFunctionsExtra.Shippingflag=0;
				GenericFunctionsExtra.EstimatedTotalflag=0;
				
				CustomReporter.startChild("Validating Product Subtotal & Shipping Charge", "");
				ExcelLibrary exe=new ExcelLibrary(PromotionConstants.filepath);
				for (int i = 0; i < exe.getRowCount(PromotionConstants.PromoSheet); i++) {

 					String PromotionNameFrom=(String) exe.getCellData(PromotionConstants.PromoSheet, i, 1);
 					if(PromotionName.equalsIgnoreCase(PromotionNameFrom)){
						
 						GenericWebDriverFunctions.performAction(StringConstants.GETTEXT,ProductSubtotal , "");
						Double ProductsSubtotal=GenericFunctionsExtra.StringToDoubleConvertor(GenericWebDriverFunctions.getText);
						System.out.println("Products-Subtotal Comming From Site:  "+ProductsSubtotal);
						
						
						GenericWebDriverFunctions.performAction(StringConstants.GETTEXT,DeductedPriceFeild , "");
						Double deductedPrice=GenericFunctionsExtra.StringToDoubleConvertor(GenericWebDriverFunctions.getText);
						System.out.println("Detucted Price Comming From Site::"+deductedPrice);
						
						//Estimating The detucted price and shipping charge
						double[] anw=PromotionSpecificClass.OrderLevelPromotion(i, ProductsSubtotal);
						System.out.println("CalculatedProductsubtotal::"+anw[0]);
						System.out.println("CalculatedShippingcharge::"+anw[1]);
						
						//Obtaining The Shipping Charge and estimated total
						//WebElement DiscountPrice=GenericWebDriverFunctions.findElementsBy(StringConstandsKingshuk.ShippingChargefeild);
						GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, ShippingChargefeild, "");
						String Shipping=GenericWebDriverFunctions.getText;
					
						//WebElement EstimatedPrice=GenericWebDriverFunctions.findElementsBy(StringConstandsKingshuk.EstimatedTotal);
						GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, EstimatedTotal, "");
						String EstimatedPricetotal=GenericWebDriverFunctions.getText;
						//System.out.println(Shipping+"////////"+EstimatedPricetotal);
						System.out.println("Shipping charge obtained from site:"+Shipping);
						System.out.println("Estimated Total obtained from site"+EstimatedPricetotal);
						
						Double EstimatedPricetotalDouble=GenericFunctionsExtra.StringToDoubleConvertor(EstimatedPricetotal);
						Double Tax=0.00;
						//Estimated Tax Fetching
						if(GenericFunctionsExtra.ElementVisibility(EstimatedTaxlist)){
							//WebElement EstimatedPrice=GenericWebDriverFunctions.findElementsBy(StringConstandsKingshuk.EstimatedTotal);
							GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, EstimatedTax, "");
							String EstimatedTaxx=GenericWebDriverFunctions.getText;
							Tax=GenericFunctionsExtra.StringToDoubleConvertor(EstimatedTaxx);
							CustomReporter.addChildInfo("Displayed Estimated Tax from site:"+Tax);
						}
						
						
						
						//If shipping charge zero then calculation
						if(anw[1]==0.00){
							if(Shipping.equalsIgnoreCase("FREE")){
								System.out.println("Proper Shipping Charge is displayed");
								//CustomReporter.addChildInfo("Free Shipping");
								//CustomReporter.reportChild("pass","Proper Shipping Charge is Displayed");
								CustomReporter.addChildInfo("Proper Shipping Charge is Displayed");
								CustomReporter.addChildInfo("Free Shipping");
								GenericFunctionsExtra.Shippingflag=1;
							}else{
								System.out.println("Proper Shipping Charge is not displayed");
								CustomReporter.addChildInfo("Shipping Charge:"+anw[1]);
								//CustomReporter.reportChild("fail","Proper Shipping Charge is not displayed");
								GenericFunctionsExtra.Shippingflag=2;
							}
							
							Double EstimatedCalculatedtotalother=anw[0]+Tax;
							if(GenericFunctionsExtra.NumberComparer(EstimatedPricetotalDouble, EstimatedCalculatedtotalother)){
								System.out.println("==================");
								
								System.out.println("Estimated Total As displayed in site:"+EstimatedPricetotalDouble);
								System.out.println("Estimated Total Calculated:"+EstimatedCalculatedtotalother);
								System.out.println("==================");
								
								System.out.println("Proper Estimated Total  is displayed");
								//CustomReporter.addChildInfo("Proper Estimated total is Displayed");
								CustomReporter.reportChild("pass","Proper Estimated Total  is displayed");
								CustomReporter.addChildInfo("Displayed Estimated Total:"+EstimatedPricetotalDouble);
								CustomReporter.addChildInfo("Calculated Estimated Total:"+EstimatedCalculatedtotalother);
								GenericFunctionsExtra.EstimatedTotalflag=1;
							}else{
								System.out.println("Proper Estimated Total  is not displayed");
								//CustomReporter.addChildInfo("Proper Estimated total is not Displayed");
								CustomReporter.reportChild("fail","Proper Estimated Total  is not displayed");
								CustomReporter.addChildInfo("Displayed Estimated Total:"+EstimatedPricetotalDouble);
								CustomReporter.addChildInfo("Calculated Estimated Total:"+EstimatedCalculatedtotalother);
								GenericFunctionsExtra.EstimatedTotalflag=2;
							}
							
						}else{
							CustomReporter.addChildInfo("Proper Shipping Charge is displayed");
							CustomReporter.addChildInfo("Shipping Charge:"+anw[1]);
							GenericFunctionsExtra.Shippingflag=1;
							//If shipping charge not zero then calculation
							System.out.println("Proper Shipping Charge is displayed");
							Double EstimatedCalculatedtotal=anw[0]+anw[1]+Tax;
							if(GenericFunctionsExtra.NumberComparer(EstimatedPricetotalDouble, EstimatedCalculatedtotal)){
								System.out.println("Proper Estimated Total  is displayed");
								//CustomReporter.addChildInfo("Proper Estimated total is Displayed");
								CustomReporter.reportChild("pass","Proper Estimated Total  is displayed");
								CustomReporter.addChildInfo("Displayed Estimated Total:"+EstimatedPricetotalDouble);
								CustomReporter.addChildInfo("Calculated Estimated Total:"+EstimatedCalculatedtotal);
								GenericFunctionsExtra.EstimatedTotalflag=1;
							}else{
								System.out.println("Proper Estimated Total  is not displayed");
								//CustomReporter.addChildInfo("Proper Estimated total is not Displayed");
								CustomReporter.reportChild("fail","Proper Estimated Total  is not displayed");
								CustomReporter.addChildInfo("Displayed Estimated Total:"+EstimatedPricetotalDouble);
								CustomReporter.addChildInfo("Calculated Estimated Total:"+EstimatedCalculatedtotal);
								GenericFunctionsExtra.EstimatedTotalflag=2;
							}
						}
 						 //------------------------------------
 							
 							
 							
 						
 					}	/*else{
 						if(i==(exe.getRowCount(PromotionConstants.PromoSheet)-1)){
 						CustomReporter.reportChild("fail","Error:The promotion Has No Entry in PromoSheet");
 						CustomReporter.addChildInfo("Please Make A Entry In Promo Sheet");
 						}
 					}*/
				}
				CustomReporter.endChildTest();
			}			
	}
	    
     /**Check Promo-code is applicable or not
     * @param PromotionName
     * @return
     */
    public static boolean PromoCodeapplicability(String PromotionName){
    		boolean applicable=false;
    			ExcelLibrary exe=new ExcelLibrary(PromotionConstants.filepath);
    		   
    		    for (int i = 1; i <=exe.getRowCount("PromoSheet"); i++) {
    		    	String PromotionNameFrom=(String) exe.getCellData("PromoSheet", i, 1);
    		    	if(PromotionName.equalsIgnoreCase(PromotionNameFrom)){
    		    		String ApplicabilityOfCodes=(String) exe.getCellData("PromoSheet", i, 9);
    		    		if(ApplicabilityOfCodes.equalsIgnoreCase("yes")){
    		    			applicable=true;
    		    			break;
    		    		}
    		    	}
    			}
    		return applicable;
    		
    	}
	

    /**
     * 
     * Order level specific function
     * @param i
     * @param ProductSubtotal
     * @return
     */
    public static  double[] OrderLevelPromotion(int i,Double ProductSubtotal){
    	System.out.println("--------Function Input----------");
    	System.out.println("i : "+i+" ProductSubtotal : "+ProductSubtotal);
    	
    	System.out.println("------------------");
    	ExcelLibrary exe=new ExcelLibrary(PromotionConstants.filepath);
    	Double CalculatedProductsubtotal = null;
    	Double CalculatedShipping=null;
    	String NoOfItems=exe.getCellData(PromotionConstants.PromoSheet, i, 4).toString();	
    	String PercentageOff=exe.getCellData(PromotionConstants.PromoSheet, i, 5).toString();	
    	String FixedPriceOff=exe.getCellData(PromotionConstants.PromoSheet, i, 6).toString();
    	String AdditionalOff=exe.getCellData(PromotionConstants.PromoSheet, i, 7).toString();
    	System.out.println("//"+ NoOfItems+"//"+PercentageOff +"//"+FixedPriceOff +"//"+ AdditionalOff+"//");
    	
    	if(PercentageOff.equalsIgnoreCase("NA")){
    		//Order have Fixed Price off
    		System.out.println("Order have Fixed Price off");
    		CalculatedProductsubtotal=ProductSubtotal-Double.parseDouble(FixedPriceOff);
    	}else {
    		//Order have Fixed percentage Off
    		System.out.println("Order have Fixed percentage off");
    		CalculatedProductsubtotal=((100-Double.parseDouble(PercentageOff))/100)*ProductSubtotal;
    	}
    	
    	/*if(CalculatedProductsubtotal>49.99){
    		CalculatedShipping=0.00;	
    	}else{
    		if(AdditionalOff.equalsIgnoreCase("Free Shipping")){
    			CalculatedShipping=0.00;
    		}else{
    			CalculatedShipping=8.00;
    		}
    		
    	}*/
    	
    	if(AdditionalOff.equalsIgnoreCase("Free Shipping")){
    		CalculatedShipping=0.00;
    		System.out.println("***********1***************");
    	}else{
    		if(CalculatedProductsubtotal<=49.99){
    			CalculatedShipping=8.00;
    			System.out.println("***********2***************");
    		}else if (CalculatedProductsubtotal>=50.00 && CalculatedProductsubtotal<=99.99) {
    			CalculatedShipping=9.00;
    			System.out.println("***********3***************");
			}else if (CalculatedProductsubtotal>=100.00 && CalculatedProductsubtotal<150.00) {

				CalculatedShipping=10.00;
				System.out.println("***********4***************");
			}else if (CalculatedProductsubtotal>=150.00 ) {
				CalculatedShipping=0.00;
				System.out.println("***********5***************");
			}
    	}
    	return (new double[]{CalculatedProductsubtotal,CalculatedShipping});	
    }
    
    



}
