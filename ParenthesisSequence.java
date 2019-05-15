package LeetProblem;

import java.util.Scanner;

public class ParenthesisSequence {
    public void printSequence(){
        Scanner sc = new Scanner(System.in);
        int len = Integer.parseInt(sc.nextLine());
        String ptr = sc.nextLine().trim();
        int o=len/2,c=len/2;

        char[] res = ptr.toCharArray();
        for(int i=0;i<ptr.length();i++){
            char ch = ptr.charAt(i);
            if(ch == '('){
                o--;
            }else if(ch == ')'){
                c--;
            }else{
                if(o-c < 1 && o>0){
                    res[i] = '(';
                    o--;
                }else{
                    res[i] = ')';
                    c--;
                }
            }
            if((o==c && i != ptr.length()-1) || (c<o) || (c<0) || (o<0)){
                System.out.println(":(");
                System.exit(1);
            }
        }
        System.out.println(String.valueOf(res));
    }
}
