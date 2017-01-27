//class DutchFlagPartitionColors {
//    static void swap(char[] arr, int i, int j){
//        char temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }
//
//    static void sortThreeColors(char[] arr){
//        if (arr.length <= 1) return;
//
//        int p = partition(arr, 'b', 0, arr.length);
//        partition(arr, 'w', 0, p);
//    }
//
//    static int partition(char[] arr, char pivot, int start, int end){
//        if (end - start <= 1) return start;
//        //partition non-pivot char to left and pivot to right
//        int divider = start;
//        for (int i = start; i < end; i++){
//            if (arr[i] != pivot){
//                swap(arr, divider, i);
//                divider++;
//            }
//        }
//        return divider;
//    }
//
//    static void print(char[] arr){
//        for (char c : arr){
//            System.out.print(c);
//        }
//        System.out.println();
//    }
//
//    public static void main(String[] args){
//        char[] arr = new char[]{'r', 'r', 'w', 'b', 'r', 'b', 'w', 'w', 'b', 'r', 'b', 'b', 'r', 'w'};
//        //O(n) algorithm to sort into red white and blue
//        print(arr);
//        sortThreeColors(arr);
//        print(arr);
//    }
//}
