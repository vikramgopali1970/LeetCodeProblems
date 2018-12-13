package LeetProblem;

public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        String tmp = S;
        tmp = tmp.toUpperCase();
        tmp = tmp.replace("-","");
        StringBuilder str = new StringBuilder();
        int first = tmp.length()%K;
        if(first != 0){
            str.append(tmp.substring(0,first)+"-");
        }
        while(first < tmp.length()){
            str.append(tmp.substring(first,first+K)+"-");
            first = first+K;
        }
        if(str.length() > 0){
            str.deleteCharAt(str.length() - 1);
        }
        return str.toString();
    }
}
