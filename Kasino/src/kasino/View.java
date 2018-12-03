/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasino;

import java.util.Arrays;
import java.util.stream.IntStream;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *
 * @author lastl
 */
public class View {
    private Controller controller;

    public void menuView() {

        // Päävalikko
        // JCheckBox checkbox = new JCheckBox("Tuplaus");
        ImageIcon icon = new ImageIcon("bliz.png"); // Kuva


        Object[] options = {"Tietovisa", "Lotto Simulaattori", "Synttärit", "Peli 4", "Tietoa tekijöistä", "Sulje"};
        int x = JOptionPane.showOptionDialog(null, "\n Valitse peli tai toiminto\n\n",
                "BLIZZARD GAMES INC.",
                // JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, options, options[0]);

        //   JOptionPane.showMessageDialog(null, "Valitsit " + options[x] + "!");
        switch (x) {
            case 0:
                // Käynnistä Peli 1
                System.out.println("Peli 1 käynnistyy..");
                controller.peli1();
                break;
            case 1:
                // Käynnistä Peli 2
                System.out.println("Lotto Simulaattori käynnistyy..");
                controller.lotto();
                break;
            case 2:
                // Käynnistä Peli 3
                System.out.println("Peli 2 käynnistyy..");
                controller.syntarit();
                break;
            case 3:
                // Käynnistä 4
                System.out.println("Peli 4 käynistyy..");
                controller.arvaaluku();
                break;
            case 4:
                // Käynnistä 5
                System.out.println("Tietoa tekijöistä");
                JOptionPane.showMessageDialog(null, "Tietovisa\nTekijä: Ninja Luotonen\n\n"
                        + "Lotto Simulaattori\n Tekijä: Oskari Ahonen\n\n"
                        + "Synttärit\nTekijä: Ekaterina Seikkinen \n\n"
                        + "Arvaa Luku\nTekijä: Artem Kupri");
                break;
            case 5:
                // Käynnistä 6
                System.out.println("6, lopetus");
                JOptionPane.showMessageDialog(null, "Tervetuloa uudelleen!");
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Joku meni vikaan");
                menuView();
        }
        menuView(); // Jos napilla ei ole vielä toimintoa, mennään takaisin menuun
    }

    //Metodit
    public void registerControl(Controller control) {
        // näyttö saa tiedon kontrollerista, jolle se välittää pyyntöjä
        this.controller = control;
    }

    public void naytaViesti(String viesti) {
        JOptionPane.showMessageDialog(null, viesti);
    }
    
    // Pyytää loton numerot
    
    public int[] annaNumerot() {
        
        int[] valitutnumerot = new int[7];
        
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
            
            // sisaltaa tarkastus ei toimi jos etsittävä luku on alustettu
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
        
        return valitutnumerot;
    }
    
    
    
    
    // ArvaaLuku
    public void aloitusNaytto() {
        String valintaStr;      // käyttäjän valinta merkkijonona
        int valinta;            // valinta numerona

        // näytetään käyttäjälle päävalikko
        valintaStr = JOptionPane.showInputDialog(null,
                "Valitse toiminto (1-3) seuraavista: \n"
                + "1: Jos et ole laiska \n"
                + "2: Jos olet laiska \n"
                + "3: Lopeta");

        // muutetaan käyttäjän vastaus numeroksi
        valinta = Integer.parseInt(valintaStr);
        

        // siirrytään käyttäjän haluamaan toimintoon
        switch (valinta) {
            case 1:
                eiLaiska();
                break;
            case 2:
                laiska();
                break;
            case 3:
                lopetus();
                break;
            default:
                // näytetään valikko uudestaan, jos ei kunnollinen valinta
                aloitusNaytto();
                
        }

    }
    
    
    
    
    // jos käyttäjä on laiska, luku arvataan hänen puolestaan
    public void laiska() {
        
        // käyttäjän luku
        controller.luvunTalletus1((int) (Math.random() * 10 + 1));
        // koneen luku
        controller.luvunTalletus2((int) (Math.random() * 10 + 1));
        // pyydetään kontrolleria hoitamaan toiminto, 
        // saadaan takaisin haluttu vastaus
        int sinunLuku = controller.sinunLuku();
        int koneenLuku = controller.koneenLuku();
        
        // näytetään arvotut luvut ja samalla 
        // kerrotaan onko pelaaja voittanut  tai hävinnyt
        if(sinunLuku == koneenLuku){
            JOptionPane.showMessageDialog(null, "Sinun luku on " + sinunLuku
            + "\nKoneen luku on " + koneenLuku + "\nVoitit!");
        
            // siirrytään takaisin aloitusnäyttöön
            aloitusNaytto();
        }
        else{
            JOptionPane.showMessageDialog(null, "Sinun luku on " + sinunLuku
            + "\nKoneen luku on " + koneenLuku + "\nHävisit!");
        
            // siirrytään takaisin aloitusnäyttöön
            aloitusNaytto();
        }
    }
    
    
    // käyttäjä syöttää luvunsa itse
    public void eiLaiska() {
        // pyydetään käyttäjältä lisätietoa ennen kontrollerin kutsumista
        String kayttajanSyotto =
                JOptionPane.showInputDialog(null, "Anna luku [1-10]: ");
        // käyttäjän luku
        // kontrolleri vaatii parametrina int, muutetaan se 'lennossa'.
        controller.luvunTalletus1( Integer.parseInt(kayttajanSyotto) );
        // koneen luku
        controller.luvunTalletus2((int) (Math.random()* 10 + 1));
        
        // pyydetään kontrolleria hoitamaan toiminto, 
        // saadaan takaisin haluttu vastaus
        int sinunLuku = controller.sinunLuku();
        int koneenLuku = controller.koneenLuku();

        // näytetään pelaajan ja arvotu luvut ja samalla 
        // kerrotaan onko pelaaja voittanut tai hävinnyt         
        if(sinunLuku == koneenLuku){
            JOptionPane.showMessageDialog(null, "Sinun luku on " + sinunLuku
            + "\nKoneen luku on " + koneenLuku + "\nVoitit!");
            // siirrytään takaisin aloitusnäyttöön
            aloitusNaytto();
        }
        else{
            JOptionPane.showMessageDialog(null, "Sinun luku on " + sinunLuku
            + "\nKoneen luku on " + koneenLuku + "\nHävisit!");
            // siirrytään takaisin aloitusnäyttöön
            aloitusNaytto();
        }
    }
    
    // keskeytytään peli
    public void lopetus() {
        System.exit(0);
    }
    
   
}
