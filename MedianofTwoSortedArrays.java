package LeetProblem;

import java.util.HashMap;
import java.util.HashSet;

public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int len = nums1.length+nums2.length;
//        if(nums1.length == 0){
//            return (len%2==0)?(float)(nums2[(len/2)-1]+nums2[len/2])/2:nums2[len/2];
//        }
//        if(nums2.length == 0){
//            return (len%2==0)?(float)(nums1[(len/2)-1]+nums1[len/2])/2:nums1[len/2];
//        }
//        int[] merge = new int[(len/2)+1];
//        int i=0,j=0,ind=0;
//        float ans=-1;
//        while(ind < merge.length){
//            if(i < nums1.length && j< nums2.length){
//                if(nums1[i] <= nums2[j]){
//                    merge[ind++] = nums1[i++];
//                }else{
//                    merge[ind++] = nums2[j++];
//                }
//            }else if(i < nums1.length){
//                merge[ind++] = nums1[i++];
//            }else{
//                merge[ind++] = nums2[j++];
//            }
//        }
//        return (len%2==0)?(float)(merge[merge.length-1]+merge[merge.length-2])/2:merge[merge.length-1];
//        String m = "IJXNLSJI".toLowerCase();
//        char[] arr = m.toCharArray();
//        int a = (int)'a';
//        for(int j=0;j<27;j++){
//            for(int i=0;i<arr.length;i++){
//                char c = arr[i];
//                int val = (int)(c-'a');
//                int newval = (val+j)%26;
//                System.out.print((char)(newval+a));
//            }
//            System.out.println();
//        }

        System.out.println(check(689));
        HashSet<String> s = new HashSet<>();
        for(int i=1;i<1001;i++){
            for(int j=1;j<1001;j++){
                if(i*j < 1000 && check(i*j)){
                    s.add(Math.min(i,j)+":"+Math.max(i,j));
                }
            }
        }
        System.out.println(s+" "+s.size());
        return 0;

//        String m = Math.min(i,j)+";"+Math.max(i,j);
    }

    private boolean check(int a){
        char[] arr = String.valueOf(a).toCharArray();
        int p = -1;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            int num = arr[i]-'0';
            set.add(num);
            if(num < p){
                return false;
            }else{
                p=num;
            }
        }
        return (set.size() == arr.length);
    }
}

// what company designed the game genie