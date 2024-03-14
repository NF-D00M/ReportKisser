import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        System.out.println("Let's Kiss");

        SwingGUI sg = new SwingGUI();
        ProviderChannel pc = new ProviderChannel();

        sg.addObserver(pc);

        sg.RunGUI();

        ProviderFactory providerFactory = new ProviderFactory();
        Provider provider = providerFactory.getProvider(sg.getProviderName());


//        provider.getProviderName();
//        provider.setTurnover();
//        provider.writeWorkbook();


//        HRV hrv = new HRV();
//        hrv.setTurnover();
//        hrv.writeWorkbook();


    }
}

