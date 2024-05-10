package Controller;

import org.example.Polinom;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class Controller {
    public ActionListener controlSuma(JTextField t1, JTextField t2, JTextField t3){
        ActionListener suma=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Polinom p1=Polinom.formarePolinom(t1.getText());
                //Polinom p2=Polinom.formarePolinom(t2.getText());

                Polinom p3=Polinom.formarePolinom("");
                p3=Polinom.adunare(t1.getText(),t2.getText());
                t3.setText(p3.afisare());
            }
        };
        return suma;
    }

    public ActionListener controlDiferenta(JTextField t1, JTextField t2, JTextField t3){
        ActionListener diferenta=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Polinom p1=Polinom.formarePolinom(t1.getText());
                //Polinom p2=Polinom.formarePolinom(t2.getText());

                Polinom p3=Polinom.formarePolinom("");
                p3=Polinom.scadere(t1.getText(),t2.getText());
                t3.setText(p3.afisare());
            }
        };
        return diferenta;
    }

    public ActionListener controlInmultire(JTextField t1, JTextField t2, JTextField t3){
        ActionListener inmultire=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Polinom p1=Polinom.formarePolinom(t1.getText());
                //Polinom p2=Polinom.formarePolinom(t2.getText());

                Polinom p3=Polinom.formarePolinom("");
                p3=Polinom.multiplication(t1.getText(),t2.getText());
                t3.setText(p3.afisare());
            }
        };
        return inmultire;
    }

    public ActionListener controlDerivare(JTextField t1, JTextField t3){
        ActionListener derivare=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Polinom p1=Polinom.formarePolinom(t1.getText());
                //Polinom p2=Polinom.formarePolinom(t2.getText());

                Polinom p3=Polinom.formarePolinom("");
                p3=Polinom.derivare(t1.getText());
                t3.setText(p3.afisare());
            }
        };
        return derivare;
    }

    public ActionListener controlIntegrare(JTextField t1, JTextField t3){
        ActionListener integrala=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Polinom p1=Polinom.formarePolinom(t1.getText());
                //Polinom p2=Polinom.formarePolinom(t2.getText());

                //Polinom p3=Polinom.formarePolinom("");
                String p3=Polinom.integrare(t1.getText());
                t3.setText(p3);
            }
        };
        return integrala;
    }

    public ActionListener controlImpartire(JTextField t1, JTextField t2, JTextField t3) {
        ActionListener division = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Polinom p1=Polinom.formarePolinom(t1.getText());
                Polinom p2=Polinom.formarePolinom(t2.getText());

                Polinom p3=Polinom.impartire(t1.getText(), t2.getText());
                Polinom rest=Polinom.scadere(p1.afisare(),Polinom.multiplication(p2.afisare(),p3.afisare()).afisare());
                for(Map.Entry<Integer, Integer> i : rest.getPolinom().entrySet()){
                    System.out.println(i.getValue());
                }
                t3.setText(p3.afisare());

            }
        };
        return division;
    }
}
