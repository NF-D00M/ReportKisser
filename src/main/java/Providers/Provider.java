package Providers;

import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;

public interface Provider {
    String getProviderName();
    Workbook readWorkbook() throws IOException;
    void setTurnover() throws IOException;
    void writeWorkbook() throws IOException;
}
