package com.constants.string;



/**
 * This class contains all element locators of OrderPaymentPage 
 * which all are String  constants. In case of any changes in
 * the OrderPaymentPage this class needs an update if needed.
 * 
 * @author skandakumar.v
 *
 */
public class OrderPaymentConstants {

	
	//Elements located by XPath
		public static final String SUBTOTALS="//div[contains(@class,'price table-cell')]",
	SUBTOTAL ="//div[@id='total-subtotal']", CARDNUMBER="//div/input[contains(@name,'account')]",
		SECCODE="//div/input[contains(@name,'pay_data_cvvNumber')]",CARDTYPE="//select[@name='paymentMethod']",
				 EXPIREMONTH="//select[@name='expire_month']", EXPIRE_YEAR="//select[@name='expire_year']",
				 PROMODISCOUNT="//div[@id='promo-discount-amount']",GIFTWRAP="//div[@id='total-adjustment-gift-wrap']",
				 COMPLETEORDER="//div[@id='cart-right']/div[16]/a[contains(@class,'btn-checkout')]",ESTTAX="//div[@id='total-tax']"
						 ,GIFTSUBTOTAL="//div[@id='giftcard-subtotal']",
						 SHIPPINGCOST="//div[contains(@id,'total-shipping')]", SHIPSURCHARGE="//div[contains(@id,'oversized-fee')]",
						 FREESHIP="(//div[contains(@id,'total-shipping')])[2]";
		
		public static final String CARDTYPEOPC="//select[contains(@id,'credit-card-type')]",CARDNUMBEROPC="//input[contains(@id,'cc-number')]",
				SECCODEOPC="//div[contains(@id,'date-cvv')]/div[2]/input[contains(@id,'cvv-number')]",EXPIREMONTHOPC="//select[contains(@id,'expMonth')]",
				EXPIRE_YEAROPC="//select[contains(@id,'expYear')]";
				
}