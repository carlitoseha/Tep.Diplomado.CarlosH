/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reproductordemedia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chernandez
 */
public class PruebaReproducible {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Audio audio1 = new Audio();
        Video video1 = new Video();
        Audio audio2 = new Audio();
        
        //Una lista de interfase media
        List<IReproductorMedia> mediaLista = new ArrayList<>();
        
        //Agregando a la lista de interfase, un objeto de la clase audio
        mediaLista.add(audio1);
         //Agregando a la lista de interfase, un objeto de la clase video
        mediaLista.add(video1);
         //Agregando a la lista de interfase, un objeto de la clase audio
        mediaLista.add(audio2);
        
        //invocando el metodo reproducir media, enviandole la lista de interfase 
        procesarReproductoresMedia(mediaLista);
      
    }
    
    public static void procesarReproductoresMedia(List <IReproductorMedia> lista){
        //recorriendo la lista de interfase y viendo los metodos de cada objeto (audio y video) de la misma. 
        for (IReproductorMedia media : lista) {
             media.ejecutar();
             media.avanzar();
             media.grabar();
             media.rebobinar();
             media.detener();
             System.out.println("----------------------------------------");
         }
    }
}
