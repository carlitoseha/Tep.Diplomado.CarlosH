/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datosestudiante;
import java.util.HashSet;
import practica1.estudiante.Estudiante;
 /*
 * @author chernandez
 */
public class DatosEstudiante {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
        Estudiante estudiante1 =  new Estudiante();
        Estudiante estudiante2 =  new Estudiante();
        Estudiante estudiante3 =  new Estudiante();
        Estudiante estudiante4 =  new Estudiante();
        Estudiante estudiante5 =  new Estudiante();
        
        estudiante1.seleccionarDatosEstudiante("19990643", "Carlos Emmanuel", "Hernández Abreu","Rincón Largo","ISC", "809-878-3987");
        estudiante2.seleccionarDatosEstudiante("20150264", "José Andrés", "Perez","Villa Olga","ITT", "809-878-3987");
        estudiante3.seleccionarDatosEstudiante("20140298", "Pedro", "Abreu","La Moraleja","ADM", "809-878-3987");
        estudiante4.seleccionarDatosEstudiante("20130584", "Emmanuel", "Hernández Abreu","Rincón Largo","ADH", "809-878-3987");
        estudiante5.seleccionarDatosEstudiante("19980843", "Omar", "Gil","La Española","PSI", "809-878-3987");

        estudiante1.mostrarDatosEstudiante();
        estudiante2.mostrarDatosEstudiante();
        estudiante3.mostrarDatosEstudiante();
        estudiante4.mostrarDatosEstudiante();
        estudiante5.mostrarDatosEstudiante();
     }
    
}
