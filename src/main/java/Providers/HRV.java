package Providers;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;


public class HRV {
    private String provider = "HRV";

    public void getTurnover() throws IOException {
        System.out.println("Retrieving Turnover for: " + provider);
        String fileLocation = "src/main/resources/ProviderFiles/HRV/HRV_Data_May.xlsx";
        Workbook workbook = new XSSFWorkbook(fileLocation);
        Sheet sheet = workbook.getSheetAt(0);
        for (Row row : sheet) {
            if (row.getCell(0).getStringCellValue().equals("Total Turnover")) {
                System.out.println(row.getCell(0));

                int FixedOddsNetTurnover = (int) row.getCell(6).getNumericCellValue();
                int ToteNetTurnover = (int) row.getCell(10).getNumericCellValue();
                System.out.println(FixedOddsNetTurnover);
                System.out.println(ToteNetTurnover);
                break;
            }
        }
    }
}
