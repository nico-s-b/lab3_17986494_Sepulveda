/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_17986494_Sepulveda;

import java.util.ArrayList;

/**
 * Clase Flow, para objetos que ser�n flujos de un chatbot, que presentar�n un
 * mensaje que servir� de posible pregunta o instrucci�n para la cual se desplegar�n
 * las opciones contenidas en el listado de options del flujo. Los flujos tienen
 * un identificador �nico dentro de un chatbot. Hereda de la clase {@link Componente_17986494_Sepulveda}
 * @author nic_s
 */
public class Flow_17986494_Sepulveda extends Componente_17986494_Sepulveda{
    
    private String nameMessage;
    private ArrayList<Option_17986494_Sepulveda> options;
    
    public Flow_17986494_Sepulveda(){
        this.options = new ArrayList<>();
    }

    /**
     * M�todo que a�ade una opci�n a un flujo, evitando a�adir opciones duplicadas
     * de acuerdo al Id de estas. Llama al m�todo {@link Componente_17986494_Sepulveda#addComponent(java.util.ArrayList, lab3_17986494_Sepulveda.Componente_17986494_Sepulveda)}
     * para realizar la acci�n. Captura el error lanzado por dicho m�todo.
     * @author nic_s
     * @param option
     */
    public void addOptionToFLow(Option_17986494_Sepulveda option){
        try{
            Componente_17986494_Sepulveda.addComponent(this.getOptions(), option);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public String toString(){
        String atr1 = String.format("Flujo: '%s'\nFlow Id: %d\n", this.getNameMessage(), this.getId());
        String atr2 = String.format("# Opciones cargadas: %d\n",this.getOptions().size());
        String atr3 = "";
        for (Option_17986494_Sepulveda op: this.getOptions()){
            atr3 = atr3 + op.getMessage()+ "\n";
        }
        return atr1+atr2+atr3;
    }
    
    //Getters & Setters
    
    public String getNameMessage() {
        return nameMessage;
    }

    public void setNameMessage(String nameMessage) {
        this.nameMessage = nameMessage;
    }    
    
    public ArrayList<Option_17986494_Sepulveda> getOptions() {
        return options;
    }
}
