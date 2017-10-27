package com.constants.string;

public interface SDPExtendedConstants {

	
	
	public static final  String NoofItemsPage30="//span[contains(text(),'30')]";    //xpath
	public static final  String NoofItemsPage60="//span[contains(text(),'60')]";    //xpath
	public static final  String NoofItemsPage90="//span[contains(text(),'90')]";    //xpath
	public static final  String ItemsBlock= "item-info-block";              //className
	
	public static final  String click30="//div[@class='page-control']//a[contains(text(),'30')]",
			                    click60="//div[@class='page-control']//a[contains(text(),'60')]",
			                    click90="//div[@class='page-control']//a[contains(text(),'90')]";
	
	//---------------Page Navigators--------------------
	public static final  String TopRightArrow="(//span[@class='icon-page-next'])[1]";  //xpath
	public static final  String BottomRightArrow="(//span[@class='icon-page-next'])[2]";  //xpath
	public static final  String TopLeftArrow="(//span[@class='icon-page-back'])[1]";  //xpath
	public static final  String BottomLeftArrow="(//span[@class='icon-page-back'])[2]";  //xpath
	public static final  String TopLastPageArrow="(//span[@class='icon-page-last'])[1]";  //xpath
	public static final  String BottomLastPageArrow="(//span[@class='icon-page-last'])[2]";  //xpath
	public static final  String TopFirstPageArrow="(//span[@class='icon-page-first'])[1]";  //xpath
	public static final  String BottomFirstPageArrow="(//span[@class='icon-page-first'])[2]";  //xpath
	public static final String SRPbreadcrumbs = "//div[@id='Search_Result_Summary']//h1";


	
}
