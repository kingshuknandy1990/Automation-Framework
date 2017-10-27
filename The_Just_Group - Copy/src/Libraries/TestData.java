package Libraries;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;

public class TestData {
	public static String TestDataPath;
	


	public TestData()throws Exception{
		System.out.println(new File(System.getProperty("user.dir")));
		Workbook w = Workbook.getWorkbook(new File(System.getProperty("user.dir")+"\\TestData\\TestData.xls"));
        Sheet s=w.getSheet("Division");
        TestDataPath=s.getCell(1,0).getContents();
        System.out.println(TestDataPath);
}
}