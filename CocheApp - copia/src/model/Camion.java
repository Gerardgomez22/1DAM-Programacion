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
public class Camion extends Vehiculo {  
    private double carga;
    private double altura;
    
    
    //CONSTRUCTOR
    
    public Camion(String iBrand, String iCarplate, String iModel, int iPower, int iCapacity, ColorEnum iColor, String iEngine, String iFechaFabricacion, transmissionEnum iTransmission, fuelTypeEnum iFuelType, double iCarga, double iAltura, double iPeso){
        super(iBrand, iCarplate, iModel, iPower, iCapacity, iColor, iEngine, iFechaFabricacion, iTransmission, iFuelType, iPeso);
        this.carga = iCarga;
        this.altura = iAltura;
        
    }

    public Camion(String iBrand, int iPower, int iCapacity, String iEngine) {
        super(iBrand, iPower, iCapacity, iEngine);
    }
    
   // Métodos de aceleración y frenado
    
    // Método para calcular antigüedad
    
    //SETTER

    public void setCarga(double carga) {
        this.carga = carga;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    // GETTER

    public double getCarga() {
        return carga;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Camion{");
        sb.append(super.toString());
        sb.append(", carga=").append(carga);
        sb.append(", altura=").append(altura);
        sb.append('}');
        return sb.toString();
    }
                    




   
}
