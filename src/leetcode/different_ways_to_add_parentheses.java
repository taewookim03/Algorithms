package leetcode;
import java.util.*;
/**
 * Created by Taewoo Kim on 3/31/2017.
 */
public class different_ways_to_add_parentheses {
    public class Solution {
        public List<Integer> diffWaysToCompute(String input) {
            List<Integer> result = new ArrayList<>();
            for (int i = 1; i < input.length(); i++){
                char c = input.charAt(i);
                char p = input.charAt(i-1);
                if ((c == '+' || c == '-' || c == '*') && p != '+' && p != '-' && p != '*'){
                    List<Integer> left = diffWaysToCompute(input.substring(0, i));
                    List<Integer> right = diffWaysToCompute(input.substring(i+1));
                    for(int s : left){
                        for (int t : right){
                            int r = 0;
                            switch(c){
                                case '+':
                                    r = s+t;
                                    break;
                                case '-':
                                    r = s-t;
                                    break;
                                case '*':
                                    r = s*t;
                                    break;
                            }
                            result.add(r);
                        }
                    }
                }
            }

            if (result.isEmpty()){
                result.add(Integer.parseInt(input));
            }
            return result;
        }
    }
}
