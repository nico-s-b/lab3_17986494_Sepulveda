/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_17986494_Sepulveda;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *Clase que contiene los menus generales, que corresponden a aquellos que no
 * modifican componentes del sistema y permiten llamar a otros menus o ejecutar
 * solicitudes al sistema y gestionar usuarios. Maneja la visibilidad de acciones
 * seg�n el privilegio de administrador del usuario que utiliza el sistema.
 * @author nic_s
 */
public class MenusGenerales_17986494_Sepulveda {

    /**
     *Primer menu del programa. Menu que se abre al iniciar la aplicaci�n. Permite
     * registrar al primer usuario administrador para poder iniciar un sistema vac�o,
     * probar el sistema DemoSystem de pruebas o terminar la ejecuci�n.
     * 
     * @param choice
     * @param sys
     * @param input
     * @param returnToPrev
     */
    public static void handleMenuFirst(int choice, System_17986494_Sepulveda sys, Scanner input, MutableBool returnToPrev){
        switch (choice) {
            case 1:
                System.out.println("Ingrese nombre de usuario administrador: ");
                String userName = input.nextLine();
                sys.registerUser(userName, true);
                sys.systemLogin(sys.getAdmin());
                TemplateMenu_17986494_Sepulveda.menu(input, sys, PrintingMenuFunctions_17986494_Sepulveda::printMenuAdmin, MenusGenerales_17986494_Sepulveda::handleMenuAdmin);
                break;
            case 2:
                System.out.println("Chatbot de prueba\n");
                TemplateMenu_17986494_Sepulveda.menu(input, DemoSystem_17986494_Sepulveda.getDemo(), PrintingMenuFunctions_17986494_Sepulveda::printMenuAdmin, MenusGenerales_17986494_Sepulveda::handleMenuAdmin);
            case 3:
                System.out.println("Ok! Muchas gracias por usar nuestro sistema");
                System.exit(0);
                break;
            default:
                System.out.println(choice + " No es una opcion valida! Por favor intentelo de nuevo.");
        }
    }

    /**
     *Menu de Administrador. Visible s�lo si el administrador est� loggeado. Permite que
     * �ste ejecute todas las acciones de Creaci�n, Modificaci�n y Agregaci�n que permite
     * su privilegio de admin, junto con la gesti�n de usuarios, adem�s de las acciones
     * de interacci�n comunes a todo usuario del sistema
     * @param choice
     * @param sys
     * @param input
     * @param returnToPrev
     */
    public static void handleMenuAdmin(int choice, System_17986494_Sepulveda sys, Scanner input, MutableBool returnToPrev){
        switch (choice){
            case 1:
                TemplateMenu_17986494_Sepulveda.menu(input, sys, PrintingMenuFunctions_17986494_Sepulveda::printMenuCrear, MenusGenerales_17986494_Sepulveda::handleMenuCrear);
                break;
            case 2:
                TemplateMenu_17986494_Sepulveda.menu(input, sys, PrintingMenuFunctions_17986494_Sepulveda::printMenuModificar, MenusGenerales_17986494_Sepulveda::handleMenuModificar);
                break;
            case 3:
                TemplateMenu_17986494_Sepulveda.menu(input, sys, PrintingMenuFunctions_17986494_Sepulveda::printMenuAgregar, MenusGenerales_17986494_Sepulveda::handleMenuAgregar);
                break;                        
            case 4:
                TemplateMenu_17986494_Sepulveda.menu(input, sys, PrintingMenuFunctions_17986494_Sepulveda::printMenuInteractAdmin, MenusGenerales_17986494_Sepulveda::handleMenuInteract);
                break;
            case 5:
                //Registrar un usuario nuevo
                System.out.println("Ingrese nombre de nuevo usuario: ");
                String userName = input.nextLine();
                try{
                    sys.registerUser(userName, false);
                    System.out.println("Usuario " + userName + " registrado!");
                }catch(IllegalArgumentException e) {
                    System.out.println("No puede registrar al mismo usuario dos veces!");
                }
                break;
            case 6:
                System.out.println("\nListado de usuarios registrados: \n");
                sys.registeredUsers();  //Mostrar usuarios registrados
                System.out.println("");
                break;
            case 7:
                sys.systemLogout();           //Cerrar sesi�n
                System.out.println("Ok! Cerrando sesion...\n");
                TemplateMenu_17986494_Sepulveda.menu(input,sys, PrintingMenuFunctions_17986494_Sepulveda::printMenuMain, MenusGenerales_17986494_Sepulveda::handleMenuMain);
                break;
            case 8:
                System.out.println("Ok! Muchas gracias por usar nuestro sistema");
                System.exit(0);
                break;
            default:
                System.out.println(choice + " No es una opcion valida! Por favor intentelo de nuevo.");  
        }
    }

