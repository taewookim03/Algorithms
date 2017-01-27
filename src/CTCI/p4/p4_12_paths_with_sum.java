package CTCI.p4;

import java.util.HashMap;
import java.util.Map;

class p4_12_paths_with_sum {
    public static class Node{
        int val;
        Node left, right;
        Node(int val){
            this.val = val;
        }
    }

    static int countSumPaths(Node node, int k){
        return countSum(node, k);
    }
    static int countSum(Node node, int k){
        if (node == null) return 0;
        int count = 0;

        count += countSum(node.left, k);
        count += countSum(node.right, k);
        count += countSumWithCarry(node, 0, k);//repeat the recursive path counting function for every node
        return count;
    }
    //this function finds the number of paths STARTING FROM HERE that sums to k
    static int countSumWithCarry(Node node, int currSum, int k){
        if (node == null) return 0;
        int count = 0;
        if (currSum + node.val == k) count++;
        count += countSumWithCarry(node.left, currSum + node.val, k);
        count += countSumWithCarry(node.right, currSum + node.val, k);
        return count;
    }


    //optimized O(n) algorithm using hash table to store frequencies of previous running sums
    //and searching for count of (current sum - target sum)
    static int countSumPathsOpt(Node node, int k){
        Map<Integer, Integer> sumFreq = new HashMap<>();
        sumFreq.put(0, 1);//starting at root
        return countSumOpt(node, 0, k, sumFreq);
    }
    static int countSumOpt(Node node, int runningSum, int targetSum, Map<Integer,Integer> sumFreq){
        if (node == null) return 0;
        runningSum += node.val;
        int pathCount = sumFreq.getOrDefault(runningSum - targetSum, 0);
        //runningSum - (runningSum-targetSum) = targetSum so paths found

        //increment frequency of current running sum then backtarck because only parents are considered potential path starts
        sumFreq.put(runningSum, (sumFreq.getOrDefault(runningSum, 0)+1));
        pathCount += countSumOpt(node.left, runningSum, targetSum, sumFreq);
        pathCount += countSumOpt(node.right, runningSum, targetSum, sumFreq);
        sumFreq.put(runningSum, sumFreq.get(runningSum) - 1);
        if (sumFreq.get(runningSum) == 0) sumFreq.remove(runningSum);
        return pathCount;
    }

    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.left.right.left = new Node(9);
        root.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.right.right = new Node(-1);

        System.out.println(countSumPaths(root, 6));
        System.out.println(countSumPathsOpt(root, 6));
    }
}
