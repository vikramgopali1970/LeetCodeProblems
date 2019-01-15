package LeetProblem;

import java.util.HashSet;

public class ValidSquare {

    private point[] points;

    public class point{
        int x;
        int y;

        public point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private void init(int[] p1, int[] p2, int[] p3, int[] p4){
        this.points = new point[4];
        this.points[0] = new point(p1[0],p1[1]);
        this.points[1] = new point(p2[0],p2[1]);
        this.points[2] = new point(p3[0],p3[1]);
        this.points[3] = new point(p4[0],p4[1]);
    }

    private double getLineLength(point p1, point p2){
//        return Math.sqrt(Math.pow(p2.x-p1.x,2) + Math.pow(p2.y - p1.y,2));
        double len = Math.sqrt(Math.pow(p2.x-p1.x,2) + Math.pow(p2.y - p1.y,2));
        System.out.println(len);
        return len;
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4){
        HashSet<Double> line = new HashSet<Double>();
        this.init(p1,p2,p3,p4);
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(i==j){
                    continue;
                }
                line.add(this.getLineLength(this.points[i],this.points[j]));
            }
        }
        return (line.size()==2 && !line.contains(0.0));
    }

}
