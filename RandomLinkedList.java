package LeetProblem;

public class RandomLinkedList {

    Node head;

    public RandomLinkedList(){
        this.head = new Node();
    }

    public class Node{
        int val;
        Node next, random;

        public Node(int val){
            this.val = val;
        }

        public Node() {

        }
    }

    public void printList(){
        Node temp = this.head;
        while(temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }


    public void createList(int[] arr){
        Node temp = head;
        for(int i=0;i<arr.length;i++){
            temp.next = new Node(arr[i]);
            temp=temp.next;
        }
    }

    public void copyRandomList(){
        Node ptr = this.head;
        while(ptr != null){
            Node temp = new Node(ptr.val);
            temp.next = ptr.next;
            ptr.next = temp;
            ptr = temp.next;
        }
    }

}
