package com.constants.string;

public interface ShoppingCartPageConstands {

	String CartPageHeading="(//div[@class='cartTitle']//p[contains(text(),'Shopping cart')])[1]",
			Shoppingbag="//div[@class='cartTitle']//p[@class='shoppingBag']",
			ItemBlock="//div[@class='items']//div[@class='item row']",
			ItemDescription="",
			Shipping="",
			Quantity="",
			Price="",
			Subtotal="//div//ul//li[@class='totals-subtotal']",
			promotionSection="//div[@class='action apply']",
			OrderTotalSection="//div//ul//li[@class='totals-total']"
			;
	
	
	String AccountsLogin="(//div[@id='checkout-method']//div)[1]",
			ShippingAndDelivery="(//div[@id='shipping-delivery']//div)[1]",
			PaymentAndBilling="(//div[@id='payment-billing']//div)[1]",
			ConfirmOrder=""
			
			;
}
