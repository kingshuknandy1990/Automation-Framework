package com.spi;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AdvancedTypeDemo {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();//up casting
		driver.manage().window().maximize();//maximize the browser
		driver.get("https://www.irctc.co.in");
		
		WebElement userNameField = driver.findElement(By.id("usernameId"));
		userNameField.sendKeys("mahesh");
		
//		userNameField.sendKeys(Keys.CONTROL+"a");//to do ctrl+a
		userNameField.sendKeys(Keys.SHIFT,Keys.HOME);//to do SHIFT+HOME
		Thread.sleep(2000);
		userNameField.sendKeys(Keys.CONTROL+"c");//to do ctrl+c
		
		driver.findElement(By.name("j_password")).sendKeys(Keys.CONTROL+"v");
		String dataInPwd = driver.findElement(By.name("j_password")).getAttribute("value");
		System.out.println(dataInPwd);
	}

}
