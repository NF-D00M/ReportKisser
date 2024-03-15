import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        System.out.println("Let's Kiss");

//        Run GUI
        SwingGUI swingGUI = new SwingGUI();
        swingGUI.RunGUI();

//        Assign Observer (Provider Factory observes GUI)
        Observer providerObserver = new ProviderFactory();
        swingGUI.addObserver(providerObserver);
    }
}

