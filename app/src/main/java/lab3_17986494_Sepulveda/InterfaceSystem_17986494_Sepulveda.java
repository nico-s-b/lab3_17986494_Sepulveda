/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lab3_17986494_Sepulveda;

import java.util.ArrayList;

/**
 * Interface de System. Contiene los métodos principales de debe implementar la clase System
 * @author nic_s
 */
public interface InterfaceSystem_17986494_Sepulveda{
    
    /**
     * Método para añadir un chatbot al sistema
     * 
     * @param chatbot chatbot que se desea añadir
     */
    void systemAddChatbot(Chatbot_17986494_Sepulveda chatbot);
    
    /**
     * Método para registrar un nuevo usuario
     * 
     * @param user nombre del nuevo usuario
     */
    void systemAddUser(String user);
    
    /**
     * Método para iniciar sesión
     * 
     * @param user nombre de usuario que desea iniciar sesión
     */
    void systemLogin(String user);
    
    /**
     * Método para verificar si un nombre de usuario existe en el sistema
     * @param user nombre a verificar
     * @return boolean
     */
    boolean userInSystem(String user);
    
    /**
     * Método para cerrar sesión.
     */
    void systemLogout();
    
    /**
     * Método para interactuar con el sistema
     * @param option String que envía el usuario
     */
    void systemTalk(String option);
    
    /**
     * Método sobrecargado para generar las interacciones simuladas del sistema
     * 
     * @param seed semilla para números aleatorios
     * @param maxInter cantidad de interacciones solicitadas
     * @param user usuario ficticio que hará las simulaciones
     */
    void systemTalk(int seed, int maxInter, String user);
    
    /**
     * Solicitar simulación de interacciones
     * 
     * @param maxInter Cantidad de interacciones deseadas
     * @param seed Semilla aleatoria
     */
    void systemSimulate(int maxInter, int seed);

    /**
     * Solicitar síntesis de historial de mensajes de usuario
     * 
     * @param user Nombre de usuario que solicita síntesis
     */
    void systemSynthesis(String user);
    
    /**
     * Añadir componente a la lista de componentes disponibles del sistema
     * 
     * @param comp Componente que se desea añadir
     */
    void addComponente(Componente_17986494_Sepulveda comp);
    
    /**
     * Obtener usuario administrador del sistema
     * 
     * @return usuario administrador
     */
    User_17986494_Sepulveda getAdmin();
    
    /**
     * Obtener un usuario del sistema según su nombre
     * 
     * @param username nombre de usuario
     * @return instancia de usuario
     */
    User_17986494_Sepulveda getUser(String username);
    
    /**
     * Método que retorna lista con TODOS los chatbots existentes en el sistema
     * 
     * @return lista de chatbots
     */
    ArrayList<Chatbot_17986494_Sepulveda> getAllChatbots();
    
    /**
     * Método que retorna lista con TODOS los flujos existentes en el sistema
     * 
     * @return lista de flujos
     */
    ArrayList<Flow_17986494_Sepulveda> getAllFlows();
    
    /**
     * Método que retorna lista con TODAS las opciones existentes en el sistema
     * 
     * @return lista de opciones
     */
    ArrayList<Option_17986494_Sepulveda> getAllOptions();
    
    /**
     * Método que retorna el chatbot actual del sistema según el chatbotCodeLink
     * 
     * @return chatbot
     */
    Chatbot_17986494_Sepulveda getActualChatbot();
    
}
