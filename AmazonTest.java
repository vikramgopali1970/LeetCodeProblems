package LeetProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class AmazonTest {

    public List<List<Integer>> getZeroSum(int[] arr){
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        HashSet<Integer> cset = new HashSet<Integer>();
        for(int i=0;i<arr.length;i++){
            if(cset.contains(arr[i])){
                ArrayList<Integer> ans = new ArrayList<Integer>();
                ans.add(arr[i]);
                ans.add(0-arr[i]);
                set.add(ans);
            }
            cset.add(0-arr[i]);
        }
        return new ArrayList<>(set);
    }

    public List<String> getRange(int[] arr){
        List<String> res = new ArrayList<String>();
        int s = arr[0];
        int e = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i] == s+1){
                e++;
            }else{
                if(s == e){
                    res.add(s+"");
                }else{
                    res.add(s+"->"+e);
                }
                s=arr[i];
                e=arr[i];
            }
        }
        if(s == e){
            res.add(s+"");
        }else{
            res.add(s+"->"+e);
        }
        return res;
    }

    public List<String> substringk(String s,int k){
        if(s.length() == 0){
            return new ArrayList<String>();
        }
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        List<String> res = new ArrayList<String>();
        int si = 0;
        int ei = 0;
        while(ei < s.length()){
            char c = s.charAt(ei);
            if(ei-si+1 > k || map.size() > k){
                char rc = s.charAt(si);
                int count = map.get(rc);
                if(count == 1){
                    map.remove(rc);
                }else{
                    map.put(rc,count-1);
                }
                si++;
                continue;
            }
            map.put(c,map.getOrDefault(c,0)+1);
            if(map.size() == k-1 && ei-si+1 == k){
                System.out.println(s.substring(si,ei+1));
            }
            ei++;
        }
        return null;
    }
}