/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Kasino;

import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Ninja
 */
public class Peli666 {
    private int pisteet;
    String asd;
    
    public void startpeli() {
        String[] Kysymys = {"Mikä on Niinistön koiran nimi?", "Minä vuonna on seuraava karkausvuosi?","Mikä on Kiinan pääkaupunki?","Kuinka monta bittiä on yhdessä tavussa?"};
        String[] Vastaus = {"Lennu","2020","Peking","8"};
        
    // tämä on peli
    
        System.out.println("Käynnistys onnistui!");
        ImageIcon icon = new ImageIcon("qst.png"); // Kuva
        JTextField vastaus = new JTextField(null,7);
        Boolean pelissa = true;
        
        do {
        int kysindex = (int)Math.ceil(Math.random() * (Kysymys.length-1));
        
        String kysymys = Kysymys[kysindex];
        
        Object[] options = {vastaus,"Ok", "Luovuta", "Sulje"};
        int x = JOptionPane.showOptionDialog(null,"Pisteitä: " + pisteet + "\n" + kysymys,
                "BLIZZARD GAMES INC.",
                // JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, options, options[0]);
        String answer = vastaus.getText(); // Ottaa vastauksen talteen
        System.out.println("Vastasit " +answer);
        
        if(answer.equals("")){
            answer = " ";
        }
        
        if (x == 3) {
            System.out.println("suljit pelin");
            pelissa = false;
             
        }
        
        
        if (answer.equalsIgnoreCase(Vastaus[kysindex]) ) {
            System.out.println("Oikein!");
            JOptionPane.showMessageDialog(null, "Oikein!");
            pisteet++;
        } else if (answer.charAt(0) == Vastaus[kysindex].charAt(0)){
            System.out.println("Lähellä mutta väärin meni!");
            JOptionPane.showMessageDialog(null,"Lähellä mutta väärin meni!");
        } else if (x == 2){
            System.out.println("Vastaus oli " + Vastaus[kysindex]);
            JOptionPane.showMessageDialog(null, "Luovuttaja! Vastaus oli " + Vastaus[kysindex]);
        } else if (x !=3) {
            System.out.println("Väärä vastaus!");
            JOptionPane.showMessageDialog(null,"Väärä vastaus!");
        } else {
            System.out.println("???");
        }
        
        vastaus.setText("");
       } while (pelissa == true);
        }
    }

