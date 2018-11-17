package LeetProblem;

public class NumberOfIsland {
    public int numIslands(char[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        int numOfIsland = 0;
        int row = grid.length;
        int col = grid[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == '1'){
                    numOfIsland++;
                    this.checkIsland(grid,i,j);
                }
            }
        }
        return numOfIsland;
    }

    private void checkIsland(char[][] grid,int row,int col){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length){
            return;
        }
        if(grid[row][col] == '0'){
            return;
        }
        grid[row][col] = '0';
        this.checkIsland(grid,row-1,col);
        this.checkIsland(grid,row+1,col);
        this.checkIsland(grid,row,col-1);
        this.checkIsland(grid,row,col+1);
    }
}
