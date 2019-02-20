package LeetProblem;

public class LargestPlusSign {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] dp = new int[N][N];
        int max = 0;
        for(int i=0;i<mines.length;i++){
            dp[mines[i][0]][mines[i][1]] = -1;
        }

        for(int i=0;i<dp.length;i++){
            int count = 0;
            for(int j=0;j<dp[0].length;j++){
                if(dp[i][j] == -1){
                    count = 0;
                }else{
                    count++;
                    dp[i][j] = count;
                }
            }

            count = 0;
            for(int j=N-1;j>=0;j--){
                if(dp[i][j] == -1){
                    count = 0;
                }else{
                    count++;
                    dp[i][j] = Math.min(dp[i][j],count);
                }
            }
        }


        for(int j=0;j<dp[0].length;j++){
            int count = 0;
            for(int i=0;i<dp.length;i++){
            for(int i=0;i<dp.length;i++){
                if(dp[i][j] == -1){
                    count=0;
                }else{
                    count++;
                    dp[i][j] = Math.min(dp[i][j],count);
                }
            }

            count = 0;
            for(int i=N-1;i>=0;i--){
                if(dp[i][j] == -1){
                    count=0;
                }else{
                    count++;
                    dp[i][j] = Math.min(dp[i][j],count);
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max;
    }
}
