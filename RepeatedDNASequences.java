package LeetProblem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<String>();
        HashSet<String> res = new HashSet<String>();
        for(int i=0;i<=s.length()-10;i++){
            String sub = s.substring(i,i+10);
            if(set.contains(sub)){
                res.add(sub);
            }else{
                set.add(sub);
            }
        }
        return new ArrayList<String>(res);
    }
}
