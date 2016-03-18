/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.edificio;

/**
 *
 * @author chernandez
 */
public class Edificio {
    private int cantPisos;
    private String nombre;
    private int cantPuertas ;
    private int cantEmpleados;
        
    public Edificio(){

    }
    public Edificio(int cantPisos, String nombre, int cantPuertas){
        // System.out.printf("El edificio " +nombre+" tendrá "+cantPisos+" pisos y "+cantPuertas+" puertas. \n");
         setNombre(nombre);
         setCantPisos(cantPisos);
         setCantPuertas(cantPuertas);
         cantidadEmpleadosNecesarios(cantPisos, cantPuertas);
    }
    
    private void cantidadEmpleadosNecesarios(int cantPisos, int cantPuertas){
        setCantEmpleados(cantPuertas/cantPisos);
     }
    /**
     * @return the cantPisos
     */
    public int getCantPisos() {
        return cantPisos;
    }

    /**
     * @param cantPisos the cantPisos to set
     */
    private void setCantPisos(int cantPisos) {
        this.cantPisos = cantPisos;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the cantPuertas
     */
    public int getCantPuertas() {
        return cantPuertas;
    }

    /**
     * @param cantPuertas the cantPuertas to set
     */
    private void setCantPuertas(int cantPuertas) {
        this.cantPuertas = cantPuertas;
    }

    /**
     * @return the empleado
     */
    public int getCantEmpleados() {
        return cantEmpleados;
    }

    /**
     * @param empleado the empleado to set
     */
    public void setCantEmpleados(int empleado) {
        this.cantEmpleados = empleado;
    }
    

   
}

