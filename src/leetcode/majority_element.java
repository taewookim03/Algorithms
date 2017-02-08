package leetcode;
import java.util.*;
/**
 * Created by Taewoo Kim on 2/8/2017.
 */
public class majority_element {
    //O(n) O(1) optimal Boyer-Moore Majority Vote Algorithm
    //http://www.cs.utexas.edu/~moore/best-ideas/mjrty/
    public class Solution {
        public int majorityElement(int[] nums) {
            int major = nums[0];
            int count = 1;
            for (int i = 1; i < nums.length; i++){
                if (count == 0){
                    major = nums[i];
                    count = 1;
                }
                else if (nums[i] == major){
                    count++;
                }
                else{
                    count--;
                }
            }
            return major;
        }
    }

    //typical O(n) O(n)
    public class Solution2 {
        public int majorityElement(int[] nums) {
            Map<Integer, Integer> freq = new HashMap<>();
            for (int num : nums){
                freq.put(num, freq.getOrDefault(num, 0) + 1);
                if (freq.get(num) > nums.length/2) return num;
            }
            return -1;
        }
    }
}
