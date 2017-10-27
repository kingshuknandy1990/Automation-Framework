package com.spi;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOverOnTopMenusDemo {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		
		List<WebElement> topMenus = driver.findElements(By.xpath("//div[@id='bluemenu']/ul/li"));
		Actions ac = new Actions(driver);
		for(WebElement menu : topMenus){
			ac.moveToElement(menu).build().perform();
			Thread.sleep(500);
			List<WebElement> subMenuList = menu.findElements(By.xpath("ul/li"));
			for(WebElement subMenu : subMenuList){
				ac.moveToElement(subMenu).build().perform();
			}
			
		}

	}

}
