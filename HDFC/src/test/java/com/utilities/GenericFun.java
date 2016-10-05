package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class GenericFun {

 public static  ArrayList<String> readExceldata() throws IOException{
		ArrayList<String> names=new ArrayList<String>();
		  String excelFilePath = getProperty("beneficiaries_file_path");
	      FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
	      String[][] arrayExcelData = null;
	      Workbook workbook = new XSSFWorkbook(inputStream);
	      Sheet firstSheet = workbook.getSheetAt(0);
	      int totalRows = firstSheet.getPhysicalNumberOfRows();
	      int totalcol= firstSheet.getRow(1).getPhysicalNumberOfCells();
	      arrayExcelData = new String[totalRows][totalcol];
	      for(int i=1;i<totalRows;i++){
	    	  int totalNumberOfColumns = firstSheet.getRow(i).getPhysicalNumberOfCells();
	    	  for(int j=0;j<totalNumberOfColumns; j++){
	    		  XSSFCell x = (XSSFCell) firstSheet.getRow(i).getCell(j);
	    		     if (x != null) {
	    		      x.setCellType(Cell.CELL_TYPE_STRING);
	    		      //System.out.println(x.getStringCellValue());
	    		      names.add(x.getStringCellValue());
	    		      //arrayExcelData[i][j] = x.getStringCellValue();
	    		     }
	    	  }
	      }
	      return names;
 }


public static String getProperty(String key) throws IOException{
	  Properties obj = new Properties();   
	  //Create Object of FileInputStream Class. Pass file path.
	  FileInputStream objfile = new FileInputStream("/Users/unagase/Documents/Maven Demo/HDFC/path/config.properties");
	  obj.load(objfile);
	  String prop=obj.getProperty(key);
	  return prop;
}

}
