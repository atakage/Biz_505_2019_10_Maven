package com.biz.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSRead_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

    	String exFile = "src/main/java/com/biz/excel/GRADE_학생정보(2019-10-10).xlsx";
    	
    	
    	FileInputStream fis = null;
    	
    	XSSFWorkbook workBook = null;
    	
    	try {
			fis = new FileInputStream(exFile);
			workBook = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	XSSFSheet xSheet = workBook.getSheet("학생정보");
    	
    	XSSFRow curRow = xSheet.getRow(5);		//학생정보 sheet 5, 1번째(0번째붙부터) 셀의 값을 읽음
    	
    	XSSFCell curCell = curRow.getCell(1);
    	
    	if(curCell != null) {
    		System.out.println(curCell.toString());
    	}
	}

}
