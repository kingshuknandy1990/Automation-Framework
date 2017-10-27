package com.spi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DefaultSelectedDropDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.ksrtc.in/AWATAROnline/?action=reg");
		
		
		WebElement countryDropDownElement = driver.findElement(By.name("selectCountry"));
		
		
		Select countrySelObj = new Select(countryDropDownElement);
		
		WebElement defaultSelectedOption = countrySelObj.getFirstSelectedOption();
		System.out.println("defaultSelectedOption = "+defaultSelectedOption.getText());
		
		countrySelObj.selectByVisibleText("Kenya");
		
		WebElement currentSelectedOption = countrySelObj.getFirstSelectedOption();
		System.out.println("Current Selected  = "+currentSelectedOption.getText());

	}

}
