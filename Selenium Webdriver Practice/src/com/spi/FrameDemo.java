package com.spi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameDemo {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://fit2me.mhealthcoach.net/minitool/hcp/#/iframe?appName=food&r=0.33532049632300864");
		
		
//		driver.switchTo().frame(0);
		WebElement frameElement = driver.findElement(By.xpath("//iframe[contains(@src,'utm_campaign=iframer')]"));
		driver.switchTo().frame(frameElement);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(@class,'thumbs-up')]")).click();

	}

}
