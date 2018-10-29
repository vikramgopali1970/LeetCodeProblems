package LeetProblem;

import java.util.HashMap;

public class IntegerToEnglishWords {
    HashMap<Integer,String> numToEng = new HashMap<>();
    HashMap<Integer,String> numSection = new HashMap<>();
    HashMap<Integer,String> numToTens = new HashMap<>();

    public IntegerToEnglishWords(){
        numSection.put(0,"");
        numSection.put(1,"Thousand");
        numSection.put(2,"Million");
        numSection.put(3,"Billion");

        numToEng.put(0,"");
        numToEng.put(1,"One");
        numToEng.put(2,"Two");
        numToEng.put(3,"Three");
        numToEng.put(4,"Four");
        numToEng.put(5,"Five");
        numToEng.put(6,"Six");
        numToEng.put(7,"Seven");
        numToEng.put(8,"Eight");
        numToEng.put(9,"Nine");
        numToEng.put(10,"Ten");
        numToEng.put(11,"Eleven");
        numToEng.put(12,"Twelve");
        numToEng.put(13,"Thirteen");
        numToEng.put(14,"Fourteen");
        numToEng.put(15,"Fifteen");
        numToEng.put(16,"Sixteen");
        numToEng.put(17,"Seventeen");
        numToEng.put(18,"Eighteen");
        numToEng.put(19,"Nineteen");
        numToTens.put(2,"Twenty");
        numToTens.put(3,"Thirty");
        numToTens.put(4,"Fourty");
        numToTens.put(5,"Fifty");
        numToTens.put(6,"Sixty");
        numToTens.put(7,"Seventy");
        numToTens.put(8,"Eighty");
        numToTens.put(9,"Ninety");
    }

    public String intToWords(int number){
        if(number== 0){
            return "Zero";
        }
        StringBuilder strb = new StringBuilder();
        strb = intToWordsHelper(number, strb,0);
//        strb = intToWordsIter(number, strb);
        strb.setLength(strb.length()-1);
        return strb.toString();
//        return intToWordsIter(number,strb);
    }

    private StringBuilder intToWordsHelper(int number,StringBuilder strb, int k) {
        if(number == 0){
            return strb;
        }
        StringBuilder tempStrb = new StringBuilder();
        int temp = number%1000;
        number = number/1000;
        if(temp > 99){
            tempStrb.append(this.numToEng.get(temp/100)+" Hundred ");
            temp = temp%100;
        }
        if (temp > 19) {
            tempStrb.append(this.numToTens.get(temp/10)+" ");
            temp = temp%10;
        }
        if(temp >9 && temp<20){
            tempStrb.append(this.numToEng.get(temp)+" ");
            temp = 0;
        }
        if(temp < 10 && temp >0){
            tempStrb.append(this.numToEng.get(temp)+" ");
        }
        if(k>0 && tempStrb.length() !=0){
            tempStrb.append(this.numSection.get(k)+" ");
        }
        strb.insert(0,tempStrb.toString().toCharArray());
        intToWordsHelper(number,strb,k+1);
        return strb;
    }

    private String intToWordsIter(int number, StringBuilder strb){

        int k = 0;
        while(number > 0){
            StringBuilder tempStrb = new StringBuilder();
            int temp = number%1000;
            number = number/1000;
            if(temp > 99){
                tempStrb.append(this.numToEng.get(temp/100)+" Hundred ");
                temp = temp%100;
            }
            if (temp > 19) {
                tempStrb.append(this.numToTens.get(temp/10)+" ");
                temp = temp%10;
            }
            if(temp >9 && temp<20){
                tempStrb.append(this.numToEng.get(temp)+" ");
                temp = 0;
            }
            if(temp < 10 && temp >0){
                tempStrb.append(this.numToEng.get(temp)+" ");
            }
            if(k>0 && tempStrb.length() !=0){
                tempStrb.append(this.numSection.get(k)+" ");
            }
            strb.insert(0,tempStrb.toString().toCharArray());
            k++;
        }
        return strb.toString();
    }
}
