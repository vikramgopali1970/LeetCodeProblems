package LeetProblem;

import java.util.HashSet;

public class NumberOfSubstringWithKUniqueChars {

    public int count(String str, int k){
        int result = 0;
        for(int i=0;i<str.length();i++){
            int d_count = 0;
            HashSet<Character> set = new HashSet<Character>();
            for(int j=i;j<str.length();j++){
                char c = str.charAt(j);
                if(!set.contains(c)){
                    d_count++;
                }
                set.add(c);
                if(d_count == k){
                    result++;
                }
                if(d_count>k){
                    break;
                }
            }
        }
        return result;
    }
}
