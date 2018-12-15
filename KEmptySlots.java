package LeetProblem;

import java.util.HashSet;

public class KEmptySlots {
    HashSet<Integer> set;
    public KEmptySlots(){
        this.set  = new HashSet<Integer>();
    }

    public int kEmptySlotsSolution(int[] flowers, int k) {
        for(int i=0;i<flowers.length;i++){
            if( i!=0 && !isBetweenPresent(flowers[i],k)){
                return i+1;
            }else{
                this.set.add(flowers[i]);
            }
        }
        return -1;
    }

    private boolean isBetweenPresent(int e,int k){
        int s1 = e-k-1;
        int s2 = e+k+1;
        if(s1>=0 && set.contains(s1)){
            for(int i=s1+1;i<e;i++){
                if(this.set.contains(i)){
                    return true;
                }
            }
            return false;
        }
        if(s2>=0 && set.contains(s2)){
            for(int i=e+1;i<s2;i++){
                if(this.set.contains(i)){
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}
