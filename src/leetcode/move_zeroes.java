package leetcode;

/**
 * Created by Taewoo Kim on 1/30/2017.
 */
public class move_zeroes {
    public class Solution {
        public void moveZeroes(int[] nums) {
            int i = 0;//first 0
            int j;//nonzero after i

            while (true){
                while (i < nums.length && nums[i] != 0) i++;
                j = i + 1;
                while (j < nums.length && nums[j] == 0) j++;
                if (j >= nums.length){
                    break;
                }
                else{
                    swap(nums, i++, j++);
                }
            }
        }
        void swap(int[] arr, int i, int j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
