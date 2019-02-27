package LeetProblem;

public class MergekSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        public ListNode(int x) { val = x; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        int interval = 1;
        while(interval < lists.length){
            System.out.println(interval);
            for(int i=0;i<lists.length-interval;i+=interval*2){
                lists[i] = this.merge2List(lists[i],lists[i+interval]);
            }
            interval *=2;
        }
        return lists[0];
    }

    private ListNode merge2List(ListNode l1, ListNode l2){
        ListNode th = new ListNode(-1);
        ListNode h = th;
        while(l1 !=null && l2 != null){
            if(l1.val <= l2.val){
                h.next = l1;
                // h=l1;
                l1=l1.next;
            }else{
                h.next = l2;
                // h = l2;
                l2=l2.next;
            }
            h=h.next;
        }
        if(l1 != null){
            h.next = l1;
        }
        if(l2 !=null){
            h.next = l2;
        }
        return th.next;
    }
}
