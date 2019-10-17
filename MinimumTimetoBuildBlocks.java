package LeetProblem;

import java.util.*;

public class MinimumTimetoBuildBlocks {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++){
            minDiff = Math.min(minDiff,Math.abs(arr[i]-arr[i-1]));
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i=1;i<arr.length;i++){
            if(arr[i]-arr[i-1] == minDiff){
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(arr[i-1]);
                temp.add(arr[i]);
                res.add(temp);
            }
        }
        return res;
    }
}
