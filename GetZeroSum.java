package LeetProblem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GetZeroSum {
    public List<List<Integer>> getZeroSum(int[] arr){
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        HashSet<Integer> cset = new HashSet<Integer>();
        for(int i=0;i<arr.length;i++){
            if(cset.contains(arr[i])){
                ArrayList<Integer> ans = new ArrayList<Integer>();
                ans.add(arr[i]);
                ans.add(0-arr[i]);
                set.add(ans);
            }
            cset.add(0-arr[i]);
        }
        return new ArrayList<>(set);
    }
}
