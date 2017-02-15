package hackerrank;

/**
 * Created by Taewoo Kim on 2/14/2017.
 */
public class lena_sort {
    /*
    tried
    import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static int[] lena(int len, int c){
        int min = minC(len);
        int max = maxC(len);
        if (c < min || c > max) return new int[]{-1};

        int[] a = new int[len];
        List<Integer> res = new ArrayList<>();

        lenaUtil(len, c, 1, len, res);
        for (Integer i : res){
            System.out.println(i);
        }

        return a;
    }
    static void lenaUtil(int len, int c, int left, int right, List<Integer> picked){
        if (left > right) return;//0
        if (left == right){//1
            picked.add(left);
            return;
        }

        int cmp = len - 1;//comparison made in this run
        //pick pivot as long as it can make c
        for (int i = left; i <= right; i++){
            int l = i - left;
            int r = right - i - 1;
            int minCmp = minC(l) + minC(r);//minimum comparisons that can be made by children
            int maxCmp = maxC(l) + maxC(r);

            if (minCmp <= c - cmp && c - cmp <= maxCmp){
                //partition possible so pick this pivot (i) which is ith smallest number in sorted array
                picked.add(i);
                //let left make min number of cmp allowed and right make c-cmp-leftMin
                lenaUtil(len, c-cmp, left, i-1, picked);
                lenaUtil(len, c-cmp, i+1, right, picked);
                break;
            }
        }

    }
    static int minC(int len){
        if (len < 2) return 0;
        if (len == 2) return 1;
        return (len-2) * 2;
    }
    static int maxC(int len){
        if (len < 2) return 0;
        return (len * (len-1) / 2);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int len = in.nextInt();
            int c = in.nextInt();
            int[] ans = lena(len, c);
            for (int i : ans){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

     */
}
