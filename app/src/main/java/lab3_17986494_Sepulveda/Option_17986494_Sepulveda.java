/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_17986494_Sepulveda;

import java.util.ArrayList;

/**
 * Clase Option, para objetos que ser�n opciones de un flujo de un chatbot. Las
 * opciones tienen un identificador �nico dentro de un flujo, y enlazan con un
 * chatbot en particular y con uno de los flujos que pertenecen a este. La opci�n
 * puede ser seleccionada por su Id o mediante alguna palabra clave contenida en
 * las keywords. Hereda de la clase {@link Componente_17986494_Sepulveda}
 * @author nic_s
 */
public class Option_17986494_Sepulveda extends Componente_17986494_Sepulveda{

    private String message;
    private int chatbotCodeLink;
    private int flowCodeLink;
    private ArrayList<String> keywords;
    
    /**
     *Constructor de Option por defecto. Crea una instancia de opci�n sin atributos
     * inicializados.
     */
    public Option_17986494_Sepulveda(){
        super();
        this.keywords = new ArrayList<>();
    }

    /**
     *Constructor de Option inicializado. Permite construir una opci�n a partir
     * de sus atributos de identificador, mensaje, c�digos de flujo y chatbot, y
     * un listado de palabras clave
     * 
     * @param id C�digo identificador de opci�n
     * @param message Mensaje que muestra la opci�n
     * @param chatbotId C�digo de enlace a chatbot
     * @param flowId C�digo de enlace a flujo del chatbot
     * @param keys Listado de palabras clave
     */
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
     * M�todo que a�ade palabras clave a la opci�n. Recibe strings, y verifica
     * que �stas palabras no hayan sido a�adidas previamente.
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
        String atr1 = String.format("OptionId: %d 1| CbLink:%d / FlLink %d || Mens: '%s'",this.getId(), this.getChatbotCodeLink(), this.getFlowCodeLink(), this.getMessage());
        String atr2 = "Keywords: ";
        for (String s: this.getKeywords()){
            atr2 = atr2+s+" ";
        }
        return atr1+atr2;
    }     

    /**
     * M�todo para verificar si un mensaje (en formato String) coincide con alguna
     * de las palabras clave de la opci�n o con su c�digo id.
     * 
     * @param mensaje String con el mensaje del usuario a comparar
     * @return true o false seg�n si hay coincidencia o no
     */    
    public boolean optionMatch(String mensaje){
        return keywords.contains(mensaje) || mensaje.equals(Integer.toString(this.getId()));
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
