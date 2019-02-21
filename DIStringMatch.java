package LeetProblem;

public class DIStringMatch {
    public int[] diStringMatch(String S) {
        if(S.length() == 0){
            return new int[]{0};
        }
        int min = 0;
        int max = S.length();
        int[] res = new int[S.length()+1];
        for(int i=0;i<S.length();i++){
            char c = S.charAt(i);
            if(c == 'I'){
                res[i] = min++;
            }else{
                res[i] = max--;
            }
        }
        if(S.charAt(S.length()-1) == 'I'){
            res[res.length-1] = max;
        }else{
            res[res.length-1] = min;
        }
        return res;
    }
}
