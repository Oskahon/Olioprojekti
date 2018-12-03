/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasino;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Ninja
 */
public class View {

    private Controller controller;

    public void menuView() {

        // Päävalikko
        // JCheckBox checkbox = new JCheckBox("Tuplaus");
        ImageIcon icon = new ImageIcon("bliz.png"); // Kuva

        Object[] options = {"Tietovisa", "Lotto", "Synttärit", "Peli 4", "Tietoa tekijöistä", "Sulje"};
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
                System.out.println("Peli 2 käynnistyy..");
                controller.lotto();
                break;
            case 2:
                // Käynnistä Peli 3
                System.out.println("Peli 2 käynnistyy..");
                controller.syntarit();
                break;
            case 3:
                // Käynnistä 4
                System.out.println("4");
                break;
            case 4:
                // Käynnistä 5
                System.out.println("5");
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

}
