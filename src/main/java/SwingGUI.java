import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class SwingGUI {
    public void GUI() {
        JFrame jfrm = new JFrame("ReportKisser");
        jfrm.setSize(500,500);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.getContentPane().setBackground(Color.white);

//        Builder
        jfrm.add(TitleLabel());
        jfrm.add(ProviderLabel());
        jfrm.add(ProviderDropDown());
        jfrm.setLayout(null);
        jfrm.setVisible(true);
    }

    public JLabel TitleLabel() {
        JLabel jlbl = new JLabel("REPORT KISSER");
        jlbl.setFont(new Font("Lucida Console", Font.BOLD, 25));
        jlbl.setForeground(new Color(	88, 110, 117));
        jlbl.setBounds(150,10,250,80);
        return jlbl;
    }

    public JLabel ProviderLabel() {
        JLabel jlbl = new JLabel("Select Data Provider");
        jlbl.setBounds(155,75,200,25);
        jlbl.setForeground(new Color(	88, 110, 117));
        return jlbl;
    }

    public JComboBox<String> ProviderDropDown() {
        String[] providers = {"HRV", "GRNSW", "GRV"};
        Arrays.sort(providers);
        final JComboBox<String> pDropDown = new JComboBox<>(providers);
        pDropDown.setVisible(true);
        pDropDown.setBounds(155,110,200,25);
        return pDropDown;
    }

    public void SwingFrame() {

    }
    public void ListFonts() {
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for(String font : fonts){
            System.out.println(font);
        }
    }
}
