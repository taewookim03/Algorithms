package Sorting;

class RadixSort {
    static int max(int[] arr){
        if (arr.length < 1) return -1;
        int m = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (arr[i] > m) m = arr[i];
        }
        return m;
    }

    static void RadixSort(int[] arr){
        int max = max(arr);

        for (int exp = 1; max/exp > 0; exp *= 10){
            countingSort(arr, exp);
        }
    }

    static void countingSort(int[] arr, int m){
        int[] output = new int[arr.length];
        int[] freq = new int[10];

        //count the number of each element at specified digit
        for (int num : arr){
            freq[(num/m)%10]++;
        }
        //convert frequency to cumulative
        for (int i = 1; i < freq.length; i++){
            freq[i] += freq[i - 1];
        }

        //place elements according to digit sorted order into the output, decreasing count
        //-------------------------------------------------EASY MISTAKE BELOW--------------------------------------------
        //for(int i = 0; i < arr.length; i++){
        //-------------------------------------------------EASY MISTAKE ABOVE--------------------------------------------
        for (int i = arr.length - 1; i >= 0; i--){
            int digit = (arr[i]/m)%10;
            output[freq[digit] - 1] = arr[i];
            --freq[digit];
        }

        //copy to original array
        for (int i = 0; i < arr.length; i++){
            arr[i] = output[i];
        }
    }

    static void print(int[] arr){
        for (int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] arr = new int[]{170, 45, 75, 90, 802, 24, 2, 66};
        print(arr);
        RadixSort(arr);
        print(arr);
    }
}
