/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package construiredificio;
import proyecto.edificio.Edificio;
/**
 *
 * @author chernandez
 */
public class ConstruirEdificio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Edificio edificio1 = new Edificio(10,"Torre Bella",200);
       Edificio edificio2 = new Edificio(15,"Torre Linda",252);
       Edificio edificio3 = new Edificio(18,"Torre Villa",290);
       Edificio edificio4 = new Edificio(20,"Torre Olga",360);
       
       System.out.printf("Nombre: %s, Pisos: %d, Puertas: %d, Empleados: %d \n", edificio1.getNombre(),edificio1.getCantPisos(),edificio1.getCantPuertas(), edificio1.getCantEmpleados());
       System.out.printf("Nombre: %s, Pisos: %d, Puertas: %d, Empleados: %d \n", edificio2.getNombre(),edificio2.getCantPisos(),edificio2.getCantPuertas(), edificio2.getCantEmpleados());
       System.out.printf("Nombre: %s, Pisos: %d, Puertas: %d, Empleados: %d \n", edificio3.getNombre(),edificio3.getCantPisos(),edificio3.getCantPuertas(), edificio3.getCantEmpleados());
       System.out.printf("Nombre: %s, Pisos: %d, Puertas: %d, Empleados: %d \n", edificio4.getNombre(),edificio4.getCantPisos(),edificio4.getCantPuertas(), edificio4.getCantEmpleados());
    
    }
    
}
