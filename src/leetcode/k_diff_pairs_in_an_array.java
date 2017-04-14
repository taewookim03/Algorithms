package leetcode;
import java.util.*;

public class k_diff_pairs_in_an_array {
    public class Solution {
        public int findPairs(int[] nums, int k) {
            int n = nums.length;
            if (k < 0 || n < 1) return 0;

            Map<Integer,Integer> freqMap = new HashMap<>();
            for (int i : nums){
                freqMap.put(i, freqMap.getOrDefault(i,0)+1);
            }

            int count = 0;
            if (k == 0){
                for (int f : freqMap.values()){
                    if (f >= 2) count++;
                }
            }
            else{
                for (int key : freqMap.keySet()){
                    if (freqMap.containsKey(key + k)) count++;
                }
            }

            return count;
        }
    }
}
