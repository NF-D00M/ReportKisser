import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class SwingGUI {

    String selected;

    public void GUI() {
        JFrame jfrm = new JFrame("ReportKisser");
        jfrm.setSize(500,500);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.getContentPane().setBackground(Color.white);

//        Builder
        jfrm.add(TitleLabel());
        jfrm.add(ProviderLabel());
        jfrm.add(ProviderDropDown());
        jfrm.add(GenerateReport());
        jfrm.setLayout(null);
        jfrm.setVisible(true);
    }

    public JLabel TitleLabel() {
        JLabel jlbl = new JLabel("REPORT KISSER");
        jlbl.setFont(new Font("Lucida Console", Font.BOLD, 25));
        jlbl.setForeground(new Color(	88, 110, 117));
        jlbl.setBounds(152,10,250,80);
        return jlbl;
    }

    public JLabel ProviderLabel() {
        JLabel jlbl = new JLabel("Select Data Provider", JLabel.CENTER);
        jlbl.setBounds(155,75,200,25);
        jlbl.setForeground(new Color(	88, 110, 117));
        return jlbl;
    }

    public JComboBox<String> ProviderDropDown() {
        String[] providers = {"HRV", "GRNSW", "GRV"};
        Arrays.sort(providers);
        final JComboBox<String> pDropDown = new JComboBox<>(providers);
        pDropDown.setBounds(155,110,200,25);
//        System.out.println(pDropDown.getSelectedItem());
        pDropDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selected = (String) pDropDown.getSelectedItem();
                System.out.println(selected);
            }
        });
        return pDropDown;
    }

    public String getSelected() {
        System.out.println(selected);
        return selected;
    }



    public JButton GenerateReport() {
        JButton jbtn = new JButton("Generate Report");
        jbtn.setBounds(155,150,200,25);
        return jbtn;
    }


    public void ListFonts() {
        String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for(String font : fonts){
            System.out.println(font);
        }
    }
}
