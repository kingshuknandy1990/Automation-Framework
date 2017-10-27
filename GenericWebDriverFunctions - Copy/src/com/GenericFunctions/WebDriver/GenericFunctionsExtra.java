package com.GenericFunctions.WebDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class GenericFunctionsExtra {

	/**
	 *Shippingflag=0  //Initialization 
	 *		      =1  //Proper shipping Charge
	 *			  =2  //Improper Shipping Charge
	 */
	public static int Shippingflag=0;
	public static String parentReportName;
	public static String parentReportDescription;
	public static boolean parentReportsettingFlag=true;   //you can set the flag
	
	
	
	/**
	 *EstimatedTotalflag=0  //Initialization 
	 *		      =1  //Proper Estimated Total
	 *			  =2  //Improper Estimated Total
	 */
	public static int EstimatedTotalflag=0;
	
	
	public static boolean ElementVisibility(List <WebElement> element){
		boolean status=false;
		//if element is visible
		if(element.size() != 0){
			status=true;
    		}
		
		return status;
	}
	
	public static Double StringToDoubleConvertor(String PriceInDollar){
		String str=" "+PriceInDollar;
	    String OfferPrice1[]=str.split("\\$");
	    Double subtotal=Double.parseDouble(OfferPrice1[1]);
	    
		return subtotal;
		
	}
		
		public static boolean NumberComparer(Double a,Double b){
			
			boolean status=false;
			double roundOffA = Math.round(a*100)/100;
			double roundOffB = Math.round(b*100)/100;
			System.out.println("roundOffA:"+roundOffA+"    "+"roundOffB:"+roundOffB);
			if(roundOffA==roundOffB){
				System.out.println("No. are equal");
				status=true;
			}else{
				System.out.println("No. are not equal");
			}
			return status;
			
		}
		
		public static String[] Split(String str) {

			String[] tokens = str.split("[\\s']");
			return tokens;
		}
		
		
		public static StringBuffer Concatenation(StringBuffer s,String str){
			  
		      s = s.append(str);
		      //System.out.println(s);
			return s;

		}
		
		public static void main(String[] args) {
				GenericFunctionsExtra.ExtractdoublefromString("You Save: 40%  ");
		}
		
	   public static Double ExtractdoublefromString(String stringToStrip){
		   
		 //  String stringToStrip="radius: -0.118211 zone";
		   String stripedValue = (stringToStrip.replaceAll("[\\s+a-zA-Z :]",""));
		   double dbl = Double.parseDouble(stripedValue);
		   System.out.println(dbl);
		return null;
		   
	   }
	   
		public static List<Double> PriceRangeStringTodouble(String str){
			String strr[]=str.split("\\$");
			List<Double> li=new ArrayList<Double>();
			for (int i = 0; i < strr.length; i++) {
				//System.out.println("Range:"+i+")"+strr[i].replace("-", ""));
				try {
					Double dou=Double.valueOf(strr[i].replace("-", ""));
					//System.out.println("Double:"+dou);
					li.add(dou);
				} catch (Exception e) {
					// TODO: handle exception
				}
				//System.out.println("---------------------------------");
			}
			
			return li;
			
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
			 double CalculatedTotalpriceOther = (int)Math.round(CalculatedTotalprice * 100)/(double)100;
			if(CalculatedTotalpriceOther==ObtainedTotalPrice){
				status=true;	
			}
			li.add(status);
			li.add(CalculatedTotalpriceOther);
			return li;	
		}

	
		
}
