package model.validations;

import java.util.Scanner;
import java.time.LocalDate;

/**
 *
 * @author gerardgomazn
 */
public class UserDataValidations {

    static Scanner sc = new Scanner(System.in);
    
/**
 * Comprueba si un NIF es válido.
 * @param typeDoc el tipo de documento (1 para NIF).
 * @param id el NIF a verificar.
 * @return true si el NIF es válido, false en caso contrario.
 */
    public static boolean checkId(int typeDoc, String id) {
        if (typeDoc != 1 || id == null || id.length() != 9) {
            return false;
        }
        String numPart = id.substring(0, 8);  
        char letterPart = id.charAt(8);      
        if (!numPart.matches("\\d+")) { // ("\\d+") comprueba que todos los valores son números.
            return false;
        }
        
        String validLetters = "TRWAGMYFPDXBNJZSQVHLCKE";
        int num = Integer.parseInt(numPart);
        char correctLetter = validLetters.charAt(num % 23);
        return letterPart == correctLetter;
    }
    
/**
 * Verifica si una fecha tiene un formato válido (dd/MM/yyyy).
 * @param date la fecha en formato dd/MM/yyyy.
 * @return true si el formato es válido, false en caso contrario.
 */
    public static boolean checkFormatDate(String date){
        boolean resultado = false;
 
        if (date == null || date.length() != 10) {
            return resultado;
        }
 
        String[] partes = date.split("/");
 
        if (partes.length != 3) {
            return resultado;
        }
 
        int day = Integer.parseInt(partes[0]);
        int month = Integer.parseInt(partes[1]);
        int year = Integer.parseInt(partes[2]);
 
        if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1000 || year > 9999) {
            return resultado;
        }
 
        if (month == 2) {
 
            if ((year % 4 == 0 && (year% 100 != 0 || year % 400 == 0))) {
                if (day > 29) {
                    return resultado;
                }
            } else {
                if (day > 28) {
                    return resultado;
                }
            }
        } else if (month== 4 || month == 6 || month == 9 || month == 11) {
            if (day > 30) {
                return resultado;
            }
        } else if (day > 31) {
            return resultado;
        }
 
        resultado = true;
        return resultado;
    } 
/**
 * Calcula la edad a partir de una fecha de nacimiento.
 * @param date la fecha de nacimiento en formato dd/MM/yyyy.
 * @return la edad calculada o -1 si la fecha no es válida.
 */
    public static int CalculateAge(String date) {
        int resultado = -1;
        LocalDate FechaHoy = LocalDate.now();
 
        if (date == null || date.length() != 10) {
            return resultado;
        }
        String[] partes = date.split("/");
 
        if (partes.length != 3) {
            return resultado;
        }
 
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int año = Integer.parseInt(partes[2]);
 
        if (mes == 2) {
 
            if ((año % 4 == 0 && (año % 100 != 0 || año % 400 == 0))) {
                if (dia > 29) {
                    return resultado;
                }
            } else {
                if (dia > 28) {
                    return resultado;
                }
            }
        } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            if (dia > 30) {
                return resultado;
            }
        } else if (dia > 31) {
            return resultado;
        }
        int DiaHoy = FechaHoy.getDayOfMonth();
        int MesHoy = FechaHoy.getMonthValue();
        int AñoHoy = FechaHoy.getYear();
 
        if ((año < 1900) || (año > AñoHoy)) {
            return resultado;
        } else {
            int edad = AñoHoy - año;
            if (((MesHoy < mes) || MesHoy == mes && DiaHoy < dia)) {
                edad--;
            }
            return resultado = edad;
        }
 
    }
 /**
 * Verifica si el codigo postal es correcto.
 * @param zip un array de códigos postales en formato String.
 * @return true si todos los valores son numéricos, false en caso contrario.
 */
    public static boolean checkPostalCode(String[] zip) {
        boolean result = false;
        if (zip == null || zip.length == 0) {
            System.out.println("El array está vacío o es nulo.");
            return result;
        }
        for (String string : zip) {
            try {
                Integer.parseInt(string);
            } catch (NumberFormatException e) {
                return result;
            }
        }
 
        result = true;
        return result;
    }
  /**
 * Comprueba si una cadena es numérica.
 * @param str la cadena a evaluar.
 * @return true si la cadena es numérica, false en caso contrario.
 */
    public static boolean isNumeric(String str) {
        boolean result = false;
        if (str == null || str.isEmpty()) {
            return result;
        }
        try {
            Integer.parseInt(str);
            result = true;
            return result;
        } catch (NumberFormatException e) {
            return result;
        }
    }
/**
 * Comprueba si una cadena contiene solo caracteres alfabéticos.
 * @param str la cadena a evaluar.
 * @return true si la cadena contiene solo caracteres alfabéticos, false en caso contrario.
 */
    public static boolean isAlphabetic(String str) {
        boolean result = false;
        if (str == null || str.isEmpty()) {
            return result;
        }
        try {
            Integer.parseInt(str);
            return result;
        } catch (NumberFormatException e) {
            result = true;
            return result;
        }
    }
    
/**
 * Comprueba si un correo electrónico tiene un formato válido.
 * @param email el correo electrónico a verificar.
 * @return true si el formato es válido, false en caso contrario.
 */
    public static boolean checkEmail(String email){
        String[] arroba = email.split("@");
        String[] punto= email.split("\\.");
        boolean result = false;
        if (email == null || email.isEmpty()){
            return result;
        }
        else if (arroba.length != 2 || punto.length < 2){
            return result;
        }
        else if (arroba[0].isEmpty()){
            return result;
        }
        else
            result = true;
        return result;
}
/**
 * Verifica si un nombre es válido (alfabético y longitud entre 1 y 30).
 * @param name el nombre a verificar.
 * @return true si el nombre es válido, false en caso contrario.
 */    
    public static boolean checkName(String name){
        boolean result = false;
        if ((name.length() < 1) || (name.length() > 30 )){
            return result;    
        }
        for (char test : name.toCharArray()) {
            if (!Character.isAlphabetic(test)){
                return result;
            }
            
        }
        result = true;
        return result;
    }
}

