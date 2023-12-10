/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lab3_17986494_Sepulveda;

/**
 *Interface de chatbot. Contiene los métodos principales de la clase
 * @author nic_s
 */
public interface InterfaceChatbot_17986494_Sepulveda {
    
    /**
     * Método para añadir un flujo al sistema
     * 
     * @param flow flujo que se desea añadir
     */
    void chatbotAddFlow(Flow_17986494_Sepulveda flow);
    
    /**
     * Construye un String del chatbot y opciones del flujo actual
     * 
     * @return string para imprimir chatbot
     */
    String toPrint();
    
    /**
     * Obtener el flujo actual cargado en el flujo
     * 
     * @return flujo actual del chatbot
     */
    Flow_17986494_Sepulveda getActualFlow();
    
}
