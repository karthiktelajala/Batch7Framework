package genericActions;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFile 
{
	static String data;
	public static String readExcel(String filePath,int sheetNum, int rowNum, int cellNum)
	{
		try
		{
			FileInputStream fis = new FileInputStream(filePath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheetAt(sheetNum);
			Row row = sheet.getRow(rowNum);
			data = row.getCell(cellNum).getStringCellValue();
			wb.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		return data;
	}
	
	public static void writeExcel(String filePath,int sheetNum, int rowNum, int cellNum, String resultData)
	{
		try
		{
			FileInputStream fis = new FileInputStream(filePath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheetAt(sheetNum);
			Row row = sheet.getRow(rowNum);
			Cell cell = row.createCell(cellNum);
			cell.setCellValue(resultData);
			FileOutputStream fos = new FileOutputStream(filePath);
			wb.write(fos);
			wb.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
