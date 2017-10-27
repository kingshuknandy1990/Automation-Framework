package com.spi;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JavaScriptDialogBoxDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Type 1:- Alert Dialog Boxes
		/*WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.tutorialspoint.com/javascript/src/alert_dialog_box.htm");
		
		driver.findElement(By.tagName("input")).click();
		
		
		//it switches and returns the pointer to alert
		Alert al = driver.switchTo().alert();
		
		String textOnTheAlert = al.getText();
		System.out.println("Msg = "+textOnTheAlert);
		al.accept();//clicks on Okay button
*/		
		
		//Type 2:- Confirmation Dialog Boxes
	/*	WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.tutorialspoint.com/javascript/src/confirmation_dialog_box.htm");
		
		driver.findElement(By.tagName("input")).click();
		
		
		//it switches and returns the pointer to alert
		Alert al = driver.switchTo().alert();
		
		String textOnTheAlert = al.getText();
		System.out.println("Msg = "+textOnTheAlert);
		
//		al.dismiss();//to click on Cancel
		al.accept();
	*/	
		
		
		
		//Type 2:- Prompt Dialog Boxes
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.tutorialspoint.com/javascript/src/prompt_dialog_box.htm");
		
		driver.findElement(By.tagName("input")).click();
		
		
		//it switches and returns the pointer to alert
		Alert al = driver.switchTo().alert();
		String textOnTheAlert = al.getText();
		System.out.println("Msg = "+textOnTheAlert);
		al.sendKeys("SPI USER");
		al.accept();

	}

}
