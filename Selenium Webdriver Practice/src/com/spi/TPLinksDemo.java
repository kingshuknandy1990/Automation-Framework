package com.spi;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TPLinksDemo {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.tutorialspoint.com/java/");
		
		
		List<WebElement> allTheLinks = driver.findElements(By.xpath("//aside/ul[4]/li/a"));
		//this for each loop to get the info which can be use to find the links again in next pages
		ArrayList<String> innerText = new ArrayList<String>();
		for(WebElement element : allTheLinks){
			//element.click();
			innerText.add(element.getText());
		}
		
		
		for(String text : innerText){
			driver.findElement(By.linkText(text)).click();
			Thread.sleep(2000);
		}
		
		

	}

}
