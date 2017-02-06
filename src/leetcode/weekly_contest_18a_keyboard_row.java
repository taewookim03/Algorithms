package leetcode;
import java.util.*;
/**
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.
 Example 1:
 Input: ["Hello", "Alaska", "Dad", "Peace"]
 Output: ["Alaska", "Dad"]
 Note:
 You may use one character in the keyboard more than once.
 You may assume the input string will only contain letters of alphabet.
 */
public class weekly_contest_18a_keyboard_row {
    public class Solution {
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";

        Map<Character, Integer> map = new HashMap<>();
        {
            for (int i = 0; i < row1.length(); i++){
                map.put(row1.charAt(i), 1);
            }
            for (int i = 0; i < row2.length(); i++){
                map.put(row2.charAt(i), 2);
            }
            for (int i = 0; i < row3.length(); i++){
                map.put(row3.charAt(i), 3);
            }
        }

        public String[] findWords(String[] words) {

            List<String> result = new ArrayList<>();
            for (String s : words){
                if (oneRow(s.toLowerCase())) result.add(s);
            }
            return result.toArray(new String[result.size()]);
        }

        public boolean oneRow(String s){
            if (s.length() == 0) return false;
            Integer group = map.get(s.charAt(0));
            for (int i = 1; i < s.length(); i++){
                if (!map.get(s.charAt(i)).equals(group)) return false;
            }
            return true;
        }
    }
}
