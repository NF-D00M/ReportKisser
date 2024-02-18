import javax.swing.*;

public class SwingGUI {
    public void GUI() {
        JFrame jfrm = new JFrame("ReportKisser");
        jfrm.setSize(500,500);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel jlbl = new JLabel("Kiss");
        jfrm.add(jlbl);
        jfrm.setVisible(true);
    }
}
