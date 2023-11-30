/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_17986494_Sepulveda;

import java.util.ArrayList;


/**
 *
 * @author nic_s
 */
public class User_17986494_Sepulveda {
    private String username;
    private ArrayList<Message_17986494_Sepulveda> chatHistory;
    
    
    public User_17986494_Sepulveda(){}
    
    public void userLogin(System_17986494_Sepulveda system){
        system.login(this);
    }
    
    private void addMessage(Message_17986494_Sepulveda mens){
        this.chatHistory.add(mens);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<Message_17986494_Sepulveda> getChatHistory() {
        return chatHistory;
    }

    public void setChatHistory(ArrayList<Message_17986494_Sepulveda> chatHistory) {
        this.chatHistory = chatHistory;
    }
    
    
}
