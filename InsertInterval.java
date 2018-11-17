package LeetProblem;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public class Interval{
        int start;
        int end;
        public Interval(){}
        public Interval(int start,int end){
            this.end = end;
            this.start = start;
        }

        public String toString(){
            StringBuilder str = new StringBuilder();
            str.append("[");
            str.append(this.start+","+this.end);
            str.append("]");
            return str.toString();
        }
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
        if(intervals.size() == 0){
            result.add(newInterval);
            return result;
        }
        boolean newMerged = false;
        for(Interval interval : intervals){
            if(newMerged){
                result.add(interval);
            }else if(interval.start > newInterval.end){
                result.add(newInterval);
                newMerged = true;
                result.add(interval);
            }else if(interval.end < newInterval.start){
                result.add(interval);
            }else{
                newInterval.start = Math.min(interval.start,newInterval.start);
                newInterval.end = Math.max(interval.end,newInterval.end);
            }
        }
        if(!newMerged){
            result.add(newInterval);
        }
        return result;
    }
}
