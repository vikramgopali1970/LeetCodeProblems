package LeetProblem;

public class SubtreeofAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if( s == null || t == null){
            return false;
        }else if(isSame(s,t)){
            return true;
        }else{
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }
    }

    private boolean isSame(TreeNode s,TreeNode t){
        if(s==null && t==null){
            return true;
        }else if( s == null || t == null){
            return false;
        }else if(s.val != t.val){
            return false;

        }else{
            return isSame(s.left,t.left) && isSame(s.right,t.right);
        }
    }
}
