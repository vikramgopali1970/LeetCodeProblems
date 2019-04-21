package LeetProblem;

public class NumberofEnclaves {
    public int numEnclaves(int[][] A) {
        if(A.length==0){
            return 0;
        }else{
            int count=0;
            for(int i=0;i<A.length;i++){
                for(int j=0;j<A[0].length;j++){
                    if(A[i][j] == 1){
                        int[] res = this.numEnclaveHelper(A,j,i,new int[]{0,0});
                        if(res[0] == 0){
                            count+=res[1];
                        }
                    }
                }
            }
            return count;
        }
    }

    private int[] numEnclaveHelper(int[][] mat, int col, int row, int[]res){
        if(col<0 || col>=mat[0].length || row < 0 || row >= mat.length || mat[row][col]==0){
            return res;
        }
        if(row == 0 || col == 0 || row == mat.length-1 || col == mat[0].length-1){
            res[0] = 1;
        }
        res[1]++;
        mat[row][col] = 0;
        res = this.numEnclaveHelper(mat,col+1,row,res);
        res = this.numEnclaveHelper(mat,col-1,row,res);
        res = this.numEnclaveHelper(mat,col,row+1,res);
        res = this.numEnclaveHelper(mat,col,row-1,res);
        return res;
    }
}
