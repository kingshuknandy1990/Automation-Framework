package com.spi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class KSRTCDatePickerDemov {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://ksrtc.in/");
		
		
		driver.findElement(By.id("txtdeptDateRtrip")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='ui-state-default' and text()='21']")).click();

	}
}
