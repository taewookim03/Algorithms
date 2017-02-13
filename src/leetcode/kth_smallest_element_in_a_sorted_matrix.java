package leetcode;
import java.util.*;
/**
 * Created by Taewoo Kim on 2/13/2017.
 */
public class kth_smallest_element_in_a_sorted_matrix {
    public class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            Queue<MatrixElement> minHeap = new PriorityQueue<>();
            for (int j = 0; j < matrix[0].length; j++){
                minHeap.add(new MatrixElement(0, j, matrix[0][j]));
            }

            for (int p = 0; p < k - 1; p++){
                MatrixElement e = minHeap.remove();
                if (e.i < matrix.length - 1){
                    minHeap.add(new MatrixElement(e.i+1, e.j, matrix[e.i+1][e.j]));
                }
            }
            return minHeap.remove().val;
        }

        public class MatrixElement implements Comparable<MatrixElement>{
            int i, j, val;
            MatrixElement(int i, int j, int val){
                this.i = i;
                this.j = j;
                this.val = val;
            }

            @Override
            public int compareTo(MatrixElement other){
                return this.val - other.val;
            }
        }
    }
}
