/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reproductordemedia;

/**
 *
 * @author chernandez
 */
public class Video implements IReproductorMedia {
    
     @Override
    public void ejecutar() {
        System.out.println("Ejecutando Video");
    }

    @Override
    public void detener() {
        System.out.println("Deteniendo Video");
    }

    @Override
    public void rebobinar() {
        System.out.println("Rebobinando Video");
    }

    @Override
    public void avanzar() {
        System.out.println("Avanzando Video");
    }

    @Override
    public void grabar() {
        System.out.println("Grabando Video");
    }
     
}
