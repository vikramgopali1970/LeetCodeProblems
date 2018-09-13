package LeetProblem;

public class SymmetricTree {
    public boolean symm(TreeNode A,TreeNode B){
        if(A == null && B==null){
            return true;
        }

        if(A !=null && B!=null && A.val == B.val){
            return symm(A.left,B.right)&&symm(A.right,B.left);
        }

        return false;

    }

    public boolean isSymmetric(TreeNode root) {
        return symm(root,root);
    }
}
