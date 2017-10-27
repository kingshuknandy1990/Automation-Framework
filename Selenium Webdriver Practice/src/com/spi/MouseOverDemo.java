package com.spi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOverDemo {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		
		WebElement element = driver.findElement(By.linkText("Flight Tickets"));
		
		Actions ac = new Actions(driver);
		ac.moveToElement(element).build().perform();
		

	}

}
