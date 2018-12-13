package LeetProblem;

import java.util.HashMap;

public class LongestSubstringwithTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length()<=2){
            return s.length();
        }
        int start = 0;
        int end = start+1;
        int maxLen = Integer.MIN_VALUE;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        map.put(s.charAt(0),0);
        char prevChar = s.charAt(0);
        for(int i=1;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                if(prevChar != c){
                    map.put(c,i);
                }
            }else{
                if(map.size() == 2){
                    if(end-start > maxLen){
                        maxLen = end-start;
                    }
                    start = map.get(prevChar);
                    map.clear();
                    map.put(prevChar,start);
                }
                map.put(c,i);
            }
            prevChar = c;
            end++;
        }
        if(end-start > maxLen){
            maxLen = end-start;
        }
        return maxLen;
    }
}
