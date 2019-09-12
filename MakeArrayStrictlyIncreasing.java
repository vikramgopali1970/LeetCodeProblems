package LeetProblem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

public class MakeArrayStrictlyIncreasing {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        int res = recursiveHelper(arr1, Arrays.stream(arr2).distinct().sorted().toArray(), 0, Integer.MIN_VALUE, new HashMap<>());
        System.out.println(res);
        return (res==Integer.MAX_VALUE)?-1:res;
    }

    private int recursiveHelper(int[] a1, int[] a2, int ind,int prev, HashMap<Integer,Integer> map){
        int key = Objects.hash(ind, prev);
        if(map.containsKey(key)){
            return map.get(key);
        }
        if(ind >= a1.length){
            return 0;
        }
        int i = Arrays.binarySearch(a2,prev);
        i = ((i<0)?-(i+1):i+1);
        int res1 = Integer.MAX_VALUE;
        int res2 = Integer.MAX_VALUE;
        if(i < a2.length){
            res2 = recursiveHelper(a1,a2,ind+1,a2[i],map);
            if(res2 != Integer.MAX_VALUE){
                ++res2;
            }
        }
        if(a1[ind] > prev){
            res1 = recursiveHelper(a1,a2,ind+1,a1[ind],map);
        }
        int ans  = Math.min(res1,res2);
        map.put(key,ans);
        return map.get(key);
    }
}
