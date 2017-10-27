package com.Pages.AllBealls;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericFunctions.WebDriver.GenericFunctionsExtra;
import com.GenericFunctions.WebDriver.GenericWebDriverFunctions;
import com.bealls.pojo.ItemsInfo;
import com.constants.string.SDPExtendedConstants;
import com.constants.string.SearchDisplayConstants;
import com.constants.string.StringConstants;
import com.excellibrary.bealls.ExcelLibrary;
import com.reports.beallsCustom.CustomReporter;



public class SDPExtended {

	/*	   WebDriver driver;	
	  // static WebDriver driver=null;
	   static String status=null;
	   static String description=null;
	   static String sheetName="ScenarioList";*/
	  
	  @FindBy(xpath=SDPExtendedConstants.NoofItemsPage30)
	  public static WebElement NoofItemsPage30;
	  
	  @FindBy(xpath=SDPExtendedConstants.NoofItemsPage60)
	  public static WebElement NoofItemsPage60;
	  
	  @FindBy(xpath=SDPExtendedConstants.NoofItemsPage90)
	  public static WebElement NoofItemsPage90;
	  
	  @FindBy(xpath=SDPExtendedConstants.click30)
	  public static WebElement click30;
	  
	  @FindBy(xpath=SDPExtendedConstants.click60)
	  public static WebElement click60;
	  
	  @FindBy(xpath=SDPExtendedConstants.click90)
	  public static WebElement click90;
	  
	  @FindBy(xpath=SDPExtendedConstants.NoofItemsPage30)
	  public static List <WebElement> NoofItemsPage30list;
	  
	  @FindBy(xpath=SDPExtendedConstants.NoofItemsPage60)
	  public static List <WebElement> NoofItemsPage60list;
	  
	  @FindBy(xpath=SDPExtendedConstants.NoofItemsPage90)
	  public static List <WebElement> NoofItemsPage90list;
	  
	  @FindBy(className=SDPExtendedConstants.ItemsBlock)
	  public static List <WebElement>  ItemsBlock;
	  
	  
	//---------------Page Navigators--------------------
	  
	  @FindBy(xpath=SDPExtendedConstants.TopRightArrow)
	  public static  WebElement TopRightArrow;
	 
	  @FindBy(xpath=SDPExtendedConstants.BottomRightArrow)
	  public static WebElement BottomRightArrow;
	  
	  @FindBy(xpath=SDPExtendedConstants.TopLeftArrow)
	  public static WebElement TopLeftArrow;
	  
	  @FindBy(xpath=SDPExtendedConstants.BottomLeftArrow)
	  public static WebElement BottomLeftArrow;
	  
	  @FindBy(xpath=SDPExtendedConstants.TopLastPageArrow)
	  public static WebElement TopLastPageArrow;
	  
	  @FindBy(xpath=SDPExtendedConstants.BottomLastPageArrow)
	  public static WebElement BottomLastPageArrow;
	  
	  @FindBy(xpath=SDPExtendedConstants.TopLastPageArrow)
	  public static WebElement TopFirstPageArrow;
	  
	  @FindBy(xpath=SDPExtendedConstants.BottomFirstPageArrow)
	  public static  WebElement BottomFirstPageArrow;
	  
	  
	  
	//------------------------Copied from differnent class--------------------------
	  
	  public static Random r = new Random();
		@FindBy(id = StringConstants.SEARCHBOX)
		public static WebElement searchBox;

		@FindBy(id = StringConstants.SEARCHBUTTON)
		public static WebElement searchButton;

		@FindBy(xpath = StringConstants.SDPUNITPRICE)
		public static WebElement shirtPrice;

		@FindAll({ @FindBy(xpath = SearchDisplayConstants.ITEMSLINK) })
		public static List<WebElement> selectProduct;

		@FindBy(xpath = StringConstants.QVLINK)
		public static WebElement quickView;

		@FindAll({ @FindBy(xpath = SearchDisplayConstants.QUICKVIEW) })
		public static List<WebElement> quickViews;

		@FindBy(xpath = StringConstants.QVCLOSE)
		public static WebElement quickViewClose;

		@FindBy(xpath = StringConstants.QVPRICE)
		public static WebElement QVPrice;

		@FindBy(xpath = StringConstants.QV_price)
		public static WebElement QV_OfferPrice;

		@FindBy(xpath = StringConstants.QV_price_reg)
		public static WebElement QV_ListPrice;

