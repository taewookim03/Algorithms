package leetcode;

import java.util.List;
import java.util.Arrays;
/**
 * Created by Taewoo Kim on 4/2/2017.
 */
public class longest_uncommon_subsequence_ii {
    public class Solution {
        public int findLUSlength(String[] strs) {
            List<String> list = Arrays.asList(strs);
            list.sort((a,b)->b.length()-a.length());

            int n = list.size();
            for (int i = 0; i < n; i++){
                boolean unique = true;
                for (int j = 0; j < n; j++){
                    if (i == j) continue;
                    String a = list.get(i);
                    String b = list.get(j);
                    if (isSubseq(a, b)){
                        unique = false;
                        break;
                    }
                }
                if (unique){
                    return list.get(i).length();
                }
            }
            return -1;
        }

        private boolean isSubseq(String s, String t){
            int i = 0;
            for (int j = 0; j < t.length() && i < s.length(); j++){
                if (s.charAt(i) == t.charAt(j)) i++;
            }
            return i == s.length();
        }
    }
}
