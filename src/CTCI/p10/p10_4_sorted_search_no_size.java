package CTCI.p10;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class p10_4_sorted_search_no_size {
    private static class Listy extends ArrayList<Integer>{
        @Override
        public Integer get(int index) {
            if (index >= this.size()) return -1;
            return super.get(index);
        }
    }
    static int searchNoSize(Listy list, int val){
        int size = 1;
        while (!list.get(size).equals(-1)){
            size *= 2;
        }

        //use approx size
        return binSearch(list, 0, size-1, val);
    }
    static int binSearch(Listy list, int lo, int hi, int val){
        if (lo > hi) return -1;
        int mid = (lo + hi)/2;

        if (list.get(mid).equals(val)) return mid;
        else if (list.get(mid) == -1 || list.get(mid) > val) return binSearch(list, lo, mid-1, val);
        else return binSearch(list, mid+1, hi, val);
    }

    public static void main(String[] args){
        Listy list = new Listy();

        Random rand = new Random();
        for (int i = 1; i <= 20; i++){
            list.add(i + rand.nextInt(2));
        }
        for (Integer i : list){
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println(searchNoSize(list, 15));
    }
}
