//class QuickSortHoare {
//    static void quicksort(int[] arr){
//        qsort(arr, 0, arr.length-1);
//    }
//
//    static void qsort(int[] arr, int low, int high){
//        if (high <= low) return;
//
//        int p = partition(arr, low, high);
//        qsort(arr, low, p);
//        qsort(arr, p+1, high);
//    }
//
//    static int partition(int[] arr, int left, int right){
//        int pivot = arr[left];
//        int i = left - 1;
//        int j = right + 1;
//
//        while (true){
//            do i++; while (arr[i] < pivot);
//            do j--; while (arr[j] > pivot);
//
//            if (j <= i) return j;
//            else{
//                swap (arr, i , j);
//            }
//        }
//    }
//
//    static void swap(int[] arr, int i, int j){
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }
//
//    public static void main(String[] args){
//        int[] arr = new int[]{0, -1, 4, 2, 3, 2, 2, 6, 4, 8, 2, 1, 2, 2, 6, 5};
//        quicksort(arr);
//        for (int i : arr){
//            System.out.print(i + " ");
//        }
//    }
//}
