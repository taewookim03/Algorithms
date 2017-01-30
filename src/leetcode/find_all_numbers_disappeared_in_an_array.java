package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Taewoo Kim on 1/29/2017.
 */
public class find_all_numbers_disappeared_in_an_array {
    //could use a boolean array - O(n) space
    //O(1) extra space by modifying input array:
    public class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            //use input array as sort of a boolean array
            //since input is all positive, mark negative on elements seen (as index)
            for (int i = 0; i < nums.length; i++){
                nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
            }

            List<Integer> result = new ArrayList<>();

            //add non-marked elements
            for (int i = 0; i < nums.length; i++){
                if (nums[i] > 0){
                    result.add(i+1);
                }
            }
            return result;
        }
    }
}
