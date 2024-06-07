package Practice;

import java.io.IOException;

import Common_Utilities.ExcelFileUtility;
import Common_Utilities.PropertyFileUtility;

public class ReadingDataFromMainJava {

	public static void main(String[] args) throws IOException {
		PropertyFileUtility p = new PropertyFileUtility();
		String url = p.toReadDataFromPropeetyFile("url");
		
		ExcelFileUtility e= new ExcelFileUtility();
		String value = e.toReadExcelFileUtility("contacts", 1, 2);
	System.out.print(url);
	System.out.println(value);
	
	}
	}
