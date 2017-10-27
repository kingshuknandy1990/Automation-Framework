package com.spi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.ksrtc.in/AWATAROnline/?action=reg");
		
		
		WebElement countryDropDownElement = driver.findElement(By.name("selectCountry"));
		
		
		Select countrySelObj = new Select(countryDropDownElement);
//		countrySelObj.selectByIndex(0); //pass the index of option tag inside select tag //index starts from 0
		
//		countrySelObj.selectByValue("India");//pass the value of value attribute belongs to option tag
		countrySelObj.selectByVisibleText("Kenya");

	}

}
