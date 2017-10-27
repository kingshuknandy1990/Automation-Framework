/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package TestScripts;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.Main;
import Libraries.Genericscripts;
import Libraries.ProjectSpecific;
import Libraries.Resultsummary;
import reports.CustomReporter;

import com.thoughtworks.selenium.SeleniumException;

public class TC1_Just_Group_Login {
	
	ProjectSpecific ps = new ProjectSpecific();
	Resultsummary rs = new Resultsummary();
	Logger APPLICATION_LOGS = Logger.getLogger("ApplicationLog");
	
	Genericscripts gs = new Genericscripts(getClass().getSimpleName());
	public static Xpath xp;
	WebDriver driver;
	
	public TC1_Just_Group_Login()throws Exception{
		
		xp = Main.xpath;	
		driver=Main.driver;
		
	}

     public void TC1_SPManager_Access()throws Exception{
    	 CustomReporter.startParent("Login functionality", "Giving valid Username and Password,Logging in and Checking it has Landed to My accounts Page Or Not");
    	 try
 		{	
        APPLICATION_LOGS.debug("*** Test Script 1 Begins ***");
    	System.out.println("*******----- TC1_home page-----*******");	
    	Genericscripts gs = new Genericscripts(getClass().getSimpleName());
    
    	String actalTitle = driver.getTitle();
    	String expectedTitle = "The Just Group";
    	
    	CustomReporter.addParentInfo("Page title : "+actalTitle);
    	if(actalTitle.contains(expectedTitle))
    	{
    		gs.writePassLog("Title of the page - Matched");
    		
    		CustomReporter.addParentInfo("Title is matched");
    	}
    	else
    	{
    		gs.writeFailLog("Title of the page - Did not Matched");
    		
    		CustomReporter.reportParent("fail", "Title Don 't  match");
    	}
    	

    	gs.clickButtonWD("//*[@id='home']/div[2]/div/div[3]/ul[2]/li[1]/a/img");
        gs.clickButtonWD("//*[@id='do-personal']/ul/li[1]/a");
    	
    	Workbook w = Workbook.getWorkbook(new File(System.getProperty("user.dir")+"\\TestData\\TestData.xls"));
        Sheet s=w.getSheet("credentials");
        String Username = s.getCell(1,0).getContents();
        String Password = s.getCell(1,1).getContents();
        gs.typeIntoEditBoxWD("//*[@id='do-login-email']",Username);
        gs.typeIntoEditBoxWD("//*[@id='do-login-password']", Password);
    	//driver.findElement(By.xpath("//*[@id='ContentPlaceHolder1_SubmitButton']")).click();
    	gs.clickButtonWD("//*[@id='do-login-remember']");
        
        gs.clickButtonWD("//*[@id='do-login-submit']");
        String SuccessPageMsg=gs.getText("//div[@id='do-content']//h1");
        if(gs.ElementVisibility("//div[@id='do-content']//h1")){
        	System.out.println("successful");
        	CustomReporter.reportParent("pass", "Successfully logged in");
        }else{
        	System.out.println("fail");
        	CustomReporter.reportParent("fail", "Unable to login");
        }
    	
    	APPLICATION_LOGS.debug("*** Test Script 1 Ends ***");
    		
    	
    	
        if(rs.failcounter>0){       
        	/*CustomReporter.startParent("Test Case 1", "Verifying credentials");
        	CustomReporter.reportParent("fail", "Verification of credentials failed");
        	CustomReporter.endParentTest();
        	CustomReporter.end();*/
            rs.writeFailSummary(getClass().getSimpleName(), "FAIL");
            Main.fail++; 
            Main.failTestScript.add(getClass().getSimpleName()); 
        }
        else{
        	/*CustomReporter.startParent("Test Case 1", "Verifying credentials");
        	CustomReporter.reportParent("pass", "Verification of credentials passes");
        	CustomReporter.endParentTest();
        	CustomReporter.end();*/
        	 rs.writePassSummary(getClass().getSimpleName(), "PASS");
        	 Main.pass++;
        }
        
        CustomReporter.endParentTest();
    	CustomReporter.end();
      }
    	 catch(SeleniumException e){
    		CustomReporter.endParentTest();
         	CustomReporter.end();
 			System.out.println(e);
 			StringWriter sw = new StringWriter();
 			e.printStackTrace(new PrintWriter(sw));
 			String st=sw.toString();
 			gs.writeFailLog(st);
 			rs.writeFailSummary(getClass().getSimpleName(), "FAIL");
 			APPLICATION_LOGS.debug("*** Test Script 1 Error ***"+e.getMessage());
 		}
     }     
 }