    /**
     *Men� principal de inicio de sistema. Este men� se muestra cuando no hay usuarios
     * con sesi�n iniciada, permitiendo que un usuario inicie sesi�n o terminar la ejecuci�n del programa
     * 
     * @param choice
     * @param sys
     * @param input
     * @param returnToPrev
     */
    public static void handleMenuMain(int choice, System_17986494_Sepulveda sys, Scanner input, MutableBool returnToPrev){
        switch (choice){
            //Iniciar sesi�n
            case 1:
                Scanner myObj = new Scanner(System.in); 
                System.out.println("Ingrese nombre de usuario: ");
                String userName = myObj.nextLine();
                sys.systemLogin(sys.getUser(userName));
                //Dependiendo si inicia sesi�n el administrador o un usuario
                //Se deriva a menus distintos
                if (sys.isLogAdmin()){
                    TemplateMenu_17986494_Sepulveda.menu(input, sys, PrintingMenuFunctions_17986494_Sepulveda::printMenuAdmin, MenusGenerales_17986494_Sepulveda::handleMenuAdmin);
                }else{
                    TemplateMenu_17986494_Sepulveda.menu(input, sys, PrintingMenuFunctions_17986494_Sepulveda::printMenuInteractUser, MenusGenerales_17986494_Sepulveda::handleMenuInteract);
                }
                break;
            //Salir
            case 2:
                System.out.println("Ok! Muchas gracias por usar nuestro sistema");
                System.exit(0);
                break;
            default:
                System.out.println(choice + " No es una opcion valida! Por favor intentelo de nuevo.");     
        }
    }
    
    /**
     *Men� de interacciones con el sistema. Este men� maneja las posibles formas de interactuar
     * con el sistema por parte de cualquier usuario, permitiendo iniciar una conversaci�n,
     * solicitar s�ntesis de las interacciones del propio usuario, o solicitar una
     * simulaci�n de interacciones.
     * 
     * @param choice
     * @param sys
     * @param input
     * @param returnToPrev
     */
    public static void handleMenuInteract(int choice, System_17986494_Sepulveda sys, Scanner input, MutableBool returnToPrev){
        switch (choice) {
            case 1:
                System.out.print("Iniciando conversacion\n");
                System.out.print("Para terminar la interaccion, en cualquier momento ingrese 'exit'\n");
                try{
                    sys.systemTalk(input);
                }catch (NullPointerException e){
                    System.out.println("ERROR: Opcion enlaza a chatbot inexistente o invalido");
                    System.out.println("Se ha terminado la interacci�n");
                }catch (NoSuchElementException e){
                    System.out.println("ERROR: Opcion enlaza a flujo inexistente o invalido");
                    System.out.println("Se ha terminado la interacci�n");
                }                            
                break;
            //Simulacion
            case 2:    
                System.out.print("Solicitar simulacion: Se requiere interacciones y semilla\n");
                int maxInters = -1;
                while (maxInters <= 0) {
                    System.out.print("Ingrese el numero maximo de interacciones deseadas: ");
                    if (input.hasNextInt()) {
                        maxInters = input.nextInt();
                        if (maxInters <= 0) {
                            System.out.println("Por favor, ingrese un numero entero positivo.");
                        }
                    } else {
                        System.out.println("Por favor, ingrese un numero entero.");
                        input.next(); // Limpiar entrada inv�lida
                    }
                    input.nextLine(); // Limpiar el buffer de entrada
                }

                int seed = -1;
                while (seed <= 0) {
                    System.out.print("Ingrese el numero que se usara como semilla aleatoria: ");
                    if (input.hasNextInt()) {
                        seed = input.nextInt();
                        if (seed <= 0) {
                            System.out.println("Por favor, ingrese un numero entero positivo.");
                        }
                    } else {
                        System.out.println("Por favor, ingrese un numero entero.");
                        input.next(); // Limpiar entrada inv�lida
                    }
                    input.nextLine(); // Limpiar el buffer de entrada
                }
                System.out.print("Solicitando simulacion...\n\n");
                sys.systemSimulate(maxInters, seed);
                break;
            //Sintesis
            case 3:
                System.out.print("Solicitando sintesis...\n\n");
                sys.systemSynthesis(sys.getUser(sys.getLoggedUser()));
                break;
            case 4:
                //Si el menu es visto por un usuario normal, esta opci�n cierra sesi�n
                //para volver a menuMain()
                if (!sys.isLogAdmin()){
                    sys.systemLogout();
                    returnToPrev.valor = true;
                }
                //Por otro lado, si es admin, con esta opci�n volver� a menuAdmin()
                returnToPrev.valor = true;
                break;
            default:
                System.out.println(choice + " No es una opcion valida! Por favor intentelo de nuevo.");      
        }
    }
    
