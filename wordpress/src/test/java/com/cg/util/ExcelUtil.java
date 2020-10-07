package com.cg.util;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	static String projectPath;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	
	public ExcelUtil(String excelPath, String sheetName ) {
		
		try {
			
			workbook = new XSSFWorkbook(excelPath);
			sheet= workbook.getSheet(sheetName);	
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		
	}
	
	/*public static void main(String[] args) {
		getRowCount();
		getCellDataString(0,0);
		getCellDataNumeric(1,1);
		
		}*/
	public static int getRowCount()
	{
		int rowCount=0;
		try {
			
		 rowCount= sheet.getPhysicalNumberOfRows();
			System.out.println("No of rows"+rowCount);
		} 
		catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return rowCount;

	}
	
	
	public static int getcolCount()
	{
		int colCount=0;
		try {
			
		 colCount= sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("No of cols"+ colCount);
		} 
		catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return colCount;

	}

	public static String getCellDataString(int rowNum,int colNum)
	{
		String cellData=null;
		try {
			
			cellData= sheet.getRow( rowNum).getCell(colNum).getStringCellValue();
			//String cellData1= sheet.getRow(rowNum).getCell( colNum).getStringCellValue();
			//System.out.println(cellData);
			
			//System.out.print(cellData1);

		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
		return cellData;

	}

	public static void getCellDataNumeric(int rowNum,int colNum)
	{
		double cellData;
		try {
			
			cellData= sheet.getRow( rowNum).getCell(colNum).getNumericCellValue();
			//String cellData1= sheet.getRow(rowNum).getCell( colNum).getStringCellValue();
			//System.out.println(cellData);
			
			//System.out.print(cellData1);

		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}

	}

} 

