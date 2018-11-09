package LeetProblem;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public int longestIncreasingSubsequenceLength(int[] arr){
        int max = -1;
        int[] lisCount = new int[arr.length];
        Arrays.fill(lisCount,1);

        for(int i=1;i<arr.length;i++){
            for (int j=0;j<i;j++){
                if(arr[i] > arr[j]){
                    lisCount[i] = Math.max(lisCount[j]+1,lisCount[i]);
                }
            }
            if(lisCount[i] > max){
                max = lisCount[i];
            }
        }
        return max;
    }

}
