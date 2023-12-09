/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_17986494_Sepulveda;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *Clase que contiene los menus que permiten AGREGAR un componente a otro correspondiente. Los componentes
 * a agregar vienen de los componentes disponibles creados en el sistema y que
 * no hayan sido asignados para su uso.
 * @author nic_s
 */
public class MenusAgregar_17986494_Sepulveda {
    
    /**
     *Menú para agregar un chatbot. Ejecuta las acciones necesarias para elegir un chatbot
     * desde la lista de chatbots disponibles para ser luego añadido al sistema. 
     * Se evita la inclusión de duplicaciones al usar el método {@link System_17986494_Sepulveda#systemAddChatbot(lab3_17986494_Sepulveda.Chatbot_17986494_Sepulveda) }
     * 
     * @param input
     * @param sys
     */
    public static void menuAgregarChatbot(Scanner input, System_17986494_Sepulveda sys){
        ArrayList<Chatbot_17986494_Sepulveda> chatbots = Componente_17986494_Sepulveda.<Chatbot_17986494_Sepulveda>filterComponent(
                                                    sys.getComponentes(), Chatbot_17986494_Sepulveda.class);
        System.out.println("Seleccionar chatbot disponible que se desea agregar al sistema");
        Chatbot_17986494_Sepulveda chatbot = MenusSeleccionar_17986494_Sepulveda.menuSelectChatbot(input, sys, chatbots);
        
        if (chatbot == null){
            System.out.println("No se selecciono un chatbot");
            return;
        }
        sys.systemAddChatbot(chatbot);
    }
    
    /**
     *Menú para agregar un flujo. Ejecuta las acciones necesarias para elegir un flujo
     * desde la lista de flujos disponibles para ser luego elegir cualquier chatbot
     * existente en el sitema para ser añadido a éste.
     * Se evita la inclusión de duplicaciones al usar el método {@link Chatbot_17986494_Sepulveda#chatbotAddFlow(lab3_17986494_Sepulveda.Flow_17986494_Sepulveda) }
     * 
     * @param input
     * @param sys
     */
    public static void menuAgregarFlow(Scanner input, System_17986494_Sepulveda sys){
        ArrayList<Flow_17986494_Sepulveda> flows = Componente_17986494_Sepulveda.<Flow_17986494_Sepulveda>filterComponent(
                                                    sys.getComponentes(), Flow_17986494_Sepulveda.class);

        System.out.println("Primero, seleccionar flujo que se desea agregar");
        Flow_17986494_Sepulveda flujo = MenusSeleccionar_17986494_Sepulveda.menuSelectFlow(input, sys, flows);
                
        if (flujo == null){
            System.out.println("No se selecciono un flujo");
            return;
        }
        System.out.println("Luego, seleccionar chatbot al cual se desea agregar un flujo");
        ArrayList<Chatbot_17986494_Sepulveda> chatbots = sys.getAllChatbots();
        Chatbot_17986494_Sepulveda chatbot = MenusSeleccionar_17986494_Sepulveda.menuSelectChatbot(input, sys, chatbots);

        if (chatbot == null){
            System.out.println("No se selecciono un chatbot");
            return;
        }
        
        chatbot.chatbotAddFlow(flujo);
    }    

    /**
     *Menú para agregar una opcion. Ejecuta las acciones necesarias para elegir una opcion
     * desde la lista de opciones disponibles para ser luego elegir cualquier flujo
     * existente en el sitema para ser añadida a éste.
     * Se evita la inclusión de duplicaciones al usar el método {@link Flow_17986494_Sepulveda#flowAddOption(lab3_17986494_Sepulveda.Option_17986494_Sepulveda)  }
     * 
     * @param input
     * @param sys
     */
    public static void menuAgregarOption(Scanner input, System_17986494_Sepulveda sys){
        ArrayList<Option_17986494_Sepulveda> options = Componente_17986494_Sepulveda.<Option_17986494_Sepulveda>filterComponent(
                                                    sys.getComponentes(), Option_17986494_Sepulveda.class);
        
        System.out.println("Primero, seleccionar opcion que se desea agregar");
        Option_17986494_Sepulveda opcion = MenusSeleccionar_17986494_Sepulveda.menuSelectOption(input, sys, options);
                
        if (opcion == null){
            System.out.println("No se selecciono una opcion");
            return;
        }
        System.out.println("Luego, seleccionar flujo al cual se desea agregar la opcion");
        ArrayList<Flow_17986494_Sepulveda> flows = sys.getAllFlows();
        Flow_17986494_Sepulveda flow = MenusSeleccionar_17986494_Sepulveda.menuSelectFlow(input, sys, flows);

        if (flow == null){
            System.out.println("No se selecciono un flujo");
            return;
        }
        
        flow.flowAddOption(opcion);
    }
}
