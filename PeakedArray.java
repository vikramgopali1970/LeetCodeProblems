package LeetProblem;

public class PeakedArray {

    private int PeekedArr(int[] arr,int strt, int end){
        if (strt==end-1){
            return Integer.max(arr[strt],arr[end]);
        }
        int mid = (strt+end)/2;
        if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
            return arr[mid];
        }else if(arr[mid] > arr[mid-1] && arr[mid+1] > arr[mid]){
            System.out.println("start is "+strt+" end is "+end+ " mid is "+mid);
            return PeekedArr(arr,mid,end);
        }else{
            return PeekedArr(arr,strt,mid);
        }
    }



    public int execAlg(int[] arr,int strt,int end){
        return PeekedArr(arr,strt,end);
    }
}
