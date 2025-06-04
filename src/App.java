import java.util.Queue;

import materia.controllers.Cola;
import materia.controllers.Stack;
import materia.controllers.StackG;
import materia.models.Persona;


public class App {
    public static void main(String[] args) throws Exception {

       /*Cola cola = new Cola();
        cola.add(5);
        cola.add(7);
        cola.add(3);
        System.out.println("Tam: "+cola.size);
        cola.printQueue();
        System.out.println("Elemento eliminado: "+cola.remove());
        System.out.println("Elemento peak: "+cola.peak());
        cola.prin*/
       
        /*Stack stack = new Stack();
        StackG<Integer> stackGint = new StackG<Integer>();
        stackGint.push(5);
        stackGint.push(-1);
        stackGint.push(0);
        stackGint.push(5);
        stackGint.printStack();
        System.out.println("tam: "+stackGint.printSize());
        stackGint.pop();
        System.out.println(" Elemento peak: "+ stackGint.peak());
        

        StackG<String> stackGStr = new StackG<String>();
        stackGStr.push("Carro");
        stackGStr.push("Avion");        
        stackGStr.push("Bus");
        stackGStr.push("Carro");
        stackGStr.printStack();
        System.out.println("tam: "+stackGStr.printSize());
        stackGStr.pop();
        System.out.println(" Elemento peak: "+ stackGStr.peak()); */

        /*stack.push(10);
        stack.push(-1);
        stack.push(0);
        stack.push(5);
        stack.printStack();
        stack.printSizeOn();
        System.out.println("tam: "+stack.printSizeO1());
        stack.pop();
        System.out.println("Elemento buscado: "+stack.peak());
        System.out.println("tam: "+stack.printSizeO1());
        stack.printSizeOn();
        stack.printStack();*/

    Persona p1 = new Persona("Pablo");
    Persona p2 = new Persona("Juan");
    Persona p3 = new Persona("Maria");
    Persona p4 = new Persona("Carlos");

    Cola<Persona> colaPersonas = new Cola<Persona>();
    colaPersonas.add(p1);
    colaPersonas.add(p2);
    colaPersonas.add(p3);
    colaPersonas.add(p4);
    
    System.out.println("Cola inicial:");
    System.out.println("Tamaño: " + colaPersonas.size());
    colaPersonas.printQueue();
    
    System.out.println("\n--- BÚSQUEDA DE PERSONAS ---");
    Persona encontrada = colaPersonas.buscarPersona("Juan");
    if (encontrada != null) {
        System.out.println("Persona encontrada: " + encontrada);
    } else {
        System.out.println("Persona no encontrada");
    }
    
    System.out.println("¿Existe Maria? " + colaPersonas.existePersona("Maria"));
    System.out.println("¿Existe Pedro? " + colaPersonas.existePersona("Pedro"));
    
    int posicion = colaPersonas.obtenerPosicionPersona("Carlos");
    System.out.println("Carlos está en la posición: " + posicion);
    
    System.out.println("\n--- ELIMINACIÓN DE PERSONAS ---");
    boolean eliminado = colaPersonas.eliminarPersona("Juan");
    if (eliminado) {
        System.out.println("Juan fue eliminado de la cola");
    } else {
        System.out.println("Juan no fue encontrado");
    }
    
    System.out.println("\nCola después de eliminar a Juan:");
    System.out.println("Tamaño: " + colaPersonas.size());
    colaPersonas.printQueue();
    
    boolean eliminado2 = colaPersonas.eliminarPersona("Pedro");
    System.out.println("¿Se eliminó Pedro? " + eliminado2);
    
    boolean eliminado3 = colaPersonas.eliminarPersona("Pablo");
    System.out.println("¿Se eliminó Pablo? " + eliminado3);
    
    System.out.println("\nCola final:");
    System.out.println("Tamaño: " + colaPersonas.size());
    colaPersonas.printQueue();

    }
   
}
