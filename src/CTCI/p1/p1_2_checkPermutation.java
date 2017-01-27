package CTCI.p1;

import java.util.HashMap;
import java.util.Map;

class p1_2_checkPermutation {
    static boolean checkPerm(String s1, String s2){
        if (s1.length() != s2.length()) return false;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++){
            char c = s1.charAt(i);
            if (map.containsKey(c)) map.put(c, map.get(c) + 1);
            else map.put(c, 1);
        }

        for (int i = 0; i < s2.length(); i++){
            char c = s2.charAt(i);
            if (!map.containsKey(c)) return false;
            map.put(c, map.get(c) - 1);
        }

        for (Integer count : map.values()){
            if (count != 0) return false;
        }

        return true;
    }

    public static void main(String[] args){
        System.out.println(checkPerm("abcda", "bdaca"));
    }
}
