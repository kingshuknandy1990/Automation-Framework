package com.spi;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleAutoSuggestionsDemo {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.co.in");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("lst-ib")).sendKeys("selenium webdriver");
		

		
		
		List<WebElement> suggestedOptions = driver.findElements(By.xpath("//ul[@role='listbox']//div[@class='sbqs_c']"));
		for(WebElement element:suggestedOptions){
			System.out.println(element.getText());
		}
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[contains(text(),'selenium webdriver') and b[contains(text(),'tu')]]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
