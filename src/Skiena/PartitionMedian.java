//import java.util.Random;
//
////TADM 4-1
//class PartitionMedian {
//    static void swap(int[] arr, int i, int j){
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }
//
//    static Random random = new Random();
//
//    //finds kth element (0-index)
//    static void find_kth(int[] arr, int k, int start, int end){//[start .. end)
//        int pivot_index = random.nextInt(end - start) + start;//[0 .. n-1]
//        int p = partition(arr, pivot_index);
//
//        if (p == k) return;//array is partitioned around kth smallest element (0-index)
//        else if (p > k) find_kth(arr, k, start, p);//median is in the left of the partition
//        else find_kth(arr, k, p + 1, end);//median in the right
//    }
//    static int partition(int[] arr, int pivot_index){
//        int pivot = arr[pivot_index];
//        swap(arr, pivot_index, arr.length - 1);//pivot at last place
//        int divider = 0;
//
//        for (int i = 0; i < arr.length - 1; i++){
//            if (arr[i] < pivot){
//                swap(arr, divider, i);
//                divider++;
//            }
//        }
//        swap(arr, divider, arr.length - 1);
//
//        return divider;
//    }
//    static void print(int[] arr){
//        for (int i : arr){
//            System.out.print(i + " ");
//        }
//        System.out.println();
//    }
//
//    public static void main(String[] args){
//
//        //int[] arr = new int[]{8, 4, 5, 2, 1, 3, 7, 6};
//        int[] arr = new int[]{4, 3};
//        print(arr);
//
//        find_kth(arr, arr.length/2, 0, arr.length);
//        print(arr);
//    }
//}