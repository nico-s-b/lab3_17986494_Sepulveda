/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_17986494_Sepulveda;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author nic_s
 */
public class Message_17986494_Sepulveda {
    private int chatbotCodeLink;
    private int flowCodeLink;
    private String mens;
    private String date;
    private String username;
    
    Message_17986494_Sepulveda(int cbLink, int fLink, String mens,User_17986494_Sepulveda user){
        this.chatbotCodeLink = cbLink;
        this.flowCodeLink = fLink;
        this.mens = mens;
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String currentDateFormatted = dateFormat.format(currentDate);
        this.date = currentDateFormatted;
        this.username = user.getUsername();
    }
    
    @Override
    public String toString(){
        return date + " : " + this.username + ": " + mens;
    }
    
}
