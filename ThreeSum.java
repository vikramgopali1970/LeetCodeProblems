package LeetProblem;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<List<Integer>>();
        for(int i=0;i<=nums.length-3;i++){
            int j=i+1;
            int k = nums.length-1;
            while(j<k){
                if(nums[j]+nums[k] == -nums[i]){
                    ArrayList<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    res.add(temp);
                    j++;
                    k--;
                }else if(nums[j]+nums[k] > -nums[i]){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return new ArrayList<List<Integer>>(res);
    }
}
