/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_17986494_Sepulveda;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author nic_s
 */
public class MenusGeneral_17986494_Sepulveda {
    
    public static void menuFirst(System_17986494_Sepulveda sys){
        Scanner input = new Scanner(System.in);
        int MENU_EXIT_OPTION = 3;
        int choice = 0;
        while (choice != MENU_EXIT_OPTION){
            PrintingMenuFunctions_17986494_Sepulveda.printMenuFirst();
            try {
                System.out.print("Ingrese opcion: ");
                choice = input.nextInt();
                
                switch (choice) {
                    case 1:
                        Scanner myObj = new Scanner(System.in); 
                        System.out.println("Ingrese nombre de usuario administrador: ");
                        String userName = myObj.nextLine();
                        sys.registerUser(userName, true);
                        sys.systemLogin(sys.getAdmin());
                        menuAdmin(sys);
                        break;
                    case 2:
                        System.out.println("Chatbot de prueba\n");
                        System.out.print("Bienvenido usuario 'admin'\n");
                        menuAdmin(DemoSystem_17986494_Sepulveda.getDemo());
                    case 3:
                        System.out.println("Ok! Muchas gracias por usar nuestro sistema");
                        System.exit(0);
                        break;
                    default:
                        System.out.println(choice + " No es una opci�n v�lida! Por favor int�ntelo de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Recuerde ingresar opciones num�ricas. Por favor int�ntelo de nuevo.");
                input.nextLine();
            }
        } 
    }
 /*   
    public static void menuFirst(int choice, System_17986494_Sepulveda sys, Scanner input){
        switch (choice) {
            case 1:
                Scanner myObj = new Scanner(System.in); 
                System.out.println("Ingrese nombre de usuario administrador: ");
                String userName = myObj.nextLine();
                sys.registerUser(userName, true);
                sys.systemLogin(sys.getAdmin());
                menuAdmin(sys);
                break;
            case 2:
                System.out.println("Chatbot de prueba\n");
                System.out.print("Bienvenido usuario 'admin'\n");
                menuAdmin(DemoSystem_17986494_Sepulveda.getDemo());
            case 3:
                System.out.println("Ok! Muchas gracias por usar nuestro sistema");
                System.exit(0);
                break;
            default:
                System.out.println(choice + " No es una opci�n v�lida! Por favor int�ntelo de nuevo.");
        }
    }
*/
    public static void menuAdmin(System_17986494_Sepulveda sys){
        Scanner input = new Scanner(System.in);
        int MENU_EXIT_OPTION = 8;
        int choice = 0;
        while (choice != MENU_EXIT_OPTION) {
            PrintingMenuFunctions_17986494_Sepulveda.printMenuAdmin();
            try{
                System.out.print("Ingrese opcion: ");
                choice = input.nextInt();
                
                switch (choice){
                    case 1:
                        menuCrear(sys);              //Menu para crear componentes nuevos
                        break;
                    case 2:
                        menuModificar(sys);          //Menu para modificar componentes existentes
                        break;
                    case 3:
                        menuAgregar(sys);           //Menu para agregar componentes disponibles
                        break;                        
                    case 4:
                        menuInteract(sys,true);//Menu para interactuar con chatbots
                        break;
                    case 5:
                        //Registrar un usuario nuevo
                        Scanner myObj = new Scanner(System.in); 
                        System.out.println("Ingrese nombre de nuevo usuario: ");
                        String userName = myObj.nextLine();
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
                        System.out.println("Ok! Cerrando sesi�n...\n");
                        menuMain(sys);
                        break;
                    case 8:
                        System.out.println("Ok! Muchas gracias por usar nuestro sistema");
                        System.exit(0);
                        break;
                    default:
                        System.out.println(choice + " No es una opci�n v�lida! Por favor int�ntelo de nuevo.");  
                }
            }catch(InputMismatchException  e){
                System.out.println("Recuerde ingresar opciones num�ricas. Por favor int�ntelo de nuevo."); 
                input.nextLine();
            }
        }
    }

    public static void menuMain(System_17986494_Sepulveda sys){
        Scanner input = new Scanner(System.in);
        int MENU_EXIT_OPTION = 2;
        int choice = 0;
        while (choice != MENU_EXIT_OPTION) {    
            PrintingMenuFunctions_17986494_Sepulveda.printMenuMain();
            try {
                System.out.print("Ingrese opcion: ");
                choice = input.nextInt();
                
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
                             menuAdmin(sys);
                         }else{
                             menuInteract(sys,false);
                         }
                         break;
                     //Salir
                     case 2:
                         System.out.println("Ok! Muchas gracias por usar nuestro sistema");
                         System.exit(0);
                         break;
                     default:
                         System.out.println(choice + " No es una opci�n v�lida! Por favor int�ntelo de nuevo.");     
                 }
            } catch (InputMismatchException e) {
                System.out.println("Recuerde ingresar opciones num�ricas. Por favor int�ntelo de nuevo.");
                input.nextLine();
            }
        } 
    }
       
    public static void menuInteract(System_17986494_Sepulveda sys,boolean isAdmin){
        Scanner input = new Scanner(System.in);
        int MENU_EXIT_OPTION = 4;
        int choice = 0;
        int maxInters = 0;
        boolean returnToPrevMenu = false;
        while (choice != MENU_EXIT_OPTION && !returnToPrevMenu) {
            PrintingMenuFunctions_17986494_Sepulveda.printMenuInteract(isAdmin);
            try {
                System.out.print("Ingrese opci�n: ");
                choice = input.nextInt();
                switch (choice) {
                    //Conversaci�n
                    case 1:
                        System.out.print("Iniciando conversaci�n\n");
                        System.out.print("Para terminar la interacci�n, en cualquier momento ingrese 'exit'\n");
                        Scanner interactInput = new Scanner(System.in);
                        try{
                            sys.systemInteraction(interactInput);
                        }catch (NullPointerException e){
                            System.out.println("ERROR: Opci�n enlaza a chatbot inexistente o inv�lido");
                            System.out.println("Se ha terminado la interacci�n");
                        }catch (NoSuchElementException e){
                            System.out.println("ERROR: Opci�n enlaza a flujo inexistente o inv�lido");
                            System.out.println("Se ha terminado la interacci�n");
                        }                            
                        break;
                    //Simulacion
                    case 2:    
                        System.out.print("Ingrese el n�mero m�ximo de interacciones deseadas: ");
                        Scanner input2 = new Scanner(System.in);                   
                        maxInters = input2.nextInt();
                        break;
                    //Sintesis
                    case 3:
                        System.out.print("3. Solicitar s�ntesis de mis conversaciones\n");
                        break;
                    case 4:
                        //Si el menu es visto por un usuario normal, esta opci�n cierra sesi�n
                        //para volver a menuMain()
                        if (!isAdmin){
                            sys.systemLogout();
                        }
                        //Por otro lado, si es admin, con esta opci�n volver� a menuAdmin()
                        returnToPrevMenu = true;
                        break;
                    default:
                        System.out.println(choice + " No es una opci�n v�lida! Por favor int�ntelo de nuevo.");      
                }
            } catch (InputMismatchException e) {
                System.out.println("Recuerde ingresar opciones num�ricas. Por favor int�ntelo de nuevo.");
                input.nextLine();
            }
        }        
    }

    public static void menuCrear(System_17986494_Sepulveda sys){
        Scanner input = new Scanner(System.in);
        int MENU_EXIT_OPTION = 4;
        int choice = 0;
        boolean returnToPrevMenu = false;
        while (choice != MENU_EXIT_OPTION && !returnToPrevMenu) {    
            PrintingMenuFunctions_17986494_Sepulveda.printMenuCrear();
            try {
                System.out.print("Ingrese opcion: ");
                choice = input.nextInt();
                
                switch (choice){
                    case 1:
                        //Creaci�n de chatbots. Difiere si es el primer chatbot o ya existen m�s en el sistema
                        if (sys.getChatbots().isEmpty()){
                            MenusCrear_17986494_Sepulveda.menuCrearChatbot(sys,true);
                        }else{
                            MenusCrear_17986494_Sepulveda.menuCrearChatbot(sys,false);
                        }
                        break;
                    case 2:
                        MenusCrear_17986494_Sepulveda.menuCrearFlow(sys);
                        break;
                    case 3:
                        MenusCrear_17986494_Sepulveda.menuCrearOption(sys);
                        break;
                    case 4:
                        returnToPrevMenu = true;
                        break;
                    default:
                        System.out.println(choice + " No es una opci�n v�lida! Por favor int�ntelo de nuevo.");     
                }
            } catch (InputMismatchException e) {
                System.out.println("Recuerde ingresar opciones num�ricas. Por favor int�ntelo de nuevo.");
                input.nextLine(); //Lim�ar buffer de entrada
            }
        }
    }

    public static void menuModificar(System_17986494_Sepulveda sys){
        Scanner input = new Scanner(System.in);
        int MENU_EXIT_OPTION = 4;
        int choice = 0;
        boolean returnToPrevMenu = false;
        while (choice != MENU_EXIT_OPTION && !returnToPrevMenu) {    
            PrintingMenuFunctions_17986494_Sepulveda.printMenuModificar();            
            try {
                System.out.print("Ingrese opcion: ");
                choice = input.nextInt();
                
                switch (choice){
                    case 1:
                        //MenusComponentes_17986494_Sepulveda.menuModificarChatbot(sys);
                        break;
                    case 2:
                        //MenusComponentes_17986494_Sepulveda.menuModificarFlow(sys);
                        break;
                    case 3:
                        //MenusComponentes_17986494_Sepulveda.menuModificarOption(sys);
                        break;
                    case 4:
                        returnToPrevMenu = true;
                        break;
                    default:
                        System.out.println(choice + " No es una opci�n v�lida! Por favor int�ntelo de nuevo.");     
                }
            } catch (InputMismatchException e) {
                System.out.println("Recuerde ingresar opciones num�ricas. Por favor int�ntelo de nuevo.");
                input.nextLine();
            }
        } 
    }

    public static void menuAgregar(System_17986494_Sepulveda sys){
        Scanner input = new Scanner(System.in);
        int MENU_EXIT_OPTION = 4;
        int choice = 0;
        boolean returnToPrevMenu = false;
        while (choice != MENU_EXIT_OPTION && !returnToPrevMenu) {    
            PrintingMenuFunctions_17986494_Sepulveda.printMenuCrear();            
            try {
                System.out.print("Ingrese opcion: ");
                choice = input.nextInt();
                
                switch (choice){
                    case 1:
                        MenusAgregar_17986494_Sepulveda.menuAgregarChatbot(sys);
                        break;
                    case 2:
                        MenusAgregar_17986494_Sepulveda.menuAgregarFlow(sys);
                        break;
                    case 3:
                        MenusAgregar_17986494_Sepulveda.menuAgregarOption(sys);
                        break;
                    case 4:
                        returnToPrevMenu = true;
                        break;
                    default:
                        System.out.println(choice + " No es una opci�n v�lida! Por favor int�ntelo de nuevo.");     
                }
            } catch (InputMismatchException e) {
                System.out.println("Recuerde ingresar opciones num�ricas. Por favor int�ntelo de nuevo.");
                input.nextLine();
            }
        }
    }       
}
