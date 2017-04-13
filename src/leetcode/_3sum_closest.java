package leetcode;
import java.util.Arrays;
/**
 * Created by Taewoo Kim on 4/9/2017.
 */
public class _3sum_closest {
    public class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int n = nums.length;
            int closestSum = nums[0] + nums[1] + nums[2];
            if (closestSum == target) return closestSum;

            for (int i = 0; i < n-2; i++){
                int left = i+1, right = n-1;
                while (left < right){
                    int sum = nums[i] + nums[left] + nums[right];
                    if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                        closestSum = sum;
                        if (closestSum == target) return closestSum;
                    }
                    if (sum <= target){
                        do left++; while (left < right && nums[left] == nums[left-1]);
                    }
                    else{
                        do right--; while (left < right && nums[right] == nums[right+1]);
                    }
                }
            }
            return closestSum;
        }
    }
}
