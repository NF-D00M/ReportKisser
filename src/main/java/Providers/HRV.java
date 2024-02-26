package Providers;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class HRV {
    private String provider = "HRV";

    public void ImportFile() throws IOException {
        System.out.println("Importing Data Provider: " + provider);
        String HRVData = "src/main/resources/ProviderFiles/HRV/HRV_Data_May.xlsx";
        File file = new File(HRVData);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = new XSSFWorkbook(inputStream);
        for (Sheet sheet : workbook) {
//            System.out.println(sheet);
            int firstRow = sheet.getFirstRowNum();
            int lastRow = sheet.getLastRowNum();

            for (int index = firstRow + 1; index <= lastRow; index++) {
                Row row = sheet.getRow(index);
//                System.out.println(row);
                for (int cellIndex = row.getFirstCellNum(); cellIndex < row.getFirstCellNum(); cellIndex++) {
                    Cell cell = row.getCell(cellIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    printCellValue(cell);
                }
            }
        }
//        inputStream.close();
    }

    public static void printCellValue(Cell cell) {
        CellType cellType = cell.getCellType().equals(CellType.FORMULA)
                ? cell.getCachedFormulaResultType()
                : cell.getCellType();
        if (cellType.equals(CellType.STRING)) {
            System.out.println(cell.getStringCellValue() + " | ");
        }
        if (cellType.equals(CellType.NUMERIC)) {
            if (DateUtil.isCellDateFormatted(cell)) {
                System.out.println(cell.getDateCellValue() + " | ");
            } else {
                System.out.println(cell.getNumericCellValue() + " | ");
            }
        }
        if (cellType.equals(CellType.BOOLEAN)) {
            System.out.println(cell.getBooleanCellValue() + " | ");
        }
    }
}
