/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_17986494_Sepulveda;

import java.util.ArrayList;

/**
 * Clase Chatbot, para objetos que serán chatbots dentro de un sistema, los que agrupan
 * los flujos que se encuentren relacionados entre sí. El atributo strartFlowId 
 * señala el flujo actualmente cargado dentro del chatbot. Los chatbots tienen
 * un identificador único dentro de un sistema. Hereda de la clase {@link Componente_17986494_Sepulveda}
 * @author nic_s
 */
public class Chatbot_17986494_Sepulveda extends Componente_17986494_Sepulveda{
    
    private String name;
    private String welcomeMessage;
    private int startFlowId;
    private ArrayList<Flow_17986494_Sepulveda> flows;

    public Chatbot_17986494_Sepulveda(){
        super();
        this.flows = new ArrayList<>();
    }

    public Chatbot_17986494_Sepulveda(int id, String name, String welcome, int flowId, ArrayList<Flow_17986494_Sepulveda> flows){
        super(id);
        this.name = name;
        this.welcomeMessage = welcome;
        this.startFlowId = flowId;
        //Método para remover duplicados
        this.flows = Componente_17986494_Sepulveda.remDuplicates(flows);
    }
    
/**
 * Método que añade un flujo a un chatbot, evitando añadir flujos duplicados
 * de acuerdo al Id de estos. Llama al método {@link Componente_17986494_Sepulveda#addComponent(java.util.ArrayList, lab3_17986494_Sepulveda.Componente_17986494_Sepulveda)}
 * para realizar la acción. Captura el error lanzado por dicho método.
 * @author nic_s
 * 
 * @param flow
 */
    public void chatbotAddFlow(Flow_17986494_Sepulveda flow){
        try{
            Componente_17986494_Sepulveda.addComponent(this.getFlows(), flow);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
  
/**
  * Método que retorna un string que muestra el mensaje del flujo actual
  * cargado en el chatbot y el listado de opciones de éste, de manera legible
  * para que el usuario pueda interactuar con el chatbot.
  * @author nic_s
  * 
  * @return String
  */    
    public String toPrint(){
        String fl = this.getActualFlow().getName() + "\n";
        String ops = "";
        for (Option_17986494_Sepulveda op: this.getActualFlow().getOptions()){
            ops = op.getMessage() + "\n";
        }
        return fl + ops;
    }

    @Override
    public String toString(){
        String atr1 = String.format("Chatbot '%s'\nChatbot Id: %d / StartFlowId: %d\n",this.getName(),this.getId(),this.getStartFlowId());
        String atr2 = String.format("# Flujos cargados: %d\n",this.getFlows().size());
        return atr1+atr2;
    }

/**
 * Método que retorna el flow actual cargado en el chatbot, en función del
 * startFlowId vigente en el chatbot.
 * @author nic_s
 */
    private Flow_17986494_Sepulveda getActualFlow(){
        for (Flow_17986494_Sepulveda fl: this.getFlows()){
            if (fl.getId() != this.getStartFlowId()){
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