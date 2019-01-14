package LeetProblem;

import java.util.HashSet;

public class WorkSchedule {

    HashSet<String> set;

    public WorkSchedule(){
        set = new HashSet<String>();
    }

    private int getRemainingWorkHours(String pattern){
        int hours = 0;
        for (int i=0;i<pattern.length();i++){
            if(pattern.charAt(i) != '?'){
                hours += Character.digit(pattern.charAt(i),10);
            }
        }
        return hours;
    }

    public void schedule(String pattern, int work_hours, int work_day){
        char[] pp = pattern.toCharArray();
        int worked_hours = this.getRemainingWorkHours(pattern);
        this.scheduleHelperFunction(pp,0,(work_hours - worked_hours),work_day);
        System.out.println(this.set);
    }

    private void scheduleHelperFunction(char[] pp,int ind,int rsum, int work_day){
        if(ind < pp.length){
            if(rsum == 0 &&(new String(pp).indexOf('?') <0)){
                this.set.add(new String(pp));
                return;
            }
            if(pp[ind] == '?'){
                for(int i=0;i<=work_day;i++){
                    pp[ind] = Character.forDigit(i,10);
                    ind++;
                    rsum = rsum-i;
                    this.scheduleHelperFunction(pp,ind,rsum,work_day);
                    rsum = rsum+i;
                    ind--;
                    pp[ind] = '?';

                }
            }else{
                ind++;
                this.scheduleHelperFunction(pp,ind,rsum,work_day);
                ind--;
            }
        }else{
            return;
        }
    }
}
