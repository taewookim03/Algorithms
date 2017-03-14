package leetcode;

/**
 * Created by Taewoo Kim on 2/27/2017.
 */
public class maximum_product_of_word_lengths {
    public class Solution {
        public int maxProduct(String[] words) {
            //O(n^2) compare everything with O(1) bit manipulation intersect check
            int n = words.length;
            int[] bits = new int[n];
            for (int i = 0; i < n; i++){
                bits[i] = strToBits(words[i]);
            }

            int maxProduct = 0;
            for (int i = 0; i < n; i++){
                for (int j = i+1; j < n; j++){
                    if ((bits[i] & bits[j]) == 0 && words[i].length() * words[j].length() > maxProduct){
                        maxProduct = words[i].length() * words[j].length();
                    }
                }
            }
            return maxProduct;
        }

        int strToBits(String s){
            int x = 0;
            for (int i = 0; i < s.length(); i++){
                int k = s.charAt(i) - 'a';
                x |= (1 << k);
            }
            return x;
        }
    }
}
