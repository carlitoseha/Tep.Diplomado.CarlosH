/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sintonizadordigital;
import sintonizador.frecuencia.Frecuencia;
import java.util.Scanner;
/**
 *
 * @author chernandez
 */
public class SintonizadorDigital {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        double fm = 80;
        int valor = 0;
        Frecuencia frecuencia = new Frecuencia(fm);
        
        while (valor!=3) {
           System.out.println ("1. Subir frecuencia:");
           System.out.println ("2. Bajar frecuencia:");
           System.out.println ("3. Salir:");
           valor = in.nextInt();
           if (valor == 1){
               frecuencia.upFrecuencia(frecuencia.getFrecuencia()+0.5);
            }else if (valor == 2){
               frecuencia.downFrecuencia(frecuencia.getFrecuencia()-0.5);
           }else if(valor == 3){
                return;
            }
            frecuencia.mostrarFrecuencia(frecuencia.getFrecuencia());
        }
   }
    
}
