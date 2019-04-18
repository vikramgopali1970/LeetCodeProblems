package LeetProblem;

/*
 *  public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class MaximumDifferenceBetweenNodeandAncestor {
    int diff = 0;

    private static int MAX = Integer.MAX_VALUE;
    private static int MIN = Integer.MIN_VALUE;

    public int maxAncestorDiff(TreeNode root) {
        int[] test = this.dfs(root);
        System.out.println(test[0]+" "+test[1]);
        return this.diff;
    }

    private int[] dfs(TreeNode root){
        if(root == null){
            return new int[]{MAX,MIN};
        }
        System.out.println(root.val);
        if((root.left == null && root.right == null)){
            return new int[]{root.val,root.val};
        }

        int[] left = this.dfs(root.left);
        int[] right = this.dfs(root.right);
        int llocalDiff,rlocalDiff,min,max;
        if((left[0] != MAX && left[1] != MIN) && (right[0] != MAX && right[1] != MIN)){
            llocalDiff = Math.max(Math.abs(root.val-left[0]),Math.abs(root.val-left[1]));
            rlocalDiff = Math.max(Math.abs(root.val-right[0]),Math.abs(root.val-right[1]));
            this.diff = Math.max(llocalDiff,Math.max(rlocalDiff,this.diff));
            min = Math.min(Math.min(root.val,left[0]),right[0]);
            max = Math.max(Math.max(root.val,left[1]),right[1]);
        }else if((left[0] != MAX && left[1] != MIN)){
            llocalDiff = Math.max(Math.abs(root.val-left[0]),Math.abs(root.val-left[1]));
            min = Math.min(root.val,left[0]);
            max = Math.max(root.val,left[1]);
            this.diff = Math.max(this.diff,llocalDiff);
        }else{
            rlocalDiff = Math.max(Math.abs(root.val-right[0]),Math.abs(root.val-right[1]));
            min = Math.min(root.val,right[0]);
            max = Math.max(root.val,right[1]);
            this.diff = Math.max(this.diff,rlocalDiff);
        }
        return new int[]{min,max} ;
    }
}
