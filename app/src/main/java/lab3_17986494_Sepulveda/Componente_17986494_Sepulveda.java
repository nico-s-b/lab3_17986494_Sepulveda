/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_17986494_Sepulveda;

import java.util.ArrayList;

/**
 * Clase componente, que identifica a los diferentes componentes que pueden formar
 * parte de un sistema de chatbots y que puedan ser identificados mediante un Id
 * único; a saber: chatbot, flow y option, clases que heredan de esta. Contiene
 * un método que permite agregar componentes sin repetir Id a una lista de componentes.
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
* El método utiliza parametrización de tipos para agregar un componente a una 
* lista de componentes, verificando previamente que el id del componente a
* agregar no lo posea otro componente perteneciente a la lista.
* En caso de que exista un componente con el mismo Id, se lanza una excepción
* @author nic_s
* @throws IllegalArgumentException : si ya existe un componente con el mismo Id
* 
 * @param <Type> : tipo de componente
 * @param list : lista de componentes a la que se desea agregar uno nuevo
 * @param comp : componente a agregar
*/
    public static <Type extends Componente_17986494_Sepulveda> void addComponent(ArrayList<Type> list, Type comp)  throws IllegalArgumentException {
        for (Componente_17986494_Sepulveda c : list) {
            if (c.getId() == comp.getId()) {
                throw new IllegalArgumentException("Ya existe un componente con el mismo código identificador.");
            }
        }
        list.add(comp);
    }
    
    public static <Type extends Componente_17986494_Sepulveda> ArrayList<Type> filterComponent(ArrayList<Type> list, Class<?> clase){
        ArrayList<Type> filteredList = new ArrayList<>();
        for (Type c : list) {
            if (clase.isInstance(c)){
                filteredList.add(c);
            }
        }
        return filteredList;
    }
}
