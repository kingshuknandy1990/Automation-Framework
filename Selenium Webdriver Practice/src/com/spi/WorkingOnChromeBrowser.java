package com.spi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WorkingOnChromeBrowser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\MaheshM\\Jars\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
		
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		
		Actions ac = new Actions(driver);
//		ac.dragAndDrop(draggable, droppable).build().perform();
		ac.dragAndDropBy(draggable, 184, 51).build().perform();
	}

}
