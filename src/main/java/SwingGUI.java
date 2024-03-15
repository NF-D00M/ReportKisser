import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class SwingGUI implements Subject {
    private ArrayList<Observer> observers = new ArrayList<>();
    private String selectedProvider;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    @Override
    public void notifyObservers() throws IOException {
        for (Observer observer : observers) {
            observer.update(selectedProvider);
        }
    }

//    Graphical User Interface for GUI

//       Building Frame
    public JFrame RunGUI() {
        JFrame jfrm = new JFrame("ReportKisser");
        jfrm.setSize(500,500);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.getContentPane().setBackground(Color.white);

//        Program Label
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

//        Provider List Combo Box
        String[] providers = {"-", "HRV", "GRNSW", "GRV"};
        Arrays.sort(providers);
        JComboBox<String> pDropDown = new JComboBox<>(providers);
        pDropDown.setBounds(130, 110, 230, 25);
        jfrm.add(pDropDown);

//        Selected Label
        JLabel jSelect = new JLabel("Selected: ", JLabel.CENTER);
        jSelect.setBounds(100,150,230,25);
        jSelect.setForeground(new Color(	88, 110, 117));
        jfrm.add(jSelect);

//        Selected Provider Text
        JTextArea jtxt = new JTextArea();
        jtxt.setBounds(255,153,200,25);
        jtxt.setForeground(new Color(	88, 110, 117));
        pDropDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) pDropDown.getSelectedItem();
//                System.out.println(selected);
                jtxt.setText(selected);
                jfrm.add(jtxt);
            }
        });

//        Generate Report Button
        JButton jbtn = new JButton("Generate Report");
        jbtn.setBounds(130,185,230,25);
        jfrm.add(jbtn);

//        Generating Report Text
        JTextArea generateText = new JTextArea("Test");
        generateText.setBounds(130,250,230,25);
        generateText.setForeground(new Color(	88, 110, 117));
        jfrm.add(generateText);

        jbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) pDropDown.getSelectedItem();
                selectedProvider = selected;
                System.out.println(selectedProvider);

                generateText.setText("Generating Report for Provider: " + selectedProvider);

                System.out.println("Notifying Observers");
                try {
                    notifyObservers();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

//        Frame Layout
        jfrm.setLayout(null);
        jfrm.setVisible(true);
        return jfrm;
    }






}
