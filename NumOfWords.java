package LeetProblem;

import java.util.HashMap;
import java.util.Map;

public class NumOfWords {

    Map<String,String> dict = new HashMap<String,String>();

    public NumOfWords(){
        dict.put("1","a");
        dict.put("2","b");
        dict.put("3","c");
        dict.put("4","d");
        dict.put("5","e");
        dict.put("6","f");
        dict.put("7","g");
        dict.put("8","h");
        dict.put("9","i");
        dict.put("10","j");
        dict.put("11","k");
        dict.put("12","l");
        dict.put("13","m");
        dict.put("14","n");
        dict.put("15","o");
        dict.put("16","p");
        dict.put("17","q");
        dict.put("18","r");
        dict.put("19","s");
        dict.put("20","t");
        dict.put("21","u");
        dict.put("22","v");
        dict.put("23","w");
        dict.put("24","x");
        dict.put("25","y");
        dict.put("26","z");
    }

    public int getWordCount(String data){
        return getWordCountHelper(data, data.length());
    }

    private int getWordCountHelper(String data, int i) {
        if(i == 0){
            return 1;
        }
        int s1 = data.length() - i;
        if(data.charAt(s1) == '0'){
            return 0;
        }

        int result = getWordCountHelper(data,i-1);
        if(i >= 2 && dict.containsKey(data.substring(s1,s1+2))){
            result+=getWordCountHelper(data,i-2);
        }
        return result;
    }
}
