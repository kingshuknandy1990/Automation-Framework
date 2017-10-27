package com.constants.string;

public interface TopNavigationConstands {

	public static int cellno = 1;
	public static String TestData = "TestData",
						
						filepath=System.getProperty("user.dir")+"\\Bealls_Execution_Excel.xlsx";
	public static String TopNavigationLinks = "//a[@class='main-nav-link']",
							L2NavigationLinks="//a[@class='link-list-link']",
									
									L2NavigationLandingPageVerification="//div[@class='dropdowns-additional']"
			;
	
	public static String Brand="//div[@class='link-list-group']//h3[contains(text(),'Brand')]",
							Espots=	"//div[@class='marketing-area col-lg-9 col-md-12 col-sm-12']",
			        Categories="//div[@class='link-list-group']//h3[contains(text(),'Categories')]"
			        
			        
			        
			        
			        ;
	public static final  String ItemsBlock= "item-info-block";
	
	public static int L1catagoryNameRow=53,
						StartCouterno=54,
								L1catagorySpecificNameRow=60,
								StartSpecificCouterno=61
						
						
						
			;
	public static int L2catagoryNameRow = 63;
	
	public static int L2catagoryNameRowSpecific = 65;
	public static int StartCouternoL2Specific = 66;
	public static int EndCouternoL2Specific = 67;
	//public static int L2catagoryNameRowSpecific = 0;
	
}
