package LeetProblem;

public class MaximumContiguousSubArraySum {

    public int maxSubArray(int[] arr) {
        if(arr.length == 0){
            return 0;
        }
        int[] sum = new int[arr.length+1];
        sum[0] = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            sum[i+1] = Math.max(sum[i]+arr[i],arr[i]);
            if(sum[i+1]>maxSum){
                maxSum = sum[i+1];
            }
            System.out.print(sum[i+1]+" ");
        }
        return maxSum;
    }
}
