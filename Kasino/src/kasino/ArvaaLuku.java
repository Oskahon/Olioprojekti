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
public class ArvaaLuku {
    
    // kapseloidut ominaisuudet
    private int sinunLuku;
    private int koneenLuku;
    
    // konstruktori, joka vaatii luvut
    public ArvaaLuku(int sinunLuku, int koneenLuku) {
        this.sinunLuku = sinunLuku;
        this.koneenLuku = koneenLuku;
    }
    
    // palauttaa pelajan tai pelajaan peolestaan arpoman luvun
    public int getSinunLuku() {
        return sinunLuku;
    }
    
    // palauttaa koneen arpoman luvun
    public int getKoneenLuku() {
       // koneenLuku = (int) (Math.random() * 10 + 1);
        return koneenLuku;
    }
    
    // tallennetaan  käytäjän tin hänen puolesta arvottu luku
    // jos käyttäjän luku on < pienempi kuin 1 ta suurempi kuin 10
    // käyttäjän luku asetetaan nollaksi
    public boolean luvunTalletus1(int uusiArvaus) {
        // kasvatetaan saldoa saadulla rahamäärällä.
        if(uusiArvaus >= 1 && uusiArvaus <= 10){
            sinunLuku = uusiArvaus;
            return true;
        }
        else{
            sinunLuku = 0;
            return false;
        }
        //this.sinunLuku = uusiArvaus;
    }
    
    
    // tallennetaan koneen luku
    public void luvunTalletus2(int uusiArvaus) {
        // kasvatetaan saldoa saadulla rahamäärällä.
        this.koneenLuku = uusiArvaus;
    }
    
}
