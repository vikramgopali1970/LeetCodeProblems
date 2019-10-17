package LeetProblem;

public class DiceRollSimulation {
    int count;
    public int dieSimulator(int n, int[] rollMax) {
        int[] rolls = new int[rollMax.length];
        this.count=0;
        this.helper(n,rollMax,rolls,0);
        return this.count;
    }


    private void helper(int n, int[] rollMax, int[] rolls,int ind){
        if(ind >= n){
            this.count++;
            System.out.println();
        }else{
            for(int i=0;i<6;i++){
                if(rolls[i] < rollMax[i]){
                    System.out.print(i+1);
                    rolls[i]++;
                    this.helper(n,rollMax,rolls,ind+1);
                    rolls[i]--;
                }
            }
        }
    }
}


// n = 2, rollMax = [1,1,2,2,2,3]