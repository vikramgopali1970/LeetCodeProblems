package LeetProblem;

import java.util.*;

public class Rahul {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    }

    public static int maxLCS(String s){
        int max = Integer.MIN_VALUE;
        HashMap<Character,Integer> gmap = new HashMap<Character,Integer>();
        HashMap<Character,Integer> rmap = new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            int count = gmap.getOrDefault(s.charAt(i),0);
            gmap.put(s.charAt(i),count+1);
        }
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int rCount = rmap.getOrDefault(c,0);
            rCount++;
            rmap.put(c,rCount);
            int gCount = gmap.get(c);
            gCount--;
            gmap.put(c,gCount);
            if(gCount == 0){
                gmap.remove(c);
            }
            int sum=0;
            for(char ch : rmap.keySet()){
                if(gmap.containsKey(ch)){
                    sum += Math.min(rmap.get(ch),gmap.get(ch));
                }
            }
            max = Math.max(max,sum);
        }
        System.out.println(max);
        return (max==Integer.MIN_VALUE)?0:max;
    }
}


// "abcdecdefg"
// "abcdedeara"