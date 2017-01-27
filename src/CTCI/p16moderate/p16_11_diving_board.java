package CTCI.p16moderate;

import java.util.ArrayList;
import java.util.List;

class p16_11_diving_board {
    static List<Integer> lengths(int shorter, int longer, int k){
        List<Integer> list = new ArrayList<>();
        if(shorter == longer){
            list.add(shorter*k);
            return list;
        }
        for (int i = shorter*k; i <= longer*k; i+=(longer-shorter)){
            list.add(i);
        }
        return list;
    }
    public static void main(String[] args){
        List<Integer> list = lengths(3, 5, 5);
        for (Integer i : list){
            System.out.println(i);
        }
    }
}
