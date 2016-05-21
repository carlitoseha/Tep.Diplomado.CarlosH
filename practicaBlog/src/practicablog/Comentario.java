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
public class Comentario extends Articulo{
    private int idcomentario;
    private String comentario;
    private String autorcomentario; 

    /**
     * @return the idcomentario
     */
    public int getIdcomentario() {
        return idcomentario;
    }

    /**
     * @param idcomentario the idcomentario to set
     */
    public void setIdcomentario(int idcomentario) {
        this.idcomentario = idcomentario;
    }

    /**
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * @return the autorcomentario
     */
    public String getAutorcomentario() {
        return autorcomentario;
    }

    /**
     * @param autorcomentario the autorcomentario to set
     */
    public void setAutorcomentario(String autorcomentario) {
        this.autorcomentario = autorcomentario;
    }
    
    
}
