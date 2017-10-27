package com.Pages.AllBealls;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericFunctions.WebDriver.GenericWebDriverFunctions;
import com.constants.string.OrderItemDisplayConstants;
import com.constants.string.StringConstants;
import com.reports.beallsCustom.CustomReporter;


public class OrderItemDisplayPage {
	
	
 

	public static String discPrice;
 
	@FindBy(xpath = OrderItemDisplayConstants.SCHECKOUT)
	public static WebElement secCheckout;
	
	@FindBy(xpath=OrderItemDisplayConstants.SUBTOTAL)
	public static WebElement proSubTotal;
	
	@FindBy(xpath=OrderItemDisplayConstants.SUBTOTALOPC)
	public static WebElement proSubtotalOpc;
	
//	@FindAll({@FindBy(xpath=OrderItemDisplayConstants.ALLPRICES)})
	@FindAll({@FindBy(xpath=OrderItemDisplayConstants.ALLPRICESOPC)})
	public static List <WebElement> subTotals; 
	
	
	@FindBy(xpath=OrderItemDisplayConstants.GIFTSUBTOTAL)
	public static WebElement giftSubTotal;
	
	@FindAll({@FindBy(xpath=OrderItemDisplayConstants.GIFTWRAP)})
	public static List <WebElement> giftWrap;
	
	@FindAll({@FindBy(xpath=OrderItemDisplayConstants.ADDGIFTWRAP)})
	public static List <WebElement> addGiftWrap;
	
	@FindAll({@FindBy(xpath=OrderItemDisplayConstants.GIFTMESSAGE)})
	public static List <WebElement> giftMessage;
	
	@FindAll({@FindBy(xpath=OrderItemDisplayConstants.REMOVELINK)})
	public static List<WebElement> removeLink;
	
	@FindAll({@FindBy(xpath=OrderItemDisplayConstants.REMOVELINKOPC)})
	public static List<WebElement> removeLinkOpc;
	
	
	@FindBy(xpath=OrderItemDisplayConstants.SHIPDETCLOSE)
	public static WebElement modalClose;
	
	@FindBy(xpath=OrderItemDisplayConstants.SKU)
	public static WebElement sku;
	
	
//	@FindBy(xpath=StringConstants.OIDDPRICE)
//	public static WebElement oidDiscPrice;
//	
//	@FindBy(xpath=StringConstants.OIDD)
//	public static WebElement oidDiscount;
//	
//	@FindBy(xpath=StringConstants.OIDOLDPRICE)
//	public static WebElement oidOldPrice;
	public static double temp,oiddis,oidoldPrize,oidoffpri,oiddiscountp;
	public static String priceCP;
	
	public static double tempSubTot=0,newSubTot=0;
	
	  static {new OrderItemDisplayPage();}
	
	  
	  public OrderItemDisplayPage() {
		  PageFactory.initElements(GenericWebDriverFunctions.driver, this);
		 
	}
	
	
	public static void fetchPriceBlock()
	{
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 WebElement oiddiscount = GenericWebDriverFunctions.findElementsBy(StringConstants.OIDD);
		 WebElement oidoldPrice = GenericWebDriverFunctions.findElementsBy(StringConstants.OIDOLDPRICE);
		 WebElement oiddiscPrice = GenericWebDriverFunctions.findElementsBy(StringConstants.OIDDPRICE);
		
		 if(oiddiscount !=null && oidoldPrice!=null)
		 {
			 GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, oiddiscount, "");
			  String oid_discount =GenericWebDriverFunctions.getText;
			  GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, oidoldPrice, "");
			  String oid_oldprice = GenericWebDriverFunctions.getText;
			  GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, oiddiscPrice, "");
			  String oid_discprice = GenericWebDriverFunctions.getText;
			  
 

			StringBuilder disc =new StringBuilder(oid_discount.split(":")[1].trim());
			disc.deleteCharAt(disc.length()-1);
			
			System.out.println("discount "+disc);
			
			oiddis = Double.parseDouble(disc.toString());
			
			
			StringBuilder oldp =new StringBuilder(oid_oldprice.split("\\$")[1]);
//			oldp.deleteCharAt(0);
			System.out.println("Old price "+oldp);
			
			oidoldPrize = Double.parseDouble(oldp.toString());
			
		 
				
				StringBuilder offP= new StringBuilder(oid_discprice);
				 discPrice = offP.toString();
				offP.deleteCharAt(0);
				oidoffpri = Double.parseDouble(offP.toString());
				 
				 
				  
				 
		 }
		 else
		 {
			  GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, oiddiscPrice, "");
			  String oid_discprice = GenericWebDriverFunctions.getText;
			  StringBuilder offP= new StringBuilder(oid_discprice);
