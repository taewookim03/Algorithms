package leetcode;

/**
 * Created by Taewoo Kim on 1/30/2017.
 */
public class single_number_iii {
    //clever solution based on the fact the first pass of x = a ^ b, which contains bits set between a and b
    //choose 1 such bit (least significant bit set here)
    //then the second pass can divide the numbers into two groups - one that has the bit set, and the other that doesn't
    //two numbers will be divided into this group so the usual trick of xor works
    public class Solution {
        public int[] singleNumber(int[] nums) {
            int x = 0;
            for (int n : nums){
                x ^= n;
            }
            //x = a ^ b
            x = x & -x;//x = least significant bit (chosen arbitrarily) of a ^ b

            int a = 0;
            int b = 0;
            for (int n : nums){
                if ((n & x) > 0){//number has x set
                    a ^= n;
                }
                else{
                    b ^= n;
                }
            }

            return new int[]{a, b};
        }
    }
}
