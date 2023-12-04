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
public class Flow_17986494_Sepulveda extends Componente_17986494_Sepulveda{
    
    private String nameMessage;
    private ArrayList<Option_17986494_Sepulveda> options;
    
    public Flow_17986494_Sepulveda(){
        this.options = new ArrayList<>();
    }
    
    public void addOptionToFLow(Option_17986494_Sepulveda option){
        try{
            Componente_17986494_Sepulveda.addComponent(this.getOptions(), option);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public String getNameMessage() {
        return nameMessage;
    }

    public ArrayList<Option_17986494_Sepulveda> getOptions() {
        return options;
    }

    public void setNameMessage(String nameMessage) {
        this.nameMessage = nameMessage;
    }

    public void setOptions(ArrayList<Option_17986494_Sepulveda> options) {
        this.options = options;
    }
    
}
