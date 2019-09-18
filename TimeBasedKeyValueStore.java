package LeetProblem;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {
    class TimeMap {

        Map<String,TreeMap<Integer,String>> map;
        /** Initialize your data structure here. */
        public TimeMap() {
            this.map = new HashMap<String,TreeMap<Integer, String>>();
        }

        public void set(String key, String value, int timestamp) {
            TreeMap<Integer, String> tmap = this.map.getOrDefault(key, new TreeMap<Integer,String>());
            tmap.put(timestamp,value);
            this.map.put(key,tmap);
        }

        public String get(String key, int timestamp) {
            if(this.map.containsKey(key)){
                TreeMap<Integer, String> tmap = this.map.get(key);
                if(tmap.containsKey(timestamp)){
                    return tmap.get(timestamp);
                }else{
                    return (tmap.floorKey(timestamp) == null)?"":tmap.get(tmap.floorKey(timestamp));
                }
            }else{
                return "";
            }
        }
    }

}
