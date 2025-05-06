/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.console;

import java.util.ArrayList;
import java.util.Scanner;
import model.Camion;
import model.Coche;
import model.Moto;
import model.Vehiculo;
import model.fuelTypeEnum;
import model.ColorEnum;
import model.fuelTypeEnum;
import model.transmissionEnum;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
        boolean salir = false;
        while (!salir) {

            System.out.println("Menú:");

            System.out.println("1. Crear un objeto de tipo Coche");

            System.out.println("2. Crear un objeto de tipo Moto");

            System.out.println("3. Crear un objeto de tipo Camion");

            System.out.println("4. Mostrar las matrículas de todos los vehículos");

            System.out.println("5. Pedir la matrícula de un vehículo y mostrar todos sus datos");

            System.out.println("6. Mostrar el total de vehículos creados");

            System.out.println("7. Mostrar el total de coches creados");

            System.out.println("8. Mostrar el total de motos creadas");

            System.out.println("9. Mostrar el total de camiones creados");

            System.out.println("10. Pedir la matrícula de un vehículo y eliminarlo del ArrayList");

            System.out.println("0. Salir");

            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();

            scanner.nextLine();

            switch (opcion) {

                case 1:

                    System.out.println("Introduce la marca del coche:");
                    String iBrand = scanner.nextLine();

                    System.out.println("Introduce la matrícula del coche:");
                    String iCarplate = scanner.nextLine();

                    System.out.println("Introduce el modelo del coche:");
                    String iModel = scanner.nextLine();

                    System.out.println("Introduce la potencia del coche:");
                    int iPower = scanner.nextInt();

                    System.out.println("Introduce el peso del coche:");
                    double iPeso = scanner.nextDouble();

                    System.out.println("Introduce la capacidad del coche:");
                    int iCapacity = scanner.nextInt();

                    scanner.nextLine();

                    System.out.println("Introduce el motor del coche:");
                    String iEngine = scanner.nextLine();

                    System.out.println("Introduce el color del coche:");
                    ColorEnum color = ColorEnum.valueOf(scanner.nextLine().toUpperCase());

                    System.out.println("Introduce el tipo de combustible del coche (GASOLINA, DIESEL, ELECTRICO, HIBRIDO, GAS):");
                    transmissionEnum transmision = transmissionEnum.valueOf(scanner.nextLine().toUpperCase());

                    System.out.println("Introduce la velocidad del coche:");
                    int iSpeed = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Introduce el tipo de combustible del coche (GASOLINA, DIESEL, ELECTRICO, HIBRIDO, GAS):");
                    fuelTypeEnum combustible = fuelTypeEnum.valueOf(scanner.nextLine().toUpperCase());

                    System.out.println("Introduce la fecha de fabricación del coche (formato: yyyy-MM-dd):");
                    String iFechaFabricacion = scanner.nextLine();

                    System.out.println("Introduce el número de puertas del coche:");
                    int iNumPuertas = scanner.nextInt();

                    Coche coche = new Coche(iBrand, iCarplate, iModel, iPower, iCapacity, color, iEngine, iFechaFabricacion, transmision, combustible, iSpeed, iNumPuertas, iPeso);

                    listaVehiculos.add(coche);

                    break;

                case 2:

                    
                    System.out.println("Introduce la marca de la moto:");
                    String brand = scanner.nextLine();

                    System.out.println("Introduce la matrícula de la moto:");
                    String carPlate = scanner.nextLine();

                    System.out.println("Introduce el modelo de la moto:");
                    String model = scanner.nextLine();

                    System.out.println("Introduce la potencia de la moto:");
                    int power = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Introduce el peso de la moto:");
                    double peso = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Introduce la capacidad de la moto:");
                    int capacity = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Introduce el motor de la moto:");
                    String engine = scanner.nextLine();

                    System.out.println("Introduce el color de la moto:");
                    ColorEnum colormoto = ColorEnum.valueOf(scanner.nextLine().toUpperCase());

                    System.out.println("Introduce la velocidad de la moto:");
                    int speed = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Introduce el tipo de combustible de la moto (PETROL, DIESEL, ELECTRIC, HIBRID, GAS):");
                    fuelTypeEnum combustibleMoto = fuelTypeEnum.valueOf(scanner.nextLine().toUpperCase());

                    System.out.println("Introduce la fecha de fabricación de la moto (formato: yyyy-MM-dd):");
                    String fechaFabricacion = scanner.nextLine();

                    System.out.println("¿La moto tiene sidecar? (true/false):");
                    boolean tieneSidecarMoto = scanner.nextBoolean();
                    scanner.nextLine();

                    System.out.println("Introduce la cilindrada de la moto:");
                    int cilindradaMoto = scanner.nextInt();
                    scanner.nextLine();

                    Moto moto = new Moto(brand, carPlate, model, power, peso, capacity, colormoto, engine, speed, combustibleMoto, fechaFabricacion, tieneSidecarMoto, cilindradaMoto);

                    listaVehiculos.add(moto);

                    break;

                case 3:

                    
                    System.out.println("Introduce la marca del camión:");
                    String marcaCamion = scanner.nextLine();

                    System.out.println("Introduce la matrícula del camión:");
                    String matriculaCamion = scanner.nextLine();

                    System.out.println("Introduce el modelo del camión:");
                    String modeloCamion = scanner.nextLine();

                    System.out.println("Introduce la potencia del camión:");
                    int potenciaCamion = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Introduce el peso del camión:");
                    double pesoCamion = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Introduce la capacidad del camión:");
                    int capacidadCamion = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Introduce el color del camión:");
                    ColorEnum colorCamion = ColorEnum.valueOf(scanner.nextLine().toUpperCase());

                    System.out.println("Introduce el motor del camión:");
                    String motorCamion = scanner.nextLine();

                    System.out.println("Introduce la velocidad del camión:");
                    int velocidadCamion = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Introduce los frenos del camión:");
                    int frenosCamion = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Introduce el tipo de combustible del camión (GASOLINA, DIESEL, ELECTRICO, HIBRIDO, GAS):");
                    fuelTypeEnum tipoCombustibleCamion = fuelTypeEnum.valueOf(scanner.nextLine().toUpperCase());

                    System.out.println("Introduce la fecha de fabricación del camión (formato: yyyy-MM-dd):");
                    String fechaFabricacionCamion = scanner.nextLine();

                    System.out.println("Introduce la carga del camión:");
                    double cargaCamion = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Introduce la altura del camión:");
                    double alturaCamion = scanner.nextDouble();
                    scanner.nextLine();


                    Camion camion = new Camion(cargaCamion, alturaCamion, marcaCamion, matriculaCamion, modeloCamion, potenciaCamion, pesoCamion, capacidadCamion, colorCamion, motorCamion, velocidadCamion, frenosCamion, tipoCombustibleCamion, fechaFabricacionCamion);

                    listaVehiculos.add(camion);

                    break;

                case 4:

                    
                    System.out.println("Matrículas de todos los vehículos creados:");

                    for (Vehiculo vehiculo : listaVehiculos) {

                        System.out.println(vehiculo.getCarplate());

                    }

                    break;

                case 5:

                    // Pedir la matrícula de un vehículo y mostrar todos sus datos
                    System.out.println("Introduce la matrícula del vehículo:");

                    String matriculaBuscar = scanner.nextLine();

                    boolean encontrado = false;

                    for (Vehiculo vehiculo : listaVehiculos) {

                        if (vehiculo.getCarplate().equals(matriculaBuscar)) {

                            System.out.println(vehiculo);

                            encontrado = true;

                            break;

                        }

                    }

                    if (!encontrado) {

                        System.out.println("Vehículo no encontrado.");

                    }

                    break;

                case 6:

                    
                    System.out.println("Total de vehículos creados: " + listaVehiculos.size());

                    break;

                case 7:

                    // Mostrar el total de coches creados
                    int totalCoches = 0;

                    for (Vehiculo vehiculo : listaVehiculos) {

                        if (vehiculo instanceof Coche) {

                            totalCoches++;

                        }

                    }

                    System.out.println("Total de coches creados: " + totalCoches);

                    break;

                case 8:

                    // Mostrar el total de motos creadas
                    int totalMotos = 0;

                    for (Vehiculo vehiculo : listaVehiculos) {

                        if (vehiculo instanceof Moto) {

                            totalMotos++;

                        }

                    }

                    System.out.println("Total de motos creadas: " + totalMotos);

                    break;

                case 9:

                    // Mostrar el total de camiones creados
                    int totalCamiones = 0;

                    for (Vehiculo vehiculo : listaVehiculos) {

                        if (vehiculo instanceof Camion) {

                            totalCamiones++;

                        }

                    }

                    System.out.println("Total de camiones creados: " + totalCamiones);

                    break;

                case 10:

                    // Pedir la matrícula de un vehículo y eliminarlo del ArrayList
                    System.out.println("Introduce la matrícula del vehículo a eliminar:");

                    String matriculaEliminar = scanner.nextLine();

                    boolean eliminado = false;

                    for (Vehiculo vehiculo : listaVehiculos) {

                        if (vehiculo.getCarplate().equals(matriculaEliminar)) {

                            listaVehiculos.remove(vehiculo);

                            eliminado = true;

                            System.out.println("Vehículo eliminado.");

                            break;

                        }

                    }

                    if (!eliminado) {

                        System.out.println("Vehículo no encontrado.");

                    }

                    break;

                case 0:

                    salir = true;

                    break;

                default:

                    System.out.println("Opción no válida. Intenta de nuevo.");

            }

        }

        scanner.close();

    }

}

