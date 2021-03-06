package kasino;

import java.util.Arrays;
import java.util.stream.IntStream;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class View {

    private Controller controller;

    public void menuView() {

        // Päävalikko
        ImageIcon icon = new ImageIcon("bliz.png"); // Kuva

        Object[] options = {"Tietovisa", "Lotto", "Synttärit", "Arvaa Luku", "Tietoa tekijöistä", "Sulje"};
        int x = JOptionPane.showOptionDialog(null, "\n Valitse peli tai toiminto\n\n",
                "BLIZZARD GAMES INC.",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, options, options[0]);

        switch (x) {
            case 0:
                controller.peli1();
                break;
            case 1:
                lottoView();
                break;
            case 2:
                controller.syntarit();
                break;
            case 3:
                controller.arvaaluku();
                break;
            case 4:
                System.out.println("Tietoa tekijöistä");
                JOptionPane.showMessageDialog(null, "Tietovisa\nTekijä: Ninja Luotonen\n\n"
                        + "Lotto\n Tekijä: Oskari Ahonen\n\n"
                        + "Synttärit\nTekijä: Ekaterina Seikkinen \n\n"
                        + "Arvaa Luku\nTekijä: Artem Kupri");
                break;
            case 5:
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

    public void lottoView() {

        // Lotto valikko
        Object[] options = {"Lotto", "7. Oikein", "Lopetus"};
        int x = JOptionPane.showOptionDialog(null, "Valitse peli tai palaa alkunäkymään", "Valitse peli",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (x) {
            case 0:
                controller.lotto();
                break;
            case 1:
                controller.lotto7();
                break;
            case 2:
                menuView();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Suljit ohjelman");
                System.exit(0);
        }
        lottoView();
    }

    // Pyytää loton numerot
    public int[] annaNumerot() {

        int[] valitutnumerot = new int[7];

        for (int i = 0; i < 7; i++) {

            boolean validi = false;

            // Varmistetaan, että annettu arvo on kokonaisluku
            while (!validi) {

                String numero = JOptionPane.showInputDialog(null, "Anna " + (i + 1) + ".numero:");

                try {
                    if (numero == null) {
                        // Jos painaa cancelia tai ruksia palataan loton alkunäkymään
                        lottoView();
                    } else {
                        // luku on kelvollinen
                        int luku = Integer.parseInt(numero);
                        validi = true;

                        // tarkistetaan, löytyykö luku jo syötetyistä numeroista
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
                } catch (Exception e) {
                    // Jos syötetty arvo ei ole kokonaisluku
                    JOptionPane.showMessageDialog(null, "Et antanut kokonaislukua...");
                }
            }
        }

        Arrays.sort(valitutnumerot);

        return valitutnumerot;
    }

    // ArvaaLuku
    public void aloitusNaytto() {
        String valintaStr;      // käyttäjän valinta merkkijonona
        int valinta = 0;            // valinta numerona
        boolean validi = false;

        // näytetään käyttäjälle päävalikko
        while (!validi) {
            valintaStr = JOptionPane.showInputDialog(null,
                    "Valitse toiminto (1-3) seuraavista: \n"
                    + "1: Jos et ole laiska \n"
                    + "2: Jos olet laiska \n"
                    + "3: Lopeta");

            // muutetaan käyttäjän vastaus numeroksi
            try {
                valinta = Integer.parseInt(valintaStr);
                validi = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Lopeta peli syöttämällä luku 3.");
            }
        }

        // siirrytään käyttäjän haluamaan toimintoon
        switch (valinta) {
            case 1:
                eiLaiska();
                break;
            case 2:
                laiska();
                break;
            case 3:
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
        if (sinunLuku == koneenLuku) {
            JOptionPane.showMessageDialog(null, "Sinun luku on " + sinunLuku
                    + "\nKoneen luku on " + koneenLuku + "\nVoitit!");

            // siirrytään takaisin aloitusnäyttöön
            aloitusNaytto();
        } else {
            JOptionPane.showMessageDialog(null, "Sinun luku on " + sinunLuku
                    + "\nKoneen luku on " + koneenLuku + "\nHävisit!");

            // siirrytään takaisin aloitusnäyttöön
            aloitusNaytto();
        }
    }

    // käyttäjä syöttää luvunsa itse
    public void eiLaiska() {
        String kayttajanSyottoStr;
        int kayttajanSyotto = 0;
        boolean validi = false;
        // pyydetään käyttäjältä lisätietoa ennen kontrollerin kutsumista

        while (!validi) {
        kayttajanSyottoStr
                = JOptionPane.showInputDialog(null, "Anna luku [1-10]");
        
        
        try {
        kayttajanSyotto = Integer.parseInt(kayttajanSyottoStr);
        validi = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Vain kokonaisluku kelpaa");
            }
        }
        // käyttäjän luku
        controller.luvunTalletus1(kayttajanSyotto);

        
        // koneen luku
        controller.luvunTalletus2((int) (Math.random() * 10 + 1));

        // pyydetään kontrolleria hoitamaan toiminto, 
        // saadaan takaisin haluttu vastaus
        int sinunLuku = controller.sinunLuku();
        int koneenLuku = controller.koneenLuku();

        // näytetään pelaajan ja arvotu luvut ja samalla 
        // kerrotaan onko pelaaja voittanut tai hävinnyt         
        if (sinunLuku == koneenLuku) {
            JOptionPane.showMessageDialog(null, "Sinun luku on " + sinunLuku
                    + "\nKoneen luku on " + koneenLuku + "\nVoitit!");
            // siirrytään takaisin aloitusnäyttöön
            aloitusNaytto();
        } else {
            JOptionPane.showMessageDialog(null, "Sinun luku on " + sinunLuku
                    + "\nKoneen luku on " + koneenLuku + "\nHävisit!");
            // siirrytään takaisin aloitusnäyttöön
            aloitusNaytto();
        }
    }

    public void syntarit() {
        //esitellään muuttajat
        String koneenpaiva,koneenkuukausi, koneenvuosi,koneenkirjain;
        String antamapaiva,antamakuukausi, antamavuosi, antamakirjain;
        double antamapanos;
         
         ImageIcon icon = new ImageIcon("qst.png");
         
         //käyttäjän valitsema panos (3 vaihtoehtoja)
         Object input4 =  JOptionPane.showInputDialog(null, "Aseta panos", "BLIZZARD GAMES INC." , 
                 JOptionPane.QUESTION_MESSAGE, icon,controller.panos(),"0,5");
         if (input4==null){return;}//jos käyttäja painaa "cancel"
         
         //muunnetaan käyttäjän valitsema arvo -> double
         antamapanos = controller.DoubleConvert(input4);
         
         //käyttäjän valitsema syntymäpäivä
         antamapaiva = 
                 (String) JOptionPane.showInputDialog(null, "Valitse syntymäpäiväsi", "BLIZZARD GAMES INC.", 
                         JOptionPane.QUESTION_MESSAGE, icon, controller.paiva(),"1");
         if (antamapaiva==null){return;}//jos käyttäja painaa "cancel"
         
         //käyttäjän valitsema syntymäkuukausi
         antamakuukausi = 
                 (String) JOptionPane.showInputDialog(null, "Valitse syntymäkuukausisi", "BLIZZARD GAMES INC.", 
                         JOptionPane.QUESTION_MESSAGE,icon, controller.kuukausi(),"tammi");
         if (antamakuukausi==null){return;}//jos käyttäja painaa "cancel"
         
         //käyttäjän valitsema syntymävuosi
         antamavuosi = 
                 (String) JOptionPane.showInputDialog(null, "Valitse syntymävuosisi", "BLIZZARD GAMES INC." ,
                         JOptionPane.QUESTION_MESSAGE, icon,controller.vuosi(),"00");
         if (antamavuosi==null){return;}//jos käyttäja painaa "cancel"
         
         //käyttäjän valitsema kirjain
         antamakirjain = 
                 (String)JOptionPane.showInputDialog(null, "Valitse mikä tahansa kirjain", "BLIZZARD GAMES INC." ,
                         JOptionPane.QUESTION_MESSAGE, icon, controller.kirjain(),"A");
         if (antamakirjain==null){return;}//jos käyttäja painaa "cancel"
         
         //koneen satunnaisarvot
         koneenpaiva = controller.getKoneenpaiva();
         koneenkuukausi = controller.getKoneenkuukaisi();
         koneenvuosi = controller.getKoneenvuosi();
         koneenkirjain =controller.getKoneenkirjain();
         
        //tulostetaan valmis rivi ja koneen rivi ja sattuman määrä
         JOptionPane.showMessageDialog(null,"Valmis rivi: "+antamapaiva+" "+antamakuukausi+" "+antamavuosi+" "+antamakirjain+ 
                 "\nKoneen rivi: " +koneenpaiva+" "+koneenkuukausi+" "+koneenvuosi+" "+koneenkirjain+
                 "\n"+controller.sattumanmaara(antamapaiva, antamakuukausi, antamavuosi, antamakirjain, koneenpaiva, koneenkuukausi, koneenvuosi, koneenkirjain)
                 , "BLIZZARD GAMES INC.", 0, icon);
         
         //jos kaikki oikein (päivä,kuukausi,vuosi,kirjain) -> tosi pieni todennäköisyys 
         if (antamapaiva.equals(koneenpaiva)&&antamakuukausi.equals(koneenkuukausi)&&antamavuosi.equals(koneenvuosi)
                 &&antamakirjain.equals(koneenkirjain)){
         naytaViesti("Voittosi on " + antamapanos*150000 + " euroa");
         }
         // jos päivä, vuosi ja kuukausi oikein
         else if(antamapaiva.equals(koneenpaiva) && antamakuukausi.equals(koneenkuukausi) 
                 && antamavuosi.equals(koneenvuosi)){
         naytaViesti("Voittosi on " +antamapanos*5000 + " euroa");
        }
         //jos kuukausi ja vuosi oikein
         else if(antamakuukausi.equals(koneenkuukausi) && antamavuosi.equals(koneenvuosi)){
         naytaViesti("Voittosi on " + antamapanos*500 + " euroa");
         }
         // jos päivä, kuukausi ja kirjain oikein
         else if(antamapaiva.equals(koneenpaiva) && antamakuukausi.equals(koneenkuukausi)
                 && antamakirjain.equals(koneenkirjain)){
         naytaViesti("Voittosi on " + antamapanos*250 + " euroa");
         }
         //jos kuukausi ja vuosi oikein
         else if(antamakuukausi.equals(koneenkuukausi) && antamavuosi.equals(koneenvuosi)){
         naytaViesti("Voittosi on " + antamapanos*50 + " euroa");
         }
        //jos kuukausi ja päivä oikein
         else if (antamapaiva.equals(koneenpaiva) && antamakuukausi.equals(koneenkuukausi)){
         naytaViesti("Voittosi on " + antamapanos*15 + " euroa");
       }
         //jos kuukausi ja kirjain oikein
         else if(antamakuukausi.equals(koneenkuukausi) && antamakirjain.equals(koneenkirjain)){
         naytaViesti("Voittosi on " + antamapanos*10 + " euroa");
         }
         //jos kuukausi on oikein
         else if(antamakuukausi.equals(koneenkuukausi)){
         naytaViesti("Voittosi on " + antamapanos*2 + " euroa");
         }
         // jos antama rivi ja koneen rivi erilaisia
         else  {naytaViesti("Valitettavasti et voittanut! ");}
      
         }
}
