package leetcode;
import java.util.*;

/**
 * Created by Taewoo Kim on 2/2/2017.
 */
public class anagrams {
    public class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            //hashmap of sorted string key -> list of keys
            Map<String, List<String>> sortedMap = new HashMap<>();
            for (String str : strs){
                String sorted = sort(str);
                if (!sortedMap.containsKey(sorted)){
                    sortedMap.put(sorted, new ArrayList<>());
                }
                sortedMap.get(sorted).add(str);
            }


            List<List<String>> result = new ArrayList<>();
            for (Map.Entry<String, List<String>> entry : sortedMap.entrySet()){
                result.add(entry.getValue());
            }
            return result;
        }

        String sort(String s){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            return String.valueOf(arr);
        }
    }
}
