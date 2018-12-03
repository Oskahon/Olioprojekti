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
String koneenkirjain, koneenpaiva,koneenvuosi,koneenkuukausi;

public void startpeli2(){
    
ImageIcon icon = new ImageIcon("qst.png");

double p;

String[] day = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};

String[] month = {"tammi","helmi","maalis","huhti","touka","kesä","heinä","elo","syys","loka","marras","joulu"};

String[] year = {"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31",
"32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55",
"56","57","58","59","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78",
"79","80","81","82","83","84","85","86","87","88","89","90","91","92","93","94","95","96","97","98","99"};

String[] letter = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","Å","Ä","Ö"};

String[] rate = new String[] {"0,5 euroa","1 euro","2 euroa"};
//JComboBox paiva1  = new JComboBox(day);
//paiva1.setEditable(true);
//paiva1.setSelectedIndex(0); 
//JOptionPane.showMessageDialog(null, paiva);

Object input = JOptionPane.showInputDialog(null, "Valitse syntymäpäiväsi", "BLIZZARD GAMES INC.", JOptionPane.QUESTION_MESSAGE, icon, day,"1");
    
Object input1 = JOptionPane.showInputDialog(null, "Valitse syntymäkuukausisi", "BLIZZARD GAMES INC.", JOptionPane.QUESTION_MESSAGE, icon, month,"tammi");

Object input2 = JOptionPane.showInputDialog(null, "Valitse syntymävuosisi", "BLIZZARD GAMES INC." , JOptionPane.QUESTION_MESSAGE, icon,year,"00");

Object input3 = JOptionPane.showInputDialog(null, "Valitse mikä tahansa kirjain", "BLIZZARD GAMES INC." , JOptionPane.QUESTION_MESSAGE, icon, letter,"A");

Object input4 = JOptionPane.showInputDialog(null, "Aseta panos", "BLIZZARD GAMES INC." , JOptionPane.QUESTION_MESSAGE, icon,rate,"0,5 euroa");
 
 
 String paiva = input.toString();
 String kuukausi = input1.toString();
 String vuosi = input2.toString();
 String kirjain = input3.toString();
 String panos = input4.toString();
  
 if (panos.equals("0,5 euroa")){p = 0.5;}
 else if (panos.equals("1 euro")){p = 1.0;}
 else {p = 2.0;}

    System.out.println(p);
 System.out.println(paiva+" "+kuukausi+" "+vuosi+" "+kirjain);
 
 int m = (int)Math.floor(Math.random()*day.length);
        koneenpaiva = day[m];
 int k = (int)Math.floor(Math.random()*month.length);
        koneenkuukausi = month[k];  
 int l = (int)Math.floor(Math.random()*year.length);
        koneenvuosi = year[l];       
 int n = (int)Math.floor(Math.random()*letter.length);
        koneenkirjain = letter[n];
        
System.out.println(koneenpaiva+" "+koneenkuukausi+" "+koneenvuosi+" "+koneenkirjain);
   
 JOptionPane.showMessageDialog(null, "Valmis rivi: "+ paiva+" "+kuukausi+" "+vuosi+" "+kirjain+ "\nKoneen rivi: "+koneenpaiva+" "+koneenkuukausi+" "+koneenvuosi+" "+koneenkirjain, "BLIZZARD GAMES INC.", 0, icon);
 
 if (paiva.equals(koneenpaiva)&& kuukausi.equals(koneenkuukausi)&& vuosi.equals(koneenvuosi)&& kirjain.equals(koneenkirjain)){
           JOptionPane.showMessageDialog(null, "Voittosi on " + p*150000 + " euroa");
       } else if (paiva.equals(koneenpaiva) && kuukausi.equals(koneenkuukausi) && vuosi.equals(koneenvuosi)){
           JOptionPane.showMessageDialog(null, "Voittosi on " + p*5000 + " euroa");
       }  else if (kuukausi.equals(koneenkuukausi) && vuosi.equals(koneenvuosi)){
           JOptionPane.showMessageDialog(null, "Voittosi on " + p*500 + " euroa");
       } else if (paiva.equals(koneenpaiva) && kuukausi.equals(koneenkuukausi)&& kirjain.equals(koneenkirjain)){
          JOptionPane.showMessageDialog(null, "Voittosi on " + p*250 + " euroa");
       } else if (kuukausi.equals(koneenkuukausi) && vuosi.equals(koneenvuosi)){
          JOptionPane.showMessageDialog(null, "Voittosi on " + p*50 + " euroa");
       } else if (paiva.equals(koneenpaiva) && kuukausi.equals(koneenkuukausi)){
          JOptionPane.showMessageDialog(null, "Voittosi on " + p*15 + " euroa");
       } else if (kuukausi.equals(koneenkuukausi) && kirjain.equals(koneenkirjain)){
           JOptionPane.showMessageDialog(null, "Voittosi on " + p*10 + " euroa");   
       } else if (kuukausi.equals(koneenkuukausi)){
           JOptionPane.showMessageDialog(null, "Voittosi on " + p*2 + " euroa");
       } else {JOptionPane.showMessageDialog(null, "Valitettavasti et voittanut! ");}
}
}

