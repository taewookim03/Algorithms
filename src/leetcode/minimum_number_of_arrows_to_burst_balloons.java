package leetcode;
import java.util.*;
/**
 * Created by Taewoo Kim on 2/14/2017.
 */
public class minimum_number_of_arrows_to_burst_balloons {
    public class Solution {
        public int findMinArrowShots(int[][] points) {
            Queue<int[]> leftMinHeap = new PriorityQueue<>((a,b)->a[0] - b[0]);
            for (int i = 0; i < points.length; i++){
                leftMinHeap.add(points[i]);
            }

            int shoot = 0;

            while (!leftMinHeap.isEmpty()){
                int right = leftMinHeap.peek()[1];
                while (!leftMinHeap.isEmpty() && leftMinHeap.peek()[0] <= right){
                    int[] p = leftMinHeap.remove();
                    right = Math.min(right, p[1]);
                }
                shoot++;
            }

            return shoot;
        }
    }
}
