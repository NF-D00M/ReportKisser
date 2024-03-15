import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        System.out.println("Let's Kiss");

        SwingGUI swingGUI = new SwingGUI();
        swingGUI.RunGUI();

        Observer providerObserver = new ProviderFactory();
        swingGUI.addObserver(providerObserver);


//        Provider provider = providerFactory.getProvider(sg.getProviderName());


//        provider.getProviderName();
//        provider.setTurnover();
//        provider.writeWorkbook();


//        HRV hrv = new HRV();
//        hrv.setTurnover();
//        hrv.writeWorkbook();


    }
}

