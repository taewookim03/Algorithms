package Arrays;//http://www.geeksforgeeks.org/given-an-array-of-of-size-n-finds-all-the-elements-that-appear-more-than-nk-times/
//tetris
//this uses array for O(nk), but using self-balancing BST yields O(n logk)
//or use hash for O(n) avg (but extra space more than O(k)?)

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class FindFrequentElements {
    static void moreThanNdK(int[] arr, int k){
        //USING HASHMAP RESULTS IN EXTRA MEMORY EXCEEDING O(k) USE ARRAY FOR NO SIGNIFICANT SPACE REQUIREMENT
        //self-balancing BST map would make this O(n logk)
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i : arr){
            if (freq.containsKey(i)){
                freq.put(i, freq.get(i) + 1);
            }
            else{
                if (freq.size() == k){
                    Iterator<Map.Entry<Integer, Integer>> it = freq.entrySet().iterator();
                    while (it.hasNext()){
                        Map.Entry<Integer, Integer> entry = it.next();
                        freq.put(entry.getKey(), entry.getValue() - 1);
                        if (entry.getValue() == 0) it.remove();
                    }
                }
                else{
                    freq.put(i, 1);
                }
            }
        }
        //process array with values in the freq keys remaining
        //new map would be more memory
        //freq is of size < k at this point
        for (Integer key : freq.keySet()){
            freq.put(key, 0);
        }

        for (int i : arr){
            if (freq.get(i) != null) freq.put(i, freq.get(i) + 1);
        }

        for (Integer key : freq.keySet()){
            if (freq.get(key) > arr.length/k) System.out.println("num: " + key + " count: " + freq.get(key));
        }
        System.out.println();

        //naive O(n) space
//        /*
//        for (Integer key : freq.keySet()){
//            int count = 0;
//            for (int i : arr){
//                if (key == i) count++;
//            }
//            if (count > arr.length / k) System.out.println("num: " + key + " count: " + count);
//        }
//        System.out.println();
//        */
    }

    public static void main(String[] args){
        int[] arr1 = {4, 5, 6, 7, 8, 4, 4};
        moreThanNdK(arr1, 3);
        int[] arr2 = {4, 2, 2, 7};
        moreThanNdK(arr2, 3);
        int[] arr3 = {2, 7, 2};
        moreThanNdK(arr3, 2);
        int[] arr4 = {2, 3, 3, 2};
        moreThanNdK(arr4, 3);
    }
}
