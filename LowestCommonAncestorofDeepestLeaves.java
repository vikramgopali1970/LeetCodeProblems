package LeetProblem;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LowestCommonAncestorofDeepestLeaves {
    ArrayList<TreeNode> leafNodes = new ArrayList<TreeNode>();
    int maxLevel = 0;
    int ind = 0;
    TreeNode res = null;

    private int dfs(TreeNode root,int count, int level){
        if(root == null){
            return count;
        }else if(level == this.maxLevel && root.equals(this.leafNodes.get(ind))){
            this.ind++;
            return count+1;
        }else{
            int lcount = this.dfs(root.left, 0, level+1);
            int rcount = this.dfs(root.right, 0, level+1);
            if(lcount + rcount == this.leafNodes.size()){
                this.res = root;
                return 0;
            }
            return (lcount + rcount);
        }
    }

    private int bfs(TreeNode root){
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        q.offer(null);
        int level = 0;
        this.leafNodes.add(root);
        ArrayList<TreeNode> leafNodes = new ArrayList<TreeNode>();
        while(!q.isEmpty()){
            if(q.peek() == null){
                q.poll();
                if(!q.isEmpty()){
                    q.offer(null);
                    level++;
                    this.leafNodes = new ArrayList<TreeNode>(leafNodes);
                    leafNodes.clear();
                }
            }else{
                TreeNode pop = q.poll();
                if(pop.left != null){
                    q.offer(pop.left);
                    leafNodes.add(pop.left);
                }
                if(pop.right != null){
                    q.offer(pop.right);
                    leafNodes.add(pop.right);
                }
            }
        }
        return level;
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root == null){
            return root;
        }
        this.maxLevel = this.bfs(root);
        if(this.leafNodes.size() == 1){
            return this.leafNodes.get(0);
        }
        this.dfs(root, 0, 0);
        return this.res;
    }
}
