/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_17986494_Sepulveda;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *Clase de mensaje de interacción. Un nuevo mensaje se genera cada vez que un usuario
 * interactúa con un chatbot y envía una respuesta al sistema. Estos mensajes se almacenan
 * en el registro chatHistory del usuario. Incluye toda la información necesaria
 * para recomponer en formato String una interacción en particular.
 * @author nic_s
 */
public class Message_17986494_Sepulveda {
    private Date systemDate;
    private Date userDate;
    private String menuPrint;
    private String mens;
    private String user;
    
    Message_17986494_Sepulveda(Date systemDate, Date userDate, String menu, String mens, String user){
        this.systemDate = systemDate;
        this.userDate = userDate;
        this.menuPrint = menu;
        this.mens = mens;
        this.user = user;
    }
    
    @Override
    public String toString(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String systemDateFormat = dateFormat.format(systemDate);
        String userDateFormat = dateFormat.format(userDate);
        String message = systemDateFormat + " - " + this.menuPrint + userDateFormat 
                + " - " + this.user + ": " + this.mens + "\n";   
        return message;
    }
    
}
