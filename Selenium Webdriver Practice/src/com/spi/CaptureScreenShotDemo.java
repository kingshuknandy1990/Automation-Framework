package com.spi;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CaptureScreenShotDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("http://ksrtc.in/");
		
		
		WebElement element = driver.findElement(By.linkText("Our Services"));
		
		Actions ac = new Actions(driver);
		ac.contextClick(element).build().perform();
		
		File fileObject = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(fileObject, new File("C:\\MaheshM\\ksrtc.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
