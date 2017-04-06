package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Taewoo Kim on 4/2/2017.
 */
public class valid_parentheses {
    public class Solution {
        public boolean isValid(String s) {
            Deque<Character> stack = new ArrayDeque<>();
            for (int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if (c == '(' || c == '{' || c== '['){
                    stack.push(c);
                }
                else{
                    if (stack.isEmpty()) return false;
                    char d = stack.remove();
                    if ((c == ')' && d != '(') || (c == '}' && d != '{') || (c == ']' && d != '[')) return false;
                }
            }

            return stack.isEmpty();
        }
    }
}
