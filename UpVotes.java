package LeetProblem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UpVotes {

    private int getPatternCount(int[] arr, int l, int r, Comparator comp){
        int sum = 0;
        int[] temp = new int[l+r+1];
        temp[0] = 0;
        for(int i=l+1;i<r;i++){
            if(comp.compare(arr[i],arr[i-1]) <= 0){
                temp[i] = temp[i-1]+1;
            }else{
                temp[i] = 0;
            }
            sum += temp[i];
        }
        return sum;
    }

    private int getNonDescending(int[] arr,int l, int r){
        int sum = 0;
        int[] temp = new int[l+r+1];
        temp[0] = 0;
        for(int i=l+1;i<r;i++){
            if(arr[i] >=arr[i-1]){
                temp[i] = temp[i-1]+1;
            }else{
                temp[i] = 0;
            }
            sum += temp[i];
        }
        return sum;
    }

    private int getNonAscending(int[] arr,int l, int r){
        int sum = 0;
        int[] temp = new int[l+r+1];
        temp[0] = 0;
        for(int i=l+1;i<r;i++){
            if(arr[i] <=arr[i-1]){
                temp[i] = temp[i-1]+1;
            }else{
                temp[i] = 0;
            }
            sum += temp[i];
        }
        return sum;
    }

    public void upVotes(int n, int k,int[] arr){
        if(k ==0 || k > n){
            return;
        }
        for(int i=0;i<n-k+1;i++){
            int nonDecreasing = this.getNonDescending(arr,i,i+k);
            int nonIncreasing = this.getNonAscending(arr,i,i+k);
            System.out.println(nonDecreasing-nonIncreasing);
        }
    }
}
