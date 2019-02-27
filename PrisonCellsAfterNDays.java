package LeetProblem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class PrisonCellsAfterNDays {
    private int[] nextDay(int[] cells){
        HashSet<Integer> zero = new HashSet<Integer>();
        HashSet<Integer> one = new HashSet<Integer>();
        for(int i=1;i<cells.length-1;i++){
            if((cells[i-1] == 0 && cells[i+1] == 0) || (cells[i-1] == 1 && cells[i+1] == 1)){
                one.add(i);
            }else{
                zero.add(i);
            }
        }
        for(int i:zero){
            cells[i] = 0;
        }
        for(int i:one){
            cells[i] = 1;
        }
        cells[0] = 0;
        cells[cells.length-1] = 0;
        return cells;
    }

    public int[] prisonAfterNDays(int[] cells, int N) {
        HashMap<String, Integer> seen = new HashMap<>();
        while (N > 0) {
            seen.put(Arrays.toString(cells), N--);
            cells = nextDay(cells);
            if (seen.containsKey(Arrays.toString(cells))) {
                N %= seen.get(Arrays.toString(cells)) - N;
            }
        }
        return cells;
    }
}
