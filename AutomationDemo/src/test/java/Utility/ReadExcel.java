package Utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Constants.Constants;

public class ReadExcel {
	
	
	public String fetchCellValue(int row, int col){

		String S = null;
		try {
		FileInputStream fis = new FileInputStream(Constants.TEST_DATA_FILE_PATH);
		Workbook wb = new XSSFWorkbook(fis);

		Cell c = wb.getSheet("Sheet1").getRow(row).getCell(col);
		S = c.getStringCellValue();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return S;
		
	}

}
