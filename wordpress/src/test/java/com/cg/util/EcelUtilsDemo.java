package com.cg.util;

public class EcelUtilsDemo {
	public static void main(String[] args) {
	
		String projectPath = System.getProperty("user.dir");
		ExcelUtil excel = new ExcelUtil(projectPath+ "/Excel/data.xlsx" ,"Sheet1");
		
		excel.getRowCount();
		excel.getCellDataNumeric(1, 1);
		excel.getCellDataString(0, 0);
	}

}
