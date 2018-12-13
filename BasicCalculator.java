package LeetProblem;

import java.util.Stack;

public class BasicCalculator {

    Stack<Integer> vs;
    Stack<Character> os;

    public BasicCalculator(){
        this.vs = new Stack<Integer>();
        this.os = new Stack<Character>();
    }

    public void performCalculations(int op1,int op2,char sw){
        switch(sw){
            case '+':this.vs.push(op1+op2);
                break;
            case '-':this.vs.push(op1-op2);
                break;
        }
    }

    public boolean preced(char op1,char op2){
        if(op1 == '+' && op2 == '-'){
            return false;
        }else if(op1 == '-' && op2 == '+'){
            return false;
        }else{
            return true;
        }
    }

    public int calculate(String s){
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == ' '){
                continue;
            }else if(c>='0' && c<='9'){
                vs.push(Character.getNumericValue(c));
            }else {
                if(c == ')'){
                    System.out.println(this.vs+"    "+this.os);
                    while(this.os.peek() != '('){
                        int op2 = this.vs.pop();
                        int op1 = this.vs.pop();
                        char sw = this.os.pop();
                        this.performCalculations(op1,op2,sw);
                    }
                    this.os.pop();
                    System.out.println(this.vs.peek());
                }else{
                    if(this.os.isEmpty()){
                        this.os.push(c);
                    }else if(preced(c,os.peek())){
                        this.os.push(c);
                    }else{
                        while(!this.os.isEmpty() && !preced(c,os.peek())){
                            int op2 = this.vs.pop();
                            int op1 = this.vs.pop();
                            char sw = this.os.pop();
                            this.performCalculations(op1,op2,sw);
                        }
                        this.os.push(c);
                    }
                }

            }
        }
        while(!this.os.isEmpty() && !this.vs.isEmpty()){

            int op2 = this.vs.pop();
            int op1 = this.vs.pop();
            char sw = this.os.pop();
            this.performCalculations(op1,op2,sw);
        }

        return this.vs.pop();
    }
}
