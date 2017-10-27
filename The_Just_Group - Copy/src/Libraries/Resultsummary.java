
package Libraries;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import jxl.Sheet;
import jxl.Workbook;

public class Resultsummary {
    public static String pth="";
    public static int failcounter;
    public static int slno=1;

//Creating a Result Summary html Log file

    public void createSummaryFile() throws IOException{
        try{
        Configuration config = new Configuration();
        String sfile=config.ResultPath; 
        Calendar c = new GregorianCalendar();
        String currtime=c.getTime().toString();
        		Workbook w = Workbook.getWorkbook(new File(System.getProperty("user.dir")+"\\Utility\\Utility.xls"));
                Sheet s=w.getSheet("Setup");
                String Browser =s.getCell(1,4).getContents();
                String Url= s.getCell(1,5).getContents();
                String Os=s.getCell(1,6).getContents();
                String BrowserVersion=s.getCell(1,7).getContents();
                System.out.println(Url);
                w.close();
        BufferedWriter bw1 = new BufferedWriter(new FileWriter(sfile+"/Summary.html"));
        bw1.write("<html>");
        bw1.write("<head>");
        bw1.write("<title>Result Summary</title>");
        bw1.write("</head><body>");
        //bw1.write("<table style=font-family:calibri  Align=center><tr><td width=200><img src=./Logo/marlabslogo.jpg/></td><td width=500><B>Selenium Hybrid Automation Framework Implementation</B></td></tr></table>");
        bw1.write("<table style=font-family:arial border =1 cellspacing=1 frame=Vsides bgcolor=#CC9999 Align=Center>");
        bw1.write("<tr><th width=775>Test : Automated Test Script Execution Summary Report</th></tr>");
        bw1.write("</table>");
		//bw1.write("<table style=font-family:arial border =1 cellspacing=1 frame=Vsides bgcolor=#CC9999 Align=Center>");
		//bw1.write("<tr><td  width=387 ><img src=C:/Catalyst/Images/Catayst_logo.png height=142 width=142></td><td width=388><img src=C:/Catalyst/Images/Marlabs_logo.jpg height=142 width=142></td></tr>");
		//bw1.write("</table>");
        bw1.write("<table style=font-family:calibri border =1 cellspacing=1 frame=Vsides bgcolor=6699FF Align=Center>");
        bw1.write("<tr><td  width=500 ><B>Execution Started Time</B></td><td width=270><B>" +currtime+ "</B></td></tr>");
        bw1.write("<tr><td  width=500 ><B>Environment </B></td><td width=270><B>"+Url+"</B></td></tr>");
        bw1.write("<tr><td  width=500 ><B>Browser </B></td><td width=270><B>"+Browser+"</B></td></tr>");
        bw1.write("<tr><td  width=500 ><B>Browser Version </B></td><td width=270><B>"+BrowserVersion+"</B></td></tr>");
        bw1.write("<tr><td  width=500 ><B>Operating System </B></td><td width=270><B>"+Os+"</B></td></tr>");
        bw1.write("<tr><td  width=500 ><B>Automation Tool</B></td><td width=270><B>Selenium</B></td></tr></table><br/>");
        bw1.write("<table style=font-family:calibri border =2 cellspacing=1 frame=Vsides bgcolor=#E8E8E8 Align=Center><tr><td Align=Center width=50><B>SL NO</B></td><td Align=center width=632><B>TestScript Name</B></td><td width=80 Align=center><B>Result</B></td></tr>");
        bw1.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

//Writing Pass Message to the html log file
    public void writePassSummary(String scriptname, String status) throws IOException{
        try{
        
        Configuration config = new Configuration();
        String rpath = config.ResultPath;
        BufferedWriter bw1 = new BufferedWriter(new FileWriter(rpath+"/summary.html",true));
        bw1.write("<tr><td Align=center>"+slno+"</td><td><a href="+scriptname+".html>"+scriptname+"</a></td><td bgcolor=#00FF00 Align=center>"+status+"</td></tr>");
        slno++;
        bw1.close();
        }
        catch(Exception e){
            System.out.println("Write PassSummary error = "+e);
        }
    }

//Writing Fail Message to the html log file
    public void writeFailSummary(String scriptname, String status) throws IOException{
        try{
        Configuration config = new Configuration();
        String rpath = config.ResultPath;
        BufferedWriter bw1 = new BufferedWriter(new FileWriter(rpath+"/summary.html",true));
        bw1.write("<tr><td Align=center>"+slno+"</td><td><a href="+scriptname+".html>"+scriptname+"</a></td><td bgcolor=#FF0000 Align=center>"+status+"</td></tr>");
        slno++;
        bw1.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}