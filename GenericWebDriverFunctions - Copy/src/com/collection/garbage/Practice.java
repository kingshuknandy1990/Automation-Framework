package com.collection.garbage;

import java.util.ArrayList;
import java.util.List;

import com.GenericFunctions.WebDriver.GenericFunctionsExtra;
import com.GenericFunctions.WebDriver.GenericWebDriverFunctions;

public class Practice {

	public static void main(String[] args) {
		quantityPriceValidator("$2.80","3","$8.40");
		

	}
	
	public static List quantityPriceValidator(String eachItemPrice,String qty,String totalprice){
		boolean status=false;
		List li=new ArrayList();
		double EachItemPrice=GenericFunctionsExtra.StringToDoubleConvertor(eachItemPrice);
		System.out.println("-->"+EachItemPrice);
		double Qty=Double.parseDouble(qty);
		double CalculatedTotalprice=EachItemPrice*Qty;
		System.out.println("Calculated Total Price:"+CalculatedTotalprice);
		
		double ObtainedTotalPrice=GenericFunctionsExtra.StringToDoubleConvertor(totalprice);
		System.out.println("Obtained Total Price:"+ObtainedTotalPrice);
		/*if(GenericFunctionsExtra.NumberComparer(CalculatedTotalprice, ObtainedTotalPrice)){
			status=true;
		}*/
		//double CalculatedTotalpriceOther=Math.round(CalculatedTotalprice*100)/100;
		   //double number1 = 10.129456;
		   double CalculatedTotalpriceOther = (int)Math.round(CalculatedTotalprice * 100)/(double)100;
		   //System.out.println(number2); 
		System.out.println("Rounded Total Price:"+CalculatedTotalpriceOther);
		
		if(CalculatedTotalpriceOther==ObtainedTotalPrice){
			status=true;	
		}
		li.add(status);
		li.add(CalculatedTotalpriceOther);
		return li;	
	}

}
