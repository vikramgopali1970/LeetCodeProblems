package LeetProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathInZigzagLabelledBinaryTree {
    private int getLevel(int label){
        int n=1, cur = 1;
        while(label >= cur){
            n++;
            cur = (int)Math.pow(2,(n-1));
        }
        return n-1;
    }

    private int getParent(int child, int level){
        return this.getMirrorElement(child/2,level-1);
    }

    private int getMirrorElement(int node, int level){
        int totalNodes = (int)Math.pow(2,level-1);
        int pos = node - totalNodes;
        int mirrPos = totalNodes - pos;
        return totalNodes + mirrPos - 1;
    }

    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new ArrayList<Integer>();
        int level = this.getLevel(label);
        res.add(label);
        int parent = getParent(label,level);
        while(parent >= 1){
            res.add(parent);
            level--;
            parent = this.getParent(parent,level);
        }
        Collections.reverse(res);
        return res;
    }
}
