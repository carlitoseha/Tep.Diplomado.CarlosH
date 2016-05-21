/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicablog;

/**
 *
 * @author chernandez
 */
public class Etiqueta extends Articulo{
    private int idetiqueta;
    private String etiqueta;

    /**
     * @return the id
     */
   
    public int getIdetiqueta() {
        return idetiqueta;
    }

    /**
     * @param id the id to set
     */
 
    public void setIdetiqueta(int id) {
        this.idetiqueta = id;
    }

    /**
     * @return the etiqueta
     */
    public String getEtiqueta() {
        return etiqueta;
    }

    /**
     * @param etiqueta the etiqueta to set
     */
    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }
    
}
