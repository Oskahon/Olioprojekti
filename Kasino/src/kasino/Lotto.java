/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasino;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.util.stream.IntStream;
import javax.swing.JOptionPane;

/**
 *
 * @author ahone
 */
public class Lotto {

    Random rand = new Random();

    private int[] arvotutnumerot = new int[7];
    private int[] valitutnumerot = new int[7];

    public Lotto() {

    }

    // Arpoo lottorivin
    public void arvoNumerot() {
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
    }

    // Pyytää käyttäjältä numerot
    public void annaNumerot() {
        for (int i = 0; i < 7; i++) {

            String numero = JOptionPane.showInputDialog(null, "Anna " + (i + 1) + ".numero:");
            int luku = Integer.parseInt(numero);

            boolean sisaltaa = IntStream.of(valitutnumerot).anyMatch(x -> x == luku);

            if (luku <= 0 || luku > 40) {
                i--;
                JOptionPane.showMessageDialog(null, "Antamasi luku ei ollut väliltä 1 - 40. Anna uusi luku.");
            } else if (sisaltaa) {
                i--;
                JOptionPane.showMessageDialog(null, "Antamasi numero on jo annettu kertaalleen. Anna uusi luku.");
            } else {
                valitutnumerot[i] = luku;
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
        int oikeatnumerot = 0;
        String valnumerot = "", arvnumerot = "";
        for (int i = 0;i < arvotutnumerot.length; i++) {
            if (i < 6) {
            valnumerot += valitutnumerot[i]+", ";
            arvnumerot += arvotutnumerot[i]+", ";
            } else {
                valnumerot += valitutnumerot[i];
                arvnumerot += arvotutnumerot[i];
            }
        }

        for (int i = 0; i < arvotutnumerot.length; i++) {
            int luku = arvotutnumerot[i];
            boolean sisaltaa = IntStream.of(valitutnumerot).anyMatch(x -> x == luku);
            if (sisaltaa) {
                oikeatnumerot++;
            }
        }
        
        JOptionPane.showMessageDialog(null, "Valitut numerot: \n"+valnumerot+
                                            "\n\nArvotut numerot:\n"+arvnumerot+
                                            "\n\nSait " + oikeatnumerot + " oikein!");

    }

}
