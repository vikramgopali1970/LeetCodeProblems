package LeetProblem;

import java.util.TreeMap;

public class NextBigElement {
    public int[] nextBigElement(int[] arr){
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        int[] res = new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            if(map.ceilingKey(arr[i]) == null){
                res[i] = -1;
            }else{
                res[i] = map.ceilingKey(arr[i]);
            }
            map.put(arr[i],i);
        }
        for(int i=0;i<res.length;i++){
            System.out.print(res[i]+" ");
        }
        return res;
    }
}
