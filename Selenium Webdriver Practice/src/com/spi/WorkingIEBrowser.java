package com.spi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class WorkingIEBrowser {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.ie.driver", "C:\\MaheshM\\Jars\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
		Thread.sleep(5000);
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		
		Actions ac = new Actions(driver);
//		ac.dragAndDrop(draggable, droppable).build().perform();
		ac.dragAndDropBy(draggable, 184, 51).build().perform();

	}

}
