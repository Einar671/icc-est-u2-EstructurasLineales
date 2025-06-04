package materia.controllers;

import java.util.EmptyStackException;

import materia.models.NodeGeneric;

public class StackG<T> {
    private int size;
    private NodeGeneric<T> top;

    public StackG(){
        this.top = null;
        this.size = 0;
    }

    public void push(T getValue){
        NodeGeneric<T> node = new NodeGeneric<T>(getValue);
        node.setNext(top);
        top= node;
        size++;
    }
    public boolean isEmpty(){
        return top == null;
    }
    public T pop(){
        if(isEmpty()) throw new EmptyStackException();
        T value = top.getValue();
        top = top.getNext();
        size--;
        return value;
    }

    public T peak(){
        if(isEmpty()) throw new EmptyStackException();
        return top.getValue();
    }

    public void printStack(){
        NodeGeneric<T> actual = top; 
        System.out.println("---- STACK ----");
         while (actual != null) {
            System.out.println("|   " + actual.getValue() + "   |");
            System.out.println("-----------");
            actual = actual.getNext();
        }
    }

    public int printSize(){
        return size;
    }
}
