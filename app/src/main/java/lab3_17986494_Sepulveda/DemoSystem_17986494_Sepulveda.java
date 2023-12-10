/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3_17986494_Sepulveda;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Clase que contiene un conjunto de chatbots de prueba, que pueden ser cargados
 * en el sistema a modo de prueba del funcionamiento del programa
 * @author nic_s
 */
public class DemoSystem_17986494_Sepulveda {

    /**
     * Método único de la clase DemoSystem que retorna un sistema que contiene
     * un conjunto cargado de chatbots con sus flujos y opciones definidos, junto
     * a un usuario 'admin' y otro usuario normal 'user0'. Puede emplearse para
     * probar el sistema.
     * 
     * @return Demo system
     */    
    public static System_17986494_Sepulveda getDemo() {

        //Chatbot 0
        ArrayList<String> op1keys = new ArrayList<>(Arrays.asList("fechas", "calendario", "dias", "fecha"));
        Option_17986494_Sepulveda op1 = new Option_17986494_Sepulveda(1, "1) Calendario", 1, 1, op1keys);

        ArrayList<String> op2keys = new ArrayList<>(Arrays.asList("tareas","pendientes","tasks", "tarea"));
        Option_17986494_Sepulveda op2 = new Option_17986494_Sepulveda(2, "2) Tareas", 2, 1, op2keys);

        ArrayList<String> op3keys = new ArrayList<>(Arrays.asList("meta", "metas", "goals", "objetivos"));
        Option_17986494_Sepulveda op3 = new Option_17986494_Sepulveda(3, "3) Metas", 3, 1, op3keys);

        ArrayList<Option_17986494_Sepulveda> flow1ops = new ArrayList<>(Arrays.asList(op1, op2, op3));
        Flow_17986494_Sepulveda flow1 = new Flow_17986494_Sepulveda(1,"Flujo Principal Organizador\nBienvenido\n¿Que te gustaria revisar?",flow1ops);

        ArrayList<Flow_17986494_Sepulveda> chatbot0flows = new ArrayList<>(Arrays.asList(flow1));
        Chatbot_17986494_Sepulveda chatbot0 = new Chatbot_17986494_Sepulveda(0,"Inicial", "Bienvenido\n¿Que te gustaria revisar?", 1,chatbot0flows);

        ////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////

        //Chatbot 1
        //Opciones primer flujo Chatbot1
        ArrayList<String> op4keys = new ArrayList<>(Arrays.asList("dia", "diario"));
        Option_17986494_Sepulveda op4 = new Option_17986494_Sepulveda(1, "1) 1 día", 1, 2, op4keys);

        ArrayList<String> op5keys = new ArrayList<>(Arrays.asList("semana","semanal","week"));
        Option_17986494_Sepulveda op5 = new Option_17986494_Sepulveda(2, "2) 1 semana", 1, 2, op5keys);

        ArrayList<String> op6keys = new ArrayList<>(Arrays.asList("mes", "mensual", "month"));
        Option_17986494_Sepulveda op6 = new Option_17986494_Sepulveda(3, "3) 1 mes", 1, 2, op6keys);

        ArrayList<String> op7keys = new ArrayList<>(Arrays.asList("regresar", "salir", "volver"));
        Option_17986494_Sepulveda op7 = new Option_17986494_Sepulveda(4, "4) Volver", 0, 1, op7keys);

        //Opciones segundo flujo Chatbot1
        ArrayList<String> op8keys = new ArrayList<>(Arrays.asList("tarea","tareas", "task"));
        Option_17986494_Sepulveda op8 = new Option_17986494_Sepulveda(1, "1) 1 día", 1, 1, op8keys);

        ArrayList<String> op9keys = new ArrayList<>(Arrays.asList("eventos","events","evento"));
        Option_17986494_Sepulveda op9 = new Option_17986494_Sepulveda(2, "2) 1 semana", 1, 1, op9keys);

        ArrayList<String> op10keys = new ArrayList<>(Arrays.asList("cumpleaños", "cumples", "bday","cumple"));
        Option_17986494_Sepulveda op10 = new Option_17986494_Sepulveda(3, "3) 1 mes", 1, 1, op10keys);

        ArrayList<String> op11keys = new ArrayList<>(Arrays.asList("regresar", "salir", "volver"));
        Option_17986494_Sepulveda op11 = new Option_17986494_Sepulveda(4, "4) Volver", 0, 1, op11keys);

        //Flujos Chatbot 1
        ArrayList<Option_17986494_Sepulveda> flow2ops = new ArrayList<>(Arrays.asList(op4, op5, op6, op7));
        Flow_17986494_Sepulveda flow2 = new Flow_17986494_Sepulveda(1,"Flujo 1 Chatbot1\nElige ventana de tiempo del calendario",flow2ops);

        ArrayList<Option_17986494_Sepulveda> flow3ops = new ArrayList<>(Arrays.asList(op8, op9, op10, op11));
        Flow_17986494_Sepulveda flow3 = new Flow_17986494_Sepulveda(2,"Flujo 2 Chatbot1\n¿Deseas resaltar algo del calendario?",flow3ops);

        ArrayList<Flow_17986494_Sepulveda> chatbot1flows = new ArrayList<>(Arrays.asList(flow2,flow3));
        Chatbot_17986494_Sepulveda chatbot1 = new Chatbot_17986494_Sepulveda(1,"Calendario", "¿Que deseas hacer con el calendario?", 1,chatbot1flows);

        ////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////

        //Chatbot 2
        //Opciones primer flujo Chatbot1
        ArrayList<String> op12keys = new ArrayList<>(Arrays.asList("tareas", "task"));
        Option_17986494_Sepulveda op12 = new Option_17986494_Sepulveda(1, "1) Ver listado de tareas", 2, 2, op12keys);

        ArrayList<String> op13keys = new ArrayList<>(Arrays.asList("eventos","events"));
        Option_17986494_Sepulveda op13 = new Option_17986494_Sepulveda(2, "2) Agregar tarea", 2, 1, op13keys);

        ArrayList<String> op14keys = new ArrayList<>(Arrays.asList("cumpleaños", "cumples", "bday"));
        Option_17986494_Sepulveda op14 = new Option_17986494_Sepulveda(3, "3) Eliminar tarea", 2, 1, op14keys);

        ArrayList<String> op15keys = new ArrayList<>(Arrays.asList("regresar", "salir", "volver"));
        Option_17986494_Sepulveda op15 = new Option_17986494_Sepulveda(4, "4) Volver", 0, 1, op15keys);

        //Opciones segundo flujo Chatbot1
        ArrayList<String> op16keys = new ArrayList<>(Arrays.asList("prioridad","importancia"));
        Option_17986494_Sepulveda op16 = new Option_17986494_Sepulveda(1, "1) Por prioridad", 0,1, op16keys);

        ArrayList<String> op17keys = new ArrayList<>(Arrays.asList("tiempo","dia","fecha"));
        Option_17986494_Sepulveda op17 = new Option_17986494_Sepulveda(2, "2) Por fecha", 0, 1, op17keys);

        ArrayList<String> op18keys = new ArrayList<>(Arrays.asList("estado"));
        Option_17986494_Sepulveda op18 = new Option_17986494_Sepulveda(3, "3) Por estado", 0, 1, op18keys);

        ArrayList<String> op19keys = new ArrayList<>(Arrays.asList("regresar", "salir", "volver"));
        Option_17986494_Sepulveda op19 = new Option_17986494_Sepulveda(4, "4) Volver", 1, 1, op19keys);

        //Flujos Chatbot 2
        ArrayList<Option_17986494_Sepulveda> flow4ops = new ArrayList<>(Arrays.asList(op12, op13, op14, op15));
        Flow_17986494_Sepulveda flow4 = new Flow_17986494_Sepulveda(1,"Flujo 1 Chatbot2\n¿Que te gustaria hacer con las tareas?",flow4ops);

        ArrayList<Option_17986494_Sepulveda> flow5ops = new ArrayList<>(Arrays.asList(op16, op17, op18, op19));
        Flow_17986494_Sepulveda flow5 = new Flow_17986494_Sepulveda(2,"Flujo 2 Chatbot2\n¿De que forma quieres filtrar las tareas?",flow5ops);

        ArrayList<Flow_17986494_Sepulveda> chatbot2flows = new ArrayList<>(Arrays.asList(flow4,flow5));
        Chatbot_17986494_Sepulveda chatbot2 = new Chatbot_17986494_Sepulveda(2,"Tareas", "Bienvenido\n¿Que te gustaria hacer con las tareas?", 1,chatbot2flows);

        ////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////

        //Chatbot 3
        //Opciones primer flujo Chatbot3
        ArrayList<String> op20keys = new ArrayList<>(Arrays.asList("prioridad","importancia"));
        Option_17986494_Sepulveda op20 = new Option_17986494_Sepulveda(1, "1) Ver metas", 0,1, op20keys);

        ArrayList<String> op21keys = new ArrayList<>(Arrays.asList("tiempo","dia","fecha"));
        Option_17986494_Sepulveda op21 = new Option_17986494_Sepulveda(2, "2) Cambiar meta", 0, 1, op21keys);

        ArrayList<String> op22keys = new ArrayList<>(Arrays.asList("estado"));
        Option_17986494_Sepulveda op22 = new Option_17986494_Sepulveda(3, "3) Asignar meta", 0, 1, op22keys);

        ArrayList<String> op23keys = new ArrayList<>(Arrays.asList("regresar", "salir", "volver"));
        Option_17986494_Sepulveda op23 = new Option_17986494_Sepulveda(4, "4) Volver", 0, 1, op23keys);

        ArrayList<Option_17986494_Sepulveda> flow6ops = new ArrayList<>(Arrays.asList(op20, op21, op22, op23));
        Flow_17986494_Sepulveda flow6 = new Flow_17986494_Sepulveda(1,"Flujo 1 Chatbot3\n¿Que te gustaria hacer con las metas?",flow6ops);

        ArrayList<Flow_17986494_Sepulveda> chatbot3flows = new ArrayList<>(Arrays.asList(flow6));
        Chatbot_17986494_Sepulveda chatbot3 = new Chatbot_17986494_Sepulveda(3,"Metas", "\"Bienvenido\n¿Que te gustaria hacer con las metas?", 1,chatbot3flows);

        ////////////////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////    

        ArrayList<Chatbot_17986494_Sepulveda> systemchatbots = new ArrayList<>(Arrays.asList(chatbot0,chatbot1,chatbot2,chatbot3));
        System_17986494_Sepulveda demoSystem = new System_17986494_Sepulveda("Chatbot organizador", 0, systemchatbots);

        AdminUser_17986494_Sepulveda admin = new AdminUser_17986494_Sepulveda("admin");
        demoSystem.getUsers().add(admin);
        demoSystem.systemAddUser("user0");
        demoSystem.systemLogin("admin");
        
        return demoSystem;
    }
}