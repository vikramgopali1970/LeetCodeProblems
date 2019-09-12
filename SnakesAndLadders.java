package LeetProblem;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {
    private int[] getRowCol(int num,int n){
        int col = (num%n == 0)?n:num%n;
        int row = (num%n == 0)?(num/n)-1:num/n;
        if(row%2 != 0){
            col = n-col;
        }else{
            col--;
        }
        row=n-row-1;
        return new int[]{row,col};
    }

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] visited = new int[(n*n)];
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(1);
        q.offer(null);
        int moves = 0;
        while(!q.isEmpty()){
            Integer pos = q.poll();
            if(pos == null){
                if(!q.isEmpty()){
                    q.offer(null);
                    moves++;
                }
            }else{
                if(pos == n*n){
                    return moves;
                }
                for(int i = pos+1; i <= Math.min(pos+6,n*n); i++){
                    if(visited[i-1] == 1){
                        continue;
                    }
                    visited[i-1] = 1;
                    int b[] = getRowCol(i,n);
                    int x = b[0],y=b[1];
                    if(board[x][y] < 0)
                        q.add(i);
                    else{
                        if(visited[board[x][y] - 1] == 0)
                            q.add(board[x][y]);
                    }
                }
            }
        }
        return -1;
    }
}
