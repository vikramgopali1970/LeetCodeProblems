package LeetProblem;

public class RecoverBST {
    public void recoverTree(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode first=null,second=null,pre=null;
        while(null != root){
            if(root.left == null){
                //printNode
                if(pre!=null && pre.val > root.val){
                    if(first == null){
                        first = pre;
                        second = root;
                    }else{
                        second = root;
                    }
                }
                pre = root;
                root = root.right;
            }else{
                TreeNode temp = root.left;
                while(temp.right!= null && temp.right != root){
                    temp = temp.right;
                }
                if(temp.right != null){
                    if(pre!=null && pre.val > root.val){
                        if(first == null){
                            first = pre;
                            second = root;
                        }else{
                            second = root;
                        }
                    }
                    temp.right = null;
                    pre = root;
                    root = root.right;
                }else{
                    temp.right = root;
                    root=root.left;
                }
            }
        }
        // System.out.println(first.val+" "+second.val);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
