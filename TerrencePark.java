package LeetProblem;

public class TerrencePark {

    public void GetPaths(int n,int m){
        //assuming the start point is 0,0 and end point is 0,m in this nXm grid
        int[][] gridRec = new int[n][m];
        int[][] gridDP = new int[n+2][m+1];
        int result = 0;
        int paths = this.getPathsHelperRecursive(gridRec,0,0);
        System.out.println(paths);
        this.dpGetpaths(gridDP);
    }

    private int getPathsHelperRecursive(int[][] grid, int i, int j){
        if(i==0 && j == grid[0].length-1){
            return 1;
        }
        int result = 0;
        if(i<0 || j< 0 || i >= grid.length || j>= grid[0].length){
            return 0;
        }else{
            result = this.getPathsHelperRecursive(grid,i,j+1);
            result += this.getPathsHelperRecursive(grid,i+1,j+1);
            result += this.getPathsHelperRecursive(grid,i-1,j+1);
        }
        return result;
    }


    private void dpGetpaths(int[][] grid){
        grid[1][1] = 1;
        for(int j=1;j<grid[0].length;j++){
            for(int i=1;i<grid.length-1;i++){
                if(i == 1 && j==1){
                    continue;
                }
//                System.out.println(i+" "+j);
                grid[i][j] += grid[i-1][j-1] + grid[i+1][j-1] + grid[i][j-1];
            }
        }
        System.out.println(grid[1][grid[0].length-1]);
        this.printMatrix(grid);
    }


    public void printMatrix(int[][] grid){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }


    private int recursiveBottomPaths(int[][] grid,int i, int j, boolean bottom, int result){
        if(i==0 && j== grid[0].length-1 && bottom){
            return 1;
        }
        if(i==grid.length-1){
            bottom = true;
        }
        if(i<0 || j<0 || i >= grid.length || j>grid[0].length){
            return 0;
        }else{
            result = this.recursiveBottomPaths(grid,i-1,j+1,bottom,result);
            result += this.recursiveBottomPaths(grid,i,j+1,bottom,result);
            result += this.recursiveBottomPaths(grid,i+1,j+1,bottom,result);
        }
        return result;
    }

//    private void bottomPathsDP(int[][] grid){
//        grid[1][1] = -1;
//        for(int j=0;j<grid[0].length;j++){
//            for(int i=0;i<grid.length;i++){
//                if(grid[i-1][j-1] < 0){
//
//                }else if()
//            }
//        }
//    }

}
