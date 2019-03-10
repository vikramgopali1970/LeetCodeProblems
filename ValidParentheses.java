package LeetProblem;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0){
            return false;
        }
        if(s.length() == 0){
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '[' || c == '{' || c=='('){
                stack.push(c);
            }else{
                if(stack.size() > 0){
                    char cc = stack.pop();
                    if(cc == '[' && c != ']'){
                        return false;
                    }else if(cc == '{' && c != '}'){
                        return false;
                    }else if(cc == '(' && c != ')'){
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }

        return !(stack.size() > 0);
    }
}
