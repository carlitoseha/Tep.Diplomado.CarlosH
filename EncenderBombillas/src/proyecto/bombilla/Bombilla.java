/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.bombilla;

/**
 *
 * @author chernandez
 */
public class Bombilla {
    private int encendida = 0; //1 = encendida, 0 apagada;
    
    
    public Bombilla (int a){
        this.encendida=a;
    }

    /**
     * @return the encendida
     */
    public int getEncendida() {
        return encendida;
    }

    /**
     * @param encendida the encendida to set
     */
    public void setEncendida(int encendida) {
        this.encendida = encendida;
    }
            
   
}
