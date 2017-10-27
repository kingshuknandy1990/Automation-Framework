package com.spi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyFirstWDScript {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Opens the Firefox Browser
		WebDriver driver = new FirefoxDriver();//up casting
		driver.manage().window().maximize();//maximize the browser
		driver.get("https://www.google.co.in/");
		String title = driver.getTitle();
		System.out.println("Title = "+title);//input[@id='lst-ib']
		driver.close();//closes the current window
		driver.quit();//closes all the windows and De initialize the driver
		

	}
	

}
