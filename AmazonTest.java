package LeetProblem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class AmazonTest {

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

    public List<String> getRange(int[] arr){
        List<String> res = new ArrayList<String>();
        int s = arr[0];
        int e = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i] == s+1){
                e++;
            }else{
                if(s == e){
                    res.add(s+"");
                }else{
                    res.add(s+"->"+e);
                }
                s=arr[i];
                e=arr[i];
            }
        }
        if(s == e){
            res.add(s+"");
        }else{
            res.add(s+"->"+e);
        }
        return res;
    }
}