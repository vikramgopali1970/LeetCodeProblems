package LeetProblem;

import java.util.HashSet;

public class UniqueStores {

    public int UniqueStores(String dirs){
        int[] pos = new int[]{0,0};
        HashSet<Integer> visitedStores = new HashSet<Integer>();
        for(int i=0;i<dirs.length();i++){
            char c = dirs.charAt(i);
            if(c == 'N'){
                pos[0]+= 0;
                pos[1]+= 1;
                visitedStores.add((pos[0])*10+(pos[1]));
            }else if(c == 'S'){
                pos[0]+= 0;
                pos[1]+= -1;
                visitedStores.add((pos[0])*10+(pos[1]));
            }else if(c == 'W'){
                pos[0]+= -1;
                pos[1]+= 0;
                visitedStores.add((pos[0])*10+(pos[1]));
            }else{
                pos[0]+= 1;
                pos[1]+= 0;
                visitedStores.add((pos[0])*10+(pos[1]));
            }
        }
        return visitedStores.size();
    }
}
