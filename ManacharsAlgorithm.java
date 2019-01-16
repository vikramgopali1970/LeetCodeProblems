package LeetProblem;

import java.util.Arrays;

public class ManacharsAlgorithm {

    private int[] palindromeCount;

    public int[] getPalindromeCount(){
        return this.palindromeCount;
    }

    public int longestPalindrome(String str){
        char[] strPalindrom = new char[2*str.length()+3];
        int ind = 2;
        strPalindrom[0] = '@';
        strPalindrom[1] = '#';
        strPalindrom[strPalindrom.length-1] = '$';
        for(int i=0;i<str.length();i++){
            strPalindrom[ind++] = str.charAt(i);
            strPalindrom[ind++] = '#';
        }
        this.palindromeCount = new int[strPalindrom.length];
        Arrays.fill(this.palindromeCount,0);
        int center =0,right=0;
        for(int i=1;i<this.palindromeCount.length-1;++i){
            if(i<right){
                this.palindromeCount[i] = Math.min(right - i, this.palindromeCount[2 * center - i]);
            }

            while(strPalindrom[i+this.palindromeCount[i]+1] == strPalindrom[i-this.palindromeCount[i]-1]){
                this.palindromeCount[i]++;
            }
            if(i + this.palindromeCount[i] > right){
                center = i;
                right = i+this.palindromeCount[i];
            }
        }
        int maxLen = Integer.MIN_VALUE;
        for(int i=0;i<this.palindromeCount.length;i++){
            if(this.palindromeCount[i] > maxLen){
                maxLen = this.palindromeCount[i];
            }
        }
        return maxLen;
    }
}
