package LeetProblem;

import java.util.HashMap;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(String word : paragraph.toLowerCase().split("[ !?',;.]+")){
            if(word.trim().length() != 0){
                int c = map.getOrDefault(word.toLowerCase(),0);
                map.put(word.toLowerCase(),c+1);
            }
        }
        for(int i=0;i<banned.length;i++){
            if(map.containsKey(banned[i])){
                map.remove(banned[i]);
            }
        }
        int max = Integer.MIN_VALUE;
        String res = "";
        for(String w : map.keySet()){
            if(map.get(w) > max){
                max = map.get(w);
                res = w;
            }
        }
        return res;
    }
}
