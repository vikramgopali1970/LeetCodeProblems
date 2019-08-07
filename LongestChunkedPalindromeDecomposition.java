package LeetProblem;

public class LongestChunkedPalindromeDecomposition {
    public int longestDecomposition(String text) {
        int s=0,e=0,rs=text.length(),re=text.length(),res=0;
        while(e <= rs){
            String f = text.substring(s,e);
            String b = text.substring(rs,re);
            if(f.equals(b) && f.length()>0){
                res+=2;
                s=e;
                re = rs;
                e=s+1;
                rs=re-1;
            }else{
                e++;
                rs--;
            }
        }
        if(text.substring(s,re).length()>0){
            res++;
        }
        return res;
    }
}
