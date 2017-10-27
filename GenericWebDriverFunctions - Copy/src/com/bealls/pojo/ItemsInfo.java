package com.bealls.pojo;

import java.util.ArrayList;
import java.util.List;

import com.classs.usage.TestClass;
import com.excellibrary.bealls.ExcelLibrary;
import com.reports.beallsCustom.CustomReporter;

public class ItemsInfo {
	
	public static List<ItemsInfo> details;
	public String name,size,color,quantity,brand,testCase,price,orderedFrom;
	boolean wishList;
	
	public String getOrderedFrom() {
		return orderedFrom;
	}

	public void setOrderedFrom(String orderedFrom) {
		this.orderedFrom = orderedFrom;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTestCase() {
		return testCase;
	}

	public void setTestCase(String testCase) {
		this.testCase = testCase;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public  void setInfo()
	{
		details  = new ArrayList<ItemsInfo>(); 
		ExcelLibrary excel = new ExcelLibrary(System.getProperty("user.dir") + "\\Bealls_Execution_Excel.xlsx");
		int colCount = excel.getColumnCount("TestData", 4);
	 
		for (int dataCounter = 1; dataCounter < colCount; dataCounter++) {
			String keyWord = (String)excel.getCellData("TestData", 4, dataCounter);
			if(!keyWord.isEmpty())
			{
				ItemsInfo item = new ItemsInfo();
//				item.setName(keyWord);
				item.setBrand(keyWord);
			String size = (String) excel.getCellData("TestData", 5, dataCounter);
			if(size.isEmpty())
			item.setSize("");
			else
			item.setSize(size);
			
			String colorTxt = (String) excel.getCellData("TestData", 6, dataCounter);
			
			if(colorTxt.isEmpty())
			item.setColor("");
			else
			item.setColor(colorTxt);
			
			double qty;
			int qtyi = 0;
			String quantity;
			
			String wishList = (String)  excel.getCellData("TestData", 10, dataCounter);
		 
			if(wishList.equalsIgnoreCase("yes"))
			item.setWishList(true);
			else
			item.setWishList(false);
			
			if ( excel.getCellData("TestData", 7, dataCounter) instanceof Double)
			{
				qty = (double) excel.getCellData("TestData", 7, dataCounter);
				qtyi = (int) qty;
				quantity = String.valueOf(qtyi);
			}
			else
			{
				quantity = (String) excel.getCellData("TestData", 7, dataCounter);
			}
 	 
	
			item.setQuantity(quantity);
		 
			details.add(item);
		}
			else
			{
				continue;
			}
		}
	}
 

	public boolean isWishList() {
		return wishList;
	}
	public boolean getWishList()
	{
		return this.wishList;
	}

	public void setWishList(boolean wishList) {
		this.wishList = wishList;
	}

	public  List<ItemsInfo> getAllItems()
	{
		 return details;
			 
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("inside set name");
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	
	public String toString()
	{
		return "<p>***********Items added in "+this.getTestCase()+" from "+this.getOrderedFrom()+"***********<br>"+
			   "Brand name:"+this.getBrand()+"<br>"+
			   "Item  name:"+this.getName()+"<br>"+
			   "Size      : "+this.getSize()+"<br>"+
			   "Color	  : "+this.getColor()+"<br>"+
			   "Quantity  : "+this.getQuantity()+"<br>"+
			   "Price	  : "+this.getPrice()+"</p>";
		
			
	}

}
