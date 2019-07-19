package LeetProblem;

import java.util.HashMap;

public class LongestWellPerformingInterval {
    public int longestWPI(int[] hours) {
        int score=0;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<hours.length;i++){
            if(hours[i] > 8){
                score++;
            }else{
                score--;
            }
            if(score > 0){
                res = Math.max(res,i+1);
            }else{
                if(!map.containsKey(score)){
                    map.put(score,i);
                }
                if(map.containsKey(score-1)){
                    res = Math.max(res, i-map.get(score-1));
                }
            }
        }
        return res;
    }
}
