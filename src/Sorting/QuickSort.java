package Sorting;

//O(n^2) worst, O(nlogn) avg, in place (O(1) Space)
//random pivot for improvement
class QuickSort {
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void qsort(int[] arr, int start, int end){
        //1 element - sorted
        if (end - start <= 1) return;

        int pivot = partition(arr, start, end);//returns pivot which is in its correct final position
        qsort(arr, start, pivot);//sort left of pivot
        qsort(arr, pivot+1, end);//sort right of pivot
    }

    static int partition(int[] arr, int start, int end){
        //use the last element as the pivot
        int pivot_value = arr[end - 1];
        int divider = start;

        for (int i = start; i < end - 1; i++){
            if (arr[i] < pivot_value){
                swap(arr, divider, i);
                divider++;
            }
        }

        swap(arr, divider, end - 1);
        return divider;
    }

    static void print(int[] arr){
        for (int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] arr = new int[]{9, 1, 5, 7, 8, 2, 6, 3, 4};
        print(arr);
        qsort(arr, 0, arr.length);
        print(arr);
    }
}
