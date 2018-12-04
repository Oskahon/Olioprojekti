/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasino;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Ninja
 */
public class Peli666 {

    String asd;
    
    public void startpeli() {  
    
        System.out.println("Käynnistys onnistui!");
        ImageIcon icon = new ImageIcon("qst.png"); // Hieno kuva
        JTextField vastaus = new JTextField(null,7);
        Boolean pelissa = true;
        Visadata VisaData = new Visadata();
        char tarkistus;
        
        do {
        
        String kysymys = VisaData.getkysymys();
        
        Object[] options = {vastaus,"Ok", "Luovuta", "Sulje"};
        int x = JOptionPane.showOptionDialog(null,"Pisteet: " + VisaData.getpisteet() + "\n"
                + "Virhepisteet: " + VisaData.getVirhepisteet() + "/3"
                + "\nEnnätyksesi: " 
                + VisaData.getMaxpisteet() +"\n"
                + kysymys,
                "BLIZZARD GAMES INC.",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, options, options[0]);
        String answer = vastaus.getText(); // Ottaa vastauksen talteen
        System.out.println("Vastasit " +"'"+answer+"'");
        
        if(answer.equals("")){  // Jos vastauskenttä on tyhjä, muutetaan se, ettei ohjelma kaadu
            answer = " ";
        }
        
        
        if (x == 3) {
            System.out.println("Suljit pelin");
            pelissa = false;
             
        }
        
        tarkistus = VisaData.tarkista(answer);
        
        if (tarkistus == 'O') {
            System.out.println("Oikein!");
            JOptionPane.showMessageDialog(null, "Oikein!");
        } else if (tarkistus == 'L'){
            System.out.println("Lähellä mutta väärin meni!");
            JOptionPane.showMessageDialog(null,"Lähellä mutta väärin meni!");
        } else if (x == 2){
            JOptionPane.showMessageDialog(null, "Luovuttaja! \nVastaus oli "+ VisaData.getvastaus()+". \nKeräsit " + VisaData.getpisteet() +" pistettä!");
            VisaData.resetpeli();
        } else if (tarkistus == 'X' && pelissa == true) {
            System.out.println("Väärä vastaus!");
            JOptionPane.showMessageDialog(null,"Väärä vastaus!");
        } else {
            System.out.println("???");
        }
        
        if (VisaData.getVirhepisteet() > 2){
            JOptionPane.showMessageDialog(null,"Vastasit väärin 3 kertaa joten hävisit! Yritä uudelleen!");
            VisaData.resetpeli();
        }
        
        if (VisaData.kysleft() == 0){
            System.out.println("Ei enempää kysymyksiä!");
            JOptionPane.showMessageDialog(null,"Olet vastannut kaikkiin kysymyksiin! Onneksi olkoon, tiedät paljon!");
            VisaData.resetpeli();
        }
        
        vastaus.setText("");
       } while (pelissa == true);
       
    
    }
    }

