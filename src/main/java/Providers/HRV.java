package Providers;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class HRV {
    private String Provider = "HRV";
    public double FONet;
    public double ToteNet;

    public Workbook readWorkbook() throws IOException {
        String fileLocation = "src/main/resources/ProviderFiles/HRV/HRV_Data_May.xlsx";
        Workbook workbook = new XSSFWorkbook(fileLocation);
        return workbook;
    }

    public void setTurnover() throws IOException {
        System.out.println("Retrieving Turnover for: " + Provider);
        readWorkbook();
        Sheet sheet = readWorkbook().getSheetAt(0);
        for (Row row : sheet) {
//            Get Row that Contains Total Turnover
            if (row.getCell(0).getStringCellValue().equals("Total Turnover")) {
                System.out.println(row.getCell(0));
                FONet = row.getCell(6).getNumericCellValue();
                ToteNet = row.getCell(10).getNumericCellValue();
                System.out.println("Setting Fixed Odds Net Turnover to: " + FONet);
                System.out.println("Setting Tote Net Turnover to: " + ToteNet);
                break;
            }
        }
    }

    public double getFixedOddsNetTurnover() {
        return FONet;
    }

    public double getToteNetTurnover() {
        return ToteNet;
    }
}
