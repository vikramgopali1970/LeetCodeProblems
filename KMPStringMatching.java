package LeetProblem;

public class KMPStringMatching {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }
        if(haystack.length() == 0){
            return -1;
        }
        int[] nArr = new int[needle.length()];
        nArr[0] = 0;
        int i=1,j=0;
        while(i < needle.length()){
            if(needle.charAt(i) != needle.charAt(j)){
                if(j>0){
                    j=nArr[j-1];
                }else{
                    nArr[i] = 0;
                    i++;
                }
            }else{
                nArr[i] = j+1;
                i++;
                j++;
            }
        }
        j=0;
        for(i=0;i<haystack.length();i++){
            if(j==needle.length()){
                return i-j;
            }
            if(haystack.charAt(i) == needle.charAt(j)){
                j++;
            }else{
                if(j > 0){
                    j=nArr[j-1];
                    i--;
                }
            }
        }
        if(j == needle.length()){
            return i-j;
        }else{
            return -1;
        }
    }
}
