package Ejercicio_01_sign;

import materia.controllers.StackG;

public class SignValidator {

    public boolean isValid(String s) {
        StackG<Character> stack = new StackG<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                
                char lastOpen = stack.pop();
                
                if (!isMatchingPair(lastOpen, c)) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    
    private boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '{' && close == '}') ||
               (open == '[' && close == ']');
    } 
    
}
