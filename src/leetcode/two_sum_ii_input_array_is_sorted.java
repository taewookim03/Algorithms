package leetcode;

/**
 * Created by Taewoo Kim on 1/30/2017.
 */
public class two_sum_ii_input_array_is_sorted {
    public class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int i = 0;
            int j = numbers.length - 1;

            while (i < j){
                int sum = numbers[i] + numbers[j];
                if (sum == target){
                    return new int[]{i+1, j+1};
                }
                if (sum < target){
                    i++;
                }
                else{
                    j--;
                }
            }
            return null;
        }
    }
}
