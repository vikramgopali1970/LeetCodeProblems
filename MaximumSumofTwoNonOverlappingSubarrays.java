package LeetProblem;

public class MaximumSumofTwoNonOverlappingSubarrays {

    private int[] getCumulativeSum(int[] arr, int len){
        int[] cumArr = new int[arr.length-len+1];
        for(int i=0;i<cumArr.length;i++){
            int sum = 0;
            for(int j=0;j<len;j++){
                sum += arr[i+j];
            }
            cumArr[i] = sum;
        }
        return cumArr;
    }


    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int[] lArr = this.getCumulativeSum(A,L);
        int[] mArr = this.getCumulativeSum(A,M);

        int max = Integer.MIN_VALUE;
        for(int i=0;i<mArr.length;i++){
            for(int j=0;j<lArr.length;j++){
                if((j+L <= i) || (i+M <= j)){
                    max = Math.max(max,mArr[i]+lArr[j]);
                }
            }
        }
        return max;
    }
}
