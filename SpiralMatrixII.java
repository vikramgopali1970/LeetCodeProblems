package LeetProblem;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int row = n,col=n,rdiff=0,ldiff=0,bdiff=0,tdiff=1;
        int r=0,c=0;
        int val = 1;
        while(val <= (n*n)){
            for(c=c;c<col-rdiff;c++){
                res[r][c] = val++;
            }
            r++;
            c--;
            rdiff++;
            for(r=r;r<row-bdiff;r++){
                res[r][c] = val++;
            }
            c--;
            r--;
            bdiff++;
            for(c=c;c>=ldiff;c--){
                res[r][c] = val++;
            }
            r--;
            c++;
            ldiff++;
            for(r=r;r>=tdiff;r--){
                res[r][c] = val++;
            }
            tdiff++;
            c++;
            r++;

        }
        return res;
    }
}
