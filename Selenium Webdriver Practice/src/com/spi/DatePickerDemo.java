package com.spi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DatePickerDemo {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://jqueryui.com/resources/demos/datepicker/icon-trigger.html");
		
		
		
		driver.findElement(By.className("ui-datepicker-trigger")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.linkText("25")).click();
		
	}

}
