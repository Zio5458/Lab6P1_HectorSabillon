/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab6p1_hectorsabillon;

import java.util.Scanner;
import java.util.Random;


public class Lab6P1_HectorSabillon {
    static Scanner leer = new Scanner(System.in);
    static Random random = new Random();
    
    public static void main(String[] args) {
        
        int opcion;
        do{
            System.out.println("1 <- Turing");
            System.out.println("2 <- Constante de Kaprekar");
            System.out.println("3 <- Salida");
            System.out.println("Ingrese el ejercicio a visualizar");
            opcion = leer.nextInt();

            switch (opcion){
                case 1:
                    int tam;
                    String instrucciones;
                    System.out.println("Ingrese la cantidad de elementos que tendra el arreglo: ");
                    tam = leer.nextInt();
                    System.out.println("Ingrese la cadena de instrucciones: ");
                    instrucciones = leer.next();
                    instrucciones = instrucciones.toUpperCase();
                    impresion(instrucciones, tam);
                    break;
                case 2:
                    int num;
                    do{
                        System.out.println("Ingrese un numero de 4 digitos: ");
                        num = leer.nextInt();
                    } while (num / 10000 > 0);
                    int temp, temp2, temp3, temp4;
                    temp = num % 10;
                    temp2 = num % 100;
                    temp3 = num % 1000;
                    temp4 = num % 10000;
                    if ((temp == temp2) && (temp == temp3) && (temp == temp4)){
                        System.out.println("Los numeros no pueden ser iguales");
                    } else {
                        for (int j = 0; j < 7; j++){
                            int num1 = ascendente(num);
                            int num2 = descendente(num);
                            int num3 = num2 - num1;
                            if (num3 == 6174){
                                System.out.println("El resultado es 6741");
                                break;
                            } else {
                                num = num3;
                                if (j == 6){
                                    System.out.println("No se pudo realizar el calculo");
                                }
                            }
                        }
                    }
                    }
                    break;
        } while (opcion != 3);
    }
    
    public static int[] arreglo1(int tam){
        int arreglorandom[] = new int[tam];
        for (int i = 0; i < tam; i++){
            arreglorandom[i] = random.nextInt(10);
        }
        //En este metodo, se generan numeros entre 0 y 9 usando el metodo Random en cada elemento del arreglo arreglorandom usando un for.
        
        return arreglorandom;
    }
    
    public static void impresion(String instrucciones, int tam){
        int [] arreglorandom = arreglo1(tam);
        int puntero = 0;
        for (int i = 0; i < instrucciones.length(); i++){
            char ins = instrucciones.charAt(i);
            switch (ins){
                case 'R':
                    if (puntero > arreglorandom.length){
                        System.out.println("Las instrucciones no son validas");
                    } else{
                        puntero++;
                    }
                    break;
                case 'L':
                    if (puntero < 0){
                        System.out.println("Las instrucciones no son validas");
                    } else{
                        puntero--;
                    }
                    break;
                case 'X':
                    System.out.print(arreglorandom[puntero]);
            }
        }
        System.out.println();
        
        //En este metodo, se posiciona el puntero tal y como el usuario ingrese las instrucciones. En el main se pasaron las instrucciones directamente a UpperCase para evitar errores y calculos erroneos por mayusculas o minusculas.
    }
    
    public static int ascendente(int num){
        int[] numeros = new int[4];
        int temp = num;
        int temp2;
        int min = 0;
        for (int i = 0; i < 4; i++){
            temp = num % 10;
            numeros[i] = temp;
            num /= 10;
        }
        
        for (int j = 0; j < numeros.length; j++){
            for (int k = j; k < numeros.length; k++){
                if (numeros[j] > numeros[k]){
                   temp2 = numeros[j];
                   numeros[j] = numeros[k];
                   numeros[k] = temp2;
                }
            }
        }
        
        for(int i = 0; i < 4; i++){
            min += (numeros[i] * (Math.pow(10, 3-i)));
        }//Minimo
        
        //En este metodo, usando las funciones for con los contadores j y k, se asigna a cada elemento del array numeros a un digito del numero ingresado. Luego, se ordenan de menor a mayor con el for k.
        return min;
    }
    
    public static int descendente(int num){
        int max = 0;
        int[] numeros = new int[4];
        int temp;
        for (int i = 0; i < 4; i++){
            temp = num % 10;
            numeros[i] = temp;
            num /= 10;
        }
        
        for (int j = 0; j < numeros.length; j++){
            for (int k = j; k < numeros.length; k++){
                if (numeros[j] < numeros[k]){
                   temp = numeros[j];
                   numeros[j] = numeros[k];
                   numeros[k] = temp;
                }
            }
        }
        
        for (int i = 0; i < 4; i++){
            max += (numeros[i] * (Math.pow(10, 3-i)));
        }//Maximo
        //En este metodo, se emplea lo mismo que en el metodo ascendente, pero invirtiendo el if que compara los valores j y k para que imprima de mayor a menor en lugar de menor a mayor.
        
        return max;
    }
    
    public static void impresion2(int num){
        int num1 = ascendente(num);
        int num2 = descendente(num);
        if (num2 - num1 == 6174){
            System.out.println("El resultado es 6174");
        } else{
            num = (num2 - num1);
        }
    }
    //Este metodo se encarga de imprimir si el resultado es 6174 o no en base al numero ingresado. De lo contrario, el main correra todos los metodos nuevamente hasta que el resultado sea 6174.
}
