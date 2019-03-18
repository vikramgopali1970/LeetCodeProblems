package LeetProblem;

import java.util.Stack;

public class SortStack {
    private Stack<Integer> s = new Stack<Integer>();
    public SortStack(int[] arr){
        for(int i=0;i<arr.length;i++){
            this.s.push(arr[i]);
        }
    }

    public Stack<Integer> getS(){
        return this.s;
    }

    public Stack<Integer> stackSort(Stack<Integer> stack){
        if(stack == null || stack.size() < 2){
            return stack;
        }
        Stack<Integer> nStack = new Stack<Integer>();
        nStack.push(stack.pop());
        while(!stack.isEmpty()){
            Integer temp = stack.pop();
            while(!nStack.isEmpty() && temp > nStack.peek()){
                stack.push(nStack.pop());
            }
            nStack.push(temp);
        }
        return nStack;
    }

}
