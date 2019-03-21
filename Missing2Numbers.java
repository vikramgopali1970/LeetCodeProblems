package LeetProblem;

public class Missing2Numbers {

    public int[] missing2Numbers(int arr[]){
        if(arr.length == 0){
            return arr;
        }
        int tXor = 1;
        for(int i=1;i<=arr.length;i++){
            tXor = (arr[i-1]^i);
            System.out.print((tXor^0)+" ");
        }
//        for(int i=0;i<arr.length;i++){
//            System.out.print(arr[i]+" ");
//        }
        return new int[]{};
    }
}
