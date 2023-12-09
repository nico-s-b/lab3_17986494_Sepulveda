/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_17986494_Sepulveda;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *Clase para los menus para MODIFICAR cualquier componente del sistema de chatbots. 
 * Los componentes son seleccionados con los menus para selección y luego pueden
 * seleccionarse los atributos que se desean cambiar.
 * @author nic_s
 */
public class MenusModificar_17986494_Sepulveda {
    
    /**
     *Menú de control de flujo para seleccion de chatbot a modificar. Obtiene una lista
     * de todos los chatbots del sistema, llama a método para seleccionar uno de estos, 
     * lo muestra y carga en el atributo {@link System_17986494_Sepulveda#componenteTemporal}
     * para luego llamar a través de inteface funcional al menú de ejecución de la modificación
     * de un chatbot.
     * 
     * @param input
     * @param sys
     */
    public static void menuModificarChatbot(Scanner input, System_17986494_Sepulveda sys){
        ArrayList<Chatbot_17986494_Sepulveda> todos = sys.getAllChatbots();
        System.out.println("Seleccionar el chatbot que se desea modificar");
        Chatbot_17986494_Sepulveda componente = MenusSeleccionar_17986494_Sepulveda.menuSelectChatbot(input, sys, todos);
        if (componente == null){
            System.out.println("Operacion terminada sin seleccionar un chatbot");
            return;
        }
        
        System.out.println("Este es el chatbot a modificar:");
        System.out.println(componente);
        sys.setComponenteTemporal(componente);
        
        TemplateMenu_17986494_Sepulveda.menu(input, sys, PrintingMenuFunctions_17986494_Sepulveda::printMenuModificarChatbot, MenusModificar_17986494_Sepulveda::handleMenuModificarChatbot);
        sys.setComponenteTemporal(null);
    }

