import javax.swing.*;
import java.awt.*;

public class SwingGUI {
    public void GUI() {
        JFrame jfrm = new JFrame("ReportKisser");
        jfrm.setSize(500,500);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        Label
        JLabel jlbl = new JLabel("REPORT KISSER");
        jlbl.setFont(new Font("Lucida Console", Font.BOLD, 22));

//        Drop Down

//        Builder
        jfrm.add(jlbl);
        jfrm.setLayout(null);
        jfrm.setVisible(true);
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
