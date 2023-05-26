import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Principal{

    public static void main(String[] args){

        boolean continuar = false;
        boolean continuar2 = false;
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        int opcion2 = 0;
        
        while (continuar == false){

            System.out.println("\n ..:: Bienvenido ::.. ");
            System.out.println("Menu de opciones ");
            System.out.println("1. Ruta mas corta entre dos ciudades");
            System.out.println("2. Ciudad en el centro del grafo");
            System.out.println("3. Modificacion del grafo");
            System.out.println("4. Finalizar");
            System.out.println("Elija una opcion: ");
            opcion = Integer.parseInt(teclado.nextLine());
            
            switch(opcion){

                case 1:

                break;

                case 2:

                break;

                case 3:

                    while(continuar2 == false){

                        System.out.println(" Menu de modificaciones ");
                        System.out.println("1. Interrupcion de trafico");
                        System.out.println("2. Crear nueva conexion");
                        System.out.println("3. Indicar el clima para una ruta");
                        System.out.println("4. Salir del menu");
                        opcion2 = Integer.parseInt(teclado.nextLine());

                        switch(opcion2){

                            case 1:

                            break;

                            case 2:

                            break;

                            case 3:

                            break;

                            case 4:
                                System.out.println("Saliendo del menu...");
                                continuar2 = true;
                            break;

                            default:
                                System.out.println("Error, la opcion no es valida");
                            break;

                        }

                    }

                break;

                case 4:

                    System.out.println("Gracias por utilizar nuestro programa");
                    continuar = true;

                break;

                default:
                    System.out.println("Error, la opcion no existe");
                break;

            }

        }
        

    }

}