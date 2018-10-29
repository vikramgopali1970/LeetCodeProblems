package LeetProblem;

import java.util.*;

public class RemoveInvalidParanthesis {
    HashSet<String> result = new HashSet<>();
    StringBuilder strb = new StringBuilder();


    public List<String> removeInvalidParentheses(String s) {
        int lRem = 0;
        int rRem = 0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                lRem++;
            }else if(s.charAt(i) == ')'){
                rRem = (lRem == 0)?rRem+1:rRem;
                lRem = (lRem > 0)?lRem-1:lRem;
            }else{
                strb.append(s.charAt(i)+"");
            }
        }
        removeInvalidParanthesisHelper(s,0,rRem,lRem);
        if(this.result.isEmpty()){
            this.result.add(strb.toString());
            return new ArrayList<String>(this.result);
        }else{
            return new ArrayList<String>(this.result);
        }
    }


    private boolean validParenthesisChecker(String p) {
        Stack<Character> stc = new Stack<>();
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                stc.push('(');
            } else if (p.charAt(i) == ')') {
                if (!stc.empty()) {
                    stc.pop();
                } else {
                    return false;
                }
            }
        }
        return (stc.empty()) ? true : false;
    }

    public void removeInvalidParanthesisHelper(String str,int index, int rRem, int lRem) {
        if(this.validParenthesisChecker(str)){
            this.result.add(str);
        }
        if(index >= str.length()){
            return;
        }
        char c = str.charAt(index);
        if((c=='(' && lRem!=0)||(c==')' && rRem!=0)){
            String temp = str.substring(0, index) + str.substring(index + 1, str.length());
            this.removeInvalidParanthesisHelper(temp,index,rRem - ((c==')')?1:0), lRem - ((c=='(')?1:0));
        }
        this.removeInvalidParanthesisHelper(str,index+1,rRem,lRem);

    }
}
