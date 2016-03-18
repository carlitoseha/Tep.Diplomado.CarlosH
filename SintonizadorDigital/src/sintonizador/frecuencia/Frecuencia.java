/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sintonizador.frecuencia;

/**
 *
 * @author chernandez
 */
public class Frecuencia {
    
    private double frecuencia;
    
    public Frecuencia (double frecuencia){
        setFrecuencia(frecuencia);
        System.out.println("La frecuencia actual es:" +this.frecuencia);
    }
    public void upFrecuencia(double frecuencia){
        if (frecuencia > 108){
            setFrecuencia(80);
        }else{ 
            setFrecuencia(frecuencia);
        } 
    }
    public void downFrecuencia(double frecuencia){
        if (frecuencia < 80){
            setFrecuencia(108);
        }else{ 
            setFrecuencia(frecuencia);
        } 
    }
    public void mostrarFrecuencia(double frecuencia){
        System.out.println("La frecuencia actual es:" +this.frecuencia);
    }


    /**
     * @return the frecuencia
     */
    public double getFrecuencia() {
        return frecuencia;
    }

    /**
     * @param frecuencia the frecuencia to set
     */
    public void setFrecuencia(double frecuencia) {
        this.frecuencia = frecuencia;
    }
    
    
}

    
    

