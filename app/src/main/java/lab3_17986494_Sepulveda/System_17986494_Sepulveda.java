/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_17986494_Sepulveda;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 *Clase para Sistema. Contiene el conjunto de chatbots asociados a un sistema, 
 * con los m�todos necesarios para interactuar con ellos y para gestionar usuarios.
 * @author nic_s
 */
public class System_17986494_Sepulveda {
    private String name;
    private int chatbotCodeLink;
    private ArrayList<Chatbot_17986494_Sepulveda> chatbots;
    private ArrayList<User_17986494_Sepulveda> users;   //Listado de usuarios registrados
    private boolean logState;       //Se�ala si hay un usuario actualmente loggeado
    private boolean logAdmin;       //Se�ala si el administrador est� o no actualmente loggeado
    private String loggedUser;      //Nombre del usuario actualmente loggeado en sistema
    private ArrayList<Componente_17986494_Sepulveda> componentesDisponibles;    //Componentes creados pero que no se han a�adido al sistema
    private Componente_17986494_Sepulveda componenteTemporal;   //Componente temporal: usado como variable para guardar componente que se desee modificar
    private Date fechaCreacion;     //Fecha de graci�n del sistema

    /**
     *Constructor de System por defecto. Entrega un sistema en blanco sin sesion
     * iniciada y con fecha de creaci�n. El chatbotCodeLink es seteado en 0.
     */
    public System_17986494_Sepulveda(){
        this.name = "ChatbotSystem";
        this.chatbotCodeLink = 0;
        this.chatbots = new ArrayList<>();
        this.users = new ArrayList<>();
        this.logState = false;
        this.logAdmin = false;
        this.loggedUser = "";
        this.componentesDisponibles = new ArrayList<>();
        this.fechaCreacion = new Date();
        this.componenteTemporal = null;
    }

    /**
     *Constructor de System inicializado. Permite construir un sistema con atributos
     * de nombre, c�digo de chatbot y listado de chatbots dados.
     * @param name Nombre del sistema
     * @param chatbotCodeLink C�digo de inicializaci�n de chatbot
     * @param chatbots Listado de chatbots del sistema
     */
    public System_17986494_Sepulveda(String name, int chatbotCodeLink, ArrayList<Chatbot_17986494_Sepulveda> chatbots){
        this.name = name;
        this.chatbotCodeLink = chatbotCodeLink;
        //M�todo para remover duplicados
        this.chatbots = Componente_17986494_Sepulveda.remDuplicates(chatbots);
        this.users = new ArrayList<>();
        this.logState = false;
        this.logAdmin = false;
        this.loggedUser = "";
        this.componentesDisponibles = new ArrayList<>();
        this.fechaCreacion = new Date();  
    }

