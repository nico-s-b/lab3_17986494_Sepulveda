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
public class Option_17986494_Sepulveda extends Componente_17986494_Sepulveda{

    //Atributos de clase
    private String message;
    private int chatbotCodeLink;
    private int flowCodeLink;
    private ArrayList<String> keywords;
    
    //Constructor por defecto
    public Option_17986494_Sepulveda(){
        this.keywords = new ArrayList<>();
    }
    
    //Add keyword
    public void addKeyword(String keyword){
        if (keyword != null && !keywords.contains(keyword)){
            this.keywords.add(keyword);
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
