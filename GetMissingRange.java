package LeetProblem;

import java.util.ArrayList;
import java.util.List;

public class GetMissingRange {
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
}
