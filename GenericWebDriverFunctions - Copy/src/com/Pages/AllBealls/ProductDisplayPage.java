package com.Pages.AllBealls;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.GenericFunctions.WebDriver.GenericWebDriverFunctions;
import com.classs.usage.TestClass;
import com.constants.string.PDPConstants;
import com.constants.string.StringConstants;
import com.exceptions.custom.CustomException;
import com.reports.beallsCustom.CustomReporter;

public class ProductDisplayPage {

	@FindBy(xpath=StringConstants.PRODPRICE)
	public static WebElement productPrice;
	
	@FindBy(id=StringConstants.PDPADDTOCART)
	public static WebElement addToCart;
	
	@FindBy(xpath=StringConstants._1X)
	public static WebElement oneX;
	
	
	@FindBy(xpath=StringConstants._8M)
	public static WebElement eightM;
	
	@FindBy(xpath=StringConstants.SMALL)
	public static WebElement small;
	
	@FindBy(xpath=StringConstants.LARGE)
	public static WebElement large;
	
	
	@FindBy(id=StringConstants.CARTPAGEPRICE)
	public static WebElement priceCartPage;
	
	@FindBy(xpath=StringConstants.ADDTOCARTCLOSE)
	public static WebElement AddToCartClose;
	
	@FindBy(xpath=StringConstants.CHECKOUT)
	public static WebElement checkOut;
	
	@FindBy(xpath=PDPConstants.CSHOPPING)
	public static WebElement continueShop;
	
	@FindAll({@FindBy(xpath=PDPConstants.SIZES)})
	public static List <WebElement> sizes;
	
	@FindAll({@FindBy(xpath=PDPConstants.COLORS)})
	public static List <WebElement> colors;
	
	@FindBy(xpath=PDPConstants.ATTRIBUTES)
	public static WebElement productAttributes;
	
	@FindBy(xpath=PDPConstants.QUANTITYDROPDOWN)
	public static WebElement quantity;
	public static String price;
	
	@FindBy(xpath=PDPConstants.SELECTEDCOLOR)
	public static WebElement selectColor;
	
	@FindBy(xpath=PDPConstants.ITEMNAME)
	public static WebElement itemName;
	
	@FindBy(xpath=PDPConstants.ITEMPRICE)
	public static WebElement itemPrice;
	
	@FindAll({@FindBy(xpath=PDPConstants.DISABLEDATTRIBS)})
	public static List<WebElement> disabledAttribs;
	
	
	


	public ProductDisplayPage() {
		PageFactory.initElements(GenericWebDriverFunctions.driver, this);
	 
	}
	
