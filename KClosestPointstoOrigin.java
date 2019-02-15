package LeetProblem;

import java.util.Arrays;
import java.util.Comparator;

public class KClosestPointstoOrigin {

    public class Point{
        int[] point;
        double dist;

        public Point(int[] point,double dist){
            this.point = point;
            this.dist = dist;
        }

    }

    private double calDist(int[] point){
        return Math.sqrt(Math.pow(point[0],2)+Math.pow(point[1],2));
    }

    public int[][] kClosest(int[][] points, int K) {
        Point[] dist = new Point[points.length];
        int[][] res = new int[K][2];
        for(int i=0;i<points.length;i++){
            dist[i] = new Point(points[i],calDist(points[i]));
        }
        Arrays.sort(dist, new Comparator<Point>(){
            public int compare(Point p1,Point p2){
                return Double.compare(p1.dist,p2.dist);
            }
        });
        for(int i=0;i<K;i++){
            res[i] = dist[i].point;
        }
        return res;
    }

}
