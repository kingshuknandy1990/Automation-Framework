package com.constants.string;

public interface PDPpageExtConstants {

	

	public static int cellno = 1;
	public static String TestData = "TestData",
						
						filepath=System.getProperty("user.dir")+"\\Bealls_Execution_Excel.xlsx";

   //elements By X-path
	public static String OfferPrice="//div[@id='prod-price']//div[@class='price']",
							ListPrice="//div[@id='prod-price']//div[@class='list-price price-reg']",
							Save="//div[@id='prod-price']//div[@class='save-price price-save']",
							sizes="//ul[@id='list-Size']/li/a";
							
							
							
							;

}
