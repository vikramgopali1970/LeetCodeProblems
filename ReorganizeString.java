package LeetProblem;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ReorganizeString {
    public class Node{
        int freq;
        char val;

        public Node(int freq, char val){
            this.val = val;
            this.freq = freq;
        }

        public String toString(){
            return "("+this.val+","+this.freq+")";
        }
    }
    public String reorganizeString(String S) {
        int[] f = new int[26];
        PriorityQueue<Node> pq = new PriorityQueue(new Comparator<Node>(){
            public int compare(Node n1, Node n2){
                return Integer.compare(n2.freq, n1.freq);
            }
        });
        for(int i=0;i<S.length();i++){
            char c = S.charAt(i);
            f[c-'a']++;
        }
        for(int i=0;i<26;i++){
            if(f[i]>0){
                pq.offer(new Node(f[i],(char)(i+'a')));
            }
        }
        Node prev = null;
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Node curr = pq.poll();
            curr.freq--;
            sb.append(curr.val);
            if(prev != null){
                pq.offer(prev);
            }
            prev = (curr.freq>0)?curr:null;
        }
        return (sb.length() == S.length())?sb.toString():"";
    }
}
