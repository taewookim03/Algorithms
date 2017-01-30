package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Taewoo Kim on 1/29/2017.
 */
public class sort_characters_by_frequency {
    //bucket sort seems to be fastest (O(n)), but could be a lot of space if there is a highly repeated element
    public class Solution {
        public String frequencySort(String s) {
            Map<Character, Integer> freqMap = new HashMap<>();
            int maxFreq = 0;
            for (int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
                maxFreq = Math.max(maxFreq, freqMap.get(c));
            }

            //sort characters by frequency
            List<Character>[] buckets = new List[maxFreq+1];
            for (Character c : freqMap.keySet()){
                int freq = freqMap.get(c);
                if (buckets[freq] == null){
                    buckets[freq] = new ArrayList<>();
                }
                buckets[freq].add(c);
            }

            StringBuilder sb = new StringBuilder();
            for (int i = buckets.length - 1; i > 0; i--){
                if (buckets[i] != null){
                    for (Character c : buckets[i]){
                        for (int count = 0; count < i; count++){
                            sb.append(c);
                        }
                    }
                }

            }

            return sb.toString();
        }
    }

    //slightly faster solution with pq
    public class Solution2 {
        public String frequencySort(String s) {
            Map<Character, Integer> freqMap = new HashMap<>();
            for (int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            }

            Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a,b)->b.getValue() - a.getValue());
            maxHeap.addAll(freqMap.entrySet());

            StringBuilder sb = new StringBuilder();
            while (!maxHeap.isEmpty()){
                Map.Entry<Character, Integer> entry = maxHeap.remove();
                for (int i = 0; i < entry.getValue(); i++){
                    sb.append(entry.getKey());
                }
            }
            return sb.toString();
        }
    }


    //ugly and slow but short and kinda cool (lambdas!) solution
    public class Solution3 {
        public String frequencySort(String s) {
            Map<Character, Integer> freqMap = new HashMap<>();
            for (char c : s.toCharArray()){
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            }
            List<Character> sorted = new ArrayList<>(freqMap.keySet());
            Collections.sort(sorted, (a,b)->freqMap.get(b)-freqMap.get(a));
            return sorted.stream().map(e->new String(new char[freqMap.get(e)]).replace("\0",e.toString())).collect(Collectors.joining());
        }
    }
}
