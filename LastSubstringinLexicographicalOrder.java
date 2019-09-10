package LeetProblem;

import java.util.Arrays;

public class LastSubstringinLexicographicalOrder {
    public String lastSubstring(String s) {
        char[] sarr = s.toCharArray();
        Arrays.sort(sarr);
        String res = "";
        int ind=s.length()-1;
        char c = sarr[ind--];
        int cnt = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == c){
                int lc = 0;
                int li = i;
                while( i < sarr.length && s.charAt(i) == c){
                    i++;
                    lc++;
                }
                if(cnt < lc){
                    ind = li;
                    cnt = lc;
                }
                res = s.substring(ind);
            }
        }
        return res;
    }
}
