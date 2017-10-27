package com.spi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JqueryAlertDemo {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://labs.abeautifulsite.net/archived/jquery-alerts/demo/");
		
		driver.findElement(By.id("alert_button")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.id("popup_ok")).click();

	}

}
