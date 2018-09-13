package LeetProblem;

public class PathSum {
    boolean sumExists = false;

    public void preOrder(TreeNode node,int sum, int soln){
        if(node == null){
            return;
        }
        soln += node.val;
        if(node.left == null && node.right == null && sum==soln){
            sumExists = true;
        }
        preOrder(node.left,sum,soln);
        preOrder(node.right,sum,soln);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        int soln = 0;
        preOrder(root,sum,soln);
        return sumExists;
    }
}
