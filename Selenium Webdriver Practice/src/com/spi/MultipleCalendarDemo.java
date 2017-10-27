package com.spi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MultipleCalendarDemo {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://jqueryui.com/resources/demos/datepicker/multiple-calendars.html");
		
		
		driver.findElement(By.id("datepicker")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@class,'last')]//a[text()='28']")).click();

	}

}
