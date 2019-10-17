package LeetProblem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class StreamOfCharacters {

    private class TrieNode{
        TrieNode[] children;
        int ind;

        public TrieNode(){
            this.children = new TrieNode[256];
        }
    }

    public class Trie{

        private TrieNode root;

        public Trie(){
            this.root = new TrieNode();
        }

        public void insert(String str){
            char[] ch = str.toCharArray();
            TrieNode cur = this.root;
            for(int i=0;i<ch.length;i++){
                if(cur.children[ch[i]] == null){
                    cur.children[ch[i]] = new TrieNode();
                }
                cur = cur.children[ch[i]];
            }
        }

        public TrieNode findNext(TrieNode trie, char c){
            return trie.children[c];
        }
    }

    public class Stream{
        char[] stream;
        int ind;
        public Stream(String stream){
            this.stream = stream.toCharArray();
            this.ind = 0;
        }

        public char getNextChar(){
            return this.stream[this.ind++];
        }

        public boolean hasNext(){
            if(this.ind < stream.length){
                return true;
            }
            return false;
        }

    }

    public class Node{
        StringBuilder sb;
        TrieNode tn;

        public Node(TrieNode tn, char c){
            this.tn = tn;
            this.sb = new StringBuilder();
            sb.append(c);
        }
    }

    public int[] streamOfCharacters(String _stream, String[] words){
        int[] result = new int[words.length];
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        HashSet<Character> start = new HashSet<Character>();
        HashSet<Node> set = new HashSet<Node>();
        Stream stream = new Stream(_stream);
        Trie trie = new Trie();
        for(int i=0;i<words.length;i++){
            trie.insert(words[i]);
            map.put(words[i],i);
            start.add(words[i].charAt(0));
        }
        int ind = -1;
        while(stream.hasNext()){
            char c = stream.getNextChar();
            ind++;
            Iterator<Node> it = set.iterator();
            while(it.hasNext()){
                Node temp = it.next();
                if(map.containsKey(temp.sb.toString())){
                    result[map.get(temp.sb.toString())] = temp.tn.ind;
                    result[map.get(temp.sb.toString())] = temp.tn.ind;
                }
                TrieNode tt = trie.findNext(temp.tn,c);
                if(tt == null){
                    it.remove();
                }else{
                    tt.ind = temp.tn.ind;
                    temp.tn = tt;
                    temp.sb.append(c);
                }
            }
            if(start.contains(c)){
                TrieNode tn = trie.findNext(trie.root,c);
                tn.ind = ind;
                set.add(new Node(tn,c));
            }
        }
        return result;
    }

}
