package leetcode;

import java.util.List;

/**
 * Created by Taewoo Kim on 2/27/2017.
 * Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

 Example 1:
 Input:
 s = "abpcplea", d = ["ale","apple","monkey","plea"]

 Output:
 "apple"
 Example 2:
 Input:
 s = "abpcplea", d = ["a","b","c"]

 Output:
 "a"
 Note:
 All the strings in the input will only contain lower-case letters.
 The size of the dictionary won't exceed 1,000.
 The length of all the strings in the input won't exceed 1,000.
 */
public class longest_word_in_dictionary_through_deleting {
    public class Solution {
        public String findLongestWord(String s, List<String> d) {
            String res = "";
            for (String st : d){
                if (canMake(st, s) && better(st, res)){
                    res = st;
                }
            }
            return res;
        }

        boolean canMake(String sub, String s){
            int i = 0;//s
            int j = 0;//sub
            int n = s.length();
            int m = sub.length();


            while (i < n && j < m){
                if (sub.charAt(j) == s.charAt(i)){
                    i++;
                    j++;
                }
                else{
                    i++;
                }
            }

            return j == m;
        }

        boolean better(String a, String b){
            int n = a.length();
            int m = b.length();
            if (n > m) return true;

            if (n == m && a.compareTo(b) < 0) return true;

            return false;
        }
    }
}
