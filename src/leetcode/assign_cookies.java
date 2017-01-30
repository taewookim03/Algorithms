package leetcode;

import java.util.Arrays;

/**
 * Created by Taewoo Kim on 1/30/2017.
 */
public class assign_cookies {
    public class Solution {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int i = 0, j = 0;
            while (i < g.length && j < s.length){
                if (g[i] <= s[j]){
                    i++;
                }
                j++;
            }

            return i;
        }
    }
}
