import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class HRV implements Provider {
    private String Provider;
    public double FONet;
    public double ToteNet;

    public HRV(String provider) {
        this.Provider = provider;
    }

    @Override
    public String getProviderName() {
        System.out.println(Provider);
        return Provider;
    }

    @Override
    public Workbook readWorkbook() throws IOException {
        String fileLocation = "src/main/resources/ProviderFiles/HRV/HRV_Data_May.xlsx";
        Workbook workbook = new XSSFWorkbook(fileLocation);
        return workbook;
    }

    @Override
    public void setTurnover() throws IOException {
        System.out.println("Retrieving Turnover for: " + Provider);
        readWorkbook();
        Sheet sheet = readWorkbook().getSheetAt(0);
        for (Row row : sheet) {
//            Get Row that Contains Total Turnover
            if (row.getCell(0).getStringCellValue().equals("Total Turnover")) {
                System.out.println(row.getCell(0));
//                Fixed Odds Net Turnover
                FONet = row.getCell(6).getNumericCellValue();
//                Tote Net Turnover
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

    @Override
    public void writeWorkbook() throws IOException {
        System.out.println("Opening HRV Template");
        String fileLocation = "src/main/resources/ProviderFiles/HRV/HRV_Template.xlsx";
        InputStream inputStream = new FileInputStream(fileLocation);
        Workbook workbook = WorkbookFactory.create(inputStream);
        Sheet sheet = workbook.getSheetAt(0);

//        Write Fixed Odds Turnover
        System.out.println("Writing Fixed Odds Net Turnover");
        Row foRow = sheet.getRow(18);
        Cell foCell = foRow.getCell(2);
        foCell.setCellValue(getFixedOddsNetTurnover());

//        Write Tote Derivative Turnover
        Row toteRow = sheet.getRow(19);
        System.out.println("Writing Tote Derivative Turnover");
        Cell toteCell = toteRow.getCell(2);
        toteCell.setCellValue(getToteNetTurnover());

        try (OutputStream fileOut = new FileOutputStream(fileLocation)) {
            workbook.write(fileOut);
        };
    }


}
