package LeetProblem;

public class HouseRobberII {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }else if(nums.length==1){
            return nums[0];
        }
        int[][] dp=new int[2][nums.length+2];
        for(int i=2;i<dp[0].length;i++){
            if(i==2){
                dp[0][i] = Math.max(dp[0][i-1],dp[0][i-2]+nums[i-2]);
            }else{
                dp[0][i] = Math.max(dp[0][i-1],dp[0][i-2]+nums[i-2]);
                dp[1][i] = Math.max(dp[1][i-1],dp[1][i-2]+nums[i-2]);
            }
        }
        return Math.max(dp[0][dp[0].length-2],dp[1][dp[0].length-1]);
    }
}
