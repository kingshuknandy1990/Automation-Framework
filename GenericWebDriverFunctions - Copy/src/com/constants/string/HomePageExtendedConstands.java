package com.constants.string;

public interface HomePageExtendedConstands {
	
	public static int cellno = 1;
	public static String TestData = "TestData",
						
						filepath=System.getProperty("user.dir")+"\\Bealls_Execution_Excel.xlsx";

	public static String ShoppingBagButton="//h2[@id='shoppingcart-display-count']",
							ChecOutButton="//div/a[@class='btn-checkout expand']",
							Remove="//a[contains(text(),'Remove')]",
						MiniCartItemsection="//form[@id='MiniShopBagForm']//div[@class='row']",
						CartPageTitle="(//div[@class='cartTitle']//p[contains(text(),'Shopping cart')])[1]";
}
