package LeetProblem;

public class PalindromicSubstrings {

    private boolean checkForPalindrome(String str){
        if(str.length() == 1){
            return true;
        }else{
            int i=0,j=str.length()-1;
            while(i<j){
                if(str.charAt(i) == str.charAt(j)){
                    i++;
                    j--;
                }else{
                    return false;
                }
            }
            return true;
        }
    }

    public int palindromicString(String str){
        int result = 0;
        for (int i=0;i<=str.length();i++){
            for (int j=i;j<=str.length();j++){
                if(i==j){
                    continue;
                }
                if(this.checkForPalindrome(str.substring(i,j))){
                    result++;
                }
            }
        }
        return result;
    }


    public int manachaersMethod(String str){
        ManacharsAlgorithm ma = new ManacharsAlgorithm();
        ma.longestPalindrome(str);
        int[] result = ma.getPalindromeCount();
        int res = 0;
        for(int i=0;i<result.length;i++){
            res+=(result[i]+1)/2;
        }
        return res;
    }




}
