package LeetProblem;

import java.util.PriorityQueue;

public class MinimumCostToConnectStick {
    public int connectSticks(int[] sticks){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i=0;i<sticks.length;i++){
            pq.offer(sticks[i]);
        }
        int res=0;
        while(pq.size() != 1){
            int s1 = pq.poll();
            int s2 = pq.poll();
            res+=s1+s2;
            pq.offer(s1+s2);
        }
        return res;
    }
}
