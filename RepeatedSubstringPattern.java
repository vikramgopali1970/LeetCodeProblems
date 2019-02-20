package LeetProblem;

public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int sInd = 1;
        while (sInd <= s.length() / 2) {
            while (sInd < s.length() && s.charAt(sInd) != s.charAt(0)) {
                sInd++;
            }
            String sub = s.substring(0, sInd);
            if (sub.length() == s.length()) {
                return false;
            }
            if (s.length() % sub.length() == 0) {
                int rpt = s.length() / sub.length();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < rpt; i++) {
                    sb.append(sub);
                }
                System.out.println(s + " " + sb.toString());
                if (sb.toString().equals(s)) {
                    return true;
                } else {
                    sInd++;
                }
            } else {
                sInd++;
            }
        }
        return false;
    }
}
