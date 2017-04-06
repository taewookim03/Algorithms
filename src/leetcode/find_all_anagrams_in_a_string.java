package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Taewoo Kim on 4/4/2017.
 */
public class find_all_anagrams_in_a_string {
    public class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int[] count = new int[256];
            int n = s.length();
            int m = p.length();
            List<Integer> res = new ArrayList<>();

            if (n < m) return res;

            for (int i = 0; i < m; i++){
                count[p.charAt(i)]++;
            }

            int lettersLeft = m;

            for (int i = 0; i < m; i++){
                if (count[s.charAt(i)] > 0) lettersLeft--;
                count[s.charAt(i)]--;
            }
            for (int left = 0; left < n-m; left++){
                if (lettersLeft == 0) res.add(left);

                //shift right by one char
                if (count[s.charAt(left)] >= 0) lettersLeft++;
                count[s.charAt(left)]++;

                if (count[s.charAt(left+m)] > 0) lettersLeft--;
                count[s.charAt(left+m)]--;
            }
            //last check
            if (lettersLeft == 0) res.add(n-m);

            return res;
        }
    }
}
