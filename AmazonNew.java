package LeetProblem;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.PriorityQueue;
import java.util.TreeSet;

public class AmazonNew {
    public int mergeSubFiles(int[] tracks){
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i=0;i<tracks.length;i++){
            pq.offer(tracks[i]);
        }
        int sum=0;
        while(!pq.isEmpty() && pq.size() >= 2){
            int t1 = pq.poll();
            int t2 = pq.poll();
            sum+=t1+t2;
            pq.offer(t1+t2);
        }
        return sum;
    }

    public int minimumDistance(int[][] maze){
        return this.minimumDistanceHelper(maze,0,0,0);
    }

    private int minimumDistanceHelper(int[][] maze, int r, int c,int path){
        if(c >= maze[0].length || c < 0 || r >= maze.length || r < 0 || maze[r][c] == 0){
            return -1;
        }else{
            if(maze[r][c] == 9){
                return path;
            }
            maze[r][c] = 0;
            int[] paths = new int[4];
            paths[0] = this.minimumDistanceHelper(maze,r+1,c,path+1);
            paths[1] = this.minimumDistanceHelper(maze,r,c+1,path+1);
            paths[2] = this.minimumDistanceHelper(maze,r-1,c,path+1);
            paths[3] = this.minimumDistanceHelper(maze,r,c-1,path+1);
            maze[r][c] = 1;
            return minPaths(paths);
        }
    }

    private int minPaths(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == -1){
                continue;
            }else{
                min = Math.min(min, arr[i]);
            }
        }
        return (min == Integer.MAX_VALUE)?-1:min;
    }

    public void twoNumbers(int n){
        int x = (int) Math.ceil(Math.sqrt(n));
        int y = (int) Math.ceil(n/x) + 1;
        System.out.println(x+y);
    }

    public void fiboSeries(int l, int r){
        int a = 0;
        int b = 1;
        int sum = 0;
        int nextFib = 0;
        while(nextFib <=r){
            nextFib = a+b;
            if(nextFib >= l && l<=r){
                while(l <= nextFib && l<=r){
                    sum+=nextFib;
                    l++;
                }
            }
            a = b;
            b = nextFib;
        }
        System.out.println(sum);
    }

    public void countInversion(int[] arr){
        int res = 0;
        TreeSet<Integer> tset = new TreeSet<Integer>();
        for(int i=0;i<arr.length;i++){
            tset.add(arr[i]);
            res += tset.tailSet(arr[i],false).size();
        }
        System.out.println(res);
    }
}
