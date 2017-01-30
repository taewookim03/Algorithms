package Search;

import java.util.ArrayList;

/**
 * Created by Taewoo Kim on 1/28/2017.
 */
public class kselect_hoare {
    static public class Solution {
        public int minMoves2(int[] nums) {
            if (nums.length == 1) return 0;

            int median = kSelect(nums, nums.length / 2, 0, nums.length - 1);//k is 0 indexed (e.g. smallest is 0th)
            int sumDiff = 0;
            for (int n : nums){
                sumDiff += Math.abs(median - n);
            }
            return sumDiff;
        }

        public int kSelect(int[] nums, int k, int left, int right){
            int p = partition(nums, left, right);
            if (p == k) return nums[p];
            else if (k < p) return kSelect(nums, k, left, p-1);
            else return kSelect(nums, k, p+1, right);
        }

        public int partition(int[] nums, int left, int right){
            if (left >= right) return left;
            //pick leftmost as pivot
            int pivot = nums[left];
            int i = left - 1;
            int j = right + 1;
            while (true){
                do i++; while (nums[i] < pivot);
                do j--; while (nums[j] > pivot);

                if (i < j){
                    swap(nums, i, j);
                }
                else{
                    break;
                }
            }
            return j;
        }
        public void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.minMoves2(new int[]{3, 1, 2}));
    }
}
