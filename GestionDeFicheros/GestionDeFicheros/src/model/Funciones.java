package model;
 
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;


public class Funciones {


    public static void createFolder(String folderName) throws IOException {
        File folder = new File(folderName);
        if (!folder.exists()){
            folder.mkdirs();
        }
    }
    
    public static void createFile(String path, String fileName, String content) {
        File archivo = new File(path, fileName);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, true))) {
            bw.write(content);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al crear o escribir en el archivo: " + e.getMessage());
        }
    }
    
    public static String[] showListFiles(String path) {
        File carpeta = new File(path);
        if (carpeta.exists() && carpeta.isDirectory()) {
            return carpeta.list();
        }
        return new String[0];
    }
    
    public static String showFile(String path, String fileName) {
        File archivo = new File(path, fileName);
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return contenido.toString();
    }
    
    public static boolean overWriteFile(String path, String fileName, String newContent) {
        File archivo = new File(path, fileName);
        if (!archivo.exists()) return false;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, false))) {
            bw.write(newContent);
            bw.newLine();
            return true;
        } catch (IOException e) {
            System.out.println("Error al sobrescribir el archivo: " + e.getMessage());
            return false;
        }
    }
    
    public static void deleteFile(String path, String fileName) {
        File archivo = new File(path, fileName);
        if (archivo.exists()) {
            archivo.delete();
        }
    }
    
    public static int countChars(String path, String fileName) {
        String contenido = showFile(path, fileName);
        return contenido.replaceAll("\n", "").length();
    }
     
    public static int countWords(String path, String fileName) {
        String contenido = showFile(path, fileName);
        if (contenido.isEmpty()) return 0;
        String[] palabras = contenido.trim().split("\\s+");
        return palabras.length;
    }
    
    public static String swapWords(String path, String fileName, String oldWord, String newWord) {
        String contenido = showFile(path, fileName);
        String nuevoContenido = contenido.replaceAll("\\b" + oldWord + "\\b", newWord);
        overWriteFile(path, fileName, nuevoContenido);
        return nuevoContenido;
    }
    
    public static void printPDF(String path, String fileName) throws Exception {
        String textContent = showFile(path, fileName);
        String pdfPath = path + File.separator + fileName.replace(".txt", "") + ".pdf";
        Document document;
        document = new Document();
        try {
            // Corregido: se debe pasar el documento correcto a PdfWriter.getInstance
            PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
            document.open();
            document.add(new Paragraph(textContent));
            document.close();
            System.out.println("PDF created successfully at: " + pdfPath);
        } catch (IOException e) {
            throw new Exception("Error creating PDF: " + e.getMessage());
        }
    }

    
}
