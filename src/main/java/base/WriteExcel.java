package base;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	
	public  static void writeExcelResults(String number) throws IOException {
		//Writing data into excel sheet
		 XSSFWorkbook wb = new XSSFWorkbook();
		 XSSFSheet sh= wb.createSheet("Output_Data");
		 Row row1 = sh.createRow(0);

		 //Creating header cell
		 Cell c1 = row1.createCell(0);
		 c1.setCellValue("Total hotel number");
		
		 //Inserting values into cells
		 Row row2 = sh.createRow(1);
		 Cell c3 = row2.createCell(0);
		 c3.setCellValue(number);
		
		 
		 File file = new File("C:\\Users\\ARUP\\eclipse-workspace\\Agoda\\ExcelData\\output.xlsx");
		 FileOutputStream fos = new FileOutputStream(file);
		 wb.write(fos);
		 wb.close();


	  }

}
