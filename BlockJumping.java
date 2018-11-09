package LeetProblem;



public class BlockJumping {

    public boolean CrossPossible(int[] blocks){
        int fieldLength = blocks.length-1;
        return this.CrossPossibleCompute(blocks, fieldLength, 0);
    }

    private boolean CrossPossibleCompute(int[] blocks, int fieldLength, int currentPosition) {
        if(currentPosition > fieldLength){
            return true;
        }
        if(blocks[currentPosition] == 0 && (fieldLength-currentPosition) < 0){
            return false;
        }
        for(int i=1;i<=blocks[currentPosition];i++){
            if(CrossPossibleCompute(blocks,fieldLength,currentPosition+i)){
                return true;
            }
        }
        return false;
    }
}
