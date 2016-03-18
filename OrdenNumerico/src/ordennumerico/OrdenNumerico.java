/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordennumerico;

/**
 *
 * @author chernandez
 */
public class OrdenNumerico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Cantidad de valores iniciales
        int cant = args.length;
        int[] arre_val = new int[cant];
        
        //Pasando los valores al arreglo númerico
        for (int i = 0 ; i < cant ; i++){
            arre_val[i] =  Integer.parseInt(args[i]);
        }
        //Si el arreglo esta ordenado desde la entrada de valores iniciales
        if (ordenar(arre_val, cant) == 1){
             System.out.println("Las cantiddades introducidas están en orden númerico"); 
        }
            
       }
    //Esta funcion ordena en arreglo de enteros pasado por parametro
    //Retorna 1 si viene ordenado, 0 si no.
    public static int ordenar(int arre_val[], int cant){
          int temp = 0;
          int no_ordenado = 0;
          int ordenado = 0;
            if (cant > 1) {    
               for (int i = 0 ; i < cant ; i++) {
                 for (int j = i+1 ; j < cant ; j++) {
                      if (arre_val[j] < arre_val[i]){
                        temp = arre_val[i];
                        arre_val[i] = arre_val[j];
                        arre_val[j] = temp;
                        no_ordenado++;
                      } 
                   }
                  if (no_ordenado == 0){
                          ordenado++;
               }
                }  
                if (ordenado != cant){
                     System.out.println("Las cantidades introducidas no están en orden númerico");
                     System.out.printf("El orden correcto es: "); 
                     for (int i = 0 ; i < cant ; i++){
                     System.out.printf("%d ",arre_val[i]);
                    }
                     System.out.println(); 
                    return 0;
                }else{
                    return 1;
                }
           }       
            return 0;
    }
}
