package LeetProblem;

public class CombinationSum {

    /**
     * for all the amounts from 0 to total we calculate individually what is the cost:
     * for each coin in set, we check in how many ways can the amount from 1 to total can be
     * achieved.
     * ref video : https://www.youtube.com/watch?v=jaNZ83Q3QGc
     * @param arr
     * @param total
     * @return
     */
    private int count(int[] arr,int total){
        int[] comb = new int[total+1];
        comb[0] = 1;
        for (int i=0;i<arr.length;i++){
            for(int j=1;j<comb.length;j++){
                if(j >= arr[i]){
                    comb[j] += comb[j - arr[i]];
                }
            }
        }
        return comb[comb.length-1];
    }

    public int execAlgo(int[] arr, int tot){
        return count(arr,tot);
    }

}
