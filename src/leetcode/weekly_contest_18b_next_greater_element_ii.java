package leetcode;

import java.util.ArrayDeque;

/**
 * Created by Taewoo Kim on 2/4/2017.
 */
public class weekly_contest_18b_next_greater_element_ii {
    //AC brute force
    public int[] nextGreaterElements2(int[] nums) {
        int  n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = -1;
            for (int k = i+1; k < i + n; k++) {
                if (nums[k%n] > nums[i]){
                    res[i] = nums[k%n];
                    break;
                }
            }
        }
        return res;
    }

    //Fast DP - solve as normal + remember index of the next biggest element (same complexity but still optimized)
    //when wrapping back around, can iterate through the cached increasing elements to find the next biggest element quickly
    public int[] nextGreaterElements(int[] nums) {
        int  n = nums.length;
        int[] res = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            res[i] = -1;
            dp[i] = -1;
            for (int j = i+1; j <n; j++) {
                if (nums[j] > cur){
                    res[i] = nums[j];
                    dp[i] = j;
                    break;
                }
            }
            if (dp[i] == -1){//no larger element to the right without wrapping around
                if (cur < nums[0]) res[i] = nums[0];
                else{
                    int k = 0;//wrap around to search
                    while (cur >= res[k] && k < i) {
                        if (dp[k] == -1) break;//this is max in the array
                        k = dp[k];//look for the next biggest element starting from 0 using dp array (stores index of next biggest)
                    }
                    if (k<i && cur < res[k])
                        res[i] = res[k];
                }
            }
        }
        return res;
    }

    //O(n) stack (fastest)
    //use a stack and traverse backward, keeping potentially larger element to the next of the element
    //have to start from length-2 because of the wrap
    public class Solution {
        public int[] nextGreaterElements(int[] nums) {
            //base case
            if (nums == null || nums.length == 0) return new int[0];

            int n = nums.length;
            int[] res = new int[n];

            //use a stack to track next greater element candidates
            //start from length-2 because of the wrap
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            for (int i = n-2; i >= 0; i--){
                while (!stack.isEmpty() && nums[i] >= stack.peek()) stack.pop();
                stack.push(nums[i]);
            }

            for (int i = n-1; i >= 0; i--){
                while (!stack.isEmpty() && nums[i] >= stack.peek()) stack.pop();
                if (stack.isEmpty()) res[i] = -1;
                else{
                    res[i] = stack.peek();
                }
                stack.push(nums[i]);
            }

            return res;
        }
    }

    //attempt (brute force)
    public static class Solution3 {
        public int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            int[] res = new int[n];

            for (int i = 0; i < n; i++){
                int found = -1;
                for (int j = i+1; j != i; j++){
                    if (j >= n) j = 0;
                    if (j == i) break;
                    if (nums[j] > nums[i]){
                        found = nums[j];
                        break;
                    }
                }
                res[i] = found;
            }

            return res;
        }
    }

    public static void main(String[] args){
        Solution3 s = new Solution3();
        int[] r = s.nextGreaterElements(new int[]{5,4,3,2,1});

        for (int i : r){
            System.out.print(i + " ");
        }
    }
}