    /**
     * M�todo que a�ade un chatbot a un sistema, evitando a�adir chatbots duplicados
     * de acuerdo al Id de estas. Llama al m�todo {@link Componente_17986494_Sepulveda#addComponent(java.util.ArrayList, lab3_17986494_Sepulveda.Componente_17986494_Sepulveda)}
     * para realizar la acci�n. Captura el error lanzado por dicho m�todo.
     * 
     * @param chatbot chatbot que se desea a�adir
     */
    public void systemAddChatbot(Chatbot_17986494_Sepulveda chatbot){
        try{
            Componente_17986494_Sepulveda.addComponent(this.getChatbots(), chatbot);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * M�todo para registrar usuarios nuevos al sistema.Recibe un nombre de usuario 
     * y si �ste tendr� o no privilegios de administrador.Crea un nuevo usuario
     * y lo a�ade al sistema utilizando el m�todo {@link #systemAddUser(lab3_17986494_Sepulveda.User_17986494_Sepulveda)}
     * 
     * @param username nombre del nuevo usuario
     * @param isAdmin booleano que indica si el nuevo usuario ser� o no administrador
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
     * M�todo para iniciar sesi�n. Recibe un usuario como par�metro y verifica si
     * es o no posible para este usuario iniciar la sesi�n.
     * @throws IllegalStateException si se intenta iniciar sesi�n cuando ya hay una iniciada
     * @throws IllegalArgumentException si el usuario que intenta iniciar sesi�n no 
     * est� registrado en el sistema
     * 
     * @param user instancia de usuario que desea iniciar sesi�n
     */
    public void systemLogin(User_17986494_Sepulveda user){
        if (this.isLogState()){
            throw new IllegalStateException("Ya existe una sesion iniciada en el sistema.");
        }
        if (userInSystem(user)){
            this.setLogState(true);
            this.setLoggedUser(user.getUsername());
            if (user.isAdmin()){
                this.setLogAdmin(true);
            }
        }else{
            throw new IllegalArgumentException("El usuario que intenta iniciar sesi�n no esta registrado en el sistema.");
        }
    }
    
    /**
     * M�todo que busca si un usuario dado est� o no registrado en el sistema
     * 
     * @param username nombre del usuario a buscar
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
     * M�todo para cerrar sesi�n, cambiando todos los par�metros necesarios del sistema
     * @throws IllegalStateException si no hay una sesi�n iniciada 
     */
    public void systemLogout(){
        if (this.isLogState()){
            this.setLogState(false);
            this.setLogAdmin(false);
            this.setLoggedUser("");
            this.setChatbotCodeLink(0);
        }else{
            throw new IllegalStateException("No hay sesion iniciada en el sistema.");
        }
    }

    /**
     * M�todo que ejecuta una conversaci�n con los chatbots disponible en el sistema
    Requiere una sesi�n inciada para iniciar la conversaci�n. Construye en cada
    interacci�n un mensaje que ser� a�adido al historial del usuario.
    En cada interacci�n, actualiza los c�digos de chatbot y flow seg�n la opci�n
    del usuario o le pregunta de nuevo en caso de entrada no v�lida. Permite
    terminar la interacci�n completamente con la palabra clave "exit"
     * 
     * @param input scanner para entradas de usuario
     */    
    public void systemTalk(Scanner input){
        this.setChatbotCodeLink(0); //Devolver chatbot del sistema a 0
        //Verificar inicio de sesi�n previo a interacci�n
        if(!this.isLogState()){
            System.out.print("Sesion no iniciada, no es posible interactuar");
            return;
        }
        boolean continueInteraction = true;

        while(continueInteraction){
            Date systemDate = new Date();   //fecha de la pregunta
            String menu = this.getActualChatbot().toPrint();
            System.out.print(menu);
            System.out.print("Ingrese opcion: ");
            String option = input.nextLine();
            System.out.print("\n");
            Date userDate = new Date();     //Fecha de la respuesta
            //Construcci�n de mensaje
            Message_17986494_Sepulveda newMens = new Message_17986494_Sepulveda(systemDate, userDate, menu, option, this.loggedUser);
            this.getUser(this.loggedUser).addMessage(newMens);
            if (option.toLowerCase().equals("exit")) {
                continueInteraction = false;
            }else{
                boolean opcionReconocida = false;
                for (Option_17986494_Sepulveda op: this.getActualFlow().getOptions()){
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
        }
    }

    /**
     * Sobrecarga del m�todo systemTalk que maneja el caso de una simulaci�n del 
     sistema.Se activa si es solicitada desde systemTalk.No verifica inicio de sesi�n pues
     trabaja con un usuario ficticio creado por systemSimulate.Emplea la misma l�gica
     que systemTalk para interacci�n humana, estando la diferencia en que genera
     las opciones a partir de una semilla aleatoria, utilizando el m�todo random.nextInt(bound)
     para generar opciones aleatorias entre 1 y la cantidad de opciones del flujo
     actual, de manera de generar interacciones v�lidas.
     Generar� maxInter interacciones en total, todas ellas en principio v�lidas si
     el sistema de chatbots est� bien definido.
    * 
    * @param seed semilla aleatoria para generar opciones aleatorias
    * @param maxInter cantidad de interacciones solicitadas
    * @param user usuario ficticio creado por {@link #systemSimulate(int, int) }
     */     
    public void systemTalk(int seed, int maxInter, User_17986494_Sepulveda user){
        this.setChatbotCodeLink(0); //Devolver chatbot del sistema a 0
        Random random = new Random(seed);       //Random a partir de semilla
        for(int i = 0; i < maxInter; i++){
            Date systemDate = new Date();
            String menu = this.getActualChatbot().toPrint();
            System.out.print(menu);
            System.out.print("user '" + user.getUsername() + " dice: ");

            //se generan valores aleatorios entre 1 y el n�mero de opciones del flow
            int opt = random.nextInt(this.getActualFlow().getOptions().size()) + 1;
            String option = Integer.toString(opt);
            System.out.print(option + "\n");
            System.out.print("\n");
            Date userDate = new Date();
            Message_17986494_Sepulveda newMens = new Message_17986494_Sepulveda(systemDate, userDate, menu, option, user.getUsername());
            user.addMessage(newMens);
            boolean opcionReconocida = false;
            for (Option_17986494_Sepulveda op: this.getActualFlow().getOptions()){
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
     *Funci�n que hace imprime la s�ntesis del historial de conversaciones de un
     * usuario. La l�gica de la generaci�n del mensaje se encuentra en el m�todo
     * de la clase usuario para manejar su propio historia de mensajes. 
     * Ver {@link User_17986494_Sepulveda#generateSynthesis() }
     * 
     * @param user
     */
    public void systemSynthesis(User_17986494_Sepulveda user){
        System.out.println(user.generateSynthesis());
    }

    /**
     *M�todo para solicitar una simulaci�n de una simulaci�n de interacciones con
     * el sistema de chatbots. Crea un usuario ficticio que ser� empleado para
     * realizar la simulaci�n. Este usuario quedar� a�adido en el sistema, con su
     * correspondiente historial de conversaci�n. Llama a m�todo sobrecargado de
     * {@link #systemTalk(int, int, lab3_17986494_Sepulveda.User_17986494_Sepulveda) }
     * 
     * @param maxInter cantidad de interacciones solicitadas
     * @param seed semilla para generar opciones aleatorias
     */
    public void systemSimulate(int maxInter, int seed){
        String fakeUser = "user" + Integer.toString(seed);
        NormalUser_17986494_Sepulveda user = new NormalUser_17986494_Sepulveda(fakeUser);
        this.systemAddUser(user);
        systemTalk(seed, maxInter, user);
    }

    /**
     * M�todo para imprimir el listado de todos los usuarios registrados en el sistema
     */        
    public void registeredUsers(){
        for (User_17986494_Sepulveda us : this.getUsers()){
            System.out.print(us);
            System.out.print("\n");
        }
    }

    /**
     * M�todo que agrega un componente (chatbot, flujo, opcion) a la lista de componentes
     * disponibles para uso del sistema.
     * 
     * @param comp componente que se desea a�adir
     */
    public void addComponente(Componente_17986494_Sepulveda comp){
        this.componentesDisponibles.add(comp);
    }

    //Specific getters
    /**
     * Devuelve la instancia del usuario administrador del sistema
     * 
     * @return user Instancia del usuario administrador encontrada
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
     * Devuelve un usuario del sistema de acuerdo al nombre. Returna null en caso
     * de no existir el usuario deseado
     * 
     * @param username String con el nombre del usuario buscado.
     * @return user Instancia de usuario encontrada
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
     * M�todo que entrega una lista de TODOS los chatbots en el sistema, tanto
     * los que est�n cargados en �l como los que se encuentran en el listado de
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
     * M�todo que entrega una lista de TODOS los flujos en el sistema, tanto
     * los que est�n cargados en cada chatbot cargado en el sistema como los que 
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
     * M�todo que entrega una lista de TODAS las opciones en el sistema, tanto
     * las que est�n a�adidas en cada flujo de cada chatbot cargado en el sistema 
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
    
    /**
     * M�todo para obtener el chatbot cargado en el sistema. Utiliza el atributo
     * {@link System_17986494_Sepulveda#chatbotCodeLink} para ubicar el chatbot
     * que se encuentra disponible en el sistema actualmente.
     * 
     * @return instancia de chatbot
     */  
    public Chatbot_17986494_Sepulveda getActualChatbot(){
        for (Chatbot_17986494_Sepulveda cb: this.getChatbots()){
            if (cb.getId() == this.getChatbotCodeLink()){
                return cb;
            }
        }
        return null;
    }
    
    /**
     * M�todo para obtener el flujo actual del sistema. Utiliza el m�todo
     * {@link System_17986494_Sepulveda#getActualChatbot() } para ubicar el chatbot
     * que se encuentra disponible en el sistema, para luego, dentro de �ste,
     * ubicar el flujo actual a partir del atributo {@link Chatbot_17986494_Sepulveda#startFlowId}.
     * 
     * @return instancia de flujo
     */  
    public Flow_17986494_Sepulveda getActualFlow(){
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

     /**
     * M�todo para consultar si existe una sesi�n iniciada en el sistema
     * @return boolean
     */    
    public boolean isLogState() {
        return logState;
    }

    public void setLogState(boolean logState) {
        this.logState = logState;
    }

     /**
     * M�todo para consultar si el administrador ha iniciado sesi�n en el sistema
     * @return boolean
     */
    public boolean isLogAdmin() {
        return logAdmin;
    }

    public void setLogAdmin(boolean logAdmin) {
        this.logAdmin = logAdmin;
    }    

     /**
     * Retorna nombre de usuario con sesi�n iniciada. 
     * @return nombre del usuario con sesi�n iniciada
     */    
    public String getLoggedUser() {
        return loggedUser;
    }
  
    public void setLoggedUser(String loggedUser) {
        this.loggedUser = loggedUser;
    }

     /**
     * Retorna componente temporal guardado en sistema. �til para modificar componentes
     * en espec�fico. Utilizado en los menus de modificaci�n.
     * @return componente temporal guardado en sistema
     */      
    public Componente_17986494_Sepulveda getComponenteTemporal() {
        return componenteTemporal;
    }

     /**
     * Guarda un componente temporal en el sistema. �til para modificar componentes
     * en espec�fico. Utilizado en los menus de modificaci�n.
     * 
     * @param componenteTemporal Componente que se desea agregar
     */       
    public void setComponenteTemporal(Componente_17986494_Sepulveda componenteTemporal) {
        this.componenteTemporal = componenteTemporal;
    }
    
}
