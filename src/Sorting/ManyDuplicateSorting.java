package Sorting;

import java.util.Map;
import java.util.TreeMap;

//http://www.algorist.com/algowiki/index.php/TADM2E_4.23
//O(nlogk) where k = number of distinct elements
class ManyDuplicateSorting {
    //self-balancing BST

    static void sort(int[] arr){
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i : arr){
            if (map.containsKey(i)){
                map.put(i, map.get(i)+1);
            }
            else{
                map.put(i, 1);
            }
        }

        int j = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            for (int i = 0; i < entry.getValue(); i++){
                arr[j++] = entry.getKey();
            }
        }
    }

    public static void main(String[] args){
        int[] arr = new int[]{4, 1, 1, 1, 2, 3, 2, 4, 2, 4, 2, 4, 3, 1, 4, 1, 2, 2, 3, 1, 3, 3, 1, 4, 2};
        sort(arr);
        for (int i : arr){
            System.out.print(i + " ");
        }
    }
}
