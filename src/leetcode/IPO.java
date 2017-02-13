package leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources, it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.

 You are given several projects. For each project i, it has a pure profit Pi and a minimum capital of Ci is needed to start the corresponding project. Initially, you have W capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.

 To sum up, pick a list of at most k distinct projects from given projects to maximize your final capital, and output your final maximized capital.

 Example 1:
 Input: k=2, W=0, Profits=[1,2,3], Capital=[0,1,1].

 Output: 4

 Explanation: Since your initial capital is 0, you can only start the project indexed 0.
 After finishing it you will obtain profit 1 and your capital becomes 1.
 With capital 1, you can either start the project indexed 1 or the project indexed 2.
 Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
 Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.
 Note:
 You may assume all numbers in the input are non-negative integers.
 The length of Profits array and Capital array will not exceed 50,000.
 The answer is guaranteed to fit in a 32-bit signed integer.
 */
public class IPO {
    //using 2 priority queues (GREEDY)
    //look at every possible project (Ci <= W) and pick the one with the largest profit Pi. Repeat with new capital W, k times
    public class Solution {
        public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
            int n = Profits.length;

            //array [profit, capital];
            Queue<int[]> maxProfitQueue = new PriorityQueue<>((a,b)->b[0] - a[0]);
            Queue<int[]> minCapitalQueue = new PriorityQueue<>((a,b)->a[1] - b[1]);

            for (int i = 0; i < n; i++){
                minCapitalQueue.add(new int[]{Profits[i], Capital[i]});
            }

            for (int i = 0; i < k; i++){
                while (!minCapitalQueue.isEmpty() && minCapitalQueue.peek()[1] <= W){
                    maxProfitQueue.add(minCapitalQueue.remove());
                }

                if (maxProfitQueue.isEmpty()) break;

                W += maxProfitQueue.remove()[0];
            }

            return W;
        }
    }

    //my attempt (dp) didnt work -  did not read problem carefully (much simpler than my misinterpretation)
    public class Solution2 {
        public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
            int n = Profits.length;//number of projects available

            int maxW = 0;
            for (int Profit : Profits){
                if (Profit > maxW) maxW = Profit;
            }
            maxW += W;
            int[][][] m = new int[n+1][maxW+1][k+1];

            for (int i = n; i >= 0; i--){
                for (int j = 0; j <= maxW; j++){
                    for (int p = 0; p <= k; p++){
                        if (p == 0 || i == n) {
                            m[i][j][p] = W;
                            continue;
                        }
                        if (j >= Capital[i]){
                            m[i][j][p] = Math.max(m[i+1][j][p], Profits[i] - Capital[i] + m[i+1][j+Profits[i]-Capital[i]][p-1]);
                        }
                        else{
                            m[i][j][p] = m[i+1][j][p];//can't do this project
                        }
                    }
                }
            }
            return m[n-1][W][k];
        }
    }
}
