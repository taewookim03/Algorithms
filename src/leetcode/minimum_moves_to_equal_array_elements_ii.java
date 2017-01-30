package leetcode;

import java.util.Arrays;

/**
 * Created by Taewoo Kim on 1/29/2017.
 * several possible solutions:
 *
 * sort and count diff from median from both ends O(nlogn) time / O(1, logn, n) space (depending on sort space req)
 *
 * find median using quickselect and add up abs(difference) - O(n) expected, O(n^2) worst time / O(logn) space / O(n) worst
 *
 * hashmap of element - frequency, count positive, negative, and zero elements, start from minimum and increment while
 * updating the numbers to calculate the abs difference - O(n) time, O(n) space but more work to code
 */
public class minimum_moves_to_equal_array_elements_ii {
    //sort - count method is easiest to code up in an interview and seems to be the fastest - 9ms
    public class Solution {
        public int minMoves2(int[] nums) {
            Arrays.sort(nums);
            int i = 0;
            int j = nums.length - 1;
            int sumDiff = 0;
            while (i < j){
                sumDiff += nums[j] - nums[i];// totalDiff = (median - nums[i]) + (nums[j] - median) = nums[j] - nums[i]
                i++;
                j--;
            }

            return sumDiff;
        }
    }


    //quickselect seems pretty slow at 100+ms but might be better with randomized pivot selection
    public class Solution2 {
        public int minMoves2(int[] nums) {
            if (nums.length == 1) return 0;

            int median = kSelect(nums, nums.length / 2, 0, nums.length - 1);//k is 0 indexed (e.g. smallest is 0th)
            int sumDiff = 0;
            for (int n : nums){
                sumDiff += Math.abs(median - n);
            }
            return sumDiff;
        }

        int kSelect(int[] nums, int k, int left, int right){
            int p = partition(nums, left, right);
            if (p == k) return nums[p];
            else if (k < p) return kSelect(nums, k, left, p-1);
            else return kSelect(nums, k, p+1, right);
        }

        int partition(int[] nums, int left, int right){
            //use modified hoare's partition that returns pivot in correct place (as opposed to the usual 2-block partition)
            if (left >= right) return right;
            //pick leftmost as pivot
            int pivot = nums[right];
            int i = left;
            int j = right;
            while (true){
                while (nums[i] < pivot && i < j) i++;
                while (nums[j] >= pivot && i < j) j--;
                if (i < j){
                    swap(nums, i, j);
                }
                else{
                    break;
                }
            }
            //put pivot and correct place (modification)
            swap(nums, right, i);
            return i;
        }
        void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
