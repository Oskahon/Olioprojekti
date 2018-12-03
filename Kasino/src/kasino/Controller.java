/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasino;

/**
 *
 * @author lastl
 */
public class Controller {
    // Kapseloidut ominaisuudet
    // Kapseloidut ominaisuudet
    private View view;
    private Peli666 peli1;
    private Lotto peli2;
    private PeliSyntarit peli3;
    private ArvaaLuku peli4;
    
    public Controller() {
        
        view = new View();
        
        // Valmistellaan kaikki pelit
        peli1 = new Peli666(); 
        peli2 = new Lotto();
        peli3 = new PeliSyntarit();
        peli4 = new ArvaaLuku(0,0);
        
        
        // välitetään näytölle tieto sovelluksen kontrollerista eli
        // tämä komponentti itse (this).
        view.registerControl(this); 
        
        // pyydetään näyttöä esittämään aloitusnäyttö
        view.menuView();      

    }
    
    
    
    // Menusta käynnistyvät metodit
    
    public void peli1(){
        // Kutsu(Käynnistä) peli (Malli)
        System.out.println("Peli 1 käynnistyy..");
        peli1.startpeli();
    }
    
    public void lotto(){
        view.naytaViesti("Huom! Koska Lotossa haetaan 7.oikein tulosta, simulointi voi kestää muutamia minuutteja.");
        int[] annetutnumerot = view.annaNumerot();
        String tulos = peli2.lottoStart(annetutnumerot);
        view.naytaViesti(tulos);
    }
    
    public void syntarit(){
        System.out.println("Peli 2 käynnistyy..");
        peli3.startpeli2();
    }
    
    public void arvaaluku(){
        System.out.println("Peli 4 käynnistyy..");
        view.aloitusNaytto();
    }
    
    // Arvaa Luvun skriptti alkaa
    // haetaan käyttäjän tai häne puolestaan arvottu luku
    public int sinunLuku() {
        int  sinunLuku = peli4.getSinunLuku();
        return sinunLuku;
    }
    
    // haetaan koneen luku
    public int koneenLuku() {
        int koneenLuku = peli4.getKoneenLuku();
        return koneenLuku;
    }
    
    
    // käyttäjän tai hänen puolestaan arvotun luvun tallentaminen
    public void luvunTalletus1(int arvaus) {
        if(arvaus < 1){
        view.naytaViesti("Luku on pienempi, kuin 1, nero! "
            + "Luvuksi asetetaan 0. \nArvaappas mitä seurravaksi tapahtuu :)");
        }
        if(arvaus > 10){
        view.naytaViesti("Luku on suurempi, kuin 10, nero! "
            + "Luvuksi asetetaan 0. \nArvaappas mitä seurravaksi tapahtuu :)");
        }
        peli4.luvunTalletus1(arvaus);
        // Ei kerrota nyt käyttäjälle toiminnon onnistumisesta mitään (???)
        // Näyttöä pyydetään siirtymään vain aloitusnäyttöön
        // naytto.aloitusNaytto();
    }
    
    // koneen luvun tallentaminen
    public void luvunTalletus2(int arvaus) {
        peli4.luvunTalletus2(arvaus);
        // Ei kerrota nyt käyttäjälle toiminnon onnistumisesta mitään (???)
        // Näyttöä pyydetään siirtymään vain aloitusnäyttöön
        // naytto.aloitusNaytto();
    }
    // Arvaa Luvun skriptti päättyy
    
    // Ohjelma käynnistyy tästä
    public static void main(String[] args) {
        // luodaan kontrolleri-olio, joka valmistelee sovelluksen ja pelit
        new Controller();
        
    } 
    
}

