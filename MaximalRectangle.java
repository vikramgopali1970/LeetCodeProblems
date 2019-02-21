package LeetProblem;

import java.util.Stack;

public class MaximalRectangle {

    private int maxAreaRect(int[] arr){
        int maxArea = 0;
        Stack<Integer> s = new Stack<Integer>();
        for(int i=0;i<arr.length;i++){
            if(s.isEmpty() || arr[s.peek()] <= arr[i]){
                s.push(i);
            }else{
                int area = 0;
                int top = s.pop();
                if(s.isEmpty()){
                    area = arr[top] * i;
                }else{
                    area = arr[top] * (i-s.peek()-1);
                }
                if(area > maxArea){
                    maxArea = area;
                }
                i--;
            }
        }
        while(!s.isEmpty()){
            int area = 0;
            int top = s.pop();
            if(s.isEmpty()){
                area = arr[top] * arr.length;
            }else{
                area = arr[top] * (arr.length-s.peek()-1);
            }
            if(area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        int maxArea = 0;
        int[] colMat = new int[matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                colMat[j] = (matrix[i][j] == '0')?0:colMat[j]+Character.getNumericValue(matrix[i][j]);
            }
            maxArea = Math.max(maxArea,this.maxAreaRect(colMat));
        }
        return maxArea;
    }

}
