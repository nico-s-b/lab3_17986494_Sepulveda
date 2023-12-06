/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_17986494_Sepulveda;

import java.util.ArrayList;

/**
 * Clase componente, que identifica a los diferentes componentes que pueden formar
 * parte de un sistema de chatbots y que puedan ser identificados mediante un Id
 * �nico; a saber: chatbot, flow y option, clases que heredan de esta. Contiene
 * un m�todo que permite agregar componentes sin repetir Id a una lista de componentes
 * y otro para filtrar componentes de un tipo espec�fico de un listado de componentes.
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
* M�todo para agregar un componente a una lista de componentes sin duplicados.
* El m�todo utiliza parametrizaci�n de tipos para agregar un componente a una 
* lista de componentes, verificando previamente que el id del componente a
* agregar no lo posea otro componente perteneciente a la lista.
* En caso de que exista un componente con el mismo Id, se lanza una excepci�n
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
                throw new IllegalArgumentException("Ya existe un componente con el mismo c�digo identificador.");
            }
        }
        list.add(comp);
    }

/**
* M�todo para filtrar componentes de una clase espec�fica dentro de una lista de
* componentes. Retorna una lista con objetos de la clase deseada, mientras estos
* sean instancias de clases que heredan desde {@link Componente_17986494_Sepulveda}
* @author nic_s
     * @param <Type> tipo de elementos que se desean filtrar y devolver
     * @param list lista de componentes gen�ricos que se desea filtrar
     * @param clase clase del tipo de componentes que se desea filtrar
     * @return Lista con componentes del tipo especificado
*/
    public static <Type extends Componente_17986494_Sepulveda> ArrayList<Type> filterComponent(
            ArrayList<? extends Componente_17986494_Sepulveda> list, Class<Type> clase){
        ArrayList<Type> filteredList = new ArrayList<>();
        for (Componente_17986494_Sepulveda c : list) {
            if (clase.isInstance(c)){
                filteredList.add((Type) c);
            }
        }
        return filteredList;
    }
    
    public static <Type extends Componente_17986494_Sepulveda> Type getComponentById(
        ArrayList<Type> list, int Id){
        for (Type c : list){
            if (c.getId() == Id){
                return c;
            }
        }return null;
    }
    
    public static <Type extends Componente_17986494_Sepulveda> void remComponentById(
        ArrayList<Type> list, int Id){
        for (Type c : list){
            if (c.getId() == Id){
                 list.remove(c);
                 break;
            }
        }
    }    
}
