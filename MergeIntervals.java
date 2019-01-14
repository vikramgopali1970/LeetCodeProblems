package LeetProblem;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

public class MergeIntervals {

    public class Interval{
        private int start;
        private int end;

        public Interval(int start,int end){
            this.start = start;
            this.end = end;
        }
    }

    public List<Interval> mergeIntervals(List<Interval> intervals){
        if(intervals.size() == 0 || intervals.size() == 1){
            return intervals;
        }
        Stack<Interval> s = new Stack<Interval>();
        Collections.sort(intervals,new Comparator<Interval>(){
            public int compare(Interval i1,Interval i2){
                return Integer.compare(i1.start,i2.start);
            }
        });

        s.push(intervals.get(0));
        for(int i=1;i<intervals.size();i++){
            Interval sEle = s.peek();
            Interval next = intervals.get(i);
            if(next.start<=sEle.end && next.start>=sEle.start){
                Interval newEle = new Interval(Math.min(sEle.start,next.start),Math.max(sEle.end,next.end));
                s.pop();
                s.push(newEle);
            }else{
                s.push(next);
            }
        }

        return new ArrayList(s);
    }
}
