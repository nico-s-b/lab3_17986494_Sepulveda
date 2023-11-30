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
public class System_17986494_Sepulveda {
    private String name;
    private int chatbotCodeLink;
    private String date;
    private ArrayList<Chatbot_17986494_Sepulveda> chatbots;
    private ArrayList<User_17986494_Sepulveda> users;
    private boolean logState;
    private boolean logAdmin;
    private String loggedUser;

    public System_17986494_Sepulveda(){
        this.chatbotCodeLink = 0;
        this.chatbots = new ArrayList<>();
        this.users = new ArrayList<>();
        logState = false;
        logAdmin = false;
    }
    
    public void addChatbotToSystem(Chatbot_17986494_Sepulveda chatbot){
        for (Chatbot_17986494_Sepulveda cb : this.chatbots){
            if (cb.getId() == chatbot.getId()){
                throw new IllegalArgumentException("Ya existe un chatbot con el mismo código en el sistema.");
            }
        }
        this.chatbots.add(chatbot);
    }    
    
    public void addUser(User_17986494_Sepulveda user){
        for (User_17986494_Sepulveda us : this.users){
            if (us.getUsername().equals(user.getUsername())){
                throw new IllegalArgumentException("Ya existe un usuario con el mismo nombre en el sistema.");
            }
        }
        this.users.add(user);
    }
    
    public void login(User_17986494_Sepulveda user){
        if (this.isLogState()){
            throw new IllegalStateException("Ya existe una sesión iniciada en el sistema.");
        }
        if (userInSystem(user)){
            this.setLogState(true);
            
        }else{
            throw new IllegalArgumentException("El usuario que intenta iniciar sesión no está registrado en el sistema.");
        }
    }
    
    private boolean userInSystem(User_17986494_Sepulveda user){
        for (User_17986494_Sepulveda us : this.users){
            if (us.getUsername().equals(user.getUsername())){
                return true;
            }
        }
        return false;
    }
        
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

    public ArrayList<Chatbot_17986494_Sepulveda> getChatbots() {
        return chatbots;
    }

    public void setChatbots(ArrayList<Chatbot_17986494_Sepulveda> chatbots) {
        this.chatbots = chatbots;
    }

    public ArrayList<User_17986494_Sepulveda> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User_17986494_Sepulveda> users) {
        this.users = users;
    }

    public boolean isLogState() {
        return logState;
    }

    public void setLogState(boolean logState) {
        this.logState = logState;
    }

    public boolean isLogAdmin() {
        return logAdmin;
    }

    public void setlogAdmin(boolean logAdmin) {
        this.logAdmin = logAdmin;
    }    
    
    public String getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(String loggedUser) {
        this.loggedUser = loggedUser;
    }
    
    
}
