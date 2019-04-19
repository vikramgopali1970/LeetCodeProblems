package LeetProblem;

public class PairsofSongsWithTotalDurationsDivisibleby60 {

    public int numPairsDivisibleBy60(int[] time) {
        int[] buckets = new int[60];
        int count=0;
        for(int i=0;i<time.length;i++){
            int t = time[i]%60;
            count += (t==0)?buckets[0]:buckets[60-t];
            buckets[t]++;
        }
        return count;
    }
}