		@FindBy(xpath = StringConstants.QV_price_save)
		public static WebElement QV_DiscountPercent;

		@FindBy(xpath = StringConstants.SRP_price)
		public static WebElement SRPPrice;

		@FindBy(xpath = StringConstants.SRP_price_reg)
		public static WebElement SRPPriceReg;

		@FindBy(xpath = StringConstants.SRP_price_save)
		public static WebElement SRPPriceSave;

		@FindBy(xpath = StringConstants.SizeDropDown)
		public static WebElement SizeDropDown;

		@FindBy(xpath = StringConstants.AddToCartButton)
		public static WebElement AddToCartButton;

		@FindBy(xpath = StringConstants.CheckOutButton)
		public static WebElement CheckOutButton;

		@FindBy(xpath = StringConstants.CP_price)
		public static WebElement CP_OfferPrice;

		@FindBy(xpath = StringConstants.CP_price_reg)
		public static WebElement CP_ListPrice;

		@FindBy(xpath = StringConstants.CP_price_save)
		public static WebElement CP_DiscountPercent;

		@FindAll({ @FindBy(xpath = SearchDisplayConstants.GIFTCARDPATH) })
		public static List<WebElement> GIFTCARD;

		@FindBy(xpath = SearchDisplayConstants.RESULTSUMMARY)
		public static WebElement resultSummary;

		@FindBy(xpath = SearchDisplayConstants.BREADCRUMB)
		public static WebElement breadCrumb;

		@FindBy(xpath = SearchDisplayConstants.ESPOTCONTENT)
		public static WebElement espotContent;
		public static ExcelLibrary excel = null;

		public static WebElement quickViewItem;
		@FindBy(xpath = SearchDisplayConstants.LOWTOHIGH)
		public static WebElement LOWTOHIGH;

		@FindBy(xpath = SearchDisplayConstants.COLORDROPDOWN)
		public static WebElement colorDropDown;

		@FindBy(xpath=SearchDisplayConstants.LOWINVENTORY)
		public static WebElement lowInventory;
		
		@FindBy(xpath=SearchDisplayConstants.NOINVENTORY)
		public static WebElement noInventoryQV;
		// @FindBy(xpath=StringConstants.)
		
		@FindAll({@FindBy(xpath=SearchDisplayConstants.ITEMPRICE)})
		public static List <WebElement> itemsPrice;
		
		@FindAll({@FindBy(xpath=SearchDisplayConstants.ITEMNAME)})
		public static List <WebElement> itemsName;
		
		@FindBy(xpath=SearchDisplayConstants.QVCLOSE)
		public static WebElement qvClose;
		
		@FindBy(xpath=SearchDisplayConstants.ADDTOWISHLIST)
		public static WebElement addToWishlist;
		
		public static ItemsInfo item ;
		
		@FindBy(xpath=SearchDisplayConstants.QVSELECTEDCOLOR)
		public static WebElement qvSelectedColor;
		
		@FindBy(xpath=SearchDisplayConstants.ADDTOWLQV)
		public static WebElement addToWLQV;
		
		@FindBy(xpath=SearchDisplayConstants.QUANTITYDROPDOWN)
		public static WebElement quantity;
		public  static int itemCounter;
	  //--------------------------------------------------------
	  
		public SDPExtended(){
			PageFactory.initElements(GenericWebDriverFunctions.driver,this);
		}


	public static void ClickOnItemsPerPage(int NoOfItems){
		  if(NoOfItems==30){
			  if (!GenericFunctionsExtra.ElementVisibility(NoofItemsPage30list)) {
				GenericWebDriverFunctions.performAction(StringConstants.CLICK, click30, "");
			     }
		  }else if(NoOfItems==60){
			  if (!GenericFunctionsExtra.ElementVisibility(NoofItemsPage60list)) {
					GenericWebDriverFunctions.performAction(StringConstants.CLICK, click60, "");
				     }
		  }
	      else {
	    	  if (!GenericFunctionsExtra.ElementVisibility(NoofItemsPage90list)) {
					GenericWebDriverFunctions.performAction(StringConstants.CLICK, click90, "");
				     }
		  }
	  }

	public static  int NoOfItemsDisplayed(){
		int size=ItemsBlock.size();
	    return size;
		
	}
	    
