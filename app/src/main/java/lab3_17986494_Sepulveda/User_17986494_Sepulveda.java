/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_17986494_Sepulveda;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author nic_s
 */
public abstract class User_17986494_Sepulveda {
    private final String username;
    private ArrayList<Message_17986494_Sepulveda> chatHistory;
    private boolean admin;
    
    User_17986494_Sepulveda(String username){
        this.username = username;
        this.chatHistory = new ArrayList<>();
    }
 

    
    public void userLogin(System_17986494_Sepulveda system){
        system.login(this);
    }
    
    public void userLogout(System_17986494_Sepulveda system){
        system.logout();
    }

    public void requestSynthesis(System_17986494_Sepulveda system){
        system.synthesis(this);
    }

/**
 * Método para solicitar una simulación.
 * Una vez llamado, se utiliza el tiempo en segundos obtenido a partir de Date() como semilla para la simulación.
 * El método hace un llamado al método del TDA system que ejecuta la simulación.
 * @param system sistema sobre el cual se está solicitando la simulación. No se le solicita al usuario
 * @param maxInter cantidad máxima de interacciones solicitadas por el usuario
 */    
    public void requestSimulation(System_17986494_Sepulveda system, int maxInter){
        Date currentDate = new Date();
        long currentTimeMillis = currentDate.getTime();
        int currentSeconds = (int) (currentTimeMillis / 10000);
        system.simulate(maxInter, currentSeconds);
    }
    
    private void addMessage(Message_17986494_Sepulveda mens){
        this.chatHistory.add(mens);
    }

    public String getUsername() {
        return username;
    }

    public boolean isAdmin(){
        return this.admin;
    }
    
    public void setAdmin(boolean isAdmin){
        this.admin = isAdmin;
    }
    
    public ArrayList<Message_17986494_Sepulveda> getChatHistory() {
        return chatHistory;
    }
    
}
