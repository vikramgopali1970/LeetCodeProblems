package LeetProblem;

public class MakeSentence{
    public void parseString(String str){
        str = str.trim();
        this.helper(str, 0, new StringBuilder());
    }

    private void helper(String str,int ind, StringBuilder sb){
        if(ind >= str.length()){
            System.out.println(sb);
            return;
        }
        else{
            char c = str.charAt(ind);
            if(c == '{'){
                StringBuilder lsb = new StringBuilder();
                ind++;
                while(ind < str.length() && str.charAt(ind) != '}'){
                    lsb.append(str.charAt(ind++));
                }
                String local = lsb.toString().trim();
                if(local.charAt(local.length()-1) == '|'){
                    lsb.append("-1");
                }
                ind++;
                String[] opts = lsb.toString().split("\\|");
                for(int i=0;i<opts.length;i++){
                    String word = opts[i].trim();
                    if(word.equals("-1")){
                        word = "";
                    }
                    sb.append(word);
                    this.helper(str, ind, sb);
                    sb.setLength(sb.length() - word.length());
                }
            }
            else{
                sb.append(c);
                this.helper(str, ind+1,sb);
                sb.setLength(sb.length() - 1);
            }
        }
    }

    public void count(int[] nums){
        int i=1,count=1,res=0;
        int prev = nums[0];
        while(i<nums.length){
            if(nums[i] == prev){
                while(i<nums.length && nums[i] == prev){
                    count++;
                    i++;
                }
                res += count/3;
            }else{
                prev = nums[i++];
                count = 1;
            }
        }
        System.out.println(res);
    }

    public void longString(String str){
        StringBuilder sb = new StringBuilder();
        int i = 1;
        int max = 0;
        String finalStr = "";
        sb.append(str.charAt(i));
        while(i < str.length()){
            if(str.charAt(i) - str.charAt(i-1) == 1){
                sb.append(str.charAt(i));
                String test = sb.toString();
                if(str.indexOf(test) != str.lastIndexOf(test)){
                    if(test.length() > max){
                        max = test.length();
                        finalStr = test;
                    }
                }
            }else{
                sb.setLength(0);
                sb.append(str.charAt(i));
            }
            i++;
        }
        System.out.println(finalStr);
    }
}