/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasino;

import java.util.*;

/**
 *
 * @author Ninja
 */
public class Visadata {
    
    private int pisteet=0;
    private int maxpisteet=0;
    private int virhepisteet;
    String[] Kysymykset = {"Mikä on Niinistön koiran nimi?", "Minä vuonna on seuraava karkausvuosi?","Mikä on Kiinan pääkaupunki?","Kuinka monta bittiä on yhdessä tavussa?","Minä vuonna Juice Leskinen kuoli?","Kuinka monta vuotta vanha metropolia täytti vuonna 2018? (Vastaa pelkkä vuosimäärä)","Paljonko on 5*5*5?"
    ,"Pikachun Pokedex id on 1, Totta/Tarua?","Integer-tietotyypin korkein desimaaliarvo on 2 147 482 647, Totta/Tarua?", "Minä vuonna julkistettiin ensimmäinen Android-puhelin?", "Minä vuonna talvisota loppui?", "Mistä kaupungista makeisvalmistaja Brunberg on kotoisin? \na) Hanko \nb) Vaasa \nc) Porvoo\nVastaa pelkkä a/b/c"
    ,"Kuinka paljon videota youtubeen ladataan joka minuutti?\na) 100 tuntia videota minuutissa \nb) 200 tuntia videota minuutissa \nc) 300 tuntia videota minuutissa\nVastaa pelkkä a/b/c",
    "Koska Helsingistä tuli Suomen pääkaupunki? \na) Vuonna 1812 \nb) Vuonna 1832 \nc) Vuonna 1848 \nVastaa pelkkä a/b/c"};
    String[] Vastaukset = {"Lennu","2020","Peking","8","2006","10","125"
    ,"Tarua","Tarua","2008","1940","C","C","A"};
    ArrayList<Integer> lukuLista;       
        ArrayList kysytyt = new ArrayList();
        int x;
    
    public int resetpeli(){
        
        kysytyt.clear();
        // Palauttaa pistemääräksi 0 ja palauttaa ennätyksen
        pisteet=0;
        virhepisteet = 0;
        return maxpisteet;
    }
    
    public String getkysymys(){
        int y;      
        do {
            x = (int)Math.floor(Math.random() * (Kysymykset.length));
            
            if (kysytyt.contains(x)){
                y = -1;
                System.out.println("..."+x);
            } else {
                y = 1;
                kysytyt.add(x);
                System.out.println("Lisätty");
            }
        } while (y == -1);             
        String kysymys = Kysymykset[x]; 
        return kysymys;
    }
    
    public char tarkista(String vastaus){
        char oikein;       
        
        
        if ( Vastaukset[x].equalsIgnoreCase(vastaus)) {
            oikein = 'O';       // Oikein
            pisteet++;           
            if (maxpisteet < pisteet){      // Jos nykyiset pisteet ovat korkeammat kuin viime ennätys, asetetaan uusi ennätys
            maxpisteet = pisteet;  
        }
            System.out.println("Tarkistus O");
        } else if (Vastaukset[x].charAt(0) == vastaus.charAt(0)){
            oikein = 'L';       // Ensimmäinen kirjain oli oikein, "lähellä oli"
            virhepisteet++;     // Väärästä vastauksesta lisätään virhepiste
            System.out.println("Tarkistus: L");
        } else {
            oikein = 'X';       // Väärin
            virhepisteet++;     // Väärästä vastauksesta lisätään virhepiste
            System.out.println("Tarkistus: X, " +"'"+ vastaus + "'"+Vastaukset[x]);
        }
        
        return oikein;
    }
    
    public int getpisteet(){
        int pist;
        
        pist = pisteet;
        return pist;
    }
    
    public String getvastaus(){
        String vast = Vastaukset[x];       
        
        return vast;
    }
    
    public int getMaxpisteet(){
        int ennatys = maxpisteet;       
        
        return ennatys;
    }
    
    public int getVirhepisteet(){
        int virheet;
        
        virheet = this.virhepisteet;
        return virheet;
    }
    
    public int kysleft(){   // Tarkistaa kuinka monta kysymystä on vielä kysymättä
        int left;
        left = Kysymykset.length - kysytyt.size();
        System.out.println("Kysymyksiä jäljellä " + left);
        return left;
    }
    
}
