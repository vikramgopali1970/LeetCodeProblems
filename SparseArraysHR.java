package LeetProblem;

import java.util.HashMap;

public class SparseArraysHR {

    public int[] getQueries(String[] words, String[] queries){
        HashMap<String,Integer> table = new HashMap<String,Integer>();
        for(int i=0;i<words.length;i++){
            int freq = table.getOrDefault(words[i],0);
            table.put(words[i],freq+1);
        }
        int[] result = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            result[i] = table.getOrDefault(queries[i],0);
        }
        return result;
    }
}
