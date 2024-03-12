import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class SwingGUI {

    String selected;

    public JFrame RunGUI() {
        JFrame jfrm = new JFrame("ReportKisser");
        jfrm.setSize(500,500);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.getContentPane().setBackground(Color.white);

//        Builder
        JLabel jtitle = new JLabel("REPORT KISSER");
        jtitle.setFont(new Font("Lucida Console", Font.BOLD, 25));
        jtitle.setForeground(new Color(	88, 110, 117));
        jtitle.setBounds(152,10,250,80);
        jfrm.add(jtitle);

        JLabel jprovider = new JLabel("Select Data Provider", JLabel.CENTER);
        jprovider.setBounds(155,75,200,25);
        jprovider.setForeground(new Color(	88, 110, 117));
        jfrm.add(jprovider);

        String[] providers = {"-", "HRV", "GRNSW", "GRV"};
        Arrays.sort(providers);
        JComboBox<String> pDropDown = new JComboBox<>(providers);
        pDropDown.setBounds(155, 110, 200, 25);
        jfrm.add(pDropDown);

        JTextArea jLabel = new JTextArea();
        jLabel.setBounds(280,153,200,25);
        jLabel.setForeground(new Color(	88, 110, 117));
        pDropDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) pDropDown.getSelectedItem();
                System.out.println(selected);
                jLabel.setText(selected);
                jfrm.add(jLabel);
            }
        });

        JLabel jSelect = new JLabel("Selected: ", JLabel.CENTER);
        jSelect.setBounds(125,150,200,25);
        jSelect.setForeground(new Color(	88, 110, 117));
        jfrm.add(jSelect);

        JButton jbtn = new JButton("Generate Report");
        jbtn.setBounds(155,185,200,25);
        jfrm.add(jbtn);

        jfrm.setLayout(null);
        jfrm.setVisible(true);
        return jfrm;
    }






}
