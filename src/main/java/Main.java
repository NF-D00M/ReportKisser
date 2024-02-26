import Providers.HRV;

public class Main {

    public static void main(String[] args) {
        System.out.println("Let's Kiss");

//        SwingGUI sg = new SwingGUI();
//            sg.GUI();

        HRV hrv = new HRV();
        hrv.ImportFile();

    }
}