	public static void getPDPPrice()
	{
		GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, productPrice, "");
		ProductDisplayPage.price=GenericWebDriverFunctions.getText;
		CustomReporter.startChild("Price in PDP", "");
		CustomReporter.addChildInfo("The Price in PDP is "+ProductDisplayPage.price);
		CustomReporter.endChildTest();
		//CustomReporter.childTitle.add(TestClass.excel.getCellData("TestData",6 , TestClass.cellNo)+" in PDP");
		//CustomReporter.childInfoDesc.add("The "+TestClass.excel.getCellData("TestData",6 , TestClass.cellNo)+" in PDP is "+ProductDisplayPage.price);
	}
	
	public static void continueShoppingPDP()
	{
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, continueShop, "");
	}
	public static void addToCart_PDP () throws NoSuchElementException
	{
		
//		try
//		{
//		GenericWebDriverFunctions.isDisplayed(addToCart);
//		 
			GenericWebDriverFunctions.performAction(StringConstants.CLICK, addToCart, "");	
		 
		
		 
		
//		}
//		catch(NoSuchElementException e)
//		{
//			PopUpPage.closePopUp();
//			addToCart_PDP();
//		}
	 
	 
	}
	
	public static boolean isQuantityDisabled()
	{
		boolean flag;
		try
		{
			quantity.getAttribute("disabled");
			flag = true;
			
		}
		catch(NullPointerException ex)
		{
			flag = false;
		}
		return flag;
	}
	
	public static void selectColor(String colorTxt)
	{ 
		
		String colorText =null;
		
		if(colors.size()<=1 || productAttributes.getText().isEmpty() )
		{
			
			 GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, selectColor, "");
			 
			SearchDisplayPage.item.setColor(GenericWebDriverFunctions.getText);
			System.out.println("Selected color 1st if "+GenericWebDriverFunctions.getText);
		return;	
		}
		else
		{
		for(int i=0;i<colors.size();i++)
		{
			
			colorText = colors.get(i).getAttribute("title");
			
			if(colorText.contains(colorTxt))
			{
				String color = colors.get(i).getAttribute("id");
				GenericWebDriverFunctions.performAction(StringConstants.CLICK, colors.get(i), "");
				SearchDisplayPage.item.setColor(color);
				System.out.println("Selected color for loop"+color);
				return;
			}
			
		}
		
		}
		try
		{
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, colors.get(0), "");
		}
		catch(IndexOutOfBoundsException  ex)
		{
			SearchDisplayPage.item.setColor(selectColor.getText());
			System.out.println("Selected color exce"+selectColor.getText());
			return;
		}
		
		
		
	}
	
	public static void selectQuantity(String quantity)
	{
		
		GenericWebDriverFunctions.performAction(StringConstants.SELECTVALUE,
				ProductDisplayPage.quantity, quantity);
		Select qty = new Select(ProductDisplayPage.quantity);
		     SearchDisplayPage.item.setQuantity(qty.getFirstSelectedOption().getText());
		     
		     SearchDisplayPage.item.setName(itemName.getText());
		     SearchDisplayPage.item.setPrice(itemPrice.getText());
		     
	}
	
	public static void checkOutPDP()
	{
	 
		if(checkOut.isDisplayed())
		{
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, checkOut, "");
		}
		else
		{
			 
			ForHomePage.selectMyBag();
			ForHomePage.checkOutHP();
		}
		OrderItemDisplayPage.validateProductSubTotalBeforeLogin();
	}
	public static void selectSize()
	{
		WebElement size;
		try
		{
		size=   sizes.get(0);
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, size, "");
		SearchDisplayPage.item.setSize(size.getText());
		}
		catch(IllegalArgumentException ex)
		{
			System.out.println("The item doesn't have proper Size (attribute)");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	public static void selectSizeV2()
	{
		 
		
		WebElement size;
		if(sizes.size()==1)
		{
			if(sizes.get(0).getAttribute("title").contains("One Size") && !(sizes.get(0).getAttribute("title").contains("not available")))
			{
				size= sizes.get(0);
				SearchDisplayPage.item.setSize(size.getText());
				return;
			}
			else
			{
				System.out.println("Items not available in inventory");
			}
			 
		}
		try
		{
			int counter =0;
		size=   sizes.get(counter);
		
		do
			{
			 System.out.println(counter);
			 size= sizes.get(counter);
			 counter++;
			}while(size.getAttribute("title").contains("not available"));
			GenericWebDriverFunctions.performAction(StringConstants.CLICK, size, "");
			SearchDisplayPage.item.setSize(size.getText());
		}
		catch(IllegalArgumentException | IndexOutOfBoundsException ex)
		{
		   
			System.out.println("The item doesn't have proper Size (attribute)");
			return;
		}
		
	 
		
		
	}
//	public static void selectSize(String size) throws InterruptedException
//	{
//		Thread.sleep(3000);
//	   
//		 
//		WebElement size;
////		if(sizes.size()==1)
////		{
////			if(sizes.get(0).getAttribute("title").contains("One Size") && !(sizes.get(0).getAttribute("title").contains("not available")))
////			{
////				size= sizes.get(0);
////				return;
////			}
////			else
////			{
////				System.out.println("Items not available in inventory");
////			}
////			 
////		}
//		
//		try
//		{
//		size=   sizes.get(r.nextInt((sizes.size())));
//		GenericWebDriverFunctions.performAction(StringConstants.CLICK, size, "");
//		}
//		catch(IllegalArgumentException ex)
//		{
//			System.out.println("The item doesn't have proper Size (attribute)");
//		}
//		catch(Exception e)
//		{
//			System.out.println(e.getMessage());
//		}
//	}
	
	public static void selectRandomSize() throws InterruptedException
	{
//		Thread.sleep(3000);
		Random r= new Random();
		System.out.println(sizes.size());
		WebElement size;
		if(sizes.size()==1)
		{
			if(sizes.get(0).getAttribute("title").contains("One Size") && !(sizes.get(0).getAttribute("title").contains("not available")))
			{
				size= sizes.get(0);
				return;
			}
			else
			{
				System.out.println("Items not available in inventory");
			}
			 
		}
		
		try
		{
		size=   sizes.get(r.nextInt((sizes.size())));
		
		do
			{
			int random = r.nextInt((sizes.size()));
			 size= sizes.get(random);
			}while(size.getAttribute("title").contains("not available"));
			GenericWebDriverFunctions.performAction(StringConstants.CLICK, size, "");
		}
		catch(IllegalArgumentException ex)
		{
			System.out.println("The item doesn't have proper Size (attribute)");
		}
			 
	}
	
	
	
	
	public static void selectSize(String sheetName,int rowNum,int cellNo) throws NoSuchElementException
	{
		String size =(String) TestClass.excel.getCellData(sheetName,rowNum, cellNo);
 
//		try
//		{
//		GenericWebDriverFunctions.isDisplayed(GenericWebDriverFunctions.getElementByLinkText(size));
//		
//		GenericWebDriverFunctions.scrollToElement(GenericWebDriverFunctions.getElementByLinkText(size));
		switch(size.toLowerCase())
		{
		
		case "1x":
		GenericWebDriverFunctions.performAction(StringConstants.CLICK, oneX, "");
		break;
		
		case "small":
			GenericWebDriverFunctions.performAction(StringConstants.CLICK, small, "");
			break;
			
		case "8m":
		 
			
			GenericWebDriverFunctions.performAction(StringConstants.CLICK, eightM, "");
		 
			break;
			default:
				try
				{
					throw new CustomException("Invalid size");
				}
				catch (CustomException e) {
					e.printStackTrace();
				}
		}
		
//		}
//		catch(NoSuchElementException e)
//		{
//		PopUpPage.closePopUp();
//		selectSize();
//		}
		 
	}
	
//	public static void getPriceCartPage()
//	{
//		GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, priceCartPage, "");
//		ProductDisplayPage.priceCP=GenericWebDriverFunctions.getText;
//		
//		CustomReporter.startChild("Price in  in CP", "");
//		CustomReporter.addChildInfo("The Price in CP is "+ProductDisplayPage.priceCP);
//		CustomReporter.endChildTest();
//		//CustomReporter.childTitle.add(TestClass.excel.getCellData("TestData",6 , TestClass.cellNo)+" in QVP");
//		//CustomReporter.childInfoDesc.add("The "+TestClass.excel.getCellData("TestData",6 , TestClass.cellNo) +" in CP is "+ProductDisplayPage.priceCP);
//		GenericWebDriverFunctions.performAction(StringConstants.CLICK, AddToCartClose, "");
//	}
	
	

}
