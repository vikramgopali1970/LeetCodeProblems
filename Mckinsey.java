package LeetProblem;

import java.util.*;

public class Mckinsey {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        List<List<Integer>> inp = new ArrayList<List<Integer>>();
        for(int i=0;i<r;i++){
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(sc.nextInt());
            temp.add(sc.nextInt());
            inp.add(temp);
        }
        countNumbers(inp);
    }

    private static void countNumbers(List<List<Integer>> arr) {
        int[] start = new int[arr.size()];
        int[] end = new int[arr.size()];
        for(int i=0;i<arr.size();i++){
            start[i] = arr.get(i).get(0);
            end[i] = arr.get(i).get(1);
        }
        List<List<Integer>> merge = new ArrayList<List<Integer>>();
        Arrays.sort(start);
        Arrays.sort(end);
        int s=0,e=0;
        while(e<end.length-1){
            if(end[e] >= start[e+1]){
                e++;
            }else{
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(start[s]);
                temp.add(end[e]);
                merge.add(temp);
                e++;
                s=e;
            }
        }
        if(s < start.length && e < end.length){
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(start[s]);
            temp.add(end[e]);
            merge.add(temp);
        }
        System.out.println(merge);
    }

    private static void solution(int[] inp){
        int n = inp.length;
        int cols = inp[0];
        int rows = (inp.length-1)/cols;
        int[][] arr = new int[rows][cols];

        int r=0,c=0;
        for(int i=1;i<inp.length;i++){
            arr[r][c] = inp[i];
            c++;
            if(c == cols){
                c=0;
                r++;
            }
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}


/*



13
4
1 2 3 4 5 6 7 8 9 10 11 12



 */