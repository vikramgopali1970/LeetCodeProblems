package LeetProblem;

import java.util.Scanner;

public class WalkingRobot {

    public void maxPosition(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        int a = sc.nextInt();
        int[] path = new int[n+1];
        for(int i=1;i<n;i++){
            path[i] = sc.nextInt();
        }
        int ac = a;
        int bc = b;
        for(int i=0;i<path.length;i++){
            if((bc==0 && ac==0)){
                System.out.println(i);
                System.exit(0);
            }else if(path[i+1] == 0){
                if(ac > 0){
                    ac--;
                }else if(b>0){
                    bc--;
                }
            }else{
                if(bc > 0 && ac == a){
                    bc--;
                }else if(bc > 0 && ac < a){
                    bc--;
                    ac++;
                }
            }
        }
        System.out.println(n);
    }
}
