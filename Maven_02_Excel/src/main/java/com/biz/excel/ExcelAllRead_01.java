package com.biz.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Hello world!
 *
 */
public class ExcelAllRead_01 
{
    public static void main( String[] args )
    {
    	
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
    	int rowIndex = 0;
    	int colIndex = 0;
    	
    	XSSFSheet xSheet = workBook.getSheet("학생정보");
    	
    	int rows = xSheet.getPhysicalNumberOfRows();		// 현재 열린 sheet의 데이터가 저장된 row개수 가져옴
    	for( rowIndex = 0 ; rowIndex < rows; rowIndex ++) {
    		
    		XSSFRow curRow = xSheet.getRow(rowIndex); // 현재 sheet에서 rowIndex위치의 row한줄 읽어옴
    		
    		int cols = curRow.getPhysicalNumberOfCells(); // 현재 row에 데이터가 저장된 column 개수를 가져옴
    		
    		for(colIndex = 0; colIndex < cols ; colIndex++) {
    			
    			XSSFCell cell = curRow.getCell(colIndex);	// 한 칸의 데이터를 가져옴
    			
    			if(cell == null) {
    				continue;
    			
    		}else {
    			System.out.print(cell.toString() + "\t");
    		}
    	}
    	
    	System.out.println();
        
    }
    System.out.println( "Hello World!" );
    }
}
