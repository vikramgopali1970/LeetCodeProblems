package LeetProblem;

public class TreeNode extends Tree {
      int val;
      TreeNode left;
      TreeNode right;

      public TreeNode(int x) { val = x; }

      public String toString(){
            return String.valueOf(this.val);
      }
}
