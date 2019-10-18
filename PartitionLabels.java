package LeetProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartitionLabels {
    public class Node{
        int s,e;
        char c;

        public Node(char c,int s,int e){
            this.c = c;
            this.s = s;
            this.e = e;
        }
    }

    public List<Integer> partitionLabels(String S) {
        Node[] range = new Node[26];
        for(int i=0;i<S.length();i++){
            char c = S.charAt(i);
            if(range[c-'a'] == null){
                range[c-'a'] = new Node(c,i,i);
            }else{
                range[c-'a'].e=i;
            }
        }
        List<Integer> start = new ArrayList<Integer>();
        List<Integer> end = new ArrayList<Integer>();
        for(int i=0;i<26;i++){
            if(range[i] != null){
                start.add(range[i].s);
                end.add(range[i].e);
            }
        }
        Collections.sort(start);
        Collections.sort(end);
        int i=0,j=0;
        List<Integer> res = new ArrayList<Integer>();
        while(j<start.size()-1){
            if(end.get(j) >= start.get(j+1)){
                j++;
            }else{
                res.add(end.get(j)-start.get(i)+1);
                j++;
                i=j;
            }
        }
        if(j<end.size() && i<start.size()){
            res.add(end.get(j)-start.get(i)+1);
        }
        return res;
    }
}