//				offP.deleteCharAt(0);
		 
			  discPrice = offP.toString();
			 
			  	oiddis=oidoldPrize= -1;
		 }
		
	}
	
	public static void verifySKU()
	{
		
	}
	
	//To be edited...
	public static void selectGiftWrapOpc() throws InterruptedException
	{
		
		for(int counter=0;counter<addGiftWrap.size();counter++)
		{
			WebElement addGift =  addGiftWrap.get(counter);
			String id = addGift.getAttribute("id");
			id=id.substring((id.length()-1), id.length());
			int idI = Integer.parseInt(id);
			WebElement giftCard= giftWrap.get(idI-1);
			GenericWebDriverFunctions.performAction(StringConstants.CLICK,giftCard , "");
			GenericWebDriverFunctions.performAction(StringConstants.CLICK,addGift , "");
			
			Thread.sleep(6000);
			
			WebElement giftMesg =giftMessage.get(idI-1);
			GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, giftMesg, "Best Wishes");
		}
		
		Thread.sleep(5000);
	}
	
	public static void selectGiftWrap() throws InterruptedException
	{	
//		Random r= new Random();
//		int random=0;
//		random = r.nextInt((giftWrap.size()-1));
//		WebElement giftCard = giftWrap.get(random);
//		GenericWebDriverFunctions.performAction(StringConstants.CLICK,giftCard , "");
//		
//		
		
		for(int counter=0;counter<addGiftWrap.size();counter++)
		{
			WebElement addGift =  addGiftWrap.get(counter);
			String id = addGift.getAttribute("id");
			id=id.substring((id.length()-1), id.length());
			int idI = Integer.parseInt(id);
			WebElement giftCard= giftWrap.get(idI-1);
			GenericWebDriverFunctions.performAction(StringConstants.CLICK,giftCard , "");
			GenericWebDriverFunctions.performAction(StringConstants.CLICK,addGift , "");
			
			Thread.sleep(6000);
			
			WebElement giftMesg =giftMessage.get(idI-1);
			GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, giftMesg, "Best Wishes");
		}
		
		Thread.sleep(5000);
		
		
