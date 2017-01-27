package CTCI;

class sorts {
    static void sort(int[] arr){
        //mergeSort(arr, new int[arr.length], 0, arr.length-1);
        //quickSort(arr, 0, arr.length-1);
        radixSort(arr);
    }
    static void mergeSort(int[] arr, int[] helper, int lo, int hi){
        if (lo >= hi) return;

        int mid = (lo + hi)/2;
        mergeSort(arr, helper, lo, mid);
        mergeSort(arr, helper, mid+1, hi);
        merge(arr, helper, lo, mid, hi);
    }
    static void merge(int[] arr, int[] helper, int lo, int mid, int hi){
        int i = lo;
        int j = mid + 1;
        int k = lo;//helper location

        while (i <= mid && j <= hi){
            if (arr[i] <= arr[j]){
                helper[k++] = arr[i++];
            }
            else{
                helper[k++] = arr[j++];
            }
        }
        while (i <= mid){
            helper[k++] = arr[i++];
        }
        //copy to original array
        for (int z = lo; z < k; z++){
            arr[z] = helper[z];
        }
    }


    static void quickSort(int[] arr, int lo, int hi){
        if (lo >= hi) return;//0 or 1 element

        int p = partition(arr, lo, hi);
        quickSort(arr, lo, p);
        quickSort(arr, p+1, hi);
    }
    static int partition(int[] arr, int lo, int hi){
        //hoare's partition
        int pivot = arr[lo];
        int i = lo - 1;
        int j = hi + 1;

        while (true){
            do i++; while (arr[i] < pivot);
            do j--; while (arr[j] > pivot);

            if (i >= j) return j;
            else{
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }


    static void radixSort(int[] arr){
        if (arr.length <= 1) return;
        int max = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (arr[i] > max) max = arr[i];
        }

        for (int m = 1; max/m > 0; m *= 10){
            countingSort(arr, m);
        }
    }
    static void countingSort(int[] arr, int m){
        int[] freq = new int[10];
        //get freq of the digits
        for (int i = 0; i < arr.length; i++){
            freq[(arr[i]/m) % 10]++;
        }
        //convert to cumulative freq
        for (int i = 1; i < freq.length; i++){
            freq[i] += freq[i-1];
        }

        //sort to output
        int[] output = new int[arr.length];
        for (int i = arr.length-1; i >= 0; i--){
            int d = (arr[i]/m) % 10;
            freq[d]--;
            output[freq[d]] = arr[i];

        }

        //copy back to arr
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
        sort(arr);
        print(arr);
    }
}
