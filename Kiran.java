package LeetProblem;

import java.util.*;

public class Kiran {
    int[] arr = new int[]{1,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,7,7,7,7,7,7,7};
//    int[] arr = new int[]{1,
//        1,
//        1,
//        1,
//        2,
//        2,
//        2,
//        3,
//        3,
//        3,
//        3,
//        4,
//        5,
//        5,
//        5,
//        6,
//        6,
//        6,
//        6,
//        7,
//        7,
//        7,
//        8,
//        8,
//        8,
//        8,
//        9,
//        9,
//        9,
//        9,
//        9,
//        10,
//        10,
//        11,
//        11,
//        11,
//        11,
//        11,
//        11,
//        12,
//        12,
//        12,
//        12,
//        12,
//        12,
//        12,
//        13,
//        13,
//        13,
//        13,
//        14,
//        14,
//        14,
//        14,
//        14,
//        16,
//        16,
//        16,
//        16,
//        16,
//        16,
//        17,
//        17,
//        17,
//        18,
//        18,
//        18,
//        18,
//        18,
//        18,
//        18,
//        18,
//        19,
//        19,
//        19,
//        19,
//        19,
//        19,
//        19,
//        20,
//        20,
//        20,
//        20,
//        20,
//        20,
//        20,
//        20,
//        20};

    public int dropCount(int[] arr){
        arr = this.arr;
        int drop=0;
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        TreeMap<Integer,Integer> dmap = new TreeMap<Integer,Integer>();
        for (int i: arr){
            int count = map.getOrDefault(i,0)+1;
            if(count > 3){
                drop++;
            }
            map.put(i,count);
        }
        System.out.println(map);
        System.out.println(drop);
        Integer ind10 = map.floorKey(10);
        Integer ind60 = map.floorKey(60);
        if(ind10 != null){
            int count = 0;
            for(int i : map.keySet()){
                if(i > 10){
                    break;
                }else{
                    count += map.get(i);
                }
            }
            if(count > 20){
                System.out.println(count+" "+(count-20));
                drop += count-20;
            }
        }
        if(ind60 != null){
            int count = 0;
            for(int i : map.keySet()){
                if(i > 60){
                    break;
                }else{
                    count += map.get(i);
                }
            }
            if(count > 60){
                System.out.println(count+" "+(count-60));
                drop += count-60;
            }
        }
        return drop;
    }

    public List<Integer> getanswer(){
        List<Integer> to = Arrays.asList(1,1,2,3,1);
        List<Integer> from=Arrays.asList(2,3,4,5,5);
        HashMap<Integer,List<Integer>> hm=new HashMap<>();
        int host=1;
        for(int i=0;i<5;i++){
            if(!hm.containsKey(to.get(i))){
                List<Integer> temp=new ArrayList<>();
                temp.add(from.get(i));
                hm.put(to.get(i),temp);
            }
            else{
                List<Integer> temp=hm.get(to.get(i));
                temp.add(from.get(i));
                hm.put(to.get(i),temp);
            }
        }
        for (Integer name: hm.keySet()){
            String key =name.toString();
            String value = hm.get(name).toString();
        }
        System.out.println(hm);
        Queue<String> q = new LinkedList<String>();
        q.offer(null);
        return null;
    }
}
