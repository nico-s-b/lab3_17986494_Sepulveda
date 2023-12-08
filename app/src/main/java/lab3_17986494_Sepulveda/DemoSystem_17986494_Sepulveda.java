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

//Chatbot 0
ArrayList<String> op1keys = new ArrayList<>(Arrays.asList("fechas", "calendario", "dias"));
Option_17986494_Sepulveda op1 = new Option_17986494_Sepulveda(1, "1) Calendario", 1, 1, op1keys);

ArrayList<String> op2keys = new ArrayList<>(Arrays.asList("tareas","pendientes","tasks"));
Option_17986494_Sepulveda op2 = new Option_17986494_Sepulveda(2, "2) Tareas", 2, 1, op2keys);

ArrayList<String> op3keys = new ArrayList<>(Arrays.asList("fechas", "calendario", "dias"));
Option_17986494_Sepulveda op3 = new Option_17986494_Sepulveda(3, "3) Metas", 3, 1, op3keys);

ArrayList<Option_17986494_Sepulveda> flow1ops = new ArrayList<>(Arrays.asList(op1, op2, op3));
Flow_17986494_Sepulveda flow1 = new Flow_17986494_Sepulveda(1,"Flujo Principal Organizador\nBienvenido\n¿Qué te gustaría revisar",flow1ops);

ArrayList<Flow_17986494_Sepulveda> chatbot0flows = new ArrayList<>(Arrays.asList(flow1));
Chatbot_17986494_Sepulveda chatbot0 = new Chatbot_17986494_Sepulveda(0,"Inicial", "Bienvenido\n¿Qué te gustaría revisar", 1,chatbot0flows);

//Chatbot 1
//Opciones primer flujo Chatbot1
ArrayList<String> op4keys = new ArrayList<>(Arrays.asList("día", "diario"));
Option_17986494_Sepulveda op4 = new Option_17986494_Sepulveda(1, "1) 1 día", 1, 2, op4keys);

ArrayList<String> op5keys = new ArrayList<>(Arrays.asList("semana","semanal","week"));
Option_17986494_Sepulveda op5 = new Option_17986494_Sepulveda(2, "2) 1 semana", 1, 2, op5keys);

ArrayList<String> op6keys = new ArrayList<>(Arrays.asList("mes", "mensual", "month"));
Option_17986494_Sepulveda op6 = new Option_17986494_Sepulveda(3, "3) 1 mes", 1, 2, op6keys);

ArrayList<String> op7keys = new ArrayList<>(Arrays.asList("regresar", "salir", "volver"));
Option_17986494_Sepulveda op7 = new Option_17986494_Sepulveda(4, "4) Volver", 0, 1, op7keys);

//Opciones segundo flujo Chatbot1
ArrayList<String> op8keys = new ArrayList<>(Arrays.asList("tareas", "task"));
Option_17986494_Sepulveda op8 = new Option_17986494_Sepulveda(1, "1) 1 día", 1, 1, op8keys);

ArrayList<String> op9keys = new ArrayList<>(Arrays.asList("eventos","events"));
Option_17986494_Sepulveda op9 = new Option_17986494_Sepulveda(2, "2) 1 semana", 1, 1, op9keys);

ArrayList<String> op10keys = new ArrayList<>(Arrays.asList("cumpleaños", "cumples", "bday"));
Option_17986494_Sepulveda op10 = new Option_17986494_Sepulveda(3, "3) 1 mes", 1, 1, op10keys);

ArrayList<String> op11keys = new ArrayList<>(Arrays.asList("regresar", "salir", "volver"));
Option_17986494_Sepulveda op11 = new Option_17986494_Sepulveda(4, "4) Volver", 0, 1, op11keys);

//Flujos Chatbot 1
ArrayList<Option_17986494_Sepulveda> flow2ops = new ArrayList<>(Arrays.asList(op4, op5, op6, op7));
Flow_17986494_Sepulveda flow2 = new Flow_17986494_Sepulveda(1,"Flujo 1 Chatbot1\nElige ventana de tiempo del calendario",flow2ops);

ArrayList<Option_17986494_Sepulveda> flow3ops = new ArrayList<>(Arrays.asList(op8, op9, op10, op11));
Flow_17986494_Sepulveda flow3 = new Flow_17986494_Sepulveda(2,"Flujo 2 Chatbot1\n¿Deseas resaltar algo del calendario?",flow3ops);

ArrayList<Flow_17986494_Sepulveda> chatbot1flows = new ArrayList<>(Arrays.asList(flow2,flow3));
Chatbot_17986494_Sepulveda chatbot1 = new Chatbot_17986494_Sepulveda(0,"Calendario", "Elige ventana de tiempo del calendario", 1,chatbot1flows);

/*
%Chatbot2
%Flujo 1
option(1,"1) Ver listado de tareas",2,2,["ver","Listado","Tareas"],OP12),
option(2,"2) Añadir tarea",2,1,["agregar","añadir","add"],OP13),
option(3,"3) Eliminar tarea",2,1,["eliminar","borrar","remove"],OP14),
option(4,"4) Volver",0,1,["Regresar","Salir","Volver"],OP15),
%Flujo 2
option(1,"1) Por prioridad",0,1,["prioridad","importancia"],OP16),
option(2,"1) Por fecha",0,1,["tiempo","dia","fecha"],OP17),
option(3,"1) Por estado",0,1,["estado"],OP18),
option(4,"4) Volver",1,1,["Regresar","Salir","Volver"],OP19),
%Flujos Chatbot 2
flow(1,"Flujo 1 Chatbot2\n¿Qué te gustaría hacer con las tareas?",[OP12,OP13,OP14,OP15],F30),
flow(2,"Flujo 2 Chatbot2\n¿De qué forma quieres filtrar las tareas?",[OP16,OP17,OP18,OP19],F31),
chatbot(2,"Tareas" ,"Bienvenido\n¿Qué te gustaría hacer con las tareas?",1,[F30],CB2),
*/


}
