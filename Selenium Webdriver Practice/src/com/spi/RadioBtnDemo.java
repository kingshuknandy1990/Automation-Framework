package com.spi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioBtnDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.beginnersguidetohtml.com/guides/html/forms/radio-buttons");
		
		
		
		WebElement maleRadioBtn = driver.findElement(By.xpath("//input[@value='male']"));
		
		System.out.println("Before Check = "+maleRadioBtn.isSelected());
		maleRadioBtn.click();
		System.out.println("After check = "+maleRadioBtn.isSelected());

	}

}
