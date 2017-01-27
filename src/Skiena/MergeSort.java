//import java.util.Arrays;
//
////mergesort - stable, O(nlogn) time, O(n) space complexity with arrays or O(logn) with linked list (only recursion stack memory)
//class MergeSort {
//    static int values[];
//    static int temp[];
//
//    static void sort(int arr[]){
//        values = arr;
//        temp = new int[arr.length];
//        mergeSort(0, arr.length);
//    }
//
//    static void mergeSort(int start, int end){
//        //base case
//        if (end - start <= 1) return;
//
//        int mid = start + (end - start)/2;
//        mergeSort(start, mid);
//        mergeSort(mid, end);
//        merge(start, mid, end);
//    }
//
//    static void merge(int start, int mid, int end){
//        int i = start;//left index
//        int j = mid;//right index
//        int k = start;//write-to index
//
//        while (i < mid && j < end){
//            if (values[i] < values[j]){
//                temp[k++] = values[i++];
//            }
//            else{
//                temp[k++] = values[j++];
//            }
//        }
//
//        while (i < mid){
//            temp[k++] = values[i++];
//        }
//
//        //copy to original array
//        for (int c = start; c < k; c++){
//            values[c] = temp[c];
//        }
//    }
//
//    static void print(int[] arr){
//        for (int i : arr){
//            System.out.print(i + " ");
//        }
//        System.out.println();
//    }
//
//    public static void main(String[] args){
//        int[] arr = new int[]{9, 1, 5, 7, 8, 2, 6, 3, 4};
//        print(arr);
//        sort(arr);
//        print(arr);
//    }
//}
