package com.constants.string;

/**
 * This class contains all element locators of BedAndBathPage 
 * which all are String  constants. In case of any changes in
 * the BedAndBathPage this class needs an update if needed.
 * 
 * @author skandakumar.v
 *
 */
public class BedAndBathConstants {
	//Locate by linktext
		public static final String BEDANDBATH="Bed & Bath";
		
		
		//Elements located by XPath
		public static final String ESPOTP2 ="//div[contains(@id,'page_wrapper')]/div[2]/div/a/img",
				ESPOTP3 ="//div[contains(@class,'Kitchen')]/a/img",ESPOTP4_5="//div[contains(@class,'photo')]/a/img",
				WIDTHIMAGE="//div[contains(@class,'FullWidthImg')]/a/img";
}
