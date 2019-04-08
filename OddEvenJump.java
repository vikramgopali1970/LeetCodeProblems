package LeetProblem;

import java.util.TreeMap;

public class OddEvenJump {
    public int oddEvenJumps(int[] arr) {
        int n = arr.length;
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        boolean[] odd = new boolean[n];
        boolean[] even = new boolean[n];
        odd[n-1] = true;
        even[n-1] = true;
        map.put(arr[n-1],n-1);
        for(int i=n-1;i>=0;i--){
            if(map.containsKey(arr[i])){
                odd[i] = even[map.get(arr[i])];
                even[i] = odd[map.get(arr[i])];
            }else{
                Integer ind = map.ceilingKey(arr[i]);
                if(ind != null){
                    odd[i] = even[map.get(ind)];
                }
                ind = map.floorKey(arr[i]);
                if(ind != null){
                    even[i] = odd[map.get(ind)];
                }
            }
            map.put(arr[i],i);
        }
        int res = 0;
        for(int i=0;i<odd.length;i++){
            if(odd[i] == true){
                res++;
            }
        }
        return res;
    }
}
