package LeetProblem;

import java.util.Arrays;
import java.util.HashSet;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        if(emails.length == 0){
            return 0;
        }
        HashSet<String> set = new HashSet<String>();
        for(String email : emails){
            String str = email.substring(0,email.indexOf("+"));
            str = str.replace(".","");
            str = str+email.substring(email.indexOf("@"));
            set.add(str);
        }
        return set.size();
    }
}
