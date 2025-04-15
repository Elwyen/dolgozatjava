package org.example.nezet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class MainFrame {
    private JComboBox comboBox;
    private JList List;
    private JButton ujSzoborbtn;
    private JButton atmozgatBtn;
    private JButton masolBtn;
    private JPanel pnlMain;
    private JFrame frame;
    private Konzol konzol;
    public MainFrame(){
        konzol = new Konzol();
        ini();
    }



private void ini()  {
    frame = new JFrame("List es Combo");
    frame.setContentPane(pnlMain);
    frame.setSize(520,240);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);

    DefaultListModel<String> dlm = new DefaultListModel<>();
    List.setModel(dlm);


    JMenuItem mitKilep = new JMenuItem("Kilepes");
    JMenuItem mitBetolt = new JMenuItem("Betoltes");

    JMenu mnuProgram = new JMenu("Program");
    mnuProgram.add(mitBetolt);
    mnuProgram.add(new JSeparator());
    mnuProgram.add(mitKilep);

    JMenuBar bar = new JMenuBar();

    mitKilep.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    });


    bar.add(mnuProgram);
    frame.setJMenuBar(bar);

    frame.setVisible(true);

    ;

}
public static void main(String[] args) {
    new MainFrame();
}
}


