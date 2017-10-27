package com.spi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TypeAndClickDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();//up casting
		driver.manage().window().maximize();//maximize the browser
		driver.get("http://www.amazon.com/");
		
		//locate web element by using name attribute value of the tag
		//<input type="text" name="field-keywords" >
		WebElement textField = driver.findElement(By.name("field-keywords"));
		textField.sendKeys("sony");
		
		
		driver.findElement(By.xpath("//input[@value='Go']")).click();

	}

}
