package LeetProblem;

public class SumofRootToLeafBinaryNumbers {
    public int sumRootToLeaf(TreeNode root) {
        return this.dfs(root,0,new StringBuilder());
    }

    private int dfs(TreeNode root,int sum,StringBuilder sb){
        if(root.left == null && root.right == null){
            sb.append(root.val);
            sum += Integer.parseInt(sb.toString(),2);
            sb.setLength(sb.length()-1);
            return sum;
        }else{
            sb.append(root.val);
            int s = 0;
            if(root.left != null){
                s += this.dfs(root.left,sum,sb);
            }
            if(root.right != null){
                s += this.dfs(root.right,sum,sb);
            }
            sb.setLength(sb.toString().length()-1);
            return s;
        }
    }
}
