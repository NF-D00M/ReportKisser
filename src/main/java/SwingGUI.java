import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.Arrays;

public class SwingGUI {

    private String SelectedProvider;

    private ArrayList<Channel> channels = new ArrayList<>();

    public void addObserver(Channel channel) {
        this.channels.add(channel);
    }

    public void removeObserver(Channel chennel) {
        this.channels.remove(chennel);
    }

    public void setProviderName(String providerName) {
        this.SelectedProvider = providerName;
        for (Channel channel : this.channels) {
            channel.update(this.SelectedProvider);
        }
    }

    public String getProviderName() {
        System.out.println(this.SelectedProvider);
        return this.SelectedProvider;
    }

    public JFrame RunGUI() {
        JFrame jfrm = new JFrame("ReportKisser");
        jfrm.setSize(500,500);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.getContentPane().setBackground(Color.white);

//        Program Title
        JLabel jtitle = new JLabel("REPORT KISSER", JLabel.CENTER);
        jtitle.setFont(new Font("Lucida Console", Font.BOLD, 25));
        jtitle.setForeground(new Color(	88, 110, 117));
        jtitle.setBounds(130,10,230,80);
        jfrm.add(jtitle);

//        Select Provider Label
        JLabel jprovider = new JLabel("Select Data Provider", JLabel.CENTER);
        jprovider.setBounds(130,75,230,25);
        jprovider.setForeground(new Color(	88, 110, 117));
        jfrm.add(jprovider);

//        Provider List
        String[] providers = {"-", "HRV", "GRNSW", "GRV"};
        Arrays.sort(providers);
        JComboBox<String> pDropDown = new JComboBox<>(providers);
        pDropDown.setBounds(130, 110, 230, 25);
        jfrm.add(pDropDown);

        JLabel jSelect = new JLabel("Selected: ", JLabel.CENTER);
        jSelect.setBounds(100,150,230,25);
        jSelect.setForeground(new Color(	88, 110, 117));
        jfrm.add(jSelect);

//        Selected Provider
        JTextArea jtxt = new JTextArea();
        jtxt.setBounds(255,153,200,25);
        jtxt.setForeground(new Color(	88, 110, 117));
        pDropDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) pDropDown.getSelectedItem();
                System.out.println(selected);
                jtxt.setText(selected);
                jfrm.add(jtxt);
            }
        });

//        Generate Button
        JButton jbtn = new JButton("Generate Report");
        jbtn.setBounds(130,185,230,25);
        jfrm.add(jbtn);

        JTextArea generateText = new JTextArea("Test");
        generateText.setBounds(130,250,230,25);
        generateText.setForeground(new Color(	88, 110, 117));
        jfrm.add(generateText);

        jbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) pDropDown.getSelectedItem();
                SelectedProvider = selected;
                System.out.println(SelectedProvider);

                generateText.setText("Generating Report for Provider: " + SelectedProvider);

            }
        });




//        Frame Layout
        jfrm.setLayout(null);
        jfrm.setVisible(true);
        return jfrm;
    }






}
