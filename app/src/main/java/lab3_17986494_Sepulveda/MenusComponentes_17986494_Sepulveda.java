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
public class MenusComponentes_17986494_Sepulveda {

    public static void menuCrearChatbot(System_17986494_Sepulveda sys, boolean isFirst){
        Chatbot_17986494_Sepulveda chatbot = new Chatbot_17986494_Sepulveda();
        
        System.out.print("Creando un nuevo chatbot...\n");
        Scanner input = new Scanner(System.in); 

        if (isFirst){
            System.out.print("Primer chatbot del sistema!\n");
        }
        
        System.out.print("1. Ingrese nombre del chatbot: ");
        chatbot.setName(input.nextLine());

        System.out.print("2. Ingrese mensaje de bienvenida del chatbot: ");
        chatbot.setWelcomeMessage(input.nextLine()+"\n");
        
        if (isFirst){
            System.out.print("3. Default: C�digo Identificador del primer Chatbot es 0");
            chatbot.setId(0);
        }else{
            while (true) {
                try {
                    System.out.print("3. Ingrese C�digo Identificador del Chatbot: ");
                    chatbot.setId(input.nextInt());
                    break;  // Salir del bucle si la entrada es v�lida
                } catch (InputMismatchException e) {
                    System.out.println("Recuerde ingresar opciones num�ricas. Por favor int�ntelo de nuevo.");
                    input.nextLine();  // Limpiar el b�fer de entrada
                }
            }            
        }

        while (true) {
            try {
                System.out.print("4. Ingrese C�digo de Flujo inicial del Chatbot: ");
                chatbot.setStartFlowId(input.nextInt());
                break;  // Salir del bucle si la entrada es v�lida
            } catch (InputMismatchException e) {
                System.out.println("Recuerde ingresar opciones num�ricas. Por favor int�ntelo de nuevo.");
                input.nextLine();  // Limpiar el b�fer de entrada
            }
        }
    }

    public static void menuCrearFlow(System_17986494_Sepulveda sys){
        Flow_17986494_Sepulveda flow = new Flow_17986494_Sepulveda();
        
        System.out.print("Creando un nuevo flujo...\n");
        Scanner input = new Scanner(System.in); 
        
        System.out.print("1. Ingrese nombre del flujo: ");
        flow.setNameMessage(input.nextLine());
        
        while (true) {
            try {
                System.out.print("3. Ingrese C�digo Identificador del Flujo: ");
                flow.setId(input.nextInt());
                break;  // Salir del bucle si la entrada es v�lida
            } catch (InputMismatchException e) {
                System.out.println("Recuerde ingresar opciones num�ricas. Por favor int�ntelo de nuevo.");
                input.nextLine();  // Limpiar el b�fer de entrada
            }
        }
    }

    /*//Atributos de clase
    private int code;
    private String message;
    private int chatbotCodeLink;
    private int flowCodeLink;
    private ArrayList<String> keywords;*/

    public static void menuCrearOption(System_17986494_Sepulveda sys){
        Option_17986494_Sepulveda option = new Option_17986494_Sepulveda();
        
        System.out.print("Creando una nueva opcion...\n");
        Scanner input = new Scanner(System.in); 

        System.out.print("1. Ingrese mensaje de la opci�n: ");
        option.setMessage(input.nextLine()+"\n");

        while (true) {
            try {
                System.out.print("2. Ingrese C�digo de la Opci�n: ");
                option.setCode(input.nextInt());
                break;  // Salir del bucle si la entrada es v�lida
            } catch (InputMismatchException e) {
                System.out.println("Recuerde ingresar opciones num�ricas. Por favor int�ntelo de nuevo.");
                input.nextLine();  // Limpiar el b�fer de entrada
            }
        }  
        
        while (true) {
            try {
                System.out.print("3. Ingrese C�digo de Enlace a Identificador de Chatbot: ");
                option.setChatbotCodeLink(input.nextInt());
                break;  // Salir del bucle si la entrada es v�lida
            } catch (InputMismatchException e) {
                System.out.println("Recuerde ingresar opciones num�ricas. Por favor int�ntelo de nuevo.");
                input.nextLine();  // Limpiar el b�fer de entrada
            }
        }            

        while (true) {
            try {
                System.out.print("4. Ingrese C�digo de Enlace a Identificador de Flujo: ");
                option.setFlowCodeLink(input.nextInt());
                break;  // Salir del bucle si la entrada es v�lida
            } catch (InputMismatchException e) {
                System.out.println("Recuerde ingresar opciones num�ricas. Por favor int�ntelo de nuevo.");
                input.nextLine();  // Limpiar el b�fer de entrada
            }
        }
        
        
        
    }
    
}    
