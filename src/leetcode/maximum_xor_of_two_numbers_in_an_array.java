package leetcode;
import java.util.*;
/**
 * Created by Taewoo Kim on 2/13/2017.
 */
public class maximum_xor_of_two_numbers_in_an_array {
    public class Solution {
        public int findMaximumXOR(int[] nums) {
            int mask = 0, max = 0;
            for (int i = 31; i >= 0; i--){
                mask |= (1 << i);

                Set<Integer> candidates = new HashSet<>();
                for (int num : nums){
                    candidates.add(num & mask);
                }

                int possibleMax = max | (1 << i);
                for (int num : candidates){
                    if (candidates.contains(num ^ possibleMax)){
                        max = possibleMax;
                        break;
                    }
                }
            }
            return max;
        }
    }
}
