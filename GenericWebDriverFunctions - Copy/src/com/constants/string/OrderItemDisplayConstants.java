package com.constants.string;


/**
 * This class contains all element locators of OrderItemDisplayPage 
 * which all are String  constants. In case of any changes in
 * the OrderItemDisplayPage this class needs an update if needed.
 * 
 * @author skandakumar.v
 *
 */
public class OrderItemDisplayConstants {
	
	
	//Elements located by XPath
	public static final String SCHECKOUT="//div[@id='checkout-button']",SHIPPING = "//div[@id='total-shipping']",
			SUBTOTAL ="//div[@id='total-subtotal']",ESTOTAL="//div[@id='total-total']",PSUBTOTAL="//div[contains(@id,'subttl')]/div",
			ALLPRICES="//div[contains(@id,'subttl')]/div[contains(@class,'price')]",GIFTSUBTOTAL="//div[@id='giftcard-subtotal']",
			GIFTWRAP="//input[contains(@id,'gifting')]",ADDGIFTWRAP="//input[contains(@id,'giftwrap')]",
			GIFTMESSAGE="//textarea[contains(@id,'gm_msg')]",REMOVELINK="//div[contains(@id,'item')]/div[1]/div[2]/a",
			SHIPDETCLOSE="//div[@id='ordershipping']/div/div/div/div/a[contains(@class,'modal-close btn-alt2')]",
			SKU="//div[contains(@class,'sku')]",ALLPRICESOPC="//div[contains(@class,'item-price')]",SUBTOTALOPC="//div[contains(@class,'left-part')]/ul/li[contains(@class,'totals-subtotal')]/span";
	public static final String REMOVELINKOPC="//button[contains(@data-orderitem-action,'delete')]";
	//div[contains(@id,'total-subtotal')]
}
