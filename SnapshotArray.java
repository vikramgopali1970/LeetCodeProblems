package LeetProblem;

import java.util.TreeMap;

public class SnapshotArray {
    TreeMap<Integer, Integer>[] snapShot;
    int snap_id;

    public SnapshotArray(int length) {
        this.snap_id = 0;
        this.snapShot = new TreeMap[length];
        for(int i=0;i<length;i++){
            this.snapShot[i] = new TreeMap<Integer, Integer>();
            this.snapShot[i].put(0,0);
        }
    }

    public void set(int index, int val) {
        this.snapShot[index].put(this.snap_id,val);
    }

    public int snap() {
        return this.snap_id++;
    }

    public int get(int index, int snap_id) {
        int key = this.snapShot[index].floorKey(snap_id);
        return this.snapShot[index].get(key);
    }
}
