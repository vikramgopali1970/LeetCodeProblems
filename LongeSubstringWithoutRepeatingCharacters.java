package LeetProblem;

import java.util.HashMap;

public class LongeSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String str) {
        if(str.length() < 2){
            return str.length();
        }
        int s=0,e=0,max=Integer.MIN_VALUE;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        while(e<str.length()){
            char c = str.charAt(e);
            if(map.containsKey(c) && map.get(c)+1 > s){
                s=map.get(c)+1;
            }
            map.put(c,e);
            max = Math.max(max,e-s+1);
            e++;
        }
        return max;
    }
}
