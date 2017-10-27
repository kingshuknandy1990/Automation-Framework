package com.Pages.AllBealls;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.GenericFunctions.WebDriver.GenericFunctionsExtra;
import com.GenericFunctions.WebDriver.GenericWebDriverFunctions;
import com.bealls.pojo.ItemsInfo;
import com.classs.usage.TestClass;
import com.constants.string.PDPConstants;
import com.constants.string.SearchDisplayConstants;
import com.constants.string.StringConstants;
import com.excellibrary.bealls.ExcelLibrary;
import com.reports.beallsCustom.CustomReporter;

public class SearchDisplayPage {

	public static String price;
	public static String qvPrice;
	public static String discount;
	public static String searchString;
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
	
	@FindBy(xpath=SearchDisplayConstants.errorfeild)
	public static List <WebElement> errorfeild;
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
	

	public SearchDisplayPage() {
		PageFactory.initElements(GenericWebDriverFunctions.driver, this);
	}

	public static void search() {
		// String keyWord = (String) TestClass.excel.getCellData("TestData",4 ,
		// TestClass.cellNo);
		//
		// CustomReporter.category=keyWord;
		// CustomReporter.subCategory=keyWord;

		GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, searchBox, searchString);
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, searchButton, searchString);

	}

	public static void getSDPPrice() {

		GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, shirtPrice, "");
		SearchDisplayPage.price = GenericWebDriverFunctions.getText;
		CustomReporter.startChild("Price in SRP", "");
		// CustomReporter.childTitle.add(TestClass.excel.getCellData("TestData",6
		// , TestClass.cellNo)+" in SRP");
		CustomReporter.addChildInfo("The price in SRP is " + SearchDisplayPage.price);
		CustomReporter.endChildTest();
		// CustomReporter.childInfoDesc.add("The price in SRP is
		// "+SearchDisplayPage.price);
	}

	public static void getAllPageInfo() {
		// GenericWebDriverFunctions.performAction(StringConstants.GETTEXT,
		// shirtPrice, "");
	}

	public static void selectProduct() {
		int item = r.nextInt((selectProduct.size()));
//		String itemName = itemsName.get(item).getText();
//		String price = itemsPrice.get(item).getText();
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, selectProduct.get(item), "");
//		SearchDisplayPage.item.setName(itemName);
//		SearchDisplayPage.item.setPrice(price);
	}

	public static void selectProductQV() {
		// int item = r.nextInt((quickViews.size()));
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, quickViewItem, "");
	}

	public static void selectGiftCard() {
		Random r = new Random();
		WebElement giftCard = GIFTCARD.get(r.nextInt((GIFTCARD.size())));
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, giftCard, "");

	}

	public static void hoverQuickView() {
		int item = r.nextInt((quickViews.size()));
		quickViewItem = quickViews.get(item);
		GenericWebDriverFunctions.performAction(StringConstants.MOUSEOVER, quickViewItem, "");
	}

	public static void selectQuickView() throws InterruptedException {
		int item = r.nextInt((selectProduct.size()));

		quickViewItem = selectProduct.get(item);
		GenericWebDriverFunctions.performAction(StringConstants.MOUSEOVER, quickViewItem, "");
		Thread.sleep(600);
		quickViewItem = quickViews.get(item);
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, quickViewItem, "");
		SearchDisplayPage.item.setName(itemsName.get(item).getText());
	}
	
	public static void selectQuickViewOnePage() throws InterruptedException {
		int itemRandom = r.nextInt(selectProduct.size());  //input Argument:Passing No of items displayed in the page
		item=new ItemsInfo();
		quickViewItem = selectProduct.get(itemRandom);
		GenericWebDriverFunctions.performAction(StringConstants.MOUSEOVER, quickViewItem, "");
		Thread.sleep(600);
		quickViewItem = quickViews.get(itemRandom);   // quickViewItem is the item to be added
		System.out.println("Name of Item Selected    :"+itemsName.get(itemRandom).getText());
		SearchDisplayPage.item.setName(itemsName.get(itemRandom).getText());
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, quickViewItem, "");
		//SearchDisplayPage.item.setName(itemsName.get(item).getText());
		/*try {
			SearchDisplayPage.item.setName(itemsName.get(item).getText());
		} catch (Exception e) {
			System.out.println("Exception Occured while  setting the Name:"+e);
			//SearchDisplayPage.item.setName("Unable to get proper name of product");
		}*/
	}
 
	public static void closeQuickView() {
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, quickViewClose, "");
	}

	public static void getQVPrice() {
		GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, QVPrice, "");
		SearchDisplayPage.qvPrice = GenericWebDriverFunctions.getText;
		CustomReporter.startChild("Price in QVP", "");
		CustomReporter.addChildInfo("The price in SRP is " + SearchDisplayPage.qvPrice);
		CustomReporter.endChildTest();

	}

	public static void hoverOnProd() {
		// To be modified...
		// GenericWebDriverFunctions.performAction(StringConstants.MOUSEOVER,
		// selectProduct, "");
	}

	public static List<String> getBadgeNames() {
		List<String> badgeNames = new ArrayList<String>();
		excel = new ExcelLibrary(System.getProperty("user.dir") + "\\Bealls_Execution_Excel.xlsx");
		int colCount = excel.getColumnCount("TestData", 16);

		for (int dataCounter = 1; dataCounter < colCount; dataCounter++) {
			String keyWord = (String) TestClass.excel.getCellData("TestData", 16, dataCounter);
			badgeNames.add(keyWord);
		}
		return badgeNames;
	}

	public static List<String> getSearchKeyWords() {
		List<String> keyWords = new ArrayList<String>();
		excel = new ExcelLibrary(System.getProperty("user.dir") + "\\Bealls_Execution_Excel.xlsx");
		int colCount = excel.getColumnCount("TestData", 17);

		for (int dataCounter = 1; dataCounter < colCount; dataCounter++) {
			String keyWord = (String) TestClass.excel.getCellData("TestData", 17, dataCounter);
			keyWords.add(keyWord);
		}
		return keyWords;
	}

	public static void selectColor(String colorTxt) {

	}

	public static List<String> getSynonymKeyWords() {
		List<String> keyWords = new ArrayList<String>();
		excel = new ExcelLibrary(System.getProperty("user.dir") + "\\Bealls_Execution_Excel.xlsx");
		int colCount = excel.getColumnCount("TestData", 18);

		for (int dataCounter = 1; dataCounter < colCount; dataCounter++) {
			String keyWord = (String) TestClass.excel.getCellData("TestData", 18, dataCounter);
			keyWords.add(keyWord);
		}
		return keyWords;
	}

	public static void searchAndValidateByBadgeNames() {
		List<String> badgeNames = getBadgeNames();
		System.out.println(badgeNames.size());
		for (int counter = 0; counter < badgeNames.size(); counter++) {
			searchString = badgeNames.get(counter);

			search();
			validateSearchResult();
			System.out.println(searchString);
		}

	}

	public static void searchAndValidateBySearchKeyWord() {
		List<String> keyWords = getSearchKeyWords();

		for (int counter = 0; counter < keyWords.size(); counter++) {
			searchString = keyWords.get(counter);

			search();
			validateSearchResult();
			System.out.println(searchString);
		}

	}

	public static void searchAndValidateBySynonymKeyWord() {
		List<String> keyWords = getSynonymKeyWords();

		for (int counter = 0; counter < keyWords.size(); counter++) {
			searchString = keyWords.get(counter);

			search();
			validateSearchResult();
			System.out.println(searchString);
		}

	}

	public static void validateSearchResult() {
		String summaryText = "";
		int itemCount = 0;
		if (GenericWebDriverFunctions.findElementsByXpath(SearchDisplayConstants.RESULTSUMMARY) > 0) {
			GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, resultSummary, "");
			summaryText = GenericWebDriverFunctions.getText;
			StringBuilder s = new StringBuilder(summaryText);
			s.reverse();
			String ah[] = s.toString().split(" ");

			if (ah.length > 0)
				itemCount = Integer.parseInt(ah[1]);
		}

		CustomReporter.startChild("Search string is ", searchString);

		if (itemCount > 0 || GenericWebDriverFunctions.findElementsByXpath(SearchDisplayConstants.ESPOTCONTENT) > 0) {
			CustomReporter.reportChild("pass", "Items are found for the search string");
			CustomReporter.addChildInfo(summaryText);
		} else {
			CustomReporter.reportChild("FAIL", "Items are not found for the search string");
			CustomReporter.addChildInfo(summaryText);
		}

		CustomReporter.endChildTest();

	}

	public static void addItemsIntoCart() throws InterruptedException {
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
			if (dataCounter % 2 == 0 ) {

				if (keyWord.contains("card") || keyWord.contains("gift card"))
					SearchDisplayPage.selectGiftCard();
				else
					SearchDisplayPage.selectProduct();
				
				  //To check whether the item selected is available in inventory
				GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, lowInventory, "");
				String low = GenericWebDriverFunctions.getText;
				
			 
				 
				if(GenericWebDriverFunctions.findElementsByXpath(SearchDisplayConstants.NOINVENTORY)>0 &&!noInventoryQV.getText().isEmpty() )
				{
					SearchDisplayPage.item.setColor("Low inventory");
					SearchDisplayPage.item.setPrice("Low inventory");
					SearchDisplayPage.item.setQuantity("Low inventory");
					SearchDisplayPage.item.setSize("Low inventory");
			 
					continue;
					
				}
				 
				
					if(GenericWebDriverFunctions.findElementsByXpath(SearchDisplayConstants.LOWINVENTORY)>0 && low.isEmpty() )
					{

				ProductDisplayPage.selectColor(colorTxt);
				// Select random size
				// ProductDisplayPage.selectRandomSize();
				// ProductDisplayPage.selectSize("TestData",5,dataCounter);
				try {
					if (!ProductDisplayPage.productAttributes.getText().isEmpty())
//						GenericWebDriverFunctions.performAction(StringConstants.CLICK,
//								GenericWebDriverFunctions.findElementByLinkText(size), "");
						ProductDisplayPage.selectSizeV2();
				} catch (NoSuchElementException | TimeoutException e) {
					ProductDisplayPage.selectSizeV2();
				}

				ProductDisplayPage.selectQuantity(quantity);

				Thread.sleep(2000);
				if(wishList)
				{
					GenericWebDriverFunctions.performAction(StringConstants.CLICK, addToWishlist, "");
					continue;
				}
				else
				{
				ProductDisplayPage.addToCart_PDP();
				}
				
					}
					else
					{
						SearchDisplayPage.item.setColor("Low inventory");
						SearchDisplayPage.item.setPrice("Low inventory");
						SearchDisplayPage.item.setQuantity("Low inventory");
						SearchDisplayPage.item.setSize("Low inventory");
					}
					item.setOrderedFrom("Product display page");
					
			} else {
				//*******Add items from Quick view part *********//
				if (keyWord.contains("card") || keyWord.contains("gift card")) {
					SearchDisplayPage.selectGiftCard();
					Thread.sleep(2000);
					GenericWebDriverFunctions.performAction(StringConstants.CLICK,
							GenericWebDriverFunctions.findElementByLinkText(size), "");
					Thread.sleep(2000);
				 
					ProductDisplayPage.addToCart_PDP();

				} else {
					SearchDisplayPage.selectQuickView();
 
					 
				if(GenericWebDriverFunctions.findElementsByXpath(SearchDisplayConstants.NOINVENTORY)>0 && dataCounter== (li.size()-1) && !noInventoryQV.getText().isEmpty())
				{
					 
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
						SearchDisplayPage.addToCart_QV(colorTxt, size, quantity);
						}
					}
				item.setOrderedFrom("Quick View ");
				}

			}

			item.setTestCase(CustomReporter.currentTestCase);
			
			CustomReporter.addChildInfo(item.toString());
			Thread.sleep(2000);
			if (dataCounter != (li.size() - 1))
				ProductDisplayPage.continueShoppingPDP(); 
	 
			 
			
		}

		CustomReporter.endChildTest();
	}

	// Function to add multiple items into cart
