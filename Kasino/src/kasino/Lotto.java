package kasino;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 *
 * @author oskahon
 */
public class Lotto {

    private Random rand = new Random();

    private int[] arvotutnumerot = new int[7];

    // Tavallinen lotto
    public String lottoStart(int[] numerot) {

        int[] valitutnumerot = numerot;
        String valnumerot = "", arvnumerot = "", tulos;
        int oikeatnumerot = 0, voittosumma = 0;

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

        // Muutetaan valitutnumerot taulukko String muotoon
        for (int i = 0; i < valitutnumerot.length; i++) {
            if (i < 6) {
                valnumerot += valitutnumerot[i] + ", ";
                arvnumerot += arvotutnumerot[i] + ", ";
            } else {
                valnumerot += valitutnumerot[i];
                arvnumerot += arvotutnumerot[i];
            }
        }

        // Voitonjako
        switch (oikeatnumerot) {
            case 3:
                voittosumma = 2;
                break;
            case 4:
                voittosumma = 10;
                break;
            case 5:
                voittosumma = 50;
                break;
            case 6:
                voittosumma = 10000;
                break;
            case 7:
                voittosumma = 2000000;
                break;
            default:
                break;
        }

        // Tulosviesti
        if (oikeatnumerot < 3) {
            tulos = "Valitut numerot: \n" + valnumerot
                    + "\n\nArvotut numerot: \n" + arvnumerot
                    + "\n\nSait " + oikeatnumerot + " oikein! "
                    + "\n\n Valitettavasti et voittanut mitään.";
        } else {
            tulos = "Valitut numerot: \n" + valnumerot
                    + "\n\nArvotut numerot: \n" + arvnumerot
                    + "\n\nSait " + oikeatnumerot + " oikein! "
                    + "\n\nVoitit " + voittosumma + " euroa!";
        }

        return tulos;

    }

    // 7 Oikein peli
    // Arpoo numeroita niin kauan, että saadaan 7.oikein. Tämän jälkeen laskee lopullisen saldon.
    public String lotto7Start(int[] numerot) {

        int[] valitutnumerot = numerot;
        String valnumerot = "";
        int oikeatnumerot, kierrokset = 0, oikein3 = 0, oikein4 = 0, oikein5 = 0, oikein6 = 0, saldo = 0;

        // Ajetaan niin kauan, että saadaan 7. oikein.
        do {

            // Nollaa arvottujen numeroiden taulukon, sekä oikeiden numeroiden määrän   
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

        // Muutetaan valitutnumerot taulukko String muotoon
        for (int i = 0; i < valitutnumerot.length; i++) {
            if (i < 6) {
                valnumerot += valitutnumerot[i] + ", ";
            } else {
                valnumerot += valitutnumerot[i];
            }
        }

        // Laskee voittojen tulot ja lisää saldoon
        oikein3 *= 2;
        oikein4 *= 10;
        oikein5 *= 50;
        oikein6 *= 10000;
        saldo = saldo + oikein3 + oikein4 + oikein5 + oikein6 + 2000000;

        // Tulosviesti
        String tulos = "Valitut numerot: \n" + valnumerot
                + "\n\nSait " + oikeatnumerot + " oikein! "
                + "\n\nTähän meni: \n" + kierrokset + " kierrosta!"
                + "\n\n Lopullinen saldosi on: \n" + saldo + " euroa!";

        return tulos;

    }

}