    /**
     *Menu de creaci�n de componentes. Realiza los llamados a los menus espec�ficos
     * para crear chatbots, flujos y opciones.
     * 
     * @param choice
     * @param sys
     * @param input
     * @param returnToPrev
     */
    public static void handleMenuCrear(int choice, System_17986494_Sepulveda sys, Scanner input, MutableBool returnToPrev){
        switch (choice){
            case 1:
                MenusCrear_17986494_Sepulveda.menuCrearChatbot(input,sys);
                break;
            case 2:
                MenusCrear_17986494_Sepulveda.menuCrearFlow(input,sys);
                break;
            case 3:
                MenusCrear_17986494_Sepulveda.menuCrearOption(input,sys);
                break;
            case 4:
                returnToPrev.valor = true;
                break;
            default:
                System.out.println(choice + " No es una opcion valida! Por favor intentelo de nuevo.");     
        }    
    }
    
    /**
     *Men� de modificaci�n de componentes. Realiza los llamados a los men�s espec�ficos
     * de modificaci�n de chatbots, flujos y opciones seg�n se desee
     * 
     * @param choice
     * @param sys
     * @param input
     * @param returnToPrev
     */
    public static void handleMenuModificar(int choice, System_17986494_Sepulveda sys, Scanner input, MutableBool returnToPrev){
        switch (choice){
            case 1:
                MenusModificar_17986494_Sepulveda.menuModificarChatbot(input, sys);
                break;
            case 2:
                MenusModificar_17986494_Sepulveda.menuModificarFlow(input, sys);
                break;
            case 3:
                MenusModificar_17986494_Sepulveda.menuModificarOption(input, sys);
                break;
            case 4:
                returnToPrev.valor = true;
                break;
            default:
                System.out.println(choice + " No es una opci�n v�lida! Por favor intentelo de nuevo.");     
        }
    }

    /**
     *Men� de agregaci�n de componentes. Realiza los llamados a los men�s espec�ficos
     * para agregar chatbots al sistema, flujos a un chatbot y opciones a un flujo.
     * 
     * @param choice
     * @param sys
     * @param input
     * @param returnToPrev
     */
    public static void handleMenuAgregar(int choice, System_17986494_Sepulveda sys, Scanner input, MutableBool returnToPrev){
        switch (choice){
            case 1:
                MenusAgregar_17986494_Sepulveda.menuAgregarChatbot(input, sys);
                break;
            case 2:
                MenusAgregar_17986494_Sepulveda.menuAgregarFlow(input, sys);
                break;
            case 3:
                MenusAgregar_17986494_Sepulveda.menuAgregarOption(input, sys);
                break;
            case 4:
                returnToPrev.valor = true;
                break;
            default:
                System.out.println(choice + " No es una opci�n v�lida! Por favor int�ntelo de nuevo.");     
        }       
    }
}

