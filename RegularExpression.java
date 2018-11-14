package LeetProblem;

public class RegularExpression {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] result = new boolean[m+1][n+1];

        result[0][0] = true;

        //fill first row
        for (int i=1;i<=n;i++){
            if(p.charAt(i-1) == '*'){
                result[0][i] = result[0][i-2];
            }else{
                result[0][i] = false;
            }
        }

        for(int i=1;i<=m;i++){
            result[i][0] = false;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.'){
                    result[i][j] = result[i-1][j-1];
                }else if (p.charAt(j-1) == '*'){
                    //case of 0 match
                    if(result[i][j-2] == true){
                        result[i][j] = result[i][j-2];
                    }else if (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.'){
                        result[i][j] = result[i-1][j];
                    }else{
                        result[i][j]=false;
                    }
                }else{
                    result[i][j] = false;
                }
            }
        }

//        for(int i=0;i<m+1;i++){
//            for(int j=0;j<n+1;j++){
//                System.out.print(result[i][j]+" ");
//            }
//            System.out.println();
//        }
        return result[m][n];
    }

}
