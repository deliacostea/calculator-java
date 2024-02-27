package org.example.GUI;

import org.example.Logic.Operatii;
import org.example.Model.Monom;
import org.example.Model.Polinom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Interfata {
    private  JFrame f;
    private  JLabel p1;
    private  JLabel p2;
    private JLabel r1;
    private   JLabel nume;
    private  JTextField pol1;
    private  JTextField pol2;
    private JTextField rez;
    private JButton ad;
    private JButton sc;
    private JButton mul;
    private JButton imp;
    private  JButton der;
    private JButton integ;

    public static Monom stringToMonom(String s) {
       Pattern pattern = Pattern.compile("([+-]?\\d*)(?:x(?:\\^(\\d+))?)?");
        Matcher matcher = pattern.matcher(s);

        // extrage coeficientul si exponentul
        int coeficient = 0;
        int exponent = 0;
        if (matcher.matches()) {
            String coefStr = matcher.group(1);
            String expStr = matcher.group(2);
            if (coefStr != null && !coefStr.isEmpty()) {
                coeficient = Integer.parseInt(coefStr);
            }
            if (expStr != null && !expStr.isEmpty()) {
                exponent = Integer.parseInt(expStr);
            }
        }
        return new Monom(exponent, coeficient);
    }


    public static boolean stringParse(String s, Polinom p) {

        Pattern pattern1 = Pattern.compile("\\b(?:[+-]?\\d*x\\^\\d+|[+-]?\\d*x|[+-]?\\d+)\\b(?!x)");
        Matcher m = pattern1.matcher(s);
        String txt="";

        while(m.find()) {
            txt+=m.group();
            String monomStr = m.group();
            Monom monom1 = stringToMonom(monomStr);
            p.addMonom(monom1);

        }
        if(txt.equals(s))
        {
            return true;
        }
        else
            return false;
    }
    public JFrame getF() {
        return f;
    }

    public String  getPol1() {
        return pol1.getText();
    }

    public String getPol2() {
        return pol2.getText();
    }

    public void setRez(String s) {
        rez.setText(s);
    }
    void addAddListener(ActionListener adu) {
        ad.addActionListener(adu);
    }
    void addScdListener(ActionListener scd) {
        sc.addActionListener(scd);
    }
    void addMulListener(ActionListener mul1) {
        mul.addActionListener(mul1);
    }
    void addImpListener(ActionListener imp1) {
        imp.addActionListener(imp1);
    }

    void addDerListener(ActionListener de) {
        der.addActionListener(de);
    }
    void addIntListener(ActionListener in) {
        integ.addActionListener(in);
    }

    public Interfata()
    {

        f = new JFrame("Calculator");f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(575, 220, 400, 550);
        nume = new JLabel("Calculator");
        nume.setBounds(120,0,200,50);
        nume.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        p1 = new JLabel("Polinom1: ");
        p1.setBounds(30, 70, 200, 50);
        p1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        pol1 =new JTextField("2x^4+1x^3+2x^2+1");
        pol1.setBounds(150, 80, 200, 30);
        pol1.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        p2 = new JLabel("Polinom2: ");
        p2.setBounds(30, 130, 200, 50);
        p2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        pol2 =new JTextField("1x^4+3x^1+5");
        pol2.setBounds(150, 140, 200, 30);
        pol2.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        r1 = new JLabel("Rezultat: ");
        r1.setBounds(30, 190, 200, 50);
        r1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        rez =new JTextField();
        rez.setBounds(150, 200, 200, 30);
        rez.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        ad=new JButton("Adunare");
        ad.setBounds(30,260,150,50);
        ad.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        sc=new JButton("Scadere");
        sc.setBounds(200,260,150,50);
        sc.setFont(new Font("Times New Roman", Font.PLAIN, 20));


        mul=new JButton("Inmultire");
        mul.setBounds(30,340,150,50);
        mul.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        imp=new JButton("Impartire");
        imp.setBounds(200,340,150,50);
        imp.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        der=new JButton("Derivare");
        der.setBounds(30,420,150,50);
        der.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        integ=new JButton("Integrare");
        integ.setBounds(200,420,150,50);
        integ.setFont(new Font("Times New Roman", Font.PLAIN, 20));

        f.add(nume);
        f.add(p1);
        f.add(pol1);
        f.add(p2);
        f.add(pol2);
        f.add(r1);
        f.add(rez);
        f.add(ad);
        f.add(sc);
        f.add(mul);
        f.add(imp);
        f.add(der);
        f.add(integ);
        f.setLayout(null);
        f.setVisible(true);

        ad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             String p1=getPol1();
             String p2=getPol2();
             Polinom m1=new Polinom();
             Polinom m2=new Polinom();
             if(stringParse(p1,m1)&&stringParse(p2,m2))
             {
                 Polinom rezPoli= Operatii.add_Polinoame(m1,m2);
                 rez.setText(rezPoli.toString());
             }
             else
                 JOptionPane.showMessageDialog(f,"input incorect");
            }
        });


        sc.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String p1=getPol1();
            String p2=getPol2();
            Polinom m1=new Polinom();
            Polinom m2=new Polinom();
            if(stringParse(p1,m1)&&stringParse(p2,m2))
            {
                Polinom rezPoli= Operatii.sub_Polinoame(m1,m2);
                rez.setText(rezPoli.toString());
            }
            else
                JOptionPane.showMessageDialog(f,"input incorect");
        }
    });


        mul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p1=getPol1();
                String p2=getPol2();
                Polinom m1=new Polinom();
                Polinom m2=new Polinom();
                if(stringParse(p1,m1)&&stringParse(p2,m2))
                {
                    Polinom rezPoli= Operatii.multipli_Polinoame(m1,m2);
                    rez.setText(rezPoli.toString());
                }
                else
                    JOptionPane.showMessageDialog(f,"input incorect");
            }
        });


      imp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p1=getPol1();
                String p2=getPol2();
                Polinom m1=new Polinom();
                Polinom m2=new Polinom();
                if(stringParse(p1,m1)&&stringParse(p2,m2))
                {
                    Polinom[] rezPoli= Operatii.divi_Polinoame(m1,m2);
                    rez.setText(" Q=" + rezPoli[0].toString() +" R= "+ rezPoli[1].toString());
                }
                else
                    JOptionPane.showMessageDialog(f,"input incorect");
            }
        });


        der.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p1=getPol1();
                Polinom m1=new Polinom();
                if(stringParse(p1,m1))
                {
                    Polinom rezPoli= Operatii.deriv(m1);
                    rez.setText(rezPoli.toString());
                }
                else
                    JOptionPane.showMessageDialog(f,"input incorect");
            }
        });

        integ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String p1=getPol1();
                Polinom m1=new Polinom();
                if(stringParse(p1,m1))
                {
                    Polinom rezPoli= Operatii.integ(m1);
                    rez.setText(rezPoli.toString());
                }
                else
                    JOptionPane.showMessageDialog(f,"input incorect");
            }
        });
    }

}