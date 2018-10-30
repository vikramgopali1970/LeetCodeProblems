package LeetProblem;

import java.util.Arrays;

class MeetingRooms2 {

    private Interval[] intervals;

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public MeetingRooms2(int[] start,int[] end){
        if(start.length == end.length){
            this.intervals = new Interval[start.length];
            for(int i=0;i<start.length;i++){
                this.intervals[i] = new Interval(start[i],end[i]);
            }
        }else{
            throw new Error();
        }
    }

    public int minMeetingRooms(){
        int[] start = new int[this.intervals.length];
        int[] end = new int[this.intervals.length];
        int rooms = 0;
        for(int i=0;i<this.intervals.length;i++){
            start[i] = this.intervals[i].start;
            end[i] = this.intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int i=0;
        int j=0;
        while(i<start.length){
            if(start[i] >= end[j]){
                rooms--;
                j++;
            }
            rooms++;
            i++;
        }
        return rooms;
    }

}