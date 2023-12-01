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
public class Flow_17986494_Sepulveda {
    private int id;
    private String nameMessage;
    private ArrayList<Option_17986494_Sepulveda> options;

    public Flow_17986494_Sepulveda(){
        this.options = new ArrayList<>();
    }
    
    public void addOptionToFLow(Option_17986494_Sepulveda option){
        for (Option_17986494_Sepulveda op : this.options){
            if (op.getCode() == option.getCode()){
                throw new IllegalArgumentException("Ya existe una opción con el mismo código en el flujo.");
            }
        }
        this.options.add(option);
    }
    
    public int getId() {
        return id;
    }

    public String getNameMessage() {
        return nameMessage;
    }

    public ArrayList<Option_17986494_Sepulveda> getOptions() {
        return options;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNameMessage(String nameMessage) {
        this.nameMessage = nameMessage;
    }

    public void setOptions(ArrayList<Option_17986494_Sepulveda> options) {
        this.options = options;
    }
    
}
