package LeetProblem;

public class MaximumSubarraySumwithOneDeletion {
    public int maximumSum(int[] arr) {
        if(arr.length == 0){
            return 0;
        }
        int sumwodel = arr[0];
        int sumwselfdel = 0;
        int sumwotherdel = 0;
        int max = sumwodel;
        for(int i=1;i<arr.length;i++){
            int prev_sumwodel = sumwodel, prev_sumwselfdel = sumwselfdel, prev_sumwotherdel=sumwotherdel;
            sumwodel = Math.max(prev_sumwodel+arr[i],arr[i]);
            sumwselfdel = prev_sumwodel;
            sumwotherdel = Math.max(arr[i]+prev_sumwselfdel,arr[i]+prev_sumwotherdel);
            max = Math.max(sumwselfdel,max);
            max = Math.max(sumwotherdel,max);
            max = Math.max(sumwodel,max);
        }
        return max;
    }
}
