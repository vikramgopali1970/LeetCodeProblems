package LeetProblem;

import java.util.*;

public class SmallestStringWithSwaps {
    int[] vis;
    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    private void dfs(String s, int node, HashMap<Integer, HashSet<Integer>> al, PriorityQueue<Character> temp, int comp){
        vis[node] = 1;
        temp.offer(s.charAt(node));
        map.put(node,comp);
        for(int child : al.get(node)){
            if(vis[child] != 1){
                this.dfs(s,child,al,temp,comp);
            }
        }
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if(pairs.size() == 0){
            return s;
        }
        HashMap<Integer,HashSet<Integer>> al = new HashMap<Integer,HashSet<Integer>>();
        for(int i=0;i<s.length();i++){
            al.put(i,new HashSet<Integer>());
        }
        for(int i=0;i<pairs.size();i++){
            int ind1 = pairs.get(i).get(0);
            int ind2 = pairs.get(i).get(1);
            HashSet<Integer> ed = al.get(ind1);
            ed.add(ind2);
            al.put(ind1, ed);
            ed = al.get(ind2);
            ed.add(ind1);
            al.put(ind2, ed);
        }
        int comp = 0;
        vis = new int[s.length()];
        ArrayList<PriorityQueue<Character>> com = new ArrayList<PriorityQueue<Character>>();
        for(int node : al.keySet()){
            if(vis[node] != 1){
                comp++;
                PriorityQueue<Character> temp = new PriorityQueue<Character>();
                this.dfs(s,node,al,temp,comp);
                com.add(temp);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            sb.append(com.get(map.get(i)-1).poll());
        }
        return sb.toString();
    }
}
