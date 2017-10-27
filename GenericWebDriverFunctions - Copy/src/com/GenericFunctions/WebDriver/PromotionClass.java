package com.GenericFunctions.WebDriver;

import com.excellibrary.bealls.ExcelLibrary;

public class PromotionClass {
	public static String InputSheet="TestData";
	public static String PromoSheet="PromoSheet";
	public static int cellNo=1;
	public static String filepath="C:\\Users\\vrangaiah\\workspace_3June16\\BeallsAutomation\\Bealls_Execution_Excel.xlsx";

public static boolean PromoCodeapplicability(String PromotionName){
	boolean applycable=false;
		ExcelLibrary exe=new ExcelLibrary("C:\\Users\\vrangaiah\\workspace_3June16\\BeallsAutomation\\Bealls_Execution_Excel.xlsx");
	   
	    for (int i = 1; i <=exe.getRowCount("PromoSheet"); i++) {
	    	String PromotionNameFrom=(String) exe.getCellData("PromoSheet", i, 1);
	    	if(PromotionName.equalsIgnoreCase(PromotionNameFrom)){
	    		String ApplicabilityOfCodes=(String) exe.getCellData("PromoSheet", i, 9);
	    		if(ApplicabilityOfCodes.equalsIgnoreCase("yes")){
	    			applycable=true;
	    			break;
	    		}
	    	}
		}
	
	return applycable;
	
}

public static  double[] OrderLevelPromotion(int i,Double ProductSubtotal){
	ExcelLibrary exe=new ExcelLibrary(filepath);
	Double CalculatedProductsubtotal = null;
	Double CalculatedShipping=null;
	String NoOfItems=exe.getCellData(PromoSheet, i, 4).toString();	
	String PercentageOff=exe.getCellData(PromoSheet, i, 5).toString();	
	String FixedPriceOff=exe.getCellData(PromoSheet, i, 6).toString();
	String AdditionalOff=exe.getCellData(PromoSheet, i, 7).toString();
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
	
	if(CalculatedProductsubtotal>49.99){
		CalculatedShipping=0.00;	
	}else{
		if(AdditionalOff.equalsIgnoreCase("Free Shipping")){
			CalculatedShipping=0.00;
		}else{
			CalculatedShipping=8.00;
		}
		
	}
	return (new double[]{CalculatedProductsubtotal,CalculatedShipping});	
}


	public static void main(String[] args) {
	
        //System.out.println(PromotionClass.PromoCodeapplicability("category promotion 20%"));
		double[] anw=PromotionClass.OrderLevelPromotion(2,(double) 40);
		System.out.println("CalculatedProductsubtotal::"+anw[0]);
		System.out.println("CalculatedShipping::"+anw[1]);
	}

}
