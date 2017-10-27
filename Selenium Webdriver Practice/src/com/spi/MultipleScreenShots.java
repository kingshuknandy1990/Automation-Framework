package com.spi;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MultipleScreenShots {

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
		for(int i = 0;i<topMenus.size();i++){
			ac.moveToElement(topMenus.get(i)).build().perform();
			Thread.sleep(500);
			File fileObject = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			try {
				FileUtils.copyFile(fileObject, new File("C:\\MaheshM\\menu_"+(i+1)+".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}

}
