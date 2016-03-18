/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1.estudiante;
import java.util.Date;
/**
 *
 * @author chernandez
 */
public class Estudiante {
    
private String matricula;
private String nombres;
private String apellidos;
private String carrera;
private String direccion;
private String sexo;
private String telefono; 
private Date fechaNacim;

public void mostrarDatosEstudiante(){
    System.out.println("Matricula: "+matricula);
    System.out.println("Nombre: "+nombres+" " +apellidos);
    System.out.println("Direccion: "+direccion);
    System.out.println("Carrera: "+carrera);
    System.out.println("Telefono: "+telefono);
    System.out.println();
}
public void seleccionarDatosEstudiante(String matricula, String nombres, String apellidos, String direccion, String carrera, String telefono){
  setMatricula(matricula);
  setNombres(nombres);
  setApellidos(apellidos);
  setCarrera(carrera);
  setDireccion(direccion);
  setTelefono(telefono);
}
    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the apellidos
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param apellidos the apellidos to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the carrera
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * @param carrera the carrera to set
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the fechaNacim
     */
    public Date getFechaNacim() {
        return fechaNacim;
    }

    /**
     * @param fechaNacim the fechaNacim to set
     */
    public void setFechaNacim(Date fechaNacim) {
        this.fechaNacim = fechaNacim;
    }



}