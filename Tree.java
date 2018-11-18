package LeetProblem;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    public int index;

    public Tree(){
        this.index = 0;
    }

    public TreeNode serialize(String data){
        String[] arr = data.split(",");
        this.index = 0;
        return preOrderDeserialize(arr);
    }

    private TreeNode preOrderDeserialize(String[] data){
        if(this.index >= data.length || data[this.index].compareTo("null") == 0){
            this.index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(data[index++]));
        root.left = preOrderDeserialize(data);
        root.right = preOrderDeserialize(data);
        return root;
    }

    private String deserialize(TreeNode root){
        List<String> str = new ArrayList<String>();
        str = preOrderSerialize(root,str);
        return String.join(",",str);
    }

    private List<String> preOrderSerialize(TreeNode node, List<String> str){
        if(node == null){
            str.add("null");
            return str;
        }
        str.add(String.valueOf(node.val));
        preOrderSerialize(node.left,str);
        preOrderSerialize(node.right,str);
        return str;
    }

    public void printTree(TreeNode root){
        System.out.println(this.deserialize(root));
    }

    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        this.inOrder(root.left);
        System.out.println(root.val);
        this.inOrder(root.right);
    }

    public void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.val);
        this.preOrder(root.left);
        this.preOrder(root.right);
    }

    public void postOrder(TreeNode root){
        if(root == null){
            return;
        }
        this.postOrder(root.left);
        this.postOrder(root.right);
        System.out.println(root.val);
    }

}
