package LeetProblem;

import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterNodeInLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public int[] nextLargerNodes(ListNode head) {
        ListNode temp = head;
        int c = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(temp != null){
            list.add(temp.val);
            temp=temp.next;
        }
        Stack<Integer> s = new Stack<Integer>();
        int[] res = new int[list.size()];
        for(int i=0;i<list.size();i++){
            while(!s.isEmpty() && list.get(i) > list.get(s.peek())){
                res[s.pop()] = list.get(i);
            }
            s.push(i);
        }
        return res;
    }
}
