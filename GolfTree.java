package LeetProblem;

import java.util.*;

public class GolfTree {

    public class Cell{
        int val;
        int row;
        int col;

        public Cell(int val,int row, int col){
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }

    public int cutOffTree(List<List<Integer>> forest) {
        if(forest.size() == 0){
            return -1;
        }
        int[][] mat = new int[forest.size()][forest.get(0).size()];
        Cell[] sorted = new Cell[mat.length*mat[0].length];
        int k = 0,res=0;
        for(int i=0;i<forest.size();i++){
            for(int j=0;j<forest.get(0).size();j++){
                mat[i][j] = forest.get(i).get(j);
                sorted[k++] = new Cell(mat[i][j],i,j);
            }
        }
        k=0;

        Arrays.sort(sorted,new Comparator<Cell>(){
            public int compare(Cell c1,Cell c2){
                return Integer.compare(c1.val,c2.val);
            }
        });
        while(sorted[k].val == 0){
            k++;
        }
        for(int i=k;i<sorted.length;i++){
            int[][] vis = new int[forest.size()][forest.get(0).size()];
            Cell c = sorted[i];
            if(sorted[i].val == 1){
                continue;
            }
            if(i == k){
                int steps = this.travell(0,0,c.row,c.col,mat,vis);
                if(steps == Integer.MAX_VALUE){
                    return -1;
                }
                res+=steps;
            }else{
                Cell pc = sorted[i-1];
                int steps = this.travell(pc.row,pc.col,c.row,c.col,mat,vis);
                if(steps == Integer.MAX_VALUE){
                    return -1;
                }
                res+=steps;
            }
        }

        return res;
    }

    private int travell(int sr,int sc, int er, int ec,int[][] mat,int[][] vis){
        Queue<Cell> q = new LinkedList<Cell>();
        q.offer(new Cell(mat[sr][sc],sr,sc));
        q.offer(null);
        int steps = 0;
        while(!q.isEmpty()){
            if(q.peek() == null){
                q.poll();
                if(!q.isEmpty()){
                    q.offer(null);
                    steps++;
                }
            }else{
                Cell c = q.poll();
                if(c.row < 0 || c.col < 0 || c.row >= mat.length || c.col>= mat[0].length || mat[c.row][c.col] == 0|| vis[c.row][c.col] == 1){
                }else{
                    if(c.row == er && c.col == ec){
                        return steps;
                    }else{
                        vis[c.row][c.col] = 1;
                        q.offer(new Cell(0,c.row+1,c.col));
                        q.offer(new Cell(0,c.row-1,c.col));
                        q.offer(new Cell(0,c.row,c.col+1));
                        q.offer(new Cell(0,c.row,c.col-1));
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }

}
