package LeetProblem;

import java.util.*;

public class YelpHackerRank {

    public void main1(){
        String[] b = new String[]{"Starbucks","Peets Coffee", "Whole Foods", "Starbucks", "Peets Coffee","Starbucks", "Whole Foods", "Whole Foods"};
        String[] l = new String[]{"Seattle", "San Francisco", "Austin", "San Francisco", "Austin", "Austin", "Austin", "Austin"};
        String[] id = new String[]{"101", "102", "103", "104", "105", "106", "103", "107"};
        ArrayList<Business> businesses = new ArrayList<Business>();
        for(int i=0;i<b.length;i++){
            businesses.add(new Business(b[i], l[i], id[i]));
        }
        String location = "Austin";
        System.out.println(detectAndOrderChainBusiness(businesses, location));
    }

    public static class Business{
        String name;
        String location;
        String id;

        public Business(String name, String location, String id){
            this.name = name;
            this.location = location;
            this.id = id;
        }

        public String toString(){
            return this.name+" - "+this.location+" - "+this.id;
        }
    }

    public static class Chain{
        String name;
        int frequency;

        public Chain(String name, int frequency){
            this.frequency = frequency;
            this.name = name;
        }

        public String toString(){
            return this.name+" - "+this.frequency;
        }
    }

    public static List<Chain> detectAndOrderChainBusiness(List<Business> businesses, String location){
        HashMap<String, HashSet<Chain>> map = new HashMap<String, HashSet<Chain>>();
        HashSet<String> iset = new HashSet<>();
        HashSet<String> lset = new HashSet<>();
        for(Business b: businesses){
            if(b.location.equals(location)){
                if(!iset.contains(b.id)){
                    //do nothing
                    HashSet<Chain> chain = null;
                    if(lset.contains(b.name)){
                        //update
                        chain = map.getOrDefault(b.location, new HashSet<Chain>());
                        int count = 0;
                        Chain cc = null;
                        for(Chain c : chain){
                            if(c.name.equals(b.name)){
                                cc = c;
                                break;
                            }
                        }
                        chain.remove(cc);
                        chain.add(new Chain(cc.name,cc.frequency+1));
                    }else{
                        //add
                        chain = map.getOrDefault(b.location, new HashSet<Chain>());
                        chain.add(new Chain(b.name,1));
                    }
                    map.remove(b.location);
                    map.put(b.location, chain);
                    lset.add(b.name);
                    iset.add(b.id);
                }
            }
        }
        ArrayList<Chain> result = new ArrayList<Chain>(map.get(location));
        Collections.sort(result, new Comparator<Chain>() {
            @Override
            public int compare(Chain o1, Chain o2) {
                if(o1.frequency == o2.frequency){
                    return o1.name.compareTo(o2.name);
                }else{
                    return Integer.compare(o2.frequency, o1.frequency);
                }
            }
        });
        return result;
    }
}
