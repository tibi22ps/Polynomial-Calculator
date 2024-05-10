package Interfata;

import Controller.Controller;

import javax.swing.*;

public class Calcuator extends JFrame{
    private JPanel calculator;
    private JTextField textField1;
    private JTextField textField2;
    private JButton sumaButton;
    private JButton diferentaButton;
    private JButton inmultireButton;
    private JButton integralaButton;
    private JButton derivataButton;
    private JTextField textField3;
    private JButton impartireButton;

    public Calcuator(){
        setContentPane(calculator);
        setTitle("Calculator Polinoame");
        setSize(600, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        Controller butoane=new Controller();
        sumaButton.addActionListener(butoane.controlSuma(textField1, textField2, textField3));
        diferentaButton.addActionListener(butoane.controlDiferenta(textField1,textField2,textField3));
        inmultireButton.addActionListener(butoane.controlInmultire(textField1,textField2,textField3));
        derivataButton.addActionListener(butoane.controlDerivare(textField1,textField3));
        integralaButton.addActionListener(butoane.controlIntegrare(textField1,textField3));
        impartireButton.addActionListener(butoane.controlImpartire(textField1,textField2,textField3));



    }
}
