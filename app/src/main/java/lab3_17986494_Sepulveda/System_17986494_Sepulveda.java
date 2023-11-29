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
public class System_17986494_Sepulveda {
    private String name;
    private int chatbotCodeLink;
    private String date;
    private List<Chatbot_17986494_Sepulveda> chatbots;
    private List<User_17986494_Sepulveda> users;
    private boolean logState;
    private String loggedUser;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChatbotCodeLink() {
        return chatbotCodeLink;
    }

    public void setChatbotCodeLink(int chatbotCodeLink) {
        this.chatbotCodeLink = chatbotCodeLink;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Chatbot_17986494_Sepulveda> getChatbots() {
        return chatbots;
    }

    public void setChatbots(List<Chatbot_17986494_Sepulveda> chatbots) {
        this.chatbots = chatbots;
    }

    public List<User_17986494_Sepulveda> getUsers() {
        return users;
    }

    public void setUsers(List<User_17986494_Sepulveda> users) {
        this.users = users;
    }

    public boolean isLogState() {
        return logState;
    }

    public void setLogState(boolean logState) {
        this.logState = logState;
    }

    public String getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(String loggedUser) {
        this.loggedUser = loggedUser;
    }
    
    
}
