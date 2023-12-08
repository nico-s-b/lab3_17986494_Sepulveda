/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_17986494_Sepulveda;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase que contiene los menus de CREACI�N de chatbots, flujos y opciones, tanto
 * para a�adirlos a los componentes respectivos como para almacenarlos en el listado
 * de componentes disponibles.
 * @author nic_s
 */
public class MenusCrear_17986494_Sepulveda {

/**
 * Menu para la creaci�n de chatbots. Se le solicita al usuario, mediante consola, 
 * ingresar todos los par�metros del chatbot, y luego se le consulta d�nde a�adirlo
 * (al sistema o a los componentes disponibles) usando {@link #menuAddComponentToDisponibles(java.util.Scanner, lab3_17986494_Sepulveda.System_17986494_Sepulveda, java.lang.String, lab3_17986494_Sepulveda.Componente_17986494_Sepulveda) }
 * 
 * @param sys
 * @param isFirst indica si no hay chatbots en el sistema a�n, para crear el primero
 */    
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
            System.out.print("3. Default: C�digo Identificador del primer Chatbot es 0\n");
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
        ArrayList<Flow_17986494_Sepulveda> flows = Componente_17986494_Sepulveda.<Flow_17986494_Sepulveda>filterComponent(
                                                    sys.getComponentes(), Flow_17986494_Sepulveda.class);
        if (flows.isEmpty()){
            System.out.print("5. No hay flujos disponibles para agregar\n");
        }else{
            System.out.print("5. Agregar flujos al chatbot\nListado de flujos disponibles para agregar: \n");
            
            for (Flow_17986494_Sepulveda f: flows){
                System.out.println(f.toString());
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
                    chatbot.chatbotAddFlow(Componente_17986494_Sepulveda.getComponentById(flows, Id));
                    Componente_17986494_Sepulveda.remComponentById(sys,flows, Id);
                } catch (NumberFormatException  e) {
                    System.out.println("Recuerde ingresar opciones num�ricas. Por favor int�ntelo de nuevo.");

                }                  
            }while (true);
        }
        //Llamado a men� para decidir qu� hacer con el componente creado
        menuAgregarComponente(input, sys, "chatbot", chatbot);
    }
    
/**
 * Menu para la creaci�n de flujos. Se le solicita al usuario, mediante consola, 
 * ingresar todos los par�metros del flujo, y luego se le consulta d�nde a�adirlo
 * (a un chatbot existente o a los componentes disponibles) usando {@link #menuAddComponentToDisponibles(java.util.Scanner, lab3_17986494_Sepulveda.System_17986494_Sepulveda, java.lang.String, lab3_17986494_Sepulveda.Componente_17986494_Sepulveda) }
 * 
 * @param sys
 */  
    public static void menuCrearFlow(System_17986494_Sepulveda sys){
        Flow_17986494_Sepulveda flow = new Flow_17986494_Sepulveda();
        
        System.out.print("Creando un nuevo flujo...\n");
        Scanner input = new Scanner(System.in); 
        
        System.out.print("1. Ingrese pregunta/instrucci�n del flujo: ");
        flow.setName(input.nextLine());
        
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
        ArrayList<Option_17986494_Sepulveda> options = Componente_17986494_Sepulveda.<Option_17986494_Sepulveda>filterComponent(
                                                    sys.getComponentes(), Option_17986494_Sepulveda.class);        
        if (options.isEmpty()){
            System.out.print("5. No hay opciones disponibles para agregar\n");
        }else{
            System.out.print("5. Agregar opciones al flujo\nListado de opciones disponibles para agregar: \n");
            for (Option_17986494_Sepulveda o: options){
                System.out.println(o.toString());
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
                    flow.flowAddOption(Componente_17986494_Sepulveda.getComponentById(options, Id));
                    Componente_17986494_Sepulveda.remComponentById(sys,options, Id);
                } catch (NumberFormatException  e) {
                    System.out.println("Recuerde ingresar opciones num�ricas. Por favor int�ntelo de nuevo.");
                }                  
            }while (true);          
        }
        //Llamado a men� para decidir qu� hacer con el componente creado
        menuAgregarComponente(input, sys, "flow", flow);
    }

