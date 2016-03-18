/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcular.circulo;

/**
 *
 * @author chernandez
 */
public class Circulo {
    private double radio;
    public Circulo(double radio){
        setRadio(radio);
    }
    public double areaCirculo(){
        return (3.14*radio*radio);

    }
    public double perimetroCirculo(){
        return (2*radio*3.14);
    }
    /**
     * @return the radio
     */
    public double getRadio() {
        return radio;
    }

    /**
     * @param radio the radio to set
     */
    private void setRadio(double radio) {
        this.radio = radio;
    }
    
}
