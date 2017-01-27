package CTCI.p10;

import java.util.*;


class p10_2_group_anagrams {
    //using hashtable - O(n*mlogm) or O(nm) if string sorting is done with counting sort O(m)
    static void groupAnagrams(String[] strings){
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String s : strings){
            String sorted = sortString(s);
            if (!anagramMap.containsKey(sorted)){
                anagramMap.put(sorted, new ArrayList<>());
            }
            anagramMap.get(sorted).add(s);
        }

        int i = 0;
        for (String key : anagramMap.keySet()){
            List<String> list = anagramMap.get(key);
            for (String s : list){
                strings[i++] = s;
            }
        }
    }

    static String sortString(String str){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }
    public static void main(String[] args){
        String[] strings = new String[]{"cat","dog","tac","god","act","gdo","good","car","asdf","doog","dood"};
        groupAnagrams(strings);
        for (String s : strings){
            System.out.print(s + " ");
        }
    }
}
