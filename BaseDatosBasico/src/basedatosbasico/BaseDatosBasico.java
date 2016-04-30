/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedatosbasico;

import java.util.List;

/**
 *
 * @author tepcurso03
 */
public class BaseDatosBasico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      
        // TODO code application logic here
        EstudianteServices estudianteServices = new EstudianteServices();
        estudianteServices.testConexion();
        
        List<Estudiante> listaEstudiantes = estudianteServices.listaEstudiantes();
        System.out.println("La cantidad de estudiantes: "+listaEstudiantes.size());
        for(Estudiante est : listaEstudiantes){
            System.out.println("La matricula: "+est.getMatricula());
        }
        
        Estudiante estudiante = estudianteServices.getEstudiante(200111136);
        if(estudiante!=null){
        System.out.println("El nombre es: "+estudiante.getNombre());
        }else{
            System.out.println("No exite el usuario consultado");
        }
        
        Estudiante insertar = new Estudiante();
        insertar.setMatricula(99999);
        insertar.setNombre("Otro");
        insertar.setApellido("Otro");
        insertar.setTelefono("4545");
        insertar.setCarrera("ISC");
        if(estudianteServices.getEstudiante(insertar.getMatricula())==null){
            estudianteServices.crearEstudiante(insertar);
        }
        
        insertar.setNombre("Cambiando el nombre.....");
        estudianteServices.actualizarEstudiante(insertar);
        
       estudianteServices.borrarEstudiante(insertar.getMatricula());

    }
     
}
