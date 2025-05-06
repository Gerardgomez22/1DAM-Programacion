package view.console;

import java.util.Scanner;
import model.Funciones;

public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- GESTIÓN DE ARCHIVOS ---");
            System.out.println("1. Crear carpeta");
            System.out.println("2. Crear archivo");
            System.out.println("3. Listar archivos de carpeta");
            System.out.println("4. Mostrar contenido de archivo");
            System.out.println("5. Sobrescribir archivo");
            System.out.println("6. Borrar archivo");
            System.out.println("7. Contar caracteres");
            System.out.println("8. Contar palabras");
            System.out.println("9. Reemplazar palabra en archivo");
            System.out.println("10. Crear PDF del archivo");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.print("Nombre de la carpeta: ");
                        String folderName = sc.nextLine();
                        Funciones.createFolder(folderName);
                        System.out.println("Carpeta creada (si no existía).");
                        break;
                
            
                    case 2:
                        System.out.println("Introduce la ruta de la carpeta");
                        String path = sc.nextLine();
                        System.out.println("Introduce el nombre del archivo");
                        String fileName = sc.nextLine();
                        System.out.println("Introduce el texto a escribir dentro del archivo:");
                        String contenido = sc.nextLine();
                        Funciones.createFile(path, fileName, contenido);
                        System.out.println("Archivo creado o modificado.");
                        break;
                
                    
                    case 3:
                        System.out.println("Introduce la ruta de la carpeta: ");
                        path = sc.nextLine();
                        String[] archivos = Funciones.showListFiles(path);
                        System.out.println("Archivos de la carpeta: ");
                        for (String archivo : archivos) {
                            System.out.println("- " + archivo);
                        }
                        
                       
                    case 4:
                        System.out.print("Ruta de la carpeta: ");
                        path = sc.nextLine();
                        System.out.print("Nombre del archivo: ");
                        fileName = sc.nextLine();
                        System.out.println("Introduce el contenido que deseas introducir en el archivo:");
                        System.out.println(Funciones.showFile(path, fileName));
                        break;
                        
                       
                    case 5:
                        System.out.print("Introduce la ruta: ");
                        path = sc.nextLine();
                        System.out.print("Introduce en nombre del archivo: ");
                        fileName = sc.nextLine();
                        System.out.print("Introduce el nuevo contenido: ");
                        contenido = sc.nextLine();
                        if (Funciones.overWriteFile(path, fileName, contenido)) {
                        System.out.println("Archivo sobrescrito.");
                        } else {
                        System.out.println("No se pudo sobrescribir.");
                        }
                        break;
                    
                    
                    case 6:
                        System.out.print("Introduce la ruta: ");
                        path = sc.nextLine();
                        System.out.print("Introduce en nombre del archivo: ");
                        fileName = sc.nextLine();
                        Funciones.deleteFile(path, fileName);
                        System.out.println("Archivo eliminado.");
                        break;
                            
                    
                    case 7:
                        System.out.print("Introduce la ruta: ");
                        path = sc.nextLine();
                        System.out.print("Introduce en nombre del archivo: ");
                        fileName = sc.nextLine();
                        System.out.println("Caracteres: " + Funciones.countChars(path, fileName));
                        break;
                        
                        
                    case 8:
                        System.out.print("Introduce la ruta: ");
                        path = sc.nextLine();
                        System.out.print("Introduce en nombre del archivo: ");
                        fileName = sc.nextLine();
                        System.out.println("Palabras: " + Funciones.countWords(path, fileName));
                        break;   
                    
                        
                    case 9:
                        System.out.print("Introduce la ruta: ");
                        path = sc.nextLine();
                        System.out.print("Introduce en nombre del archivo: ");
                        fileName = sc.nextLine();
                        System.out.print("Introduce la palabra a reemplazar: ");
                        String antigua = sc.nextLine();
                        System.out.print("Introduce la nueva palabra: ");
                        String nueva = sc.nextLine();
                        String actualizado = Funciones.swapWords(path, fileName, antigua, nueva);
                        System.out.println("Contenido actualizado:\n" + actualizado);
                        break;
                        
                        
                    case 10:
                        System.out.print("Introduce la ruta: ");
                        path = sc.nextLine();
                        System.out.print("Introduce el nombre del archivo: ");
                        fileName = sc.nextLine();
                        try {
                            Funciones.printPDF(path, fileName);
                            System.out.println("PDF creado correctamente.");
                        } catch (Exception e) {
                            System.out.println("Error al crear el PDF: " + e.getMessage());
                        }
                        break;
                
                        
                
                    case 0:
                    System.out.println("Fin del programa.");
                    break;

                default:
                    System.out.println("Opción no válida.");
                        
    }
                
            } catch (NumberFormatException e) {
                System.out.println("Error: Debes introducir un número.");
                opcion = -1; 
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
                opcion = -1; 
            }
            
        } while (opcion != 0);
        
        sc.close();
        System.out.println("Programa finalizado.");
    }
}
