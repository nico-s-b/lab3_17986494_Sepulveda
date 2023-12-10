/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lab3_17986494_Sepulveda;

import java.util.ArrayList;

/**
 * Interface de System. Contiene los m�todos principales de debe implementar la clase System
 * @author nic_s
 */
public interface InterfaceSystem_17986494_Sepulveda{
    
    /**
     * M�todo para a�adir un chatbot al sistema
     * 
     * @param chatbot chatbot que se desea a�adir
     */
    void systemAddChatbot(Chatbot_17986494_Sepulveda chatbot);
    
    /**
     * M�todo para registrar un nuevo usuario
     * 
     * @param user nombre del nuevo usuario
     */
    void systemAddUser(String user);
    
    /**
     * M�todo para iniciar sesi�n
     * 
     * @param user nombre de usuario que desea iniciar sesi�n
     */
    void systemLogin(String user);
    
    /**
     * M�todo para verificar si un nombre de usuario existe en el sistema
     * @param user nombre a verificar
     * @return boolean
     */
    boolean userInSystem(String user);
    
    /**
     * M�todo para cerrar sesi�n.
     */
    void systemLogout();
    
    /**
     * M�todo para interactuar con el sistema
     * @param option String que env�a el usuario
     */
    void systemTalk(String option);
    
    /**
     * M�todo sobrecargado para generar las interacciones simuladas del sistema
     * 
     * @param seed semilla para n�meros aleatorios
     * @param maxInter cantidad de interacciones solicitadas
     * @param user usuario ficticio que har� las simulaciones
     */
    void systemTalk(int seed, int maxInter, String user);
    
    /**
     * Solicitar simulaci�n de interacciones
     * 
     * @param maxInter Cantidad de interacciones deseadas
     * @param seed Semilla aleatoria
     */
    void systemSimulate(int maxInter, int seed);

    /**
     * Solicitar s�ntesis de historial de mensajes de usuario
     * 
     * @param user Nombre de usuario que solicita s�ntesis
     */
    void systemSynthesis(String user);
    
    /**
     * A�adir componente a la lista de componentes disponibles del sistema
     * 
     * @param comp Componente que se desea a�adir
     */
    void addComponente(Componente_17986494_Sepulveda comp);
    
    /**
     * Obtener usuario administrador del sistema
     * 
     * @return usuario administrador
     */
    User_17986494_Sepulveda getAdmin();
    
    /**
     * Obtener un usuario del sistema seg�n su nombre
     * 
     * @param username nombre de usuario
     * @return instancia de usuario
     */
    User_17986494_Sepulveda getUser(String username);
    
    /**
     * M�todo que retorna lista con TODOS los chatbots existentes en el sistema
     * 
     * @return lista de chatbots
     */
    ArrayList<Chatbot_17986494_Sepulveda> getAllChatbots();
    
    /**
     * M�todo que retorna lista con TODOS los flujos existentes en el sistema
     * 
     * @return lista de flujos
     */
    ArrayList<Flow_17986494_Sepulveda> getAllFlows();
    
    /**
     * M�todo que retorna lista con TODAS las opciones existentes en el sistema
     * 
     * @return lista de opciones
     */
    ArrayList<Option_17986494_Sepulveda> getAllOptions();
    
    /**
     * M�todo que retorna el chatbot actual del sistema seg�n el chatbotCodeLink
     * 
     * @return chatbot
     */
    Chatbot_17986494_Sepulveda getActualChatbot();
    
}
