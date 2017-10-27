package com.spi;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectDropDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		
		//switch to frame using id attribute value
		driver.switchTo().frame("iframeResult");
		
		
		WebElement carsElement = driver.findElement(By.name("cars"));
		
		Select carsSelect = new Select(carsElement);
		
		System.out.println("is multiple ?? = "+carsSelect.isMultiple());
		
		
		
		carsSelect.selectByIndex(1);
		carsSelect.selectByValue("volvo");
		carsSelect.selectByVisibleText("Audi");
		
		
		List<WebElement> selectedOptions = carsSelect.getAllSelectedOptions();
		for(WebElement element: selectedOptions){
			System.out.println(element.getText());
		}
		
		
		carsSelect.deselectAll();
		

	}

}
