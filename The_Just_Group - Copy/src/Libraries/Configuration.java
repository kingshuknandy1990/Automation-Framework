/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Libraries;
import java.io.File;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Configuration {

//Global Variables & Array declaratiion and Initialization
	
public static String ControlScriptPath;
public static String ResultPath;
public static String Zippedfile;
public static String Browser;
public static String TDPath;
public static String FEMUrl;


public Configuration()throws Exception{
		Workbook w = Workbook.getWorkbook(new File(System.getProperty("user.dir")+"\\Utility\\Utility.xls"));
        Sheet s=w.getSheet("Path");
        ControlScriptPath=s.getCell(1,0).getContents();
        System.out.println(ControlScriptPath);
        ResultPath=s.getCell(1,1).getContents();
        System.out.println("ResultPath = " +ResultPath);
        Zippedfile=s.getCell(1,2).getContents();
        TDPath=s.getCell(1,3).getContents();
        w.close();
    }






}
