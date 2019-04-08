package LeetProblem;

import java.util.TreeMap;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0){
            return new int[]{};
        }
        int s=0;
        int e = 0;
        int max = Integer.MIN_VALUE;
        int[] res = new int[nums.length-k+1];
        TreeMap<Integer,Integer> tmap = new TreeMap<Integer,Integer>();
        int ind = 0;
        while(e<nums.length){
            tmap.put(nums[e],e);

            if(e-s+1 > k){
                if(tmap.containsKey(nums[s]) && tmap.get(nums[s]) == s){
                    tmap.remove(nums[s]);
                }
                s++;
            }else{
                if(!tmap.isEmpty() && (e-s+1)==k){
                    res[ind++] = tmap.lastKey();
                }
                e++;
            }
        }
        return res;
    }
}
