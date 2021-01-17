package com.atqa2020.framework.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class ExcelReader {

    public String path;
    public FileInputStream fileInputStream = null;
    private XSSFWorkbook workbook = null;
    private XSSFCell cell;
    private XSSFRow row;

    public ExcelReader (String path) {
        this.path = path;
        try {
            fileInputStream = new FileInputStream(path);
            workbook = new XSSFWorkbook(fileInputStream);
            fileInputStream.close();
        } catch (Exception ex) {
            Helper.Logger.LogError("Data file wasn't loaded", ex);
        }
    }

    public int getRowCount(String sheetName) {
        return workbook.getSheet(sheetName).getPhysicalNumberOfRows();
    }

    public int getColumnCount(String sheetName) {
        return workbook.getSheet(sheetName).getRow(0).getLastCellNum();
    }

    public Object getCellData(String sheetName, int colNumber, int rowNumber) {
        return getCellData(workbook.getSheet(sheetName).getRow(rowNumber).getCell(colNumber));
    }

    public void setCellData(String sheetName, int colNumber, ArrayList<String> results) {

        try {
            for (int i=0; i < results.size(); i++) {
                row = workbook.getSheet(sheetName).getRow(i+1);
                cell = row.createCell(colNumber);
                Helper.Logger.LogInfo(results.get(i));
                cell.setCellValue(results.get(i));
            }

            FileOutputStream fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        } catch (Exception ex) {
            Helper.Logger.LogError("Couldn't write to Excel file", ex);
        }
    }

    private Object getCellData(Cell cell) {
        switch (cell.getCellType()) {
            case BOOLEAN:
                return cell.getBooleanCellValue();
            case STRING:
                return cell.getRichStringCellValue().getString();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue();
                } else {
                    return cell.getNumericCellValue();
                }
            case FORMULA:
                return cell.getCellFormula();
            default:
                return null;
        }
    }
}
