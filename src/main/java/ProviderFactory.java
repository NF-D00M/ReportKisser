import javax.swing.*;
import java.io.IOException;

public class ProviderFactory implements Observer {
    private String providerName;
    Provider provider;

    @Override
    public void update(String providerName) throws IOException {
        this.providerName = providerName;
        System.out.println("Provider Factory Creating: " + providerName);
        constructProvider(providerName);
        processData();
    }

    public void constructProvider(String providerName) {
        if (providerName == null) {
            System.out.println("Provider does not exist...");
        }
        if (providerName.equalsIgnoreCase("HRV")) {
            provider = new HRV("HRV");
        }
        else if (providerName.equalsIgnoreCase("GRV")) {
//            provider = new GRV("GRV");
        }
    }

    public void processData() throws IOException {
        System.out.println("Processing Data");
        provider.getProviderName();
        provider.setTurnover();
        provider.writeWorkbook();
    }











}
