package LeetProblem;

import java.util.HashSet;

public class FruitsInBasket {

    public int totalFruit(int[] tree) {
        if(tree.length <= 2){
            return tree.length;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        int start =0;
        int end  = start+1;
        int maxFruits = Integer.MIN_VALUE;
        set.add(tree[start]);
        while(end<tree.length){
            if(!set.contains(tree[end])){
                set.add(tree[end]);
                if(set.size()>2){
                    // can be improved to set to start to the 2nd fruit last occurrence
                    set.clear();
                    start++;
                    set.add(tree[start]);
                    end=start+1;
                }else{
                    end++;
                    if(maxFruits <= end-start){
                        maxFruits = end-start;
                    }
                }
            }else{
                end++;
                if(maxFruits <= end-start){
                    maxFruits = end-start;
                }
            }
        }
        return maxFruits;
    }
}
