package LeetProblem;

import java.util.Stack;

public class LargestRectangleinHistogram {
    public int largestRectangleArea(int[] arr) {
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
}
