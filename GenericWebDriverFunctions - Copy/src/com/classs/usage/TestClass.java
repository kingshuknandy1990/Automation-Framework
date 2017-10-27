package com.classs.usage;
//Main class for test execution 
//Comment2
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.GenericFunctions.WebDriver.GenericWebDriverFunctions;
import com.Pages.AllBealls.PopUpPage;
import com.Pages.AllBealls.ProductDisplayPage;
import com.Pages.AllBealls.SearchDisplayPage;
import com.bealls.pojo.Sheet;
import com.bealls.videorecording.VideoRecord;
import com.excellibrary.bealls.ExcelLibrary;
import com.relevantcodes.extentreports.ExtentReports;
import com.reports.beallsCustom.CustomReporter;

public class TestClass {
	public static SearchDisplayPage sdp = null;
	public static PopUpPage pup = null;
	public static ProductDisplayPage pdp = null;
	public static ArrayList<String> classes = null;
	public static Class cls = null;
	public static ExtentReports report = null;
	public static int cellNo;

	public static ExcelLibrary excel = null;
	public static VideoRecord recorder = null;
	public static void main(String[] args) throws InterruptedException	 {

		recorder = new VideoRecord();
		
		try {
//			FileUtils.cleanDirectory(new File(System.getProperty("user.dir")+"\\utility\\screenshots\\")); 
			//FileUtils.cleanDirectory(new File(System.getProperty("user.dir")+"\\utility\\"));
			excel = new ExcelLibrary(System.getProperty("user.dir")+"\\Bealls_Execution_Excel.xlsx");

			String driver = (String) excel.getCellData("TestData", 0, 1);
			String url = (String) excel.getCellData("TestData", 1, 1);
			report = new ExtentReports("TestExecutionReport.html");
			
			recorder.startRecording();
			GenericWebDriverFunctions.loadDriver(driver);
			GenericWebDriverFunctions.startServer(url);

//			sdp = new SearchDisplayPage();
//			pup = new PopUpPage();
//			pdp = new ProductDisplayPage();
			getAllClasses(System.getProperty("user.dir")
					+ "\\src\\com\\Pages\\AllBealls\\");
			executeMethods();

			Thread.sleep(500);
			GenericWebDriverFunctions.stopServer();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void getAllClasses(String path) {
		classes = new ArrayList<String>();
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				// System.out.println(listOfFiles[i].getName().substring(0,
				// listOfFiles[i].getName().indexOf(".")));
				classes.add(listOfFiles[i].getName().substring(0,
						listOfFiles[i].getName().indexOf(".")));

			}
		}
	}

	public static void executeMethods() {

 
		
		System.out.println("executeMethod() start");
		Sheet.setTestCases();
		System.out.println("executeMethods()------------");
		List<ArrayList<String>> tcs = Sheet.getPaths();
		
		
		 
		
			int rowCount = tcs.size();
			 
		 	for (int counter1 = 0; counter1 < rowCount; counter1++) {
				 	 
		 		ArrayList<String> paths = tcs.get(counter1);
		 		String[] stockArr = new String[paths.size()];
		 		
				 
//		for (int dataCounter = 1; dataCounter < colCount; dataCounter++) {
				
				CustomReporter reporter = new CustomReporter();
//				cellNo = dataCounter;
				
				 
				String ar[] = new String[paths.size()];
				ar = paths.toArray(ar);
				
				String methods[] = ar;
				Class noParams[] = {};
				CustomReporter.currentTestCase = methods[0];
				System.out.println("/***********Currently executing "+CustomReporter.currentTestCase);
				if(methods[1]!=null && methods[1].equalsIgnoreCase("yes") )
				{
				// Code to check critical path entries from excel sheet
				// for(int counter2=0;counter2<methods.length;counter2++)
				// {
				// System.out.println(methods[counter2]);
				// }

				for (int counter2 = 0; counter2 < methods.length; counter2++) {
					for (int counter3 = 0; counter3 < classes.size(); counter3++) {
						try {
							cls = Class.forName("com.Pages.AllBealls."
									+ classes.get(counter3));
							Method method;
							Object obj = cls.newInstance();
							//System.out.println("Class Name - "+cls);

							invokeMethod(methods[counter2]);

						} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SecurityException
								| IllegalArgumentException e) {
							e.printStackTrace();
						}

					}
				}

		 
//		}
			}
			 
		}
			
			try {
				recorder.stopRecording();
			} catch (Exception e) {
				 System.out.println("Test exception");
				e.printStackTrace();
			}
	}

	public static void invokeMethod(String methodName) {

		Method[] ar = cls.getDeclaredMethods();
		Method method = null;
		for (int counter = 0; counter < ar.length; counter++) {

			try {
				if (ar[counter].toString().contains(methodName)) {

					try {
						//System.out.println("The Function found @ "+cls);
						method = cls.getDeclaredMethod(methodName, null);
						method.invoke("", null);
						break;
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			} catch (Exception e) {
				// System.out.println(e.getMessage());
			}
		}

	}

}