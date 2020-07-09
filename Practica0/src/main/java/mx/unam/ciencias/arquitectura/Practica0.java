package mx.unam.ciencias.arquitectura;

import java.util.Scanner;

public class Practica0{
    
    private Scanner scanner;
    
    public Practica0() {
        scanner = new Scanner(System.in);
    }

    /**
     * Pide un número al usuario.
     */
    private int leeEntero(String mensaje) {
        System.out.println(mensaje);
        boolean error = false;
        int num = -1;
        try {
            num = Integer.parseInt(scanner.nextLine());
            if (num <= 0) {
                error = true;
                System.out.println("Ingrese un número válido.");
            }
        } catch (NumberFormatException nfe) {
            error = true;
            System.out.println("Ingrese un número válido.");
        }
        if (error) {
            num = leeEntero(mensaje);
        }
        return num;
    }

    private String leeCadena(String mensaje){
        System.out.println(mensaje);
        return scanner.nextLine();
    }

    private void corre(){
        ConvertidorBases cb = ConvertidorBases.getInstance();
        String s = "Elige entre las siguientes opciones (usa el número que lo identifique y presiona enter):\n" +
            "1. Base 2 a 8\n" +
            "2. Base 2 a 10\n" +
            "3. Base 2 a 16\n" +
            "4. Base 8 a 2\n" +
            "5. Base 8 a 10\n" +
            "6. Base 8 a 16\n" +
            "7. Base 10 a 2\n" +
            "8. Base 10 a 8\n" +
            "9. Base 10 a 16\n" +
            "10. Base 16 a 2\n" +
            "11. Base 16 a 8\n" +
            "12. Base 16 a 10\n";
        System.out.println("** CONVERTIDOR DE BASES **\n");
        boolean continuar = true;
        while(continuar){
            int opc = leeEntero(s);
            switch (opc){
                case 0:
                    continuar = false;
                    break;
                case 1:
                    try{
                        System.out.println(cb.dosAOctal(leeCadena("Ingresa un número binario")));
                    }
                    catch(NumberFormatException nfe){
                        System.out.println(nfe);
                    }
                    break;
                case 2:
                    try{
                        System.out.println(cb.dosADiez(leeCadena("Ingresa un número binario")));
                    }
                    catch(NumberFormatException nfe){
                        System.out.println(nfe);
                    }
                    break;
                case 3:
                    try{
                        System.out.println(cb.dosAHexadecimal(leeCadena("Ingresa un número binario")));
                    }
                    catch(NumberFormatException nfe){
                        System.out.println(nfe);
                    }
                    break;
                case 4:
                    try{
                        System.out.println(cb.octalADos(leeCadena("Ingresa un número octal")));
                    }
                    catch(NumberFormatException nfe){
                        System.out.println(nfe);
                    }
                    break;
                case 5:
                    try{
                        System.out.println(cb.octalADiez(leeCadena("Ingresa un número octal")));
                    }
                    catch(NumberFormatException nfe){
                        System.out.println(nfe);
                    }
                    break;
                case 6:
                    try{
                        System.out.println(cb.octalAHexadecimal(leeCadena("Ingresa un número octal")));
                    }
                    catch(NumberFormatException nfe){
                        System.out.println(nfe);
                    }
                    break;
                case 7:
                    try{
                        System.out.println(cb.diezADos(leeCadena("Ingresa un número decimal")));
                    }
                    catch(NumberFormatException nfe){
                        System.out.println(nfe);
                    }
                    break;
                case 8:
                    try{
                        System.out.println(cb.diezAOctal(leeCadena("Ingresa un número decimal")));
                    }
                    catch(NumberFormatException nfe){
                        System.out.println(nfe);
                    }
                    break;
                case 9:
                    try{
                        System.out.println(cb.diezAHexadecimal(leeCadena("Ingresa un número decimal")));
                    }
                    catch(NumberFormatException nfe){
                        System.out.println(nfe);
                    }
                    break;
                case 10:
                    try{
                        System.out.println(cb.hexadecimalADos(leeCadena("Ingresa un número hexadecimal")));
                    }
                    catch(NumberFormatException nfe){
                        System.out.println(nfe);
                    }
                    break;
                case 11:
                    try{
                        System.out.println(cb.hexadecimalAOctal(leeCadena("Ingresa un número hexadecimal")));
                    }
                    catch(NumberFormatException nfe){
                        System.out.println(nfe);
                    }
                    break;
                case 12:
                    try{
                        System.out.println(cb.hexadecimalADiez(leeCadena("Ingresa un número hexadecimal")));
                    }
                    catch(NumberFormatException nfe){
                        System.out.println(nfe);
                    }
                    break;
                default:
                    System.out.println("Opción invalida.");
                    opc = leeEntero("Seleccione una opción");
                    break;
            }
        }
    }

    public static void main(String[] args){
        Practica0 practica = new Practica0();
        practica.corre();
    }
}