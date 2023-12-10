/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_17986494_Sepulveda;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 *Clase para Sistema. Contiene el conjunto de chatbots asociados a un sistema, 
 * con los métodos necesarios para interactuar con ellos y para gestionar usuarios.
 * @author nic_s
 */
public class System_17986494_Sepulveda implements InterfaceSystem_17986494_Sepulveda{
    private String name;
    private int chatbotCodeLink;
    private ArrayList<Chatbot_17986494_Sepulveda> chatbots;
    private ArrayList<User_17986494_Sepulveda> users;   //Listado de usuarios registrados
    private boolean logState;       //Señala si hay un usuario actualmente loggeado
    private User_17986494_Sepulveda loggedUser;      //Nombre del usuario actualmente loggeado en sistema
    private ArrayList<Componente_17986494_Sepulveda> componentesDisponibles;    //Componentes creados pero que no se han añadido al sistema
    private Componente_17986494_Sepulveda componenteTemporal;   //Componente temporal: usado como variable para guardar componente que se desee modificar
    private Date fechaCreacion;     //Fecha de gración del sistema
    private Date interactDate;

    /**
     *Constructor de System por defecto. Entrega un sistema en blanco sin sesion
     * iniciada y con fecha de creación. El chatbotCodeLink es seteado en 0.
     */
    public System_17986494_Sepulveda(){
        this.name = "ChatbotSystem";
        this.chatbotCodeLink = 0;
        this.chatbots = new ArrayList<>();
        this.users = new ArrayList<>();
        this.logState = false;
        this.loggedUser = null;
        this.componentesDisponibles = new ArrayList<>();
        this.fechaCreacion = new Date();
        this.componenteTemporal = null;
    }

    /**
     *Constructor de System inicializado. Permite construir un sistema con atributos
     * de nombre, código de chatbot y listado de chatbots dados.
     * @param name Nombre del sistema
     * @param chatbotCodeLink Código de inicialización de chatbot
     * @param chatbots Listado de chatbots del sistema
     */
    public System_17986494_Sepulveda(String name, int chatbotCodeLink, ArrayList<Chatbot_17986494_Sepulveda> chatbots){
        this.name = name;
        this.chatbotCodeLink = chatbotCodeLink;
        //Método para remover duplicados
        this.chatbots = Componente_17986494_Sepulveda.remDuplicates(chatbots);
        this.users = new ArrayList<>();
        this.logState = false;
        this.componentesDisponibles = new ArrayList<>();
        this.fechaCreacion = new Date();  
    }

