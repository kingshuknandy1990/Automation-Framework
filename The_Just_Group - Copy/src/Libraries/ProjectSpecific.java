package Libraries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Framework.Main;
import TestScripts.Xpath;


public class ProjectSpecific {
	
	public static int rowCount;
	public static String price;
	Genericscripts gs = new Genericscripts(getClass().getSimpleName());
	public static WebDriver driver;
	public static Xpath xp;
	
	public ProjectSpecific ()throws Exception{
	driver = Main.driver;
	xp = Main.xpath;
	}
	public void loginPage() throws Exception {
		if(driver.findElement(By.id(xp.userName)).isDisplayed() 
		&& driver.findElement(By.xpath(xp.passWord)).isDisplayed() 
		&& driver.findElement(By.xpath(xp.loginButton)).isDisplayed() )
		   {
		    	gs.writePassLog("UserName, Password & Login button Filed are present");
		   }
		
		else {
			gs.writeFailLog("Filed Not present");
		}
	}
	
}


