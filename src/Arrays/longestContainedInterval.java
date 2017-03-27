package Arrays;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.


 1 2 3 4 5
 1 2 5 4 3

 1 2   3 4
 1 2   4 3

 */


/*

Find the length of the longest contained interval.
example if input is
{3,-2,7,9,8,1,2,0,-1,5,8}
 the largest such subset is [-2,-1,0,1,2,3]
{10,5,3,11,6,100,4}
answer is {3,4,5,6}

{3, -2} -> 1
{} -> 0
{4} -> 1

{ 3 1 4 2}

maxLen
hashmap (3,1,4,2, 8, 6)

3 -> 2, 4  len = 2
1, 5 stop

0, 6

8 -> 7, 9

6 -> 5, 7

1 -> 0, 2
4 -> 5
2 ->

*/





class Solution {
    public static int lci(int[] arr){
        Set<Integer> set = new HashSet<>();
        for (int i : arr){
            set.add(i);
        }

        int maxLen = 0;
        int len = 0;

        for (int i : arr){
            if (set.contains(i)){
                len = 1;
                int offset = 1;
                while(true){
                    if (!set.contains(i-offset) && !set.contains(i+offset)) break;
                    if (set.contains(i-offset)) {
                        len++;
                        set.remove(i-offset);
                    }
                    if (set.contains(i+offset)) {
                        len++;
                        set.remove(i+offset);
                    }
                    offset++;
                }
                set.remove(i);
                maxLen = Math.max(maxLen, len);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lci(new int[]{10,5,3,11,6,100,4}));
    }
}
