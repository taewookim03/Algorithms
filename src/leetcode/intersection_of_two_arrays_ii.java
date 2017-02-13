package leetcode;
import java.util.*;
/**
 * Created by Taewoo Kim on 2/12/2017.
 */
public class intersection_of_two_arrays_ii {
    public class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            Map<Integer, Integer> counts = new HashMap<>();
            for (int num : nums1){
                counts.put(num, counts.getOrDefault(num, 0) + 1);
            }

            List<Integer> res = new ArrayList<>();
            for (int num : nums2){
                if (counts.get(num) != null){
                    res.add(num);
                    counts.put(num, counts.get(num) - 1);
                    if (counts.get(num) == 0){
                        counts.remove(num);
                    }
                }
            }

            return res.stream().mapToInt(i->i).toArray();
        }
    }
}
