/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_17986494_Sepulveda;

import java.util.Scanner;

/**
 * Interface para manejar menus generales utilizando interfaces funcionales
 * y el m�todo menu. Se implementa para menus que utilicen una estructura de switch
 * ya sea para acciones sencillas o para derivar a otros menus
 * @author nic_s
 */
public interface TemplateMenu_17986494_Sepulveda {

     /**
     *Interface funcional para utilizar un m�todo para imprimir las opciones de un men�
     */    
    @FunctionalInterface
    interface PrintMenuFunction {
        /**
         *Funci�n que imprime un men�. Dicha funci�n pertenece a la clase 
         * {@link PrintingMenuFunctions_17986494_Sepulveda}
         */
        void printMenu();
    }

     /**
     *Interface funcional para ejecutar el m�todo que controla el flujo de un menu 
     * basado en switchs dados los par�metros necesarios
     */
    @FunctionalInterface        
    interface SwitchMenuFunction {
        /**
         * Ejecuta la l�gica de manejo de opciones de men�.
         * 
         * @param choice la opci�n del men� elegida por el usuario
         * @param sys la instancia del sistema
         * @param input el objeto Scanner para leer la entrada del usuario
         * @param returnToPrevMenu MutableBool para controlar el regreso al men� anterior
         */            
        void menuHandle(int choice, System_17986494_Sepulveda sys, Scanner input, MutableBool_17986494_Sepulveda returnToPrevMenu);
    }
 
    /**
     *M�todo que permite imprimir y manejar el flujo, excepciones y salidas de un
     * men� a partir de sus funciones para imprimir su flujo y para manejar el switch
     * de opciones v�lidas. Sirve para menus basados en switch.
     * 
     * @param input Scanner de inputs
     * @param sys sistema sobre el que se ejecutan las acciones
     * @param menuPrint m�todo para imprimir un men�
     * @param menuHandle m�todo que maneja el switch de opciones del men�
     */
    public static void menu(Scanner input, System_17986494_Sepulveda sys, PrintMenuFunction menuPrint, SwitchMenuFunction menuHandle) {
        MutableBool_17986494_Sepulveda returnToPrevMenu = new MutableBool_17986494_Sepulveda(false);
        while (!returnToPrevMenu.valor) {
            //Llamado a m�todo que imprime el men� deseado
            menuPrint.printMenu();
            System.out.print("Ingrese opcion: ");
            try {
                int choice = Integer.parseInt(input.nextLine().trim());
                //Llamado a m�todo que ejecuta la l�gica del men� deseado
                menuHandle.menuHandle(choice, sys, input, returnToPrevMenu);
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un numero valido.");
            }
        }
    }
}