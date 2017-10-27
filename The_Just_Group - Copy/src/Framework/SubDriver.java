/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Framework;

import java.io.File;

import Libraries.Configuration;
import Libraries.ProjectSpecific;
import TestScripts.TC1_Just_Group_Login;
import TestScripts.TC2_SPManaer_Division_Selection;
import TestScripts.TC3_SPManaer_Store_Selection;
import TestScripts.TC4_SPManaer_Store_Selection2;
import TestScripts.TC5_SPManaer_Store_Selection3;
import jxl.Sheet;
import jxl.Workbook;

public class SubDriver {

	ProjectSpecific ps = new ProjectSpecific();
	public SubDriver ()throws Exception{
		//Constructor	
		}
	public void GetTestScriptName() throws Exception {

		String CSpath = Configuration.ControlScriptPath;
		Workbook w = Workbook.getWorkbook(new File(CSpath));
		Sheet s = w.getSheet(Main.testSuite);
	

		int rc = s.getRows();
		ps.rowCount = rc-1;
		System.out.println("Control Script row count : " + rc);
		try {
			for (int i = 1; i < rc; i++) {
				String executionstatus = s.getCell(2, i).getContents();
				String TestScriptid = s.getCell(0, i).getContents();
				String TestScriptName = s.getCell(1, i).getContents();
				int Tid = Integer.parseInt(TestScriptid);

				System.out.println(Tid);

				if (executionstatus.equalsIgnoreCase("Run")) {
					switch (Tid) {
					case 1:
						System.out.println("*******--TC1 SubDriver--*******");
						Main.Tname = TestScriptName;
						Main.StartSeleniumWD();
						TC1_Just_Group_Login ts1 = new TC1_Just_Group_Login();
						ts1.TC1_SPManager_Access();
						Main.StopSeleniumWD();
						break;
						
					case 2:
						System.out.println("*******--TC2 SubDriver--*******");
						Main.Tname = TestScriptName;
						Main.StartSeleniumWD();
						//TC1_Just_Group_Login ts0 = new TC1_Just_Group_Login();
						//ts0.TC1_SPManager_Access();
						TC2_SPManaer_Division_Selection ts2 = new TC2_SPManaer_Division_Selection();
						ts2.TC2_SPManager_Access();
						Main.StopSeleniumWD();;
						break;
						
					case 3:									
						
					   System.out.println("*******--TC3 SubDriver--*******");
					    Main.Tname = TestScriptName;
						Main.StartSeleniumWD();
						TC3_SPManaer_Store_Selection ts3 = new TC3_SPManaer_Store_Selection();
					    ts3.TC3_SPManaer_Store_Selection1();
						Main.StopSeleniumWD();;
					   break;
					   
					case 4:									
						
						   System.out.println("*******--TC3 SubDriver--*******");
						    Main.Tname = TestScriptName;
							Main.StartSeleniumWD();
							TC4_SPManaer_Store_Selection2 ts4 = new TC4_SPManaer_Store_Selection2();
						    ts4.TC3_SPManaer_Store_Selection1();
							Main.StopSeleniumWD();;
						   break;
						   
					case 5:									
						
						   System.out.println("*******--TC3 SubDriver--*******");
						    Main.Tname = TestScriptName;
							Main.StartSeleniumWD();
							TC5_SPManaer_Store_Selection3 ts5 = new TC5_SPManaer_Store_Selection3();
						    ts5.TC3_SPManaer_Store_Selection1();
							Main.StopSeleniumWD();;
						   break;
//										
//				
					}
					
					
				} else if (executionstatus.equalsIgnoreCase("Ignore")) {
					System.out.println("Execution not started for the TestScript id : "+ Tid);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		w.close();
	}
}