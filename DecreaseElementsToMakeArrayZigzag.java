package LeetProblem;

public class DecreaseElementsToMakeArrayZigzag {
    public int movesToMakeZigzag(int[] nums) {
        int ez = 0, oz = 0, ez1 = 0, oz1 = 0;
        for(int i=0;i<nums.length;i+=2){
            if(i==0){
                if(nums[i] >= nums[i+1]){
                    oz += nums[i] - (nums[i+1]-1);
                }
            }else if(i == nums.length - 1){
                if(nums[i] >= nums[i-1]){
                    oz += nums[i] - (nums[i-1] - 1);
                }
            }else{
                int min = Math.min(nums[i-1],nums[i+1]);
                int max = Math.max(nums[i-1],nums[i+1]);
                if(nums[i] >= min){
                    oz += nums[i] - (min-1);
                }
            }
        }
        for(int i=1;i<nums.length;i+=2){
            if(i == nums.length-1){
                if(nums[i] >= nums[i-1]){
                    oz1 += nums[i] - (nums[i-1] - 1);
                }
            }else{
                int min = Math.min(nums[i-1],nums[i+1]);
                int max = Math.max(nums[i-1],nums[i+1]);
                System.out.println(min+" "+max);
                if(nums[i] >= min){
                    ez1 += nums[i] - (min-1);
                }
            }
        }
        return Math.min(oz+ez,ez1+oz1);
    }
}
