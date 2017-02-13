package leetcode;
import java.util.*;

/**
 * Created by Taewoo Kim on 2/11/2017.
 */
public class remove_k_digits {
    public class Solution {
        public String removeKdigits(String num, int k) {
            if (k == 0) return num;
            int n = num.length();
            if (k >= n) return "0";

            Deque<Character> stack = new ArrayDeque<>();
            for (int i = 0; i < n; i++){
                char digit = num.charAt(i);
                while (!stack.isEmpty() && digit < stack.getLast() && k > 0){
                    stack.removeLast();
                    k--;
                }
                stack.addLast(digit);
            }
            while (k > 0){
                k--;
                stack.removeLast();
            }

            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty() && stack.peek() == '0'){
                stack.removeFirst();
            }
            while (!stack.isEmpty()){
                sb.append(stack.removeFirst());
            }

            return sb.length() == 0 ? "0" : sb.toString();
        }
    }
}
