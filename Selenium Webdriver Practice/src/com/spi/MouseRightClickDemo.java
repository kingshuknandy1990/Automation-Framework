package com.spi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseRightClickDemo {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("http://ksrtc.in/");
		
		
		WebElement element = driver.findElement(By.linkText("Our Services"));
		
		Actions ac = new Actions(driver);
		ac.contextClick(element).build().perform();
		
		ac.sendKeys(Keys.RIGHT).build().perform();
		Thread.sleep(2000);
		ac.sendKeys(Keys.DOWN).build().perform();
		Thread.sleep(2000);
		ac.sendKeys(Keys.DOWN).build().perform();
		Thread.sleep(2000);
		/*ac.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);*/
		
		ac.sendKeys("t").build().perform();
		
		
		
		

	}

}