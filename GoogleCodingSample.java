package LeetProblem;

import java.util.Arrays;
import java.util.Comparator;

public class GoogleCodingSample {

    int res;
    public class Node{
        int ind;
        int val;

        public Node(int ind,int val){
            this.ind = ind;
            this.val = val;
        }

        public String toString(){
            return "["+this.val+","+this.ind+"]";
        }
    }

    public int reachable(int[] arr){
        if(arr.length <2){
            return arr.length;
        }
        this.res = 0;
        Node[] items = new Node[arr.length];
        for(int i=0;i<arr.length;i++){
            items[i] = new Node(i,arr[i]);
        }

        Arrays.sort(items, new Comparator<Node>() {
            public int compare(Node o1, Node o2) {
                return Integer.compare(o1.val,o2.val);
            }
        });

        for(int i=0;i<items.length;i++){
            reachableHelper(items,i,1);
        }
        return this.res;
    }

    private void reachableHelper(Node[] arr, int ind, int count) {

        if(arr[ind].ind+1 == arr.length){
            this.res = this.res+1;
            return;
        }
        Node tmp = null;
        if(count%2==0){
            //even pass
            for(int i=ind-1;i>=0;i--){
                if(arr[i].val < arr[ind].val && arr[i].ind > arr[ind].ind){
                    reachableHelper(arr,i,count+1);
                    break;
                }
            }
            return;
        }else{
            //odd pass
            for(int i=ind+1;i<arr.length;i++){
                if(arr[i].val > arr[ind].val && arr[i].ind > arr[ind].ind){
                    reachableHelper(arr,i,count+1);
                    break;
                }
            }
            return;
        }

    }


}