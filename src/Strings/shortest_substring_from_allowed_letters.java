package Strings;

import java.util.*;

/**
 * Created by Taewoo Kim on 4/3/2017.
 * http://ruslanledesma.com/2017/04/01/shortest-substring-made-of-allowed-letters.html
 *
 */
public class shortest_substring_from_allowed_letters {
    public static String shortestAllowed(String str, String allowed){
        Set<Character> allowedSet = new HashSet<>();
        for (int i = 0; i < allowed.length(); i++){
            allowedSet.add(allowed.charAt(i));
        }

        Map<Character, Integer> charIndexMap = new HashMap<>();//character to index
        int minLength = str.length() + 1;
        String shortest = "";
        for (int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if (!allowedSet.contains(c)) {
                charIndexMap.clear();
                continue;
            }
            charIndexMap.put(c, i);
            if (charIndexMap.size() == allowedSet.size()){
                int left = Collections.min(charIndexMap.values());
                int right = Collections.max(charIndexMap.values());
                int length = right - left + 1;
                if (length < minLength){
                    minLength = length;
                    shortest = str.substring(left, right+1);
                }
            }
        }
        return shortest;
    }

    public static void main(String[] args){
        System.out.println(shortestAllowed("xaabbca","abc"));
        System.out.println(shortestAllowed("aabxbcbaaccb","abc"));
        System.out.println(shortestAllowed("aabbccbbabbcaabcbc","abc"));
        System.out.println(shortestAllowed("axbc","abc"));
        System.out.println(shortestAllowed("abc","abc"));
        /*
        xaabbca
        abc
        -> bca

        aabxbcbaaccb
        abc
        -> cba

        aabbccbbabbcaabcbc
        abc
        -> bca

        axbc
        abc
        -> ""
         */
    }
}
