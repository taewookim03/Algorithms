package leetcode;

/**
 * Created by Taewoo Kim on 1/30/2017.
 */
public class product_of_array_except_self {
    //O(n) time O(1) space except result array
    //cumulative products for one direction does not have to be stored in an array, so store prefix products
    //and then walk backwards, multiplying with postfix products which are calculated at the same time
    public class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] p = new int[nums.length];

            p[0] = 1;
            for (int i = 1; i < p.length; i++){
                p[i] = p[i-1] * nums[i-1];
            }

            int q = 1;
            for (int i = p.length - 1; i >= 0; i--){
                p[i] *= q;
                q *= nums[i];
            }
            return p;
        }
    }


    //O(n) time O(n) space
    public class Solution2 {
        public int[] productExceptSelf(int[] nums) {
            int[] p = new int[nums.length];
            int[] q = new int[nums.length];

            p[0] = 1;
            for (int i = 1; i < p.length; i++){
                p[i] = p[i-1] * nums[i-1];
            }
            q[q.length-1] = 1;
            for (int i = q.length-2; i >= 0; i--){
                q[i] = q[i+1] * nums[i+1];
            }

            int[] result = new int[nums.length];
            for (int i = 0; i < result.length; i++){
                result[i] = p[i] * q[i];
            }
            return result;
        }
    }
}
