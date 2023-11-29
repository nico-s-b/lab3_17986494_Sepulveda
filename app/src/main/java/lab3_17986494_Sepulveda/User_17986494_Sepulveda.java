/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_17986494_Sepulveda;

import java.util.List;

/**
 *
 * @author nic_s
 */
public class User_17986494_Sepulveda {
    private String username;
    private List<Message_17986494_Sepulveda> chatHistory;
    
    private void addMessage(Message_17986494_Sepulveda mens){
        this.chatHistory.add(mens);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Message_17986494_Sepulveda> getChatHistory() {
        return chatHistory;
    }

    public void setChatHistory(List<Message_17986494_Sepulveda> chatHistory) {
        this.chatHistory = chatHistory;
    }
    
    
}
