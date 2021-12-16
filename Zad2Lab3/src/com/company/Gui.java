package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Gui  extends  JFrame{
    private JTextField liczba1;
    private JTextField liczba2;
    private JTextField wynik;
    private JList operator;
    private JPanel cont;
    private JButton oblicz;
    private JButton wyczysc;


    public Gui() {
        super("KALK");
        this.setContentPane(cont);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        setLayout(null);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object select = e.getSource();
if(select==oblicz) {
    if (operator.getSelectedValue() == "d"){
        int a= Integer.parseInt(liczba1.getText());
        int b= Integer.parseInt(liczba2.getText());
           int c= a/b;
        wynik.setText(""+c);
    }else if (operator.getSelectedValue() == "m"){
        int a= Integer.parseInt(liczba1.getText());
        int b= Integer.parseInt(liczba2.getText());
        int c= a*b;
        wynik.setText(""+c);
    }
}else if(select==wyczysc){
    wynik.setText("");
    liczba1.setText("");
    liczba2.setText("");
}
            }


        };

        oblicz.addActionListener(listener);
        wyczysc.addActionListener(listener);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(null,
                        "czy na pewno chcesz wyjsc", "Pytanie",
                        JOptionPane.YES_NO_OPTION);

                if (confirmed == JOptionPane.YES_OPTION) {
                    dispose();
                }else {
                   setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                }
            }
        });
    }

    public static void main(String[] args) {
        Gui kalku = new Gui();
        kalku.setVisible(true);
    }
}
