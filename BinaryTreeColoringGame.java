package LeetProblem;

public class BinaryTreeColoringGame {
    private int parentRed = 0;
    private int redLeftChild = 0;
    private int redrightChild = 0;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        this.traverse(root, true, false, false, x);
        return (this.parentRed > (n - this.parentRed) || (Math.max(this.redLeftChild, this.redrightChild) > this.parentRed + (Math.min(this.redLeftChild, this.redrightChild))));
    }

    private void traverse(TreeNode root,boolean beforeRed, boolean redLeft, boolean redRight, int x){
        if(root == null){
            return;
        }else{
            if(root.val == x){
                beforeRed = false;
                this.traverse(root.left, beforeRed, true, redRight, x);
                this.traverse(root.right, beforeRed, redLeft, true, x);
                return;
            }
            if(beforeRed){
                parentRed++;
            }
            if(redLeft){
                this.redLeftChild++;
            }
            if(redRight){
                this.redrightChild++;
            }
            this.traverse(root.left, beforeRed, redLeft, redRight, x);
            this.traverse(root.right, beforeRed, redLeft, redRight, x);
        }
    }
}
