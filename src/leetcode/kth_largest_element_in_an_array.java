package leetcode;

/**
 * Created by Taewoo Kim on 4/7/2017.
 */
public class kth_largest_element_in_an_array {
    public class Solution {
        public int findKthLargest(int[] nums, int k) {
            return findKthLargestUtil(nums, k, 0, nums.length-1);
        }

        private int findKthLargestUtil(int[] nums, int k, int left, int right){
            int n = nums.length;
            int p = partition(nums, left, right);
            if (p == n-k) return nums[p];
            if (p < n-k) return findKthLargestUtil(nums, k, p+1, right);
            return findKthLargestUtil(nums, k, left, p-1);
        }

        private int partition(int[] nums, int left, int right){
            int pivot = nums[right];
            int i = left, j = right;

            while (true){
                while (i < j && nums[i] < pivot) i++;
                while (i < j && nums[j] >= pivot) j--;
                if (i >= j) break;
                else{
                    swap(nums, i, j);
                }
            }
            swap(nums, i, right);
            return i;
        }
        private void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
