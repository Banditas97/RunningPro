package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException
	{
		//Open the doc in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		//Create a workbook 
		Workbook file = WorkbookFactory.create(fis);
		//navigate to required sheet
		Sheet st = file.getSheet("Organization");
		//Navigate to required Row
		Row row = st.getRow(0);
		//Navigate to required cell
		Cell cell = row.getCell(1);
		//Capture the data/value in the cell
		String value = cell.getStringCellValue();
		System.out.println(value);
	}

}
