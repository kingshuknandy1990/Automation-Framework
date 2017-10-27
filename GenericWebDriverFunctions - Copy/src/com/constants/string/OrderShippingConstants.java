package com.constants.string;


/**
 * This class contains all element locators of OrderShippingPage 
 * which all are String  constants. In case of any changes in
 * the OrderShippingPage this class needs an update if needed.
 * 
 * @author skandakumar.v
 *
 */
public class OrderShippingConstants {

	
	//Elements located by name
	public static final String SHIPSAMEBILL="shipSameBill";
	
	//Elements located by XPath
	public static final String SUBTOTALS="//div[contains(@class,'price table-cell')]",ESTTAX="//div[@id='total-tax']",
			 PROMODISCOUNT="//div[@id='promo-discount-amount']",GIFTWRAP="//div[@id='total-adjustment-gift-wrap']",
			 EDITBILLING="//a[@id='edit_billing']", CITY="(//input[@name='city'])[2]",STATE="(//select[@name='state'])[2]"
			 ,ZIPCODE="(//input[@name='zipCode'])[2]",
			 EDITSHIPPING="//div[contains(@id,'shipping-address')]/div[2]/div[2]/a",SCITY="(//input[@name='city'])[2]",SSTATE="(//select[@name='state'])[2]",
			 SZIPCODE="(//input[@name='zipCode'])[2]",
			 SUBTOTAL ="//div[@id='total-subtotal']",
			 USEMYENTRY="//div[contains(@id,'use-my-entry')]/a",
			 CONCHECKOUT="//div[contains(@class,'billing-page')]/div/a[contains(@class,'btn-checkout')]"
					 ,GIFTSUBTOTAL="//div[@id='giftcard-subtotal']",
					 SHIPADDRESS="//div[contains(@class,'cityStateZip')]",
					 BILLADDRESS="//div[contains(@id,'left-billing')]/div[2]/address/div[contains(@id,'city-state-zip')]",
							 PHONE="(//input[contains(@class,'expand phone')])[2]";
	
	
	public static final String SAMESHIPBILL="//select[contains(@id,'billing-address')]",CITYOPC="//div[contains(@id,'billingAddress')]/div/div/input[@name='city']",
			STATEOPC="//div[contains(@id,'billingAddress')]/div/div[6]/select",ZIPCODEOPC="//div[contains(@id,'billingAddressForm')]/div[2]/div/input[@name='zipCode']",
			PHONEOPC="//div[contains(@id,'billingAddressForm')]/div[2]/div[2]/input[@name='phone1']",ORDERCONFIRM="//button[contains(@class,'billingSubmit')]",
			PLACEORDEROPC="//button[contains(text(),'Place Order now')]",EDITSHIPOPC="//div[contains(@id,'shipping-delivery')]/div[2]/span",
			CITY_OPC_ES="//div[contains(@id,'shippingAdd')]/div/div[5]/input",STATE_OPC_ES="//div[contains(@id,'shippingAdd')]/div/div[6]/select",
					ZIP_CODE_OPC_ES="//div[contains(@id,'shippingAdd')]/div[2]/div[1]/input",
					PHONE_OPC_ES="//div[contains(@id,'shippingAdd')]/div[2]/div[2]/input",
					CONTINUE_PAY_OPC_ES="//div[contains(@class,'shipping-form')]/div[2]/div[4]/button"
			;
	
	
}
