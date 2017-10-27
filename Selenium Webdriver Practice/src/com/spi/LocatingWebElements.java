package com.spi;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocatingWebElements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();//up casting
		driver.manage().window().maximize();//maximize the browser
		driver.get("http://www.amazon.com/");
		
		//locate web element by using name attribute value of the tag
		//<input type="text" name="field-keywords" >
		driver.findElement(By.name("field-keywords")).sendKeys("sony");

		//locate web element using id attribute value of the tag
		//getting value of value attribute
		String textInSearchField = driver.findElement(By.id("twotabsearchtextbox")).getAttribute("value");
		System.out.println("text = "+textInSearchField);
		
		
		//locate web element by using class attribute value of the tag
		//the class value must not have space(' ')
		System.out.println(driver.findElement(By.className("nav-logo-base")).getTagName());
		
		//Find 'a' tagged elements By using Inner text of the 'a' tag
		//use linktext to find link(s) using complete inner text of 'a' tag
		String hrefValue = driver.findElement(By.linkText("Sell")).getAttribute("href");
		System.out.println("href = "+hrefValue);
		
		
		//use partialLinkText() to find link(s) using partial inner text of 'a' tag
		String hrefStringValue = driver.findElement(By.partialLinkText("Amazon.com")).getAttribute("href");
		System.out.println("href = "+hrefStringValue);
		
		//locate element by using xpath
		List<WebElement> linksUsingXpath = driver.findElements(By.xpath("//a"));
		System.out.println("No of Links using xpath = "+linksUsingXpath.size());
		
		//locate element using css selector
		List<WebElement> linksUsingcssSelector = driver.findElements(By.cssSelector("a"));
		System.out.println("No of Links using css Selector = "+linksUsingcssSelector.size());
		
		//locate element by using tag name
		List<WebElement> linksUsingtagName = driver.findElements(By.tagName("a"));
		System.out.println("No of Links using Tag Name = "+linksUsingtagName.size());
	}

}