/**
 * Menu para la creaci�n de opciones. Se le solicita al usuario, mediante consola, 
 * ingresar todos los par�metros de la opci�n, y luego se le consulta d�nde a�adirla
 * (a un flujo existente o a los componentes disponibles) usando {@link #menuAddComponentToDisponibles(java.util.Scanner, lab3_17986494_Sepulveda.System_17986494_Sepulveda, java.lang.String, lab3_17986494_Sepulveda.Componente_17986494_Sepulveda) }
 * 
 * @param sys
 */  
    public static void menuCrearOption(System_17986494_Sepulveda sys){
        Option_17986494_Sepulveda option = new Option_17986494_Sepulveda();
        
        System.out.print("Creando una nueva opcion...\n");
        Scanner input = new Scanner(System.in); 

        System.out.print("1. Ingrese mensaje de la opci�n: ");
        option.setMessage(input.nextLine()+"\n");

        while (true) {
            try {
                System.out.print("2. Ingrese C�digo de la Opci�n: ");
                option.setId(input.nextInt());
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
        
        System.out.print("5. Ingrese las palabras claves que tendr� la Opci�n: \nIngrese 0 si ya termin� de agregar palabras\n");
        String MENU_EXIT_OPTION = "0";
        String keyword;
        int num = 1;
        do{
            keyword = input.nextLine();
            System.out.print("Ingrese palabra clave N�"+Integer.toString(num)+": ");
            option.addKeyword(keyword);
            num++;
        }while (keyword.equals(MENU_EXIT_OPTION));
        
        //Llamado a men� para decidir qu� hacer con el componente creado
        menuAgregarComponente(input, sys, "opcion", option);
    }

/**
 * Menu para agregar un componente a otro existente o al listado de componentes 
 * disponibles del sistema.Dependiendo de si se le solicita a�adir un chatbot,
 * un flujo o una opci�n se comportar� en consecuencia.
 * 
 * @param input
 * @param sys
 * @param tipoComponente
 * @param componente
 */
    public static void menuAgregarComponente(Scanner input, System_17986494_Sepulveda sys, String tipoComponente, 
                        Componente_17986494_Sepulveda componente) {

        System.out.println("\nEste es su nuevo " + tipoComponente);
        System.out.println(componente.toString());
        String otroComponente = null;
        //Strings correspondientes para imprimir mensajes
        switch (tipoComponente) {
            case "flujo":
                otroComponente = "un chatbot";
                break;
            case "opcion":
                otroComponente = " un flujo";
                break;
            case "chatbot":
                otroComponente = "l sistema";
                break;
            default:
                break;
        }
        int ready = 0;
        while (ready == 0) {
            System.out.print("�A�adir " + tipoComponente + " a"+otroComponente+"? Ingrese 'si' para confirmar, 'no' para cancelar: ");
            String userInput = input.nextLine().toLowerCase();

            switch (userInput) {
                case "si":
                    //Caso de agregar chatbot al sistema
                    if (componente instanceof Chatbot_17986494_Sepulveda) {
                        sys.systemAddChatbot((Chatbot_17986494_Sepulveda) componente);
                        //Caso de agregar flujo a un chatbot
                    } else if (componente instanceof Flow_17986494_Sepulveda) {
                        System.out.println("Ingresa el n�mero del chatbot al que deseas agregar el flujo: \n(Ingrese 0 para cancelar)");
                        ArrayList<Chatbot_17986494_Sepulveda> todos = sys.getAllChatbots();
                        int i = 1;
                        for (Chatbot_17986494_Sepulveda comp: todos){
                            System.out.println(String.format("%d) %s",i,comp.getName()));
                            i++;
                        }
                        
                        int index;
                        Chatbot_17986494_Sepulveda chatbot = null;
                        
                        while (chatbot == null) {
                            try {
                                index = input.nextInt();
                                if (index == 0) { //Cancelar operaci�n
                                    break;
                                }
                                if (index >= 1 && index <= todos.size()) {
                                    chatbot = todos.get(index - 1);
                                } else {
                                    System.out.println("Ingresa un n�mero v�lido (entre 1 y " + todos.size() + ")");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Ingresa un n�mero v�lido (entre 1 y " + todos.size() + ")");
                                input.next(); // Limpiar el b�fer de entrada
                            }
                        }
                        //A�adir flujo una vez que se eligi� correctamente un chatbot
                        if (chatbot != null) {
                            chatbot.chatbotAddFlow((Flow_17986494_Sepulveda) componente);
                        }
                        //Caso de agregar opcion a un flujo
                    } else if (componente instanceof Option_17986494_Sepulveda) {
                        
                        System.out.println("Ingresa el n�mero del chatbot al que deseas agregar el flujo: \n(Ingrese 0 para cancelar)");
                        ArrayList<Flow_17986494_Sepulveda> todos = sys.getAllFlows();
                        int i = 1;
                        for (Flow_17986494_Sepulveda comp: todos){
                            System.out.println(String.format("%d) %s",i,comp.getName()));
                            i++;
                        }
                        
                        int index;
                        Flow_17986494_Sepulveda flujo = null;
                        
                        while (flujo == null) {
                            try {
                                index = input.nextInt();
                                if (index == 0) { //Cancelar operaci�n
                                    break;
                                }
                                if (index >= 1 && index <= todos.size()) {
                                    flujo = todos.get(index - 1);
                                } else {
                                    System.out.println("Ingresa un n�mero v�lido (entre 1 y " + todos.size() + ")");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Ingresa un n�mero v�lido (entre 1 y " + todos.size() + ")");
                                input.next(); // Limpiar el b�fer de entrada
                            }
                        }
                        //A�adir opci�n una vez que se eligi� correctamente un flujo
                        if (flujo != null) {
                            flujo.flowAddOption((Option_17986494_Sepulveda) componente);
                        }
                    }   System.out.println("El " + tipoComponente+"fue a�adido exitosamente.");
                    ready = 1;
                    break;
                case "no":
                    //Secci�n del men� espec�fica para a�adir un componente cualquiera
                    //al listado de componentes del sistema.
                    menuAddComponentToDisponibles(input, sys, tipoComponente, componente);
                    ready = 1;
                    break;
                default:
                    System.out.println("Ingrese una opci�n v�lida.");
                    break;
            }
        }
    }

    
/**
 * Menu espec�fico para a�adir un componente al listado de componentes disponibles, 
 * o elegir cancelar la operaci�n, lo que har� que el componente creado se pierda.
 * 
 * @param input
 * @param sys
 * @param tipoComponente
 * @param componente
 */    
    private static void menuAddComponentToDisponibles(Scanner input, System_17986494_Sepulveda sys, String tipoComponente, Componente_17986494_Sepulveda componente){
        int ready = 0;
        while (ready == 0){
            System.out.print("�Desea guardar el " + tipoComponente + " en el listado de componentes? Ingrese 'si' para confirmar, 'no' para cancelar: ");
            String userInput = input.nextLine().toLowerCase();            
            switch (userInput) {
                case "si":
                    sys.addComponente(componente);
                    System.out.println("Se a�adi� el " + tipoComponente + " al listado de componentes del sistema.");
                    ready = 1;
                    break;
                case "no":
                    System.out.println("Ok, el " + tipoComponente + " no ser� guardado.");
                    ready = 1;
                    break;
                default:
                    System.out.println("Ingrese una opci�n v�lida ('si' o 'no').");
                    break;
            }
        }
    }

    
}    
