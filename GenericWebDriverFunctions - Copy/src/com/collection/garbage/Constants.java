package com.collection.garbage;

public interface Constants {

	public static final String CP_price="(//div[@class='item-price'])[3]//div[@class='price']";
	public static final String PDP_price="";
	public static final String QV_price="//div[@id='prod-price']//div[@class='price']";
	public static final String SRP_price="(//div[@class='price'])[1]";
	
	public static final String CP_price_reg="(//div[@class='item-price'])[3]//div[@class='price-reg']";
	public static final String PDP_price_reg="";
	public static final String QV_price_reg="//div[@class='list-price price-reg']";
	public static final String SRP_price_reg="(//div[@class='price-reg'])[1]";
	
	public static final String CP_price_save="(//div[@class='item-price'])[3]//div[@class='price-save save-price']";
	public static final String PDP_price_save="";
	public static final String QV_price_save="//div[@class='save-price price-save']";
	public static final String SRP_price_save="(//div[@class='price-save'])[1]";
	
	
	public static final String QVButton="(//a[@class='quick-view-button btn-secondary'])[1]";
	
	
	public static final String keyWordSearchbox="//input[@id='SimpleSearchForm_SearchTerm']";
	//a[@id='addToCartButton']
	public static final String AddToCartButton="//a[@id='addToCartButton']";
	
	public static final String  CheckOutButton="(//a[@class='checkout-button btn-checkout'])[1]";
	public static final String  ContinueShoppingButton="//div[@class='modal-body']//a[@class='continue-shopping-button btn-secondary']";
}
