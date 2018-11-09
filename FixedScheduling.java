package LeetProblem;

import java.util.HashMap;

public class FixedScheduling {

    public int fixedScheduling(String s,int n){

        HashMap<Character,Integer> map = new HashMap<Character,Integer>();

        int time = 0;

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                int lastInd = map.get(c);
                while(time - lastInd <= n){
//                    System.out.print("*");
                    time++;
                }
//                System.out.print(c);
                map.put(c,time);
            }else{
                map.put(c,time);
//                System.out.print(c);
            }
            time++;
        }
        return time;
    }
}
