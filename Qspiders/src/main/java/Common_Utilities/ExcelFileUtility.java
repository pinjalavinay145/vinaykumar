package Common_Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	
	 public String toReadExcelFileUtility(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException {
		 FileInputStream fis = new FileInputStream(Iconstant_Utility.excelFilePath);
		 Workbook workbook = WorkbookFactory.create(fis);
		String value = workbook.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
	    return value;
	}

}
