package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	XSSFCell cell;
	XSSFSheet sheet;
	XSSFWorkbook workbook;
	String country;

	// Method for loading the file
	public void readExcel() throws IOException {
		File source = new File("src\\test\\resources\\Exceldata.xlsx");
		FileInputStream file_input = new FileInputStream(source);
		workbook = new XSSFWorkbook(file_input);
	}

	// Method for getting data from excel
	public String Country() throws IOException {
		readExcel();
		sheet = workbook.getSheetAt(0);
		country = sheet.getRow(0).getCell(0).getStringCellValue();
		return country;
	}

}
