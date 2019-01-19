package LeetProblem;

public class CountPalindromicSubsequence {

    private void printMatrix(int[][] dp){
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp.length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int longestPalindromeSubsequence(String str){
        int[][] dp = new int[str.length()][str.length()];

        for(int i=0;i<str.length();i++){
            dp[i][i] = 1;
        }

        for(int l=2;l<=str.length();l++){
            for(int i=0;i<str.length()-l+1;i++){
                int j=i+l-1;
                if(l==2 && str.charAt(i) == str.charAt(j)){
                    dp[i][j] = 2;
                }else if(str.charAt(i) == str.charAt(j)){
                    dp[i][j] = 2 + dp[i+1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[str.length()-1][str.length()-1];

    }

    private String printCell(int i,int j){
        return "("+i+","+j+")";
    }

    public void countPalindromeSubsequence(String str){
        int len = str.length();
        int mod = 1_000_000_007;
        int[][] dp = new int[len+1][len+1];

        for(int i=0;i<len;i++){
            dp[i][i] = 1;
        }

        for(int l=2;l<=len;l++){
            for(int i=0;i<len-l+1;i++){
                int j=i+l-1;
                    if(str.charAt(i) == str.charAt(j)){
//                        this.printMatrix(dp);
                        dp[i][j] = dp[i + 1][j - 1] * 2;
//                        System.out.println("match for "+this.printCell(i,j)+" !! "+this.printCell(i+1,j-1));
//                        this.printMatrix(dp);
                        int k = i + 1;
                        int r = j - 1;
                        while (k <= r && str.charAt(k) != str.charAt(i)){
                            k += 1;
                        }
                        while (k <= r && str.charAt(r) != str.charAt(i)){
                            r -= 1;
                        }
                        if (k > r){
                            /* eg:  "aba" while i = 0 and j = 2:  dp[1][1] = 1 records the palindrome{"b"},
                         the reason why dp[i + 1][j  - 1] * 2 counted is that we count dp[i + 1][j - 1] one time as {"b"},
                         and additional time as {"aba"}. The reason why 2 counted is that we also count {"a", "aa"}.
                         So totally dp[i][j] record the palindrome: {"a", "b", "aa", "aba"}.
                         */
//                            this.printMatrix(dp);
                            dp[i][j] += 2;
//                            System.out.println("inside match k > r ");
//                            this.printMatrix(dp);
                        }else if (k == r){
                            /* eg:  "aaa" while i = 0 and j = 2: the dp[i + 1][j - 1] records the palindrome {"a"}.
                         the reason why dp[i + 1][j  - 1] * 2 counted is that we count dp[i + 1][j - 1] one time as {"a"},
                         and additional time as {"aaa"}. the reason why 1 counted is that
                         we also count {"aa"} that the first 'a' come from index i and the second come from index j. So totally dp[i][j] records {"a", "aa", "aaa"}
                        */
//                            this.printMatrix(dp);
                            dp[i][j] += 1;
//                            System.out.println("inside match k = r ");
//                            this.printMatrix(dp);
                        }else{
                            /* eg: "aacaa" while i = 0 and j = 4: the dp[i + 1][j - 1] records the palindrome {"a",  "c", "aa", "aca"}.
                          the reason why dp[i + 1][j  - 1] * 2 counted is that we count dp[i + 1][j - 1] one time as {"a",  "c", "aa", "aca"},
                          and additional time as {"aaa",  "aca", "aaaa", "aacaa"}.  Now there is duplicate :  {"aca"},
                          which is removed by deduce dp[low + 1][high - 1]. So totally dp[i][j] record {"a",  "c", "aa", "aca", "aaa", "aaaa", "aacaa"}
                          */
//                            this.printMatrix(dp);
                            dp[i][j] -= dp[k + 1][r - 1];
//                            System.out.println("inside match k < r "+this.printCell(k+1,r-1));
//                            this.printMatrix(dp);
                        }
                    }else{
                        // check for rest sub-sequence and  remove common
                        // palindromic subsequences as they are counted
                        // twice when we do countPS(i+1, j) + countPS(i,j-1)
//                        this.printMatrix(dp);
                        dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
                        if(dp[i][j] > mod){
                            dp[i][j] -= mod;
                        }
//                        System.out.println("not match "+this.printCell(i,j)+" !!"+this.printCell(i,j-1)+" "+this.printCell(i+1,j)+" "+this.printCell(i+1,j-1));
//                        this.printMatrix(dp);
                    }
                    dp[i][j] %= 1000000007;
            }
        }
        System.out.println((dp[0][len-1]));
//        return dp[str.length()-1][str.length()-1];
    }
}
