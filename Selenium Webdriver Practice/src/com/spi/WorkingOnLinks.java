package com.spi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WorkingOnLinks {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.ksrtc.in/");
		
		driver.findElement(By.linkText("New User? [Register]")).click();
		
		driver.findElement(By.linkText("Sign In")).click();

	}

}
