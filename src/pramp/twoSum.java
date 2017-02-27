package pramp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Taewoo Kim on 2/16/2017.
 * Merging 2 Packages

 Given a package with a weight limit and an array arr of item weights, how can you most efficiently find two items with sum of weights that equals the weight limit?

 Your function should return 2 such indices of item weights or -1 if such pair doesn't exist.
 What is the runtime and space complexity of your solution?

 Hints & Tips
 As in any array iteration, check for proper indices limit and for covering all elements within the array.

 If your peer can't come up with a solution, ask for the brute force solution and then ask how can you do better. Another clue is to ask your peer to use the information you"ve found during a single iteration.

 If the programming language you use has no hash table data structure implementation, allow your peer to assume the existence of such implantation (as used in the solution).

 Watch out for hashing the item weight before searching the hash table for its complement.
 For a weight w1 that equals limit/2 (its complement is also limit/2), hashing the weight before searching the complement can detect a couple even when only one item with weight w1 exists...

 Solution
 The brute force solution is looping over the array and then for each weight looping on all other weights while comparing the sum of each pair to the weight limit.
 It takes O(n2) runtime complexity and involves checking every pair twice.

 This is a classic case to use a hash table.
 We iterate over arr only once. For each weight w in arr we compute its complement limit - w and check if that complement was hashed so far. If we find the complement in the hash table we return both indices, if not we hash w while using the weight as the hash key and the array index as the hash value (even if the same weight is found more than once it doesn't matter because at the time of the lookup we only need one product with that weight).

 function findComplementingWeights(arr, limit):
 h = new hashTable()
 for (index, w) in arr:
 complementIndex = h.findKey(limit - w)
 if (complementIndex != null):
 return [index, complementIndex]
 else:
 h.insert(w, index)
 return -1
 Runtime Complexity: Going over the array only once, performing constant time work for each weight and assuming we have a good hash function with rare collisions, we get a linear O(n) (where n in the length of the weights array).

 Space Complexity: O(m) (where m in the number of the unique weights in array).
 */
public class twoSum {
    static void findPairSorted(int[] array, int sum){
        int i = 0;
        int j = array.length - 1;
        while(i < j){
            
        }
    }
    static int[] findPairSum(int[] array, int sum){
        Map<Integer,Integer> numIndex = new HashMap<>();
        for (int i = 0; i < array.length; i++){
            if (numIndex.get(sum - array[i]) != null) {
                return new int[]{i, numIndex.get(sum - array[i])};
            }
            numIndex.put(array[i], i);
        }
        return new int[]{-1};
    }
    public static void main(String[] args){
        int sum = 8;
        int[] a1 = new int[]{1, 3, 4, 8};//ans: -1
        int[] a2 = new int[]{1, 2, 5, 3};//ans: 2, 3
        findPairSum(a1, sum);
        findPairSum(a2, sum);
    }
}
