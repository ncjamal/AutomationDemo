package Utilities;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
    public static Object[][] getExcelData(String filePath, String sheetName) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
            int colCount = sheet.getRow(0).getLastCellNum();

            Object[][] data = new Object[rowCount][colCount];

            for (int i = 1; i <=rowCount; i++) {
            	Row row = sheet.getRow(i);
                for (int j = 0; j < colCount; j++) {
                	Cell cell = row.getCell(j);
                    data[i-1][j] = cell.toString();
                }
                }

            workbook.close();
            fis.close();
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String GetData(String filepath, String sheetname, int rownum, int colnum)
    {
    	String value="";
    	try
    	{
    		FileInputStream fis = new FileInputStream(filepath);
    		Workbook wk = new XSSFWorkbook(fis);
    		Sheet sheet = wk.getSheet(sheetname);    		
    		value = sheet.getRow(rownum).getCell(colnum).getStringCellValue();
    		wk.close();
    		fis.close();	
    	}
    	catch(Exception e)
    	{
    		System.out.println("Exception occured: "+e.getMessage());
    	}
		return value;
    }
}