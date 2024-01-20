package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {
	List<String> subscriber;
	public List<String> getExcelData() throws IOException {
		subscriber=new ArrayList<String>();
		FileInputStream inputStream=new FileInputStream(new File("src/test/resources/excel/subscriber.xlsx"));
		XSSFWorkbook workBook=new XSSFWorkbook(inputStream);
		XSSFSheet sheet=workBook.getSheetAt(0);
		int rowCount=sheet.getLastRowNum() - sheet.getFirstRowNum();
		for(int i=1; i<rowCount+1; i++) {
			Row row=sheet.getRow(i);
			for(int j=0; j<row.getLastCellNum();j++) {
				subscriber.add(row.getCell(j).getStringCellValue());
				System.out.println(row.getCell(j).getStringCellValue());
			}
		}
		
		return subscriber;
	}

}
