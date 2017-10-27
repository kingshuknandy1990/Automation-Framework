package com.spi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindElementDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();//up casting
		driver.manage().window().maximize();//maximize the browser
		driver.get("https://www.google.co.in/");
		String title = driver.getTitle();
		System.out.println("Title = "+title);
		WebElement element = driver.findElement(By.xpath("//input[@id='lst-ib123']"));
		element.sendKeys(new String[]{"selenium Webdriver"});
		driver.close();//closes the current window
		driver.quit();//closes all the windows and De initialize the driver

	}

}
