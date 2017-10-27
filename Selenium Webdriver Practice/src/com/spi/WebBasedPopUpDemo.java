package com.spi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebBasedPopUpDemo {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://jqueryui.com/resources/demos/dialog/modal-form.html");
		
		
		
		driver.findElement(By.id("create-user")).click();
		
		
		Thread.sleep(2000);
		WebElement nameElement = driver.findElement(By.id("name"));
		nameElement.clear();
		nameElement.sendKeys("spi user");
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("spi@gmail.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("spiuser");
		

		driver.findElement(By.xpath("//button[span[contains(text(),'an ac')]]")).click();
	}

}
