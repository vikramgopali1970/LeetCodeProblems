package LeetProblem;

import java.util.*;

public class TerrencePark {

    public void GetPaths(int n,int m){
        //assuming the start point is 0,0 and end point is 0,m in this nXm grid
        int[][] gridRec = new int[n][m];
        int[][] gridDP = new int[n+2][m+1];
        int[][][] bottomGridDp = new int[n+2][m+1][2];
        int result = 0;
        //all paths
        int paths = this.getPathsHelperRecursive(gridRec,0,0);
        System.out.println("all paths "+paths);
        this.dpGetpaths(gridDP);
        //all paths touching bottom
        paths = this.recursiveBottomPaths(gridRec,0,0,false,result);
        System.out.println("bottom paths "+paths);
        this.bottomPathsDP(bottomGridDp);
        //all paths through certain points
        List<Integer[]> route = new ArrayList<>();
        route.add(new Integer[]{1,3});
        route.add(new Integer[]{1,1});
        Collections.sort(route, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return Integer.compare(o1[1],o2[1]);
            }
        });
        paths = this.setOfPointsRecurssive(gridRec,0,0,route,0);
        System.out.println("specific points paths "+paths);
        this.setOfPointsDP(bottomGridDp,route);
    }

    /**
     * All paths
     *
     * */
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
                grid[i][j] += grid[i-1][j-1] + grid[i+1][j-1] + grid[i][j-1];
            }
        }
        System.out.println("all paths DP "+grid[1][grid[0].length-1]);
//        this.printMatrix(grid);
    }

    public void printMatrix(int[][] grid){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }



    /**
     * All paths that touch the bottom
     *
     * */
    public void print3DMatrix(int[][][] grid,int ind){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                System.out.print(grid[i][j][ind]+" ");
            }
            System.out.println();
        }
        System.out.println();
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

    private void bottomPathsDP(int[][][] grid){
        grid[1][1][0] = 1;
        for(int j=1;j<grid[0].length;j++){
            for(int i=1;i<grid.length-1;i++){
                if(i ==1 && j==1){
                    continue;
                }
                grid[i][j][0] += grid[i-1][j-1][0] + grid[i][j-1][0] + grid[i+1][j-1][0];
                if(i == grid.length-2){
                    grid[i][j][1] += grid[i][j][0];
                    continue;
                }
                grid[i][j][1] += grid[i-1][j-1][1] + grid[i][j-1][1] + grid[i+1][j-1][1];
            }
        }
        System.out.println(" bottom paths "+grid[1][grid[0].length-1][1]);
    }


    /**
     * All Paths that pass through a set of points
     * */

    private int setOfPointsRecurssive(int[][] grid, int i, int j, List<Integer[]> route, int rInd){
        if(i==0 && j==grid[0].length-1 && rInd == route.size()){
            return 1;
        }
        int result = 0;
        if(i<0 || j < 0 || i>= grid.length || j>= grid[0].length|| rInd >= route.size()){
            return 0;
        }else{
            if(i == route.get(rInd)[0] && j == route.get(rInd)[1]){
                rInd++;
            }
            result += this.setOfPointsRecurssive(grid,i-1,j+1,route,rInd);
            result += this.setOfPointsRecurssive(grid,i,j+1,route,rInd);
            result += this.setOfPointsRecurssive(grid,i+1,j+1,route,rInd);
        }
        return result;
    }

    private void setOfPointsDP(int [][][] grid, List<Integer[]> route){
        grid[1][1][0] = 1;
        int ind = 0;
        int next = route.get(ind)[1];
        for(int j=1;j<grid[0].length;j++) {

            for (int i = 1; i < grid.length - 1; i++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                grid[i][j][0] += grid[i - 1][j - 1][0] + grid[i][j - 1][0] + grid[i + 1][j - 1][0];
                if (i == route.get(ind)[0] && j == route.get(ind)[1]) {

                    continue;
                }
                grid[i][j][1] += grid[i - 1][j - 1][1] + grid[i][j - 1][1] + grid[i + 1][j - 1][1];
            }
            if(j == next){
                next = route.get(ind++)[1];
            }
        }
        System.out.println("12312 paths "+grid[1][grid[0].length-1][1]);
    }
}
