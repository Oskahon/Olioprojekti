/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasino;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *
 * @author ekate
 */
public class PeliSyntarit {
//esitellaan muuttajat
Object paiva;    
String koneenpaiva, koneenkuukausi, koneenvuosi, koneenkirjain;
Double p;

//kapseloidut ominaisuudet
String[] day = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};

String[] month = {"tammi","helmi","maalis","huhti","touka","kesä","heinä","elo","syys","loka","marras","joulu"};

String[] year = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31",
"32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55",
"56","57","58","59","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78",
"79","80","81","82","83","84","85","86","87","88","89","90","91","92","93","94","95","96","97","98","99"};

String[] letter = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","Å","Ä","Ö"};

String[] rate = new String[] {"0,5 euroa","1 euro","2 euroa"}; 

//luokan metodit
//saadaan käyttäjän antama päivä
public String[] getPaiva(){
    return day;
}
//saadaan käyttäjän antama kuukausi   
public String[] getKuukausi(){
    return month;
}
//saadaan käyttäjän antama vuosi
public String[] getVuosi(){
    return year;
}
//saadaan käyttäjän antama kirjain
public String[] getKirjain(){
    return letter;
}
//saadaan käyttäjän antama panos
public String[] getPanos(){
    return rate;
}

//saadaan satunnaiskirjan taulukosta "day"
public String getKoneenpaiva(){
    
        int m = (int)Math.floor(Math.random()*day.length);
        return koneenpaiva = day[m];    
}

//saadaan satunnaiskuukausi taulukosta "month"
public String getKoneenkuukausi(){
   
    int k = (int)Math.floor(Math.random()*month.length);
    return koneenkuukausi = month[k];
    
}

//saadaan satunnaisvuosi taulukosta "year"
public String getKoneenvuosi(){
   int l = (int)Math.floor(Math.random()*year.length);
   return koneenvuosi = year[l]; 
}

//saadaan satunnaiskirjan taulukosta "letter" 
public String getKoneenkirjain(){
   int n = (int)Math.floor(Math.random()*letter.length);
   return koneenkirjain = letter[n];
}

//muunnetaan object -> double
public double DoubleConvert(Object panos){
        if (panos.equals("0,5 euroa")){p = 0.5;}
        else if (panos.equals("1 euro")){p = 1.0;}
        else {p = 2.0;}
        return p;
}
}
