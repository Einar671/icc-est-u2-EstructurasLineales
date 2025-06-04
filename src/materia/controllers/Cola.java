package materia.controllers;

import java.util.EmptyStackException;

import materia.models.Node;
import materia.models.NodeGeneric;
import materia.models.Persona;

public class Cola<T> {
    
    private int size;
    private NodeGeneric<T> primero;
    private NodeGeneric<T> ultimo;

    public Cola(){
        this.primero = null;
        this.ultimo = null;
        this.size = 0;
    }

    public void add(T value){
        NodeGeneric<T> newnode = new NodeGeneric<T>(value);
        if(isEmpty()){
            primero = newnode;
            ultimo = newnode;
        }else{
            ultimo.setNext(newnode);
            ultimo = newnode;
        }
        size++;
    }

    public T remove(){
        if(isEmpty()) throw new EmptyStackException();
        T value = primero.getValue();
        primero = primero.getNext();
        size--;
        return value;
    }

    public T peak(){
        if(isEmpty()) throw new EmptyStackException();
        T value = primero.getValue();
        return value;
    }

    public boolean isEmpty(){
        return primero == null;
    }

    public int size(){
        return size;
    }
    public void printQueue(){
        NodeGeneric<T> actuNode = primero;
        System.out.println("---- STACK ----");
         while (actuNode != null) {
            System.out.println("|   " + actuNode.getValue() + "   |");
            System.out.println("-----------");
            actuNode = actuNode.getNext();
        }
    }

    /**
 * Busca una persona por nombre en la cola
 * @param nombre El nombre de la persona a buscar
 * @return La persona encontrada o null si no existe
 */
public T buscarPersona(String nombre) {
    if (isEmpty()) return null;
    
    NodeGeneric<T> actual = primero;
    while (actual != null) {
        T valor = actual.getValue();
        // Verificamos si es una instancia de Persona y si el nombre coincide
        if (valor instanceof Persona) {
            Persona persona = (Persona) valor;
            if (persona.getNombre().equalsIgnoreCase(nombre)) {
                return valor;
            }
        }
        actual = actual.getNext();
    }
    return null; // No encontrado
}

/**
 * Elimina una persona específica de la cola por nombre
 * @param nombre El nombre de la persona a eliminar
 * @return true si se eliminó, false si no se encontró
 */
public boolean eliminarPersona(String nombre) {
    if (isEmpty()) return false;
    
    if (primero.getValue() instanceof Persona) {
        Persona personaPrimero = (Persona) primero.getValue();
        if (personaPrimero.getNombre().equalsIgnoreCase(nombre)) {
            primero = primero.getNext();
            if (primero == null) { // Si era el único elemento
                ultimo = null;
            }
            size--;
            return true;
        }
    }
    
    NodeGeneric<T> actual = primero;
    while (actual.getNext() != null) {
        T valorSiguiente = actual.getNext().getValue();
        if (valorSiguiente instanceof Persona) {
            Persona persona = (Persona) valorSiguiente;
            if (persona.getNombre().equalsIgnoreCase(nombre)) {
                NodeGeneric<T> nodoAEliminar = actual.getNext();
                actual.setNext(nodoAEliminar.getNext());
                
                if (nodoAEliminar == ultimo) {
                    ultimo = actual;
                }
                
                size--;
                return true;
            }
        }
        actual = actual.getNext();
    }
    
    return false;
}


public boolean existePersona(String nombre) {
    return buscarPersona(nombre) != null;
}

public int obtenerPosicionPersona(String nombre) {
    if (isEmpty()) return -1;
    
    NodeGeneric<T> actual = primero;
    int posicion = 0;
    
    while (actual != null) {
        T valor = actual.getValue();
        if (valor instanceof Persona) {
            Persona persona = (Persona) valor;
            if (persona.getNombre().equalsIgnoreCase(nombre)) {
                return posicion;
            }
        }
        actual = actual.getNext();
        posicion++;
    }
    
    return -1;
}
}