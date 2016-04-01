/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.pucmm.javabasico.objetos;

//import java.lang.String // Es un import implicito..
import java.util.Date;

/**
 * Una clase es un conjunto de propiedades + acciones
 * @author vacax
 */
public class Estudiante {
    
    //Propiedes.
    // Modificador + tipo + nombre [= valor]
    
    //Modificadores: privados, publicos, predterminos o protegidos.
    //Valores primitivos o Objetos..
    //El nombre representa el identificar o el puntero al objeto.
    
    private int matricula; //Solo es visible en la misma clase.
    public String nombre; //visible en todos los lugares.
    String apellido; // Solo visible dentro de elementos del mismo paquete. (Predeterminado)
    protected String telefono; //visible en el paquete y herencia.
    
    private Date fechaNacimiento;
    public static String propiedadClase = "Valor estatico";
    
    //Constructor implicito...
    public Estudiante(){
        System.out.println("Iinicializando la clase Estudiante vacio..."); 
    }
    
    public Estudiante(int matricula){
        //this y super..
        this.matricula = matricula; //Ambito de la variable.
        fechaNacimiento =  new Date();
        System.out.println("Inicializando la clase con matricula:" +this.getClass().getName());
    }
    
    public Estudiante(int matricula, String nombre){
        this.matricula = matricula;
        this.nombre = nombre;
    }
    
    
    //modificador de acceso + retorno (Tipo de Dato) + nombre  +[parametos(tipo + nombre)]
    public void mostrarInformacionEstudiante(){ //ver la convención de nombre...
        System.out.printf("Matricula: %d, Nombre: %s, Apellido: %s, Telefono: %s \n", matricula, nombre, apellido, telefono);
        metodoPrivado();
    }
    
    //Para estabecer valor ("Setear")
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    
    private void metodoPrivado(){
        //Visible dentro de la clase..
        return; //retorno  implicito..
    }
    
    public Date getFechaNacimiento(){
        return fechaNacimiento;
    }
    
    /**
     * 
     * @param pasoPorValor
     * @param estudiante  
     */
    public void pruebaReferenciaYValorEnVariables(int pasoPorValor, Estudiante estudiante){
        pasoPorValor +=10;
        estudiante.nombre+="__ Otro Valor....";
    }
    
     public static Estudiante evitandoCambioDeReferenciaObjeto(final Estudiante estudiante){
        //estudiante = new Estudiante(444444, "Otro Estudiante");
        estudiante.nombre = "";
        return estudiante;
    }
    
    //la palabra static.
    public static void metodoClase(){
        System.out.println("Metodo de clase...");
    }
    
}
