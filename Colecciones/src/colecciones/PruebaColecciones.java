/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colecciones;
import edu.pucmm.javabasico.objetos.Estudiante;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author chernandez
 */
public class PruebaColecciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Punto 2");
        MiColeccion coleccion1 = new MiColeccion();
        MiColeccion coleccion2 = new MiColeccion(5);
       
        System.out.println("");
        if (coleccion1.add(new Estudiante())) {
            System.out.println("Objecto agregado.");
        }
         else{
            System.out.println("Error agregando objecto.");
        }
       
        if ( coleccion1.add(new Estudiante(19990643))){
            System.out.println("Objecto agregado.");
        }
         else{
            System.out.println("Error agregando objecto.");
        }
    
        if ( coleccion1.add(new Estudiante(19990643))){
            System.out.println("Objecto agregado.");
        }
         else{
            System.out.println("Error agregando objecto.");
        }
     
        if ( coleccion2.add(new Estudiante(19990643))){
            System.out.println("Objecto agregado.");
        }
         else{
            System.out.println("Error agregando objecto.");
        }
         if ( coleccion1.add(new Estudiante(19990643))){
            System.out.println("Objecto agregado.");
        }
         else{
            System.out.println("Error agregando objecto.");
        }
         System.out.println("");
         System.out.println("Tamaño arreglo1:" + coleccion1.size());
         System.out.println("Tamaño arreglo2:" + coleccion2.size());        
         
         System.out.println("");
         
         System.out.println("------------------ Punto 3 -------------------");
     
        List coleccion3 = new ArrayList<>();
        List coleccion4 = new LinkedList<>();
                  
        coleccion3.add(coleccion1);
        coleccion3.add(coleccion2);
        coleccion3.add(coleccion2);
          
        coleccion4.add(coleccion2);
        coleccion4.add(coleccion1);
        
        recorrerLista(coleccion3);
        recorrerLista(coleccion4);
    }
     public static void recorrerLista(List <java.util.List> lista){ 
         
        for (java.util.List coleccion : lista) {
            System.out.println("Colección: " + coleccion.getClass().getName());  
         }
        System.out.println("Tamaño Lista:" + lista.size());
        System.out.println("----------------------------------------");
    }
    
}