//		while(GenericWebDriverFunctions.findElementsByXpath(OrderItemDisplayConstants.ADDGIFTWRAP)<0)
//		{
//		GenericWebDriverFunctions.performAction(StringConstants.CLICK,giftCard , "");
//		random = r.nextInt((giftWrap.size()-1));
//		giftCard = giftWrap.get(random);
//		GenericWebDriverFunctions.performAction(StringConstants.CLICK,giftCard , "");
//		}
//		
//		 
//		WebElement addGift = addGiftWrap.get(random);
//		GenericWebDriverFunctions.performAction(StringConstants.CLICK, addGift, "");
//		
		
		
	}
	
	
	
	public static void removeItems() throws InterruptedException
	{
 
		
		while(!removeLink.isEmpty())
		{ 
			GenericWebDriverFunctions.performAction(StringConstants.CLICK, removeLink.get(0), "");
			Thread.sleep(9000);
			removeLink = GenericWebDriverFunctions.getElementByXpath(OrderItemDisplayConstants.REMOVELINK);
			System.out.println(removeLink.size());
		}
		
	}
	
	public static void removeItemsOpc() throws InterruptedException
	{
 
		
		while(!removeLinkOpc.isEmpty())
		{ 
			GenericWebDriverFunctions.performAction(StringConstants.CLICK, removeLinkOpc.get(0), "");
			Thread.sleep(9000);
			removeLinkOpc = GenericWebDriverFunctions.getElementByXpath(OrderItemDisplayConstants.REMOVELINKOPC);
			 
		}
		
	}
	
	public static void validateDiscountPriceCP()
	{
		
		temp = oidoffpri;
		 oiddiscountp = (oiddis*oidoldPrize)/100;
		 
		 if(oiddis ==-1 || oidoldPrize==-1)
		 {
			 CustomReporter.startChild("Discount in CP", "");
				CustomReporter.reportChild("Pass", "No discount applicable");
				CustomReporter.endChildTest();
			 
		 }
		 else
		 {
		 if(temp == (oidoldPrize-oiddiscountp))
		 {
		 
			 CustomReporter.startChild("Discount in CP", "");
		    	CustomReporter.reportChild("pass", "Discount price for "+CustomReporter.category+" is proper");
		    	CustomReporter.addChildInfo("The discount price in CP is "+OrderItemDisplayPage.oiddis);
		    	CustomReporter.endChildTest();
		 }
		 else
		 {
			 System.out.println(temp +" ,"+oidoldPrize+" , "+oiddiscountp+(oidoldPrize-oiddiscountp));
			 CustomReporter.startChild("Discount in CP", "");
		    	CustomReporter.reportChild("FAIL", "Discount price for "+CustomReporter.category+" is not proper");
		    	CustomReporter.addChildInfo("The discount price in CP is "+OrderItemDisplayPage.oiddis);
		    	CustomReporter.endChildTest();
			 
		 }
		 }
		 temp = oiddis = oidoldPrize = oidoffpri = oiddiscountp=0;
		 OrderItemDisplayPage.discPrice="";
	}
	
	
	public static void validatePriceCP()
	{
		fetchPriceBlock();
	 	System.out.println("disc Price in validatePriceCP "+discPrice);
		OrderItemDisplayPage.priceCP = OrderItemDisplayPage.discPrice;
		OrderItemDisplayPage.removeItemFromCart();
		CustomReporter.startChild("Price in CP", "");
		CustomReporter.addChildInfo("The Price in CP is "+OrderItemDisplayPage.priceCP);
		CustomReporter.endChildTest();
		
		
	}
	
	
	public static void removeItemFromCart()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement element= GenericWebDriverFunctions.findElementByLinkText(StringConstants.REMOVE);
		if(element!=null)
		{
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, element, "");
		}
	}
	
	
	
	
	public static void secureCheckout()
	{
		if(GenericWebDriverFunctions.findElementsByXpath(OrderItemDisplayConstants.SHIPDETCLOSE)>0)
			GenericWebDriverFunctions.performAction(StringConstants.CLICK, modalClose, "");
//		validateProductSubTotalBeforeLogin();
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, secCheckout, "");
		
		
	}
	
	
	//To validate the total of sub totals 
	public static void  validateProductSubTotalBeforeLogin()
	{
//		tempSubTot=0;
		try
		{
		Thread.sleep(3000);
		}
		catch(InterruptedException ex)
		{
			
		}
		String giftSubtotal="";
		
		
		
		Locale locale = new Locale("en", "US");
		NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
		 
		
		
		
		double sum=0;
		for(int i=0;i<subTotals.size();i++)
		{
			sum+=Double.parseDouble(subTotals.get(i).getText().replace("$", ""));
		}
		
		tempSubTot=sum;
		if(GenericWebDriverFunctions.findElementsByXpath(OrderItemDisplayConstants.GIFTSUBTOTAL)>0)
		{
		if(!giftSubTotal.getText().isEmpty())
		{
		giftSubtotal=giftSubTotal.getText();
		
		tempSubTot =tempSubTot-Double.parseDouble(giftSubtotal.replace("$", ""));
		}
		}
		
 
		
		CustomReporter.startChild("Subtotal in Cart page ", "");
		CustomReporter.addChildInfo("Subtotal in Cart page  is "+tempSubTot);
//		System.out.println("Subtotal in OIP "+tempSubTot);
		
		if(GenericWebDriverFunctions.findElementsByXpath(OrderItemDisplayConstants.SUBTOTALOPC)>0)
		{
//Before
//		if(fmt.format(tempSubTot).equalsIgnoreCase(proSubTotal.getText()))
		//After 
		if(fmt.format(tempSubTot).equalsIgnoreCase(proSubtotalOpc.getText()))
		CustomReporter.reportChild("PASS","Subtotals are same in Cart page" );
//		System.out.println("Subtotals are same in Order Item Page");
		else
		CustomReporter.reportChild("FAIL","Subtotals are not same in Cart page" );
//		System.out.println("Subtotals are not same in Order Item  page");
		}
		
		CustomReporter.endChildTest();
	}
	
	public static void  validateProductSubTotalAfterLogin()
	{
		Locale locale = new Locale("en", "US");
		NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
		 
		  
		for(int i=0;i<subTotals.size();i++)
			newSubTot+=Double.parseDouble(subTotals.get(i).getText().replace("$", ""));		
		
		System.out.println("After  login "+newSubTot);
		
		if(fmt.format(newSubTot).equalsIgnoreCase(proSubTotal.getText()))
		System.out.println("Subtotals are same");
		else
		System.out.println("Subtotals are not same");
	}
	
	public static void validateNewOldSubTot()
	{
		System.out.println(tempSubTot +", "+newSubTot);
		if(tempSubTot ==newSubTot)
			System.out.println("Subtotal before and after login are same");
		else
			System.out.println("Subtotal before and after login are not same");
	}
}
