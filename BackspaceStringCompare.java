package LeetProblem;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String str, String tstr) {
        return (this.backSpaceCompareHelper(str).compareTo(this.backSpaceCompareHelper(tstr)) == 0);
    }

    private String backSpaceCompareHelper(String str){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if( c == '#'){
                sb.setLength(Math.max(sb.length() - 1, 0));
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
