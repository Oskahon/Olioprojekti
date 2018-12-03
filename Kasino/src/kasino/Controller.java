package kasino;

/**
 *
 * @author Ninja
 */
public class Controller {
    // Kapseloidut ominaisuudet
    private View view;
    private Peli666 peli1;
    private Lotto peli2;
    private PeliSyntarit peli3;
    
    public Controller() {
        
        view = new View();
        
        // Valmistellaan kaikki pelit
        peli1 = new Peli666(); 
        peli2 = new Lotto();
        peli3 = new PeliSyntarit();
        
        
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
        peli2.annaNumerot();
        peli2.tarkistaNumreot();
    }
    
    public void syntarit(){
        System.out.println("Peli 2 käynnistyy..");
        peli3.startpeli2();
    }
    
   
    
    // Ohjelma käynnistyy tästä
    public static void main(String[] args) {
        // luodaan kontrolleri-olio, joka valmistelee sovelluksen ja pelit
        new Controller();
        
    }       
}

