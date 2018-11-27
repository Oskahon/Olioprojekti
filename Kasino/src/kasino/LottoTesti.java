/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasino;

import java.util.Arrays;

/**
 *
 * @author ahone
 */
public class LottoTesti {
    public static void main(String[] args) {
        
        Lotto uusiRivi = new Lotto();
        uusiRivi.arvoNumerot();
        uusiRivi.annaNumerot();
        
        int[] arvotturivi = uusiRivi.haeArvotutNumerot();
        int[] valitutnumerot = uusiRivi.haeAnnetutNumerot();
        
        System.out.println(Arrays.toString(arvotturivi));
        System.out.println(Arrays.toString(valitutnumerot));
        
        uusiRivi.tarkistaNumreot();
        
        
    }
    
}
