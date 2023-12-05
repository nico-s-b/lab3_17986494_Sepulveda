/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package lab3_17986494_Sepulveda;

import java.util.InputMismatchException;
import java.util.Scanner;

//import lab3_17986494_Sepulveda.System_17986494_Sepulveda;

public class Main {
    public static void main(String[] args) {        
        System_17986494_Sepulveda mySystem = new System_17986494_Sepulveda();
        
        menuFirst(mySystem);
        
    }
    
    private static void menuFirst(System_17986494_Sepulveda sys){
        Scanner input = new Scanner(System.in);
        int MENU_EXIT_OPTION = 2;
        int choice;
        do {
            Menus_17986494_Sepulveda.printMenuFirst();

            do {
                try {
                    choice = input.nextInt();
                    switch (choice) {
                        case 1:
                            Scanner myObj = new Scanner(System.in); 
                            System.out.println("Ingrese nombre de usuario administrador: ");
                            String userName = myObj.nextLine();
                            sys.registerUser(userName, true);
                            sys.login(sys.getAdmin());
                            menuAdmin(sys);
                            break;
                        case 2:
                            System.out.println("Ok! Muchas gracias por usar nuestro sistema");
                            System.exit(0);
                            break;
                        default:
                            System.out.println(choice + " No es una opci�n v�lida! Por favor int�ntelo de nuevo.");
                            System.out.print("\nIngrese opcion: ");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Recuerde ingresar opciones num�ricas. Por favor int�ntelo de nuevo.");
                    System.out.print("\nIngrese opcion: ");
                    input.nextLine();
                }
            } while (true); // Continuar hasta que se ingrese una entrada v�lida
        } while (choice != MENU_EXIT_OPTION);   
    }

    
    private static void menuAdmin(System_17986494_Sepulveda sys){
        Scanner input = new Scanner(System.in);
        int MENU_EXIT_OPTION = 7;
        int choice;
        do {
            Menus_17986494_Sepulveda.printMenuAdmin();
            do{
                try{
                    choice = input.nextInt();
                    switch (choice){
                        case 1:
                            menuCrear(sys);              //Menu para crear componentes nuevos
                            break;
                        case 2:
                            menuModificar(sys);          //Menu para modificar componentes existentes
                            break;
                        case 3:
                            menuInteract(sys,true);//Menu para interactuar con chatbots
                            break;
                        case 4:
                            //Registrar un usuario nuevo
                            Scanner myObj = new Scanner(System.in); 
                            System.out.println("Ingrese nombre de nuevo usuario: ");
                            String userName = myObj.nextLine();
                            sys.registerUser(userName, false);
                            break;
                        case 5:
                            System.out.println("\nListado de usuarios registrados: \n");
                            sys.registeredUsers();  //Mostrar usuarios registrados
                            System.out.println("");
                            break;
                        case 6:
                            sys.logout();           //Cerrar sesi�n
                            System.out.println("Ok! Cerrando sesi�n...\n");
                            menuMain(sys);
                            break;
                        case 7:
                            System.out.println("Ok! Muchas gracias por usar nuestro sistema");
                            System.exit(0);
                            break;
                        default:
                            System.out.println(choice + " No es una opci�n v�lida! Por favor int�ntelo de nuevo.");  
                            System.out.print("\nIngrese opcion: ");
                    }
                }catch(InputMismatchException  e){
                    System.out.println("Recuerde ingresar opciones num�ricas. Por favor int�ntelo de nuevo."); 
                    System.out.print("\nIngrese opcion: ");
                    input.nextLine();
                }
            }while (true);       
        } while (choice != MENU_EXIT_OPTION);   
    }

    private static void menuMain(System_17986494_Sepulveda sys){
        Scanner input = new Scanner(System.in);
        int MENU_EXIT_OPTION = 2;
        int choice;
        do {    
            Menus_17986494_Sepulveda.printMenuMain();

            do {
                try {
                    choice = input.nextInt();
                    switch (choice){
                         //Iniciar sesi�n
                         case 1:
                             Scanner myObj = new Scanner(System.in); 
                             System.out.println("Ingrese nombre de usuario: ");
                             String userName = myObj.nextLine();
                             sys.login(sys.getUser(userName));
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
                             System.out.print("\nIngrese opcion: ");
                     }
                } catch (InputMismatchException e) {
                    System.out.println("Recuerde ingresar opciones num�ricas. Por favor int�ntelo de nuevo.");
                    System.out.print("\nIngrese opcion: ");
                    input.nextLine();
                }
            } while (true); // Continuar hasta que se ingrese una entrada v�lida
        } while (choice != MENU_EXIT_OPTION);   
    }
       
    private static void menuInteract(System_17986494_Sepulveda sys,boolean isAdmin){
        Scanner input = new Scanner(System.in);
        int MENU_EXIT_OPTION = 4;
        int choice;
        int maxInters;
        boolean returnToPrevMenu = false;
        do {    
            Menus_17986494_Sepulveda.printMenuInteract(isAdmin);
            do {
                try {
                    choice = input.nextInt();
                    switch (choice) {
                        //Conversaci�n
                        case 1:                            
                            System.out.print("1. Iniciar una conversaci�n\n");
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
                                sys.logout();
                            }
                            //Por otro lado, si es admin, con esta opci�n volver� a menuAdmin()
                            returnToPrevMenu = true;
                            break;
                        default:
                            System.out.println(choice + " No es una opci�n v�lida! Por favor int�ntelo de nuevo.");      
                            System.out.print("\nIngrese opcion: ");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Recuerde ingresar opciones num�ricas. Por favor int�ntelo de nuevo.");
                    System.out.print("\nIngrese opcion: ");
                    input.nextLine();
                }
            } while (true); // Continuar hasta que se ingrese una entrada v�lida            
        } while (choice != MENU_EXIT_OPTION && !returnToPrevMenu);
    }

    private static void menuCrear(System_17986494_Sepulveda sys){
        Scanner input = new Scanner(System.in);
        int MENU_EXIT_OPTION = 4;
        int choice;
        boolean returnToPrevMenu = false;
        do {    
            Menus_17986494_Sepulveda.printMenuCrear();            
            do {
                try {
                    choice = input.nextInt();
                    switch (choice){
                        case 1:
                            //Creaci�n de chatbots. Difiere si es el primer chatbot o ya existen m�s en el sistema
                            if (sys.getChatbots().isEmpty()){
                                MenusComponentes_17986494_Sepulveda.menuCrearChatbot(sys,true);
                            }else{
                                MenusComponentes_17986494_Sepulveda.menuCrearChatbot(sys,false);
                            }
                            break;
                        case 2:
                            MenusComponentes_17986494_Sepulveda.menuCrearFlow(sys);
                            break;
                        case 3:
                            MenusComponentes_17986494_Sepulveda.menuCrearOption(sys);
                            break;
                        case 4:
                            returnToPrevMenu = true;
                            break;
                        default:
                            System.out.println(choice + " No es una opci�n v�lida! Por favor int�ntelo de nuevo.");     
                            System.out.print("\nIngrese opcion: ");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Recuerde ingresar opciones num�ricas. Por favor int�ntelo de nuevo.");
                    System.out.print("\nIngrese opcion: ");
                    input.nextLine();
                }
            } while (true); // Continuar hasta que se ingrese una entrada v�lida
        } while (choice != MENU_EXIT_OPTION && !returnToPrevMenu);
    }

    private static void menuModificar(System_17986494_Sepulveda sys){
        Scanner input = new Scanner(System.in);
        int MENU_EXIT_OPTION = 4;
        int choice;
        boolean returnToPrevMenu = false;
        do {    
            Menus_17986494_Sepulveda.printMenuModificar();            
            do {
                try {
                    choice = input.nextInt();
                    switch (choice){
                        case 1:
                            //Creaci�n de chatbots. Difiere si es el primer chatbot o ya existen m�s en el sistema
                            if (sys.getChatbots().isEmpty()){
                                System.out.print("No hay chatbots que modificar!");
                                returnToPrevMenu = true;
                            }else{
                                //MenusComponentes_17986494_Sepulveda.menuModificarChatbot(sys);
                            }
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
                            System.out.print("\nIngrese opcion: ");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Recuerde ingresar opciones num�ricas. Por favor int�ntelo de nuevo.");
                    System.out.print("\nIngrese opcion: ");
                    input.nextLine();
                }
            } while (true); // Continuar hasta que se ingrese una entrada v�lida
        } while (choice != MENU_EXIT_OPTION && !returnToPrevMenu);
    }

}
