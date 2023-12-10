/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_17986494_Sepulveda;

import java.util.ArrayList;

/**
 * Clase abstracta de usuario general. Contiene los atributos y métodos comunes a
 * los distintos dipos de usuario que puede haber en el sistema
 * @author nic_s
 */
public abstract class User_17986494_Sepulveda {
    private final String username;
    private ArrayList<Message_17986494_Sepulveda> chatHistory;
    
    User_17986494_Sepulveda(String username){
        this.username = username;
        this.chatHistory = new ArrayList<>();
    }

    @Override
    public String toString() {
        return this.getUsername();
    }
     
    /**
     *Método que añade un nuevo mensaje al chatHistory del usuario.
     * 
     * @param mens mensaje del usuario
     */
    public void addMessage(Message_17986494_Sepulveda mens){
        this.chatHistory.add(mens);
    }

    /**
     *Método que construye la síntesis de mensajes del usuario a partir de lo
     * almacenado en el chatHistory de éste. Entrega la síntesis como un String
     * 
     * @return String con la síntesis de mensajes
     */
    public String generateSynthesis(){
        if (this.getChatHistory().isEmpty()){
            return "Usuario no tiene mensajes guardados";
        }
        String synthesis = "";
        for (Message_17986494_Sepulveda mens: this.getChatHistory()){
            synthesis = synthesis + mens.toString() + "\n";
        }
        return synthesis;
    }
    
    public String getUsername() {
        return username;
    }

    public ArrayList<Message_17986494_Sepulveda> getChatHistory() {
        return chatHistory;
    }
    
}
