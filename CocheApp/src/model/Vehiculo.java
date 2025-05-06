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
public class Vehiculo {  
    private String brand;
    private String carplate;
    private String model;
    private int power;
    private int capacity;
    private ColorEnum color;
    private String engine;
    private double speed;
    private int brake;
    private String fechaFabricacion;
    private transmissionEnum transmission;
    private fuelTypeEnum fuelType;
    private double peso;

    
    
    //CONSTRUCTOR
    
    public Vehiculo(String iBrand, String iCarplate, String iModel, int iPower, int iCapacity, ColorEnum iColor, String iEngine,String iFechaFabricacion, transmissionEnum iTransmission, fuelTypeEnum iFuelType, double iPeso){
        this.brand = iBrand;
        this.carplate = iCarplate;
        this.model = iModel;
        this.power = iPower;
        this.capacity = iCapacity;
        this.color = iColor;
        this.engine = iEngine;
        this.transmission = iTransmission;
        this.fuelType = iFuelType;
        setSpeed(speed);
        this.fechaFabricacion = iFechaFabricacion;
        this.peso = iPeso;

        
    }

    public Vehiculo(String brand, int power, int capacity, String engine) {
        this.brand = brand;
        this.power = power;
        this.capacity = capacity;
        this.engine = engine;
    }

   public Vehiculo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
   // Métodos de aceleración y frenado
    public void accelerate() {
        double MAX_SPEED = 330;
        this.speed = Math.min(this.speed + 10, MAX_SPEED);
    }
    
    public void accelerate(double amount) {
        double MAX_SPEED = 330;
        this.speed = Math.min(this.speed + amount, MAX_SPEED);
    }
    
    public void brake() {
        this.speed = Math.max(this.speed - 10, 0);
    }
    
    public void brake(double amount) {
        this.speed = Math.max(this.speed - amount, 0);
    }
    
    // Método para calcular antigüedad
    
    //SETTER
    public void setBrand(String marca) {
        if ((brand.equals("Ferrari") || marca.equals("Masserati"))){
            brand = marca;
        }
}
    public void setCarplate(String carplate){
        this.carplate = carplate;
}
    public void setModel(String model){
        this.model = model;
    }

    public void setSpeed(double speed) {
        if (speed >= 0){
        this.speed = speed;
        }
        else{
            
        }
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setColor(ColorEnum color) {
        this.color = color;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setBrake(int brake) {
        this.brake = brake;
    }

    public void setFuelType(fuelTypeEnum fuelType) {
        this.fuelType = fuelType;
    }   

    public void setFechaFabricacion(String fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    
    
    // GETTER
    public String getBrand() {
        return brand;
    }

    public String getCarplate() {
        return carplate;
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public int getCapacity() {
        return capacity;
    }

    public ColorEnum getColor() {
        return color;
    }

    public String getEngine() {
        return engine;
    }

    public double getSpeed() {
        return speed;
    }


    public int getBrake() {
        return brake;
    }

    public String getFechaFabricacion() {
        return fechaFabricacion;
    }
    

    public transmissionEnum getTransmission() {
        return transmission;
    }

    public fuelTypeEnum getFuelType() {
        return fuelType;
    }

    public int getPeso(int peso) {
        return peso;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vehiculo{");
        sb.append("brand=").append(brand);
        sb.append(", carplate=").append(carplate);
        sb.append(", model=").append(model);
        sb.append(", power=").append(power);
        sb.append(", capacity=").append(capacity);
        sb.append(", color=").append(color);
        sb.append(", engine=").append(engine);
        sb.append(", speed=").append(speed);
        sb.append(", brake=").append(brake);
        sb.append(", fechaFabricacion=").append(fechaFabricacion);
        sb.append(", transmission=").append(transmission);
        sb.append(", fuelType=").append(fuelType);
        sb.append(", peso=").append(peso);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
    public int calcularAntiguedad(){
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Period p = Period.between(LocalDate.parse(fechaFabricacion, dateTimeFormatter), currentDate);
        return p.getYears();
    }
    //METODOS PROPIOS
    
    public double calcularConsumo(){
        return(1);
    }



   
}