//	public static void addItemsToCart() throws InterruptedException {
//		excel = new ExcelLibrary(System.getProperty("user.dir") + "\\Bealls_Execution_Excel.xlsx");
//		int colCount = excel.getColumnCount("TestData", 4);
//		CustomReporter.startChild("Items purchased are ", "");
//		for (int dataCounter = 1; dataCounter < colCount; dataCounter++) {
//
//			String keyWord = (String) TestClass.excel.getCellData("TestData", 4, dataCounter);
//
//			CustomReporter.addChildInfo(keyWord);
//			CustomReporter.category = keyWord;
//			CustomReporter.subCategory = keyWord;
//
//			GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, searchBox, keyWord);
//			GenericWebDriverFunctions.performAction(StringConstants.CLICK, searchButton, keyWord);
//
//			Thread.sleep(2000);
//			if (keyWord.contains("card") || keyWord.contains("gift card"))
//				SearchDisplayPage.selectGiftCard();
//			else
//				SearchDisplayPage.selectProduct();
//
//			Thread.sleep(2000);
//			ProductDisplayPage.selectRandomSize();
//			// ProductDisplayPage.selectSize("TestData",5,dataCounter);
//
//			Thread.sleep(2000);
//			ProductDisplayPage.addToCart_PDP();
//
//			Thread.sleep(2000);
//			if (dataCounter != (colCount - 1))
//				ProductDisplayPage.continueShoppingPDP();
//
//		}
//
//		CustomReporter.endChildTest();
//
//	}

	public static void ValidateDiscountsSRP() {
		// Thread.sleep(1000);
		String OfferPrice = null;
		String ListPrice = null;
		String DiscountPercent = null;

		try {

			if (GenericWebDriverFunctions.isDisplayed(SRPPrice)) {
				GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, SRPPrice, "");
				String offerprice = " " + GenericWebDriverFunctions.getText;
				String OfferPrice1[] = offerprice.split("\\$");
				OfferPrice = OfferPrice1[1];
				// System.out.println("Offer price in SRP");
				// System.out.println("OfferPrice:$"+OfferPrice);
			} else {
				// System.out.println("Offer Price is not Displayed");
			}

			if (GenericWebDriverFunctions.isDisplayed(SRPPriceSave)) {
				GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, SRPPriceSave, "");
				if (GenericWebDriverFunctions.getText.equalsIgnoreCase("")) {
					CustomReporter.startChild("Discount in SRP", "");
					CustomReporter.reportChild("Pass", "No discount applicable");
					CustomReporter.endChildTest();

				} else {

					// Write code here
					if (GenericWebDriverFunctions.isDisplayed(SRPPriceReg)) {
						GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, SRPPriceReg, "");
						String st = GenericWebDriverFunctions.getText;
						String starr[] = st.split("\\$");
						ListPrice = starr[1];
						// System.out.println("Offer price in SRP");
						// System.out.println("List Price:$"+ListPrice);
					} else {
						// System.out.println("List Price is not Displayed");
					}

					if (GenericWebDriverFunctions.isDisplayed(SRPPriceSave)) {
						GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, SRPPriceSave, "");
						String st2[] = GenericWebDriverFunctions.getText.split("\\:");
						String Save1[] = (st2[1] + " ").split("\\%");
						DiscountPercent = Save1[0];
						SearchDisplayPage.discount = DiscountPercent;
						// System.out.println("Save :"+DiscountPercent+"%");
					} else {
						// System.out.println("Save % is not Displayed");
					}

					Double OfferPriceFormattet = Double.valueOf(OfferPrice);
					double listPriceFormattet = Double.valueOf(ListPrice);
					double DiscountPercentFormattet = Double.valueOf(DiscountPercent);

					Double calculatedOfferPriceFormattet = listPriceFormattet * (1 - (DiscountPercentFormattet / 100));
					int OfferPriceint = OfferPriceFormattet.intValue();
					int result = calculatedOfferPriceFormattet.intValue();
					// System.out.println("//////"+OfferPriceint+"//////"+result);
					if (OfferPriceint == result) {
						CustomReporter.startChild("Discount in SRP", "");
						CustomReporter.reportChild("pass",
								"Discount price for " + CustomReporter.category + " is proper");
						CustomReporter.addChildInfo("The discount price in SRP is " + SearchDisplayPage.discount);
						CustomReporter.endChildTest();

					} else {
						CustomReporter.startChild("Discount in SRP", "");
						CustomReporter.reportChild("FAIL",
								"Discount price for " + CustomReporter.category + " is not proper");
						CustomReporter.addChildInfo("The discount price in SRP is " + SearchDisplayPage.discount);
						CustomReporter.endChildTest();
					}
				}
			} else {

			}
			// System.out.println("---------------------------");
		} catch (TimeoutException ex) {
			if (PopUpPage.popUp.isDisplayed()) {
				PopUpPage.closePopUp();
				ValidateDiscountsSRP();
			}
		}

	}

	public static void ValidateDiscountsInQV() {

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement discount = GenericWebDriverFunctions.findElementsBy(StringConstants.DISCOUNT);
		WebElement oldPrice = GenericWebDriverFunctions.findElementsBy(StringConstants.OLDPRICE);
		WebElement discPrice = GenericWebDriverFunctions.findElementsBy(StringConstants.DISCOUNTPRICE);
		double temp, dis, oldPrize, offpri, discountp;

		if (discount != null && oldPrice != null) {
			GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, discount, "");
			String discountS = GenericWebDriverFunctions.getText;
			GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, oldPrice, "");
			String olprice = GenericWebDriverFunctions.getText;
			GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, discPrice, "");
			String discountPrice = GenericWebDriverFunctions.getText;

			StringBuilder disc = new StringBuilder(discountS.split(":")[1].trim());
			disc.deleteCharAt(disc.length() - 1);
			dis = Double.parseDouble(disc.toString());

			StringBuilder oldp = new StringBuilder(olprice.split("\\ ")[1]);
			oldp.deleteCharAt(0);

			oldPrize = Double.parseDouble(oldp.toString());

			StringBuilder offP = new StringBuilder(discountPrice);
			offP.deleteCharAt(0);
			offpri = Double.parseDouble(offP.toString());
			System.out.println(offP);
			temp = offpri;
			discountp = (dis * oldPrize) / 100;
			if (temp == (oldPrize - discountp)) {
				// System.out.println("Discount properly applied");
				CustomReporter.startChild("Discount in QVP", "");
				CustomReporter.reportChild("pass", "Discount price for " + CustomReporter.category + " is proper");
				CustomReporter.addChildInfo("The discount price in QVP is " + SearchDisplayPage.discount);
				CustomReporter.endChildTest();
			} else {
				CustomReporter.startChild("Discount in QVP", "");
				CustomReporter.reportChild("FAIL", "Discount price for " + CustomReporter.category + " is not proper");
				CustomReporter.addChildInfo("The discount price in QVP is " + SearchDisplayPage.discount);
				CustomReporter.endChildTest();
				// System.out.println("Discount not proper");
			}

		} else {
			CustomReporter.startChild("Discount in QVP", "");
			CustomReporter.reportChild("Pass", "No discount applicable");
			CustomReporter.endChildTest();
			// System.out.println("No Discount applicable");
		}

	}

	public static void addToCart_QV(String color, String size, String quantity) {
 
		
		if(GenericWebDriverFunctions.findElementsByXpath(SearchDisplayConstants.COLORDROPDOWN)>0 && colorDropDown.isDisplayed())
		{
		
		Select colorDrop= new Select(colorDropDown);
		
		if(colorDrop.getOptions().size()>1)
		{
			GenericWebDriverFunctions.performAction(StringConstants.SELECTVALUE, colorDropDown, color);
			SearchDisplayPage.item.setColor(colorDrop.getFirstSelectedOption().getText());
			System.out.println("Selected color QV >1"+SearchDisplayPage.item.getColor());
		}
		else
		{
		 
			GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, qvSelectedColor, "");
			
			SearchDisplayPage.item.setColor(GenericWebDriverFunctions.getText);
			System.out.println("Selected color QV"+SearchDisplayPage.item.getColor());
		}
		}
		
		
		if(GenericWebDriverFunctions.findElementsByXpath(StringConstants.SizeDropDown)>0   && SizeDropDown.isDisplayed())
		{
		GenericWebDriverFunctions.performAction(StringConstants.SELECTVALUE, SizeDropDown, size);
		 
		Select sizeDrop = new Select(SizeDropDown);
		SearchDisplayPage.item.setSize(sizeDrop.getFirstSelectedOption().getText());
		SearchDisplayPage.item.setPrice(QVPrice.getText());
		}
		
		if(GenericWebDriverFunctions.findElementsByXpath(PDPConstants.QUANTITYDROPDOWN)>0 && ProductDisplayPage.quantity.isDisplayed())
		
		{
		GenericWebDriverFunctions.performAction(StringConstants.SELECTVALUE, ProductDisplayPage.quantity, quantity);
		Select quantityDrop = new Select(ProductDisplayPage.quantity);
		SearchDisplayPage.item.setQuantity(quantityDrop.getFirstSelectedOption().getText());
		}
		
		if(AddToCartButton.isDisplayed())
		{
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, AddToCartButton, "");
		}
		// GenericWebDriverFunctions.performAction(StringConstants.CLICK,
		// CheckOutButton, "");
	}
	
	public static void addToCart_QVOnepage(String color, String size, String quantity) throws InterruptedException {

		 
		//try {

			if(GenericWebDriverFunctions.findElementsByXpath(SearchDisplayConstants.COLORDROPDOWN)>0 && colorDropDown.isDisplayed())
			{
			System.out.println("Color DropDown is displayed--Selecting color");
			Select colorDrop= new Select(colorDropDown);
			
			if(colorDrop.getOptions().size()>1)
			{    ///If color options are avaliable
				GenericWebDriverFunctions.performAction(StringConstants.SELECTVALUE, colorDropDown, color);
				SearchDisplayPage.item.setColor(colorDrop.getFirstSelectedOption().getText());
				System.out.println("Selected color QV >1"+SearchDisplayPage.item.getColor());
			}
			else
			{
			 
				GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, qvSelectedColor, "");
				
				SearchDisplayPage.item.setColor(GenericWebDriverFunctions.getText);
				System.out.println("Selected color QV"+SearchDisplayPage.item.getColor());
			}
			}
		/*} catch (Exception e) {
			System.out.println("Selecting color:"+e);
		}*/
		
		
		//try {
			if(GenericWebDriverFunctions.findElementsByXpath(StringConstants.SizeDropDown)>0   && SizeDropDown.isDisplayed())
			{
			GenericWebDriverFunctions.performAction(StringConstants.SELECTVALUE, SizeDropDown, size);
			 
			Select sizeDrop = new Select(SizeDropDown);
			SearchDisplayPage.item.setSize(sizeDrop.getFirstSelectedOption().getText());
			SearchDisplayPage.item.setPrice(QVPrice.getText());
			}
		/*} catch (Exception e2) {
			System.out.println("selecting size:"+e2);
		}*/
			//try {
		if(GenericWebDriverFunctions.findElementsByXpath(PDPConstants.QUANTITYDROPDOWN)>0 && ProductDisplayPage.quantity.isDisplayed())
		
		
		
		
			{System.out.println("Quantity Drop down");
			GenericWebDriverFunctions.performAction(StringConstants.SELECTVALUE, ProductDisplayPage.quantity, quantity);
			Select quantityDrop = new Select(ProductDisplayPage.quantity);
			SearchDisplayPage.item.setQuantity(quantityDrop.getFirstSelectedOption().getText());
			}
		/*} catch (Exception e3) {
			System.out.println("Quantity:"+e3);
		}*/
		
		Thread.sleep(2000);
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, AddToCartButton, "");
		if(GenericFunctionsExtra.ElementVisibility(errorfeild)){
			GenericWebDriverFunctions.performAction(StringConstants.CLICK, AddToCartButton, "");
		}
		
		// GenericWebDriverFunctions.performAction(StringConstants.CLICK,
		// CheckOutButton, "");
	
	}

	public static void continueShopping() {
		ProductDisplayPage.continueShoppingPDP();
	}

	public static void checkOut() {
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, CheckOutButton, "");
	}

	public static void selectLowToHigh() {
		GenericWebDriverFunctions.performAction(StringConstants.SELECTVALUE, SearchDisplayPage.LOWTOHIGH,
				"Price: Low to High");
	}

	public static void ValidateDiscountsInPDP() throws InterruptedException {

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement discount = GenericWebDriverFunctions.findElementsBy(StringConstants.DISCOUNT);
		WebElement oldPrice = GenericWebDriverFunctions.findElementsBy(StringConstants.OLDPRICE);
		WebElement discPrice = GenericWebDriverFunctions.findElementsBy(StringConstants.DISCOUNTPRICE);
		double temp, dis, oldPrize, offpri, discountp;

		if (discount != null && oldPrice != null) {
			GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, discount, "");
			String discountS = GenericWebDriverFunctions.getText;
			GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, oldPrice, "");
			String olprice = GenericWebDriverFunctions.getText;
			GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, discPrice, "");
			String discountPrice = GenericWebDriverFunctions.getText;

			StringBuilder disc = new StringBuilder(discountS.split(":")[1].trim());
			disc.deleteCharAt(disc.length() - 1);
			dis = Double.parseDouble(disc.toString());

			StringBuilder oldp = new StringBuilder(olprice.split("\\ ")[1]);
			oldp.deleteCharAt(0);

			oldPrize = Double.parseDouble(oldp.toString());

			StringBuilder offP = new StringBuilder(discountPrice);
			offP.deleteCharAt(0);
			offpri = Double.parseDouble(offP.toString());
			System.out.println(offP);
			temp = offpri;
			discountp = (dis * oldPrize) / 100;
			if (temp == (oldPrize - discountp)) {
				// System.out.println("Discount properly applied");
				CustomReporter.startChild("Discount in PDP", "");
				CustomReporter.reportChild("pass", "Discount price for " + CustomReporter.category + " is proper");
				CustomReporter.addChildInfo("The discount price in PDP is " + SearchDisplayPage.discount);
				CustomReporter.endChildTest();
			} else {
				CustomReporter.startChild("Discount in PDP", "");
				CustomReporter.reportChild("FAIL", "Discount price for " + CustomReporter.category + " is not proper");
				CustomReporter.addChildInfo("The discount price in PDP is " + SearchDisplayPage.discount);
				CustomReporter.endChildTest();
				// System.out.println("Discount not proper");
			}

		} else {
			CustomReporter.startChild("Discount in PDP", "");
			CustomReporter.reportChild("Pass", "No discount applicable");
			CustomReporter.endChildTest();
			// System.out.println("No Discount applicable");
		}

	}

}
