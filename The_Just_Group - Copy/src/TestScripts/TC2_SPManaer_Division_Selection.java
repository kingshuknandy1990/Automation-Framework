/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TestScripts;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.Main;
import Libraries.Genericscripts;
import Libraries.ProjectSpecific;
import Libraries.Resultsummary;
import Libraries.TestData;
import jxl.Sheet;
import jxl.Workbook;
import reports.CustomReporter;

import com.sun.org.apache.bcel.internal.generic.Select;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.thoughtworks.selenium.SeleniumException;

public class TC2_SPManaer_Division_Selection {
	
	private static final char[] te = null;
	ProjectSpecific ps = new ProjectSpecific();
	Resultsummary rs = new Resultsummary();
	Logger APPLICATION_LOGS = Logger.getLogger("ApplicationLog");
	
	Genericscripts gs = new Genericscripts(getClass().getSimpleName());
	public static Xpath xp;
	WebDriver driver;
	
	public TC2_SPManaer_Division_Selection()throws Exception{
		
		xp = Main.xpath;	
		driver=Main.driver;
	}
     
     public void TC2_SPManager_Access()throws Exception{
    	 try
 		{	
        APPLICATION_LOGS.debug("*** Test Script 2 Begins ***");
    	System.out.println("*******----- TC2_SPManager_Access -----*******");	
    	Genericscripts gs = new Genericscripts(getClass().getSimpleName());
    
    	String actalTitle = driver.getTitle();
    	//String expectedTitle = "SP Manager";
   
    	gs.typeIntoEditBoxWD("//*[@id='ContentPlaceHolder1_UsernameTextBox']", "BC02584");
    	gs.typeIntoEditBoxWD("//*[@id='ContentPlaceHolder1_PasswordTextBox']", "Mouni@1605");
    	gs.clickButtonWD("//*[@id='ContentPlaceHolder1_SubmitButton']");
    	
    	Actions mouseOver = new Actions(driver);
    	WebElement element = driver.findElement(By.xpath("//*[@id='trigger']/i")); 
    	
    	mouseOver.moveToElement(element).perform();
    	driver.findElement(By.xpath("//*[@id='drop']/li[1]/a")).click();
    	driver.findElement(By.xpath("//*[@id='drop']/li[1]/div/ul/li[1]/a")).click();     	
    	Thread.sleep(2000);
    	System.out.println("The Output of the IsDisplayed " + driver.findElement(By.id("SelectedDivision")).isDisplayed()); 	
    	
    	
    	String value;
    	Workbook w = Workbook.getWorkbook(new File(System.getProperty("user.dir")+"\\TestData\\TestData.xls"));
        Sheet s=w.getSheet("Division");
        value=s.getCell(0,1).getContents();
        System.out.println(value);
     	gs.selectdropDown(value);
		
     	APPLICATION_LOGS.debug("*** Test Script 2 Ends ***"); 
    	
        if(rs.failcounter>0){        	
        	CustomReporter.startParent("Test Case 2", "Verifying division selection");
        	CustomReporter.reportParent("fail", "Verification of division selection failed");
        	CustomReporter.endParentTest();
        	CustomReporter.end();
            rs.writeFailSummary(getClass().getSimpleName(), "FAIL");
            Main.fail++; 
            Main.failTestScript.add(getClass().getSimpleName()); 
        }
        else{
        	CustomReporter.startParent("Test Case 2", "Verifying division selection");
        	CustomReporter.reportParent("pass", "Verification of division selection passed");
        	CustomReporter.endParentTest();
        	CustomReporter.end();
        	 rs.writePassSummary(getClass().getSimpleName(), "PASS");
        	 Main.pass++;
        }
      }
    	 catch(SeleniumException e){
 			System.out.println(e);
 			StringWriter sw = new StringWriter();
 			e.printStackTrace(new PrintWriter(sw));
 			String st=sw.toString();
 			gs.writeFailLog(st);
 			rs.writeFailSummary(getClass().getSimpleName(), "FAIL");
 			APPLICATION_LOGS.debug("*** Test Script 2 Error ***"+e.getMessage());
 		}
          
     
 }
}