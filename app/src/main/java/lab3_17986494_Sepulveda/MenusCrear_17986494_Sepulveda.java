/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_17986494_Sepulveda;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase que contiene los menus de CREACIÓN de chatbots, flujos y opciones, tanto
 * para añadirlos a los componentes respectivos como para almacenarlos en el listado
 * de componentes disponibles.
 * @author nic_s
 */
public class MenusCrear_17986494_Sepulveda {

    /**
     * Menu para la creación de chatbots.Se le solicita al usuario, mediante consola, 
     * ingresar todos los parámetros del chatbot, y luego se le consulta dónde añadirlo
     * (al sistema o a los componentes disponibles) usando {@link #menuAddComponentToDisponibles(java.util.Scanner, lab3_17986494_Sepulveda.System_17986494_Sepulveda, java.lang.String, lab3_17986494_Sepulveda.Componente_17986494_Sepulveda)}
     * 
     * @param input Scanner
     * @param sys Sistema contenedor
     */    
    public static void menuCrearChatbot(Scanner input, System_17986494_Sepulveda sys){
        Chatbot_17986494_Sepulveda chatbot = new Chatbot_17986494_Sepulveda();
        
        System.out.print("Creando un nuevo chatbot...\n");

        if (sys.getChatbots().isEmpty()){
            System.out.print("Primer chatbot del sistema!\n");
        }
        
        System.out.print("1. Ingrese nombre del chatbot: ");
        chatbot.setName(input.nextLine());

        System.out.print("2. Ingrese mensaje de bienvenida del chatbot: ");
        chatbot.setWelcomeMessage(input.nextLine()+"\n");
        
        if (sys.getChatbots().isEmpty()){
            System.out.print("3. Default: Codigo Identificador del primer Chatbot es 0\n");
            chatbot.setId(0);
        }else{
            while (true) {
                try {
                    System.out.print("3. Ingrese Codigo Identificador del Chatbot: ");
                    chatbot.setId(input.nextInt());
                    break;  // Salir del bucle si la entrada es válida
                } catch (InputMismatchException e) {
                    System.out.println("Recuerde ingresar opciones numericas. Por favor, intentelo de nuevo.");
                    input.nextLine();  // Limpiar el búfer de entrada
                }
            }            
        }
        
        while (true) {
            try {
                System.out.print("4. Ingrese Codigo de Flujo inicial del Chatbot: ");
                chatbot.setStartFlowId(input.nextInt());
                break;  // Salir del bucle si la entrada es válida
            } catch (InputMismatchException e) {
                System.out.println("Recuerde ingresar opciones numericas. Por favor inténtelo de nuevo.");
                input.nextLine();  // Limpiar el búfer de entrada
            }
        }
        //Filtrar solo los flows desde el listado de componentes disponibles del sistema
        ArrayList<Flow_17986494_Sepulveda> flows = Componente_17986494_Sepulveda.<Flow_17986494_Sepulveda>filterComponent(
                                                    sys.getComponentes(), Flow_17986494_Sepulveda.class);
        if (flows.isEmpty()){
            System.out.print("5. No hay flujos disponibles para agregar\n");
        }else{
            System.out.print("5. Agregar flujos al chatbot\nListado de flujos disponibles para agregar: \n");
            //Imprimir flujos disponibles
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
                    Flow_17986494_Sepulveda flowToAdd = Componente_17986494_Sepulveda.getComponentById(flows, Id);
                    if (flowToAdd != null) {
                        chatbot.chatbotAddFlow(flowToAdd);
                        Componente_17986494_Sepulveda.remComponentById(sys, flows, Id);
                    } else {
                        System.out.println("No se encontro un flujo con el ID especificado.");
                    }
                } catch (NumberFormatException  e) {
                    System.out.println("Recuerde ingresar opciones numericas. Por favor intentelo de nuevo.");

                }
            }while (true);
        }
        //Llamado a menú para decidir qué hacer con el componente creado
        menuAgregarComponente(input, sys, "chatbot", chatbot);
    }
    
    /**
     * Menu para la creación de flujos.Se le solicita al usuario, mediante consola, 
     * ingresar todos los parámetros del flujo, y luego se le consulta dónde añadirlo
     * (a un chatbot existente o a los componentes disponibles) usando {@link #menuAddComponentToDisponibles(java.util.Scanner, lab3_17986494_Sepulveda.System_17986494_Sepulveda, java.lang.String, lab3_17986494_Sepulveda.Componente_17986494_Sepulveda)}
     * 
     * @param input Scanner de entrada
     * @param sys sistema vigente
     */  
    public static void menuCrearFlow(Scanner input, System_17986494_Sepulveda sys){
        Flow_17986494_Sepulveda flow = new Flow_17986494_Sepulveda();
        
        System.out.print("Creando un nuevo flujo...\n");
        
        System.out.print("1. Ingrese pregunta/instruccion del flujo: ");
        flow.setName(input.nextLine());
        
        while (true) {
            try {
                System.out.print("2. Ingrese Codigo Identificador del Flujo: ");
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
            System.out.print("3. No hay opciones disponibles para agregar\n");
        }else{
            System.out.print("3. Agregar opciones al flujo\nListado de opciones disponibles para agregar: \n");
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
                    Option_17986494_Sepulveda optionToAdd = Componente_17986494_Sepulveda.getComponentById(options, Id);
                    if (optionToAdd != null){
                        flow.flowAddOption(optionToAdd);
                        Componente_17986494_Sepulveda.remComponentById(sys,options, Id);
                    }else{
                        System.out.println("No se encontro una opcion con el ID especificado.");                        
                    }
                } catch (NumberFormatException  e) {
                    System.out.println("Recuerde ingresar opciones numéricas. Por favor inténtelo de nuevo.");
                }                  
            }while (true);
        }
        //Llamado a menú para decidir qué hacer con el componente creado
        menuAgregarComponente(input, sys, "flujo", flow);
    }

    /**
     * Menu para la creación de opciones.Se le solicita al usuario, mediante consola, 
     * ingresar todos los parámetros de la opción, y luego se le consulta dónde añadirla
     * (a un flujo existente o a los componentes disponibles) usando {@link #menuAddComponentToDisponibles(java.util.Scanner, lab3_17986494_Sepulveda.System_17986494_Sepulveda, java.lang.String, lab3_17986494_Sepulveda.Componente_17986494_Sepulveda)}
     * 
     * @param input Scanner de entrada
     * @param sys sistema vigente
     */  
    public static void menuCrearOption(Scanner input, System_17986494_Sepulveda sys){
        Option_17986494_Sepulveda option = new Option_17986494_Sepulveda();
        
        System.out.print("Creando una nueva opcion...\n");

        System.out.print("1. Ingrese mensaje de la opcion: ");
        option.setMessage(input.nextLine());

        while (true) {
            try {
                System.out.print("2. Ingrese Codigo de la Opcion: ");
                option.setId(input.nextInt());
                break;  // Salir del bucle si la entrada es válida
            } catch (InputMismatchException e) {
                System.out.println("Recuerde ingresar opciones numericas. Por favor intentelo de nuevo.");
                input.nextLine();  // Limpiar el búfer de entrada
            }
        }  
        
        while (true) {
            try {
                System.out.print("3. Ingrese Codigo de Enlace a Identificador de Chatbot: ");
                option.setChatbotCodeLink(input.nextInt());
                break;  // Salir del bucle si la entrada es válida
            } catch (InputMismatchException e) {
                System.out.println("Recuerde ingresar opciones numericas. Por favor intentelo de nuevo.");
                input.nextLine();  // Limpiar el búfer de entrada
            }
        }            

        while (true) {
            try {
                System.out.print("4. Ingrese Codigo de Enlace a Identificador de Flujo: ");
                option.setFlowCodeLink(input.nextInt());
                break;  // Salir del bucle si la entrada es válida
            } catch (InputMismatchException e) {
                System.out.println("Recuerde ingresar opciones numericas. Por favor intentelo de nuevo.");
                input.nextLine();  // Limpiar el búfer de entrada
            }
        }

        input.nextLine(); // Limpiar búfer de entrada antes de ingresar palabras
        System.out.print("5. Ingrese las palabras claves que tendra la Opcion:\nIngrese 0 si ya termino de agregar palabras\n");
        String MENU_EXIT_OPTION = "0";
        String keyword;
        int num = 1;

        while (true) {
            System.out.print("Ingrese palabra clave N°" + num + ": ");
            keyword = input.nextLine();

            if (keyword.equals(MENU_EXIT_OPTION)) {
                break; // Salir del bucle si el usuario ingresa 0
            }

            option.addKeyword(keyword);
            num++;
        }
        //Llamado a menú para decidir qué hacer con el componente creado
        menuAgregarComponente(input, sys, "opcion", option);
    }

    /**
     * Menu para agregar un componente a otro existente o al listado de componentes 
     * disponibles del sistema.Dependiendo de si se le solicita añadir un chatbot,
     * un flujo o una opción se comportará en consecuencia.
     * 
     * @param input Scanner de entrada de usuario
     * @param sys sistema vigente
     * @param tipoComponente nombre del tipo de componente a agregar
     * @param componente componente que se desea agregar
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
        boolean isActionCompleted = false;
        input.nextLine(); //limpiar búfer
        while (!isActionCompleted) {
            System.out.print("¿Agregar " + tipoComponente + " a"+otroComponente+"? Ingrese 'si' para confirmar, 'no' para cancelar: ");
            String userInput = input.nextLine().toLowerCase();
            switch (userInput) {
                case "si":
                    //Caso de agregar chatbot al sistema
                    if (componente instanceof Chatbot_17986494_Sepulveda) {
                        sys.systemAddChatbot((Chatbot_17986494_Sepulveda) componente);
                       
                    //Caso de agregar flujo a un chatbot                    
                    } else if (componente instanceof Flow_17986494_Sepulveda) {  
                        ArrayList<Chatbot_17986494_Sepulveda> todos = sys.getAllChatbots();
                        System.out.println("Seleccionar el chatbot al que se agregara el flujo");
                        Chatbot_17986494_Sepulveda chatbot = MenusSeleccionar_17986494_Sepulveda.menuSelectChatbot(input, sys, todos);
                        if (chatbot != null) {
                            chatbot.chatbotAddFlow((Flow_17986494_Sepulveda) componente);
                        }else{
                            System.out.println("Operacion terminada sin agregar componente");
                        }
                                                
                    //Caso de agregar opcion a un flujo
                    } else if (componente instanceof Option_17986494_Sepulveda) {
                        ArrayList<Flow_17986494_Sepulveda> todos = sys.getAllFlows();
                        System.out.println("Seleccionar el flujo al que se agregara la opcion");
                        Flow_17986494_Sepulveda flow = MenusSeleccionar_17986494_Sepulveda.menuSelectFlow(input, sys, todos);
                        if (flow != null) {
                            flow.flowAddOption((Option_17986494_Sepulveda) componente);
                        } else{
                            System.out.println("Operacion terminada sin agregar componente");
                        }   
                    }
                    isActionCompleted = true;
                    break;
                case "no":
                    //Sección del menú específica para añadir un componente cualquiera
                    //al listado de componentes del sistema.
                    menuAddComponentToDisponibles(input, sys, tipoComponente, componente);
                    isActionCompleted = true;
                    break;
                default:
                    System.out.println("Ingrese una opcion valida.");
                    break;
            }
        }
    }

    /**
     * Menu específico para añadir un componente al listado de componentes disponibles, 
     * o elegir cancelar la operación, lo que hará que el componente creado se pierda.
     * 
     * @param input
     * @param sys
     * @param tipoComponente
     * @param componente
     */    
    private static void menuAddComponentToDisponibles(Scanner input, System_17986494_Sepulveda sys, String tipoComponente, Componente_17986494_Sepulveda componente){
        boolean isActionCompleted = false;
        while (!isActionCompleted){
            System.out.print("¿Desea guardar el " + tipoComponente + " en el listado de componentes? Ingrese 'si' para confirmar, 'no' para cancelar: ");
            String userInput = input.nextLine().toLowerCase();            
            switch (userInput) {
                case "si":
                    sys.addComponente(componente);
                    System.out.println("Se guardo el " + tipoComponente + " en el listado de componentes del sistema.");
                    isActionCompleted = true;
                    break;
                case "no":
                    System.out.println("Ok, el " + tipoComponente + " no sera guardado.");
                    isActionCompleted = true;
                    break;
                default:
                    System.out.println("Ingrese una opcion valida ('si' o 'no').");
                    break;
            }
        }
    }

}    
