package Ejercicio_02_sign;

import materia.controllers.Stack;

public class StackSorter {
    public void stackSorter(Stack stack){
        Stack auxStack = new Stack();
        
        while(!stack.isEmpty()){
            int temp = stack.pop();
            while (!auxStack.isEmpty() && auxStack.peak() > temp) {
                stack.push(auxStack.pop());
            }
            auxStack.push(temp);
        }
        while (!auxStack.isEmpty()){
            stack.push(auxStack.pop());
        }
    }
}
