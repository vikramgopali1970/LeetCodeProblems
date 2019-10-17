package LeetProblem;

import java.util.Scanner;

public class Namra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Integer[] arr = new Integer[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        solution(arr,k);
    }

    private static Integer[] solution(Integer[] N, int K){
        Integer[] res = new Integer[K];
        for(int i=0;i<K;i++){
            res[i] = N[i];
        }

        for(int i=1;i<=N.length-K;i++){
            boolean copy = false;
            for(int j=0;j<K;j++){
                if(j==0 && res[j] > N[j+i]){
                    break;
                }else{
                    if(N[j+i] > res[j]){
                        copy = true;
                    }
                    if(copy){
                        res[j] = N[j+i];
                    }
                }

            }
        }
        for(int i=0;i<K;i++){
            System.out.print(res[i]+" ");
        }
        return res;
    }
}
