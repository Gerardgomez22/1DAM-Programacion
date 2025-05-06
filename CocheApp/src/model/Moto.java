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
public class Moto extends Vehiculo{  
    private boolean tieneSidecar;
    private int cilindrada;
    
    
    //CONSTRUCTOR
    
    public Moto(String iBrand, String iCarplate, String iModel, int iPower, int iCapacity, ColorEnum iColor, String iEngine,String iFechaFabricacion, transmissionEnum iTransmission, fuelTypeEnum iFuelType, boolean iTieneSidecar, int iCilindrada, double iPeso){
        super(iBrand, iCarplate, iModel, iPower, iCapacity, iColor, iEngine, iFechaFabricacion, iTransmission, iFuelType, iPeso);
        this.tieneSidecar = iTieneSidecar;
        this.cilindrada = iCilindrada;
        
    }

    public Moto(String iBrand, int iPower, int iCapacity, String iEngine) {
        super(iBrand, iPower, iCapacity, iEngine);
    }
    
   // Métodos de aceleración y frenado
   

    public void setTieneSidecar(boolean tieneSidecar) {    
        this.tieneSidecar = tieneSidecar;
    }

    // Método para calcular antigüedad
    //SETTER
    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }   

    // GETTER

    public boolean isTieneSidecar() {
        return tieneSidecar;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Moto{");
        sb.append("tieneSidecar=").append(tieneSidecar);
        sb.append(", cilindrada=").append(cilindrada);
        sb.append('}');
        return sb.toString();
    }
 
   
}
