/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_17986494_Sepulveda;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *Clase que contiene los menus que permiten SELECCIONAR un componente de una lista 
 * de componentes dada. La lista de entrada debe contener solo instancias del mismo componente
 * @author nic_s
 */
public class MenusSeleccionar_17986494_Sepulveda {

    /**
     *Menu para seleccionar un chatbot. Dada una lista que contenga solamente instancias
     * de chatbot, inicia una interacción con el usuario que le permite seleccionar
     * uno de los chatbots de la lista.
     * 
     * @param input
     * @param sys
     * @param todos
     * @return
     */
    public static Chatbot_17986494_Sepulveda menuSelectChatbot(Scanner input, System_17986494_Sepulveda sys, ArrayList<Chatbot_17986494_Sepulveda> todos){
        if (todos.isEmpty()){
            System.out.println("No hay chatbots disponibles en estos momentos");
            return null;
        }            
        
        int i = 1;
        System.out.println("Listado de chatbots:\n");
        for (Chatbot_17986494_Sepulveda comp: todos){
            System.out.println(String.format("%d) %s",i,comp.getName()));
            i++;
        }
        System.out.println("\n\nIngresa el numero del chatbot deseado: \n(Ingrese 0 para cancelar)");
        System.out.print("Numero de chatbot: ");
        int index;
        Chatbot_17986494_Sepulveda chatbot = null;
        boolean isActionCompleted = false;
        while (!isActionCompleted) {
            try {
                index = input.nextInt();
                if (index == 0) { //Cancelar operación
                    isActionCompleted = true;
                }
                if (index >= 1 && index <= todos.size()) {
                    chatbot = todos.get(index - 1);
                    isActionCompleted = true;
                } else {
                    System.out.println("Ingresa un numero valido (entre 1 y " + todos.size() + ")");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingresa un numero valido (entre 1 y " + todos.size() + ")");
                input.next(); // Limpiar el búfer de entrada
            }
        }
        return chatbot;
    }

    /**
     *Menu para seleccionar un flujo. Dada una lista que contenga solamente instancias
     * de flujos, inicia una interacción con el usuario que le permite seleccionar
     * uno de los flujos de la lista.
     * 
     * @param input
     * @param sys
     * @param todos
     * @return
     */
    public static Flow_17986494_Sepulveda menuSelectFlow(Scanner input, System_17986494_Sepulveda sys, ArrayList <Flow_17986494_Sepulveda> todos){
        if (todos.isEmpty()){
            System.out.println("No hay flujos disponibles en estos momentos");
            return null;
        }    
        System.out.println("Listado de flujos:\n");
        
        int i = 1;
        for (Flow_17986494_Sepulveda comp: todos){
            System.out.println(String.format("%d) %s",i,comp.getName()));
            i++;
        }
        System.out.println("\n\nIngresa el numero del flujo deseado: \n(Ingrese 0 para cancelar)");
        System.out.print("Numero de flujo: ");
        int index;
        Flow_17986494_Sepulveda flujo = null;
        boolean isActionCompleted = false;
        while (!isActionCompleted) {
            try {
                index = input.nextInt();
                if (index == 0) { //Cancelar operación
                    isActionCompleted = true;
                }
                if (index >= 1 && index <= todos.size()) {
                    flujo = todos.get(index - 1);
                    isActionCompleted = true;
                } else {
                    System.out.println("Ingresa un numero valido (entre 1 y " + todos.size() + ")");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingresa un numero valido (entre 1 y " + todos.size() + ")");
                input.next(); // Limpiar el búfer de entrada
            }
        }
        return flujo;    
    }
    
    /**
     *Menu para seleccionar una opción. Dada una lista que contenga solamente instancias
     * de opciones, inicia una interacción con el usuario que le permite seleccionar
     * una de las opciones de la lista.
     * 
     * @param input
     * @param sys
     * @param todos
     * @return
     */
    public static Option_17986494_Sepulveda menuSelectOption(Scanner input, System_17986494_Sepulveda sys, ArrayList <Option_17986494_Sepulveda> todos){
        if (todos.isEmpty()){
            System.out.println("No hay opciones disponibles en estos momentos");
            return null;
        }
        System.out.print("Listado de opciones: \n\n");
        int i = 1;
        for (Option_17986494_Sepulveda comp: todos){
            System.out.println(String.format("%d) %s",i,comp.getMessage()));
            i++;
        }
        System.out.println("\n\nIngresa el numero de la opcion deseada: \n(Ingrese 0 para cancelar)");
        System.out.print("Numero de opcion: ");
        int index;
        boolean isActionCompleted = false;
        Option_17986494_Sepulveda option = null;
        while (!isActionCompleted){
            try {
                index = input.nextInt();
                if (index == 0) { 
                    isActionCompleted = true; //Cancelar operación
                }
                if (index >= 1 && index <= todos.size()) {
                    option = todos.get(index - 1);
                    isActionCompleted = true;
                } else {
                    System.out.println("Ingresa un numero valido (entre 1 y " + todos.size() + ")");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingresa un numero valido (entre 1 y " + todos.size() + ")");
                input.next(); // Limpiar el búfer de entrada
            }   
        }
        return option;
    }
    
}
