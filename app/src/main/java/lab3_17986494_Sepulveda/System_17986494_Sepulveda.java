/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_17986494_Sepulveda;

import java.util.ArrayList;
import java.util.Random;

/**
 *Clase para Sistema. Contiene el conjunto de chatbots asociados a un sistema, 
 * con los m�todos necesarios para interactuar con ellos y para gestionar usuarios.
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
    private ArrayList<Componente_17986494_Sepulveda> waitingComponents;

    public System_17986494_Sepulveda(){
        this.chatbotCodeLink = 0;
        this.chatbots = new ArrayList<>();
        this.users = new ArrayList<>();
        this.logState = false;
        this.logAdmin = false;
        this.loggedUser ="";
        this.waitingComponents = new ArrayList<>();
    }

/**
 * M�todo que a�ade un chatbot a un sistema, evitando a�adir chatbots duplicados
 * de acuerdo al Id de estas. Llama al m�todo {@link Componente_17986494_Sepulveda#addComponent(java.util.ArrayList, lab3_17986494_Sepulveda.Componente_17986494_Sepulveda)}
 * para realizar la acci�n. Captura el error lanzado por dicho m�todo.
 * @author nic_s
 * 
 * @param chatbot
 */
    public void addChatbotToSystem(Chatbot_17986494_Sepulveda chatbot){
        try{
            Componente_17986494_Sepulveda.addComponent(this.getChatbots(), chatbot);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
/**
 * M�todo para registrar usuarios nuevos al sistema.Recibe un nombre de usuario 
 * y si �ste tendr� o no privilegios de administrador.Crea un nuevo usuario
 * y lo a�ade al sistema utilizando el m�todo {@link #addUser(lab3_17986494_Sepulveda.User_17986494_Sepulveda)}
 * @author nic_s
 * 
 * @param username
 * @param isAdmin
 */    
    public void registerUser(String username, boolean isAdmin){
        User_17986494_Sepulveda user;
        if (isAdmin){
            user = new AdminUser_17986494_Sepulveda(username);
        }else{
            user = new NormalUser_17986494_Sepulveda(username);
        }
        this.addUser(user);
    }
     
    private void addUser(User_17986494_Sepulveda user){
        for (User_17986494_Sepulveda us : this.getUsers()){
            if (us.getUsername().equals(user.getUsername())){
                throw new IllegalArgumentException("Ya existe un usuario con el mismo nombre en el sistema.");
            }
        }
        this.getUsers().add(user);
    }

/**
 * M�todo para iniciar sesi�n. Recibe un usuario como par�metro y verifica si
 * es o no posible para este usuario iniciar la sesi�n.
 * @throws IllegalStateException si se intenta iniciar sesi�n cuando ya hay una iniciada
 * @throws IllegalArgumentException si el usuario que intenta iniciar sesi�n no 
 * est� registrado en el sistema
 * 
 * @param user
 */
    public void login(User_17986494_Sepulveda user){
        if (this.isLogState()){
            throw new IllegalStateException("Ya existe una sesi�n iniciada en el sistema.");
        }
        if (userInSystem(user)){
            this.setLogState(true);
            this.setLoggedUser(user.getUsername());
            if (user.isAdmin()){
                this.setLogAdmin(true);
            }
            
        }else{
            throw new IllegalArgumentException("El usuario que intenta iniciar sesi�n no est� registrado en el sistema.");
        }
    }
    
    private boolean userInSystem(User_17986494_Sepulveda user){
        for (User_17986494_Sepulveda us : this.getUsers()){
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
            throw new IllegalStateException("No hay sesi�n iniciada en el sistema.");
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

    public User_17986494_Sepulveda getAdmin(){
        for (User_17986494_Sepulveda us : this.getUsers()){
            if (us.isAdmin()){
                return us;
            }
        }
        return null;
    }
    
    public User_17986494_Sepulveda getUser(String username){
        for (User_17986494_Sepulveda us : this.getUsers()){
            if (us.getUsername().equals(username) ){
                return us;
            }
        }
        return null;
    }
    
    public void registeredUsers(){
        for (User_17986494_Sepulveda us : this.getUsers()){
            System.out.print(us);
            System.out.print("\n");
        }
    }

    public void addComponente(Componente_17986494_Sepulveda comp){
        this.waitingComponents.add(comp);
    }
    
    //Getters & Setters
    
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

    public ArrayList<Chatbot_17986494_Sepulveda> getChatbots() {
        return chatbots;
    }

    public ArrayList<User_17986494_Sepulveda> getUsers() {
        return users;
    }

    public ArrayList<Componente_17986494_Sepulveda> getComponentes() {
        return waitingComponents;
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
