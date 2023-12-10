/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lab3_17986494_Sepulveda;

/**
 *Interface de Option. Contiene los métodos principales que deben estar presentes en la clase
 * @author nic_s
 */
public interface InterfaceOption_17986494_Sepulveda {
    
    /**
     * Método para añadir palabra clave
     * 
     * @param keyword palabra clave a añadir
     */
    void addKeyword(String keyword);
    
    /**
     * Método para verificar si mensaje coincide con palabra clave o código de opción.
     * 
     * @param mensaje mensaje a comparar
     * @return true or false
     */
    boolean optionMatch(String mensaje);
    
}