		public static  void itemsPer30PageValidation() throws InterruptedException{
			  CustomReporter.startChild("Items Per-Page 30 Validation", "Validating items per-page 30 or Not in Search Rersult Page");
			  try {
				  SDPExtended.ClickOnItemsPerPage(30);
				  int size;
				  Thread.sleep(3000);
				  size=SDPExtended.NoOfItemsDisplayed();
				  if(size==30){
						System.out.println("Pass"+"\t"+"Items Per Page is:"+"\t"+ size);
						CustomReporter.reportChild("pass", "Items Per Page is:"+"\t"+ size);
				  	}else{
						System.out.println("Fail"+"\t"+"Items Per Page is:"+"\t"+ size);
						CustomReporter.reportChild("fail", "Items Per Page is:"+"\t"+ size);
					}
			} catch (Exception e) {
				CustomReporter.reportChild("fail", "Unable to verify");
				CustomReporter.addChildInfo("ERROR Occured:"+e);
			}
	          CustomReporter.endChildTest();
		}
		
		public static  void itemsPer60PageValidation() throws InterruptedException{
			CustomReporter.startChild("Items Per-Page 60 Validation", "Validating items per-page 60 or Not in Search Rersult Page");
			  try {
				  SDPExtended.ClickOnItemsPerPage(60);
				  int size;
				  Thread.sleep(3000);
				  size=SDPExtended.NoOfItemsDisplayed();
				  if(size==60){
						System.out.println("Pass"+"\t"+"Items Per Page is:"+"\t"+ size);
						CustomReporter.reportChild("pass", "Items Per Page is:"+"\t"+ size);
				  	}else{
						System.out.println("Fail"+"\t"+"Items Per Page is:"+"\t"+ size);
						CustomReporter.reportChild("fail", "Items Per Page is:"+"\t"+ size);
					}
			} catch (Exception e) {
				CustomReporter.reportChild("fail", "Unable to verify");
				CustomReporter.addChildInfo("ERROR Occured:"+e);
			}
	          CustomReporter.endChildTest();
		}
		
		public static void itemsPer90PageValidation() throws InterruptedException{
			CustomReporter.startChild("Items Per-Page 90 Validation", "Validating items per-page 90 or Not in Search Rersult Page");
			  try {
				  SDPExtended.ClickOnItemsPerPage(90);
				  int size;
				  Thread.sleep(3000);
				  size=SDPExtended.NoOfItemsDisplayed();
				  if(size==90){
						System.out.println("Pass"+"\t"+"Items Per Page is:"+"\t"+ size);
						CustomReporter.reportChild("pass", "Items Per Page is:"+"\t"+ size);
				  	}else{
						System.out.println("Fail"+"\t"+"Items Per Page is:"+"\t"+ size);
						CustomReporter.reportChild("fail", "Items Per Page is:"+"\t"+ size);
					}
			} catch (Exception e) {
				CustomReporter.reportChild("fail", "Unable to verify");
				CustomReporter.addChildInfo("ERROR Occured:"+e);
			}
	          CustomReporter.endChildTest();
		}
	
		public static void breadcrumbsVerification(){
			
		}
		
