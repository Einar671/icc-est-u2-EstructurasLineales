package materia.controllers;

import java.util.EmptyStackException;

import materia.models.Node;

public class Stack {
    
    private Node top;  
    private int size;

    public Stack(){
        this.top = null;
        this.size= 0;
    }

    public void push(int getValue){
        Node newNode = new Node(getValue);
        newNode.setNext(top);
        top = newNode;
        size++;
    }

    public int pop(){
        if(isEmpty()) throw new EmptyStackException();
        int value = top.getValue();
        top = top.getNext();
        size--;
        return value;
        

    }

    public boolean isEmpty(){
        return top == null;
    }

    public int peak(){
        if(isEmpty()) throw new EmptyStackException();
        return top.getValue();
    }

    public void printStack(){
        Node actual = top; 
        System.out.println("---- STACK ----");
         while (actual != null) {
            System.out.println("|   " + actual.getValue() + "   |");
            System.out.println("-----------");
            actual = actual.getNext();
        }
    }

    public void printSizeOn(){
        int contador=0;
        Node acNode = top;
        while(acNode != null){
            contador+=1;
            acNode = acNode.getNext();
        }
        System.out.println("Tam: "+contador);
    }

    public int printSizeO1(){
        return size;
    }

}
