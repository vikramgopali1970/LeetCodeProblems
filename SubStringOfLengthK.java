package LeetProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubStringOfLengthK {
    public List<String> substringk(String s, int k){
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
                res.add(s.substring(si,ei+1));
            }
            ei++;
        }
        return new ArrayList<String>(res);
    }
}
