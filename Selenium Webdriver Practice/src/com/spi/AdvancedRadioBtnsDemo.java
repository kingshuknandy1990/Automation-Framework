package com.spi;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AdvancedRadioBtnsDemo {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.beginnersguidetohtml.com/guides/html/forms/radio-buttons");
		
		
		List<WebElement> ageRadioBtns = driver.findElements(By.name("age"));
		
		for(WebElement element : ageRadioBtns){
			element.click();
			Thread.sleep(1000);
		}

	}

}
