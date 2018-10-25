package LeetProblem;

import java.util.Arrays;

public class BuildTree {


    public TreeNode buildBTree(int[] inorder,int[] postorder,int startInd,int endInd,int postInd){
        if(startInd > endInd){
            return null;
        }
        TreeNode node = new TreeNode(postorder[postInd++]);

        int rootIndex = Arrays.asList(inorder).indexOf(node.val);

        if(startInd == endInd){
            return node;
        }

        node.left = buildBTree(inorder,postorder,startInd,rootIndex-1,postInd);
        node.right = buildBTree(inorder,postorder,rootIndex+1,endInd,postInd);

        return node;
    }



    /**
     * Build tree for Inorder and post order expressions
     */

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int postInd = postorder.length -1;
        return buildBTree(inorder,postorder,0,inorder.length-1,postInd);
    }
}
