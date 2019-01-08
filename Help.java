package LeetProblem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Help {

    HashMap<String, HashSet<String>> mapFirst;
    HashMap<String, HashSet<String>> mapLast;
    String res;

    public Help(){
        mapFirst = new HashMap<String,HashSet<String>>();
        mapLast = new HashMap<String,HashSet<String>>();
        this.res = "";
    }

    private void add(HashMap<String, HashSet<String>> map,String fix,String str){
        HashSet<String> tmpSet = map.get(fix);
        if(tmpSet == null){
            tmpSet = new HashSet<String>();
        }
        tmpSet.add(str);
        map.put(fix,tmpSet);
    }

    private void remove(HashMap<String, HashSet<String>> map,String fix,String str){
        HashSet<String> tmpSet = map.get(fix);
        if(tmpSet.contains(str)){
            tmpSet.remove(str);
        }
        if(tmpSet.isEmpty()){
            map.remove(fix);
        }else{
            map.put(fix,tmpSet);
        }

    }

    private String getString(HashMap<String, HashSet<String>> map,String fix){
        HashSet<String> tmpSet = map.get(fix);
            return tmpSet.iterator().next();
    }

    public String combine(String[] arrs){

        HashMap<String,String> dict = new HashMap<String,String>();
        dict.put("AAT","asd");
        dict.put("AAA","asd");
        dict.put("TTG","asd");
        dict.put("CCC","asd");
        dict.put("TTT","asd");
        Queue<String> q = new LinkedList<String>();
        for(int i=0;i<arrs.length;i++){
            String tmp = arrs[i];
            if(dict.containsKey(tmp.substring(0,3))){
                this.add(this.mapFirst,tmp.substring(0,3),tmp);
            }
            if(dict.containsKey(tmp.substring(tmp.length()-3))){
                this.add(this.mapLast,tmp.substring(tmp.length()-3),tmp);
            }
        }
        System.out.println(mapFirst);
        System.out.println(mapLast);
        q.add(arrs[0]);
        while(true){
            String tmp = q.poll();
            System.out.println(tmp);
            String first = tmp.substring(0,3);
            String last = tmp.substring(tmp.length()-3);
            if(mapLast.containsKey(first)){
                String tmpSetStr = this.getString(this.mapLast,first);
                this.res = tmpSetStr+tmp.substring(3);
                this.remove(this.mapFirst,tmpSetStr.substring(0,3),tmpSetStr);
                this.remove(this.mapLast,tmpSetStr.substring(tmpSetStr.length()-3),tmpSetStr);
                this.remove(this.mapFirst,tmp.substring(0,3),tmp);
                this.remove(this.mapLast,tmp.substring(tmp.length()-3),tmp);
            }else if(mapFirst.containsKey(last)){
                String tmpSetStr = this.getString(mapFirst,last);
                this.res = tmp+tmpSetStr.substring(3);
                this.remove(this.mapFirst,tmpSetStr.substring(0,3),tmpSetStr);
                this.remove(this.mapLast,tmpSetStr.substring(tmpSetStr.length()-3),tmpSetStr);
                this.remove(this.mapFirst,tmp.substring(0,3),tmp);
                this.remove(this.mapLast,tmp.substring(tmp.length()-3),tmp);
            }

            q.offer(this.res);
            this.add(this.mapFirst,this.res.substring(0,3),this.res);
            this.add(this.mapLast,this.res.substring(this.res.length()-3),this.res);
            System.out.println(mapFirst);
            System.out.println(mapLast);
            if(mapFirst.size() == 1){
                break;
            }
        }
        return q.poll();
    }
}

//  AATTGGCCAATTGAATTGGCCAAAATTTGGGCCC