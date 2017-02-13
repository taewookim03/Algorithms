package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Taewoo Kim on 2/4/2017.
 *
 Given scores of N athletes, find their relative ranks and the men with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

 Example 1:
 Input: [5, 4, 3, 2, 1]
 Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
 For the left two athletes, you just need to output their relative ranks according to their scores.
 Note:
 N is a positive integer and won't exceed 10,000.
 All the sores of athletes are ensure to be unique.
 *
 */
public class relative_ranks {
    public class Solution {
        public String[] findRelativeRanks(int[] nums) {
            if (nums.length == 0) return new String[]{};
            //[score, index]
            Queue<int[]> pq = new PriorityQueue<>((a, b)->b[0] - a[0]);
            for (int i = 0; i < nums.length; i++){
                pq.add(new int[]{nums[i],i});
            }

            String[] res = new String[nums.length];
            int count = 1;
            while (!pq.isEmpty()){
                int[] e = pq.remove();
                if (count == 1){
                    res[e[1]] = "Gold Medal";
                }
                else if (count == 2){
                    res[e[1]] = "Silver Medal";
                }
                else if (count == 3){
                    res[e[1]] = "Bronze Medal";
                }
                else{
                    res[e[1]] = String.valueOf(count);
                }
                count++;
            }
            return res;
        }
    }
}
