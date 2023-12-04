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
public class Componente_17986494_Sepulveda {
    private int id;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    

    /**
    * Método para agregar un componente a una lista de componentes sin duplicados.
    * 
    * @author nic_s
     * @param <Type>
     * @param list
     * @param comp
    */
    public static <Type extends Componente_17986494_Sepulveda> void addComponent(ArrayList<Type> list, Type comp) {
        for (Componente_17986494_Sepulveda c : list) {
            if (c.getId() == comp.getId()) {
                throw new IllegalArgumentException("Ya existe un componente con el mismo código identificador.");
            }
        }
        list.add(comp);
    }

    
}
