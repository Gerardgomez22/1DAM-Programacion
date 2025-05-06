/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.console;

import java.util.Scanner;
import model.validations.UserDataValidations;
import static model.validations.UserDataValidations.checkFormatDate;

/**
 *
 * @author gerardgomazn
 */
public class Main {
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args){
        String option;
        do{
            System.out.println("1.- Tester checkID");
            System.out.println("2.- Tester checkFormatDate");
            System.out.println("3.- Tester calculateAge");
            System.out.println("4.- Tester checkPostalCode");
            System.out.println("5.- Tester isNumeric");
            System.out.println("6.- Tester isAlphabetic");
            System.out.println("7.- Tester checkEmail");
            System.out.println("8.- Tester checkName");
            System.out.println("z.- Salir");
            
            System.out.println("Option: ");
             option= sc.next();
            
            switch (option){
                case "1":
                    testCheckId();
                    break;
                case "2":
                    testCheckFormateDate();
                    break;
                case "3":
                    testCalculateAge();
                    break;
                case "4":
                    testCheckPostalCode();
                    break;
                case "5":
                    testIsNumeric();
                    break;
                case "6":
                    testIsAlphabetic();
                    break;
                case "7":
                    testCheckEmail();
                    break;
                case "8":
                    testCheckName();
                    break;
                case "z":
                    System.out.println("Adios bomboclat");
                    break;
                default:
                    System.out.println("Incorrect option");
            }
        }while (!option.equals("z"));    
        }
   static void testCheckId(){
        System.out.println("NIF validator");
        System.out.println("Enter your ID: ");
        String nif = sc.next();
        boolean idOk = UserDataValidations.checkId(1, nif);
        if (idOk) {
            System.out.println("Correct Id");
        }else{
            System.out.println("Incorrect Id");
        }

    }
   
   static void testCheckFormateDate(){
       System.out.println("Format Date Validator");
       System.out.println("Enter your Date dd/mm/aaaa");
       String date = sc.next();
       boolean resultado = UserDataValidations.checkFormatDate(date);
       if (resultado){
           System.out.println("Correct date");
       }else{
           System.out.println("Incorrect date");
       }
   }
   
   static void testCalculateAge() {
        System.out.println("Date Validator");
        System.out.println("Enter the your birthday Ex(01/03/2007):");
        String date = sc.next();
        int resultado = UserDataValidations.CalculateAge(date);
        if (resultado != -1) {
            System.out.println(resultado + " Anos");
        } else {
            System.out.println("Incorrect Date");
        }
    }
 
    static void testCheckPostalCode() {
        String[] postalCode = new String[5];
        System.out.println("Dime 5 numeros");
        for (int i = 0; i != 5; i++) {
            System.out.println("Escribe la nota numero " + i);
            postalCode[i] = sc.next();
        }
        boolean resultado = UserDataValidations.checkPostalCode(postalCode);
        if (resultado == true) {
            System.out.println(resultado);
        } else {
            System.out.println("Incorrect Numbers");
        }
    }
 
    static void testIsNumeric() {
        System.out.println("Is Numeric?");
        System.out.println("Enter Numbers");
        String number = sc.next();
        boolean resultado = UserDataValidations.isNumeric(number);
        if (resultado) {
            System.out.println("Son numericos ");
        } else {
            System.out.println("No son numericos ");
        }
    }
 
    static void testIsAlphabetic() {
        System.out.println("Is Alphabetic?");
        System.out.println("Enter Numbers");
        String letras = sc.next();
        boolean resultado = UserDataValidations.isAlphabetic(letras);
        if (resultado) {
            System.out.println("Son letras ");
        } else {
            System.out.println("No son letras ");
        }
    }
    
    static void testCheckEmail(){
        System.out.println("Pon tu Email");
        String email = sc.next();
        boolean resultado = UserDataValidations.checkEmail(email);
        if (resultado){
            System.out.println("Es correcto");
        } else{
            System.out.println("No es correcto");
        }
    }
    
        static void testCheckName(){
        System.out.println("Pon tu Nombre");
        String name = sc.next();
        boolean resultado = UserDataValidations.checkName(name);
        if (resultado){
            System.out.println("Es correcto");
        } else{
            System.out.println("No es correcto");
        }
    }
}

