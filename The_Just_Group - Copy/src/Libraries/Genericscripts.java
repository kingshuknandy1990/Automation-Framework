package Libraries;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.Main;



    
	public class Genericscripts {
    public int objval=0;
    public String scriptname;
    Resultsummary r;
    public static int TC=0;
    public static String Snapshotpath;
    public static int screencapcounter=1;
    public static String celldata;
    public static int rnum;
    public static int cnum;
    public static String[] arr;
    public static String browser="*iexplore";
    public static WebDriver driver;

            public Genericscripts(String scrptname) {
                   
                    this.scriptname=scrptname;
                    driver = Main.driver;
                    try{
                    createLogFile();
                    r=new Resultsummary();
                    r.failcounter=0;
                    }
                    catch(Exception e){
                    System.out.println(e);
                    }
            }

          //********************************************************************************************************************
          //Generic function name :typeIntoEditBox using WebDriver
          //Description : Validating the Text Box in the screen
          //********************************************************************************************************************
             
                      public void typeIntoEditBoxWD(String locator, String val) throws Exception{
                    	  WebElement el  =explicitWait(locator);
                    	  if(el!= null){
                              System.out.println(locator+" Link found");
                              el.sendKeys(val);
                              System.out.println("Entered value [ "+val+" ] @  [ "+locator+" ]");
                              writePassLog("Entered value [ "+val+" ] @  [ "+locator+" ]");
                              }
                              else{
                              writeFailLog("Cound not Enter value [ "+val+" ] @  [ "+locator+" ]");
                              }
              }
   

 //********************************************************************************************************************
 //Generic function name :clickLinkWD
 //Description : Validating and clicking the Link by Xpath or any attributes
 //********************************************************************************************************************
   
    public void clickLinkWD(String locator) throws Exception{
    	WebElement el =explicitWait(locator);
             if(el!= null){
             System.out.println(locator+" Link found");
             el.click();
             System.out.println("clicked on the Button - "+locator);
             writePassLog("clicked on the Link - "+locator);
             }
             else{
             writeFailLog("Link not found on the Screen");
             }
     }
    
    
    public static  WebElement explicitWait(String locator)
    {
    	WebDriverWait wait  = new WebDriverWait(driver, 5);
    	
    	return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    	
    	
    	
    }
    
    //********************************************************************************************************************
    //Generic function name :clickButtonWD
    //Description : Validating and clicking the Button by Xpath or any attributes
    //********************************************************************************************************************
      
       public void clickButtonWD(String locator) throws Exception{
    	   	WebElement e =explicitWait(locator);
                if(e!= null){
                System.out.println(locator+" Link found");
                e.click();
                System.out.println("clicked on the Button - "+locator);
                writePassLog("clicked on the Button - "+locator);
                }
                else{
                writeFailLog("Button not found on the Screen");
                }
        }
    
       public void switchIframe(String locator)
       {
    	   
    	   driver.switchTo().frame(driver.findElement(By.id(locator)));
       }
       public boolean isSelected(String locator)
       {
    	   boolean isChecked;
    	   
    	   WebElement e = explicitWait(locator);
    	   isChecked = driver.findElement(By.xpath(locator)).isSelected();
    	   
    	   return isChecked;
       }
       
       public String getText(String locator)
       {
    	   
    	   WebElement el =  explicitWait(locator);
    	   return el.getAttribute("value");
       }
       
       public boolean ElementVisibility(String locator){
    	   WebElement  element=  explicitWait(locator);
    	   //List <WebElement> element=e;
    	   List <WebElement> li=new ArrayList<WebElement>();
    	   li.add(element);
   		boolean status=false;
   		//if element is visible
   		if(li.size() != 0){
   			status=true;
       		}
   		
   		return status;
   	}
       
  //********************************************************************************************************************
    //Generic function name :clickLinkWD
    //Description : Mouse Over on the Location
    //********************************************************************************************************************
      
       public void mouseOver(String locator) throws Exception{
    	   Actions action = new Actions(driver);
	    	 WebElement we = driver.findElement(By.xpath(locator));
	    	 action.moveToElement(we).build().perform();
                writePassLog("Mouse Over on the Location - "+locator);
               
        }
       //********************************************************************************************************************
       //Generic function name :clickLinkWD
       //Description : Mouse Over on the Location
       //********************************************************************************************************************
         
          public String gText(String locator) throws Exception{
        	  String text = driver.findElement(By.xpath(locator)).getText();
        	  return text;
                  
           }     
       
//********************************************************************************************************************
//Generic function name :createLogFile
//Description : Creating Html Log File for the test script
//********************************************************************************************************************
    
   public void createLogFile() throws IOException{
            try{
            Configuration config = new Configuration();
            String rpath = config.ResultPath;
            Calendar c = new GregorianCalendar();
            String currtime=c.getTime().toString();
            BufferedWriter bw1 = new BufferedWriter(new FileWriter(rpath+"/"+scriptname+".html"));
            bw1.write("<html><head><title>"+scriptname+"</title></head><body><table style=font-family:calibri border =1 cellspacing=1 frame=Vsides  bgcolor=6699FF Align=Center><tr><td><B>Test Case Name</B></td><td><B>"+scriptname+"</B></td></tr>");
            bw1.write("<tr><td width=500 ><B>Execution Start Time</B></td><td width=270><B>"+currtime+"</B></td></tr></table><br/>");
            bw1.write("<table style=font-family:calibri border =1 cellspacing=1 frame=Vsides bgcolor=#E8E8E8 Align=Center><tr><td Align=center><B>Step Description</B></td><td Align=center><B>Result</B></td></tr>");
            bw1.close();
            }
            catch(Exception e){
            System.out.println(e);
            }
    }
    
//********************************************************************************************************************
//Generic function name :writePassLog
//Description : Writing Pass message to the HTML log file
//********************************************************************************************************************
    
    public void writePassLog(String desc) throws IOException{
            try{

        	Configuration config = new Configuration();
            String rpath = config.ResultPath;
            BufferedWriter bw1 = new BufferedWriter(new FileWriter(rpath+"/"+scriptname+".html",true));
            bw1.write("<tr><td width=690>"+desc+"</td><td width=80 bgcolor=#00FF00 Align=center >PASS</td></tr>");
            bw1.close();
            }
            catch(Exception e){
            System.out.println("Error = "+e);
            }
    }
    
  //********************************************************************************************************************
  //Generic function name :writePassLog
  //Description : Writing Pass message to the HTML log file
  //********************************************************************************************************************
      
      public void writeHeader(String desc) throws IOException{
              try{

          	Configuration config = new Configuration();
              String rpath = config.ResultPath;
              BufferedWriter bw1 = new BufferedWriter(new FileWriter(rpath+"/"+scriptname+".html",true));
              bw1.write("<tr><td width=770 bgcolor=lightblue Align=center>"+desc+"</td></tr>");
              bw1.close();
              }
              catch(Exception e){
              System.out.println("Error = "+e);
              }
      }
    
    public void writeResults(String desc) throws IOException{
        try{

    	Configuration config = new Configuration();
        String rpath = config.ResultPath;
        BufferedWriter bw1 = new BufferedWriter(new FileWriter(rpath+"/"+scriptname+".html",true));
        bw1.write("<tr><td width=690 bgcolor= pink ><b>"+desc+"</td></td></tr>");
        bw1.close();
        }
        catch(Exception e){
        System.out.println("Error = "+e);
        }
}
//********************************************************************************************************************
//Generic function name :writeFailLog
//Description : Writing Fail message to the HTML log file
//********************************************************************************************************************
   
    public void writeFailLog(String desc) throws Exception{
            try{
            Configuration config = new Configuration();
            String rpath = config.ResultPath;
            takeScreenShot(scriptname);
            BufferedWriter bw1 = new BufferedWriter(new FileWriter(rpath+"/"+scriptname+".html",true));
            bw1.write("<tr><td width=690><a href="+Snapshotpath+">"+desc+"</a></td><td width=80 bgcolor=#FF0000 Align=center >FAIL</td></tr>");
            bw1.close();
            r.failcounter++;
            }
            catch(Exception e){
            System.out.println("Write Failed Log Exception = "+e);
            }
    }
    

  //****************************************************************************************************************
  //Generic function name :Elementpresent
  //Description : Wait until the element displayed on the page
  //****************************************************************************************************************
   public void WDElementpresent(String locator)throws Exception{
      	for(int i=0;i<=50;i++){
      		Thread.sleep(1000);
      	//	if(WD.findElements(By.xpath(locator) != null)
      				{
      			writePassLog("Element displayed on the Screen :"+locator);
      			break;
      			
      		}
      	}
   }

       public void clickLinkWDDynamiObj(WebElement obj) throws Exception{
       	obj.click();
        writePassLog("clicked on the Dyanmic Object - "+obj);
   }
       
       // store screenshots
    	public static void takeScreenShot(String scriptname) throws Exception {
    		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    		Configuration config = new Configuration();
   	    String rpath = config.ResultPath;
    	    try {
    			FileUtils.copyFile(scrFile, new File(rpath+"/Snapshots/"+scriptname+screencapcounter+".png"));
    			Snapshotpath = "./Snapshots/"+scriptname+screencapcounter+".png";
                screencapcounter++;
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}	   
    	}
    	
    	public void selectdropDown(String value) throws Exception
    	{
    		try {
    			org.openqa.selenium.support.ui.Select dropdown = new org.openqa.selenium.support.ui.Select(driver.findElement(By.id("SelectedDivision")));
        		dropdown.selectByVisibleText((value)); 
        		writePassLog("Selected value at drop down - "+value);
    		}
    		 catch (IOException e) {
     			// TODO Auto-generated catch block
     			e.printStackTrace();
     		}	
    	}
}