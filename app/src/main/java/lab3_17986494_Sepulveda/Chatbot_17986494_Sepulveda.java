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
public class Chatbot_17986494_Sepulveda {
    private int id;
    private String name;
    private String welcomeMessage;
    private int startFlowId;
    private ArrayList<Flow_17986494_Sepulveda> flows;

    public Chatbot_17986494_Sepulveda(){
        this.flows = new ArrayList<>();
    }
    
    public void addFlowToChatbot(Flow_17986494_Sepulveda flow){
        for (Flow_17986494_Sepulveda fl : this.flows){
            if (fl.getId() == flow.getId()){
                throw new IllegalArgumentException("Ya existe un flow con el mismo código en el chatbot.");
            }
        }
        this.flows.add(flow);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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