//    static Scanner sc = new Scanner(System.in);
//    
//    public static void main(String[] args){
//        Coche coche1;
//        coche1 = new Coche();
//        
//        System.out.println(coche1);
//        coche1.setBrand("Ferrari"); //Asignamos un valor al atributo marca de coche1
//        //coche1.brand = "toyota";
//        System.out.println("marca: " + coche1.getBrand()); // Obtenemos el valor del atributo marca de coche1
//        System.out.println("potencia: " + coche1.getPower());
//       //System.out.println("color: " + coche1.color);
//
//        Coche coche2 = new Coche("Toyota", "1111YPK", "Yaris", 400, 5, ColorEnum.BLUE, "ELECTRICO");
//        
//        System.out.println("coche2: " + coche2.getCarplate());
//        System.out.println(coche2.toString());
//        Coche coche3;
//        
//        coche3 = coche2;
//        
//        coche3.setCarplate("2222KYP");
//        
//        System.out.println("coche2: " + coche2.getCarplate());
//        
//        Coche coche4 = new Coche("Toyota", "1111KYP", "Yaris", 400, 5, ColorEnum.AZUL, "ELECTRICO");
//        
//        if (coche4 == coche2){
//            System.out.println("iguales");
//        }
//        else{
//            System.out.println("diferentes");
//        }