    /**
     * Método que añade un chatbot a un sistema, evitando añadir chatbots duplicados
     * de acuerdo al Id de estas. Llama al método {@link Componente_17986494_Sepulveda#addComponent(java.util.ArrayList, lab3_17986494_Sepulveda.Componente_17986494_Sepulveda)}
     * para realizar la acción. Captura el error lanzado por dicho método.
     * 
     * @param chatbot chatbot que se desea añadir
     */
    @Override
    public void systemAddChatbot(Chatbot_17986494_Sepulveda chatbot){
        try{
            Componente_17986494_Sepulveda.addComponent(this.getChatbots(), chatbot);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Método para registrar usuarios nuevos al sistema. Recibe un nombre de usuario 
     * y verifica si el nombre de usuario ya existe en el sistema. Crea un nuevo 
     * usuario y lo añade al sistema en caso de poder registrarse el nuevo usuario.
     * 
     * @param user nombre del nuevo usuario
     */
    @Override
    public void systemAddUser(String user){
        for (User_17986494_Sepulveda us : this.getUsers()){
            if (us.getUsername().equals(user)){
                throw new IllegalArgumentException("Ya existe un usuario con el mismo nombre en el sistema.");
            }
        }
        NormalUser_17986494_Sepulveda newUser = new NormalUser_17986494_Sepulveda(user);
        this.getUsers().add(newUser);
    }

    /**
     * Método para iniciar sesión. Recibe un usuario como parámetro y verifica si
     * es o no posible para este usuario iniciar la sesión.
     * @throws IllegalStateException si se intenta iniciar sesión cuando ya hay una iniciada
     * @throws IllegalArgumentException si el usuario que intenta iniciar sesión no 
     * está registrado en el sistema
     * 
     * @param user instancia de usuario que desea iniciar sesión
     */
    @Override
    public void systemLogin(String user){
        if (this.isLogState()){
            throw new IllegalStateException("Ya existe una sesion iniciada en el sistema.");
        }
        if (userInSystem(user)){
            this.setLogState(true);
            this.setLoggedUser(this.getUser(user));
        }else{
            throw new IllegalArgumentException("El usuario que intenta iniciar sesión no esta registrado en el sistema.");
        }
    }
    
    /**
     * Método que busca si un usuario dado está o no registrado en el sistema
     * 
     * @param user nombre del usuario a buscar
     * @return boolean 
     */    
    @Override
    public boolean userInSystem(String user){
        for (User_17986494_Sepulveda us : this.getUsers()){
            if (us.getUsername().equals(user)){
                return true;
            }
        }
        return false;
    }

    /**
     * Método para cerrar sesión, cambiando todos los parámetros necesarios del sistema
     * @throws IllegalStateException si no hay una sesión iniciada 
     */
    @Override
    public void systemLogout(){
        if (this.isLogState()){
            this.setLogState(false);
            this.setLoggedUser(null);
            this.setChatbotCodeLink(0);
        }else{
            throw new IllegalStateException("No hay sesion iniciada en el sistema.");
        }
    }

    /**
     * Método que ejecuta una conversación con los chatbots disponible en el sistema.
    Requiere una sesión inciada para iniciar la conversación. Construye en cada
    interacción un mensaje que será añadido al historial del usuario.
    En cada interacción, actualiza los códigos de chatbot y flow según la opción
    del usuario o le pregunta de nuevo en caso de entrada no válida. Permite
    terminar la interacción completamente con la palabra clave "exit"
     * 
     * @param option String con entrada de usuario
     */    
    @Override
    public void systemTalk(String option){          
        Date userDate = new Date();     //Fecha de la respuesta
        //Construcción de mensaje
        Message_17986494_Sepulveda newMens = new Message_17986494_Sepulveda(this.getInteractDate(), userDate, this.getActualChatbot().toPrint(), option, this.getLoggedUser().getUsername());
        this.getLoggedUser().addMessage(newMens);
        boolean opcionReconocida = false;
        for (Option_17986494_Sepulveda op: this.getActualChatbot().getActualFlow().getOptions()){
            if (op.optionMatch(option)){
                this.setChatbotCodeLink(op.getChatbotCodeLink());
                for (Chatbot_17986494_Sepulveda cb: this.getChatbots()){
                    if (cb.getId() == op.getChatbotCodeLink()){
                        cb.setStartFlowId(op.getFlowCodeLink());
                    }
                }
                opcionReconocida = true;
                break;
            }
        }
        if (!opcionReconocida) {
            System.out.println("Opcion no reconocida. Intente otra vez");
        }
    }

    /**
     * Sobrecarga del método systemTalk que maneja el caso de una simulación del 
     sistema.Se activa si es solicitada desde systemTalk.No verifica inicio de sesión pues
     trabaja con un usuario ficticio creado por systemSimulate.Emplea la misma lógica
     que systemTalk para interacción humana, estando la diferencia en que genera
     las opciones a partir de una semilla aleatoria, utilizando el método random.nextInt(bound)
     para generar opciones aleatorias entre 1 y la cantidad de opciones del flujo
     actual, de manera de generar interacciones válidas.
     Generará maxInter interacciones en total, todas ellas en principio válidas si
     el sistema de chatbots está bien definido.
    * 
    * @param seed semilla aleatoria para generar opciones aleatorias
    * @param maxInter cantidad de interacciones solicitadas
    * @param user usuario ficticio creado por {@link #systemSimulate(int, int) }
     */     
    @Override
    public void systemTalk(int seed, int maxInter, String user){
        this.setChatbotCodeLink(0); //Devolver chatbot del sistema a 0
        Random random = new Random(seed);       //Random a partir de semilla
        for(int i = 0; i < maxInter; i++){
            Date systemDate = new Date();
            String menu;
            try{
                menu = this.getActualChatbot().toPrint();
            }catch (NullPointerException e) {
                System.out.println("\nNo hay chatbots en el sistema! No se puede interactuar.");
                return;
            }
            System.out.print(menu);
            System.out.print("user '" + user + "' dice: ");

            //se generan valores aleatorios entre 1 y el número de opciones del flow
            int opt = random.nextInt(this.getActualChatbot().getActualFlow().getOptions().size()) + 1;
            String option = Integer.toString(opt);
            System.out.print(option + "\n");
            System.out.print("\n");
            Date userDate = new Date();
            Message_17986494_Sepulveda newMens = new Message_17986494_Sepulveda(systemDate, userDate, menu, option, user);
            this.getUser(user).addMessage(newMens);
            boolean opcionReconocida = false;
            for (Option_17986494_Sepulveda op: this.getActualChatbot().getActualFlow().getOptions()){
                if (op.optionMatch(option)){
                    this.setChatbotCodeLink(op.getChatbotCodeLink());
                    for (Chatbot_17986494_Sepulveda cb: this.getChatbots()){
                        if (cb.getId() == op.getChatbotCodeLink()){
                            cb.setStartFlowId(op.getFlowCodeLink());
                        }
                    }
                    opcionReconocida = true;
                    break;
                }
            }
            if (!opcionReconocida) {
                System.out.println("Opcion no reconocida. Intente otra vez");
            }
        }
        this.setChatbotCodeLink(0); //Devolver chatbot del sistema a 0
    }    
    
    /**
     *Método para solicitar una simulación de una simulación de interacciones con
     * el sistema de chatbots. Crea un usuario ficticio que será empleado para
     * realizar la simulación. Este usuario quedará añadido en el sistema, con su
     * correspondiente historial de conversación. Llama a método sobrecargado de
     * {@link #systemTalk(int, int, String) }
     * 
     * @param maxInter cantidad de interacciones solicitadas
     * @param seed semilla para generar opciones aleatorias
     */
    @Override
    public void systemSimulate(int maxInter, int seed){
        String fakeUser = "user" + Integer.toString(seed);
        try{
            this.systemAddUser(fakeUser);
        }catch (IllegalArgumentException e){ } //Do nothing
        systemTalk(seed, maxInter, fakeUser);
    }

    /**
     *Función que hace imprime la síntesis del historial de conversaciones de un
     * usuario. La lógica de la generación del mensaje se encuentra en el método
     * de la clase usuario para manejar su propio historia de mensajes. 
     * Ver {@link User_17986494_Sepulveda#generateSynthesis() }
     * 
     * @param user nombre del usuario que desea la síntesis
     */
    @Override
    public void systemSynthesis(String user){
        System.out.println(this.getUser(user).generateSynthesis());
    }
    
    /**
     * Método que agrega un componente (chatbot, flujo, opcion) a la lista de componentes
     * disponibles para uso del sistema.
     * 
     * @param comp componente que se desea añadir
     */
    @Override
    public void addComponente(Componente_17986494_Sepulveda comp){
        this.componentesDisponibles.add(comp);
    }

    //Specific getters
    /**
     * Devuelve la instancia del usuario administrador del sistema
     * 
     * @return user Instancia del usuario administrador encontrada
     */    
    @Override
    public User_17986494_Sepulveda getAdmin(){
        for (User_17986494_Sepulveda us : this.getUsers()){
            if (us instanceof AdminUser_17986494_Sepulveda){
                return us;
            }
        }
        return null;
    }

    /**
     * Devuelve un usuario del sistema de acuerdo al nombre. Returna null en caso
     * de no existir el usuario deseado
     * 
     * @param username String con el nombre del usuario buscado.
     * @return user Instancia de usuario encontrada
     */        
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    
    /**
     * Método para obtener el chatbot cargado en el sistema. Utiliza el atributo
     * {@link System_17986494_Sepulveda#chatbotCodeLink} para ubicar el chatbot
     * que se encuentra disponible en el sistema actualmente.
     * 
     * @return instancia de chatbot
     */  
    @Override
    public Chatbot_17986494_Sepulveda getActualChatbot(){
        for (Chatbot_17986494_Sepulveda cb: this.getChatbots()){
            if (cb.getId() == this.getChatbotCodeLink()){
                return cb;
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
   
    public Date getInteractDate() {
        return interactDate;
    }

    public void setInteractDate(Date interactDate) {
        this.interactDate = interactDate;
    }
    
    public ArrayList<User_17986494_Sepulveda> getUsers() {
        return users;
    }

    public ArrayList<Componente_17986494_Sepulveda> getComponentes() {
        return componentesDisponibles;
    }

     /**
     * Método para consultar si existe una sesión iniciada en el sistema
     * 
     * @return boolean
     */    
    public boolean isLogState() {
        return logState;
    }

    public void setLogState(boolean logState) {
        this.logState = logState;
    }

     /**
     * Retorna nombre de usuario con sesión iniciada. 
     * 
     * @return nombre del usuario con sesión iniciada
     */    
    public User_17986494_Sepulveda getLoggedUser() {
        return loggedUser;
    }
  
    public void setLoggedUser(User_17986494_Sepulveda loggedUser) {
        this.loggedUser = loggedUser;
    }

     /**
     * Retorna componente temporal guardado en sistema. Útil para modificar componentes
     * en específico. Utilizado en los menus de modificación.
     * 
     * @return componente temporal guardado en sistema
     */      
    public Componente_17986494_Sepulveda getComponenteTemporal() {
        return componenteTemporal;
    }

     /**
     * Guarda un componente temporal en el sistema. Útil para modificar componentes
     * en específico. Utilizado en los menus de modificación.
     * 
     * @param componenteTemporal Componente que se desea agregar
     */       
    public void setComponenteTemporal(Componente_17986494_Sepulveda componenteTemporal) {
        this.componenteTemporal = componenteTemporal;
    }
    
}
