/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_17986494_Sepulveda;

import java.util.ArrayList;
import java.util.Random;
import lab3_17986494_Sepulveda.NormalUser_17986494_Sepulveda;

/**
 *Clase para Sistema. Contiene el conjunto de chatbots asociados a un sistema, con los métodos necesarios para interactuar con ellos y para gestionar usuarios.
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
        this.logState = false;
        this.logAdmin = false;
        this.loggedUser ="";
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

/**
 * Método para iniciar sesión.
 * @throws IllegalStateException si se intenta iniciar sesión cuando ya hay una iniciada
 * @throws IllegalArgumentException si el usuario que intenta iniciar sesión no está registrado en el sistema
 * @param user usuario que intenta iniciar sesión
 */
    
    public void login(User_17986494_Sepulveda user){
        if (this.isLogState()){
            throw new IllegalStateException("Ya existe una sesión iniciada en el sistema.");
        }
        if (userInSystem(user)){
            this.setLogState(true);
            this.setLoggedUser(user.getUsername());
            
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
       
    public void logout(){
        if (this.isLogState()){
            this.setLogState(false);
            this.setLogAdmin(false);
            this.setLoggedUser("");
        }else{
            throw new IllegalStateException("No hay sesión iniciada en el sistema.");
        }
    }
    
    public String simulate(int maxInter, int seed){
        String fakeUser = "user" + Integer.toString(seed);
        NormalUser_17986494_Sepulveda user = new NormalUser_17986494_Sepulveda(fakeUser);
        this.addUser(user);
        Random random = new Random(seed);
        return fakeUser;
    }
     
    public String synthesis(User_17986494_Sepulveda user){
        return user.getUsername();
    }
    
    public String getName() {
        return name;
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

    public ArrayList<User_17986494_Sepulveda> getUsers() {
        return users;
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

    public void setLogAdmin(boolean logAdmin) {
        this.logAdmin = logAdmin;
    }    
    
    public String getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(String loggedUser) {
        this.loggedUser = loggedUser;
    }
    
}
