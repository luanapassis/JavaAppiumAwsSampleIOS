package com.javaAppiumIOS.utils;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile{
    XSSFWorkbook work_book;
    XSSFSheet sheet;
    public ReadExcelFile(String excelfilePath) {
        try {
            File s = new File(excelfilePath);
            FileInputStream stream = new FileInputStream(s);
            work_book = new XSSFWorkbook(stream);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public String getData(int sheetnumber, int row, int column){
        DataFormatter formatter = new DataFormatter();
        String data=null;
        sheet = work_book.getSheetAt(sheetnumber);
        //String data = sheet.getRow(row).getCell(column).getStringCellValue();
//        if(sheet.getRow(row).getCell(column).getCellType()== CellType.STRING)
//            data = sheet.getRow(row).getCell(column).getStringCellValue();
//        else if(sheet.getRow(row).getCell(column).getCellType()==CellType.NUMERIC)
//            data = String.valueOf(sheet.getRow(row).getCell(column).getNumericCellValue());
        data = formatter.formatCellValue(sheet.getRow(row).getCell(column));

        return data;
    }
    public int getRowCount(int sheetIndex){
        int row = work_book.getSheetAt(sheetIndex).getLastRowNum();
        row = row + 1;
        return row;
    }
}
