package materia.controllers;

import java.util.EmptyStackException;

import materia.models.Node;
import materia.models.NodeGeneric;

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
}