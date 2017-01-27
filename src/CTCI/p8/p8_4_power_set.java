package CTCI.p8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class p8_4_power_set {
    //return all subsets of a set
    static List<List<Integer>> allSubsets(List<Integer> set){
        List<List<Integer>> subsets = new ArrayList<>();
        buildSubset(subsets, new ArrayList<>(), set);
        return subsets;
    }

    static void buildSubset(List<List<Integer>> subsets, List<Integer> curr, List<Integer> avail){
        //base
        if (avail.isEmpty()) {
            subsets.add(curr);
            return;
        }

        List<Integer> newAvail = new ArrayList<>(avail);
        Integer first = newAvail.remove(0);
        buildSubset(subsets, curr, newAvail);
        List<Integer> newCurr = new ArrayList<>(curr);
        newCurr.add(first);
        buildSubset(subsets, newCurr, newAvail);
    }

    //using binary representation (same idea)
    static List<List<Integer>> allSubsets2(List<Integer> set){
        List<List<Integer>> subsets = new ArrayList<>();
        int iterations = 1 << set.size();//2^n where n is the set size
        for (int i = 0; i < iterations; i++){
            List<Integer> subset = binToSubset(set, i);
            subsets.add(subset);
        }
        return subsets;
    }
    static List<Integer> binToSubset(List<Integer> set, int b){
        List<Integer> subset = new ArrayList<>();
        int index = 0;

        while (b != 0){
            if ((b & 1) == 1){
                subset.add(set.get(index));
            }
            index++;
            b >>= 1;
        }
        return subset;
    }

    public static void main(String[] args){
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        //List<List<Integer>> subsets = allSubsets(list);
        List<List<Integer>> subsets = allSubsets2(list);//using binary numbers

        for (List<Integer> set : subsets){
            for (Integer i : set){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
