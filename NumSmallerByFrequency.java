package LeetProblem;

import java.util.TreeSet;

public class NumSmallerByFrequency {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        TreeSet<Integer> qset = new TreeSet<Integer>();
        TreeSet<Integer> wset = new TreeSet<Integer>();
        for(int i=0;i<words.length;i++){
            int[] f = new int[26];
            for(int j=0;j<words[i].length();j++){
                char c = words[i].charAt(j);
                f[c-'a']++;
            }
            for(int j=0;j<26;j++){
                if(f[j] > 0){
                    wset.add(f[j]);
                    break;
                }
            }
        }
        int[] q = new int[queries.length];
        int[] res = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int[] f = new int[26];
            for(int j=0;j<queries[i].length();j++){
                char c = queries[i].charAt(j);
                f[c-'a']++;
            }
            for(int j=0;j<26;j++){
                if(f[j] > 0){
                    q[i] = f[j];
                    break;
                }
            }
        }
        for(int i=0;i<q.length;i++){
            res[i] = wset.headSet(q[i]).size();
        }
        System.out.println(wset);
        return res;
    }
}
