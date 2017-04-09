package leetcode;
import java.util.*;

/**
 * Created by Taewoo Kim on 4/9/2017.
 */

public class _3sum {
    public class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> res = new ArrayList<>();
            int n = nums.length;
            for (int i = 0; i < n-2; i++){
                if (i != 0 && nums[i] == nums[i-1]) continue;
                int left = i+1, right = n-1;
                while (left < right){
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum == 0) {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    }
                    if (nums[left] == nums[right]) break;
                    if (sum > 0) {
                        do right--; while (left < right && nums[right] == nums[right+1]);
                    }
                    else {
                        do left++; while (left < right && nums[left] == nums[left-1]);
                    }
                }
            }
            return res;
        }
    }
}
