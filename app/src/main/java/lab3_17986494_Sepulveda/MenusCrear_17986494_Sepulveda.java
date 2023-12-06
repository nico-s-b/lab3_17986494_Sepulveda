/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_17986494_Sepulveda;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author nic_s
 */
public class MenusCrear_17986494_Sepulveda {

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
            System.out.print("3. Default: Código Identificador del primer Chatbot es 0");
            chatbot.setId(0);
        }else{
            while (true) {
                try {
                    System.out.print("3. Ingrese Código Identificador del Chatbot: ");
                    chatbot.setId(input.nextInt());
                    break;  // Salir del bucle si la entrada es válida
                } catch (InputMismatchException e) {
                    System.out.println("Recuerde ingresar opciones numéricas. Por favor inténtelo de nuevo.");
                    input.nextLine();  // Limpiar el búfer de entrada
                }
            }            
        }
        
        while (true) {
            try {
                System.out.print("4. Ingrese Código de Flujo inicial del Chatbot: ");
                chatbot.setStartFlowId(input.nextInt());
                break;  // Salir del bucle si la entrada es válida
            } catch (InputMismatchException e) {
                System.out.println("Recuerde ingresar opciones numéricas. Por favor inténtelo de nuevo.");
                input.nextLine();  // Limpiar el búfer de entrada
            }
        }
        ArrayList<Flow_17986494_Sepulveda> flows = Componente_17986494_Sepulveda.<Flow_17986494_Sepulveda>filterComponent(
                                                    sys.getComponentes(), Flow_17986494_Sepulveda.class);        
        if (flows.isEmpty()){
            System.out.print("5. No hay flujos disponibles para agregar\n");
            System.out.print("Se añadió el chatbot al sistema");
            sys.addChatbotToSystem(chatbot);
        }else{
            System.out.print("5. Agregar flujos al chatbot\nListado de flujos disponibles para agregar: \n");
            
            for (Flow_17986494_Sepulveda f: flows){
                f.toString();
            }
            do {
                System.out.print("Ingrese Id del componente que desea agregar o escriba 'no' para terminar: ");
                String userInput = input.nextLine().toLowerCase();
                if(flows.isEmpty()){
                    System.out.print("Ya no quedan comopnentes por agregar\n");
                    break;
                }
                if (userInput.equals("no")) {
                    break;
                }
                try {
                    int Id = Integer.parseInt(userInput);
                    chatbot.addFlowToChatbot(Componente_17986494_Sepulveda.getComponentById(flows, Id));
                    Componente_17986494_Sepulveda.remComponentById(flows, Id);
                } catch (NumberFormatException  e) {
                    System.out.println("Recuerde ingresar opciones numéricas. Por favor inténtelo de nuevo.");

                }                  
            }while (true);
            System.out.print("Este es su nuevo chatbot:\n");
            chatbot.toString();
            System.out.print("¿Añadir chatbot al sistema?\nIngrese 'si' para confirmar, 'no' para cancelar: ");
            String userInput = input.nextLine().toLowerCase();
            do {
                if (userInput.equals("si")){
                    sys.addChatbotToSystem(chatbot);
                    System.out.print("Se añadió el chatbot al sistema");
                }else{
                    
                }
            }while ();

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
                System.out.print("3. Ingrese Código Identificador del Flujo: ");
                flow.setId(input.nextInt());
                break;  // Salir del bucle si la entrada es válida
            } catch (InputMismatchException e) {
                System.out.println("Recuerde ingresar opciones numéricas. Por favor inténtelo de nuevo.");
                input.nextLine();  // Limpiar el búfer de entrada
            }
        }
        ArrayList<Option_17986494_Sepulveda> options = Componente_17986494_Sepulveda.<Option_17986494_Sepulveda>filterComponent(
                                                    sys.getComponentes(), Option_17986494_Sepulveda.class);        
        if (options.isEmpty()){
            System.out.print("5. No hay opciones disponibles para agregar\n");
            System.out.print("Se añadió el flujo al sistema");
            sys.addComponente(flow);
        }else{
            System.out.print("5. Agregar opciones al flujo\nListado de opciones disponibles para agregar: \n");
            for (Option_17986494_Sepulveda o: options){
                o.toString();
            }            
            for (Option_17986494_Sepulveda o: options){
                o.toString();
            }
            do {
                System.out.print("Ingrese Id del componente que desea agregar o escriba 'no' para terminar: ");
                String userInput = input.nextLine().toLowerCase();
                if(options.isEmpty()){
                    System.out.print("Ya no quedan comopnentes por agregar\n");
                    break;
                }                
                if (userInput.equals("no")) {
                    break;
                }
                try {
                    int Id = Integer.parseInt(userInput);
                    flow.addOptionToFLow(Componente_17986494_Sepulveda.getComponentById(options, Id));
                    Componente_17986494_Sepulveda.remComponentById(options, Id);
                } catch (NumberFormatException  e) {
                    System.out.println("Recuerde ingresar opciones numéricas. Por favor inténtelo de nuevo.");

                }                  
            }while (true);
            sys.addComponente(flow);
        }
    }

    public static void menuCrearOption(System_17986494_Sepulveda sys){
        Option_17986494_Sepulveda option = new Option_17986494_Sepulveda();
        
        System.out.print("Creando una nueva opcion...\n");
        Scanner input = new Scanner(System.in); 

        System.out.print("1. Ingrese mensaje de la opción: ");
        option.setMessage(input.nextLine()+"\n");

        while (true) {
            try {
                System.out.print("2. Ingrese Código de la Opción: ");
                option.setId(input.nextInt());
                break;  // Salir del bucle si la entrada es válida
            } catch (InputMismatchException e) {
                System.out.println("Recuerde ingresar opciones numéricas. Por favor inténtelo de nuevo.");
                input.nextLine();  // Limpiar el búfer de entrada
            }
        }  
        
        while (true) {
            try {
                System.out.print("3. Ingrese Código de Enlace a Identificador de Chatbot: ");
                option.setChatbotCodeLink(input.nextInt());
                break;  // Salir del bucle si la entrada es válida
            } catch (InputMismatchException e) {
                System.out.println("Recuerde ingresar opciones numéricas. Por favor inténtelo de nuevo.");
                input.nextLine();  // Limpiar el búfer de entrada
            }
        }            

        while (true) {
            try {
                System.out.print("4. Ingrese Código de Enlace a Identificador de Flujo: ");
                option.setFlowCodeLink(input.nextInt());
                break;  // Salir del bucle si la entrada es válida
            } catch (InputMismatchException e) {
                System.out.println("Recuerde ingresar opciones numéricas. Por favor inténtelo de nuevo.");
                input.nextLine();  // Limpiar el búfer de entrada
            }
        }
        
        System.out.print("5. Ingrese las palabras claves que tendrá la Opción: \nIngrese 0 si ya terminó de agregar palabras\n");
        String MENU_EXIT_OPTION = "0";
        String keyword;
        int num = 1;
        do{
            keyword = input.nextLine();
            System.out.print("Ingrese palabra clave N°"+Integer.toString(num)+": ");
            option.addKeyword(keyword);
            num++;
        }while (keyword.equals(MENU_EXIT_OPTION));
        
        sys.addComponente(option);
    }
}    