    /**
     *Menú de modificación de un chatbot. Toma el componente cargado en el atributo
     * de componente temporal del sistema y permite modificar todos sus atributos.
     * Utiliza la interface funcional de {@link TemplateMenu_17986494_Sepulveda#menu(java.util.Scanner, lab3_17986494_Sepulveda.System_17986494_Sepulveda, lab3_17986494_Sepulveda.TemplateMenu_17986494_Sepulveda.PrintMenuFunction, lab3_17986494_Sepulveda.TemplateMenu_17986494_Sepulveda.SwitchMenuFunction) }
     * 
     * @param choice
     * @param sys
     * @param input
     * @param returnToPrev
     */
    public static void handleMenuModificarChatbot(int choice, System_17986494_Sepulveda sys, Scanner input, MutableBool returnToPrev){
        Chatbot_17986494_Sepulveda chatbot = (Chatbot_17986494_Sepulveda) sys.getComponenteTemporal();
        switch (choice){
            case 1:
                //Cambiar nombre
                System.out.print("Ingresa nuevo nombre: ");
                String newName = input.nextLine();
                chatbot.setName(newName);
                break;
            case 2:
                //Cambiar mensaje de bienvenida
                System.out.print("Ingresa nuevo mensaje de bienvenida: ");
                String newMens = input.nextLine();
                chatbot.setName(newMens);
                break;
            case 3:
                //Cambiar flowCode
                System.out.print("Ingresa nuevo codigo de flujo inicial: ");
                if (input.hasNextInt()){
                    int newFlowCode = input.nextInt();
                    chatbot.setId(newFlowCode);
                } else {
                    System.out.println("Entrada invalida, solo se aceptan numeros.");
                }
                break;
            case 4:
                //Eliminar flujos
                if(chatbot.getFlows().isEmpty()){
                    System.out.println("El chatbot no tiene flujos que eliminar.");
                    break;
                }
                int i = 1;
                System.out.println("Seleccionar flujo a eliminar\nListado de flujos del chatbot: ");
                for (Flow_17986494_Sepulveda comp: chatbot.getFlows()){
                    System.out.println(String.format("%d) %s",i,comp.getName()));
                    i++;
                }
                System.out.println("Ingresa el numero del flujo a eliminar: \n(Ingrese 0 para cancelar)");

                int index;
                
                boolean isActionCompleted = false;
                while (!isActionCompleted) {
                    try {
                        index = input.nextInt();
                        if (index == 0) { //Cancelar operación
                            isActionCompleted = true;
                        }
                        if (index >= 1 && index <= chatbot.getFlows().size()) {
                            chatbot.getFlows().remove(index - 1);
                            System.out.println("Flujo eliminado");
                            isActionCompleted = true;
                        } else {
                            System.out.println("Ingresa un numero valido (entre 1 y " + chatbot.getFlows().size() + ")");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Ingresa un numero valido (entre 1 y " + chatbot.getFlows().size() + ")");
                        input.next(); // Limpiar el búfer de entrada
                    }
                }
                break;
            case 5:
                //Agregar flujos
                ArrayList<Flow_17986494_Sepulveda> flows = Componente_17986494_Sepulveda.<Flow_17986494_Sepulveda>filterComponent(
                                                             sys.getComponentes(), Flow_17986494_Sepulveda.class);

                 System.out.println("Seleccionar flujo que se desea agregar");
                 Flow_17986494_Sepulveda flujo = MenusSeleccionar_17986494_Sepulveda.menuSelectFlow(input, sys, flows);

                 if (flujo == null){
                     System.out.println("No se selecciono un flujo");
                     break;
                 }
                chatbot.chatbotAddFlow(flujo);
                System.out.println("Flujo agregado");
                break;                
            case 6:
                returnToPrev.valor = true;
                break;
            default:
                System.out.println(choice + " No es una opcion valida! Por favor intentelo de nuevo.");     
        }    
    }

    /**
     *Menú de control de flujo para seleccion de flujo a modificar. Obtiene una lista
     * de todos los flujos del sistema, llama a método para seleccionar uno de estos, 
     * lo muestra y carga en el atributo {@link System_17986494_Sepulveda#componenteTemporal}
     * para luego llamar a través de inteface funcional al menú de ejecución de la modificación
     * de un flujo.
     * 
     * @param input
     * @param sys
     */
    public static void menuModificarFlow(Scanner input, System_17986494_Sepulveda sys){
        ArrayList<Flow_17986494_Sepulveda> todos = sys.getAllFlows();
        System.out.println("Seleccionar el flujo que se desea modificar");
        Flow_17986494_Sepulveda componente = MenusSeleccionar_17986494_Sepulveda.menuSelectFlow(input, sys, todos);
        if (componente == null){
            System.out.println("Operacion terminada sin seleccionar un flujo");
            return;
        }
        
        System.out.println("Este es el flujo a modificar:");
        System.out.println(componente);
        sys.setComponenteTemporal(componente);
        
        TemplateMenu_17986494_Sepulveda.menu(input, sys, PrintingMenuFunctions_17986494_Sepulveda::printMenuModificarFlow, MenusModificar_17986494_Sepulveda::handleMenuModificarFlow);
        sys.setComponenteTemporal(null);
    }

    /**
     *Menú de modificación de un chatbot. Toma el componente cargado en el atributo
     * de componente temporal del sistema y permite modificar todos sus atributos.
     * Utiliza la interface funcional de {@link TemplateMenu_17986494_Sepulveda#menu(java.util.Scanner, lab3_17986494_Sepulveda.System_17986494_Sepulveda, lab3_17986494_Sepulveda.TemplateMenu_17986494_Sepulveda.PrintMenuFunction, lab3_17986494_Sepulveda.TemplateMenu_17986494_Sepulveda.SwitchMenuFunction) 
     * 
     * @param choice
     * @param sys
     * @param input
     * @param returnToPrev
     */
    public static void handleMenuModificarFlow(int choice, System_17986494_Sepulveda sys, Scanner input, MutableBool returnToPrev){
        Flow_17986494_Sepulveda flow = (Flow_17986494_Sepulveda) sys.getComponenteTemporal();
        switch (choice){
            case 1:
                //Cambiar nombre
                System.out.print("Ingresa nuevo mensaje del flujo: ");
                String newName = input.nextLine();
                flow.setName(newName);
                break;
            case 2:
                //Eliminar opciones
                if(flow.getOptions().isEmpty()){
                    System.out.println("El flujo no tiene opciones que eliminar.");
                    break;
                }
                int i = 1;
                System.out.println("Seleccionar opcion a eliminar\nListado de opciones del flujo: ");
                for (Option_17986494_Sepulveda comp: flow.getOptions()){
                    System.out.println(String.format("%d) %s",i,comp.getMessage()));
                    i++;
                }
                System.out.println("Ingresa el numero de la opcion a eliminar: \n(Ingrese 0 para cancelar)");

                int index;
                
                boolean isActionCompleted = false;
                while (!isActionCompleted) {
                    try {
                        index = input.nextInt();
                        if (index == 0) { //Cancelar operación
                            isActionCompleted = true;
                        }
                        if (index >= 1 && index <= flow.getOptions().size()) {
                            flow.getOptions().remove(index - 1);
                            System.out.println("Flujo eliminado");
                            isActionCompleted = true;
                        } else {
                            System.out.println("Ingresa un numero valido (entre 1 y " + flow.getOptions().size() + ")");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Ingresa un numero valido (entre 1 y " + flow.getOptions().size() + ")");
                        input.next(); // Limpiar el búfer de entrada
                    }
                }
                break;
            case 3:
                //Agregar opciones
                ArrayList<Option_17986494_Sepulveda> options = Componente_17986494_Sepulveda.<Option_17986494_Sepulveda>filterComponent(
                                                             sys.getComponentes(), Option_17986494_Sepulveda.class);

                 System.out.println("Seleccionar opcion que se desea agregar");
                 Option_17986494_Sepulveda opcion = MenusSeleccionar_17986494_Sepulveda.menuSelectOption(input, sys, options);

                 if (opcion == null){
                     System.out.println("No se selecciono un flujo");
                     break;
                 }
                flow.flowAddOption(opcion);
                System.out.println("Flujo agregado");
                break;                
            case 4:
                returnToPrev.valor = true;
                break;
            default:
                System.out.println(choice + " No es una opcion valida! Por favor intentelo de nuevo.");     
        }    
    }

    /**
     *Menú de control de flujo para seleccion de opción a modificar. Obtiene una lista
     * de todas las opciones del sistema, llama a método para seleccionar uno de estos, 
     * lo muestra y carga en el atributo {@link System_17986494_Sepulveda#componenteTemporal}
     * para luego llamar a través de inteface funcional al menú de ejecución de la modificación
     * de una opción.
     * 
     * @param input
     * @param sys
     */
    public static void menuModificarOption(Scanner input, System_17986494_Sepulveda sys){
        ArrayList<Option_17986494_Sepulveda> todos = sys.getAllOptions();
        System.out.println("Seleccionar la opcion que se desea modificar");
        Option_17986494_Sepulveda componente = MenusSeleccionar_17986494_Sepulveda.menuSelectOption(input, sys, todos);
        if (componente == null){
            System.out.println("Operacion terminada sin seleccionar una opcion");
            return;
        }
        
        System.out.println("Esta es la opcion a modificar:");
        System.out.println(componente);
        sys.setComponenteTemporal(componente);
        
        TemplateMenu_17986494_Sepulveda.menu(input, sys, PrintingMenuFunctions_17986494_Sepulveda::printMenuModificarOption, MenusModificar_17986494_Sepulveda::handleMenuModificarOption);
        sys.setComponenteTemporal(null);
    }

    /**
     *Menú de modificación de un chatbot. Toma el componente cargado en el atributo
     * de componente temporal del sistema y permite modificar todos sus atributos.
     * Utiliza la interface funcional de {@link TemplateMenu_17986494_Sepulveda#menu(java.util.Scanner, lab3_17986494_Sepulveda.System_17986494_Sepulveda, lab3_17986494_Sepulveda.TemplateMenu_17986494_Sepulveda.PrintMenuFunction, lab3_17986494_Sepulveda.TemplateMenu_17986494_Sepulveda.SwitchMenuFunction) 
     * 
     * @param choice
     * @param sys
     * @param input
     * @param returnToPrev
     */
    public static void handleMenuModificarOption(int choice, System_17986494_Sepulveda sys, Scanner input, MutableBool returnToPrev){
        Option_17986494_Sepulveda option = (Option_17986494_Sepulveda) sys.getComponenteTemporal();
        switch (choice){
            case 1:
                //Cambiar nombre
                System.out.print("Ingresa nuevo mensaje: ");
                String newMens = input.nextLine();
                option.setMessage(newMens);
                break;
            case 2:
                //Cambiar chatbotCode
                System.out.print("Ingresa nuevo codigo de enlace a chatbot: ");
                if (input.hasNextInt()){
                    int newChatbotCode = input.nextInt();
                    option.setChatbotCodeLink(newChatbotCode);
                } else {
                    System.out.println("Entrada invalida, solo se aceptan numeros.");
                }
                break;
            case 3:
                //Cambiar flowCode
                System.out.print("Ingresa nuevo codigo de enlace a flujo: ");
                if (input.hasNextInt()){
                    int newFlowCode = input.nextInt();
                    option.setFlowCodeLink(newFlowCode);
                } else {
                    System.out.println("Entrada invalida, solo se aceptan numeros.");
                }
                break;
            case 4:
                //Agregar palabra clave
                System.out.print("Ingresa nueva palabra clave: ");
                String newWord = input.nextLine().toLowerCase();
                option.addKeyword(newWord);
                break;
            case 5:
                //Eliminar palabra clave
                System.out.print("Listado de palabras clave disponibles: \n");
                if (option.getKeywords().isEmpty()){
                    System.out.print("No hay palabras clave\n");
                    break;
                }
                int i = 1;
                for (String word: option.getKeywords()){
                    System.out.println(String.format("%d) %s",i,word));
                    i++;
                }
                System.out.println("Ingresa el numero de la palabra a eliminar: \n(Ingrese 0 para cancelar)");

                int index;
                
                boolean isActionCompleted = false;
                while (!isActionCompleted) {
                    try {
                        index = input.nextInt();
                        if (index == 0) { //Cancelar operación
                            isActionCompleted = true;
                        }
                        if (index >= 1 && index <= option.getKeywords().size()) {
                            option.getKeywords().remove(index - 1);
                            System.out.println("Palabra eliminada");
                            isActionCompleted = true;
                        } else {
                            System.out.println("Ingresa un numero valido (entre 1 y " + option.getKeywords().size() + ")");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Ingresa un numero valido (entre 1 y " + option.getKeywords().size() + ")");
                        input.next(); // Limpiar el búfer de entrada
                    }
                }                
            case 6:
                returnToPrev.valor = true;
                break;
            default:
                System.out.println(choice + " No es una opcion valida! Por favor intentelo de nuevo.");     
        }    
    }
    
}
