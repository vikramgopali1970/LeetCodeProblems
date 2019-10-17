package LeetProblem;

public class PairInt{
    int first,second;
    public PairInt(){}
    public PairInt(int first, int second){
        this.first = first;
        this.second = second;
    }

    public String toString(){
        return "["+this.first+","+this.second+"]";
    }

}