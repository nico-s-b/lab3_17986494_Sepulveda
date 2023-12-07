/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_17986494_Sepulveda;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author nic_s
 */
public class MenusModificar_17986494_Sepulveda {
    
    public static void menuModificarChatbot(System_17986494_Sepulveda sys){
        ArrayList<Chatbot_17986494_Sepulveda> chatbots = Componente_17986494_Sepulveda.<Chatbot_17986494_Sepulveda>filterComponent(
                                                    sys.getComponentes(), Chatbot_17986494_Sepulveda.class);
        if (chatbots.isEmpty()){
            System.out.print("Creando un nuevo chatbot...\n");
            return;
        }
        System.out.print("Creando un nuevo chatbot...\n");
        Scanner input = new Scanner(System.in); 
    }
}
