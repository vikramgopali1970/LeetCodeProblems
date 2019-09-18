package LeetProblem;

import java.util.Arrays;
import java.util.List;

public class Triangle {
    int[][] dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        return helper(triangle, 0, 0);
    }

    private int helper(List<List<Integer>> triangle,int row,int col){
        if(dp[row][col] != Integer.MAX_VALUE){
            return dp[row][col];
        }
        if(row >= triangle.size()-1){
            return triangle.get(row).get(col);
        }else{
            int min2 = Integer.MAX_VALUE;
            int min1 = helper(triangle,row+1,col);
            if(col+1 < triangle.get(row+1).size()){
                min2 = helper(triangle,row+1,col+1);
                dp[row][col] = Math.min(min1+triangle.get(row).get(col),min2+triangle.get(row).get(col));
                return dp[row][col];
            }else{
                dp[row][col] = Math.min(min1+triangle.get(row).get(col),min2);
                return dp[row][col];
            }
        }
    }
}
