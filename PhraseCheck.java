package LeetProblem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class PhraseCheck {

    /*
        PhraseCheck pc = new PhraseCheck();
        Map<String, List<Integer>> doc = new HashMap<String,List<Integer>>();
        doc.put("i",Arrays.asList(new Integer[]{0,5,7,12}));
        doc.put("went",Arrays.asList(new Integer[]{1,8}));
        doc.put("to",Arrays.asList(new Integer[]{6,9,1000}));
        doc.put("the",Arrays.asList(new Integer[]{3,19,10}));
        doc.put("store",Arrays.asList(new Integer[]{4,14,199,11}));
        System.out.println(pc.phraseCheck(doc,"i went to the store"));

    */

    public boolean phraseCheck(Map<String, List<Integer>> doc, String phrase){
        if(doc.size() == 0){
            return false;
        }
        if(phrase.length() == 0){
            return true;
        }
        Map<String,TreeSet<Integer>> docs = new HashMap<String,TreeSet<Integer>>();
        for(String str : doc.keySet()){
            docs.put(str,new TreeSet<Integer>(doc.get(str)));
        }
        String[] p = phrase.split(" ");
        int ind = 0;
        TreeSet<Integer> temp1 = docs.get(p[ind++]);
        for(Integer i : temp1){
            ind = 1;
            int loc = i;
            while(ind < p.length){
                TreeSet<Integer> temp2 = docs.get(p[ind++]);
                if(temp2.ceiling(loc) == null || temp2.ceiling(loc) != (loc+1)){
                    break;
                }else{
                    loc = temp2.ceiling(loc);
                }
            }
        }
        return true;
    }

    private boolean phraseCheckHelper(Map<String,TreeSet<Integer>> docs, String[] phrase, int ind,int wordIndex){
        if(ind >= phrase.length){
            return true;
        }
        if(!docs.containsKey(phrase[ind])){
            return false;
        }
        TreeSet<Integer> temp = docs.get(phrase[ind]);
        if(wordIndex < 0){
            for(Integer i : temp){
                boolean present = this.phraseCheckHelper(docs,phrase,ind+1,i);
                if(present){
                    return present;
                }
            }
        }else{
            if(temp.ceiling(wordIndex) == null || temp.ceiling(wordIndex) != (wordIndex+1)){
                return false;
            }else{
                int nInd = temp.ceiling(wordIndex);
                return this.phraseCheckHelper(docs,phrase,ind+1,nInd);
            }
        }
        return false;
    }

}
