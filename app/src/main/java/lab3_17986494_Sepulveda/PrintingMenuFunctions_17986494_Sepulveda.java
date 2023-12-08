/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_17986494_Sepulveda;

/**
 *
 * @author nic_s
 */
public class PrintingMenuFunctions_17986494_Sepulveda {

    public static void printMenuFirst() {
        System.out.println("Bienvenido al sistema de Chatbots!\n");
        System.out.print("1. Registre al usuario administrador \n");
        System.out.print("2. Probar demo del sistema \n");
        System.out.print("3. Salir\n");
        System.out.print("\nIngrese opcion: ");
    }    
    
    public static void printMenuMain(){
        System.out.println("Bienvenido al sistema de Chatbots!\n");
        System.out.print("1. Iniciar sesi�n\n");
        System.out.print("2. Salir\n");
        System.out.print("\nIngrese opcion: ");
    }        
    
    public static void printMenuAdmin() {
        System.out.println("�Qu� desea hacer, Administrador?\n");
        System.out.print("1. Crear componentes del sistema\n");
        System.out.print("2. Modificar componentes del sistema\n");
        System.out.print("3. A�adir componentes disponibles al sistema\n");
        System.out.print("4. Interactuar con el sistema\n");
        System.out.print("5. A�adir usuarios\n");
        System.out.print("6. Ver usuarios registrados\n");
        System.out.print("7. Cerrar sesi�n\n");
        System.out.print("8. Salir\n");
        System.out.print("\nIngrese opcion: ");
    }

    public static void printMenuCrear(){
        System.out.println("�Qu� deseas hacer?\n");
        System.out.print("1. Crear un nuevo chatbot\n");
        System.out.print("2. Crear un nuevo flujo\n");
        System.out.print("3. Crear una nueva opci�n\n");
        System.out.print("4. Volver\n");
        System.out.print("\nIngrese opcion: ");
    }        

    public static void printMenu(){
        System.out.println("�Qu� deseas hacer?\n");
        System.out.print("1. Crear un nuevo chatbot\n");
        System.out.print("2. Crear un nuevo flujo\n");
        System.out.print("3. Crear una nueva opci�n\n");
        System.out.print("4. Volver\n");
        System.out.print("\nIngrese opcion: ");
    }        
    
    public static void printMenuModificar(){
        System.out.println("�Qu� deseas hacer?\n");
        System.out.print("1. Modificar un chatbot\n");
        System.out.print("2. Modificar un flujo\n");
        System.out.print("3. Modificar una opci�n\n");
        System.out.print("4. Volver\n");
        System.out.print("\nIngrese opcion: ");
    }        

    public static void printMenuAgregar(){
        System.out.println("�Qu� deseas hacer?\n");
        System.out.print("1. Agregar un chatbot\n");
        System.out.print("2. Agregar un flujo\n");
        System.out.print("3. Agregar una opci�n\n");
        System.out.print("4. Volver\n");
        System.out.print("\nIngrese opcion: ");
    }    
    
    public static void printMenuInteract(boolean isAdmin){
        System.out.println("�Qu� deseas hacer?\n");
        System.out.print("1. Iniciar una conversaci�n\n");
        System.out.print("2. Solicitar una simulaci�n\n");
        System.out.print("3. Solicitar s�ntesis de mis conversaciones\n");
        if (isAdmin){
            System.out.print("4. Volver\n");
        }else{
            System.out.print("4. Cerrar sesi�n\n");
        }
        
        System.out.print("\nIngrese opcion: ");
    }        
}
