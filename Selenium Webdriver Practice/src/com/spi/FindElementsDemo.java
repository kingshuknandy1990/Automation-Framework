package com.spi;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindElementsDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();//up casting
		driver.manage().window().maximize();//maximize the browser
		driver.get("http://www.amazon.com/");
//		WebElement element = driver.findElement(By.xpath("//input[@id='lst-ib']"));
		
		List<WebElement> allTheLinks = driver.findElements(By.xpath("//input"));
		
		System.out.println("No of links = "+allTheLinks.size());
		int size = allTheLinks.size();
		
		/*for(int i = 0;i<allTheLinks.size();i++){
			WebElement link = allTheLinks.get(i);
			System.out.println(link.getText());
		}*/
	}

}
