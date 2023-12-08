/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_17986494_Sepulveda;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 *Clase para Sistema. Contiene el conjunto de chatbots asociados a un sistema, 
 * con los métodos necesarios para interactuar con ellos y para gestionar usuarios.
 * @author nic_s
 */
public class System_17986494_Sepulveda {
    private String name;
    private int chatbotCodeLink;
    private ArrayList<Chatbot_17986494_Sepulveda> chatbots;
    private ArrayList<User_17986494_Sepulveda> users;
    private boolean logState;
    private boolean logAdmin;
    private String loggedUser;
    private ArrayList<Componente_17986494_Sepulveda> componentesDisponibles;
    private Date fechaCreacion;

    public System_17986494_Sepulveda(){
        this.chatbotCodeLink = 0;
        this.chatbots = new ArrayList<>();
        this.users = new ArrayList<>();
        this.logState = false;
        this.logAdmin = false;
        this.loggedUser = "";
        this.componentesDisponibles = new ArrayList<>();
        this.fechaCreacion = new Date();
    }
    
    public System_17986494_Sepulveda(String name, int chatbotCodeLink, ArrayList<Chatbot_17986494_Sepulveda> chatbots){
        this.name = name;
        this.chatbotCodeLink = chatbotCodeLink;
        this.chatbots = Componente_17986494_Sepulveda.remDuplicates(chatbots);
        this.users = new ArrayList<>();
        this.logState = false;
        this.logAdmin = false;
        this.loggedUser = "";
        this.componentesDisponibles = new ArrayList<>();
        this.fechaCreacion = new Date();  
    }

/**
 * Método que añade un chatbot a un sistema, evitando añadir chatbots duplicados
 * de acuerdo al Id de estas. Llama al método {@link Componente_17986494_Sepulveda#addComponent(java.util.ArrayList, lab3_17986494_Sepulveda.Componente_17986494_Sepulveda)}
 * para realizar la acción. Captura el error lanzado por dicho método.
 * @author nic_s
 * 
 * @param chatbot
 */
    public void systemAddChatbot(Chatbot_17986494_Sepulveda chatbot){
        try{
            Componente_17986494_Sepulveda.addComponent(this.getChatbots(), chatbot);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
/**
 * Método para registrar usuarios nuevos al sistema.Recibe un nombre de usuario 
 * y si éste tendrá o no privilegios de administrador.Crea un nuevo usuario
 * y lo añade al sistema utilizando el método {@link #systemAddUser(lab3_17986494_Sepulveda.User_17986494_Sepulveda)}
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
        this.systemAddUser(user);
    }
     
    private void systemAddUser(User_17986494_Sepulveda user){
        for (User_17986494_Sepulveda us : this.getUsers()){
            if (us.getUsername().equals(user.getUsername())){
                throw new IllegalArgumentException("Ya existe un usuario con el mismo nombre en el sistema.");
            }
        }
        this.getUsers().add(user);
    }

/**
 * Método para iniciar sesión. Recibe un usuario como parámetro y verifica si
 * es o no posible para este usuario iniciar la sesión.
 * @throws IllegalStateException si se intenta iniciar sesión cuando ya hay una iniciada
 * @throws IllegalArgumentException si el usuario que intenta iniciar sesión no 
 * está registrado en el sistema
 * 
 * @param user
 */
    public void systemLogin(User_17986494_Sepulveda user){
        if (this.isLogState()){
            throw new IllegalStateException("Ya existe una sesión iniciada en el sistema.");
        }
        if (userInSystem(user)){
            this.setLogState(true);
            this.setLoggedUser(user.getUsername());
            if (user.isAdmin()){
                this.setLogAdmin(true);
            }
            
        }else{
            throw new IllegalArgumentException("El usuario que intenta iniciar sesión no está registrado en el sistema.");
        }
    }
    
/**
 * Método que busca si un usuario dado está o no registrado en el sistema
 * 
 * @param username
 * @return boolean 
 */    
    private boolean userInSystem(User_17986494_Sepulveda user){
        for (User_17986494_Sepulveda us : this.getUsers()){
            if (us.getUsername().equals(user.getUsername())){
                return true;
            }
        }
        return false;
    }

/**
 * Método para cerrar sesión, cambiando todos los parámetros necesarios del sistema
 * @throws IllegalStateException si no hay una sesión iniciada 
 */        
    public void systemLogout(){
        if (this.isLogState()){
            this.setLogState(false);
            this.setLogAdmin(false);
            this.setLoggedUser("");
        }else{
            throw new IllegalStateException("No hay sesión iniciada en el sistema.");
        }
    }
    

    public void systemInteraction(){
        if(!this.isLogState()){
            System.out.print("Sesión no iniciada, no es posible interactuar");
            return;
        }    
        
        boolean continueInteraction = true; 
        
        while(continueInteraction){
            System.out.print(this.getActualChatbot().toPrint());
            System.out.print("Ingrese opcion: ");
            
            try (Scanner input = new Scanner(System.in)) {
                String option = input.nextLine();
                if (option.toLowerCase().equals("exit")) {
                    continueInteraction = false;
                }else{
                    this.systemTalk(option);
                }
            }           
        }
    }
    
    private void systemTalk(String mensaje){
        boolean opcionReconocida = false;
        for (Option_17986494_Sepulveda option: this.getActualFlow().getOptions()){
            if (option.optionMatch(mensaje)){
                this.setChatbotCodeLink(option.getChatbotCodeLink());
                for (Chatbot_17986494_Sepulveda cb: this.getChatbots()){
                    if (cb.getId() == option.getChatbotCodeLink()){
                        cb.setStartFlowId(option.getFlowCodeLink());
                        this.systemInteraction();
                    }
                }
                opcionReconocida = true;
                break;
            }
        }
        if (!opcionReconocida) {
            System.out.println("Opción no reconocida.");
            this.systemInteraction();
        }       
    }
    
    public String systemSimulate(int maxInter, int seed){
        String fakeUser = "user" + Integer.toString(seed);
        NormalUser_17986494_Sepulveda user = new NormalUser_17986494_Sepulveda(fakeUser);
        this.systemAddUser(user);
        Random random = new Random(seed);
        return fakeUser;
    }
     
    public String systemSynthesis(User_17986494_Sepulveda user){
        return user.getUsername();
    }

/**
 * Método para mostrar un listado de todos los usuarios registrados en el sistema
 */        
    public void registeredUsers(){
        for (User_17986494_Sepulveda us : this.getUsers()){
            System.out.print(us);
            System.out.print("\n");
        }
    }

/**
 * Método que agrega un componente (chatbot, flujo, opcion) a la lista de componentes
 * disponibles para uso del sistema.
 * 
 * @param comp
 */        
    public void addComponente(Componente_17986494_Sepulveda comp){
        this.componentesDisponibles.add(comp);
    }

    //Specific getters
/**
 * Devuelve el usuario administrador del sistema
 * 
 * @return user 
 */    
    public User_17986494_Sepulveda getAdmin(){
        for (User_17986494_Sepulveda us : this.getUsers()){
            if (us.isAdmin()){
                return us;
            }
        }
        return null;
    }

/**
 * Devuelve un usuario del sistema de acuerdo al nombre
 * 
 * @param username
 * @return user 
 */        
    public User_17986494_Sepulveda getUser(String username){
        for (User_17986494_Sepulveda us : this.getUsers()){
            if (us.getUsername().equals(username) ){
                return us;
            }
        }
        return null;
    }

/**
 * Método que entrega una lista de TODOS los chatbots en el sistema, tanto
 * los que están cargados en él como los que se encuentran en el listado de
 * componentes disponibles
 * 
 * @return listado de chatbots 
 */        
    public ArrayList<Chatbot_17986494_Sepulveda> getAllChatbots(){
        ArrayList<Chatbot_17986494_Sepulveda> list = new ArrayList<>();
        for (Chatbot_17986494_Sepulveda cb: this.getChatbots()){
            list.add(cb);
        }
        for (Componente_17986494_Sepulveda comp: this.getComponentes()){
            if (comp instanceof Chatbot_17986494_Sepulveda){
                list.add((Chatbot_17986494_Sepulveda) comp);
            }
        }
        return list;
    }

/**
 * Método que entrega una lista de TODOS los flujos en el sistema, tanto
 * los que están cargados en cada chatbot cargado en el sistema como los que 
 * se encuentran en el listado de componentes disponibles
 * 
 * @return listado de flujos
 */      
    public ArrayList<Flow_17986494_Sepulveda> getAllFlows(){
        ArrayList<Flow_17986494_Sepulveda> list = new ArrayList<>();
        for (Chatbot_17986494_Sepulveda cb: this.getChatbots()){
            for(Flow_17986494_Sepulveda fl: cb.getFlows()){
                list.add(fl);
            }
        }
        for (Componente_17986494_Sepulveda comp: this.getComponentes()){
            if (comp instanceof Flow_17986494_Sepulveda){
                list.add((Flow_17986494_Sepulveda) comp);
            }
        }
        return list;
    }

/**
 * Método que entrega una lista de TODAS las opciones en el sistema, tanto
 * las que están añadidas en cada flujo de cada chatbot cargado en el sistema 
 * como las que se encuentran en el listado de componentes disponibles
 * 
 * @return listado de opciones
 */         
    public ArrayList<Option_17986494_Sepulveda> getAllOptions(){
        ArrayList<Option_17986494_Sepulveda> list = new ArrayList<>();
        for (Chatbot_17986494_Sepulveda cb: this.getChatbots()){
            for(Flow_17986494_Sepulveda fl: cb.getFlows()){
                for(Option_17986494_Sepulveda op: fl.getOptions()){
                    list.add(op);
                }
            }
        }
        for (Componente_17986494_Sepulveda comp: this.getComponentes()){
            if (comp instanceof Option_17986494_Sepulveda){
                list.add((Option_17986494_Sepulveda) comp);
            }
        }
        return list;
    }
    
    private Chatbot_17986494_Sepulveda getActualChatbot(){
        for (Chatbot_17986494_Sepulveda cb: this.getChatbots()){
            if (cb.getId() == this.getChatbotCodeLink()){
                return cb;
            }
        }
        return null;
    }
    
    private Flow_17986494_Sepulveda getActualFlow(){
        Chatbot_17986494_Sepulveda cb = this.getActualChatbot();
        for (Flow_17986494_Sepulveda fl: cb.getFlows()){
            if (fl.getId() == cb.getStartFlowId()){
                return fl;
            }
        }
        return null;
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

   public ArrayList<Chatbot_17986494_Sepulveda> getChatbots() {
        return chatbots;
    }

    public ArrayList<User_17986494_Sepulveda> getUsers() {
        return users;
    }

    public ArrayList<Componente_17986494_Sepulveda> getComponentes() {
        return componentesDisponibles;
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
