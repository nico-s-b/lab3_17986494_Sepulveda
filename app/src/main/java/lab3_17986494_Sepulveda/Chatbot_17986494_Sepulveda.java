/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_17986494_Sepulveda;

import java.util.ArrayList;

/**
 * Clase Chatbot, para objetos que ser�n chatbots dentro de un sistema, los que agrupan
 * los flujos que se encuentren relacionados entre s�. El atributo strartFlowId 
 * se�ala el flujo actualmente cargado dentro del chatbot. Los chatbots tienen
 * un identificador �nico dentro de un sistema. Hereda de la clase {@link Componente_17986494_Sepulveda}
 * @author nic_s
 */
public class Chatbot_17986494_Sepulveda extends Componente_17986494_Sepulveda{
    
    private String name;
    private String welcomeMessage;
    private int startFlowId;
    private ArrayList<Flow_17986494_Sepulveda> flows;

    /**
     *Constructor de Chatbot por defecto. Crea una instancia vac�a de chatbot 
     * sin atributos inicializados
     */
    public Chatbot_17986494_Sepulveda(){
        super();
        this.flows = new ArrayList<>();
    }

    /**
     *Constructor de Chatbot inicializado. Permite construir una nueva instancia
     * de chatbot a partir de sus par�metros de identificador, nombre, mensaje
     * de bienvenida, identificador de flujo inicial y listado de flujos
     * 
     * @param id C�digo identificador del chatbot
     * @param name Nombre del chatbot
     * @param welcome Mensaje de bienvenida del chatbot
     * @param flowId C�digo indentificador del flujo actual
     * @param flows Listado de flujos del chatbot
     */
    public Chatbot_17986494_Sepulveda(int id, String name, String welcome, int flowId, ArrayList<Flow_17986494_Sepulveda> flows){
        super(id);
        this.name = name;
        this.welcomeMessage = welcome;
        this.startFlowId = flowId;
        //M�todo para remover duplicados
        this.flows = Componente_17986494_Sepulveda.remDuplicates(flows);
    }
    
    /**
     * M�todo que a�ade un flujo a un chatbot, evitando a�adir flujos duplicados
     * de acuerdo al Id de estos. Llama al m�todo {@link Componente_17986494_Sepulveda#addComponent(java.util.ArrayList, lab3_17986494_Sepulveda.Componente_17986494_Sepulveda)}
     * para realizar la acci�n. Captura el error lanzado por dicho m�todo.
     * 
     * @param flow flujo que se desea a�adir
     */
    public void chatbotAddFlow(Flow_17986494_Sepulveda flow){
        try{
            Componente_17986494_Sepulveda.addComponent(this.getFlows(), flow);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
  
    /**
      * M�todo que retorna un string que muestra el mensaje del flujo actual
      * cargado en el chatbot y el listado de opciones de �ste, de manera legible
      * para que el usuario pueda interactuar con el chatbot.
      * 
      * @return String
      */    
    public String toPrint(){
        String fl = this.getActualFlow().getName() + "\n";
        String ops = "";
        for (Option_17986494_Sepulveda op: this.getActualFlow().getOptions()){
            ops = ops + op.getMessage() + "\n";
        }
        return fl + ops;
    }

    @Override
    public String toString(){
        String atr1 = String.format("Chatbot '%s'\nMensaje: %s\nChatbotId: %d / StartFlowId: %d\n",this.getName(),this.getWelcomeMessage(),this.getId(),this.getStartFlowId());
        String atr2 = String.format("# Flujos cargados: %d\n",this.getFlows().size());
        return atr1+atr2;
    }

    /**
     * M�todo que retorna el flow actual cargado en el chatbot, en funci�n del
     * startFlowId vigente en el chatbot.
     */
    private Flow_17986494_Sepulveda getActualFlow(){
        for (Flow_17986494_Sepulveda fl: this.getFlows()){
            if (fl.getId() == this.getStartFlowId()){
                return fl;
            } 
        }
        return null;
    }
    
    //Getters & Setters
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public int getStartFlowId() {
        return startFlowId;
    }

    public void setStartFlowId(int startFlowId) {
        this.startFlowId = startFlowId;
    }

    public ArrayList<Flow_17986494_Sepulveda> getFlows() {
        return flows;
    } 
}