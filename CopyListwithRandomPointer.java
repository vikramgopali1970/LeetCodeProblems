package LeetProblem;

public class CopyListwithRandomPointer {

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };

    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        Node p1 = head;
        while(p1!=null){
            Node temp = new Node(p1.val,null,null);
            temp.next = p1.next;
            p1.next = temp;
            p1=temp.next;
        }
        p1=head;
        while(p1 != null){
            p1.next.random = (p1.random==null)?null:p1.random.next;
            p1=p1.next.next;
        }
        p1=head;
        Node res = head.next;
        Node p2=res;
        while(p1!=null){
            System.out.println(p1.val+" "+p2.val);
            p1.next = p2.next;
            p2.next = (p2.next == null)?null:p2.next.next;
            p1 = p1.next;
            p2=p2.next;
        }
        return res;
    }
}
