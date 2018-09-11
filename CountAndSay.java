package LeetProblem;

import java.util.LinkedList;
import java.util.Queue;

public class CountAndSay {

    private Queue<Integer> countEle(Queue<Integer> q1){
        Queue<Integer> q2 = new LinkedList<>();
        int ele = q1.poll();
        int count = 1;
        while(q1.size() != 0){
            if(ele == q1.peek()){
                q1.poll();
                count++;
            }else{
                q2.add(count);
                q2.add(ele);
                ele = q1.poll();
                count=1;
            }
        }
        q2.add(count);
        q2.add(ele);
        return q2;
    }

    public String CountAndSaySoln(int n){
        Queue<Integer> q1 = new LinkedList<>();
        q1.add(1);
        if(n==1){
            return "1";
        }else{
            for(int i=0;i<n-1;i++){
                q1 = countEle(q1);
            }
        }
        String res = "";
        for (Integer s : q1)
            res = res+Integer.toString(s);
        return res;
    }
}
