package com.spi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserNavigation {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.ksrtc.in");
		
		
		
		driver.findElement(By.partialLinkText("[Register]")).click();
		
		
		Thread.sleep(2000);
		
		driver.navigate().back();//browser back button
		Thread.sleep(2000);
		
		driver.navigate().forward();//browser forward button
		Thread.sleep(2000);
		
		driver.navigate().refresh();//browser reload
		
		driver.getCurrentUrl();
		driver.navigate().to("https://www.google.co.in");//to go other url
		
		

	}

}
