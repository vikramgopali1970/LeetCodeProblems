package LeetProblem;

import java.util.LinkedList;
import java.util.Queue;

public class AsFarfromLandasPossible {

    public class Pair{
        int row;
        int col;
        int dist;

        public Pair(int row, int col, int dist){
            this.col = col;
            this.row = row;
            this.dist = dist;
        }

        public String toString(){
            return "("+this.row+","+this.col+") "+this.dist;
        }
    }

    public int maxDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dr = {1,0,-1,0};
        int[] dc = {0,1,0,-1};
        int[][] dist = new int[m][n];
        Queue<Pair> q = new LinkedList<Pair>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                dist[i][j] = -1;
                if(grid[i][j] == 1){
                    q.offer(new Pair(i,j, 0));
                }
            }
        }
        while(!q.isEmpty()){
            Pair curr = q.poll();
            if(dist[curr.row][curr.col] != -1){
                continue;
            }
            dist[curr.row][curr.col] = curr.dist;
            for(int i=0;i<4;i++){
                int row = curr.row + dr[i];
                int col = curr.col + dc[i];
                if(row >=0 && row < grid.length && col >= 0 && col < grid[0].length){
                    q.offer(new Pair(row,col,curr.dist+1));
                }
            }
        }
        int res = -1;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                res = Math.max(dist[i][j], res);
            }
        }
        return res==0?-1:res;
    }


}
