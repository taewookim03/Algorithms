package CTCI.p16moderate;

import java.util.Arrays;

class p16_6_smallest_difference {
    static int minDiff(int[] a, int[] b){
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0;
        int j = 0;
        int minDelta = Integer.MAX_VALUE;
        while (i < a.length && j < b.length){
            int delta = Math.abs(a[i] - b[j]);
            if (delta < minDelta){
                minDelta = delta;
            }
            if(a[i] > b[j]){
                j++;
            }
            else{
                i++;
            }
        }
        return minDelta;
    }
    public static void main(String[] args){
        int[] a = new int[]{1, 3, 15, 11, 2};
        int[] b = new int[]{23, 127, 235, 19, 8};
        System.out.println(minDiff(a, b));
    }
}
