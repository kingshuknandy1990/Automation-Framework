package com.spi;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class KSRTCAutoSuggestions {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.ksrtc.in/");
		
		
		driver.findElement(By.id("matchStartPlace")).sendKeys("mys");
		
		Thread.sleep(2000);
		List<WebElement> placesList = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li/a"));
		
		for(WebElement element : placesList){
			System.out.println(element.getText());
		}
		
		driver.findElement(By.linkText("SALIGRAM/MYSORE")).click();

	}

}
