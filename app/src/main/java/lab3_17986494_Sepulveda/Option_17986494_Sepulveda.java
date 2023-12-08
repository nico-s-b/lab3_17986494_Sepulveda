/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_17986494_Sepulveda;

import java.util.ArrayList;

/**
 * Clase Option, para objetos que serán opciones de un flujo de un chatbot. Las
 * opciones tienen un identificador único dentro de un flujo, y enlazan con un
 * chatbot en particular y con uno de los flujos que pertenecen a este. La opción
 * puede ser seleccionada por su Id o mediante alguna palabra clave contenida en
 * las keywords. Hereda de la clase {@link Componente_17986494_Sepulveda}
 * @author nic_s
 */
public class Option_17986494_Sepulveda extends Componente_17986494_Sepulveda{

    private String message;
    private int chatbotCodeLink;
    private int flowCodeLink;
    private ArrayList<String> keywords;
    
    public Option_17986494_Sepulveda(){
        super();
        this.keywords = new ArrayList<>();
    }

    public Option_17986494_Sepulveda(int id, String message, int chatbotId, int flowId, ArrayList<String> keys){
        super(id);
        this.message = message;
        this.chatbotCodeLink = chatbotId;
        this.flowCodeLink = flowId;
        
        this.keywords = new ArrayList<>();  
        for(String word: keys){
            this.keywords.add(word.toLowerCase());
        }            
    }
    
/**
 * Método que añade palabras clave a la opción. Recibe strings, y verifica
 * que éstas palabras no hayan sido añadidas previamente.
 * @author nic_s
 * 
 * @param keyword
 */
    public void addKeyword(String keyword){
        if (keyword != null && !this.getKeywords().contains(keyword)){
            this.getKeywords().add(keyword);
        }
    }
    
    @Override
    public String toString(){
        String atr1 = String.format("Op: %d | CbLink:%d FlLink %d | '%s'",this.getId(), this.getChatbotCodeLink(), this.getFlowCodeLink(), this.getMessage());
        String atr2 = "Keywords: ";
        for (String s: this.getKeywords()){
            atr2 = atr2+s+" ";
        }
        return atr1+atr2;
    }     
    
    public boolean optionMatch(String mensaje){
        if (keywords.contains(mensaje) || mensaje.equals(Integer.toString(this.getId()))){
            return true;
        }else{
            return false;
        }
    }
    
    //Getters

    public String getMessage() {
        return message;
    }

    public int getChatbotCodeLink() {
        return chatbotCodeLink;
    }

    public int getFlowCodeLink() {
        return flowCodeLink;
    }

    public ArrayList<String> getKeywords() {
        return keywords;
    }    
    
    //Setters

    public void setMessage(String message) {
        this.message = message;
    }

    public void setChatbotCodeLink(int chatbotCodeLink) {
        this.chatbotCodeLink = chatbotCodeLink;
    }

    public void setFlowCodeLink(int flowCodeLink) {
        this.flowCodeLink = flowCodeLink;
    }
}
