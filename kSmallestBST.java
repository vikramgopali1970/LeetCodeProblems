package LeetProblem;

public class kSmallestBST {
    int small;
    int count = 0;
    public int inorder(TreeNode node,int k){
        if (node == null){
            return 0;
        }
        inorder(node.left,k);
        count++;
        if(count == k){
            small = node.val;
        }
        inorder(node.right,k);
        return small;
    }

    public int kthSmallest(TreeNode root, int k) {
        return inorder(root,k);

    }
}
