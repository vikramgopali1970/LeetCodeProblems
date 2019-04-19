package LeetProblem;

import java.util.HashMap;
import java.util.HashSet;

public class FindtheTownJudge {
    //fast
    public int findJudge(int N, int[][] trust) {
        int[] res = new int[N+1];
        for(int i=0;i<trust.length;i++){

            res[trust[i][0]]--;
            if(res[trust[i][1]] >= 0){
                res[trust[i][1]]++;
            }
        }
        for(int i=1;i<res.length;i++){
            if(res[i]==N-1){
                return i;
            }
        }
        return -1;
    }

    //my slow
    public int findJudgeMine(int N, int[][] trust) {
        HashMap<Integer, HashSet<Integer>> adl = new HashMap<Integer,HashSet<Integer>>();
        for(int i=0;i<trust.length;i++){
            HashSet<Integer> t = adl.getOrDefault(trust[i][0],new HashSet<Integer>());
            t.add(trust[i][1]);
            adl.put(trust[i][0],t);
        }
        int judge = -1;
        for(int i=1;i<=N;i++){
            if(!adl.containsKey(i)){
                judge=i;
            }
        }
        if(judge != -1){
            for(int k : adl.keySet()){
                if(!adl.get(k).contains(judge)){
                    return -1;
                }
            }
            return judge;
        }
        return -1;
    }
}
