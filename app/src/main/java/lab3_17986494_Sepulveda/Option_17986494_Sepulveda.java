/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_17986494_Sepulveda;

import java.util.List;

/**
 *
 * @author nic_s
 */
public class Option_17986494_Sepulveda {

    //Atributos de clase
    private int code;
    private String message;
    private int chatbotCodeLink;
    private int flowCodeLink;
    private List<String> keywords;
    
    //Constructor por defecto
    public Option_17986494_Sepulveda(){}
    
    //Constructor de nuevo objeto
    public Option_17986494_Sepulveda(int code, String message, int chatbotCodeLink, int flowCodeLink, List<String> keywords){
        this.code = code;
        this.message = message;
        this.chatbotCodeLink = chatbotCodeLink;
        this.flowCodeLink = flowCodeLink;
        this.keywords = keywords;
    }

    
    //Getters
    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public int getChatbotCodeLink() {
        return chatbotCodeLink;
    }

    public int getFlowCodeLink() {
        return flowCodeLink;
    }

    public List<String> getKeywords() {
        return keywords;
    }    
    
    //Setters
    public void setCode(int code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setChatbotCodeLink(int chatbotCodeLink) {
        this.chatbotCodeLink = chatbotCodeLink;
    }

    public void setFlowCodeLink(int flowCodeLink) {
        this.flowCodeLink = flowCodeLink;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }
}
