/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_17986494_Sepulveda;

import java.util.Scanner;

/**
 * Interface para manejar menus generales utilizando interfaces funcionales
 * y el método menu. Se implementa para menus que utilicen una estructura de switch
 * ya sea para acciones sencillas o para derivar a otros menus
 * @author nic_s
 */
public interface TemplateMenu_17986494_Sepulveda {

     /**
     *Interface funcional para utilizar un método para imprimir las opciones de un menú
     */    
    @FunctionalInterface
    interface PrintMenuFunction {
        /**
         *Función que imprime un menú. Dicha función pertenece a la clase 
         * {@link PrintingMenuFunctions_17986494_Sepulveda}
         */
        void printMenu();
    }

     /**
     *Interface funcional para ejecutar el método que controla el flujo de un menu 
     * basado en switchs dados los parámetros necesarios
     */
    @FunctionalInterface        
    interface SwitchMenuFunction {
        /**
         * Ejecuta la lógica de manejo de opciones de menú.
         * 
         * @param choice la opción del menú elegida por el usuario
         * @param sys la instancia del sistema
         * @param input el objeto Scanner para leer la entrada del usuario
         * @param returnToPrevMenu MutableBool para controlar el regreso al menú anterior
         */            
        void menuHandle(int choice, System_17986494_Sepulveda sys, Scanner input, MutableBool_17986494_Sepulveda returnToPrevMenu);
    }
 
    /**
     *Método que permite imprimir y manejar el flujo, excepciones y salidas de un
     * menú a partir de sus funciones para imprimir su flujo y para manejar el switch
     * de opciones válidas. Sirve para menus basados en switch.
     * 
     * @param input Scanner de inputs
     * @param sys sistema sobre el que se ejecutan las acciones
     * @param menuPrint método para imprimir un menú
     * @param menuHandle método que maneja el switch de opciones del menú
     */
    public static void menu(Scanner input, System_17986494_Sepulveda sys, PrintMenuFunction menuPrint, SwitchMenuFunction menuHandle) {
        MutableBool_17986494_Sepulveda returnToPrevMenu = new MutableBool_17986494_Sepulveda(false);
        while (!returnToPrevMenu.valor) {
            //Llamado a método que imprime el menú deseado
            menuPrint.printMenu();
            System.out.print("Ingrese opcion: ");
            try {
                int choice = Integer.parseInt(input.nextLine().trim());
                //Llamado a método que ejecuta la lógica del menú deseado
                menuHandle.menuHandle(choice, sys, input, returnToPrevMenu);
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un numero valido.");
            }
        }
    }
}