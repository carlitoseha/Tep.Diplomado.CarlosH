/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miclasemain;
import proyecto.miclase.MiClase;
/**
 *
 * @author chernandez
 */
public class MiClaseMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int valorClase =0;
        int valorInstacia = 0;
        MiClase valores = new MiClase();
        
        valorClase = MiClase.getValorClase();
        valorInstacia = valores.getValorInstacia();
        
    }
    
}
