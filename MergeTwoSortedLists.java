package LeetProblem;

public class MergeTwoSortedLists {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }else if (l2==null){
            return l1;
        }
        ListNode h = new ListNode(-1);
        ListNode ptr = h;
        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                ptr.next = l1;
                ptr = l1;
                l1=l1.next;
            }else{
                ptr.next = l2;
                ptr=l2;
                l2=l2.next;
            }
        }
        if(l1 != null){
            ptr.next = l1;
        }
        if(l2 != null){
            ptr.next = l2;
        }
        return h.next;
    }
}
