/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasino;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import javax.swing.JOptionPane;

/**
 *
 * @author ahone
 */
public class Lotto {

    private Random rand = new Random();

    private int[] arvotutnumerot = new int[7];
    private int[] valitutnumerot = new int[7];

    // Arpoo lottorivin
/*    public void arvoNumerot() {
        for (int i = 0; i < 7; i++) {

            int luku = (int) rand.nextInt(40) + 1;

            boolean sisaltaa = IntStream.of(arvotutnumerot).anyMatch(x -> x == luku);

            if (sisaltaa) {
                i--;
            } else {
                arvotutnumerot[i] = luku;
            }

        }
        Arrays.sort(arvotutnumerot);
        }*/
    // Pyytää käyttäjältä numerot
    public void annaNumerot() {
        for (int i = 0; i < 7; i++) {

            boolean sisaltaa, validi = false;
            int luku = 0;

            // Varmistetaan, että annettu arvo on kokonaisluku
            while (!validi) {
                String numero = JOptionPane.showInputDialog(null, "Anna " + (i + 1) + ".numero:");
                try {
                    luku = Integer.parseInt(numero);
                    validi = true;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Et antanut kokonaislukua...");
                }
            }

            int arvo;
            arvo = luku;

            sisaltaa = IntStream.of(valitutnumerot).anyMatch(x -> x == arvo);

            if (arvo <= 0 || arvo > 40) {
                i--;
                JOptionPane.showMessageDialog(null, "Antamasi luku ei ollut väliltä 1 - 40. Anna uusi luku.");
            } else if (sisaltaa) {
                i--;
                JOptionPane.showMessageDialog(null, "Antamasi numero on jo annettu kertaalleen. Anna uusi luku.");
            } else {
                valitutnumerot[i] = arvo;
            }

        }
        Arrays.sort(valitutnumerot);
    }

// Hakee arvotut numerot
    public int[] haeArvotutNumerot() {
        return arvotutnumerot;
    }

    // Hakee käyttäjän valitsemat numerot
    public int[] haeAnnetutNumerot() {
        return valitutnumerot;
    }

    // Tarkistaa oikeiden numeroiden määrän
    public void tarkistaNumreot() {
        int oikeatnumerot;
        String valnumerot = "", arvnumerot = "";
        int kierrokset = 0, oikein3 = 0, oikein4 = 0, oikein5 = 0, oikein6 = 0, saldo = 100;

        // Ajetaan niin kauan, että saadaan 7. oikein.
        do {

            // Nollaa arvottujen numeroiden taulukon, sekä oikeiden numeroiden määrän   
            arvotutnumerot = null;
            arvotutnumerot = new int[7];
            oikeatnumerot = 0;
            saldo--;
            kierrokset++;

            
            // Arpoo numerot
            for (int i = 0; i < 7; i++) {

                int luku = (int) rand.nextInt(40) + 1;

                boolean sisaltaa = IntStream.of(arvotutnumerot).anyMatch(x -> x == luku);

                if (sisaltaa) {
                    i--;
                } else {
                    arvotutnumerot[i] = luku;
                }

            }
            Arrays.sort(arvotutnumerot);
            
            // Vertaa arvottuja numeroita valittuihin numeroihin
            for (int i = 0; i < arvotutnumerot.length; i++) {
                int luku = arvotutnumerot[i];
                boolean sisaltaa = IntStream.of(valitutnumerot).anyMatch(x -> x == luku);
                if (sisaltaa) {
                    oikeatnumerot++;
                }
            }
            
            // Laskee eri voittojen määrän
            switch (oikeatnumerot) {
                case 4:
                    oikein4++;
                    break;
                case 5:
                    oikein5++;
                    break;
                case 6:
                    oikein6++;
                    break;
                default:
                    break;
            }
            
            
        } while (oikeatnumerot < 7);

        // Muutetaan taulukot String muotoon
        for (int i = 0; i < arvotutnumerot.length; i++) {
            if (i < 6) {
                valnumerot += valitutnumerot[i] + ", ";
                arvnumerot += arvotutnumerot[i] + ", ";
            } else {
                valnumerot += valitutnumerot[i];
                arvnumerot += arvotutnumerot[i];
            }
        }
        
        // Laskee voittojen tulot ja lisää saldoon
        oikein3 *= 2;
        oikein4 *= 10;
        oikein5 *= 50;
        oikein6 *= 10000;
        saldo = saldo + oikein3 + oikein4 + oikein5 + oikein6 + 1500000;

        
 
        // Tulosviesti
        JOptionPane.showMessageDialog(null, "Valitut numerot: \n" + valnumerot
                + "\n\nArvotut numerot:\n" + arvnumerot
                + "\n\nSait " + oikeatnumerot + " oikein! \nTähän meni: " + kierrokset + " kierrosta!"
                        + "\n Lopullinen saldosi on: "+saldo+" euroa!");

    }

}
