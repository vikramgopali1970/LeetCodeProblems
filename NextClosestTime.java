package LeetProblem;

import java.util.HashSet;

public class NextClosestTime {

    public class Time{
        int hh;
        int mm;

        public Time(int hh,int mm){
            this.hh = hh;
            this.mm = mm;
        }

        public String toString(){
            String hh,mm;
            if(this.hh<10){
                hh="0"+this.hh;
            }else{
                hh = String.valueOf(this.hh);
            }
            if(this.mm<10){
                mm="0"+this.mm;
            }else{
                mm = String.valueOf(this.mm);
            }
            return hh+":"+mm;
        }
    }

    private boolean checkIfSameDigits(Time t, HashSet<Integer> set){
        String time = t.toString();
        for(int i=0;i<time.length();i++){
            if(time.charAt(i)!=':' && !set.contains(Character.getNumericValue(time.charAt(i)))){
                return false;
            }
        }
        return true;
    }

    public String nextClosestTime(String time) {
        // TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        int min = Integer.MAX_VALUE;
        Time t = new Time(Integer.parseInt(time.split(":")[0]),Integer.parseInt(time.split(":")[1]));
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i=0;i<time.length();i++){
            if(time.charAt(i) != ':'){
                if(min > Character.getNumericValue(time.charAt(i))){
                    min = Character.getNumericValue(time.charAt(i));
                }
                set.add(Character.getNumericValue(time.charAt(i)));
            }
        }
        int c = 0;
        while(c <= 1440){
            t.mm++;
            c++;
            if(t.mm%60 == 0){
                t.hh++;
                if(t.hh%24 == 0){
                    t.hh = 0;
                }
                t.mm = 0;
            }
            if(checkIfSameDigits(t,set)){
                return t.toString();
            }
        }
        return min+min+":"+min+min;
    }

}
