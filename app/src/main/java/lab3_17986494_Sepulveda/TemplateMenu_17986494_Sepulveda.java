/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_17986494_Sepulveda;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author nic_s
 */
public interface TemplateMenu_17986494_Sepulveda {

    @FunctionalInterface
    interface PrintMenuFunction {
        void printMenu();
    }

    @FunctionalInterface
    interface SwitchMenuFunction {
        void execute(int choice, System_17986494_Sepulveda sys, Scanner input, boolean returnToPrevMenu);
    }
 
    public static void menu(System_17986494_Sepulveda sys, PrintMenuFunction menuPrint, SwitchMenuFunction menuFlow) {
        Scanner input = new Scanner(System.in);
        boolean returnToPrevMenu = false;
        int choice = 0;

        while (!returnToPrevMenu) {    
            menuPrint.printMenu();            
            try {
                System.out.print("Ingrese opción: ");
                choice = input.nextInt();

                menuFlow.execute(choice, sys, input, returnToPrevMenu);
            } catch (InputMismatchException e) {
                System.out.println("Recuerde ingresar opciones numéricas. Por favor inténtelo de nuevo.");
                input.nextLine();
            }
        }
    }
}
