package leetcode;

/**
 * Created by Taewoo Kim on 1/31/2017.
 * locked leetcode question #266
 * Given a string, determine if a permutation of the string could form a palindrome.

 For example,
 "code" -> False, "aab" -> True, "carerac" -> True.
 */
public class palindrome_permutation {
    public class Solution{
        public boolean palindromePermutation(String s){
            int[] charFreq = new int[256];
            for (int i = 0; i < s.length(); i++){
                charFreq[s.charAt(i)]++;
            }

            //could also do a single pass by updating odds for every frequency addition in above loop
            //(if it turns even, decrement odds. if it turns odd, increment)
            int odds = 0;
            for (int freq : charFreq){
                odds += freq & 1;
                if (odds > 1) return false;
            }
            return true;
        }
    }
}
