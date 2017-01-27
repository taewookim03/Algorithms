package CTCI.p10;


import java.util.Arrays;

class p10_11_peaks_and_valleys {
    static int[] peakValley2(int[] arr){
        //O(n)
        int n = arr.length;
        if (n <= 1) return arr;

        //compare every 2 elements with adj and swap with the largest (make peaks)
        for (int i = 1; i < n; i += 2){
            int largestIndex = maxIndex(arr, i-1, i, i+1);
            int temp = arr[largestIndex];
            arr[largestIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
    static int maxIndex(int[] arr, int i, int j, int k){
        int a = (i >= 0 && i < arr.length) ? arr[i] : Integer.MIN_VALUE;
        int b = (j >= 0 && j < arr.length) ? arr[j] : Integer.MIN_VALUE;
        int c = (k >= 0 && k < arr.length) ? arr[k] : Integer.MIN_VALUE;

        if (a > b){
            if (a > c) return i;
            else return k;
        }
        else{
            if (b > c) return j;
            else return k;
        }
    }


    static int[] peakValley(int[] arr){
        //O(nlogn) sorting
        int n = arr.length;
        Arrays.sort(arr);

        int n1 = n % 2 == 0 ? n/2 : n/2+1;

        int[] output = new int[n];

        int i = 0;//start of n1
        int j = n1;//start of n2
        int k = 0;//start of output
        while (k < n){
            output[k++] = arr[i++];
            if (j < n){
                output[k++] = arr[j++];
            }
        }
        return output;
    }
    public static void main(String[] args){
        int[] arr = new int[]{5, 3, 1, 2, 3};
        //int[] pv = peakValley(arr);
        int[] pv = peakValley2(arr);
        for (int i : pv){
            System.out.print(i + " ");
        }
        System.out.println();//e.g. 5 1 3 2 3
    }
}
