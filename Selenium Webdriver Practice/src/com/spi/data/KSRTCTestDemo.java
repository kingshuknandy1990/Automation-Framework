package com.spi.data;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class KSRTCTestDemo {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		String filePath = "C:\\MaheshM\\KSRTCDataFile.xlsx";
		ExcelLibrary el = new ExcelLibrary(filePath);
		
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.ksrtc.in/");
		
		String sheetName = "Places";
		int rowCount = el.getRowCount(sheetName);
		
		for(int i = 1;i<=rowCount;i++){
			driver.findElement(By.id("matchStartPlace")).clear();
			String startPlace = (String)el.getCellData(sheetName, i, 0);
			double doubleValue = (Double)el.getCellData(sheetName, i, 1);
			int expectedCount = (int)doubleValue;
			driver.findElement(By.id("matchStartPlace")).sendKeys(startPlace);
			
			Thread.sleep(2000);
			List<WebElement> placesList = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li/a"));
			
			System.out.println("Actual Places count for "+startPlace+" is "+placesList.size());
			if(expectedCount == placesList.size()){
				el.writeToCell(sheetName, i, 2, "PASS");
			}else {
				el.writeToCell(sheetName, i, 2, "FAIL");
			}
		}
		

	}

}
