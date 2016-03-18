/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encenderbombillas;
import proyecto.bombilla.Bombilla;
/**
 *
 * @author chernandez
 */
public class EncenderBombillas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Bombilla bombilla1 = new Bombilla(1);
        Bombilla bombilla2 = new Bombilla(0);
        Bombilla bombilla3 = new Bombilla(1);
        Bombilla bombilla4 = new Bombilla(0);
        Bombilla bombilla5 = new Bombilla(0);
        
        //Bombilla 1
        if (bombilla1.getEncendida() == 1){
            System.out.println("La bombilla 1 está encendida");
        }else{
             System.out.println("La bombilla 1 está apagada");
        }
        
        //Bombilla 2
        if (bombilla2.getEncendida() == 1){
            System.out.println("La bombilla 2 está encendida");
        }else{
             System.out.println("La bombilla 2 está apagada");
        }
        
        //Bombilla 3
        if (bombilla3.getEncendida() == 1){
            System.out.println("La bombilla 3 está encendida");
        }else{
             System.out.println("La bombilla 3 está apagada");
        }
        
        //Bombilla 4
        if (bombilla4.getEncendida() == 1){
            System.out.println("La bombilla 4 está encendida");
        }else{
             System.out.println("La bombilla 4 está apagada");
        }
        
        //Bombilla 5
        if (bombilla5.getEncendida() == 1){
            System.out.println("La bombilla 5 está encendida");
        }else{
             System.out.println("La bombilla 5 está apagada");
        }
        
        
    }
    
}
