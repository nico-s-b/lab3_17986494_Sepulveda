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
public class Chatbot_17986494_Sepulveda extends Componente_17986494_Sepulveda{
    
    private String name;
    private String welcomeMessage;
    private int startFlowId;
    private ArrayList<Flow_17986494_Sepulveda> flows;

    public Chatbot_17986494_Sepulveda(){
        this.flows = new ArrayList<>();
    }

    public void addFlowToChatbot(Flow_17986494_Sepulveda flow){
        try{
            Componente_17986494_Sepulveda.addComponent(this.getFlows(), flow);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
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