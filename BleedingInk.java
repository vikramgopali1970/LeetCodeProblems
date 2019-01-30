package LeetProblem;

public class BleedingInk {

    public static void main(String[] args){
        BleedingInk bi = new BleedingInk(new int[500][500],new int[][]{{0,0,4000}});
        System.out.println(bi.bleedInk());
    }


    private int[][] paper;
    private int[][] dots;


    public BleedingInk(int[][] paper,int[][] dots){
        this.dots = dots;
        this.paper = paper;
    }

    private void bleedImplementRecursionHelper(int[][] paper,int dot_row, int dot_col,int val,int i,int j,int[][] visited){
        System.out.println("m");
        if(i < 0 || i>=paper.length || j<0 || j>=paper[0].length || visited[i][j] == 1){
            return;
        }else{
            visited[i][j] = 1;
            int blotVal = Math.max(paper[i][j],val-Math.abs(dot_row-i)-Math.abs(dot_col-j));
            if(blotVal == 0){
                return;
            }else{
                paper[i][j] = blotVal;
                this.bleedImplementRecursionHelper(paper,dot_row,dot_col,val,i+1,j,visited);
                this.bleedImplementRecursionHelper(paper,dot_row,dot_col,val,i+1,j+1,visited);
                this.bleedImplementRecursionHelper(paper,dot_row,dot_col,val,i,j+1,visited);
                this.bleedImplementRecursionHelper(paper,dot_row,dot_col,val,i-1,j+1,visited);
                this.bleedImplementRecursionHelper(paper,dot_row,dot_col,val,i-1,j,visited);
                this.bleedImplementRecursionHelper(paper,dot_row,dot_col,val,i-1,j-1,visited);
                this.bleedImplementRecursionHelper(paper,dot_row,dot_col,val,i,j-1,visited);
                this.bleedImplementRecursionHelper(paper,dot_row,dot_col,val,i+1,j-1,visited);
            }

        }
    }


    public int bleedInk(){
        for(int i=0;i<this.dots.length;i++){
            this.bleedImplementRecursionHelper(paper,this.dots[i][0],this.dots[i][1],this.dots[i][2],this.dots[i][0],this.dots[i][1],new int[paper.length][paper[0].length]);
        }

        int sum = 0;
//        for(int i=0;i<this.paper.length;i++){
//            for(int j=0;j<this.paper[0].length;j++){
//                System.out.print(paper[i][j]+" ");
//                sum+=paper[i][j];
//            }
//            System.out.println();
//        }

        return sum;

    }

}