		@FindBy(xpath=SDPExtendedConstants.SRPbreadcrumbs)
		static WebElement SRPbreadcrumbs;
		
		
		public static void messageDisplayinSRP(){
			CustomReporter.startChild("Message Displayed in SRP", "");
			try {
				GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, SRPbreadcrumbs, "");
				System.out.println("Result:"+GenericWebDriverFunctions.getText);
				if(GenericWebDriverFunctions.getText.contains("Your search for")){
					if(GenericWebDriverFunctions.getText.contains("returned")){
						if(GenericWebDriverFunctions.getText.contains("items")){
							CustomReporter.reportChild("pass", GenericWebDriverFunctions.getText);
						}else{
							CustomReporter.reportChild("fail", "Does not contain 'items'");
						}
					}else{
						CustomReporter.reportChild("fail", "Does not contain 'returned'");
					}
				}else{
					CustomReporter.reportChild("fail", "Does not contain 'Your search for'");	
				}
				
			} catch (Exception e) {
				CustomReporter.reportChild("fail", "Error:"+e);
			}
			CustomReporter.endChildTest();
		}
		
	
	public static void 	additemsfromQV() throws InterruptedException{

		excel = new ExcelLibrary(System.getProperty("user.dir") + "\\Bealls_Execution_Excel.xlsx");
		 
	 
		CustomReporter.startChild("Items purchased are ", "");
		 
		ItemsInfo obj= new ItemsInfo();
		obj.setInfo();
		List<ItemsInfo> li=obj.getAllItems();
		
		
		for (int dataCounter = 0; dataCounter < li.size(); dataCounter++) {
			 itemCounter =dataCounter;
			
			  item = (ItemsInfo) li.get(dataCounter);
		 
		 
			String keyWord = item.getBrand();
		 
			String size =  item.getSize();
			String colorTxt =item.getColor() ;
		 
			String quantity=item.getQuantity();
			 
		  boolean wishList = item.getWishList();
 
			CustomReporter.category = keyWord;
			CustomReporter.subCategory = keyWord;
			
			GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, searchBox, keyWord);
			GenericWebDriverFunctions.performAction(StringConstants.CLICK, searchButton, keyWord);
			Thread.sleep(3000);
			WebElement lowtohigh=GenericWebDriverFunctions.driver.findElement(By.xpath("//div[@class='page-control']//select"));
			GenericWebDriverFunctions.performAction(StringConstants.SELECTBYVT, lowtohigh, "Price: Low to High");

			Thread.sleep(3000);
			//if (dataCounter % 2 == 0 ) {} 

			//*******Add items from Quick view part *********//
				if (keyWord.contains("card") || keyWord.contains("gift card")) {
					//===gift Card
					SearchDisplayPage.selectGiftCard();
					Thread.sleep(2000);
					GenericWebDriverFunctions.performAction(StringConstants.CLICK,
							GenericWebDriverFunctions.findElementByLinkText(size), "");
					Thread.sleep(2000);
				 
					ProductDisplayPage.addToCart_PDP();
	
				} else {
					
					//Normal Execution
				SearchDisplayPage.selectQuickViewOnePage();    ///Opening The Quick view

				 
			if(GenericWebDriverFunctions.findElementsByXpath(SearchDisplayConstants.NOINVENTORY)>0 && dataCounter== (li.size()-1) && !noInventoryQV.getText().isEmpty())
			{///If no inventory no of items is also equal
				 
					SearchDisplayPage.item.setColor("Low inventory");
					SearchDisplayPage.item.setPrice("Low inventory");
					SearchDisplayPage.item.setQuantity("Low inventory");
					SearchDisplayPage.item.setSize("Low inventory");
					GenericWebDriverFunctions.performAction(StringConstants.CLICK, qvClose, "");

				 continue;
			}
			
			else
			if(GenericWebDriverFunctions.findElementsByXpath(SearchDisplayConstants.NOINVENTORY)>0 && dataCounter< (li.size()-1) && !noInventoryQV.getText().isEmpty() )
			{
				SearchDisplayPage.item.setColor("Low inventory");
				SearchDisplayPage.item.setPrice("Low inventory");
				SearchDisplayPage.item.setQuantity("Low inventory");
				SearchDisplayPage.item.setSize("Low inventory");
				GenericWebDriverFunctions.performAction(StringConstants.CLICK, qvClose, "");
				continue;
				
			}
			 
				if(GenericWebDriverFunctions.findElementsByXpath(SearchDisplayConstants.LOWINVENTORY)>0 && !lowInventory.getText().isEmpty())
				{
					System.out.println("inside low inventory");
				 
					GenericWebDriverFunctions.performAction(StringConstants.CLICK, qvClose, "");	
					SearchDisplayPage.item.setColor("Low inventory");
					SearchDisplayPage.item.setPrice("Low inventory");
					SearchDisplayPage.item.setQuantity("Low inventory");
					SearchDisplayPage.item.setSize("Low inventory");
					continue;
				}
				else
				{
					System.out.println("Empty");
					if(wishList)
					{
					GenericWebDriverFunctions.performAction(StringConstants.CLICK, addToWLQV, "");
					continue;
					}
					else
					{
						
					//Normally Adding items by selecting size,color,quantity
					SearchDisplayPage.addToCart_QVOnepage(colorTxt, size, quantity);
					}
				}
			item.setOrderedFrom("Quick View ");
			}

		

			item.setTestCase(CustomReporter.currentTestCase);
			
			CustomReporter.addChildInfo(item.toString());
			Thread.sleep(2000);
			if (dataCounter != (li.size() - 1))
				ProductDisplayPage.continueShoppingPDP(); 
	 
			 
			
		}

		CustomReporter.endChildTest();
	
		}
}
