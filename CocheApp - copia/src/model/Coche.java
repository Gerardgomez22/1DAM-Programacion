/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;
import java.util.Date;

/**
 *
 * @author gerardgomazn
 */
public class Coche extends Vehiculo {
    
    //ATRIBUTOS
    private int numPuertas;
    
    //CONSTRUCTOR
    public Coche(String iBrand, String iCarplate, String iModel, int iPower, int iCapacity, ColorEnum iColor, String iEngine, String iFechaFabricacion, transmissionEnum iTransmission, fuelTypeEnum iFuelType, int iSpeed, int iNumPuertas ,double iPeso) {
        super(iBrand, iCarplate, iModel, iPower, iCapacity, iColor, iEngine, iFechaFabricacion, iTransmission, iFuelType, iPeso);
        this.numPuertas = iNumPuertas;
        
    }
    

    public Coche(String iBrand, int iPower, int iCapacity, String iEngine) {
       super(iBrand, iPower, iCapacity, iEngine);
    }
    
   // Métodos de aceleración y frenado
    
    // Método para calcular antigüedad
    
    //SETTER



    

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }
    
    // GETTER

    public int getNumPuertas() {
        return numPuertas;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Coche{");
        sb.append(super.toString());
        sb.append(", numPuertas=").append(numPuertas);
        sb.append('}');
        return sb.toString();
    }

    public Object getMarca() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getPeso() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }






   
}
