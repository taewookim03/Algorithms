package leetcode;
import java.util.*;
/**
 * Created by Taewoo Kim on 3/31/2017.
 */

public class longest_substring_without_repeating_characters {
    public class Solution {
        public int lengthOfLongestSubstring(String s) {
            int longest = 0;
            Map<Character,Integer> map = new HashMap<>();
            for (int i = 0, j = 0; j < s.length(); j++){
                char c = s.charAt(j);
                if (map.containsKey(c) && map.get(c) >= i){
                    i = map.get(c) + 1;
                }
                map.put(c, j);
                longest = Math.max(longest, j - i + 1);
            }

            return longest;
        }
    }

    public class Solution2 {
        public int lengthOfLongestSubstring(String s) {
            int longest = 0;
            Set<Character> set = new HashSet<>();
            for (int i = 0, j = 0; j < s.length(); j++){
                char c = s.charAt(j);
                if (set.contains(c)){
                    while (s.charAt(i) != c){
                        set.remove(s.charAt(i));
                        i++;
                    }
                    i++;
                }
                set.add(s.charAt(j));
                longest = Math.max(longest, j - i + 1);
            }

            return longest;
        }
    }
}
