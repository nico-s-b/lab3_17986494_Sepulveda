/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_17986494_Sepulveda;

/**
 * Clase que contiene los métodos que imprimen menús por consola. Los nombres 
 * de los métodos coinciden con el del menú que los implementa (printMenuXXXX)
 * @author nic_s
 */
public class PrintingMenuFunctions_17986494_Sepulveda {

    public static void printMenuFirst() {
        System.out.println("Bienvenido al sistema de Chatbots!\n");
        System.out.print("1. Registre al usuario administrador \n");
        System.out.print("2. Probar demo del sistema \n");
        System.out.print("3. Salir\n");
    }    
    
    public static void printMenuMain(){
        System.out.println("Bienvenido al sistema de Chatbots!\n");
        System.out.print("1. Iniciar sesion\n");
        System.out.print("2. Salir\n");
    }        
    
    public static void printMenuAdmin() {
        System.out.println("¿Que desea hacer, Administrador?\n");
        System.out.print("1. Crear componentes nuevos\n");
        System.out.print("2. Modificar componentes en el sistema\n");
        System.out.print("3. Agregar componentes disponibles\n");
        System.out.print("4. Interactuar con el sistema\n");
        System.out.print("5. Registrar usuarios\n");
        System.out.print("6. Ver usuarios registrados\n");
        System.out.print("7. Cerrar sesion\n");
        System.out.print("8. Salir\n");
    }

    public static void printMenuCrear(){
        System.out.println("¿Que deseas hacer?\n");
        System.out.print("1. Crear un nuevo chatbot\n");
        System.out.print("2. Crear un nuevo flujo\n");
        System.out.print("3. Crear una nueva opcion\n");
        System.out.print("4. Volver\n");
    }        

    public static void printMenu(){
        System.out.println("¿Que deseas hacer?\n");
        System.out.print("1. Crear un nuevo chatbot\n");
        System.out.print("2. Crear un nuevo flujo\n");
        System.out.print("3. Crear una nueva opcion\n");
        System.out.print("4. Volver\n");
    }        
    
    public static void printMenuModificar(){
        System.out.println("¿Que deseas hacer?\n");
        System.out.print("1. Modificar un chatbot\n");
        System.out.print("2. Modificar un flujo\n");
        System.out.print("3. Modificar una opcion\n");
        System.out.print("4. Volver\n");
    }        

    public static void printMenuAgregar(){
        System.out.println("¿Que deseas hacer?\n");
        System.out.print("1. Agregar un chatbot\n");
        System.out.print("2. Agregar un flujo\n");
        System.out.print("3. Agregar una opcion\n");
        System.out.print("4. Volver\n");
    }    
    
    public static void printMenuInteractUser(){
        System.out.println("¿Qué deseas hacer?\n");
        System.out.print("1. Iniciar una conversacion\n");
        System.out.print("2. Solicitar una simulacion\n");
        System.out.print("3. Solicitar sintesis de mis conversaciones\n");
        System.out.print("4. Cerrar sesión\n");           
    }

    public static void printMenuInteractAdmin(){
        System.out.println("¿Que deseas hacer?\n");
        System.out.print("1. Iniciar una conversacion\n");
        System.out.print("2. Solicitar una simulacion\n");
        System.out.print("3. Solicitar sintesis de mis conversaciones\n");
        System.out.print("4. Volver\n");
    }        

    public static void printMenuModificarChatbot() {
        System.out.println("¿Que desea modificar del chatbot seleccionado?\n");
        System.out.print("1. Cambiar nombre\n");
        System.out.print("2. Cambiar mensaje de bienvenida \n");
        System.out.print("3. Cambiar Codigo de Enlace a Flujo \n");
        System.out.print("4. Eliminar flujos \n");
        System.out.print("5. Agregar flujos \n");
        System.out.print("6. Salir\n");
    }      

    public static void printMenuModificarFlow() {
        System.out.println("¿Que desea modificar del flujo seleccionado?\n");
        System.out.print("1. Cambiar nombre\n");
        System.out.print("2. Eliminar opciones \n");
        System.out.print("3. Agregar opciones \n");
        System.out.print("4. Salir\n");
    }          

    public static void printMenuModificarOption() {
        System.out.println("¿Que desea modificar de la opcion seleccionada?\n");
        System.out.print("1. Cambiar mensaje\n");
        System.out.print("2. Cambiar Codigo de Enlace a Chatbot \n");
        System.out.print("3. Cambiar Codigo de Enlace a Flujo \n");
        System.out.print("4. Agregar palabra clave \n");
        System.out.print("5. Eliminar palabra clave \n");
        System.out.print("6. Salir\n");
    }      
}
