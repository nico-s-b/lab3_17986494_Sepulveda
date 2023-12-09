/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_17986494_Sepulveda;

/**
 *Clase de usuarios normales. Hereda de la clase de usuario general. Usuario
 * sin privilegios de administrador.
 * @author nic_s
 */
public class NormalUser_17986494_Sepulveda extends User_17986494_Sepulveda {
    
    NormalUser_17986494_Sepulveda(String user){
        super(user);
        this.setAdmin(false);
    }
    
}
