package leetcode;
import java.util.*;
/**
 * Created by Taewoo Kim on 1/30/2017.
 */
public class top_k_frequent_elements {
    //bucket sort O(n)
    public class Solution {
        public List<Integer> topKFrequent(int[] nums, int k) {
            //bucket sort O(n)
            //process numberse into a frequency map
            Map<Integer,Integer> freqMap = new HashMap<>();
            for (int n : nums){
                freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
            }

            List<Integer>[] buckets = new List[nums.length + 1];
            for (Map.Entry<Integer,Integer> entry : freqMap.entrySet()){
                int freq = entry.getValue();
                int num = entry.getKey();
                if (buckets[freq] == null){
                    buckets[freq] = new ArrayList<>();
                }
                buckets[freq].add(num);
            }

            List<Integer> result = new ArrayList<>();
            for (int i = buckets.length - 1; i >= 0; i--){
                if (buckets[i] != null){
                    for (int j = 0; j < buckets[i].size() && result.size() < k; j++){
                        result.add(buckets[i].get(j));
                    }
                }
            }
            return result;
        }
    }

    //standard map+heap solution (O(klogn))
    public class Solution2 {
        public List<Integer> topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> freqMap = new HashMap<>();
            for (int n : nums){
                freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
            }

            Queue<Map.Entry<Integer,Integer>> freqMaxHeap = new PriorityQueue<>((a,b)-> b.getValue() - a.getValue());
            freqMaxHeap.addAll(freqMap.entrySet());

            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < k; i++){
                result.add(freqMaxHeap.remove().getKey());
            }

            return result;
        }
    }
}
