//class DutchFlagBetter {
//    static void swap(int[] arr, int i, int j){
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }
//
//    static void sort012(int[] arr){
//        int n = arr.length;
//
//        int low = 0;
//        int mid = 0;
//        int high = n - 1;
//
//        while (mid <= high){
//            switch(arr[mid]){
//                case 0:
//                    swap(arr, low, mid);
//                    low++;
//                    mid++;
//                    break;
//                case 1:
//                    mid++;
//                    break;
//                case 2:
//                    swap(arr, mid, high);
//                    high--;
//                    break;
//            }
//        }
//
//    }
//
//    static void print(int[] arr){
//        for (int i : arr){
//            System.out.print(i);
//        }
//        System.out.println();
//    }
//
//    public static void main(String[] args){
//        int[] arr = new int[]{0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
//        print(arr);
//        sort012(arr);
//        print(arr);
//    }
//}
