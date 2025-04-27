package wsUtilities;


import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WsExcelUtils {
	
	public static int getRowCount(String xl, String Sheet)
	{
		try
		{
			// File f = new File(xl);
			FileInputStream fi = new FileInputStream(xl);  // to open a file path
			@SuppressWarnings("resource")
			XSSFWorkbook wb = new XSSFWorkbook(fi);     	   // to open sheet
			
			return wb.getSheet(Sheet).getLastRowNum(); //to count no of rows and return back the value(test cls rowcount)
		}
		catch (Exception e)
		{
			return 0; //return a default value (zero) when an error occurs.
		}
	    
	
	}
	
	
	
	public static String getCellValString(String xl, String Sheet, int r, int c)
	{
		try
		{
			FileInputStream	fi	= new FileInputStream(xl);
			@SuppressWarnings("resource")
			XSSFWorkbook wb = new XSSFWorkbook(fi);
			
			XSSFCell cell = wb.getSheet(Sheet).getRow(r).getCell(c); //Locate cell
			if(cell.getCellType() == CellType.STRING)   //Checking whether values in the excel is String or numeric
			{
				return cell.getStringCellValue();
			}
			else
			{
				
				return cell.getRawValue();
			}
		}
		catch(Exception e)
		{
			return "";
		}
	}
	
}
	
