package Framework;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import Libraries.HtmlEmailSender;
import Libraries.Resultsummary;
import Libraries.VideoRecord;
import Libraries.Zipresults;
import TestScripts.Xpath;

public class Main {

	public static String Url;
	public static String Browser;
	public static String Port;
	public static String Host;
	public static String Env;
	public static String Tname;
	public static WebDriver driver;
	public static int pass=0;
	public static int fail=0;
	public static String testSuite;
	public static String email;	
	public static String subject;
	public static String recording;
	public static Xpath xpath = new Xpath();
	public static List failTestScript = new ArrayList(); 
	
	
	public static void main(String[] args) {
		try {
			Resultsummary rsum = new Resultsummary();
			rsum.createSummaryFile();
			Workbook w = Workbook.getWorkbook(new File(System.getProperty("user.dir")+"\\Utility\\Utility.xls"));
			Sheet s = w.getSheet("Setup");
			Browser = s.getCell(1, 2).getContents();
			Url = s.getCell(1, 3).getContents();
			Env = s.getCell(1, 8).getContents();
			email=s.getCell(1,11).getContents();
			subject = s.getCell(1, 12).getContents();
			testSuite=s.getCell(1,13).getContents();
			recording=s.getCell(1,14).getContents();
			w.close();
			
			VideoRecord vr = new VideoRecord();	
			//Start Video Recording
			if(recording.equalsIgnoreCase("Yes"))
			{
				vr.startRecording();
			}
			
			//Test Scripts Execution
			SubDriver obj_SD = new SubDriver();
			obj_SD.GetTestScriptName();

			//Zip Results
	Zipresults z = new Zipresults();
			z.zipRes();
			
			//Java Mail 
			HtmlEmailSender email = new HtmlEmailSender();
		//	email.mail();
		//	System.out.println("email sent");

			//Stop Video Recording
			if(recording.equalsIgnoreCase("Yes"))
			{
				vr.stopRecording();	
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	
	public static void StartSeleniumWD() throws Exception {
		//Test Execution in Firfox browser		
		if(Browser.equalsIgnoreCase("Firefox"))
		{
			DesiredCapabilities capa =DesiredCapabilities.firefox();
		    capa.setBrowserName("firefox");
		    capa.setCapability("binary", "C:\\Workspace\\The_Just_Group\\Drivers\\firefox.exe");
		    capa.setPlatform(Platform.ANY);
		    driver = new FirefoxDriver();
		}
		else if(Browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Deepak_justgroup\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
	    
		else if(Browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\JARS\\IE&ChromeDriver\\iedriver64\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		//Test Execution in Safari browser
		else if(Browser.equalsIgnoreCase("safari")) 
		{
			Browser.equalsIgnoreCase("safari");
			driver = new SafariDriver ();
		}
		driver.manage().window().maximize();
		driver.get(Url);
		driver.manage().window().maximize();
	}
	
	public static void StopSeleniumWD() throws Exception {
		driver.quit();
	}
}