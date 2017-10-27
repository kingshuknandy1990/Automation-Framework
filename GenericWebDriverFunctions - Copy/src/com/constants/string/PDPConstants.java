package com.constants.string;





/**
 * This class contains all element locators of PDPPage 
 * which all are String  constants. In case of any changes in
 * the PDPPage this class needs an update if needed.
 * 
 * @author skandakumar.v
 *
 */
public class PDPConstants {
	
	//Elements located by XPath
	
public static final String CSHOPPING="//a[contains(@class,'continue-shopping')]",

	SIZES="//ul[@id='list-Size']/li/a",COLORS="//a[contains(@title,'Color')]",ATTRIBUTES="//div[@id='attribute-section']",
	QUANTITYDROPDOWN="//select[@id='quantity']",SELECTEDCOLOR="//span[contains(@id,'selected-Color')]",ITEMNAME="//div[@id='title']/h1",
	ITEMPRICE="//div[contains(@id,'prod-price')]/div",SIZE="//span[@id='selected-Size']",DISABLEDATTRIBS="//select[contains(@disabled,'')]";

}
