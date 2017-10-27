package com.constants.string;



/**
 * This class contains all element locators of SearchDisplayPage 
 * which all are String  constants. In case of any changes in
 * the SearchDisplayPage this class needs an update if needed.
 * 
 * @author skandakumar.v
 *
 */
public class SearchDisplayConstants {

	//Elements located by XPath
	public static final String GIFTCARDPATH="//a[contains(@href,'card')]/img",ITEMSLINK="//a[contains(@class,'item-img-link')]",
			 RESULTSUMMARY="//h1[contains(@class,'search-results-message')]",BREADCRUMB="//ul[contains(@class,'breadcrumbs')]/li[2]",
			 ESPOTCONTENT="//div[contains(@class,'content-spot')]",QUICKVIEW="//div[contains(@class,'item-block')]/div[1]/a[2]";
	public static final String LOWTOHIGH="//select[contains(@id,'orderBy')]",COLORDROPDOWN="//select[contains(@id,'dd-Color')]", LOWINVENTORY="//span[contains(@class,'low-inventory')]",
			  NOINVENTORY="//div[contains(@id,'noInvErr')]",ITEMNAME="//div[contains(@class,'item-info-block')]/div[2]",ITEMPRICE="//div[contains(@class,'item-info-block')]/div[3]",
			  QVCLOSE="//div[contains(@id,'product')]/div/div/div/a",QVSELECTEDCOLOR="(//div[contains(@class,'expand')])[2]",
			  ADDTOWISHLIST="//div[contains(@id,'add-area')]/div[2]/a[contains(@class,'wishlist-text')]"
			  ,QUANTITYDROPDOWN="//select[@id='quantity']",
			  ADDTOWLQV="//div[contains(@id,'addToCart')]/a[2]",
			errorfeild="//div[@id='noInvErr']//div";

}
