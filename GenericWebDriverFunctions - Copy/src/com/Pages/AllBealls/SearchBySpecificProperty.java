package com.Pages.AllBealls;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.GenericFunctions.WebDriver.GenericFunctionsExtra;
import com.GenericFunctions.WebDriver.GenericWebDriverFunctions;
import com.constants.string.PromotionConstants;
import com.constants.string.SearchBySpecificPropertyConstands;
import com.constants.string.StringConstants;
import com.excellibrary.bealls.ExcelLibrary;
import com.reports.beallsCustom.CustomReporter;

public class SearchBySpecificProperty {
	
	@FindBy(id=SearchBySpecificPropertyConstands.SEARCHBOX)
	public static WebElement searchBox;
	
	@FindBy(id=SearchBySpecificPropertyConstands.SEARCHBUTTON)
	public static WebElement searchButton;
	
	@FindBy(xpath=SearchBySpecificPropertyConstands.WebIdFeildInPDP)
	public static WebElement WebIdFeildInPDP;
	
	
	@FindBy(xpath=SearchBySpecificPropertyConstands.PDP_Rightsection)
	public static List<WebElement>  PDP_RightSection;
	
	public SearchBySpecificProperty(){
		PageFactory.initElements(GenericWebDriverFunctions.driver,this);
	}

	public static void SearchBywebId(){
		CustomReporter.startChild("Search Items By Web-Id", "");
		try {
			ExcelLibrary exe=new ExcelLibrary(SearchBySpecificPropertyConstands.filepath);
			String  SearchKeyWord=(String) exe.getCellData(SearchBySpecificPropertyConstands.TestData, SearchBySpecificPropertyConstands.SearchByWebIdRow, SearchBySpecificPropertyConstands.cellno);
			GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, searchBox, SearchKeyWord);
			GenericWebDriverFunctions.performAction(StringConstants.CLICK, searchButton, "");
			GenericWebDriverFunctions.performAction(StringConstants.GETTEXT, WebIdFeildInPDP, "");
			
			String str[]=GenericFunctionsExtra.Split(GenericWebDriverFunctions.getText);
			String ObtainedWebid=str[2];
			if(ObtainedWebid.equalsIgnoreCase(SearchKeyWord)){
				CustomReporter.reportChild("pass", "Product With WebId:"+SearchKeyWord+" has been searched successfully");
			}else{
				CustomReporter.reportChild("fail", "Product With WebId:"+SearchKeyWord+" was not found");
			}

		} catch (Exception e) {
			CustomReporter.reportChild("fail", "Unable to Search item ");
		}

		CustomReporter.endChildTest();
	}
	
    public static void SearchBySKU(){
    	CustomReporter.startChild("Search Items By SKU", "");
		try {
			ExcelLibrary exe=new ExcelLibrary(SearchBySpecificPropertyConstands.filepath);
			String  SearchKeyWord=(String) exe.getCellData(SearchBySpecificPropertyConstands.TestData, SearchBySpecificPropertyConstands.SearchBySKURow, SearchBySpecificPropertyConstands.cellno).toString();
			GenericWebDriverFunctions.performAction(StringConstants.SENDKEYS, searchBox, SearchKeyWord.replace("-", ""));
			GenericWebDriverFunctions.performAction(StringConstants.CLICK, searchButton, "");
			if (GenericFunctionsExtra.ElementVisibility(PDP_RightSection)) {
				CustomReporter.reportChild("pass", "Product was successfully searched by SKU:"+SearchKeyWord);	
			}else{
				CustomReporter.reportChild("fail", "Unable to Search item by SKU ID ");	
			}
			
		} catch (Exception e) {
			CustomReporter.reportChild("fail", "Exception Occured:"+"Unable to Search item by SKU ID "+e);
		}

		CustomReporter.endChildTest();
	}
}
