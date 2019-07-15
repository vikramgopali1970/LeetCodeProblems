package LeetProblem;

import java.util.Arrays;

public class RelativeSortArray {
    private void swap(int[] arr, int ind1, int ind2){
        int temp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = temp;
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int sptr = 0;
        for(int i=0;i<arr2.length;i++){
            for(int j=sptr;j<arr1.length && sptr < arr1.length;j++){
                if(arr1[j] == arr2[i]){
                    this.swap(arr1,sptr,j);
                    sptr++;
                }
            }
        }
        Arrays.sort(arr1, sptr, arr1.length);
        return arr1;
    }
}