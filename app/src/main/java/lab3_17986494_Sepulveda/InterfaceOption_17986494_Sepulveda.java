/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lab3_17986494_Sepulveda;

/**
 *Interface de Option. Contiene los m�todos principales que deben estar presentes en la clase
 * @author nic_s
 */
public interface InterfaceOption_17986494_Sepulveda {
    
    /**
     * M�todo para a�adir palabra clave
     * 
     * @param keyword palabra clave a a�adir
     */
    void addKeyword(String keyword);
    
    /**
     * M�todo para verificar si mensaje coincide con palabra clave o c�digo de opci�n.
     * 
     * @param mensaje mensaje a comparar
     * @return true or false
     */
    boolean optionMatch(String mensaje);
    
}
